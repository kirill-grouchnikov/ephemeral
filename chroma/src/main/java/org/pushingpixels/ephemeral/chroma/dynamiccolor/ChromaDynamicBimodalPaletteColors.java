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

/** Named colors, otherwise known as tokens, or roles, in the Ephemeral Design system. */
public final class ChromaDynamicBimodalPaletteColors {
  public ChromaDynamicBimodalPaletteColors() {
  }

    public DynamicBimodalPaletteColor containerSurfaceLowest() {
        return new DynamicBimodalPaletteColor(
            /* name= */ "container_surface_lowest",
            /* tone= */ (p) -> p.containerConfiguration.isDark()
                ? p.fidelityTone - 8.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor()
                : p.fidelityTone + 8.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor(),
            /* isBackground= */ true,
            /* isInverse= */ false,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicBimodalPaletteColor containerSurfaceLow() {
        return new DynamicBimodalPaletteColor(
            /* name= */ "container_surface_low",
            /* tone= */ (p) -> p.containerConfiguration.isDark()
                ? p.fidelityTone - 2.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor()
                : p.fidelityTone + 4.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor(),
            /* isBackground= */ true,
            /* isInverse= */ false,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicBimodalPaletteColor containerSurface() {
        return new DynamicBimodalPaletteColor(
            /* name= */ "container_surface",
            /* tone= */ (p) -> p.fidelityTone,
            /* isBackground= */ true,
            /* isInverse= */ false,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicBimodalPaletteColor containerSurfaceHigh() {
        return new DynamicBimodalPaletteColor(
            /* name= */ "container_surface_high",
            /* tone= */ (p) -> p.containerConfiguration.isDark()
                ? p.fidelityTone + 5.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor()
                : p.fidelityTone - 2.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor(),
            /* isBackground= */ true,
            /* isInverse= */ false,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicBimodalPaletteColor containerSurfaceHighest() {
        return new DynamicBimodalPaletteColor(
            /* name= */ "container_surface_highest",
            /* tone= */ (p) -> p.containerConfiguration.isDark()
                ? p.fidelityTone + 10.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor()
                : p.fidelityTone - 4.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor(),
            /* isBackground= */ true,
            /* isInverse= */ false,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }


    public DynamicBimodalPaletteColor containerSurfaceDim() {
        return new DynamicBimodalPaletteColor(
            /* name= */ "container_surface_dim",
            /* tone= */ (p) -> p.containerConfiguration.isDark()
                ? p.fidelityTone - 10.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor()
                : p.fidelityTone - 6.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor(),
            /* isBackground= */ true,
            /* isInverse= */ false,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }


    public DynamicBimodalPaletteColor containerSurfaceBright() {
        return new DynamicBimodalPaletteColor(
            /* name= */ "container_surface_bright",
            /* tone= */ (p) -> p.containerConfiguration.isDark()
                ? p.fidelityTone + 12.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor()
                : p.fidelityTone + 10.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor(),
            /* isBackground= */ true,
            /* isInverse= */ false,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicBimodalPaletteColor onContainer() {
        return new DynamicBimodalPaletteColor(
            /* name= */ "on_container",
            /* tone= */ (p) -> {
                ContrastCurve contrastCurve = p.containerConfiguration.isDark()
                    ? new ContrastCurve(5.0, 7.0, 9.5, 12.0)
                    : new ContrastCurve(4.5, 6.0, 9.0, 12.0);
                return DynamicPaletteColor.foregroundTone(
                    containerSurface().tone.apply(p),
                    contrastCurve.get(p.containerConfiguration.getContrastLevel()),
                    p.containerConfiguration.isDark());
            },
            /* isBackground= */ false,
            /* isInverse= */ false,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0));
    }

    public DynamicBimodalPaletteColor onContainerVariant() {
        return new DynamicBimodalPaletteColor(
            /* name= */ "on_container_variant",
            /* tone= */ (p) -> {
                ContrastCurve contrastCurve = p.containerConfiguration.isDark()
                    ? new ContrastCurve(5.0, 6.0, 8.0, 10.0)
                    : new ContrastCurve(4.5, 5.0, 7.5, 10.0);
                return DynamicPaletteColor.foregroundTone(
                    containerSurface().tone.apply(p),
                    contrastCurve.get(p.containerConfiguration.getContrastLevel()),
                    p.containerConfiguration.isDark());
            },
            /* isBackground= */ false,
            /* isInverse= */ false,
            /* background= */ (p) -> containerSurface(),
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0));
    }

    public DynamicBimodalPaletteColor containerOutline() {
        return new DynamicBimodalPaletteColor(
            /* name= */ "container_outline",
            /* tone= */ (p) -> p.containerConfiguration.isDark()
                ? new ContrastCurve(15.0, 10.0, 5.0, 0.0).get(p.containerConfiguration.getContrastLevel())
                : new ContrastCurve(55.0, 50.0, 40.0, 30.0).get(p.containerConfiguration.getContrastLevel()),
            /* isBackground= */ false,
            /* isInverse= */ false,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicBimodalPaletteColor containerOutlineVariant() {
        return new DynamicBimodalPaletteColor(
            /* name= */ "container_outline_variant",
            /* tone= */ (p) -> p.containerConfiguration.isDark()
                ? new ContrastCurve(15.0, 10.0, 5.0, 0.0).get(p.containerConfiguration.getContrastLevel())
                : new ContrastCurve(85.0, 80.0, 70.0, 50.0).get(p.containerConfiguration.getContrastLevel()),
            /* isBackground= */ false,
            /* isInverse= */ false,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicBimodalPaletteColor inverseContainerSurface() {
        return new DynamicBimodalPaletteColor(
            /* name= */ "inverse_container_surface",
            /* tone= */ (p) -> p.containerConfiguration.isDark()
                ? new ContrastCurve(90.0, 90.0, 88.0, 86.0).get(p.containerConfiguration.getContrastLevel())
                : new ContrastCurve(30.0, 30.0, 34.0, 36.0).get(p.containerConfiguration.getContrastLevel()),
            /* isBackground= */ true,
            /* isInverse= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicBimodalPaletteColor inverseOnContainer() {
        return new DynamicBimodalPaletteColor(
            /* name= */ "inverse_on_container",
            /* tone= */ (p) -> p.containerConfiguration.isDark() ? 30.0 : 90.0,
            /* isBackground= */ false,
            /* isInverse= */ true,
            /* background= */ (p) -> inverseContainerSurface(),
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0));
    }

    public DynamicBimodalPaletteColor inverseContainerOutline() {
        return new DynamicBimodalPaletteColor(
            /* name= */ "inverse_container_outline",
            /* tone= */ (p) -> p.containerConfiguration.isDark()
                ? new ContrastCurve(55.0, 50.0, 40.0, 30.0).get(p.containerConfiguration.getContrastLevel())
                : new ContrastCurve(15.0, 10.0, 5.0, 0.0).get(p.containerConfiguration.getContrastLevel()),
            /* isBackground= */ false,
            /* isInverse= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicBimodalPaletteColor complementaryOnContainer() {
        return new DynamicBimodalPaletteColor(
            /* name= */ "complementary_on_container",
            /* tone= */ (p) -> p.containerConfiguration.isDark() ? 10.0 : 80.0,
            /* isBackground= */ false,
            /* isInverse= */ false,
            /* background= */ (p) -> inverseContainerSurface(),
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0));
    }

    public DynamicBimodalPaletteColor complementaryContainerOutline() {
        return new DynamicBimodalPaletteColor(
            /* name= */ "complementary_container_outline",
            /* tone= */ (p) -> p.containerConfiguration.isDark()
                ? new ContrastCurve(85.0, 90.0, 95.0, 100.0).get(p.containerConfiguration.getContrastLevel())
                : new ContrastCurve(90.0, 95.0, 98.0, 100.0).get(p.containerConfiguration.getContrastLevel()),
            /* isBackground= */ false,
            /* isInverse= */ false,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    /* internal */ double getTransitionRangeToneStart(DynamicBimodalPalette palette) {
        if (palette.transitionRange == DynamicBimodalPalette.TransitionRange.FULL_SPAN) {
            return 0.0;
        }

        return palette.containerConfiguration.isDark()
            ? palette.fidelityTone - 10.0 * palette.containerConfiguration.getSurfaceRangeAmplitudeFactor()
            : palette.fidelityTone - 6.0 * palette.containerConfiguration.getSurfaceRangeAmplitudeFactor();
    }

    /* internal */ double getTransitionRangeToneEnd(DynamicBimodalPalette palette) {
        if (palette.transitionRange == DynamicBimodalPalette.TransitionRange.FULL_SPAN) {
            return 100.0;
        }

        return palette.containerConfiguration.isDark()
            ? palette.fidelityTone + 12.0 * palette.containerConfiguration.getSurfaceRangeAmplitudeFactor()
            : palette.fidelityTone + 10.0 * palette.containerConfiguration.getSurfaceRangeAmplitudeFactor();
    }
}
