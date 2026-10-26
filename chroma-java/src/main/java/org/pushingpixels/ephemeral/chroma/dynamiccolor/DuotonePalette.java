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
  /** The tonal palette for container colors. */
  public final TonalPalette containerPalette;
  /** The tonal palette for on-container colors. */
  public final TonalPalette onContainerPalette;
  /** The tone of the container source color. */
  public final double containerSourceColorTone;
  /** The tone of the on-container source color. */
  public final double onContainerSourceColorTone;
  /** The container configuration (dark mode, contrast level, etc.). */
  public final ContainerConfiguration containerConfiguration;

  /**
   * Creates a duotone palette from two HCT seed colors and a container configuration.
   *
   * @param seedContainer the HCT color for container colors
   * @param seedOnContainer the HCT color for on-container colors
   * @param containerConfiguration the container configuration
   */
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

  /**
   * Returns the ARGB color value for the given duotone palette color.
   *
   * @param dynamicPaletteColor the duotone palette color descriptor
   * @return the ARGB color value
   */
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
  public int getOnContainerLow() {
    return getArgb(new ChromaDuotonePaletteColors().onContainerLow());
  }

  @Override
  public int getOnContainer() {
    return getArgb(new ChromaDuotonePaletteColors().onContainer());
  }

  @Override
  public int getOnContainerHigh() {
    return getArgb(new ChromaDuotonePaletteColors().onContainerHigh());
  }

  @Override
  public int getContainerOutlineLow() {
    return getArgb(new ChromaDuotonePaletteColors().containerOutlineLow());
  }

  @Override
  public int getContainerOutline() {
    return getArgb(new ChromaDuotonePaletteColors().containerOutline());
  }

  @Override
  public int getContainerOutlineHigh() {
    return getArgb(new ChromaDuotonePaletteColors().containerOutlineHigh());
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
