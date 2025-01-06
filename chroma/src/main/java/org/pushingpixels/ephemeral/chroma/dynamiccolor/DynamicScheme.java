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
 * Provides important settings for creating colors dynamically, and 8 tonal palettes. Requires:
 * 1. A color. (source color)
 * 2. Whether or not its dark mode.
 * 3. Contrast level. (-1 to 1, currently contrast ratio 3.0 and 7.0)
 */
public class DynamicScheme {
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

  public Hct getHct(DynamicSchemeColor dynamicSchemeColor) {
    return dynamicSchemeColor.getHct(this);
  }

  public int getArgb(DynamicSchemeColor dynamicSchemeColor) {
    return dynamicSchemeColor.getArgb(this);
  }

  public int getSurface() {
    return getArgb(new ChromaDynamicSchemeColors().surface());
  }

  public int getSurfaceDim() {
    return getArgb(new ChromaDynamicSchemeColors().surfaceDim());
  }

  public int getSurfaceBright() {
    return getArgb(new ChromaDynamicSchemeColors().surfaceBright());
  }

  public int getNeutralContainerSurfaceLowest() {
    return getArgb(new ChromaDynamicSchemeColors().neutralContainerSurfaceLowest());
  }

  public int getNeutralContainerSurfaceLow() {
    return getArgb(new ChromaDynamicSchemeColors().neutralContainerSurfaceLow());
  }

  public int getNeutralContainerSurface() {
    return getArgb(new ChromaDynamicSchemeColors().neutralContainerSurface());
  }

  public int getNeutralContainerSurfaceHigh() {
    return getArgb(new ChromaDynamicSchemeColors().neutralContainerSurfaceHigh());
  }

  public int getNeutralContainerSurfaceHighest() {
    return getArgb(new ChromaDynamicSchemeColors().neutralContainerSurfaceHighest());
  }

  public int getOnNeutralContainer() {
    return getArgb(new ChromaDynamicSchemeColors().onNeutralContainer());
  }

  public int getOnNeutralContainerVariant() {
    return getArgb(new ChromaDynamicSchemeColors().onNeutralContainerVariant());
  }

  public int getNeutralContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().neutralContainerOutline());
  }

  public int getNeutralContainerOutlineVariant() {
    return getArgb(new ChromaDynamicSchemeColors().neutralContainerOutlineVariant());
  }

  public int getMutedContainerSurfaceLowest() {
    return getArgb(new ChromaDynamicSchemeColors().mutedContainerSurfaceLowest());
  }

  public int getMutedContainerSurfaceLow() {
    return getArgb(new ChromaDynamicSchemeColors().mutedContainerSurfaceLow());
  }

  public int getMutedContainerSurface() {
    return getArgb(new ChromaDynamicSchemeColors().mutedContainerSurface());
  }

  public int getMutedContainerSurfaceHigh() {
    return getArgb(new ChromaDynamicSchemeColors().mutedContainerSurfaceHigh());
  }

  public int getMutedContainerSurfaceHighest() {
    return getArgb(new ChromaDynamicSchemeColors().mutedContainerSurfaceHighest());
  }

  public int getOnMutedContainer() {
    return getArgb(new ChromaDynamicSchemeColors().onMutedContainer());
  }

  public int getOnMutedContainerVariant() {
    return getArgb(new ChromaDynamicSchemeColors().onMutedContainerVariant());
  }

  public int getMutedContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().mutedContainerOutline());
  }

  public int getMutedContainerOutlineVariant() {
    return getArgb(new ChromaDynamicSchemeColors().mutedContainerOutlineVariant());
  }

  public int getTonalContainerSurfaceLowest() {
    return getArgb(new ChromaDynamicSchemeColors().tonalContainerSurfaceLowest());
  }

  public int getTonalContainerSurfaceLow() {
    return getArgb(new ChromaDynamicSchemeColors().tonalContainerSurfaceLow());
  }

  public int getTonalContainerSurface() {
    return getArgb(new ChromaDynamicSchemeColors().tonalContainerSurface());
  }

  public int getTonalContainerSurfaceHigh() {
    return getArgb(new ChromaDynamicSchemeColors().tonalContainerSurfaceHigh());
  }

  public int getTonalContainerSurfaceHighest() {
    return getArgb(new ChromaDynamicSchemeColors().tonalContainerSurfaceHighest());
  }

  public int getOnTonalContainer() {
    return getArgb(new ChromaDynamicSchemeColors().onTonalContainer());
  }

  public int getOnTonalContainerVariant() {
    return getArgb(new ChromaDynamicSchemeColors().onTonalContainerVariant());
  }

  public int getTonalContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().tonalContainerOutline());
  }

  public int getTonalContainerOutlineVariant() {
    return getArgb(new ChromaDynamicSchemeColors().tonalContainerOutlineVariant());
  }

  public int getPrimaryContainerSurfaceLowest() {
    return getArgb(new ChromaDynamicSchemeColors().primaryContainerSurfaceLowest());
  }

  public int getPrimaryContainerSurfaceLow() {
    return getArgb(new ChromaDynamicSchemeColors().primaryContainerSurfaceLow());
  }

  public int getPrimaryContainerSurface() {
    return getArgb(new ChromaDynamicSchemeColors().primaryContainerSurface());
  }

  public int getPrimaryContainerSurfaceHigh() {
    return getArgb(new ChromaDynamicSchemeColors().primaryContainerSurfaceHigh());
  }

  public int getPrimaryContainerSurfaceHighest() {
    return getArgb(new ChromaDynamicSchemeColors().primaryContainerSurfaceHighest());
  }

  public int getOnPrimaryContainer() {
    return getArgb(new ChromaDynamicSchemeColors().onPrimaryContainer());
  }

  public int getOnPrimaryContainerVariant() {
    return getArgb(new ChromaDynamicSchemeColors().onPrimaryContainerVariant());
  }

  public int getPrimaryContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().primaryContainerOutline());
  }

  public int getPrimaryContainerOutlineVariant() {
    return getArgb(new ChromaDynamicSchemeColors().primaryContainerOutlineVariant());
  }

  public int getSystemInfoContainerSurfaceLowest() {
    return getArgb(new ChromaDynamicSchemeColors().systemInfoContainerSurfaceLowest());
  }

  public int getSystemInfoContainerSurfaceLow() {
    return getArgb(new ChromaDynamicSchemeColors().systemInfoContainerSurfaceLow());
  }

  public int getSystemInfoContainerSurface() {
    return getArgb(new ChromaDynamicSchemeColors().systemInfoContainerSurface());
  }

  public int getSystemInfoContainerSurfaceHigh() {
    return getArgb(new ChromaDynamicSchemeColors().systemInfoContainerSurfaceHigh());
  }

  public int getSystemInfoContainerSurfaceHighest() {
    return getArgb(new ChromaDynamicSchemeColors().systemInfoContainerSurfaceHighest());
  }

  public int getOnSystemInfoContainer() {
    return getArgb(new ChromaDynamicSchemeColors().onSystemInfoContainer());
  }

  public int getOnSystemInfoContainerVariant() {
    return getArgb(new ChromaDynamicSchemeColors().onSystemInfoContainerVariant());
  }

  public int getSystemInfoContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().systemInfoContainerOutline());
  }

  public int getSystemInfoContainerOutlineVariant() {
    return getArgb(new ChromaDynamicSchemeColors().systemInfoContainerOutlineVariant());
  }

  public int getSystemWarningContainerSurfaceLowest() {
    return getArgb(new ChromaDynamicSchemeColors().systemWarningContainerSurfaceLowest());
  }

  public int getSystemWarningContainerSurfaceLow() {
    return getArgb(new ChromaDynamicSchemeColors().systemWarningContainerSurfaceLow());
  }

  public int getSystemWarningContainerSurface() {
    return getArgb(new ChromaDynamicSchemeColors().systemWarningContainerSurface());
  }

  public int getSystemWarningContainerSurfaceHigh() {
    return getArgb(new ChromaDynamicSchemeColors().systemWarningContainerSurfaceHigh());
  }

  public int getSystemWarningContainerSurfaceHighest() {
    return getArgb(new ChromaDynamicSchemeColors().systemWarningContainerSurfaceHighest());
  }

  public int getOnSystemWarningContainer() {
    return getArgb(new ChromaDynamicSchemeColors().onSystemWarningContainer());
  }

  public int getOnSystemWarningContainerVariant() {
    return getArgb(new ChromaDynamicSchemeColors().onSystemWarningContainerVariant());
  }

  public int getSystemWarningContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().systemWarningContainerOutline());
  }

  public int getSystemWarningContainerOutlineVariant() {
    return getArgb(new ChromaDynamicSchemeColors().systemWarningContainerOutlineVariant());
  }

  public int getSystemErrorContainerSurfaceLowest() {
    return getArgb(new ChromaDynamicSchemeColors().systemErrorContainerSurfaceLowest());
  }

  public int getSystemErrorContainerSurfaceLow() {
    return getArgb(new ChromaDynamicSchemeColors().systemErrorContainerSurfaceLow());
  }

  public int getSystemErrorContainerSurface() {
    return getArgb(new ChromaDynamicSchemeColors().systemErrorContainerSurface());
  }

  public int getSystemErrorContainerSurfaceHigh() {
    return getArgb(new ChromaDynamicSchemeColors().systemErrorContainerSurfaceHigh());
  }

  public int getSystemErrorContainerSurfaceHighest() {
    return getArgb(new ChromaDynamicSchemeColors().systemErrorContainerSurfaceHighest());
  }

  public int getOnSystemErrorContainer() {
    return getArgb(new ChromaDynamicSchemeColors().onSystemErrorContainer());
  }

  public int getOnSystemErrorContainerVariant() {
    return getArgb(new ChromaDynamicSchemeColors().onSystemErrorContainerVariant());
  }

  public int getSystemErrorContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().systemErrorContainerOutline());
  }

  public int getSystemErrorContainerOutlineVariant() {
    return getArgb(new ChromaDynamicSchemeColors().systemErrorContainerOutlineVariant());
  }

  public int getSystemSuccessContainerSurfaceLowest() {
    return getArgb(new ChromaDynamicSchemeColors().systemSuccessContainerSurfaceLowest());
  }

  public int getSystemSuccessContainerSurfaceLow() {
    return getArgb(new ChromaDynamicSchemeColors().systemSuccessContainerSurfaceLow());
  }

  public int getSystemSuccessContainerSurface() {
    return getArgb(new ChromaDynamicSchemeColors().systemSuccessContainerSurface());
  }

  public int getSystemSuccessContainerSurfaceHigh() {
    return getArgb(new ChromaDynamicSchemeColors().systemSuccessContainerSurfaceHigh());
  }

  public int getSystemSuccessContainerSurfaceHighest() {
    return getArgb(new ChromaDynamicSchemeColors().systemSuccessContainerSurfaceHighest());
  }

  public int getOnSystemSuccessContainer() {
    return getArgb(new ChromaDynamicSchemeColors().onSystemSuccessContainer());
  }

  public int getOnSystemSuccessContainerVariant() {
    return getArgb(new ChromaDynamicSchemeColors().onSystemSuccessContainerVariant());
  }

  public int getSystemSuccessContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().systemSuccessContainerOutline());
  }

  public int getSystemSuccessContainerOutlineVariant() {
    return getArgb(new ChromaDynamicSchemeColors().systemSuccessContainerOutlineVariant());
  }

  public int getSystemEmergencyContainerSurfaceLowest() {
    return getArgb(new ChromaDynamicSchemeColors().systemEmergencyContainerSurfaceLowest());
  }

  public int getSystemEmergencyContainerSurfaceLow() {
    return getArgb(new ChromaDynamicSchemeColors().systemEmergencyContainerSurfaceLow());
  }

  public int getSystemEmergencyContainerSurface() {
    return getArgb(new ChromaDynamicSchemeColors().systemEmergencyContainerSurface());
  }

  public int getSystemEmergencyContainerSurfaceHigh() {
    return getArgb(new ChromaDynamicSchemeColors().systemEmergencyContainerSurfaceHigh());
  }

  public int getSystemEmergencyContainerSurfaceHighest() {
    return getArgb(new ChromaDynamicSchemeColors().systemEmergencyContainerSurfaceHighest());
  }

  public int getOnSystemEmergencyContainer() {
    return getArgb(new ChromaDynamicSchemeColors().onSystemEmergencyContainer());
  }

  public int getOnSystemEmergencyContainerVariant() {
    return getArgb(new ChromaDynamicSchemeColors().onSystemEmergencyContainerVariant());
  }

  public int getSystemEmergencyContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().systemEmergencyContainerOutline());
  }

  public int getSystemEmergencyContainerOutlineVariant() {
    return getArgb(new ChromaDynamicSchemeColors().systemEmergencyContainerOutlineVariant());
  }

}
