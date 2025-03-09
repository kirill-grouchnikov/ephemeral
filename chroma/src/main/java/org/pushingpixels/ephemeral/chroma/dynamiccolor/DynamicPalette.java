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
  public final boolean isDark;
  public final double contrastLevel;
  public final TonalPalette palette;
  public final double sourceColorTone;

  public DynamicPalette(
      Hct sourceColorHct,
      boolean isDark,
      double contrastLevel) {
    this.isDark = isDark;
    this.contrastLevel = contrastLevel;

    this.palette = TonalPalette.fromHct(sourceColorHct);
    this.sourceColorTone = sourceColorHct.getTone();
  }

  public Hct getHct(DynamicPaletteColor dynamicPaletteColor) {
    return dynamicPaletteColor.getHct(this);
  }

  public int getArgb(DynamicPaletteColor dynamicPaletteColor) {
    return dynamicPaletteColor.getArgb(this);
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

  public int getTonalContainerSurfaceDim() {
    return getArgb(new ChromaDynamicPaletteColors().tonalContainerSurfaceDim());
  }

  public int getTonalContainerSurfaceBright() {
    return getArgb(new ChromaDynamicPaletteColors().tonalContainerSurfaceBright());
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

  public int getComplementaryOnTonalContainer() {
    return getArgb(new ChromaDynamicPaletteColors().complementaryOnTonalContainer());
  }
}
