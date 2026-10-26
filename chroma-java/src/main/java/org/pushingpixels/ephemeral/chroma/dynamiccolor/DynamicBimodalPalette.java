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
  /**
   * Defines the transition range between two palettes.
   */
  public enum TransitionRange {
    /** Transition across the full tonal range. */
    FULL_SPAN,
    /** Transition only within tonal container surfaces. */
    TONAL_CONTAINER_SURFACES
  }

  /** The first tonal palette. */
  public final TonalPalette paletteOne;
  /** The second tonal palette. */
  public final TonalPalette paletteTwo;
  /** The fidelity tone value. */
  public final double fidelityTone;
  /** The transition range between the two palettes. */
  public final TransitionRange transitionRange;
  /** The container configuration. */
  public final ContainerConfiguration containerConfiguration;

  /**
   * Creates a dynamic bimodal palette from two HCT seed colors.
   *
   * @param seedOne the first HCT color seed
   * @param seedTwo the second HCT color seed
   * @param transitionRange the transition range between the two palettes
   * @param fidelityTone the fidelity tone value
   * @param containerConfiguration the container configuration
   */
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

  /**
   * Returns the ARGB color value for the given dynamic bimodal palette color.
   *
   * @param dynamicPaletteColor the dynamic bimodal palette color descriptor
   * @return the ARGB color value
   */
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
