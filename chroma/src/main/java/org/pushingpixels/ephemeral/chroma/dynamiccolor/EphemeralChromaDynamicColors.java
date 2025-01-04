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
  public EphemeralChromaDynamicColors() {
  }

  public DynamicColor highestSurface(DynamicScheme s) {
    return s.isDark ? surfaceBright() : surfaceDim();
  }

  public DynamicColor surface() {
    return new DynamicColor(
        /* name= */ "surface",
        /* palette= */ (s) -> s.neutralPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.neutralSourceColorHct.getTone();
          }
          return s.isDark ? 6.0 : 98.0;
        },
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
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.isDark ? s.neutralSourceColorHct.getTone()
                : s.neutralSourceColorHct.getTone() - 10.0;
          }
          return s.isDark ? 6.0 : new ContrastCurve(87.0, 87.0, 80.0, 75.0).get(s.contrastLevel);
        },
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
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.isDark ? s.neutralSourceColorHct.getTone() + 18.0
                : s.neutralSourceColorHct.getTone();
          }
          return s.isDark ? new ContrastCurve(24.0, 24.0, 29.0, 34.0).get(s.contrastLevel) : 98.0;
        },
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor neutralContainerSurfaceLowest() {
    return new DynamicColor(
        /* name= */ "neutral_container_surface_lowest",
        /* palette= */ (s) -> s.neutralPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.isDark
                ? s.neutralSourceColorHct.getTone() - 2.0
                : s.neutralSourceColorHct.getTone() + 2.0;
          }
          return s.isDark ? new ContrastCurve(4.0, 4.0, 2.0, 0.0).get(s.contrastLevel) : 100.0;
        },
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor neutralContainerSurfaceLow() {
    return new DynamicColor(
        /* name= */ "neutral_container_surface_low",
        /* palette= */ (s) -> s.neutralPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.isDark
                ? s.neutralSourceColorHct.getTone() + 4.0
                : s.neutralSourceColorHct.getTone() - 2.0;
          }
          return s.isDark
              ? new ContrastCurve(10.0, 10.0, 11.0, 12.0).get(s.contrastLevel)
              : new ContrastCurve(96.0, 96.0, 96.0, 95.0).get(s.contrastLevel);
        },
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor neutralContainerSurface() {
    return new DynamicColor(
        /* name= */ "neutral_container_surface",
        /* palette= */ (s) -> s.neutralPalette,
        /* tone= */ (s) -> {
           if (isFidelity(s)) {
             return s.isDark
                 ? s.neutralSourceColorHct.getTone() + 6.0
                 : s.neutralSourceColorHct.getTone() - 4.0;
           }
           return s.isDark
               ? new ContrastCurve(12.0, 12.0, 16.0, 20.0).get(s.contrastLevel)
               : new ContrastCurve(94.0, 94.0, 92.0, 90.0).get(s.contrastLevel);
        },
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor neutralContainerSurfaceHigh() {
    return new DynamicColor(
        /* name= */ "neutral_container_surface_high",
        /* palette= */ (s) -> s.neutralPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.isDark
                ? s.neutralSourceColorHct.getTone() + 11.0
                : s.neutralSourceColorHct.getTone() - 6.0;
          }
          return s.isDark
              ? new ContrastCurve(17.0, 17.0, 21.0, 25.0).get(s.contrastLevel)
              : new ContrastCurve(92.0, 92.0, 88.0, 85.0).get(s.contrastLevel);
        },
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor neutralContainerSurfaceHighest() {
    return new DynamicColor(
        /* name= */ "neutral_container_surface_highest",
        /* palette= */ (s) -> s.neutralPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.isDark
                ? s.neutralSourceColorHct.getTone() + 16.0
                : s.neutralSourceColorHct.getTone() - 8.0;
          }
          return s.isDark
              ? new ContrastCurve(22.0, 22.0, 26.0, 30.0).get(s.contrastLevel)
              : new ContrastCurve(90.0, 90.0, 84.0, 80.0).get(s.contrastLevel);
        },
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicColor onNeutralContainer() {
    return new DynamicColor(
        /* name= */ "on_neutral_container",
        /* palette= */ (s) -> s.neutralPalette,
        /* tone= */ (s) -> {
            if (isFidelity(s)) {
                return DynamicColor.foregroundTone(neutralContainerSurface().tone.apply(s), 6.0);
            }
            return s.isDark ? 90.0 : 10.0;
        },
        /* isBackground= */ false,
        /* background= */ this::highestSurface,
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(4.5, 7.0, 11.0, 21.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor onNeutralContainerVariant() {
    return new DynamicColor(
        /* name= */ "on_neutral_container_variant",
        /* palette= */ (s) -> s.mutedPalette,
        /* tone= */ (s) -> s.isDark ? 80.0 : 30.0,
        /* isBackground= */ false,
        /* background= */ this::highestSurface,
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor neutralContainerOutline() {
    return new DynamicColor(
        /* name= */ "neutral_container_outline",
        /* palette= */ (s) -> s.mutedPalette,
        /* tone= */ (s) -> s.isDark ? 20.0 : 50.0,
        /* isBackground= */ false,
        /* background= */ this::highestSurface,
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(1.5, 3.0, 4.5, 7.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor neutralContainerOutlineVariant() {
    return new DynamicColor(
        /* name= */ "neutral_container_outline_variant",
        /* palette= */ (s) -> s.mutedPalette,
        /* tone= */ (s) -> s.isDark ? 40.0 : 80.0,
        /* isBackground= */ false,
        /* background= */ this::highestSurface,
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(1.0, 1.0, 3.0, 4.5),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor primaryContainerSurfaceLowest() {
    return new DynamicColor(
        /* name= */ "primary_container_surface_lowest",
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

  public DynamicColor primaryContainerSurfaceLow() {
    return new DynamicColor(
        /* name= */ "primary_container_surface_low",
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

  public DynamicColor primaryContainerSurface() {
    return new DynamicColor(
        /* name= */ "primary_container_surface",
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

  public DynamicColor primaryContainerSurfaceHigh() {
    return new DynamicColor(
        /* name= */ "primary_container_surface_high",
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

  public DynamicColor primaryContainerSurfaceHighest() {
    return new DynamicColor(
        /* name= */ "primary_container_surface_highest",
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
        /* background= */ (s) -> primaryContainerSurface(),
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
        /* background= */ (s) -> primaryContainerSurface(),
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

  public DynamicColor mutedContainerSurfaceLowest() {
    return new DynamicColor(
        /* name= */ "muted_container_surface_lowest",
        /* palette= */ (s) -> s.mutedPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.isDark
                ? s.mutedSourceColorHct.getTone() - 8.0
                : s.mutedSourceColorHct.getTone() + 8.0;
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

  public DynamicColor mutedContainerSurfaceLow() {
    return new DynamicColor(
        /* name= */ "muted_container_surface_low",
        /* palette= */ (s) -> s.mutedPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.isDark
                ? s.mutedSourceColorHct.getTone() - 2.0
                : s.mutedSourceColorHct.getTone() + 4.0;
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

  public DynamicColor mutedContainerSurface() {
    return new DynamicColor(
        /* name= */ "muted_container_surface",
        /* palette= */ (s) -> s.mutedPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.mutedSourceColorHct.getTone();
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

  public DynamicColor mutedContainerSurfaceHigh() {
    return new DynamicColor(
        /* name= */ "muted_container_surface_high",
        /* palette= */ (s) -> s.mutedPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.isDark
                ? s.mutedSourceColorHct.getTone() + 5.0
                : s.mutedSourceColorHct.getTone() - 2.0;
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

  public DynamicColor mutedContainerSurfaceHighest() {
    return new DynamicColor(
        /* name= */ "muted_container_surface_highest",
        /* palette= */ (s) -> s.mutedPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.isDark
                ? s.mutedSourceColorHct.getTone() + 10.0
                : s.mutedSourceColorHct.getTone() - 4.0;
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

  public DynamicColor onMutedContainer() {
    return new DynamicColor(
        /* name= */ "on_muted_container",
        /* palette= */ (s) -> s.mutedPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return DynamicColor.foregroundTone(mutedContainerSurface().tone.apply(s), 6.0);
          }
          return s.isDark ? 90.0 : 30.0;
        },
        /* isBackground= */ false,
        /* background= */ (s) -> mutedContainerSurface(),
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor onMutedContainerVariant() {
    return new DynamicColor(
        /* name= */ "on_muted_container_variant",
        /* palette= */ (s) -> s.mutedPalette,
        /* tone= */ (s) -> s.isDark ? 80.0 : 30.0,
        /* isBackground= */ false,
        /* background= */ (s) -> mutedContainerSurface(),
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor mutedContainerOutline() {
    return new DynamicColor(
        /* name= */ "muted_container_outline",
        /* palette= */ (s) -> s.mutedPalette,
        /* tone= */ (s) -> s.isDark ? 20.0 : 50.0,
        /* isBackground= */ false,
        /* background= */ this::highestSurface,
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(1.5, 3.0, 4.5, 7.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor mutedContainerOutlineVariant() {
    return new DynamicColor(
        /* name= */ "muted_container_outline_variant",
        /* palette= */ (s) -> s.mutedPalette,
        /* tone= */ (s) -> s.isDark ? 40.0 : 80.0,
        /* isBackground= */ false,
        /* background= */ this::highestSurface,
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(1.0, 1.0, 3.0, 4.5),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor tonalContainerSurfaceLowest() {
    return new DynamicColor(
        /* name= */ "tonal_container_surface_lowest",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.isDark
                ? s.primarySourceColorHct.getTone() - 8.0
                : s.primarySourceColorHct.getTone() + 8.0;
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

  public DynamicColor tonalContainerSurfaceLow() {
    return new DynamicColor(
        /* name= */ "tonal_container_surface_low",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.isDark
                ? s.primarySourceColorHct.getTone() - 2.0
                : s.primarySourceColorHct.getTone() + 4.0;
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

  public DynamicColor tonalContainerSurface() {
    return new DynamicColor(
        /* name= */ "tonal_container_surface",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.primarySourceColorHct.getTone();
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

  public DynamicColor tonalContainerSurfaceHigh() {
    return new DynamicColor(
        /* name= */ "tonal_container_surface_high",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.isDark
                ? s.primarySourceColorHct.getTone() + 5.0
                : s.primarySourceColorHct.getTone() - 2.0;
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

  public DynamicColor tonalContainerSurfaceHighest() {
    return new DynamicColor(
        /* name= */ "tonal_container_surface_highest",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.isDark
                ? s.primarySourceColorHct.getTone() + 10.0
                : s.primarySourceColorHct.getTone() - 4.0;
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
            return DynamicColor.foregroundTone(tonalContainerSurface().tone.apply(s), 6.0);
          }
          return s.isDark ? 90.0 : 30.0;
        },
        /* isBackground= */ false,
        /* background= */ (s) -> tonalContainerSurface(),
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
        /* background= */ (s) -> tonalContainerSurface(),
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor tonalContainerOutline() {
    return new DynamicColor(
        /* name= */ "tonal_container_outline",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> s.isDark ? 20.0 : 50.0,
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
        /* tone= */ (s) -> s.isDark ? 40.0 : 80.0,
        /* isBackground= */ false,
        /* background= */ this::highestSurface,
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(1.0, 1.0, 3.0, 4.5),
        /* toneDeltaPair= */ null);
  }

  public DynamicColor systemErrorContainerSurfaceLowest() {
    return new DynamicColor(
        /* name= */ "system_error_container_surface_lowest",
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

  public DynamicColor systemErrorContainerSurfaceLow() {
    return new DynamicColor(
        /* name= */ "system_error_container_surface_low",
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

  public DynamicColor systemErrorContainerSurface() {
    return new DynamicColor(
        /* name= */ "system_error_container_surface",
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

  public DynamicColor systemErrorContainerSurfaceHigh() {
    return new DynamicColor(
        /* name= */ "system_error_container_surface_high",
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

  public DynamicColor systemErrorContainerSurfaceHighest() {
    return new DynamicColor(
        /* name= */ "system_error_container_surface_highest",
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
        /* background= */ (s) -> systemErrorContainerSurface(),
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
        /* background= */ (s) -> systemErrorContainerSurface(),
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

  public DynamicColor systemWarningContainerSurfaceLowest() {
    return new DynamicColor(
        /* name= */ "system_warning_container_surface_lowest",
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

  public DynamicColor systemWarningContainerSurfaceLow() {
    return new DynamicColor(
        /* name= */ "system_warning_container_surface_low",
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

  public DynamicColor systemWarningContainerSurface() {
    return new DynamicColor(
        /* name= */ "system_warning_container_surface",
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

  public DynamicColor systemWarningContainerSurfaceHigh() {
    return new DynamicColor(
        /* name= */ "system_warning_container_surface_high",
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

  public DynamicColor systemWarningContainerSurfaceHighest() {
    return new DynamicColor(
        /* name= */ "system_warning_container_surface_highest",
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
        /* background= */ (s) -> systemWarningContainerSurface(),
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
        /* background= */ (s) -> systemWarningContainerSurface(),
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

  public DynamicColor systemInfoContainerSurfaceLowest() {
    return new DynamicColor(
        /* name= */ "system_info_container_surface_lowest",
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

  public DynamicColor systemInfoContainerSurfaceLow() {
    return new DynamicColor(
        /* name= */ "system_info_container_surface_low",
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

  public DynamicColor systemInfoContainerSurface() {
    return new DynamicColor(
        /* name= */ "system_info_container_surface",
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

  public DynamicColor systemInfoContainerSurfaceHigh() {
    return new DynamicColor(
        /* name= */ "system_info_container_surface_high",
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

  public DynamicColor systemInfoContainerSurfaceHighest() {
    return new DynamicColor(
        /* name= */ "system_info_container_surface_highest",
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
        /* background= */ (s) -> systemInfoContainerSurface(),
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
        /* background= */ (s) -> systemInfoContainerSurface(),
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

  public DynamicColor systemSuccessContainerSurfaceLowest() {
    return new DynamicColor(
        /* name= */ "system_success_container_surface_lowest",
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

  public DynamicColor systemSuccessContainerSurfaceLow() {
    return new DynamicColor(
        /* name= */ "system_success_container_surface_low",
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

  public DynamicColor systemSuccessContainerSurface() {
    return new DynamicColor(
        /* name= */ "system_success_container_surface",
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

  public DynamicColor systemSuccessContainerSurfaceHigh() {
    return new DynamicColor(
        /* name= */ "system_success_container_surface_high",
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

  public DynamicColor systemSuccessContainerSurfaceHighest() {
    return new DynamicColor(
        /* name= */ "system_success_container_surface_highest",
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
        /* name= */ "on_system_success_container_surface",
        /* palette= */ (s) -> s.systemSuccessPalette,
        /* tone= */ (s) -> s.isDark ? 90.0 : 30.0,
        /* isBackground= */ false,
        /* background= */ (s) -> systemSuccessContainerSurface(),
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
        /* background= */ (s) -> systemSuccessContainerSurface(),
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

  public DynamicColor systemEmergencyContainerSurfaceLowest() {
    return new DynamicColor(
        /* name= */ "system_emergency_container_surface_lowest",
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

  public DynamicColor systemEmergencyContainerSurfaceLow() {
    return new DynamicColor(
        /* name= */ "system_emergency_container_surface_low",
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

  public DynamicColor systemEmergencyContainerSurface() {
    return new DynamicColor(
        /* name= */ "system_emergency_container_surface",
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

  public DynamicColor systemEmergencyContainerSurfaceHigh() {
    return new DynamicColor(
        /* name= */ "system_emergency_container_surface_high",
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

  public DynamicColor systemEmergencyContainerSurfaceHighest() {
    return new DynamicColor(
        /* name= */ "system_emergency_container_surface_highest",
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
        /* background= */ (s) -> systemEmergencyContainerSurface(),
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
        /* background= */ (s) -> systemEmergencyContainerSurface(),
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
    return scheme.isFidelity;
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
