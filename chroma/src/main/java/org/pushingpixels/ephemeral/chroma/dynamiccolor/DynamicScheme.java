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
  public final int primarySourceColorArgb;
  public final Hct primarySourceColorHct;
  public final Hct mutedSourceColorHct;
  public final Hct neutralSourceColorHct;
  public final boolean isFidelity;
  public final boolean isDark;
  public final double contrastLevel;

  public final TonalPalette primaryPalette;
  public final TonalPalette mutedPalette;
  public final TonalPalette neutralPalette;
  public final TonalPalette systemInfoPalette;
  public final TonalPalette systemWarningPalette;
  public final TonalPalette systemErrorPalette;
  public final TonalPalette systemSuccessPalette;
  public final TonalPalette systemEmergencyPalette;

  public DynamicScheme(
      Hct primarySourceColorHct,
      Hct mutedSourceColorHct,
      Hct neutralSourceColorHct,
      boolean isFidelity,
      boolean isDark,
      double contrastLevel,
      TonalPalette primaryPalette,
      TonalPalette mutedPalette,
      TonalPalette neutralPalette,
      TonalPalette systemInfoPalette,
      TonalPalette systemWarningPalette,
      TonalPalette systemErrorPalette,
      TonalPalette systemSuccessPalette,
      TonalPalette systemEmergencyPalette) {

    this.primarySourceColorArgb = primarySourceColorHct.toInt();
    this.primarySourceColorHct = primarySourceColorHct;
    this.mutedSourceColorHct = mutedSourceColorHct;
    this.neutralSourceColorHct = neutralSourceColorHct;

    this.isFidelity = isFidelity;
    this.isDark = isDark;
    this.contrastLevel = contrastLevel;

    this.primaryPalette = primaryPalette;
    this.mutedPalette = mutedPalette;
    this.neutralPalette = neutralPalette;
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

  public int getNeutralContainerSurfaceLowest() {
    return getArgb(new EphemeralChromaDynamicColors().neutralContainerSurfaceLowest());
  }

  public int getNeutralContainerSurfaceLow() {
    return getArgb(new EphemeralChromaDynamicColors().neutralContainerSurfaceLow());
  }

  public int getNeutralContainerSurface() {
    return getArgb(new EphemeralChromaDynamicColors().neutralContainerSurface());
  }

  public int getNeutralContainerSurfaceHigh() {
    return getArgb(new EphemeralChromaDynamicColors().neutralContainerSurfaceHigh());
  }

  public int getNeutralContainerSurfaceHighest() {
    return getArgb(new EphemeralChromaDynamicColors().neutralContainerSurfaceHighest());
  }

  public int getOnNeutralContainer() {
    return getArgb(new EphemeralChromaDynamicColors().onNeutralContainer());
  }

  public int getOnNeutralContainerVariant() {
    return getArgb(new EphemeralChromaDynamicColors().onNeutralContainerVariant());
  }

  public int getNeutralContainerOutline() {
    return getArgb(new EphemeralChromaDynamicColors().neutralContainerOutline());
  }

  public int getNeutralContainerOutlineVariant() {
    return getArgb(new EphemeralChromaDynamicColors().neutralContainerOutlineVariant());
  }

  public int getMutedContainerSurfaceLowest() {
    return getArgb(new EphemeralChromaDynamicColors().mutedContainerSurfaceLowest());
  }

  public int getMutedContainerSurfaceLow() {
    return getArgb(new EphemeralChromaDynamicColors().mutedContainerSurfaceLow());
  }

  public int getMutedContainerSurface() {
    return getArgb(new EphemeralChromaDynamicColors().mutedContainerSurface());
  }

  public int getMutedContainerSurfaceHigh() {
    return getArgb(new EphemeralChromaDynamicColors().mutedContainerSurfaceHigh());
  }

  public int getMutedContainerSurfaceHighest() {
    return getArgb(new EphemeralChromaDynamicColors().mutedContainerSurfaceHighest());
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

  public int getTonalContainerSurfaceLowest() {
    return getArgb(new EphemeralChromaDynamicColors().tonalContainerSurfaceLowest());
  }

  public int getTonalContainerSurfaceLow() {
    return getArgb(new EphemeralChromaDynamicColors().tonalContainerSurfaceLow());
  }

  public int getTonalContainerSurface() {
    return getArgb(new EphemeralChromaDynamicColors().tonalContainerSurface());
  }

  public int getTonalContainerSurfaceHigh() {
    return getArgb(new EphemeralChromaDynamicColors().tonalContainerSurfaceHigh());
  }

  public int getTonalContainerSurfaceHighest() {
    return getArgb(new EphemeralChromaDynamicColors().tonalContainerSurfaceHighest());
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

  public int getPrimaryContainerSurfaceLowest() {
    return getArgb(new EphemeralChromaDynamicColors().primaryContainerSurfaceLowest());
  }

  public int getPrimaryContainerSurfaceLow() {
    return getArgb(new EphemeralChromaDynamicColors().primaryContainerSurfaceLow());
  }

  public int getPrimaryContainerSurface() {
    return getArgb(new EphemeralChromaDynamicColors().primaryContainerSurface());
  }

  public int getPrimaryContainerSurfaceHigh() {
    return getArgb(new EphemeralChromaDynamicColors().primaryContainerSurfaceHigh());
  }

  public int getPrimaryContainerSurfaceHighest() {
    return getArgb(new EphemeralChromaDynamicColors().primaryContainerSurfaceHighest());
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

  public int getSystemInfoContainerSurfaceLowest() {
    return getArgb(new EphemeralChromaDynamicColors().systemInfoContainerSurfaceLowest());
  }

  public int getSystemInfoContainerSurfaceLow() {
    return getArgb(new EphemeralChromaDynamicColors().systemInfoContainerSurfaceLow());
  }

  public int getSystemInfoContainerSurface() {
    return getArgb(new EphemeralChromaDynamicColors().systemInfoContainerSurface());
  }

  public int getSystemInfoContainerSurfaceHigh() {
    return getArgb(new EphemeralChromaDynamicColors().systemInfoContainerSurfaceHigh());
  }

  public int getSystemInfoContainerSurfaceHighest() {
    return getArgb(new EphemeralChromaDynamicColors().systemInfoContainerSurfaceHighest());
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

  public int getSystemWarningContainerSurfaceLowest() {
    return getArgb(new EphemeralChromaDynamicColors().systemWarningContainerSurfaceLowest());
  }

  public int getSystemWarningContainerSurfaceLow() {
    return getArgb(new EphemeralChromaDynamicColors().systemWarningContainerSurfaceLow());
  }

  public int getSystemWarningContainerSurface() {
    return getArgb(new EphemeralChromaDynamicColors().systemWarningContainerSurface());
  }

  public int getSystemWarningContainerSurfaceHigh() {
    return getArgb(new EphemeralChromaDynamicColors().systemWarningContainerSurfaceHigh());
  }

  public int getSystemWarningContainerSurfaceHighest() {
    return getArgb(new EphemeralChromaDynamicColors().systemWarningContainerSurfaceHighest());
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

  public int getSystemErrorContainerSurfaceLowest() {
    return getArgb(new EphemeralChromaDynamicColors().systemErrorContainerSurfaceLowest());
  }

  public int getSystemErrorContainerSurfaceLow() {
    return getArgb(new EphemeralChromaDynamicColors().systemErrorContainerSurfaceLow());
  }

  public int getSystemErrorContainerSurface() {
    return getArgb(new EphemeralChromaDynamicColors().systemErrorContainerSurface());
  }

  public int getSystemErrorContainerSurfaceHigh() {
    return getArgb(new EphemeralChromaDynamicColors().systemErrorContainerSurfaceHigh());
  }

  public int getSystemErrorContainerSurfaceHighest() {
    return getArgb(new EphemeralChromaDynamicColors().systemErrorContainerSurfaceHighest());
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

  public int getSystemSuccessContainerSurfaceLowest() {
    return getArgb(new EphemeralChromaDynamicColors().systemSuccessContainerSurfaceLowest());
  }

  public int getSystemSuccessContainerSurfaceLow() {
    return getArgb(new EphemeralChromaDynamicColors().systemSuccessContainerSurfaceLow());
  }

  public int getSystemSuccessContainerSurface() {
    return getArgb(new EphemeralChromaDynamicColors().systemSuccessContainerSurface());
  }

  public int getSystemSuccessContainerSurfaceHigh() {
    return getArgb(new EphemeralChromaDynamicColors().systemSuccessContainerSurfaceHigh());
  }

  public int getSystemSuccessContainerSurfaceHighest() {
    return getArgb(new EphemeralChromaDynamicColors().systemSuccessContainerSurfaceHighest());
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

  public int getSystemEmergencyContainerSurfaceLowest() {
    return getArgb(new EphemeralChromaDynamicColors().systemEmergencyContainerSurfaceLowest());
  }

  public int getSystemEmergencyContainerSurfaceLow() {
    return getArgb(new EphemeralChromaDynamicColors().systemEmergencyContainerSurfaceLow());
  }

  public int getSystemEmergencyContainerSurface() {
    return getArgb(new EphemeralChromaDynamicColors().systemEmergencyContainerSurface());
  }

  public int getSystemEmergencyContainerSurfaceHigh() {
    return getArgb(new EphemeralChromaDynamicColors().systemEmergencyContainerSurfaceHigh());
  }

  public int getSystemEmergencyContainerSurfaceHighest() {
    return getArgb(new EphemeralChromaDynamicColors().systemEmergencyContainerSurfaceHighest());
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
