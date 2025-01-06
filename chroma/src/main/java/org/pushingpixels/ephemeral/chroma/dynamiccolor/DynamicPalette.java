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

  public int getContainerSurfaceLowest() {
    return getArgb(new ChromaDynamicPaletteColors().containerSurfaceLowest());
  }

  public int getContainerSurfaceLow() {
    return getArgb(new ChromaDynamicPaletteColors().containerSurfaceLow());
  }

  public int getContainerSurface() {
    return getArgb(new ChromaDynamicPaletteColors().containerSurface());
  }

  public int getContainerSurfaceHigh() {
    return getArgb(new ChromaDynamicPaletteColors().containerSurfaceHigh());
  }

  public int getContainerSurfaceHighest() {
    return getArgb(new ChromaDynamicPaletteColors().containerSurfaceHighest());
  }

  public int getOnContainer() {
    return getArgb(new ChromaDynamicPaletteColors().onContainer());
  }

  public int getOnContainerVariant() {
    return getArgb(new ChromaDynamicPaletteColors().onContainerVariant());
  }

  public int getContainerOutline() {
    return getArgb(new ChromaDynamicPaletteColors().containerOutline());
  }

  public int getContainerOutlineVariant() {
    return getArgb(new ChromaDynamicPaletteColors().containerOutlineVariant());
  }
}
