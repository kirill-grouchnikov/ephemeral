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

import java.util.function.Function;

// This is a modified version of the original source code, changed to fit the Chroma needs

/**
 * Provides important settings for creating colors dynamically, and 8 tonal palettes. Requires:
 * 1. A color. (source color)
 * 2. Whether or not its dark mode.
 * 3. Contrast level. (-1 to 1, currently contrast ratio 3.0 and 7.0)
 */
public class DynamicScheme {
  public final double primarySourceColorTone;
  public final double mutedSourceColorTone;
  public final double neutralSourceColorTone;
  public final boolean isFidelity;
  public final boolean isPrimaryDark;
  public final boolean isTonalDark;
  public final boolean isMutedDark;
  public final boolean isNeutralDark;
  public final double primaryContrastLevel;
  public final double tonalContrastLevel;
  public final double mutedContrastLevel;
  public final double neutralContrastLevel;

  public final TonalPalette primaryPalette;
  public final TonalPalette mutedPalette;
  public final TonalPalette neutralPalette;

  public DynamicScheme(
      TonalPalette primaryPalette,
      TonalPalette mutedPalette,
      TonalPalette neutralPalette,
      double primarySourceColorTone,
      double mutedSourceColorTone,
      double neutralSourceColorTone,
      boolean isFidelity,
      boolean isPrimaryDark,
      boolean isTonalDark,
      boolean isMutedDark,
      boolean isNeutralDark,
      double primaryContrastLevel,
      double tonalContrastLevel,
      double mutedContrastLevel,
      double neutralContrastLevel) {

    this.primaryPalette = primaryPalette;
    this.mutedPalette = mutedPalette;
    this.neutralPalette = neutralPalette;

    this.primarySourceColorTone = primarySourceColorTone;
    this.mutedSourceColorTone = mutedSourceColorTone;
    this.neutralSourceColorTone = neutralSourceColorTone;

    this.isFidelity = isFidelity;

    this.isPrimaryDark = isPrimaryDark;
    this.isTonalDark = isTonalDark;
    this.isMutedDark = isMutedDark;
    this.isNeutralDark = isNeutralDark;

    this.primaryContrastLevel = primaryContrastLevel;
    this.tonalContrastLevel = tonalContrastLevel;
    this.mutedContrastLevel = mutedContrastLevel;
    this.neutralContrastLevel = neutralContrastLevel;
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

  public Hct getHct(DynamicSchemeColor dynamicSchemeColor, Function<DynamicScheme, Boolean> isDark,
      Function<DynamicScheme, Double> contrastLevel) {
    return dynamicSchemeColor.getHct(this, isDark, contrastLevel);
  }

  public int getArgb(DynamicSchemeColor dynamicSchemeColor, Function<DynamicScheme, Boolean> isDark,
      Function<DynamicScheme, Double> contrastLevel) {
    return dynamicSchemeColor.getArgb(this, isDark, contrastLevel);
  }

  public int getSurface() {
    return getArgb(new ChromaDynamicSchemeColors().surface(), (s) -> isNeutralDark, (s) -> neutralContrastLevel);
  }

  public int getSurfaceDim() {
    return getArgb(new ChromaDynamicSchemeColors().surfaceDim(), (s) -> isNeutralDark, (s) -> neutralContrastLevel);
  }

  public int getSurfaceBright() {
    return getArgb(new ChromaDynamicSchemeColors().surfaceBright(), (s) -> isNeutralDark, (s) -> neutralContrastLevel);
  }
  
  public int getInverseSurface() {
    return getArgb(new ChromaDynamicSchemeColors().inverseSurface(), (s) -> isNeutralDark, (s) -> neutralContrastLevel);
  }

  public int getNeutralContainerSurfaceLowest() {
    return getArgb(new ChromaDynamicSchemeColors().neutralContainerSurfaceLowest(), (s) -> isNeutralDark, (s) -> neutralContrastLevel);
  }

  public int getNeutralContainerSurfaceLow() {
    return getArgb(new ChromaDynamicSchemeColors().neutralContainerSurfaceLow(), (s) -> isNeutralDark, (s) -> neutralContrastLevel);
  }

  public int getNeutralContainerSurface() {
    return getArgb(new ChromaDynamicSchemeColors().neutralContainerSurface(), (s) -> isNeutralDark, (s) -> neutralContrastLevel);
  }

  public int getNeutralContainerSurfaceHigh() {
    return getArgb(new ChromaDynamicSchemeColors().neutralContainerSurfaceHigh(), (s) -> isNeutralDark, (s) -> neutralContrastLevel);
  }

  public int getNeutralContainerSurfaceHighest() {
    return getArgb(new ChromaDynamicSchemeColors().neutralContainerSurfaceHighest(), (s) -> isNeutralDark, (s) -> neutralContrastLevel);
  }

  public int getOnNeutralContainer() {
    return getArgb(new ChromaDynamicSchemeColors().onNeutralContainer(), (s) -> isNeutralDark, (s) -> neutralContrastLevel);
  }

  public int getOnNeutralContainerVariant() {
    return getArgb(new ChromaDynamicSchemeColors().onNeutralContainerVariant(), (s) -> isNeutralDark, (s) -> neutralContrastLevel);
  }

  public int getNeutralContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().neutralContainerOutline(), (s) -> isNeutralDark, (s) -> neutralContrastLevel);
  }

  public int getNeutralContainerOutlineVariant() {
    return getArgb(new ChromaDynamicSchemeColors().neutralContainerOutlineVariant(), (s) -> isNeutralDark, (s) -> neutralContrastLevel);
  }

  public int getInverseNeutralContainerSurface() {
    return getArgb(new ChromaDynamicSchemeColors().inverseNeutralContainerSurface(), (s) -> isNeutralDark, (s) -> neutralContrastLevel);
  }

  public int getInverseOnNeutralContainer() {
    return getArgb(new ChromaDynamicSchemeColors().inverseOnNeutralContainer(), (s) -> isNeutralDark, (s) -> neutralContrastLevel);
  }

  public int getInverseNeutralContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().inverseNeutralContainerOutline(), (s) -> isNeutralDark, (s) -> neutralContrastLevel);
  }

  public int getComplementaryOnNeutralContainer() {
    return getArgb(new ChromaDynamicSchemeColors().complementaryOnNeutralContainer(), (s) -> isNeutralDark, (s) -> neutralContrastLevel);
  }

  public int getComplementaryNeutralContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().complementaryNeutralContainerOutline(), (s) -> isNeutralDark, (s) -> neutralContrastLevel);
  }

  public int getMutedContainerSurfaceLowest() {
    return getArgb(new ChromaDynamicSchemeColors().mutedContainerSurfaceLowest(), (s) -> isMutedDark, (s) -> mutedContrastLevel);
  }

  public int getMutedContainerSurfaceLow() {
    return getArgb(new ChromaDynamicSchemeColors().mutedContainerSurfaceLow(), (s) -> isMutedDark, (s) -> mutedContrastLevel);
  }

  public int getMutedContainerSurface() {
    return getArgb(new ChromaDynamicSchemeColors().mutedContainerSurface(), (s) -> isMutedDark, (s) -> mutedContrastLevel);
  }

  public int getMutedContainerSurfaceHigh() {
    return getArgb(new ChromaDynamicSchemeColors().mutedContainerSurfaceHigh(), (s) -> isMutedDark, (s) -> mutedContrastLevel);
  }

  public int getMutedContainerSurfaceHighest() {
    return getArgb(new ChromaDynamicSchemeColors().mutedContainerSurfaceHighest(), (s) -> isMutedDark, (s) -> mutedContrastLevel);
  }

  public int getOnMutedContainer() {
    return getArgb(new ChromaDynamicSchemeColors().onMutedContainer(), (s) -> isMutedDark, (s) -> mutedContrastLevel);
  }

  public int getOnMutedContainerVariant() {
    return getArgb(new ChromaDynamicSchemeColors().onMutedContainerVariant(), (s) -> isMutedDark, (s) -> mutedContrastLevel);
  }

  public int getMutedContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().mutedContainerOutline(), (s) -> isMutedDark, (s) -> mutedContrastLevel);
  }

  public int getMutedContainerOutlineVariant() {
    return getArgb(new ChromaDynamicSchemeColors().mutedContainerOutlineVariant(), (s) -> isMutedDark, (s) -> mutedContrastLevel);
  }

  public int getInverseMutedContainerSurface() {
    return getArgb(new ChromaDynamicSchemeColors().inverseMutedContainerSurface(), (s) -> isMutedDark, (s) -> mutedContrastLevel);
  }

  public int getInverseOnMutedContainer() {
    return getArgb(new ChromaDynamicSchemeColors().inverseOnMutedContainer(), (s) -> isMutedDark, (s) -> mutedContrastLevel);
  }

  public int getInverseMutedContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().inverseMutedContainerOutline(), (s) -> isMutedDark, (s) -> mutedContrastLevel);
  }

  public int getComplementaryOnMutedContainer() {
    return getArgb(new ChromaDynamicSchemeColors().complementaryOnMutedContainer(), (s) -> isMutedDark, (s) -> mutedContrastLevel);
  }

  public int getComplementaryMutedContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().complementaryMutedContainerOutline(), (s) -> isMutedDark, (s) -> mutedContrastLevel);
  }

  public int getTonalContainerSurfaceLowest() {
    return getArgb(new ChromaDynamicSchemeColors().tonalContainerSurfaceLowest(), (s) -> isTonalDark, (s) -> tonalContrastLevel);
  }

  public int getTonalContainerSurfaceLow() {
    return getArgb(new ChromaDynamicSchemeColors().tonalContainerSurfaceLow(), (s) -> isTonalDark, (s) -> tonalContrastLevel);
  }

  public int getTonalContainerSurface() {
    return getArgb(new ChromaDynamicSchemeColors().tonalContainerSurface(), (s) -> isTonalDark, (s) -> tonalContrastLevel);
  }

  public int getTonalContainerSurfaceHigh() {
    return getArgb(new ChromaDynamicSchemeColors().tonalContainerSurfaceHigh(), (s) -> isTonalDark, (s) -> tonalContrastLevel);
  }

  public int getTonalContainerSurfaceHighest() {
    return getArgb(new ChromaDynamicSchemeColors().tonalContainerSurfaceHighest(), (s) -> isTonalDark, (s) -> tonalContrastLevel);
  }

  public int getOnTonalContainer() {
    return getArgb(new ChromaDynamicSchemeColors().onTonalContainer(), (s) -> isTonalDark, (s) -> tonalContrastLevel);
  }

  public int getOnTonalContainerVariant() {
    return getArgb(new ChromaDynamicSchemeColors().onTonalContainerVariant(), (s) -> isTonalDark, (s) -> tonalContrastLevel);
  }

  public int getTonalContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().tonalContainerOutline(), (s) -> isTonalDark, (s) -> tonalContrastLevel);
  }

  public int getTonalContainerOutlineVariant() {
    return getArgb(new ChromaDynamicSchemeColors().tonalContainerOutlineVariant(), (s) -> isTonalDark, (s) -> tonalContrastLevel);
  }
  
  public int getInverseTonalContainerSurface() {
    return getArgb(new ChromaDynamicSchemeColors().inverseTonalContainerSurface(), (s) -> isTonalDark, (s) -> tonalContrastLevel);
  }

  public int getInverseOnTonalContainer() {
    return getArgb(new ChromaDynamicSchemeColors().inverseOnTonalContainer(), (s) -> isTonalDark, (s) -> tonalContrastLevel);
  }

  public int getInverseTonalContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().inverseTonalContainerOutline(), (s) -> isTonalDark, (s) -> tonalContrastLevel);
  }

  public int getComplementaryOnTonalContainer() {
    return getArgb(new ChromaDynamicSchemeColors().complementaryOnTonalContainer(), (s) -> isTonalDark, (s) -> tonalContrastLevel);
  }

  public int getComplementaryTonalContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().complementaryTonalContainerOutline(), (s) -> isTonalDark, (s) -> tonalContrastLevel);
  }

  public int getPrimaryContainerSurfaceLowest() {
    return getArgb(new ChromaDynamicSchemeColors().primaryContainerSurfaceLowest(), (s) -> isPrimaryDark, (s) -> primaryContrastLevel);
  }

  public int getPrimaryContainerSurfaceLow() {
    return getArgb(new ChromaDynamicSchemeColors().primaryContainerSurfaceLow(), (s) -> isPrimaryDark, (s) -> primaryContrastLevel);
  }

  public int getPrimaryContainerSurface() {
    return getArgb(new ChromaDynamicSchemeColors().primaryContainerSurface(), (s) -> isPrimaryDark, (s) -> primaryContrastLevel);
  }

  public int getPrimaryContainerSurfaceHigh() {
    return getArgb(new ChromaDynamicSchemeColors().primaryContainerSurfaceHigh(), (s) -> isPrimaryDark, (s) -> primaryContrastLevel);
  }

  public int getPrimaryContainerSurfaceHighest() {
    return getArgb(new ChromaDynamicSchemeColors().primaryContainerSurfaceHighest(), (s) -> isPrimaryDark, (s) -> primaryContrastLevel);
  }

  public int getOnPrimaryContainer() {
    return getArgb(new ChromaDynamicSchemeColors().onPrimaryContainer(), (s) -> isPrimaryDark, (s) -> primaryContrastLevel);
  }

  public int getOnPrimaryContainerVariant() {
    return getArgb(new ChromaDynamicSchemeColors().onPrimaryContainerVariant(), (s) -> isPrimaryDark, (s) -> primaryContrastLevel);
  }

  public int getPrimaryContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().primaryContainerOutline(), (s) -> isPrimaryDark, (s) -> primaryContrastLevel);
  }

  public int getPrimaryContainerOutlineVariant() {
    return getArgb(new ChromaDynamicSchemeColors().primaryContainerOutlineVariant(), (s) -> isPrimaryDark, (s) -> primaryContrastLevel);
  }

  public int getInversePrimaryContainerSurface() {
    return getArgb(new ChromaDynamicSchemeColors().inversePrimaryContainerSurface(), (s) -> isPrimaryDark, (s) -> primaryContrastLevel);
  }

  public int getInverseOnPrimaryContainer() {
    return getArgb(new ChromaDynamicSchemeColors().inverseOnPrimaryContainer(), (s) -> isPrimaryDark, (s) -> primaryContrastLevel);
  }

  public int getInversePrimaryContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().inversePrimaryContainerOutline(), (s) -> isPrimaryDark, (s) -> primaryContrastLevel);
  }

  public int getComplementaryOnPrimaryContainer() {
    return getArgb(new ChromaDynamicSchemeColors().complementaryOnPrimaryContainer(), (s) -> isPrimaryDark, (s) -> primaryContrastLevel);
  }

  public int getComplementaryPrimaryContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().complementaryPrimaryContainerOutline(), (s) -> isPrimaryDark, (s) -> primaryContrastLevel);
  }
}
