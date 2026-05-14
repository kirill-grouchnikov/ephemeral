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
 * A primary entry point for duotone palettes.
 * 1. Two source colors, one for container colors and one for on-container colors.
 * 2. Container configuration (dark mode, contrast level, ...)
 */
public class DuotonePalette implements TokenPalette {
  public final TonalPalette containerPalette;
  public final TonalPalette onContainerPalette;
  public final double containerSourceColorTone;
  public final double onContainerSourceColorTone;
  public final ContainerConfiguration containerConfiguration;

  public DuotonePalette(
      Hct seedContainer,
      Hct seedOnContainer,
      ContainerConfiguration containerConfiguration) {
    this.containerConfiguration = containerConfiguration;

    this.containerPalette = TonalPalette.fromHct(seedContainer);
    this.onContainerPalette = TonalPalette.fromHct(seedOnContainer);
    this.containerSourceColorTone = seedContainer.getTone();
    this.onContainerSourceColorTone = seedOnContainer.getTone();
  }

  public int getArgb(DuotonePaletteColor dynamicPaletteColor) {
    return dynamicPaletteColor.getArgb(this);
  }

  @Override
  public int getContainerSurfaceLowest() {
    return getArgb(new ChromaDuotonePaletteColors().containerSurfaceLowest());
  }

  @Override
  public int getContainerSurfaceLow() {
    return getArgb(new ChromaDuotonePaletteColors().containerSurfaceLow());
  }

  @Override
  public int getContainerSurface() {
    return getArgb(new ChromaDuotonePaletteColors().containerSurface());
  }

  @Override
  public int getContainerSurfaceHigh() {
    return getArgb(new ChromaDuotonePaletteColors().containerSurfaceHigh());
  }

  @Override
  public int getContainerSurfaceHighest() {
    return getArgb(new ChromaDuotonePaletteColors().containerSurfaceHighest());
  }

  @Override
  public int getContainerSurfaceDim() {
    return getArgb(new ChromaDuotonePaletteColors().containerSurfaceDim());
  }

  @Override
  public int getContainerSurfaceBright() {
    return getArgb(new ChromaDuotonePaletteColors().containerSurfaceBright());
  }

  @Override
  public int getContainerShadow() {
    return getArgb(new ChromaDuotonePaletteColors().containerShadow());
  }

  @Override
  public int getOnContainer() {
    return getArgb(new ChromaDuotonePaletteColors().onContainer());
  }

  @Override
  public int getOnContainerVariant() {
    return getArgb(new ChromaDuotonePaletteColors().onContainerVariant());
  }

  @Override
  public int getContainerOutline() {
    return getArgb(new ChromaDuotonePaletteColors().containerOutline());
  }

  @Override
  public int getContainerOutlineVariant() {
    return getArgb(new ChromaDuotonePaletteColors().containerOutlineVariant());
  }

  @Override
  public int getInverseContainerSurface() {
    return getArgb(new ChromaDuotonePaletteColors().inverseContainerSurface());
  }

  @Override
  public int getInverseOnContainer() {
    return getArgb(new ChromaDuotonePaletteColors().inverseOnContainer());
  }

  @Override
  public int getInverseContainerOutline() {
    return getArgb(new ChromaDuotonePaletteColors().inverseContainerOutline());
  }

  @Override
  public int getComplementaryOnContainer() {
    return getArgb(new ChromaDuotonePaletteColors().complementaryOnContainer());
  }

  @Override
  public int getComplementaryContainerOutline() {
    return getArgb(new ChromaDuotonePaletteColors().complementaryContainerOutline());
  }

  @Override
  public int getAccentOnContainer() {
    return getArgb(new ChromaDuotonePaletteColors().accentOnContainer());
  }

  @Override
  public int getMarkerOnContainer() {
    return getArgb(new ChromaDuotonePaletteColors().markerOnContainer());
  }

  @Override
  public int getComplementaryMarkerOnContainer() {
    return getArgb(new ChromaDuotonePaletteColors().complementaryMarkerOnContainer());
  }
}
