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

  public final boolean isFidelity;
  public final boolean isDark;
  public final double contrastLevel;
  public final TonalPalette paletteOne;
  public final TonalPalette paletteTwo;
  public final double fidelityTone;
  public final TransitionRange transitionRange;

  private DynamicBimodalPalette(
      Hct seedOne,
      Hct seedTwo,
      TransitionRange transitionRange,
      boolean isFidelity,
      double fidelityTone,
      boolean isDark,
      double contrastLevel) {
    this.transitionRange = transitionRange;
    this.isFidelity = isFidelity;
    this.fidelityTone = fidelityTone;
    this.isDark = isDark;
    this.contrastLevel = contrastLevel;

    this.paletteOne = TonalPalette.fromHct(seedOne);
    this.paletteTwo = TonalPalette.fromHct(seedTwo);
  }

  public static DynamicBimodalPalette fidelity(
      Hct seedOne,
      Hct seedTwo,
      TransitionRange transitionRange,
      boolean isDark,
      double fidelityTone,
      double contrastLevel) {
    return new DynamicBimodalPalette(
        seedOne,
        seedTwo,
        transitionRange,
        true,
        fidelityTone,
        isDark,
        contrastLevel);
  }

  public static DynamicBimodalPalette balanced(
      Hct seedOne,
      Hct seedTwo,
      TransitionRange transitionRange,
      boolean isDark,
      double contrastLevel) {
    return new DynamicBimodalPalette(
        seedOne,
        seedTwo,
        transitionRange,
        false,
        -1,
        isDark,
        contrastLevel);
  }

  public int getArgb(DynamicBimodalPaletteColor dynamicPaletteColor) {
    return dynamicPaletteColor.getArgb(this);
  }

  public int getTonalContainerSurfaceLowest() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().tonalContainerSurfaceLowest());
  }

  public int getTonalContainerSurfaceLow() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().tonalContainerSurfaceLow());
  }

  public int getTonalContainerSurface() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().tonalContainerSurface());
  }

  public int getTonalContainerSurfaceHigh() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().tonalContainerSurfaceHigh());
  }

  public int getTonalContainerSurfaceHighest() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().tonalContainerSurfaceHighest());
  }

  public int getTonalContainerSurfaceDim() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().tonalContainerSurfaceDim());
  }

  public int getTonalContainerSurfaceBright() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().tonalContainerSurfaceBright());
  }

  public int getOnTonalContainer() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().onTonalContainer());
  }

  public int getOnTonalContainerVariant() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().onTonalContainerVariant());
  }

  public int getTonalContainerOutline() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().tonalContainerOutline());
  }

  public int getTonalContainerOutlineVariant() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().tonalContainerOutlineVariant());
  }

  public int getInverseTonalContainerSurface() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().inverseTonalContainerSurface());
  }

  public int getInverseOnTonalContainer() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().inverseOnTonalContainer());
  }

  public int getInverseTonalContainerOutline() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().inverseTonalContainerOutline());
  }

  public int getComplementaryOnTonalContainer() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().complementaryOnTonalContainer());
  }

  public int getComplementaryTonalContainerOutline() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().complementaryTonalContainerOutline());
  }

  public int getPrimaryContainerSurfaceLowest() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().primaryContainerSurfaceLowest());
  }

  public int getPrimaryContainerSurfaceLow() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().primaryContainerSurfaceLow());
  }

  public int getPrimaryContainerSurface() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().primaryContainerSurface());
  }

  public int getPrimaryContainerSurfaceHigh() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().primaryContainerSurfaceHigh());
  }

  public int getPrimaryContainerSurfaceHighest() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().primaryContainerSurfaceHighest());
  }

  public int getPrimaryContainerSurfaceDim() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().primaryContainerSurfaceDim());
  }

  public int getPrimaryContainerSurfaceBright() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().primaryContainerSurfaceBright());
  }

  public int getOnPrimaryContainer() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().onPrimaryContainer());
  }

  public int getOnPrimaryContainerVariant() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().onPrimaryContainerVariant());
  }

  public int getPrimaryContainerOutline() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().primaryContainerOutline());
  }

  public int getPrimaryContainerOutlineVariant() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().primaryContainerOutlineVariant());
  }

  public int getInversePrimaryContainerSurface() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().inversePrimaryContainerSurface());
  }

  public int getInverseOnPrimaryContainer() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().inverseOnPrimaryContainer());
  }

  public int getInversePrimaryContainerOutline() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().inversePrimaryContainerOutline());
  }

  public int getComplementaryOnPrimaryContainer() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().complementaryOnPrimaryContainer());
  }

  public int getComplementaryPrimaryContainerOutline() {
    return getArgb(new ChromaDynamicBimodalPaletteColors().complementaryPrimaryContainerOutline());
  }
}
