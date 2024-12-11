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

import org.pushingpixels.ephemeral.chroma.hct.Hct;
import org.pushingpixels.ephemeral.chroma.palettes.TonalPalette;
import org.pushingpixels.ephemeral.chroma.utils.MathUtils;

// This is a modified version of the original source code, changed to fit the Chroma needs

/**
 * Provides important settings for creating colors dynamically, and 8 color palettes. Requires:
 * 1. A color. (source color)
 * 2. Whether or not its dark mode.
 * 3. Contrast level. (-1 to 1, currently contrast ratio 3.0 and 7.0)
 */
public class DynamicScheme {
  public final int sourceColorArgb;
  public final Hct sourceColorHct;
  public final boolean isDark;
  public final double contrastLevel;

  public final TonalPalette primaryPalette;
  public final TonalPalette neutralPalette;
  public final TonalPalette neutralVariantPalette;
  public final TonalPalette systemInfoPalette;
  public final TonalPalette systemWarningPalette;
  public final TonalPalette systemErrorPalette;
  public final TonalPalette systemSuccessPalette;
  public final TonalPalette systemEmergencyPalette;

  public DynamicScheme(
      Hct sourceColorHct,
      boolean isDark,
      double contrastLevel,
      TonalPalette primaryPalette,
      TonalPalette neutralPalette,
      TonalPalette neutralVariantPalette,
      TonalPalette systemInfoPalette,
      TonalPalette systemWarningPalette,
      TonalPalette systemErrorPalette,
      TonalPalette systemSuccessPalette,
      TonalPalette systemEmergencyPalette) {
    this.sourceColorArgb = sourceColorHct.toInt();
    this.sourceColorHct = sourceColorHct;
    this.isDark = isDark;
    this.contrastLevel = contrastLevel;

    this.primaryPalette = primaryPalette;
    this.neutralPalette = neutralPalette;
    this.neutralVariantPalette = neutralVariantPalette;
    this.systemInfoPalette = systemInfoPalette;
    this.systemWarningPalette = systemWarningPalette;
    this.systemErrorPalette = systemErrorPalette;
    this.systemSuccessPalette = systemSuccessPalette;
    this.systemEmergencyPalette = systemEmergencyPalette;
  }

  /**
   * Given a set of hues and set of hue rotations, locate which hues the source color's hue is
   * between, apply the rotation at the same index as the first hue in the range, and return the
   * rotated hue.
   *
   * @param sourceColorHct The color whose hue should be rotated.
   * @param hues A set of hues.
   * @param rotations A set of hue rotations.
   * @return Color's hue with a rotation applied.
   */
  public static double getRotatedHue(Hct sourceColorHct, double[] hues, double[] rotations) {
    final double sourceHue = sourceColorHct.getHue();
    if (rotations.length == 1) {
      return MathUtils.sanitizeDegreesDouble(sourceHue + rotations[0]);
    }
    final int size = hues.length;
    for (int i = 0; i <= (size - 2); i++) {
      final double thisHue = hues[i];
      final double nextHue = hues[i + 1];
      if (thisHue < sourceHue && sourceHue < nextHue) {
        return MathUtils.sanitizeDegreesDouble(sourceHue + rotations[i]);
      }
    }
    // If this statement executes, something is wrong, there should have been a rotation
    // found using the arrays.
    return sourceHue;
  }

  public Hct getHct(DynamicColor dynamicColor) {
    return dynamicColor.getHct(this);
  }

  public int getArgb(DynamicColor dynamicColor) {
    return dynamicColor.getArgb(this);
  }

  public int getSurface() {
    return getArgb(new EphemeralChromaDynamicColors().surface());
  }

  public int getSurfaceDim() {
    return getArgb(new EphemeralChromaDynamicColors().surfaceDim());
  }

  public int getSurfaceBright() {
    return getArgb(new EphemeralChromaDynamicColors().surfaceBright());
  }

  public int getSurfaceContainerLowest() {
    return getArgb(new EphemeralChromaDynamicColors().surfaceContainerLowest());
  }

  public int getSurfaceContainerLow() {
    return getArgb(new EphemeralChromaDynamicColors().surfaceContainerLow());
  }

  public int getSurfaceContainer() {
    return getArgb(new EphemeralChromaDynamicColors().surfaceContainer());
  }

  public int getSurfaceContainerHigh() {
    return getArgb(new EphemeralChromaDynamicColors().surfaceContainerHigh());
  }

  public int getSurfaceContainerHighest() {
    return getArgb(new EphemeralChromaDynamicColors().surfaceContainerHighest());
  }

  public int getOnSurfaceContainer() {
    return getArgb(new EphemeralChromaDynamicColors().onSurfaceContainer());
  }

  public int getOnSurfaceContainerVariant() {
    return getArgb(new EphemeralChromaDynamicColors().onSurfaceContainerVariant());
  }

  public int getSurfaceContainerOutline() {
    return getArgb(new EphemeralChromaDynamicColors().surfaceContainerOutline());
  }

  public int getSurfaceContainerOutlineVariant() {
    return getArgb(new EphemeralChromaDynamicColors().surfaceContainerOutlineVariant());
  }

  public int getMutedContainerLowest() {
    return getArgb(new EphemeralChromaDynamicColors().mutedContainerLowest());
  }

  public int getMutedContainerLow() {
    return getArgb(new EphemeralChromaDynamicColors().mutedContainerLow());
  }

  public int getMutedContainer() {
    return getArgb(new EphemeralChromaDynamicColors().mutedContainer());
  }

  public int getMutedContainerHigh() {
    return getArgb(new EphemeralChromaDynamicColors().mutedContainerHigh());
  }

  public int getMutedContainerHighest() {
    return getArgb(new EphemeralChromaDynamicColors().mutedContainerHighest());
  }

  public int getOnMutedContainer() {
    return getArgb(new EphemeralChromaDynamicColors().onMutedContainer());
  }

  public int getOnMutedContainerVariant() {
    return getArgb(new EphemeralChromaDynamicColors().onMutedContainerVariant());
  }

  public int getMutedContainerOutline() {
    return getArgb(new EphemeralChromaDynamicColors().mutedContainerOutline());
  }

  public int getMutedContainerOutlineVariant() {
    return getArgb(new EphemeralChromaDynamicColors().mutedContainerOutlineVariant());
  }

  public int getTonalContainerLowest() {
    return getArgb(new EphemeralChromaDynamicColors().tonalContainerLowest());
  }

  public int getTonalContainerLow() {
    return getArgb(new EphemeralChromaDynamicColors().tonalContainerLow());
  }

  public int getTonalContainer() {
    return getArgb(new EphemeralChromaDynamicColors().tonalContainer());
  }

  public int getTonalContainerHigh() {
    return getArgb(new EphemeralChromaDynamicColors().tonalContainerHigh());
  }

  public int getTonalContainerHighest() {
    return getArgb(new EphemeralChromaDynamicColors().tonalContainerHighest());
  }

  public int getOnTonalContainer() {
    return getArgb(new EphemeralChromaDynamicColors().onTonalContainer());
  }

  public int getOnTonalContainerVariant() {
    return getArgb(new EphemeralChromaDynamicColors().onTonalContainerVariant());
  }

  public int getTonalContainerOutline() {
    return getArgb(new EphemeralChromaDynamicColors().tonalContainerOutline());
  }

  public int getTonalContainerOutlineVariant() {
    return getArgb(new EphemeralChromaDynamicColors().tonalContainerOutlineVariant());
  }

  public int getPrimaryContainerLowest() {
    return getArgb(new EphemeralChromaDynamicColors().primaryContainerLowest());
  }

  public int getPrimaryContainerLow() {
    return getArgb(new EphemeralChromaDynamicColors().primaryContainerLow());
  }

  public int getPrimaryContainer() {
    return getArgb(new EphemeralChromaDynamicColors().primaryContainer());
  }

  public int getPrimaryContainerHigh() {
    return getArgb(new EphemeralChromaDynamicColors().primaryContainerHigh());
  }

  public int getPrimaryContainerHighest() {
    return getArgb(new EphemeralChromaDynamicColors().primaryContainerHighest());
  }

  public int getOnPrimaryContainer() {
    return getArgb(new EphemeralChromaDynamicColors().onPrimaryContainer());
  }

  public int getOnPrimaryContainerVariant() {
    return getArgb(new EphemeralChromaDynamicColors().onPrimaryContainerVariant());
  }

  public int getPrimaryContainerOutline() {
    return getArgb(new EphemeralChromaDynamicColors().primaryContainerOutline());
  }

  public int getPrimaryContainerOutlineVariant() {
    return getArgb(new EphemeralChromaDynamicColors().primaryContainerOutlineVariant());
  }

  public int getSystemInfoContainerLowest() {
    return getArgb(new EphemeralChromaDynamicColors().systemInfoContainerLowest());
  }

  public int getSystemInfoContainerLow() {
    return getArgb(new EphemeralChromaDynamicColors().systemInfoContainerLow());
  }

  public int getSystemInfoContainer() {
    return getArgb(new EphemeralChromaDynamicColors().systemInfoContainer());
  }

  public int getSystemInfoContainerHigh() {
    return getArgb(new EphemeralChromaDynamicColors().systemInfoContainerHigh());
  }

  public int getSystemInfoContainerHighest() {
    return getArgb(new EphemeralChromaDynamicColors().systemInfoContainerHighest());
  }

  public int getOnSystemInfoContainer() {
    return getArgb(new EphemeralChromaDynamicColors().onSystemInfoContainer());
  }

  public int getOnSystemInfoContainerVariant() {
    return getArgb(new EphemeralChromaDynamicColors().onSystemInfoContainerVariant());
  }

  public int getSystemInfoContainerOutline() {
    return getArgb(new EphemeralChromaDynamicColors().systemInfoContainerOutline());
  }

  public int getSystemInfoContainerOutlineVariant() {
    return getArgb(new EphemeralChromaDynamicColors().systemInfoContainerOutlineVariant());
  }

  public int getSystemWarningContainerLowest() {
    return getArgb(new EphemeralChromaDynamicColors().systemWarningContainerLowest());
  }

  public int getSystemWarningContainerLow() {
    return getArgb(new EphemeralChromaDynamicColors().systemWarningContainerLow());
  }

  public int getSystemWarningContainer() {
    return getArgb(new EphemeralChromaDynamicColors().systemWarningContainer());
  }

  public int getSystemWarningContainerHigh() {
    return getArgb(new EphemeralChromaDynamicColors().systemWarningContainerHigh());
  }

  public int getSystemWarningContainerHighest() {
    return getArgb(new EphemeralChromaDynamicColors().systemWarningContainerHighest());
  }

  public int getOnSystemWarningContainer() {
    return getArgb(new EphemeralChromaDynamicColors().onSystemWarningContainer());
  }

  public int getOnSystemWarningContainerVariant() {
    return getArgb(new EphemeralChromaDynamicColors().onSystemWarningContainerVariant());
  }

  public int getSystemWarningContainerOutline() {
    return getArgb(new EphemeralChromaDynamicColors().systemWarningContainerOutline());
  }

  public int getSystemWarningContainerOutlineVariant() {
    return getArgb(new EphemeralChromaDynamicColors().systemWarningContainerOutlineVariant());
  }

  public int getSystemErrorContainerLowest() {
    return getArgb(new EphemeralChromaDynamicColors().systemErrorContainerLowest());
  }

  public int getSystemErrorContainerLow() {
    return getArgb(new EphemeralChromaDynamicColors().systemErrorContainerLow());
  }

  public int getSystemErrorContainer() {
    return getArgb(new EphemeralChromaDynamicColors().systemErrorContainer());
  }

  public int getSystemErrorContainerHigh() {
    return getArgb(new EphemeralChromaDynamicColors().systemErrorContainerHigh());
  }

  public int getSystemErrorContainerHighest() {
    return getArgb(new EphemeralChromaDynamicColors().systemErrorContainerHighest());
  }

  public int getOnSystemErrorContainer() {
    return getArgb(new EphemeralChromaDynamicColors().onSystemErrorContainer());
  }

  public int getOnSystemErrorContainerVariant() {
    return getArgb(new EphemeralChromaDynamicColors().onSystemErrorContainerVariant());
  }

  public int getSystemErrorContainerOutline() {
    return getArgb(new EphemeralChromaDynamicColors().systemErrorContainerOutline());
  }

  public int getSystemErrorContainerOutlineVariant() {
    return getArgb(new EphemeralChromaDynamicColors().systemErrorContainerOutlineVariant());
  }

  public int getSystemSuccessContainerLowest() {
    return getArgb(new EphemeralChromaDynamicColors().systemSuccessContainerLowest());
  }

  public int getSystemSuccessContainerLow() {
    return getArgb(new EphemeralChromaDynamicColors().systemSuccessContainerLow());
  }

  public int getSystemSuccessContainer() {
    return getArgb(new EphemeralChromaDynamicColors().systemSuccessContainer());
  }

  public int getSystemSuccessContainerHigh() {
    return getArgb(new EphemeralChromaDynamicColors().systemSuccessContainerHigh());
  }

  public int getSystemSuccessContainerHighest() {
    return getArgb(new EphemeralChromaDynamicColors().systemSuccessContainerHighest());
  }

  public int getOnSystemSuccessContainer() {
    return getArgb(new EphemeralChromaDynamicColors().onSystemSuccessContainer());
  }

  public int getOnSystemSuccessContainerVariant() {
    return getArgb(new EphemeralChromaDynamicColors().onSystemSuccessContainerVariant());
  }

  public int getSystemSuccessContainerOutline() {
    return getArgb(new EphemeralChromaDynamicColors().systemSuccessContainerOutline());
  }

  public int getSystemSuccessContainerOutlineVariant() {
    return getArgb(new EphemeralChromaDynamicColors().systemSuccessContainerOutlineVariant());
  }

  public int getSystemEmergencyContainerLowest() {
    return getArgb(new EphemeralChromaDynamicColors().systemEmergencyContainerLowest());
  }

  public int getSystemEmergencyContainerLow() {
    return getArgb(new EphemeralChromaDynamicColors().systemEmergencyContainerLow());
  }

  public int getSystemEmergencyContainer() {
    return getArgb(new EphemeralChromaDynamicColors().systemEmergencyContainer());
  }

  public int getSystemEmergencyContainerHigh() {
    return getArgb(new EphemeralChromaDynamicColors().systemEmergencyContainerHigh());
  }

  public int getSystemEmergencyContainerHighest() {
    return getArgb(new EphemeralChromaDynamicColors().systemEmergencyContainerHighest());
  }

  public int getOnSystemEmergencyContainer() {
    return getArgb(new EphemeralChromaDynamicColors().onSystemEmergencyContainer());
  }

  public int getOnSystemEmergencyContainerVariant() {
    return getArgb(new EphemeralChromaDynamicColors().onSystemEmergencyContainerVariant());
  }

  public int getSystemEmergencyContainerOutline() {
    return getArgb(new EphemeralChromaDynamicColors().systemEmergencyContainerOutline());
  }

  public int getSystemEmergencyContainerOutlineVariant() {
    return getArgb(new EphemeralChromaDynamicColors().systemEmergencyContainerOutlineVariant());
  }

}
