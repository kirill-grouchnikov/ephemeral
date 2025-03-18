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
public final class ChromaDynamicPaletteColors {
  public ChromaDynamicPaletteColors() {
  }

    public DynamicPaletteColor containerSurfaceLowest() {
        return new DynamicPaletteColor(
            /* name= */ "container_surface_lowest",
            /* tone= */ (p) -> p.containerConfiguration.isDark()
                ? p.sourceColorTone - 8.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor()
                : p.sourceColorTone + 8.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor(),
            /* isBackground= */ true,
            /* isInverse= */ false,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor containerSurfaceLow() {
        return new DynamicPaletteColor(
            /* name= */ "container_surface_low",
            /* tone= */ (p) -> p.containerConfiguration.isDark()
                ? p.sourceColorTone - 2.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor()
                : p.sourceColorTone + 4.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor(),
            /* isBackground= */ true,
            /* isInverse= */ false,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor containerSurface() {
        return new DynamicPaletteColor(
            /* name= */ "container_surface",
            /* tone= */ (p) -> p.sourceColorTone,
            /* isBackground= */ true,
            /* isInverse= */ false,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor containerSurfaceHigh() {
        return new DynamicPaletteColor(
            /* name= */ "container_surface_high",
            /* tone= */ (p) -> p.containerConfiguration.isDark()
                ? p.sourceColorTone + 5.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor()
                : p.sourceColorTone - 2.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor(),
            /* isBackground= */ true,
            /* isInverse= */ false,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor containerSurfaceHighest() {
        return new DynamicPaletteColor(
            /* name= */ "container_surface_highest",
            /* tone= */ (p) -> p.containerConfiguration.isDark()
                ? p.sourceColorTone + 10.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor()
                : p.sourceColorTone - 4.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor(),
            /* isBackground= */ true,
            /* isInverse= */ false,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor containerSurfaceDim() {
        return new DynamicPaletteColor(
            /* name= */ "container_surface_dim",
            /* tone= */ (p) -> p.containerConfiguration.isDark()
                ? p.sourceColorTone - 10.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor()
                : p.sourceColorTone - 6.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor(),
            /* isBackground= */ true,
            /* isInverse= */ false,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor containerSurfaceBright() {
        return new DynamicPaletteColor(
            /* name= */ "container_surface_bright",
            /* tone= */ (p) -> p.containerConfiguration.isDark()
                ? p.sourceColorTone + 12.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor()
                : p.sourceColorTone + 10.0 * p.containerConfiguration.getSurfaceRangeAmplitudeFactor(),
            /* isBackground= */ true,
            /* isInverse= */ false,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor onContainer() {
        return new DynamicPaletteColor(
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

    public DynamicPaletteColor onContainerVariant() {
        return new DynamicPaletteColor(
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

    public DynamicPaletteColor containerOutline() {
        return new DynamicPaletteColor(
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

    public DynamicPaletteColor containerOutlineVariant() {
        return new DynamicPaletteColor(
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

    public DynamicPaletteColor inverseContainerSurface() {
        return new DynamicPaletteColor(
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

    public DynamicPaletteColor inverseOnContainer() {
        return new DynamicPaletteColor(
            /* name= */ "inverse_on_container",
            /* tone= */ (p) -> p.containerConfiguration.isDark() ? 30.0 : 90.0,
            /* isBackground= */ false,
            /* isInverse= */ true,
            /* background= */ (p) -> inverseContainerSurface(),
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0));
    }

    public DynamicPaletteColor inverseContainerOutline() {
        return new DynamicPaletteColor(
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

    public DynamicPaletteColor complementaryOnContainer() {
        return new DynamicPaletteColor(
            /* name= */ "complementary_on_container",
            /* tone= */ (p) -> p.containerConfiguration.isDark() ? 10.0 : 80.0,
            /* isBackground= */ false,
            /* isInverse= */ false,
            /* background= */ (p) -> inverseContainerSurface(),
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0));
    }

    public DynamicPaletteColor complementaryContainerOutline() {
        return new DynamicPaletteColor(
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
}
