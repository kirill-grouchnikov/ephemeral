/*
 * Copyright 2021 Google LLC
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

package org.pushingpixels.ephemeral.chroma.palettes;

import org.pushingpixels.ephemeral.chroma.hct.Hct;

import java.util.HashMap;
import java.util.Map;

// This is a modified version of the original source code, changed to fit the Chroma needs

/**
 * A convenience class for retrieving colors that are sourced from an interpolation
 * between two HCT seeds.
 *
 * <p>BimodalTonalPalette is intended for use in a single thread due to its stateful caching.
 */
public final class BimodalTonalPalette implements BaseTonalPalette {
  /**
   * Defines the tone range over which a transition between two palettes occurs.
   */
  public interface TransitionRange {
    /**
     * Returns the starting tone of the transition range.
     * @return the start tone value
     */
    double getTransitionToneStart();

    /**
     * Returns the ending tone of the transition range.
     * @return the end tone value
     */
    double getTransitionToneEnd();
  }

  /**
   * A transition range that prioritizes fidelity to the source color in light tones.
   */
  public static class TransitionRangeFidelityLight implements TransitionRange {
    private final double fidelityTone;

    /**
     * Creates a fidelity-based light transition range.
     * @param fidelityTone the tone value at which fidelity is centered
     */
    public TransitionRangeFidelityLight(double fidelityTone) {
      this.fidelityTone = fidelityTone;
    }

    @Override
    public double getTransitionToneStart() {
      return this.fidelityTone - 4.0;
    }

    @Override
    public double getTransitionToneEnd() {
      return this.fidelityTone + 8.0;
    }
  }

  /**
   * A transition range that prioritizes fidelity to the source color in dark tones.
   */
  public static class TransitionRangeFidelityDark implements TransitionRange {
    private final double fidelityTone;

    /**
     * Creates a fidelity-based dark transition range.
     * @param fidelityTone the tone value at which fidelity is centered
     */
    public TransitionRangeFidelityDark(double fidelityTone) {
      this.fidelityTone = fidelityTone;
    }

    @Override
    public double getTransitionToneStart() {
      return this.fidelityTone - 8.0;
    }

    @Override
    public double getTransitionToneEnd() {
      return this.fidelityTone + 10.0;
    }
  }

  /**
   * A balanced transition range for light tones, transitioning between tone 82 and 94.
   */
  public static class TransitionRangeBalancedLight implements TransitionRange {
    /** Creates a balanced light transition range. */
    public TransitionRangeBalancedLight() {
    }

    @Override
    public double getTransitionToneStart() {
      return 82.0;
    }

    @Override
    public double getTransitionToneEnd() {
      return 94.0;
    }
  }

  /**
   * A balanced transition range for dark tones, transitioning between tone 22 and 46.
   */
  public static class TransitionRangeBalancedDark implements TransitionRange {
    /** Creates a balanced dark transition range. */
    public TransitionRangeBalancedDark() {
    }

    @Override
    public double getTransitionToneStart() {
      return 22.0;
    }

    @Override
    public double getTransitionToneEnd() {
      return 46.0;
    }
  }

  private final TonalPalette palette1;
  private final TonalPalette palette2;
  private final TransitionRange transitionRange;

  private Map<Integer, Integer> cache;

  private BimodalTonalPalette(
      TonalPalette palette1,
      TonalPalette palette2,
      TransitionRange transitionRange) {
    this.palette1 = palette1;
    this.palette2 = palette2;
    this.transitionRange = transitionRange;
    this.cache = new HashMap<>();
  }

  /**
   * Creates a BimodalTonalPalette from two HCT colors and a transition range.
   *
   * @param hct1 the first HCT color seed
   * @param hct2 the second HCT color seed
   * @param transitionRange the range over which the two palettes transition
   * @return a new BimodalTonalPalette instance
   */
  public static BimodalTonalPalette from(Hct hct1, Hct hct2, TransitionRange transitionRange) {
    return new BimodalTonalPalette(TonalPalette.fromHct(hct1), TonalPalette.fromHct(hct2), transitionRange);
  }

  @Override
  public int tone(int tone) {
    int tone1 = this.palette1.tone(tone);
    int tone2 = this.palette2.tone(tone);

    Integer answer = cache.get(tone);
    if (answer == null) {
      double transitionToneStart = this.transitionRange.getTransitionToneStart();
      double transitionToneEnd = this.transitionRange.getTransitionToneEnd();
      if (tone <= transitionToneStart) {
        answer = tone1;
      } else if (tone >= transitionToneEnd) {
        answer = tone2;
      } else {
        double fraction = (tone - transitionToneStart) / (transitionToneEnd - transitionToneStart);
        // Interpolate hue and chroma, but leave the tone
        Hct hct1 = Hct.fromInt(tone1);
        Hct hct2 = Hct.fromInt(tone2);
        double interpolatedHue =
            hct1.getHue() * (1.0 - fraction) + hct2.getHue() * fraction;
        double interpolatedChroma =
            hct1.getChroma() * (1.0 - fraction) + hct2.getChroma() * fraction;
        answer = Hct.from(interpolatedHue, interpolatedChroma, tone).toInt();
      }
      cache.put(tone, answer);
    }
    return answer;
  }

  /** Given a tone, use hue and chroma of palette to create a color, and return it as HCT. */
  @Override
  public Hct getHct(double tone) {
    Hct hct1 = this.palette1.getHct(tone);
    Hct hct2 = this.palette2.getHct(tone);

    double transitionToneStart = this.transitionRange.getTransitionToneStart();
    double transitionToneEnd = this.transitionRange.getTransitionToneEnd();
    if (tone <= transitionToneStart) {
      return hct1;
    } else if (tone >= transitionToneEnd) {
      return hct2;
    } else {
      double fraction = (tone - transitionToneStart) / (transitionToneEnd - transitionToneStart);
      // Interpolate hue and chroma, but leave the tone
      double interpolatedHue =
          hct1.getHue() * (1.0 - fraction) + hct2.getHue() * fraction;
      double interpolatedChroma =
          hct1.getChroma() * (1.0 - fraction) + hct2.getChroma() * fraction;
      return Hct.from(interpolatedHue, interpolatedChroma, tone);
    }
  }
}
