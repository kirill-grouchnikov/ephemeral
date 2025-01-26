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
  public final Hct primarySourceColorHct;
  public final Hct mutedSourceColorHct;
  public final Hct neutralSourceColorHct;
  public final boolean isFidelity;
  public final boolean isPrimaryDark;
  public final boolean isMutedDark;
  public final boolean isNeutralDark;
  public final double contrastLevel;

  public final TonalPalette primaryPalette;
  public final TonalPalette mutedPalette;
  public final TonalPalette neutralPalette;

  public DynamicScheme(
      Hct primarySourceColorHct,
      Hct mutedSourceColorHct,
      Hct neutralSourceColorHct,
      boolean isFidelity,
      boolean isPrimaryDark,
      boolean isMutedDark,
      boolean isNeutralDark,
      double contrastLevel,
      TonalPalette primaryPalette,
      TonalPalette mutedPalette,
      TonalPalette neutralPalette) {

    this.primarySourceColorHct = primarySourceColorHct;
    this.mutedSourceColorHct = mutedSourceColorHct;
    this.neutralSourceColorHct = neutralSourceColorHct;

    this.isFidelity = isFidelity;
    this.isPrimaryDark = isPrimaryDark;
    this.isMutedDark = isMutedDark;
    this.isNeutralDark = isNeutralDark;
    this.contrastLevel = contrastLevel;

    this.primaryPalette = primaryPalette;
    this.mutedPalette = mutedPalette;
    this.neutralPalette = neutralPalette;
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

  public Hct getHct(DynamicSchemeColor dynamicSchemeColor, Function<DynamicScheme, Boolean> isDark) {
    return dynamicSchemeColor.getHct(this, isDark);
  }

  public int getArgb(DynamicSchemeColor dynamicSchemeColor, Function<DynamicScheme, Boolean> isDark) {
    return dynamicSchemeColor.getArgb(this, isDark);
  }

  public int getSurface() {
    return getArgb(new ChromaDynamicSchemeColors().surface(), (s) -> isNeutralDark);
  }

  public int getSurfaceDim() {
    return getArgb(new ChromaDynamicSchemeColors().surfaceDim(), (s) -> isNeutralDark);
  }

  public int getSurfaceBright() {
    return getArgb(new ChromaDynamicSchemeColors().surfaceBright(), (s) -> isNeutralDark);
  }
  
  public int getInverseSurface() {
    return getArgb(new ChromaDynamicSchemeColors().inverseSurface(), (s) -> isNeutralDark);
  }

  public int getNeutralContainerSurfaceLowest() {
    return getArgb(new ChromaDynamicSchemeColors().neutralContainerSurfaceLowest(), (s) -> isNeutralDark);
  }

  public int getNeutralContainerSurfaceLow() {
    return getArgb(new ChromaDynamicSchemeColors().neutralContainerSurfaceLow(), (s) -> isNeutralDark);
  }

  public int getNeutralContainerSurface() {
    return getArgb(new ChromaDynamicSchemeColors().neutralContainerSurface(), (s) -> isNeutralDark);
  }

  public int getNeutralContainerSurfaceHigh() {
    return getArgb(new ChromaDynamicSchemeColors().neutralContainerSurfaceHigh(), (s) -> isNeutralDark);
  }

  public int getNeutralContainerSurfaceHighest() {
    return getArgb(new ChromaDynamicSchemeColors().neutralContainerSurfaceHighest(), (s) -> isNeutralDark);
  }

  public int getOnNeutralContainer() {
    return getArgb(new ChromaDynamicSchemeColors().onNeutralContainer(), (s) -> isNeutralDark);
  }

  public int getOnNeutralContainerVariant() {
    return getArgb(new ChromaDynamicSchemeColors().onNeutralContainerVariant(), (s) -> isNeutralDark);
  }

  public int getNeutralContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().neutralContainerOutline(), (s) -> isNeutralDark);
  }

  public int getNeutralContainerOutlineVariant() {
    return getArgb(new ChromaDynamicSchemeColors().neutralContainerOutlineVariant(), (s) -> isNeutralDark);
  }

  public int getInverseNeutralContainerSurface() {
    return getArgb(new ChromaDynamicSchemeColors().inverseNeutralContainerSurface(), (s) -> isNeutralDark);
  }

  public int getInverseOnNeutralContainer() {
    return getArgb(new ChromaDynamicSchemeColors().inverseOnNeutralContainer(), (s) -> isNeutralDark);
  }

  public int getInverseNeutralContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().inverseNeutralContainerOutline(), (s) -> isNeutralDark);
  }

  public int getMutedContainerSurfaceLowest() {
    return getArgb(new ChromaDynamicSchemeColors().mutedContainerSurfaceLowest(), (s) -> isMutedDark);
  }

  public int getMutedContainerSurfaceLow() {
    return getArgb(new ChromaDynamicSchemeColors().mutedContainerSurfaceLow(), (s) -> isMutedDark);
  }

  public int getMutedContainerSurface() {
    return getArgb(new ChromaDynamicSchemeColors().mutedContainerSurface(), (s) -> isMutedDark);
  }

  public int getMutedContainerSurfaceHigh() {
    return getArgb(new ChromaDynamicSchemeColors().mutedContainerSurfaceHigh(), (s) -> isMutedDark);
  }

  public int getMutedContainerSurfaceHighest() {
    return getArgb(new ChromaDynamicSchemeColors().mutedContainerSurfaceHighest(), (s) -> isMutedDark);
  }

  public int getOnMutedContainer() {
    return getArgb(new ChromaDynamicSchemeColors().onMutedContainer(), (s) -> isMutedDark);
  }

  public int getOnMutedContainerVariant() {
    return getArgb(new ChromaDynamicSchemeColors().onMutedContainerVariant(), (s) -> isMutedDark);
  }

  public int getMutedContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().mutedContainerOutline(), (s) -> isMutedDark);
  }

  public int getMutedContainerOutlineVariant() {
    return getArgb(new ChromaDynamicSchemeColors().mutedContainerOutlineVariant(), (s) -> isMutedDark);
  }

  public int getInverseMutedContainerSurface() {
    return getArgb(new ChromaDynamicSchemeColors().inverseMutedContainerSurface(), (s) -> isMutedDark);
  }

  public int getInverseOnMutedContainer() {
    return getArgb(new ChromaDynamicSchemeColors().inverseOnMutedContainer(), (s) -> isMutedDark);
  }

  public int getInverseMutedContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().inverseMutedContainerOutline(), (s) -> isMutedDark);
  }

  public int getTonalContainerSurfaceLowest() {
    return getArgb(new ChromaDynamicSchemeColors().tonalContainerSurfaceLowest(), (s) -> isPrimaryDark);
  }

  public int getTonalContainerSurfaceLow() {
    return getArgb(new ChromaDynamicSchemeColors().tonalContainerSurfaceLow(), (s) -> isPrimaryDark);
  }

  public int getTonalContainerSurface() {
    return getArgb(new ChromaDynamicSchemeColors().tonalContainerSurface(), (s) -> isPrimaryDark);
  }

  public int getTonalContainerSurfaceHigh() {
    return getArgb(new ChromaDynamicSchemeColors().tonalContainerSurfaceHigh(), (s) -> isPrimaryDark);
  }

  public int getTonalContainerSurfaceHighest() {
    return getArgb(new ChromaDynamicSchemeColors().tonalContainerSurfaceHighest(), (s) -> isPrimaryDark);
  }

  public int getOnTonalContainer() {
    return getArgb(new ChromaDynamicSchemeColors().onTonalContainer(), (s) -> isPrimaryDark);
  }

  public int getOnTonalContainerVariant() {
    return getArgb(new ChromaDynamicSchemeColors().onTonalContainerVariant(), (s) -> isPrimaryDark);
  }

  public int getTonalContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().tonalContainerOutline(), (s) -> isPrimaryDark);
  }

  public int getTonalContainerOutlineVariant() {
    return getArgb(new ChromaDynamicSchemeColors().tonalContainerOutlineVariant(), (s) -> isPrimaryDark);
  }
  
  public int getInverseTonalContainerSurface() {
    return getArgb(new ChromaDynamicSchemeColors().inverseTonalContainerSurface(), (s) -> isPrimaryDark);
  }

  public int getInverseOnTonalContainer() {
    return getArgb(new ChromaDynamicSchemeColors().inverseOnTonalContainer(), (s) -> isPrimaryDark);
  }

  public int getInverseTonalContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().inverseTonalContainerOutline(), (s) -> isPrimaryDark);
  }

  public int getPrimaryContainerSurfaceLowest() {
    return getArgb(new ChromaDynamicSchemeColors().primaryContainerSurfaceLowest(), (s) -> isPrimaryDark);
  }

  public int getPrimaryContainerSurfaceLow() {
    return getArgb(new ChromaDynamicSchemeColors().primaryContainerSurfaceLow(), (s) -> isPrimaryDark);
  }

  public int getPrimaryContainerSurface() {
    return getArgb(new ChromaDynamicSchemeColors().primaryContainerSurface(), (s) -> isPrimaryDark);
  }

  public int getPrimaryContainerSurfaceHigh() {
    return getArgb(new ChromaDynamicSchemeColors().primaryContainerSurfaceHigh(), (s) -> isPrimaryDark);
  }

  public int getPrimaryContainerSurfaceHighest() {
    return getArgb(new ChromaDynamicSchemeColors().primaryContainerSurfaceHighest(), (s) -> isPrimaryDark);
  }

  public int getOnPrimaryContainer() {
    return getArgb(new ChromaDynamicSchemeColors().onPrimaryContainer(), (s) -> isPrimaryDark);
  }

  public int getOnPrimaryContainerVariant() {
    return getArgb(new ChromaDynamicSchemeColors().onPrimaryContainerVariant(), (s) -> isPrimaryDark);
  }

  public int getPrimaryContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().primaryContainerOutline(), (s) -> isPrimaryDark);
  }

  public int getPrimaryContainerOutlineVariant() {
    return getArgb(new ChromaDynamicSchemeColors().primaryContainerOutlineVariant(), (s) -> isPrimaryDark);
  }

  public int getInversePrimaryContainerSurface() {
    return getArgb(new ChromaDynamicSchemeColors().inversePrimaryContainerSurface(), (s) -> isPrimaryDark);
  }

  public int getInverseOnPrimaryContainer() {
    return getArgb(new ChromaDynamicSchemeColors().inverseOnPrimaryContainer(), (s) -> isPrimaryDark);
  }

  public int getInversePrimaryContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().inversePrimaryContainerOutline(), (s) -> isPrimaryDark);
  }
}
