/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.pushingpixels.ephemeral.chroma.dynamiccolor;

import org.pushingpixels.ephemeral.chroma.contrast.Contrast;
import org.pushingpixels.ephemeral.chroma.hct.Hct;
import org.pushingpixels.ephemeral.chroma.palettes.TonalPalette;
import org.pushingpixels.ephemeral.chroma.utils.MathUtils;

import java.util.HashMap;
import java.util.function.Function;

// This is a modified version of the original source code, changed to fit the Chroma needs

/**
 * A color that adjusts itself based on UI state, represented by DuotonePalette.
 *
 * <p>This color automatically adjusts to accommodate a desired contrast level, or other adjustments
 * such as differing in light mode versus dark mode, or what the theme is, or what the color that
 * produced the theme is, etc.
 *
 * <p>Colors without backgrounds do not change tone when contrast changes. Colors with backgrounds
 * become closer to their background as contrast lowers, and further when contrast increases.
 *
 * <p>Prefer the static constructors. They provide a much more simple interface, such as requiring
 * just a hexcode, or just a hexcode and a background.
 *
 * <p>Ultimately, each component necessary for calculating a color, adjusting it for a desired
 * contrast level, and ensuring it has a certain lightness/tone difference from another color, is
 * provided by a function that takes a DuotonePalette and returns a value. This ensures ultimate
 * flexibility, any desired behavior of a color for any design system, but it usually unnecessary.
 * See the default constructor for more information.
 */
// Prevent lint for Function.apply not being available on Android before API level 14 (4.0.1).
// "AndroidJdkLibsChecker" for Function, "NewApi" for Function.apply().
// A java_library Bazel rule with an Android constraint cannot skip these warnings without this
// annotation; another solution would be to create an android_library rule and supply
// AndroidManifest with an SDK set higher than 14.
@SuppressWarnings({"AndroidJdkLibsChecker", "NewApi"})
public final class DuotonePaletteColor {
  public final String name;
  public final Function<DuotonePalette, TonalPalette> tonalPalette;
  public final Function<DuotonePalette, Double> tone;
  public final boolean isBackground;
  public final boolean isInverse;
  public final Function<DuotonePalette, DuotonePaletteColor> background;
  public final ContrastCurve contrastCurve;

  public final Function<DuotonePalette, Double> opacity;

  private final HashMap<DuotonePalette, Hct> hctCache = new HashMap<>();

  /**
   * A constructor for DynamicColor.
   *
   * <p>_Strongly_ prefer using one of the convenience constructors. This class is arguably too
   * flexible to ensure it can support any scenario. Functional arguments allow overriding without
   * risks that come with subclasses.
   *
   * <p>For example, the default behavior of adjust tone at max contrast to be at a 7.0 ratio with
   * its background is principled and matches accessibility guidance. That does not mean it's the
   * desired approach for _every_ design system, and every color pairing, always, in every case.
   *
   * <p>For opaque colors (colors with alpha = 100%).
   *
   * @param name The name of the dynamic color.
   * @param tone Function that provides a tone, given a DuotonePalette.
   * @param isBackground Whether this dynamic color is a background, with some other color as the
   *     foreground.
   * @param background The background of the dynamic color (as a function of a `DuotonePalette`), if
   *     it exists.
   * @param contrastCurve A `ContrastCurve` object specifying how its contrast against its
   *     background should behave in various contrast levels options.
   */
  public DuotonePaletteColor(
      String name,
      Function<DuotonePalette, TonalPalette> tonalPalette,
      Function<DuotonePalette, Double> tone,
      boolean isBackground,
      boolean isInverse,
      Function<DuotonePalette, DuotonePaletteColor> background,
      ContrastCurve contrastCurve) {

    this.name = name;
    this.tonalPalette = tonalPalette;
    this.tone = tone;
    this.isBackground = isBackground;
    this.isInverse = isInverse;
    this.background = background;
    this.contrastCurve = contrastCurve;
    this.opacity = null;
  }

  /**
   * Returns an ARGB integer (i.e. a hex code).
   *
   * @param palette Defines the conditions of the user interface, for example, whether or not it is
   *     dark mode or light mode, and what the desired contrast level is.
   */
  public int getArgb(DuotonePalette palette) {
    int argb = getHct(palette).toInt();
    if (opacity == null) {
      return argb;
    }
    double percentage = opacity.apply(palette);
    int alpha = MathUtils.clampInt(0, 255, (int) Math.round(percentage * 255));
    return (argb & 0x00ffffff) | (alpha << 24);
  }

  /**
   * Returns an HCT object.
   *
   * @param palette Defines the conditions of the user interface, for example, whether or not it is
   *     dark mode or light mode, and what the desired contrast level is.
   */
  public Hct getHct(DuotonePalette palette) {
    Hct cachedAnswer = hctCache.get(palette);
    if (cachedAnswer != null) {
      return cachedAnswer;
    }
    // This is crucial for aesthetics: we aren't simply the taking the standard color
    // and changing its tone for contrast. Rather, we find the tone for contrast, then
    // use the specified chroma from the palette to construct a new color.
    //
    // For example, this enables colors with standard tone of T90, which has limited chroma, to
    // "recover" intended chroma as contrast increases.
    double tone = getTone(palette);
    TonalPalette tonalPalette = this.tonalPalette.apply(palette);
    Hct answer = tonalPalette.getHct(tone);

    // NOMUTANTS--trivial test with onerous dependency injection requirement.
    if (hctCache.size() > 4) {
      hctCache.clear();
    }
    // NOMUTANTS--trivial test with onerous dependency injection requirement.
    hctCache.put(palette, answer);
    return answer;
  }

  /** Returns the tone in HCT, ranging from 0 to 100, of the resolved color given palette. */
  public double getTone(DuotonePalette palette) {
    boolean decreasingContrast = palette.containerConfiguration.getContrastLevel() < 0;

      double answer = tone.apply(palette);

      if (background == null) {
        return answer; // No adjustment for colors with no background.
      }

      DuotonePaletteColor backgroundPaletteColor = background.apply(palette);
      if (backgroundPaletteColor == null) {
        return answer; // No adjustment for colors with no background.
      }

      double bgTone = backgroundPaletteColor.getTone(palette);

      double desiredRatio = contrastCurve.get(palette.containerConfiguration.getContrastLevel());

      if (Contrast.ratioOfTones(bgTone, answer) >= desiredRatio) {
        // Don't "improve" what's good enough.
      } else {
        // Rough improvement.
        answer = DuotonePaletteColor.foregroundTone(bgTone, desiredRatio, false,
            isInverse ^ palette.containerConfiguration.isDark());
      }

      if (decreasingContrast) {
        answer = DuotonePaletteColor.foregroundTone(bgTone, desiredRatio, false,
            isInverse ^ palette.containerConfiguration.isDark());
      }

      if (isBackground && 50 <= answer && answer < 60) {
        // Must adjust
        if (Contrast.ratioOfTones(49, bgTone) >= desiredRatio) {
          answer = 49;
        } else {
          answer = 60;
        }
      }

      return answer;
  }

  /**
   * Given a background tone, find a foreground tone, while ensuring they reach a contrast ratio
   * that is as close to ratio as possible.
   */
  public static double foregroundTone(double bgTone, double ratio,
      boolean allowDynamicPreference, boolean isDark ) {
    double lighterTone = Contrast.lighterUnsafe(bgTone, ratio);
    double darkerTone = Contrast.darkerUnsafe(bgTone, ratio);

    if (!allowDynamicPreference) {
      return isDark ? lighterTone : darkerTone;
    }

    double lighterRatio = Contrast.ratioOfTones(lighterTone, bgTone);
    double darkerRatio = Contrast.ratioOfTones(darkerTone, bgTone);
    boolean preferLighter = tonePrefersLightForeground(bgTone);

    if (preferLighter) {
      // "Negligible difference" handles an edge case where the initial contrast ratio is high
      // (ex. 13.0), and the ratio passed to the function is that high ratio, and both the lighter
      // and darker ratio fails to pass that ratio.
      //
      // This was observed with Tonal Spot's On Primary Container turning black momentarily between
      // high and max contrast in light mode. PC's standard tone was T90, OPC's was T10, it was
      // light mode, and the contrast level was 0.6568521221032331.
      boolean negligibleDifference =
          Math.abs(lighterRatio - darkerRatio) < 0.1 && lighterRatio < ratio && darkerRatio < ratio;
      if (lighterRatio >= ratio || lighterRatio >= darkerRatio || negligibleDifference) {
        return lighterTone;
      } else {
        return darkerTone;
      }
    } else {
      return darkerRatio >= ratio || darkerRatio >= lighterRatio ? darkerTone : lighterTone;
    }
  }

  /**
   * Adjust a tone down such that white has 4.5 contrast, if the tone is reasonably close to
   * supporting it.
   */
  public static double enableLightForeground(double tone) {
    if (tonePrefersLightForeground(tone) && !toneAllowsLightForeground(tone)) {
      return 49.0;
    }
    return tone;
  }

  /**
   * People prefer white foregrounds on ~T60-70. Observed over time, and also by Andrew Somers
   * during research for APCA.
   *
   * <p>T60 used as to create the smallest discontinuity possible when skipping down to T49 in order
   * to ensure light foregrounds.
   *
   * <p>Since `tertiaryContainer` in dark monochrome scheme requires a tone of 60, it should not be
   * adjusted. Therefore, 60 is excluded here.
   */
  public static boolean tonePrefersLightForeground(double tone) {
    return Math.round(tone) < 60;
  }

  /** Tones less than ~T50 always permit white at 4.5 contrast. */
  public static boolean toneAllowsLightForeground(double tone) {
    return Math.round(tone) <= 49;
  }
}
