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
public final class ChromaDuotonePaletteColors {
  public ChromaDuotonePaletteColors() {
  }

    public DuotonePaletteColor containerSurfaceLowest() {
        return new DuotonePaletteColor(
            /* name= */ "container_surface_lowest",
            /* tonalPalette= */ (p) -> p.containerPalette,
            /* tone= */ (p) -> p.containerConfiguration.isDark()
                ? p.containerSourceColorTone - 8.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor()
                : p.containerSourceColorTone + 8.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor(),
            /* isBackground= */ true,
            /* isInverse= */ false,
            /* background= */ null,
            /* contrastCurve= */ null);
    }

    public DuotonePaletteColor containerSurfaceLow() {
        return new DuotonePaletteColor(
            /* name= */ "container_surface_low",
            /* tonalPalette= */ (p) -> p.containerPalette,
            /* tone= */ (p) -> p.containerConfiguration.isDark()
                ? p.containerSourceColorTone - 2.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor()
                : p.containerSourceColorTone + 4.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor(),
            /* isBackground= */ true,
            /* isInverse= */ false,
            /* background= */ null,
            /* contrastCurve= */ null);
    }

    public DuotonePaletteColor containerSurface() {
        return new DuotonePaletteColor(
            /* name= */ "container_surface",
            /* tonalPalette= */ (p) -> p.containerPalette,
            /* tone= */ (p) -> p.containerSourceColorTone,
            /* isBackground= */ true,
            /* isInverse= */ false,
            /* background= */ null,
            /* contrastCurve= */ null);
    }

    public DuotonePaletteColor containerSurfaceHigh() {
        return new DuotonePaletteColor(
            /* name= */ "container_surface_high",
            /* tonalPalette= */ (p) -> p.containerPalette,
            /* tone= */ (p) -> p.containerConfiguration.isDark()
                ? p.containerSourceColorTone + 5.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor()
                : p.containerSourceColorTone - 2.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor(),
            /* isBackground= */ true,
            /* isInverse= */ false,
            /* background= */ null,
            /* contrastCurve= */ null);
    }

    public DuotonePaletteColor containerSurfaceHighest() {
        return new DuotonePaletteColor(
            /* name= */ "container_surface_highest",
            /* tonalPalette= */ (p) -> p.containerPalette,
            /* tone= */ (p) -> p.containerConfiguration.isDark()
                ? p.containerSourceColorTone + 10.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor()
                : p.containerSourceColorTone - 4.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor(),
            /* isBackground= */ true,
            /* isInverse= */ false,
            /* background= */ null,
            /* contrastCurve= */ null);
    }


    public DuotonePaletteColor containerSurfaceDim() {
        return new DuotonePaletteColor(
            /* name= */ "container_surface_dim",
            /* tonalPalette= */ (p) -> p.containerPalette,
            /* tone= */ (p) -> p.containerConfiguration.isDark()
                ? p.containerSourceColorTone - 10.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor()
                : p.containerSourceColorTone - 6.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor(),
            /* isBackground= */ true,
            /* isInverse= */ false,
            /* background= */ null,
            /* contrastCurve= */ null);
    }


    public DuotonePaletteColor containerSurfaceBright() {
        return new DuotonePaletteColor(
            /* name= */ "container_surface_bright",
            /* tonalPalette= */ (p) -> p.containerPalette,
            /* tone= */ (p) -> p.containerConfiguration.isDark()
                ? p.containerSourceColorTone + 12.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor()
                : p.containerSourceColorTone + 10.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor(),
            /* isBackground= */ true,
            /* isInverse= */ false,
            /* background= */ null,
            /* contrastCurve= */ null);
    }

    public DuotonePaletteColor containerShadow() {
        return new DuotonePaletteColor(
            /* name= */ "container_shadow",
            /* tonalPalette= */ (p) -> p.containerPalette,
            /* tone= */ (p) -> p.containerConfiguration.isDark()
                ? new ContrastCurve(10.0, 5.0, 2.0, 0.0).get(p.containerConfiguration.getContrastLevel())
                : new ContrastCurve(20.0, 12.0, 5.0, 0.0).get(p.containerConfiguration.getContrastLevel()),
            /* isBackground= */ false,
            /* isInverse= */ false,
            /* background= */ null,
            /* contrastCurve= */ null);
    }

    public DuotonePaletteColor onContainer() {
        return new DuotonePaletteColor(
            /* name= */ "on_container",
            /* tonalPalette= */ (p) -> p.onContainerPalette,
            /* tone= */ (p) -> p.onContainerSourceColorTone,
            /* isBackground= */ false,
            /* isInverse= */ false,
            /* background= */ null,
            /* contrastCurve= */ null);
    }

    public DuotonePaletteColor onContainerVariant() {
        return new DuotonePaletteColor(
            /* name= */ "on_container_variant",
            /* tonalPalette= */ (p) -> p.onContainerPalette,
            /* tone= */ (p) -> p.containerConfiguration.isDark()
                ? p.onContainerSourceColorTone - 10.0
                : p.onContainerSourceColorTone + 10.0,
            /* isBackground= */ false,
            /* isInverse= */ false,
            /* background= */ null,
            /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0));
    }

    public DuotonePaletteColor containerOutline() {
        return new DuotonePaletteColor(
            /* name= */ "container_outline",
            /* tonalPalette= */ (p) -> p.containerPalette,
            /* tone= */ (p) -> p.containerConfiguration.isDark()
                ? new ContrastCurve(15.0, 10.0, 5.0, 0.0).get(p.containerConfiguration.getContrastLevel())
                : new ContrastCurve(55.0, 50.0, 40.0, 30.0).get(p.containerConfiguration.getContrastLevel()),
            /* isBackground= */ false,
            /* isInverse= */ false,
            /* background= */ null,
            /* contrastCurve= */ null);
    }

    public DuotonePaletteColor containerOutlineVariant() {
        return new DuotonePaletteColor(
            /* name= */ "container_outline_variant",
            /* tonalPalette= */ (p) -> p.containerPalette,
            /* tone= */ (p) -> p.containerConfiguration.isDark()
                ? new ContrastCurve(35.0, 30.0, 20.0, 10.0).get(p.containerConfiguration.getContrastLevel())
                : new ContrastCurve(85.0, 80.0, 70.0, 50.0).get(p.containerConfiguration.getContrastLevel()),
            /* isBackground= */ false,
            /* isInverse= */ false,
            /* background= */ null,
            /* contrastCurve= */ null);
    }

    public DuotonePaletteColor inverseContainerSurface() {
        return new DuotonePaletteColor(
            /* name= */ "inverse_container_surface",
            /* tonalPalette= */ (p) -> p.containerPalette,
            /* tone= */ (p) -> p.containerConfiguration.isDark()
                ? new ContrastCurve(90.0, 90.0, 88.0, 86.0).get(p.containerConfiguration.getContrastLevel())
                : new ContrastCurve(30.0, 30.0, 34.0, 36.0).get(p.containerConfiguration.getContrastLevel()),
            /* isBackground= */ true,
            /* isInverse= */ true,
            /* background= */ null,
            /* contrastCurve= */ null);
    }

    public DuotonePaletteColor inverseOnContainer() {
        return new DuotonePaletteColor(
            /* name= */ "inverse_on_container",
            /* tonalPalette= */ (p) -> p.onContainerPalette,
            /* tone= */ (p) -> p.containerConfiguration.isDark() ? 30.0 : 90.0,
            /* isBackground= */ false,
            /* isInverse= */ true,
            /* background= */ (p) -> inverseContainerSurface(),
            /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0));
    }

    public DuotonePaletteColor inverseContainerOutline() {
        return new DuotonePaletteColor(
            /* name= */ "inverse_container_outline",
            /* tonalPalette= */ (p) -> p.containerPalette,
            /* tone= */ (p) -> p.containerConfiguration.isDark()
                ? new ContrastCurve(25.0, 20.0, 15.0, 5.0).get(p.containerConfiguration.getContrastLevel())
                : new ContrastCurve(15.0, 10.0, 5.0, 0.0).get(p.containerConfiguration.getContrastLevel()),
            /* isBackground= */ false,
            /* isInverse= */ true,
            /* background= */ null,
            /* contrastCurve= */ null);
    }

    public DuotonePaletteColor complementaryOnContainer() {
        return new DuotonePaletteColor(
            /* name= */ "complementary_on_container",
            /* tonalPalette= */ (p) -> p.onContainerPalette,
            /* tone= */ (p) -> {
                ContrastCurve contrastCurve = p.containerConfiguration.isDark()
                    ? new ContrastCurve(4.5, 6.0, 9.0, 12.0)
                    : new ContrastCurve(5.0, 7.0, 9.5, 12.0);
                return DynamicPaletteColor.foregroundTone(
                    containerSurface().tone.apply(p),
                    contrastCurve.get(p.containerConfiguration.getContrastLevel()),
                    !p.containerConfiguration.isDark());
            },
            /* isBackground= */ false,
            /* isInverse= */ false,
            /* background= */ null,
            /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0));
    }

    public DuotonePaletteColor complementaryContainerOutline() {
        return new DuotonePaletteColor(
            /* name= */ "complementary_container_outline",
            /* tonalPalette= */ (p) -> p.containerPalette,
            /* tone= */ (p) -> p.containerConfiguration.isDark()
                ? new ContrastCurve(85.0, 90.0, 95.0, 100.0).get(p.containerConfiguration.getContrastLevel())
                : new ContrastCurve(90.0, 95.0, 98.0, 100.0).get(p.containerConfiguration.getContrastLevel()),
            /* isBackground= */ false,
            /* isInverse= */ false,
            /* background= */ null,
            /* contrastCurve= */ null);
    }

    public DuotonePaletteColor accentOnContainer() {
        return new DuotonePaletteColor(
            /* name= */ "accent_on_container",
            /* tonalPalette= */ (p) -> p.onContainerPalette,
            /* tone= */ (p) -> p.containerConfiguration.isDark() ? 80.0 : 40.0,
            /* isBackground= */ false,
            /* isInverse= */ false,
            /* background= */ (p) -> containerSurface(),
            /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0));
    }
}
