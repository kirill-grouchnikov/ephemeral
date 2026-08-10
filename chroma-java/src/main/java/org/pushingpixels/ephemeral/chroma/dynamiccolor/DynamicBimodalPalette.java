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
 * A primary entry point for bimodal palettes.
 * 1. Two source colors.
 * 2. Transition range between these two colors across the full tonal range.
 * 3. Container configuration (dark mode, contrast level, ...)
 */
public class DynamicBimodalPalette implements TokenPalette {
  public enum TransitionRange {
    FULL_SPAN, TONAL_CONTAINER_SURFACES
  }

  public final TonalPalette paletteOne;
  public final TonalPalette paletteTwo;
  public final double fidelityTone;
  public final TransitionRange transitionRange;
  public final ContainerConfiguration containerConfiguration;

  public DynamicBimodalPalette(
      Hct seedOne,
      Hct seedTwo,
      TransitionRange transitionRange,
      double fidelityTone,
      ContainerConfiguration containerConfiguration) {
    this.transitionRange = transitionRange;
    this.fidelityTone = fidelityTone;
    this.containerConfiguration = containerConfiguration;

    this.paletteOne = TonalPalette.fromHct(seedOne);
    this.paletteTwo = TonalPalette.fromHct(seedTwo);
  }

  /* internal */
  double getTransitionRangeToneStart() {
    return new ChromaDynamicBimodalPaletteColors().getTransitionRangeToneStart(this);
  }

  /* internal */
  double getTransitionRangeToneEnd() {
    return new ChromaDynamicBimodalPaletteColors().getTransitionRangeToneEnd(this);
  }

  public int getArgb(DynamicBimodalPaletteColor dynamicPaletteColor) {
    return dynamicPaletteColor.getArgb(this);
  }

  @Override
  public int getContainerSurfaceLowest() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().containerSurfaceLowest());
  }

  @Override
  public int getContainerSurfaceLow() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().containerSurfaceLow());
  }

  @Override
  public int getContainerSurface() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().containerSurface());
  }

  @Override
  public int getContainerSurfaceHigh() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().containerSurfaceHigh());
  }

  @Override
  public int getContainerSurfaceHighest() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().containerSurfaceHighest());
  }

  @Override
  public int getContainerSurfaceDim() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().containerSurfaceDim());
  }

  @Override
  public int getContainerSurfaceBright() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().containerSurfaceBright());
  }

  @Override
  public int getContainerShadow() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().containerShadow());
  }

  @Override
  public int getOnContainerLow() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().onContainerLow());
  }

  @Override
  public int getOnContainer() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().onContainer());
  }

  @Override
  public int getOnContainerHigh() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().onContainerHigh());
  }

  @Override
  public int getContainerOutlineLow() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().containerOutlineLow());
  }

  @Override
  public int getContainerOutline() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().containerOutline());
  }

  @Override
  public int getContainerOutlineHigh() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().containerOutlineHigh());
  }

  @Override
  public int getInverseContainerSurface() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().inverseContainerSurface());
  }

  @Override
  public int getInverseOnContainer() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().inverseOnContainer());
  }

  @Override
  public int getInverseContainerOutline() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().inverseContainerOutline());
  }

  @Override
  public int getComplementaryOnContainer() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().complementaryOnContainer());
  }

  @Override
  public int getComplementaryContainerOutline() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().complementaryContainerOutline());
  }

  @Override
  public int getAccentOnContainer() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().accentOnContainer());
  }

  @Override
  public int getMarkerOnContainer() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().markerOnContainer());
  }

  @Override
  public int getComplementaryMarkerOnContainer() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().complementaryMarkerOnContainer());
  }
}
