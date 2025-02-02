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
 * Provides important settings for creating colors dynamically, and a tonal palette. Requires:
 * 1. A color. (source color)
 * 2. Whether or not its dark mode.
 * 3. Contrast level. (-1 to 1, currently contrast ratio 3.0 and 7.0)
 */
public class DynamicPalette {
  public final Hct sourceColorHct;
  public final boolean isFidelity;
  public final boolean isDark;
  public final double contrastLevel;

  public final TonalPalette palette;

  public DynamicPalette(
      Hct sourceColorHct,
      boolean isFidelity,
      boolean isDark,
      double contrastLevel,
      TonalPalette palette) {

    this.sourceColorHct = sourceColorHct;

    this.isFidelity = isFidelity;
    this.isDark = isDark;
    this.contrastLevel = contrastLevel;

    this.palette = palette;
  }

  public Hct getHct(DynamicPaletteColor dynamicPaletteColor) {
    return dynamicPaletteColor.getHct(this);
  }

  public int getArgb(DynamicPaletteColor dynamicPaletteColor) {
    return dynamicPaletteColor.getArgb(this);
  }

  public int getSurface() {
    return getArgb(new ChromaDynamicPaletteColors().surface());
  }

  public int getSurfaceDim() {
    return getArgb(new ChromaDynamicPaletteColors().surfaceDim());
  }

  public int getSurfaceBright() {
    return getArgb(new ChromaDynamicPaletteColors().surfaceBright());
  }

  public int getInverseSurface() {
    return getArgb(new ChromaDynamicPaletteColors().inverseSurface());
  }

  public int getTonalContainerSurfaceLowest() {
    return getArgb(new ChromaDynamicPaletteColors().tonalContainerSurfaceLowest());
  }

  public int getTonalContainerSurfaceLow() {
    return getArgb(new ChromaDynamicPaletteColors().tonalContainerSurfaceLow());
  }

  public int getTonalContainerSurface() {
    return getArgb(new ChromaDynamicPaletteColors().tonalContainerSurface());
  }

  public int getTonalContainerSurfaceHigh() {
    return getArgb(new ChromaDynamicPaletteColors().tonalContainerSurfaceHigh());
  }

  public int getTonalContainerSurfaceHighest() {
    return getArgb(new ChromaDynamicPaletteColors().tonalContainerSurfaceHighest());
  }

  public int getOnTonalContainer() {
    return getArgb(new ChromaDynamicPaletteColors().onTonalContainer());
  }

  public int getOnTonalContainerVariant() {
    return getArgb(new ChromaDynamicPaletteColors().onTonalContainerVariant());
  }

  public int getTonalContainerOutline() {
    return getArgb(new ChromaDynamicPaletteColors().tonalContainerOutline());
  }

  public int getTonalContainerOutlineVariant() {
    return getArgb(new ChromaDynamicPaletteColors().tonalContainerOutlineVariant());
  }

  public int getInverseTonalContainerSurface() {
    return getArgb(new ChromaDynamicPaletteColors().inverseTonalContainerSurface());
  }

  public int getInverseOnTonalContainer() {
    return getArgb(new ChromaDynamicPaletteColors().inverseOnTonalContainer());
  }

  public int getInverseTonalContainerOutline() {
    return getArgb(new ChromaDynamicPaletteColors().inverseTonalContainerOutline());
  }

  public int getComplementaryTonalContainerOutline() {
    return getArgb(new ChromaDynamicPaletteColors().complementaryTonalContainerOutline());
  }

  public int getPrimaryContainerSurfaceLowest() {
    return getArgb(new ChromaDynamicPaletteColors().primaryContainerSurfaceLowest());
  }

  public int getPrimaryContainerSurfaceLow() {
    return getArgb(new ChromaDynamicPaletteColors().primaryContainerSurfaceLow());
  }

  public int getPrimaryContainerSurface() {
    return getArgb(new ChromaDynamicPaletteColors().primaryContainerSurface());
  }

  public int getPrimaryContainerSurfaceHigh() {
    return getArgb(new ChromaDynamicPaletteColors().primaryContainerSurfaceHigh());
  }

  public int getPrimaryContainerSurfaceHighest() {
    return getArgb(new ChromaDynamicPaletteColors().primaryContainerSurfaceHighest());
  }

  public int getOnPrimaryContainer() {
    return getArgb(new ChromaDynamicPaletteColors().onPrimaryContainer());
  }

  public int getOnPrimaryContainerVariant() {
    return getArgb(new ChromaDynamicPaletteColors().onPrimaryContainerVariant());
  }

  public int getPrimaryContainerOutline() {
    return getArgb(new ChromaDynamicPaletteColors().primaryContainerOutline());
  }

  public int getPrimaryContainerOutlineVariant() {
    return getArgb(new ChromaDynamicPaletteColors().primaryContainerOutlineVariant());
  }

  public int getInversePrimaryContainerSurface() {
    return getArgb(new ChromaDynamicPaletteColors().inversePrimaryContainerSurface());
  }

  public int getInverseOnPrimaryContainer() {
    return getArgb(new ChromaDynamicPaletteColors().inverseOnPrimaryContainer());
  }

  public int getInversePrimaryContainerOutline() {
    return getArgb(new ChromaDynamicPaletteColors().inversePrimaryContainerOutline());
  }

  public int getComplementaryPrimaryContainerOutline() {
    return getArgb(new ChromaDynamicPaletteColors().complementaryPrimaryContainerOutline());
  }
}
