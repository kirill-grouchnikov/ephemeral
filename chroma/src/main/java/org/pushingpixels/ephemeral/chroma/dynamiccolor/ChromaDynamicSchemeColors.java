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
public final class ChromaDynamicSchemeColors {
  public ChromaDynamicSchemeColors() {
  }

  public DynamicSchemeColor highestSurface(DynamicScheme s) {
    return s.isNeutralDark ? surfaceBright() : surfaceDim();
  }

  public DynamicSchemeColor surface() {
    return new DynamicSchemeColor(
        /* name= */ "surface",
        /* palette= */ (s) -> s.neutralPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.neutralSourceColorHct.getTone();
          }
          return s.isNeutralDark ? 6.0 : 98.0;
        },
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor surfaceDim() {
    return new DynamicSchemeColor(
        /* name= */ "surface_dim",
        /* palette= */ (s) -> s.neutralPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.isNeutralDark ? s.neutralSourceColorHct.getTone() - 3.0
                : s.neutralSourceColorHct.getTone() - 10.0;
          }
          return s.isNeutralDark ? 3.0 : new ContrastCurve(87.0, 87.0, 80.0, 75.0).get(s.neutralContrastLevel);
        },
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor surfaceBright() {
    return new DynamicSchemeColor(
        /* name= */ "surface_bright",
        /* palette= */ (s) -> s.neutralPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.isNeutralDark ? s.neutralSourceColorHct.getTone() + 18.0
                : s.neutralSourceColorHct.getTone() + 1.0;
          }
          return s.isNeutralDark ? new ContrastCurve(24.0, 24.0, 29.0, 34.0).get(s.neutralContrastLevel) : 99.0;
        },
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

    public DynamicSchemeColor inverseSurface() {
        return new DynamicSchemeColor(
            /* name= */ "inverse_surface",
            /* palette= */ (s) -> s.neutralPalette,
            /* tone= */ (s) -> s.isNeutralDark ? 90.0 : 20.0,
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null,
            /* toneDeltaPair= */ null);
    }

  public DynamicSchemeColor neutralContainerSurfaceLowest() {
    return new DynamicSchemeColor(
        /* name= */ "neutral_container_surface_lowest",
        /* palette= */ (s) -> s.neutralPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.isNeutralDark
                ? s.neutralSourceColorHct.getTone() - 2.0
                : s.neutralSourceColorHct.getTone() + 2.0;
          }
          return s.isNeutralDark ? new ContrastCurve(4.0, 4.0, 2.0, 0.0).get(s.neutralContrastLevel) : 100.0;
        },
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor neutralContainerSurfaceLow() {
    return new DynamicSchemeColor(
        /* name= */ "neutral_container_surface_low",
        /* palette= */ (s) -> s.neutralPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.isNeutralDark
                ? s.neutralSourceColorHct.getTone() + 4.0
                : s.neutralSourceColorHct.getTone() - 2.0;
          }
          return s.isNeutralDark
              ? new ContrastCurve(10.0, 10.0, 11.0, 12.0).get(s.neutralContrastLevel)
              : new ContrastCurve(96.0, 96.0, 96.0, 95.0).get(s.neutralContrastLevel);
        },
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor neutralContainerSurface() {
    return new DynamicSchemeColor(
        /* name= */ "neutral_container_surface",
        /* palette= */ (s) -> s.neutralPalette,
        /* tone= */ (s) -> {
           if (isFidelity(s)) {
             return s.isNeutralDark
                 ? s.neutralSourceColorHct.getTone() + 6.0
                 : s.neutralSourceColorHct.getTone() - 4.0;
           }
           return s.isNeutralDark
               ? new ContrastCurve(12.0, 12.0, 16.0, 20.0).get(s.neutralContrastLevel)
               : new ContrastCurve(94.0, 94.0, 92.0, 90.0).get(s.neutralContrastLevel);
        },
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor neutralContainerSurfaceHigh() {
    return new DynamicSchemeColor(
        /* name= */ "neutral_container_surface_high",
        /* palette= */ (s) -> s.neutralPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.isNeutralDark
                ? s.neutralSourceColorHct.getTone() + 11.0
                : s.neutralSourceColorHct.getTone() - 6.0;
          }
          return s.isNeutralDark
              ? new ContrastCurve(17.0, 17.0, 21.0, 25.0).get(s.neutralContrastLevel)
              : new ContrastCurve(92.0, 92.0, 88.0, 85.0).get(s.neutralContrastLevel);
        },
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor neutralContainerSurfaceHighest() {
    return new DynamicSchemeColor(
        /* name= */ "neutral_container_surface_highest",
        /* palette= */ (s) -> s.neutralPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.isNeutralDark
                ? s.neutralSourceColorHct.getTone() + 16.0
                : s.neutralSourceColorHct.getTone() - 8.0;
          }
          return s.isNeutralDark
              ? new ContrastCurve(22.0, 22.0, 26.0, 30.0).get(s.neutralContrastLevel)
              : new ContrastCurve(90.0, 90.0, 84.0, 80.0).get(s.neutralContrastLevel);
        },
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor onNeutralContainer() {
    return new DynamicSchemeColor(
        /* name= */ "on_neutral_container",
        /* palette= */ (s) -> s.neutralPalette,
        /* tone= */ (s) -> {
            if (isFidelity(s)) {
                return DynamicPaletteColor.foregroundTone(neutralContainerSurface().tone.apply(s),
                    new ContrastCurve(4.5, 6.0, 9.0, 12.0).get(s.neutralContrastLevel),
                    false, s.isNeutralDark);
            }
            return s.isNeutralDark ? 90.0 : 10.0;
        },
        /* isBackground= */ false,
        /* background= */ (s) -> (isFidelity(s)) ? null : highestSurface(s),
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(4.5, 7.0, 11.0, 21.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor onNeutralContainerVariant() {
    return new DynamicSchemeColor(
        /* name= */ "on_neutral_container_variant",
        /* palette= */ (s) -> s.neutralPalette,
        /* tone= */ (s) -> s.isNeutralDark ? 80.0 : 30.0,
        /* isBackground= */ false,
        /* background= */ this::highestSurface,
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor neutralContainerOutline() {
    return new DynamicSchemeColor(
        /* name= */ "neutral_container_outline",
        /* palette= */ (s) -> s.neutralPalette,
        /* tone= */ (s) -> s.isNeutralDark
            ? new ContrastCurve(15.0, 10.0, 5.0, 0.0).get(s.neutralContrastLevel)
            : new ContrastCurve(55.0, 50.0, 40.0, 30.0).get(s.neutralContrastLevel),
        /* isBackground= */ false,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor neutralContainerOutlineVariant() {
    return new DynamicSchemeColor(
        /* name= */ "neutral_container_outline_variant",
        /* palette= */ (s) -> s.neutralPalette,
        /* tone= */ (s) -> s.isNeutralDark
            ? new ContrastCurve(25.0, 20.0, 15.0, 10.0).get(s.neutralContrastLevel)
            : new ContrastCurve(85.0, 80.0, 70.0, 50.0).get(s.neutralContrastLevel),
        /* isBackground= */ false,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

    public DynamicSchemeColor inverseNeutralContainerSurface() {
        return new DynamicSchemeColor(
            /* name= */ "inverse_neutral_container_surface",
            /* palette= */ (s) -> s.neutralPalette,
            /* tone= */ (s) -> s.isNeutralDark
            ? new ContrastCurve(94.0, 94.0, 92.0, 90.0).get(s.neutralContrastLevel)
            : new ContrastCurve(12.0, 12.0, 16.0, 20.0).get(s.neutralContrastLevel),
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null,
            /* toneDeltaPair= */ null);
    }

    public DynamicSchemeColor inverseOnNeutralContainer() {
        return new DynamicSchemeColor(
            /* name= */ "inverse_on_neutral_container",
            /* palette= */ (s) -> s.neutralPalette,
            /* tone= */ (s) -> s.isNeutralDark ? 10.0 : 90.0,
            /* isBackground= */ false,
            /* background= */ (s) -> inverseNeutralContainerSurface(),
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(4.5, 7.0, 11.0, 21.0),
            /* toneDeltaPair= */ null);
    }

    public DynamicSchemeColor inverseNeutralContainerOutline() {
        return new DynamicSchemeColor(
            /* name= */ "inverse_neutral_container_outline",
            /* palette= */ (s) -> s.neutralPalette,
            /* tone= */ (s) -> s.isNeutralDark
                ? new ContrastCurve(55.0, 50.0, 40.0, 30.0).get(s.neutralContrastLevel)
                : new ContrastCurve(15.0, 10.0, 5.0, 0.0).get(s.neutralContrastLevel),
            /* isBackground= */ false,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null,
            /* toneDeltaPair= */ null);
    }

    public DynamicSchemeColor complementaryNeutralContainerOutline() {
        return new DynamicSchemeColor(
            /* name= */ "complementary_neutral_container_outline",
            /* palette= */ (s) -> s.neutralPalette,
            /* tone= */ (s) -> s.isNeutralDark
            ? new ContrastCurve(85.0, 90.0, 95.0, 100.0).get(s.neutralContrastLevel)
            : new ContrastCurve(90.0, 95.0, 98.0, 100.0).get(s.neutralContrastLevel),
            /* isBackground= */ false,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null,
            /* toneDeltaPair= */ null);
    }

  public DynamicSchemeColor primaryContainerSurfaceLowest() {
    return new DynamicSchemeColor(
        /* name= */ "primary_container_surface_lowest",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> s.isPrimaryDark
        ? new ContrastCurve(88.0, 88.0, 92.0, 94.0).get(s.primaryContrastLevel)
        : new ContrastCurve(34.0, 34.0, 32.0, 30.0).get(s.primaryContrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor primaryContainerSurfaceLow() {
    return new DynamicSchemeColor(
        /* name= */ "primary_container_surface_low",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> s.isPrimaryDark
        ? new ContrastCurve(82.0, 82.0, 86.0, 88.0).get(s.primaryContrastLevel)
        : new ContrastCurve(38.0, 38.0, 36.0, 34.0).get(s.primaryContrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor primaryContainerSurface() {
    return new DynamicSchemeColor(
        /* name= */ "primary_container_surface",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> s.isPrimaryDark
        ? new ContrastCurve(80.0, 80.0, 84.0, 86.0).get(s.primaryContrastLevel)
        : new ContrastCurve(40.0, 40.0, 38.0, 36.0).get(s.primaryContrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor primaryContainerSurfaceHigh() {
    return new DynamicSchemeColor(
        /* name= */ "primary_container_surface_high",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> s.isPrimaryDark
        ? new ContrastCurve(76.0, 76.0, 80.0, 82.0).get(s.primaryContrastLevel)
        : new ContrastCurve(45.0, 45.0, 43.0, 41.0).get(s.primaryContrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor primaryContainerSurfaceHighest() {
    return new DynamicSchemeColor(
        /* name= */ "primary_container_surface_highest",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> s.isPrimaryDark
        ? new ContrastCurve(74.0, 74.0, 78.0, 80.0).get(s.primaryContrastLevel)
        : new ContrastCurve(50.0, 50.0, 48.0, 46.0).get(s.primaryContrastLevel),
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor onPrimaryContainer() {
    return new DynamicSchemeColor(
        /* name= */ "on_primary_container",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> s.isPrimaryDark ? 20.0 : 100.0,
        /* isBackground= */ false,
        /* background= */ (s) -> primaryContainerSurface(),
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(4.5, 7.0, 11.0, 21.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor onPrimaryContainerVariant() {
    return new DynamicSchemeColor(
        /* name= */ "on_primary_container_variant",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> s.isPrimaryDark ? 30.0 : 95.0,
        /* isBackground= */ false,
        /* background= */ (s) -> primaryContainerSurface(),
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(4.5, 7.0, 11.0, 21.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor primaryContainerOutline() {
    return new DynamicSchemeColor(
        /* name= */ "primary_container_outline",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> s.isPrimaryDark ? 30.0 : 100.0,
        /* isBackground= */ false,
        /* background= */ (s) -> primaryContainerSurface(),
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(1.0, 1.0, 3.0, 4.5),
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor primaryContainerOutlineVariant() {
    return new DynamicSchemeColor(
        /* name= */ "primary_container_outline_variant",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> s.isPrimaryDark ? 50.0 : 95.0,
        /* isBackground= */ false,
        /* background= */ (s) -> primaryContainerSurface(),
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(1.0, 1.0, 3.0, 4.5),
        /* toneDeltaPair= */ null);
  }

    public DynamicSchemeColor inversePrimaryContainerSurface() {
        return new DynamicSchemeColor(
            /* name= */ "inverse_primary_container_surface",
            /* palette= */ (s) -> s.primaryPalette,
            /* tone= */ (s) -> s.isPrimaryDark
            ? new ContrastCurve(40.0, 40.0, 38.0, 36.0).get(s.primaryContrastLevel)
            : new ContrastCurve(80.0, 80.0, 84.0, 86.0).get(s.primaryContrastLevel),
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null,
            /* toneDeltaPair= */ null);
    }

    public DynamicSchemeColor inverseOnPrimaryContainer() {
        return new DynamicSchemeColor(
            /* name= */ "inverse_on_primary_container",
            /* palette= */ (s) -> s.primaryPalette,
            /* tone= */ (s) -> s.isPrimaryDark ? 100.0 : 20.0,
            /* isBackground= */ false,
            /* background= */ (s) -> inversePrimaryContainerSurface(),
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(4.5, 7.0, 11.0, 21.0),
            /* toneDeltaPair= */ null);
    }

    public DynamicSchemeColor inversePrimaryContainerOutline() {
        return new DynamicSchemeColor(
            /* name= */ "inverse_primary_container_outline",
            /* palette= */ (s) -> s.primaryPalette,
            /* tone= */ (s) -> s.isPrimaryDark ? 100.0 : 30.0,
            /* isBackground= */ false,
            /* background= */ (s) -> inversePrimaryContainerSurface(),
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(1.0, 1.0, 3.0, 4.5),
            /* toneDeltaPair= */ null);
    }

    public DynamicSchemeColor complementaryPrimaryContainerOutline() {
        return new DynamicSchemeColor(
            /* name= */ "complementary_primary_container_outline",
            /* palette= */ (s) -> s.primaryPalette,
            /* tone= */ (s) -> s.isPrimaryDark ? 70.0 : 0.0,
            /* isBackground= */ false,
            /* background= */ (s) -> inversePrimaryContainerSurface(),
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(1.0, 1.0, 3.0, 4.5),
            /* toneDeltaPair= */ null);
    }

  public DynamicSchemeColor mutedContainerSurfaceLowest() {
    return new DynamicSchemeColor(
        /* name= */ "muted_container_surface_lowest",
        /* palette= */ (s) -> s.mutedPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.isMutedDark
                ? s.mutedSourceColorHct.getTone() - 8.0
                : s.mutedSourceColorHct.getTone() + 8.0;
          }
          return s.isMutedDark
              ? new ContrastCurve(22.0, 22.0, 26.0, 28.0).get(s.mutedContrastLevel)
              : new ContrastCurve(94.0, 94.0, 92.0, 90.0).get(s.mutedContrastLevel);
        },
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor mutedContainerSurfaceLow() {
    return new DynamicSchemeColor(
        /* name= */ "muted_container_surface_low",
        /* palette= */ (s) -> s.mutedPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.isMutedDark
                ? s.mutedSourceColorHct.getTone() - 2.0
                : s.mutedSourceColorHct.getTone() + 4.0;
          }
          return s.isMutedDark
              ? new ContrastCurve(28.0, 28.0, 32.0, 34.0).get(s.mutedContrastLevel)
              : new ContrastCurve(92.0, 92.0, 90.0, 88.0).get(s.mutedContrastLevel);
        },
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor mutedContainerSurface() {
    return new DynamicSchemeColor(
        /* name= */ "muted_container_surface",
        /* palette= */ (s) -> s.mutedPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.mutedSourceColorHct.getTone();
          }
          return s.isMutedDark
              ? new ContrastCurve(30.0, 30.0, 34.0, 36.0).get(s.mutedContrastLevel)
              : new ContrastCurve(90.0, 90.0, 88.0, 86.0).get(s.mutedContrastLevel);
        },
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor mutedContainerSurfaceHigh() {
    return new DynamicSchemeColor(
        /* name= */ "muted_container_surface_high",
        /* palette= */ (s) -> s.mutedPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.isMutedDark
                ? s.mutedSourceColorHct.getTone() + 5.0
                : s.mutedSourceColorHct.getTone() - 2.0;
          }
          return s.isMutedDark
              ? new ContrastCurve(35.0, 35.0, 39.0, 41.0).get(s.mutedContrastLevel)
              : new ContrastCurve(88.0, 88.0, 86.0, 84.0).get(s.mutedContrastLevel);
        },
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor mutedContainerSurfaceHighest() {
    return new DynamicSchemeColor(
        /* name= */ "muted_container_surface_highest",
        /* palette= */ (s) -> s.mutedPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.isMutedDark
                ? s.mutedSourceColorHct.getTone() + 10.0
                : s.mutedSourceColorHct.getTone() - 4.0;
          }
          return s.isMutedDark
              ? new ContrastCurve(40.0, 40.0, 44.0, 46.0).get(s.mutedContrastLevel)
              : new ContrastCurve(86.0, 86.0, 84.0, 82.0).get(s.mutedContrastLevel);
        },
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor onMutedContainer() {
    return new DynamicSchemeColor(
        /* name= */ "on_muted_container",
        /* palette= */ (s) -> s.mutedPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
              return DynamicPaletteColor.foregroundTone(mutedContainerSurface().tone.apply(s),
                  new ContrastCurve(4.5, 6.0, 9.0, 12.0).get(s.mutedContrastLevel),
                  false, s.isMutedDark);
          }
          return s.isMutedDark ? 90.0 : 30.0;
        },
        /* isBackground= */ false,
        /* background= */ (s) -> (isFidelity(s)) ? null : mutedContainerSurface(),
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor onMutedContainerVariant() {
    return new DynamicSchemeColor(
        /* name= */ "on_muted_container_variant",
        /* palette= */ (s) -> s.mutedPalette,
        /* tone= */ (s) -> s.isMutedDark ? 80.0 : 30.0,
        /* isBackground= */ false,
        /* background= */ (s) -> mutedContainerSurface(),
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor mutedContainerOutline() {
    return new DynamicSchemeColor(
        /* name= */ "muted_container_outline",
        /* palette= */ (s) -> s.mutedPalette,
        /* tone= */ (s) -> s.isMutedDark
            ? new ContrastCurve(15.0, 10.0, 5.0, 0.0).get(s.mutedContrastLevel)
            : new ContrastCurve(55.0, 50.0, 40.0, 30.0).get(s.mutedContrastLevel),
        /* isBackground= */ false,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor mutedContainerOutlineVariant() {
    return new DynamicSchemeColor(
        /* name= */ "muted_container_outline_variant",
        /* palette= */ (s) -> s.mutedPalette,
        /* tone= */ (s) -> s.isMutedDark
            ? new ContrastCurve(25.0, 20.0, 15.0, 10.0).get(s.mutedContrastLevel)
            : new ContrastCurve(85.0, 80.0, 70.0, 50.0).get(s.mutedContrastLevel),
        /* isBackground= */ false,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

    public DynamicSchemeColor inverseMutedContainerSurface() {
        return new DynamicSchemeColor(
            /* name= */ "inverse_muted_container_surface",
            /* palette= */ (s) -> s.mutedPalette,
            /* tone= */ (s) -> s.isMutedDark
                ? new ContrastCurve(90.0, 90.0, 88.0, 86.0).get(s.mutedContrastLevel)
                : new ContrastCurve(30.0, 30.0, 34.0, 36.0).get(s.mutedContrastLevel),
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null,
            /* toneDeltaPair= */ null);
    }

    public DynamicSchemeColor inverseOnMutedContainer() {
        return new DynamicSchemeColor(
            /* name= */ "inverse_on_muted_container",
            /* palette= */ (s) -> s.mutedPalette,
            /* tone= */ (s) -> s.isMutedDark ? 30.0 : 90.0,
            /* isBackground= */ false,
            /* background= */ (s) -> inverseMutedContainerSurface(),
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0),
            /* toneDeltaPair= */ null);
    }

    public DynamicSchemeColor inverseMutedContainerOutline() {
        return new DynamicSchemeColor(
            /* name= */ "inverse_muted_container_outline",
            /* palette= */ (s) -> s.mutedPalette,
            /* tone= */ (s) -> s.isMutedDark
            ? new ContrastCurve(55.0, 50.0, 40.0, 30.0).get(s.mutedContrastLevel)
            : new ContrastCurve(15.0, 10.0, 5.0, 0.0).get(s.mutedContrastLevel),
            /* isBackground= */ false,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null,
            /* toneDeltaPair= */ null);
    }

    public DynamicSchemeColor complementaryMutedContainerOutline() {
        return new DynamicSchemeColor(
            /* name= */ "complementary_muted_container_outline",
            /* palette= */ (s) -> s.mutedPalette,
            /* tone= */ (s) -> s.isMutedDark
            ? new ContrastCurve(85.0, 90.0, 95.0, 100.0).get(s.mutedContrastLevel)
            : new ContrastCurve(90.0, 95.0, 98.0, 100.0).get(s.mutedContrastLevel),
            /* isBackground= */ false,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null,
            /* toneDeltaPair= */ null);
    }

  public DynamicSchemeColor tonalContainerSurfaceLowest() {
    return new DynamicSchemeColor(
        /* name= */ "tonal_container_surface_lowest",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.isTonalDark
                ? s.primarySourceColorHct.getTone() - 8.0
                : s.primarySourceColorHct.getTone() + 8.0;
          }
          return s.isTonalDark
              ? new ContrastCurve(22.0, 22.0, 26.0, 28.0).get(s.tonalContrastLevel)
              : new ContrastCurve(94.0, 94.0, 92.0, 90.0).get(s.tonalContrastLevel);
        },
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor tonalContainerSurfaceLow() {
    return new DynamicSchemeColor(
        /* name= */ "tonal_container_surface_low",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.isTonalDark
                ? s.primarySourceColorHct.getTone() - 2.0
                : s.primarySourceColorHct.getTone() + 4.0;
          }
          return s.isTonalDark
              ? new ContrastCurve(28.0, 28.0, 32.0, 34.0).get(s.tonalContrastLevel)
              : new ContrastCurve(92.0, 92.0, 90.0, 88.0).get(s.tonalContrastLevel);
        },
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor tonalContainerSurface() {
    return new DynamicSchemeColor(
        /* name= */ "tonal_container_surface",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.primarySourceColorHct.getTone();
          }
          return s.isTonalDark
              ? new ContrastCurve(30.0, 30.0, 34.0, 36.0).get(s.tonalContrastLevel)
              : new ContrastCurve(90.0, 90.0, 88.0, 86.0).get(s.tonalContrastLevel);
        },
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor tonalContainerSurfaceHigh() {
    return new DynamicSchemeColor(
        /* name= */ "tonal_container_surface_high",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.isTonalDark
                ? s.primarySourceColorHct.getTone() + 5.0
                : s.primarySourceColorHct.getTone() - 2.0;
          }
          return s.isTonalDark
              ? new ContrastCurve(35.0, 35.0, 39.0, 41.0).get(s.tonalContrastLevel)
              : new ContrastCurve(88.0, 88.0, 86.0, 84.0).get(s.tonalContrastLevel);
        },
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor tonalContainerSurfaceHighest() {
    return new DynamicSchemeColor(
        /* name= */ "tonal_container_surface_highest",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
            return s.isTonalDark
                ? s.primarySourceColorHct.getTone() + 10.0
                : s.primarySourceColorHct.getTone() - 4.0;
          }
          return s.isTonalDark
              ? new ContrastCurve(40.0, 40.0, 44.0, 46.0).get(s.tonalContrastLevel)
              : new ContrastCurve(86.0, 86.0, 84.0, 82.0).get(s.tonalContrastLevel);
        },
        /* isBackground= */ true,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor onTonalContainer() {
    return new DynamicSchemeColor(
        /* name= */ "on_tonal_container",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> {
          if (isFidelity(s)) {
              return DynamicPaletteColor.foregroundTone(tonalContainerSurface().tone.apply(s),
                  new ContrastCurve(4.5, 6.0, 9.0, 12.0).get(s.tonalContrastLevel),
                  false, s.isTonalDark);
          }
          return s.isTonalDark ? 90.0 : 30.0;
        },
        /* isBackground= */ false,
        /* background= */ (s) -> (isFidelity(s)) ? null : tonalContainerSurface(),
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor onTonalContainerVariant() {
    return new DynamicSchemeColor(
        /* name= */ "on_tonal_container_variant",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> s.isTonalDark ? 80.0 : 40.0,
        /* isBackground= */ false,
        /* background= */ (s) -> tonalContainerSurface(),
        /* secondBackground= */ null,
        /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0),
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor tonalContainerOutline() {
    return new DynamicSchemeColor(
        /* name= */ "tonal_container_outline",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> s.isTonalDark
          ? new ContrastCurve(15.0, 10.0, 5.0, 0.0).get(s.tonalContrastLevel)
          : new ContrastCurve(55.0, 50.0, 40.0, 30.0).get(s.tonalContrastLevel),
        /* isBackground= */ false,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

  public DynamicSchemeColor tonalContainerOutlineVariant() {
    return new DynamicSchemeColor(
        /* name= */ "tonal_container_outline_variant",
        /* palette= */ (s) -> s.primaryPalette,
        /* tone= */ (s) -> s.isTonalDark
            ? new ContrastCurve(25.0, 20.0, 15.0, 10.0).get(s.tonalContrastLevel)
            : new ContrastCurve(85.0, 80.0, 70.0, 50.0).get(s.tonalContrastLevel),
        /* isBackground= */ false,
        /* background= */ null,
        /* secondBackground= */ null,
        /* contrastCurve= */ null,
        /* toneDeltaPair= */ null);
  }

    public DynamicSchemeColor inverseTonalContainerSurface() {
        return new DynamicSchemeColor(
            /* name= */ "inverse_tonal_container_surface",
            /* palette= */ (s) -> s.primaryPalette,
            /* tone= */ (s) -> s.isTonalDark
            ? new ContrastCurve(90.0, 90.0, 88.0, 86.0).get(s.tonalContrastLevel)
            : new ContrastCurve(30.0, 30.0, 34.0, 36.0).get(s.tonalContrastLevel),
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null,
            /* toneDeltaPair= */ null);
    }

    public DynamicSchemeColor inverseOnTonalContainer() {
        return new DynamicSchemeColor(
            /* name= */ "inverse_on_tonal_container",
            /* palette= */ (s) -> s.primaryPalette,
            /* tone= */ (s) -> s.isTonalDark ? 30.0 : 90.0,
            /* isBackground= */ false,
            /* background= */ (s) -> inverseTonalContainerSurface(),
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0),
            /* toneDeltaPair= */ null);
    }

    public DynamicSchemeColor inverseTonalContainerOutline() {
        return new DynamicSchemeColor(
            /* name= */ "inverse_tonal_container_outline",
            /* palette= */ (s) -> s.primaryPalette,
            /* tone= */ (s) -> s.isTonalDark
                ? new ContrastCurve(55.0, 50.0, 40.0, 30.0).get(s.tonalContrastLevel)
                : new ContrastCurve(15.0, 10.0, 5.0, 0.0).get(s.tonalContrastLevel),
            /* isBackground= */ false,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null,
            /* toneDeltaPair= */ null);
    }

    public DynamicSchemeColor complementaryTonalContainerOutline() {
        return new DynamicSchemeColor(
            /* name= */ "complementary_tonal_container_outline",
            /* palette= */ (s) -> s.primaryPalette,
            /* tone= */ (s) -> s.isTonalDark
            ? new ContrastCurve(85.0, 90.0, 95.0, 100.0).get(s.tonalContrastLevel)
            : new ContrastCurve(90.0, 95.0, 98.0, 100.0).get(s.tonalContrastLevel),
            /* isBackground= */ false,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null,
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
