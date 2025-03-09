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

import org.pushingpixels.ephemeral.chroma.hct.Hct;

// This is a modified version of the original source code, changed to fit the Chroma needs

/** Named colors, otherwise known as tokens, or roles, in the Ephemeral Design system. */
public final class ChromaDynamicPaletteColors {
  public ChromaDynamicPaletteColors() {
  }

    public DynamicPaletteColor tonalContainerSurfaceLowest() {
        return new DynamicPaletteColor(
            /* name= */ "tonal_container_surface_lowest",
            /* tone= */ (p) -> p.isDark
                ? p.sourceColorTone - 8.0
                : p.sourceColorTone + 8.0,
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor tonalContainerSurfaceLow() {
        return new DynamicPaletteColor(
            /* name= */ "tonal_container_surface_low",
            /* tone= */ (p) -> p.isDark
                ? p.sourceColorTone - 2.0
                : p.sourceColorTone + 4.0,
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor tonalContainerSurface() {
        return new DynamicPaletteColor(
            /* name= */ "tonal_container_surface",
            /* tone= */ (p) -> p.sourceColorTone,
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor tonalContainerSurfaceHigh() {
        return new DynamicPaletteColor(
            /* name= */ "tonal_container_surface_high",
            /* tone= */ (p) -> p.isDark
                ? p.sourceColorTone + 5.0
                : p.sourceColorTone - 2.0,
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor tonalContainerSurfaceHighest() {
        return new DynamicPaletteColor(
            /* name= */ "tonal_container_surface_highest",
            /* tone= */ (p) -> p.isDark
                ? p.sourceColorTone + 10.0
                : p.sourceColorTone - 4.0,
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor tonalContainerSurfaceDim() {
        return new DynamicPaletteColor(
            /* name= */ "tonal_container_surface_dim",
            /* tone= */ (p) -> p.isDark ? p.sourceColorTone - 10.0
                : p.sourceColorTone - 6.0,
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor tonalContainerSurfaceBright() {
        return new DynamicPaletteColor(
            /* name= */ "tonal_container_surface_bright",
            /* tone= */ (p) -> p.isDark ? p.sourceColorTone + 12.0
                : p.sourceColorTone + 10.0,
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor onTonalContainer() {
        return new DynamicPaletteColor(
            /* name= */ "on_tonal_container",
            /* tone= */ (p) -> DynamicPaletteColor.foregroundTone(tonalContainerSurface().tone.apply(p),
                new ContrastCurve(4.5, 6.0, 9.0, 12.0).get(p.contrastLevel),
                p.isDark),
        /* isBackground= */ false,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0));
    }

    public DynamicPaletteColor onTonalContainerVariant() {
        return new DynamicPaletteColor(
            /* name= */ "on_tonal_container_variant",
            /* tone= */ (p) -> p.isDark ? 80.0 : 40.0,
            /* isBackground= */ false,
            /* background= */ (p) -> tonalContainerSurface(),
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0));
    }

    public DynamicPaletteColor tonalContainerOutline() {
        return new DynamicPaletteColor(
            /* name= */ "tonal_container_outline",
            /* tone= */ (p) -> p.isDark
                ? new ContrastCurve(15.0, 10.0, 5.0, 0.0).get(p.contrastLevel)
                : new ContrastCurve(55.0, 50.0, 40.0, 30.0).get(p.contrastLevel),
            /* isBackground= */ false,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor tonalContainerOutlineVariant() {
        return new DynamicPaletteColor(
            /* name= */ "tonal_container_outline_variant",
            /* tone= */ (p) -> p.isDark
                ? new ContrastCurve(15.0, 10.0, 5.0, 0.0).get(p.contrastLevel)
                : new ContrastCurve(85.0, 80.0, 70.0, 50.0).get(p.contrastLevel),
            /* isBackground= */ false,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor inverseTonalContainerSurface() {
        return new DynamicPaletteColor(
            /* name= */ "inverse_tonal_container_surface",
            /* tone= */ (p) -> p.isDark
            ? new ContrastCurve(90.0, 90.0, 88.0, 86.0).get(p.contrastLevel)
            : new ContrastCurve(30.0, 30.0, 34.0, 36.0).get(p.contrastLevel),
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor inverseOnTonalContainer() {
        return new DynamicPaletteColor(
            /* name= */ "inverse_on_tonal_container",
            /* tone= */ (p) -> p.isDark ? 30.0 : 90.0,
            /* isBackground= */ false,
            /* background= */ (p) -> inverseTonalContainerSurface(),
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0));
    }

    public DynamicPaletteColor inverseTonalContainerOutline() {
        return new DynamicPaletteColor(
            /* name= */ "inverse_tonal_container_outline",
            /* tone= */ (p) -> p.isDark
            ? new ContrastCurve(55.0, 50.0, 40.0, 30.0).get(p.contrastLevel)
            : new ContrastCurve(15.0, 10.0, 5.0, 0.0).get(p.contrastLevel),
            /* isBackground= */ false,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor complementaryOnTonalContainer() {
        return new DynamicPaletteColor(
            /* name= */ "complementary_on_tonal_container",
            /* tone= */ (p) -> p.isDark ? 10.0 : 80.0,
            /* isBackground= */ false,
            /* background= */ (p) -> inverseTonalContainerSurface(),
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0));
    }

    public DynamicPaletteColor complementaryTonalContainerOutline() {
        return new DynamicPaletteColor(
            /* name= */ "complementary_tonal_container_outline",
            /* tone= */ (p) -> p.isDark
            ? new ContrastCurve(85.0, 90.0, 95.0, 100.0).get(p.contrastLevel)
            : new ContrastCurve(90.0, 95.0, 98.0, 100.0).get(p.contrastLevel),
            /* isBackground= */ false,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }
}
