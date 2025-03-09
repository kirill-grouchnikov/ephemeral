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

// This is a modified version of the original source code, changed to fit the Chroma needs

/**
 * Provides important settings for creating colors dynamically, and a tonal palette. Requires:
 * 1. A color. (source color)
 * 2. Whether or not its dark mode.
 * 3. Contrast level. (-1 to 1, currently contrast ratio 3.0 and 7.0)
 */
public class DynamicBimodalPalette {
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

  public int getContainerSurfaceLowest() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().containerSurfaceLowest());
  }

  public int getContainerSurfaceLow() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().containerSurfaceLow());
  }

  public int getContainerSurface() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().containerSurface());
  }

  public int getContainerSurfaceHigh() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().containerSurfaceHigh());
  }

  public int getContainerSurfaceHighest() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().containerSurfaceHighest());
  }

  public int getContainerSurfaceDim() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().containerSurfaceDim());
  }

  public int getContainerSurfaceBright() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().containerSurfaceBright());
  }

  public int getOnContainer() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().onContainer());
  }

  public int getOnContainerVariant() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().onContainerVariant());
  }

  public int getContainerOutline() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().containerOutline());
  }

  public int getContainerOutlineVariant() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().containerOutlineVariant());
  }

  public int getInverseContainerSurface() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().inverseContainerSurface());
  }

  public int getInverseOnContainer() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().inverseOnContainer());
  }

  public int getInverseContainerOutline() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().inverseContainerOutline());
  }

  public int getComplementaryOnContainer() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().complementaryOnContainer());
  }

  public int getComplementaryContainerOutline() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().complementaryContainerOutline());
  }
}
