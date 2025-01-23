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

  public DynamicScheme(
      Hct primarySourceColorHct,
      Hct mutedSourceColorHct,
      Hct neutralSourceColorHct,
      boolean isFidelity,
      boolean isDark,
      double contrastLevel,
      TonalPalette primaryPalette,
      TonalPalette mutedPalette,
      TonalPalette neutralPalette) {

    this.primarySourceColorHct = primarySourceColorHct;
    this.mutedSourceColorHct = mutedSourceColorHct;
    this.neutralSourceColorHct = neutralSourceColorHct;

    this.isFidelity = isFidelity;
    this.isDark = isDark;
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
  
  public int getInverseSurface() {
    return getArgb(new ChromaDynamicSchemeColors().inverseSurface());
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

  public int getInverseNeutralContainerSurface() {
    return getArgb(new ChromaDynamicSchemeColors().inverseNeutralContainerSurface());
  }

  public int getInverseOnNeutralContainer() {
    return getArgb(new ChromaDynamicSchemeColors().inverseOnNeutralContainer());
  }

  public int getInverseNeutralContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().inverseNeutralContainerOutline());
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

  public int getInverseMutedContainerSurface() {
    return getArgb(new ChromaDynamicSchemeColors().inverseMutedContainerSurface());
  }

  public int getInverseOnMutedContainer() {
    return getArgb(new ChromaDynamicSchemeColors().inverseOnMutedContainer());
  }

  public int getInverseMutedContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().inverseMutedContainerOutline());
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
  
  public int getInverseTonalContainerSurface() {
    return getArgb(new ChromaDynamicSchemeColors().inverseTonalContainerSurface());
  }

  public int getInverseOnTonalContainer() {
    return getArgb(new ChromaDynamicSchemeColors().inverseOnTonalContainer());
  }

  public int getInverseTonalContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().inverseTonalContainerOutline());
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

  public int getInversePrimaryContainerSurface() {
    return getArgb(new ChromaDynamicSchemeColors().inversePrimaryContainerSurface());
  }

  public int getInverseOnPrimaryContainer() {
    return getArgb(new ChromaDynamicSchemeColors().inverseOnPrimaryContainer());
  }

  public int getInversePrimaryContainerOutline() {
    return getArgb(new ChromaDynamicSchemeColors().inversePrimaryContainerOutline());
  }
}
