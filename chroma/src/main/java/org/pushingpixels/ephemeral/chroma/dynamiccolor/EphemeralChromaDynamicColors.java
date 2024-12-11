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
public final class EphemeralChromaDynamicColors {
  /** Optionally use fidelity on most color schemes. */
  private final boolean isExtendedFidelity;

  public EphemeralChromaDynamicColors() {
    this.isExtendedFidelity = true;
  }

  // Temporary constructor to support extended fidelity experiment.
  // TODO(b/291720794): Once schemes that will permanently use fidelity are identified,
  // remove this and default to the decided behavior.
  public EphemeralChromaDynamicColors(boolean isExtendedFidelity) {
    this.isExtendedFidelity = isExtendedFidelity;
  }

  public DynamicColor highestSurface(DynamicScheme s) {
    return s.isDark ? surfaceBright() : surfaceDim();
  }

  public DynamicColor surface() {
    return new DynamicColor(
        /* name= */ "surface",
        /* palette= */ (s) -> s.neutralPalette,
        /* tone= */ (s) -> s.isDark ? 6.0 : 98.0,
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor surfaceDim() {
    return new DynamicColor(
        /* name= */ "surface_dim",
        /* palette= */ (s) -> s.neutralPalette,
        /* tone= */ (s) ->
            s.isDark ? 6.0 : new ContrastCurve(87.0, 87.0, 80.0, 75.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor surfaceBright() {
    return new DynamicColor(
        /* name= */ "surface_bright",
        /* palette= */ (s) -> s.neutralPalette,
        /* tone= */ (s) ->
            s.isDark ? new ContrastCurve(24.0, 24.0, 29.0, 34.0).get(s.contrastLevel) : 98.0,
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor surfaceContainerLowest() {
    return new DynamicColor(
        /* name= */ "surface_container_lowest",
        /* palette= */ (s) -> s.neutralPalette,
        /* tone= */ (s) ->
            s.isDark ? new ContrastCurve(4.0, 4.0, 2.0, 0.0).get(s.contrastLevel) : 100.0,
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor surfaceContainerLow() {
    return new DynamicColor(
        /* name= */ "surface_container_low",
        /* palette= */ (s) -> s.neutralPalette,
        /* tone= */ (s) ->
            s.isDark
                ? new ContrastCurve(10.0, 10.0, 11.0, 12.0).get(s.contrastLevel)
                : new ContrastCurve(96.0, 96.0, 96.0, 95.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor surfaceContainer() {
    return new DynamicColor(
        /* name= */ "surface_container",
        /* palette= */ (s) -> s.neutralPalette,
        /* tone= */ (s) ->
            s.isDark
                ? new ContrastCurve(12.0, 12.0, 16.0, 20.0).get(s.contrastLevel)
                : new ContrastCurve(94.0, 94.0, 92.0, 90.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor surfaceContainerHigh() {
    return new DynamicColor(
        /* name= */ "surface_container_high",
        /* palette= */ (s) -> s.neutralPalette,
        /* tone= */ (s) ->
            s.isDark
                ? new ContrastCurve(17.0, 17.0, 21.0, 25.0).get(s.contrastLevel)
                : new ContrastCurve(92.0, 92.0, 88.0, 85.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor surfaceContainerHighest() {
    return new DynamicColor(
        /* name= */ "surface_container_highest",
        /* palette= */ (s) -> s.neutralPalette,
        /* tone= */ (s) ->
            s.isDark
                ? new ContrastCurve(22.0, 22.0, 26.0, 30.0).get(s.contrastLevel)
                : new ContrastCurve(90.0, 90.0, 84.0, 80.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor onSurfaceContainer() {
    return new DynamicColor(
        /* name= */ "on_surface_container",
        /* palette= */ (s) -> s.neutralPalette,
        /* tone= */ (s) -> s.isDark ? 90.0 : 10.0,
        /* isBackground= */ false,
        /* background= */ this::highestSurface,
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(4.5, 7.0, 11.0, 21.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor onSurfaceContainerVariant() {
    return new DynamicColor(
        /* name= */ "on_surface_container_variant",
        /* palette= */ (s) -> s.neutralVariantPalette,
        /* tone= */ (s) -> s.isDark ? 80.0 : 30.0,
        /* isBackground= */ false,
        /* background= */ this::highestSurface,
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor surfaceContainerOutline() {
    return new DynamicColor(
        /* name= */ "surface_container_outline",
        /* palette= */ (s) -> s.neutralVariantPalette,
        /* tone= */ (s) -> s.isDark ? 60.0 : 50.0,
        /* isBackground= */ false,
        /* background= */ this::highestSurface,
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(1.5, 3.0, 4.5, 7.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor surfaceContainerOutlineVariant() {
    return new DynamicColor(
        /* name= */ "surface_container_outline_variant",
        /* palette= */ (s) -> s.neutralVariantPalette,
        /* tone= */ (s) -> s.isDark ? 30.0 : 80.0,
        /* isBackground= */ false,
        /* background= */ this::highestSurface,
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(1.0, 1.0, 3.0, 4.5),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor primaryContainerLowest() {
    return new DynamicColor(
        /* name= */ "primary_container_lowest",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> s.isDark
        ? new ContrastCurve(88.0, 88.0, 92.0, 94.0).get(s.contrastLevel)
        : new ContrastCurve(34.0, 34.0, 32.0, 30.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor primaryContainerLow() {
    return new DynamicColor(
        /* name= */ "primary_container_low",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> s.isDark
        ? new ContrastCurve(82.0, 82.0, 86.0, 88.0).get(s.contrastLevel)
        : new ContrastCurve(38.0, 38.0, 36.0, 34.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor primaryContainer() {
    return new DynamicColor(
        /* name= */ "primary_container",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> s.isDark
        ? new ContrastCurve(80.0, 80.0, 84.0, 86.0).get(s.contrastLevel)
        : new ContrastCurve(40.0, 40.0, 38.0, 36.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor primaryContainerHigh() {
    return new DynamicColor(
        /* name= */ "primary_container_high",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> s.isDark
        ? new ContrastCurve(76.0, 76.0, 80.0, 82.0).get(s.contrastLevel)
        : new ContrastCurve(45.0, 45.0, 43.0, 41.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor primaryContainerHighest() {
    return new DynamicColor(
        /* name= */ "primary_container_highest",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> s.isDark
        ? new ContrastCurve(74.0, 74.0, 78.0, 80.0).get(s.contrastLevel)
        : new ContrastCurve(50.0, 50.0, 48.0, 46.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor onPrimaryContainer() {
    return new DynamicColor(
        /* name= */ "on_primary_container",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> s.isDark ? 20.0 : 100.0,
        /* isBackground= */ false,
        /* background= */ (s) -> primaryContainer(),
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(4.5, 7.0, 11.0, 21.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor onPrimaryContainerVariant() {
    return new DynamicColor(
        /* name= */ "on_primary_container_variant",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> s.isDark ? 30.0 : 95.0,
        /* isBackground= */ false,
        /* background= */ (s) -> primaryContainer(),
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(4.5, 7.0, 11.0, 21.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor primaryContainerOutline() {
    return new DynamicColor(
        /* name= */ "primary_container_outline",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> s.isDark ? 30.0 : 100.0,
        /* isBackground= */ false,
        /* background= */ this::highestSurface,
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(1.0, 1.0, 3.0, 4.5),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor primaryContainerOutlineVariant() {
    return new DynamicColor(
        /* name= */ "primary_container_outline_variant",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> s.isDark ? 50.0 : 95.0,
        /* isBackground= */ false,
        /* background= */ this::highestSurface,
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(1.0, 1.0, 3.0, 4.5),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor mutedContainerLowest() {
    return new DynamicColor(
        /* name= */ "muted_container_lowest",
        /* palette= */ (s) -> s.neutralVariantPalette,
        /* tone= */ (s) ->
        s.isDark
            ? new ContrastCurve(12.0, 12.0, 16.0, 18.0).get(s.contrastLevel)
            : new ContrastCurve(94.0, 94.0, 92.0, 90.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor mutedContainerLow() {
    return new DynamicColor(
        /* name= */ "muted_container_low",
        /* palette= */ (s) -> s.neutralVariantPalette,
        /* tone= */ (s) ->
        s.isDark
            ? new ContrastCurve(16.0, 16.0, 20.0, 22.0).get(s.contrastLevel)
            : new ContrastCurve(90.0, 90.0, 88.0, 86.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor mutedContainer() {
    return new DynamicColor(
        /* name= */ "muted_container",
        /* palette= */ (s) -> s.neutralVariantPalette,
        /* tone= */ (s) ->
         s.isDark
            ? new ContrastCurve(18.0, 18.0, 22.0, 24.0).get(s.contrastLevel)
            : new ContrastCurve(88.0, 88.0, 86.0, 84.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor mutedContainerHigh() {
    return new DynamicColor(
        /* name= */ "muted_container_high",
        /* palette= */ (s) -> s.neutralVariantPalette,
        /* tone= */ (s) ->
        s.isDark
            ? new ContrastCurve(23.0, 23.0, 27.0, 29.0).get(s.contrastLevel)
            : new ContrastCurve(86.0, 86.0, 84.0, 82.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor mutedContainerHighest() {
    return new DynamicColor(
        /* name= */ "muted_container_highest",
        /* palette= */ (s) -> s.neutralVariantPalette,
        /* tone= */ (s) ->
        s.isDark
            ? new ContrastCurve(28.0, 28.0, 32.0, 34.0).get(s.contrastLevel)
            : new ContrastCurve(84.0, 84.0, 82.0, 80.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor onMutedContainer() {
    return new DynamicColor(
        /* name= */ "on_muted_container",
        /* palette= */ (s) -> s.neutralVariantPalette,
        /* tone= */ (s) -> s.isDark ? 90.0 : 10.0,
        /* isBackground= */ false,
        /* background= */ (s) -> mutedContainer(),
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor onMutedContainerVariant() {
    return new DynamicColor(
        /* name= */ "on_muted_container_variant",
        /* palette= */ (s) -> s.neutralVariantPalette,
        /* tone= */ (s) -> s.isDark ? 80.0 : 30.0,
        /* isBackground= */ false,
        /* background= */ (s) -> mutedContainer(),
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor mutedContainerOutline() {
    return new DynamicColor(
        /* name= */ "muted_container_outline",
        /* palette= */ (s) -> s.neutralVariantPalette,
        /* tone= */ (s) -> s.isDark ? 60.0 : 50.0,
        /* isBackground= */ false,
        /* background= */ this::highestSurface,
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(1.5, 3.0, 4.5, 7.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor mutedContainerOutlineVariant() {
    return new DynamicColor(
        /* name= */ "muted_container_outline_variant",
        /* palette= */ (s) -> s.neutralVariantPalette,
        /* tone= */ (s) -> s.isDark ? 40.0 : 70.0,
        /* isBackground= */ false,
        /* background= */ this::highestSurface,
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(1.0, 1.0, 3.0, 4.5),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor tonalContainerLowest() {
    return new DynamicColor(
        /* name= */ "tonal_container_lowest",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.isDark
                ? s.sourceColorHct.getTone() - 8.0
                : s.sourceColorHct.getTone() + 10.0;
          }
          return s.isDark
              ? new ContrastCurve(22.0, 22.0, 26.0, 28.0).get(s.contrastLevel)
              : new ContrastCurve(94.0, 94.0, 92.0, 90.0).get(s.contrastLevel);
        },
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor tonalContainerLow() {
    return new DynamicColor(
        /* name= */ "tonal_container_low",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.isDark
                ? s.sourceColorHct.getTone() - 2.0
                : s.sourceColorHct.getTone() + 4.0;
          }
          return s.isDark
              ? new ContrastCurve(28.0, 28.0, 32.0, 34.0).get(s.contrastLevel)
              : new ContrastCurve(92.0, 92.0, 90.0, 88.0).get(s.contrastLevel);
        },
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor tonalContainer() {
    return new DynamicColor(
        /* name= */ "tonal_container",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> {
      if (isFidelity(s)) {
        return s.sourceColorHct.getTone();
      }
      return s.isDark
          ? new ContrastCurve(30.0, 30.0, 34.0, 36.0).get(s.contrastLevel)
          : new ContrastCurve(90.0, 90.0, 88.0, 86.0).get(s.contrastLevel);
    },
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor tonalContainerHigh() {
    return new DynamicColor(
        /* name= */ "tonal_container_high",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.isDark
                ? s.sourceColorHct.getTone() + 5.0
                : s.sourceColorHct.getTone() - 2.0;
          }
          return s.isDark
              ? new ContrastCurve(35.0, 35.0, 39.0, 41.0).get(s.contrastLevel)
              : new ContrastCurve(88.0, 88.0, 86.0, 84.0).get(s.contrastLevel);
        },
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor tonalContainerHighest() {
    return new DynamicColor(
        /* name= */ "tonal_container_highest",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.isDark
                ? s.sourceColorHct.getTone() + 10.0
                : s.sourceColorHct.getTone() - 4.0;
          }
          return s.isDark
              ? new ContrastCurve(40.0, 40.0, 44.0, 46.0).get(s.contrastLevel)
              : new ContrastCurve(86.0, 86.0, 84.0, 82.0).get(s.contrastLevel);
        },
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor onTonalContainer() {
    return new DynamicColor(
        /* name= */ "on_tonal_container",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> {
      if (isFidelity(s)) {
        return DynamicColor.foregroundTone(tonalContainer().tone.apply(s), 4.5);
      }
      return s.isDark ? 90.0 : 30.0;
    },
        /* isBackground= */ false,
        /* background= */ (s) -> tonalContainer(),
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor onTonalContainerVariant() {
    return new DynamicColor(
        /* name= */ "on_tonal_container_variant",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> s.isDark ? 80.0 : 40.0,
        /* isBackground= */ false,
        /* background= */ (s) -> tonalContainer(),
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor tonalContainerOutline() {
    return new DynamicColor(
        /* name= */ "tonal_container_outline",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> s.isDark ? 60.0 : 45.0,
        /* isBackground= */ false,
        /* background= */ this::highestSurface,
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(1.5, 3.0, 4.5, 7.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor tonalContainerOutlineVariant() {
    return new DynamicColor(
        /* name= */ "tonal_container_outline_variant",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> s.isDark ? 40.0 : 65.0,
        /* isBackground= */ false,
        /* background= */ this::highestSurface,
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(1.0, 1.0, 3.0, 4.5),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemErrorContainerLowest() {
    return new DynamicColor(
        /* name= */ "system_error_container_lowest",
        /* palette= */ (s) -> s.systemErrorPalette,
        /* tone= */ (s) ->
        s.isDark
            ? new ContrastCurve(22.0, 22.0, 26.0, 28.0).get(s.contrastLevel)
            : new ContrastCurve(94.0, 94.0, 92.0, 90.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemErrorContainerLow() {
    return new DynamicColor(
        /* name= */ "system_error_container_low",
        /* palette= */ (s) -> s.systemErrorPalette,
        /* tone= */ (s) ->
        s.isDark
            ? new ContrastCurve(28.0, 28.0, 32.0, 34.0).get(s.contrastLevel)
            : new ContrastCurve(92.0, 92.0, 90.0, 88.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemErrorContainer() {
    return new DynamicColor(
        /* name= */ "system_error_container",
        /* palette= */ (s) -> s.systemErrorPalette,
        /* tone= */ (s) ->
        s.isDark
            ? new ContrastCurve(30.0, 30.0, 34.0, 36.0).get(s.contrastLevel)
            : new ContrastCurve(90.0, 90.0, 88.0, 86.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemErrorContainerHigh() {
    return new DynamicColor(
        /* name= */ "system_error_container_high",
        /* palette= */ (s) -> s.systemErrorPalette,
        /* tone= */ (s) ->
        s.isDark
            ? new ContrastCurve(35.0, 35.0, 39.0, 41.0).get(s.contrastLevel)
            : new ContrastCurve(88.0, 88.0, 86.0, 84.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemErrorContainerHighest() {
    return new DynamicColor(
        /* name= */ "system_error_container_highest",
        /* palette= */ (s) -> s.systemErrorPalette,
        /* tone= */ (s) ->
        s.isDark
            ? new ContrastCurve(40.0, 40.0, 44.0, 46.0).get(s.contrastLevel)
            : new ContrastCurve(86.0, 86.0, 84.0, 82.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor onSystemErrorContainer() {
    return new DynamicColor(
        /* name= */ "on_system_error_container",
        /* palette= */ (s) -> s.systemErrorPalette,
        /* tone= */ (s) -> s.isDark ? 90.0 : 30.0,
        /* isBackground= */ false,
        /* background= */ (s) -> systemErrorContainer(),
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor onSystemErrorContainerVariant() {
    return new DynamicColor(
        /* name= */ "on_system_error_container_variant",
        /* palette= */ (s) -> s.systemErrorPalette,
        /* tone= */ (s) -> s.isDark ? 80.0 : 40.0,
        /* isBackground= */ false,
        /* background= */ (s) -> systemErrorContainer(),
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemErrorContainerOutline() {
    return new DynamicColor(
        /* name= */ "system_error_container_outline",
        /* palette= */ (s) -> s.systemErrorPalette,
        /* tone= */ (s) -> s.isDark ? 60.0 : 45.0,
        /* isBackground= */ false,
        /* background= */ this::highestSurface,
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(1.5, 3.0, 4.5, 7.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemErrorContainerOutlineVariant() {
    return new DynamicColor(
        /* name= */ "system_error_container_outline_variant",
        /* palette= */ (s) -> s.systemErrorPalette,
        /* tone= */ (s) -> s.isDark ? 40.0 : 65.0,
        /* isBackground= */ false,
        /* background= */ this::highestSurface,
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(1.0, 1.0, 3.0, 4.5),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemWarningContainerLowest() {
    return new DynamicColor(
        /* name= */ "system_warning_container_lowest",
        /* palette= */ (s) -> s.systemWarningPalette,
        /* tone= */ (s) ->
        s.isDark
            ? new ContrastCurve(22.0, 22.0, 26.0, 28.0).get(s.contrastLevel)
            : new ContrastCurve(94.0, 94.0, 92.0, 90.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemWarningContainerLow() {
    return new DynamicColor(
        /* name= */ "system_warning_container_low",
        /* palette= */ (s) -> s.systemWarningPalette,
        /* tone= */ (s) ->
        s.isDark
            ? new ContrastCurve(28.0, 28.0, 32.0, 34.0).get(s.contrastLevel)
            : new ContrastCurve(92.0, 92.0, 90.0, 88.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemWarningContainer() {
    return new DynamicColor(
        /* name= */ "system_warning_container",
        /* palette= */ (s) -> s.systemWarningPalette,
        /* tone= */ (s) ->
        s.isDark
            ? new ContrastCurve(30.0, 30.0, 34.0, 36.0).get(s.contrastLevel)
            : new ContrastCurve(90.0, 90.0, 88.0, 86.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemWarningContainerHigh() {
    return new DynamicColor(
        /* name= */ "system_warning_container_high",
        /* palette= */ (s) -> s.systemWarningPalette,
        /* tone= */ (s) ->
        s.isDark
            ? new ContrastCurve(35.0, 35.0, 39.0, 41.0).get(s.contrastLevel)
            : new ContrastCurve(88.0, 88.0, 86.0, 84.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemWarningContainerHighest() {
    return new DynamicColor(
        /* name= */ "system_warning_container_highest",
        /* palette= */ (s) -> s.systemWarningPalette,
        /* tone= */ (s) ->
        s.isDark
            ? new ContrastCurve(40.0, 40.0, 44.0, 46.0).get(s.contrastLevel)
            : new ContrastCurve(86.0, 86.0, 84.0, 82.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor onSystemWarningContainer() {
    return new DynamicColor(
        /* name= */ "on_system_warning_container",
        /* palette= */ (s) -> s.systemWarningPalette,
        /* tone= */ (s) -> s.isDark ? 90.0 : 30.0,
        /* isBackground= */ false,
        /* background= */ (s) -> systemWarningContainer(),
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor onSystemWarningContainerVariant() {
    return new DynamicColor(
        /* name= */ "on_system_warning_container_variant",
        /* palette= */ (s) -> s.systemWarningPalette,
        /* tone= */ (s) -> s.isDark ? 80.0 : 40.0,
        /* isBackground= */ false,
        /* background= */ (s) -> systemWarningContainer(),
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemWarningContainerOutline() {
    return new DynamicColor(
        /* name= */ "system_warning_container_outline",
        /* palette= */ (s) -> s.systemWarningPalette,
        /* tone= */ (s) -> s.isDark ? 60.0 : 45.0,
        /* isBackground= */ false,
        /* background= */ this::highestSurface,
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(1.5, 3.0, 4.5, 7.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemWarningContainerOutlineVariant() {
    return new DynamicColor(
        /* name= */ "system_warning_container_outline_variant",
        /* palette= */ (s) -> s.systemWarningPalette,
        /* tone= */ (s) -> s.isDark ? 40.0 : 65.0,
        /* isBackground= */ false,
        /* background= */ this::highestSurface,
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(1.0, 1.0, 3.0, 4.5),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemInfoContainerLowest() {
    return new DynamicColor(
        /* name= */ "system_info_container_lowest",
        /* palette= */ (s) -> s.systemInfoPalette,
        /* tone= */ (s) ->
        s.isDark
            ? new ContrastCurve(22.0, 22.0, 26.0, 28.0).get(s.contrastLevel)
            : new ContrastCurve(94.0, 94.0, 92.0, 90.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemInfoContainerLow() {
    return new DynamicColor(
        /* name= */ "system_info_container_low",
        /* palette= */ (s) -> s.systemInfoPalette,
        /* tone= */ (s) ->
        s.isDark
            ? new ContrastCurve(28.0, 28.0, 32.0, 34.0).get(s.contrastLevel)
            : new ContrastCurve(92.0, 92.0, 90.0, 88.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemInfoContainer() {
    return new DynamicColor(
        /* name= */ "system_info_container",
        /* palette= */ (s) -> s.systemInfoPalette,
        /* tone= */ (s) ->
        s.isDark
            ? new ContrastCurve(30.0, 30.0, 34.0, 36.0).get(s.contrastLevel)
            : new ContrastCurve(90.0, 90.0, 88.0, 86.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemInfoContainerHigh() {
    return new DynamicColor(
        /* name= */ "system_info_container_high",
        /* palette= */ (s) -> s.systemInfoPalette,
        /* tone= */ (s) ->
        s.isDark
            ? new ContrastCurve(35.0, 35.0, 39.0, 41.0).get(s.contrastLevel)
            : new ContrastCurve(88.0, 88.0, 86.0, 84.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemInfoContainerHighest() {
    return new DynamicColor(
        /* name= */ "system_info_container_highest",
        /* palette= */ (s) -> s.systemInfoPalette,
        /* tone= */ (s) ->
        s.isDark
            ? new ContrastCurve(40.0, 40.0, 44.0, 46.0).get(s.contrastLevel)
            : new ContrastCurve(86.0, 86.0, 84.0, 82.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor onSystemInfoContainer() {
    return new DynamicColor(
        /* name= */ "on_system_info_container",
        /* palette= */ (s) -> s.systemInfoPalette,
        /* tone= */ (s) -> s.isDark ? 90.0 : 30.0,
        /* isBackground= */ false,
        /* background= */ (s) -> systemInfoContainer(),
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor onSystemInfoContainerVariant() {
    return new DynamicColor(
        /* name= */ "on_system_info_container_variant",
        /* palette= */ (s) -> s.systemInfoPalette,
        /* tone= */ (s) -> s.isDark ? 80.0 : 40.0,
        /* isBackground= */ false,
        /* background= */ (s) -> systemInfoContainer(),
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemInfoContainerOutline() {
    return new DynamicColor(
        /* name= */ "system_info_container_outline",
        /* palette= */ (s) -> s.systemInfoPalette,
        /* tone= */ (s) -> s.isDark ? 60.0 : 45.0,
        /* isBackground= */ false,
        /* background= */ this::highestSurface,
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(1.5, 3.0, 4.5, 7.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemInfoContainerOutlineVariant() {
    return new DynamicColor(
        /* name= */ "system_info_container_outline_variant",
        /* palette= */ (s) -> s.systemInfoPalette,
        /* tone= */ (s) -> s.isDark ? 40.0 : 65.0,
        /* isBackground= */ false,
        /* background= */ this::highestSurface,
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(1.0, 1.0, 3.0, 4.5),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemSuccessContainerLowest() {
    return new DynamicColor(
        /* name= */ "system_success_container_lowest",
        /* palette= */ (s) -> s.systemSuccessPalette,
        /* tone= */ (s) ->
        s.isDark
            ? new ContrastCurve(22.0, 22.0, 26.0, 28.0).get(s.contrastLevel)
            : new ContrastCurve(94.0, 94.0, 92.0, 90.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemSuccessContainerLow() {
    return new DynamicColor(
        /* name= */ "system_success_container_low",
        /* palette= */ (s) -> s.systemSuccessPalette,
        /* tone= */ (s) ->
        s.isDark
            ? new ContrastCurve(28.0, 28.0, 32.0, 34.0).get(s.contrastLevel)
            : new ContrastCurve(92.0, 92.0, 90.0, 88.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemSuccessContainer() {
    return new DynamicColor(
        /* name= */ "system_success_container",
        /* palette= */ (s) -> s.systemSuccessPalette,
        /* tone= */ (s) ->
        s.isDark
            ? new ContrastCurve(30.0, 30.0, 34.0, 36.0).get(s.contrastLevel)
            : new ContrastCurve(90.0, 90.0, 88.0, 86.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemSuccessContainerHigh() {
    return new DynamicColor(
        /* name= */ "system_success_container_high",
        /* palette= */ (s) -> s.systemSuccessPalette,
        /* tone= */ (s) ->
        s.isDark
            ? new ContrastCurve(35.0, 35.0, 39.0, 41.0).get(s.contrastLevel)
            : new ContrastCurve(88.0, 88.0, 86.0, 84.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemSuccessContainerHighest() {
    return new DynamicColor(
        /* name= */ "system_success_container_highest",
        /* palette= */ (s) -> s.systemSuccessPalette,
        /* tone= */ (s) ->
        s.isDark
            ? new ContrastCurve(40.0, 40.0, 44.0, 46.0).get(s.contrastLevel)
            : new ContrastCurve(86.0, 86.0, 84.0, 82.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor onSystemSuccessContainer() {
    return new DynamicColor(
        /* name= */ "on_system_success_container",
        /* palette= */ (s) -> s.systemSuccessPalette,
        /* tone= */ (s) -> s.isDark ? 90.0 : 30.0,
        /* isBackground= */ false,
        /* background= */ (s) -> systemSuccessContainer(),
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor onSystemSuccessContainerVariant() {
    return new DynamicColor(
        /* name= */ "on_system_success_container_variant",
        /* palette= */ (s) -> s.systemSuccessPalette,
        /* tone= */ (s) -> s.isDark ? 80.0 : 40.0,
        /* isBackground= */ false,
        /* background= */ (s) -> systemSuccessContainer(),
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemSuccessContainerOutline() {
    return new DynamicColor(
        /* name= */ "system_success_container_outline",
        /* palette= */ (s) -> s.systemSuccessPalette,
        /* tone= */ (s) -> s.isDark ? 60.0 : 45.0,
        /* isBackground= */ false,
        /* background= */ this::highestSurface,
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(1.5, 3.0, 4.5, 7.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemSuccessContainerOutlineVariant() {
    return new DynamicColor(
        /* name= */ "system_success_container_outline_variant",
        /* palette= */ (s) -> s.systemSuccessPalette,
        /* tone= */ (s) -> s.isDark ? 40.0 : 65.0,
        /* isBackground= */ false,
        /* background= */ this::highestSurface,
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(1.0, 1.0, 3.0, 4.5),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemEmergencyContainerLowest() {
    return new DynamicColor(
        /* name= */ "system_emergency_container_lowest",
        /* palette= */ (s) -> s.systemEmergencyPalette,
        /* tone= */ (s) ->
        s.isDark
            ? new ContrastCurve(22.0, 22.0, 26.0, 28.0).get(s.contrastLevel)
            : new ContrastCurve(94.0, 94.0, 92.0, 90.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemEmergencyContainerLow() {
    return new DynamicColor(
        /* name= */ "system_emergency_container_low",
        /* palette= */ (s) -> s.systemEmergencyPalette,
        /* tone= */ (s) ->
        s.isDark
            ? new ContrastCurve(28.0, 28.0, 32.0, 34.0).get(s.contrastLevel)
            : new ContrastCurve(92.0, 92.0, 90.0, 88.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemEmergencyContainer() {
    return new DynamicColor(
        /* name= */ "system_emergency_container",
        /* palette= */ (s) -> s.systemEmergencyPalette,
        /* tone= */ (s) ->
        s.isDark
            ? new ContrastCurve(30.0, 30.0, 34.0, 36.0).get(s.contrastLevel)
            : new ContrastCurve(90.0, 90.0, 88.0, 86.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemEmergencyContainerHigh() {
    return new DynamicColor(
        /* name= */ "system_emergency_container_high",
        /* palette= */ (s) -> s.systemEmergencyPalette,
        /* tone= */ (s) ->
        s.isDark
            ? new ContrastCurve(35.0, 35.0, 39.0, 41.0).get(s.contrastLevel)
            : new ContrastCurve(88.0, 88.0, 86.0, 84.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemEmergencyContainerHighest() {
    return new DynamicColor(
        /* name= */ "system_emergency_container_highest",
        /* palette= */ (s) -> s.systemEmergencyPalette,
        /* tone= */ (s) ->
        s.isDark
            ? new ContrastCurve(40.0, 40.0, 44.0, 46.0).get(s.contrastLevel)
            : new ContrastCurve(86.0, 86.0, 84.0, 82.0).get(s.contrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor onSystemEmergencyContainer() {
    return new DynamicColor(
        /* name= */ "on_system_emergency_container",
        /* palette= */ (s) -> s.systemEmergencyPalette,
        /* tone= */ (s) -> s.isDark ? 90.0 : 30.0,
        /* isBackground= */ false,
        /* background= */ (s) -> systemEmergencyContainer(),
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor onSystemEmergencyContainerVariant() {
    return new DynamicColor(
        /* name= */ "on_system_emergency_container_variant",
        /* palette= */ (s) -> s.systemEmergencyPalette,
        /* tone= */ (s) -> s.isDark ? 80.0 : 40.0,
        /* isBackground= */ false,
        /* background= */ (s) -> systemEmergencyContainer(),
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemEmergencyContainerOutline() {
    return new DynamicColor(
        /* name= */ "system_emergency_container_outline",
        /* palette= */ (s) -> s.systemEmergencyPalette,
        /* tone= */ (s) -> s.isDark ? 60.0 : 45.0,
        /* isBackground= */ false,
        /* background= */ this::highestSurface,
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(1.5, 3.0, 4.5, 7.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemEmergencyContainerOutlineVariant() {
    return new DynamicColor(
        /* name= */ "system_emergency_container_outline_variant",
        /* palette= */ (s) -> s.systemEmergencyPalette,
        /* tone= */ (s) -> s.isDark ? 40.0 : 65.0,
        /* isBackground= */ false,
        /* background= */ this::highestSurface,
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(1.0, 1.0, 3.0, 4.5),
        /* toneDeltaPair= */ null);
  }

  
  private boolean isFidelity(DynamicScheme scheme) {
    return this.isExtendedFidelity;
  }

  static double findDesiredChromaByTone(
      double hue, double chroma, double tone, boolean byDecreasingTone) {
    double answer = tone;

    Hct closestToChroma = Hct.from(hue, chroma, tone);
    if (closestToChroma.getChroma() < chroma) {
      double chromaPeak = closestToChroma.getChroma();
      while (closestToChroma.getChroma() < chroma) {
        answer += byDecreasingTone ? -1.0 : 1.0;
        Hct potentialSolution = Hct.from(hue, chroma, answer);
        if (chromaPeak > potentialSolution.getChroma()) {
          break;
        }
        if (Math.abs(potentialSolution.getChroma() - chroma) < 0.4) {
          break;
        }

        double potentialDelta = Math.abs(potentialSolution.getChroma() - chroma);
        double currentDelta = Math.abs(closestToChroma.getChroma() - chroma);
        if (potentialDelta < currentDelta) {
          closestToChroma = potentialSolution;
        }
        chromaPeak = Math.max(chromaPeak, potentialSolution.getChroma());
      }
    }

    return answer;
  }
}
