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
import org.pushingpixels.ephemeral.chroma.palettes.TokenPalette;
import org.pushingpixels.ephemeral.chroma.palettes.TonalPalette;

// This is a modified version of the original source code, changed to fit the Chroma needs

/**
 * Provides important settings for creating colors dynamically, and a tonal palette. Requires:
 * 1. A color. (source color)
 * 2. Whether or not its dark mode.
 * 3. Contrast level. (-1 to 1, currently contrast ratio 3.0 and 7.0)
 */
public class DynamicPalette implements TokenPalette {
  public final ContainerConfiguration containerConfiguration;
  public final TonalPalette palette;
  public final double sourceColorTone;

  public DynamicPalette(
      Hct sourceColorHct,
      ContainerConfiguration containerConfiguration) {
    this.containerConfiguration = containerConfiguration;

    this.palette = TonalPalette.fromHct(sourceColorHct);
    this.sourceColorTone = sourceColorHct.getTone();
  }

  public Hct getHct(DynamicPaletteColor dynamicPaletteColor) {
    return dynamicPaletteColor.getHct(this);
  }

  public int getArgb(DynamicPaletteColor dynamicPaletteColor) {
    return dynamicPaletteColor.getArgb(this);
  }

  @Override
  public int getContainerSurfaceLowest() {
    return getArgb(new ChromaDynamicPaletteColors().containerSurfaceLowest());
  }

  @Override
  public int getContainerSurfaceLow() {
    return getArgb(new ChromaDynamicPaletteColors().containerSurfaceLow());
  }

  @Override
  public int getContainerSurface() {
    return getArgb(new ChromaDynamicPaletteColors().containerSurface());
  }

  @Override
  public int getContainerSurfaceHigh() {
    return getArgb(new ChromaDynamicPaletteColors().containerSurfaceHigh());
  }

  @Override
  public int getContainerSurfaceHighest() {
    return getArgb(new ChromaDynamicPaletteColors().containerSurfaceHighest());
  }

  @Override
  public int getContainerSurfaceDim() {
    return getArgb(new ChromaDynamicPaletteColors().containerSurfaceDim());
  }

  @Override
  public int getContainerSurfaceBright() {
    return getArgb(new ChromaDynamicPaletteColors().containerSurfaceBright());
  }

  @Override
  public int getOnContainer() {
    return getArgb(new ChromaDynamicPaletteColors().onContainer());
  }

  @Override
  public int getOnContainerVariant() {
    return getArgb(new ChromaDynamicPaletteColors().onContainerVariant());
  }

  @Override
  public int getContainerOutline() {
    return getArgb(new ChromaDynamicPaletteColors().containerOutline());
  }

  @Override
  public int getContainerOutlineVariant() {
    return getArgb(new ChromaDynamicPaletteColors().containerOutlineVariant());
  }

  @Override
  public int getInverseContainerSurface() {
    return getArgb(new ChromaDynamicPaletteColors().inverseContainerSurface());
  }

  @Override
  public int getInverseOnContainer() {
    return getArgb(new ChromaDynamicPaletteColors().inverseOnContainer());
  }

  @Override
  public int getInverseContainerOutline() {
    return getArgb(new ChromaDynamicPaletteColors().inverseContainerOutline());
  }

  @Override
  public int getComplementaryContainerOutline() {
    return getArgb(new ChromaDynamicPaletteColors().complementaryContainerOutline());
  }

  @Override
  public int getComplementaryOnContainer() {
    return getArgb(new ChromaDynamicPaletteColors().complementaryOnContainer());
  }

  @Override
  public int getAccentOnContainer() {
    return getArgb(new ChromaDynamicPaletteColors().accentOnContainer());
  }
}
