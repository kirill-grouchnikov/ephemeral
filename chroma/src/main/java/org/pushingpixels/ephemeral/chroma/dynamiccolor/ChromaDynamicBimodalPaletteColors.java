/*
 * Copyright 2023 Google LLC
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

// This is a modified version of the original source code, changed to fit the Chroma needs

import org.pushingpixels.ephemeral.chroma.utils.ContrastCurveUtils;

/** Named colors, otherwise known as tokens, or roles, in the Ephemeral Design system. */
public final class ChromaDynamicBimodalPaletteColors {
  public ChromaDynamicBimodalPaletteColors() {
  }

    public DynamicBimodalPaletteColor tonalContainerSurfaceLowest() {
        return new DynamicBimodalPaletteColor(
            /* name= */ "tonal_container_surface_lowest",
            /* tone= */ (p) -> p.tonalContainerConfiguration.isDark()
                ? p.fidelityTone - 8.0 * p.tonalContainerConfiguration.getSurfaceRangeAmplitudeFactor()
                : p.fidelityTone + 8.0 * p.tonalContainerConfiguration.getSurfaceRangeAmplitudeFactor(),
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicBimodalPaletteColor tonalContainerSurfaceLow() {
        return new DynamicBimodalPaletteColor(
            /* name= */ "tonal_container_surface_low",
            /* tone= */ (p) -> p.tonalContainerConfiguration.isDark()
                ? p.fidelityTone - 2.0 * p.tonalContainerConfiguration.getSurfaceRangeAmplitudeFactor()
                : p.fidelityTone + 4.0 * p.tonalContainerConfiguration.getSurfaceRangeAmplitudeFactor(),
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicBimodalPaletteColor tonalContainerSurface() {
        return new DynamicBimodalPaletteColor(
            /* name= */ "tonal_container_surface",
            /* tone= */ (p) -> p.fidelityTone,
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicBimodalPaletteColor tonalContainerSurfaceHigh() {
        return new DynamicBimodalPaletteColor(
            /* name= */ "tonal_container_surface_high",
            /* tone= */ (p) -> p.tonalContainerConfiguration.isDark()
                ? p.fidelityTone + 5.0 * p.tonalContainerConfiguration.getSurfaceRangeAmplitudeFactor()
                : p.fidelityTone - 2.0 * p.tonalContainerConfiguration.getSurfaceRangeAmplitudeFactor(),
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicBimodalPaletteColor tonalContainerSurfaceHighest() {
        return new DynamicBimodalPaletteColor(
            /* name= */ "tonal_container_surface_highest",
            /* tone= */ (p) -> p.tonalContainerConfiguration.isDark()
                ? p.fidelityTone + 10.0 * p.tonalContainerConfiguration.getSurfaceRangeAmplitudeFactor()
                : p.fidelityTone - 4.0 * p.tonalContainerConfiguration.getSurfaceRangeAmplitudeFactor(),
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }


    public DynamicBimodalPaletteColor tonalContainerSurfaceDim() {
        return new DynamicBimodalPaletteColor(
            /* name= */ "tonal_container_surface_dim",
            /* tone= */ (p) -> p.tonalContainerConfiguration.isDark()
                ? p.fidelityTone - 10.0 * p.tonalContainerConfiguration.getSurfaceRangeAmplitudeFactor()
                : p.fidelityTone - 6.0 * p.tonalContainerConfiguration.getSurfaceRangeAmplitudeFactor(),
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }


    public DynamicBimodalPaletteColor tonalContainerSurfaceBright() {
        return new DynamicBimodalPaletteColor(
            /* name= */ "tonal_container_surface_bright",
            /* tone= */ (p) -> p.tonalContainerConfiguration.isDark()
                ? p.fidelityTone + 12.0 * p.tonalContainerConfiguration.getSurfaceRangeAmplitudeFactor()
                : p.fidelityTone + 10.0 * p.tonalContainerConfiguration.getSurfaceRangeAmplitudeFactor(),
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicBimodalPaletteColor onTonalContainer() {
        return new DynamicBimodalPaletteColor(
            /* name= */ "on_tonal_container",
            /* tone= */ (p) -> DynamicBimodalPaletteColor.foregroundTone(tonalContainerSurface().tone.apply(p),
                new ContrastCurve(4.5, 6.0, 9.0, 12.0).get(p.tonalContainerConfiguration.getContrastLevel()),
                false, p.tonalContainerConfiguration.isDark()),
        /* isBackground= */ false,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0));
    }

    public DynamicBimodalPaletteColor onTonalContainerVariant() {
        return new DynamicBimodalPaletteColor(
            /* name= */ "on_tonal_container_variant",
            /* tone= */ (p) -> p.tonalContainerConfiguration.isDark() ? 80.0 : 40.0,
            /* isBackground= */ false,
            /* background= */ (p) -> tonalContainerSurface(),
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0));
    }

    public DynamicBimodalPaletteColor tonalContainerOutline() {
        return new DynamicBimodalPaletteColor(
            /* name= */ "tonal_container_outline",
            /* tone= */ (p) -> p.tonalContainerConfiguration.isDark()
                ? new ContrastCurve(15.0, 10.0, 5.0, 0.0).get(p.tonalContainerConfiguration.getContrastLevel())
                : new ContrastCurve(55.0, 50.0, 40.0, 30.0).get(p.tonalContainerConfiguration.getContrastLevel()),
            /* isBackground= */ false,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicBimodalPaletteColor tonalContainerOutlineVariant() {
        return new DynamicBimodalPaletteColor(
            /* name= */ "tonal_container_outline_variant",
            /* tone= */ (p) -> p.tonalContainerConfiguration.isDark()
                ? new ContrastCurve(15.0, 10.0, 5.0, 0.0).get(p.tonalContainerConfiguration.getContrastLevel())
                : new ContrastCurve(85.0, 80.0, 70.0, 50.0).get(p.tonalContainerConfiguration.getContrastLevel()),
            /* isBackground= */ false,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicBimodalPaletteColor inverseTonalContainerSurface() {
        return new DynamicBimodalPaletteColor(
            /* name= */ "inverse_tonal_container_surface",
            /* tone= */ (p) -> p.tonalContainerConfiguration.isDark()
            ? new ContrastCurve(90.0, 90.0, 88.0, 86.0).get(p.tonalContainerConfiguration.getContrastLevel())
            : new ContrastCurve(30.0, 30.0, 34.0, 36.0).get(p.tonalContainerConfiguration.getContrastLevel()),
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicBimodalPaletteColor inverseOnTonalContainer() {
        return new DynamicBimodalPaletteColor(
            /* name= */ "inverse_on_tonal_container",
            /* tone= */ (p) -> p.tonalContainerConfiguration.isDark() ? 30.0 : 90.0,
            /* isBackground= */ false,
            /* background= */ (p) -> inverseTonalContainerSurface(),
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0));
    }

    public DynamicBimodalPaletteColor inverseTonalContainerOutline() {
        return new DynamicBimodalPaletteColor(
            /* name= */ "inverse_tonal_container_outline",
            /* tone= */ (p) -> p.tonalContainerConfiguration.isDark()
            ? new ContrastCurve(55.0, 50.0, 40.0, 30.0).get(p.tonalContainerConfiguration.getContrastLevel())
            : new ContrastCurve(15.0, 10.0, 5.0, 0.0).get(p.tonalContainerConfiguration.getContrastLevel()),
            /* isBackground= */ false,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicBimodalPaletteColor complementaryOnTonalContainer() {
        return new DynamicBimodalPaletteColor(
            /* name= */ "complementary_on_tonal_container",
            /* tone= */ (p) -> p.tonalContainerConfiguration.isDark() ? 10.0 : 80.0,
            /* isBackground= */ false,
            /* background= */ (p) -> inverseTonalContainerSurface(),
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0));
    }

    public DynamicBimodalPaletteColor complementaryTonalContainerOutline() {
        return new DynamicBimodalPaletteColor(
            /* name= */ "complementary_tonal_container_outline",
            /* tone= */ (p) -> p.tonalContainerConfiguration.isDark()
            ? new ContrastCurve(85.0, 90.0, 95.0, 100.0).get(p.tonalContainerConfiguration.getContrastLevel())
            : new ContrastCurve(90.0, 95.0, 98.0, 100.0).get(p.tonalContainerConfiguration.getContrastLevel()),
            /* isBackground= */ false,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    /* internal */ double getTonalTransitionRangeToneStart(DynamicBimodalPalette palette) {
        if (palette.tonalTransitionRange == DynamicBimodalPalette.TransitionRange.FULL_SPAN) {
            return 0.0;
        }

        return palette.tonalContainerConfiguration.isDark()
            ? palette.fidelityTone - 10.0 * palette.tonalContainerConfiguration.getSurfaceRangeAmplitudeFactor()
            : palette.fidelityTone - 6.0 * palette.tonalContainerConfiguration.getSurfaceRangeAmplitudeFactor();
    }

    /* internal */ double getTonalTransitionRangeToneEnd(DynamicBimodalPalette palette) {
        if (palette.tonalTransitionRange == DynamicBimodalPalette.TransitionRange.FULL_SPAN) {
            return 100.0;
        }

        return palette.tonalContainerConfiguration.isDark()
            ? palette.fidelityTone + 12.0 * palette.tonalContainerConfiguration.getSurfaceRangeAmplitudeFactor()
            : palette.fidelityTone + 10.0 * palette.tonalContainerConfiguration.getSurfaceRangeAmplitudeFactor();
    }
}
