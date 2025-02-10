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

  public DynamicPaletteColor highestSurface(DynamicPalette p) {
    return p.isDark ? surfaceBright() : surfaceDim();
  }

    public DynamicPaletteColor surface() {
        return new DynamicPaletteColor(
            /* name= */ "surface",
            /* tone= */ (p) -> {
            if (isFidelity(p)) {
                return p.sourceColorHct.getTone();
            }
            return p.isDark ? 6.0 : 98.0;
        },
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor surfaceDim() {
        return new DynamicPaletteColor(
            /* name= */ "surface_dim",
            /* tone= */ (p) -> {
            if (isFidelity(p)) {
                return p.isDark ? p.sourceColorHct.getTone() -10.0
                    : p.sourceColorHct.getTone() - 6.0;
            }
            return p.isDark ? 3.0 : new ContrastCurve(87.0, 87.0, 80.0, 75.0).get(p.contrastLevel);
        },
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor surfaceBright() {
        return new DynamicPaletteColor(
            /* name= */ "surface_bright",
            /* tone= */ (p) -> {
            if (isFidelity(p)) {
                return p.isDark ? p.sourceColorHct.getTone() + 12.0
                    : p.sourceColorHct.getTone() + 10.0;
            }
            return p.isDark ? new ContrastCurve(24.0, 24.0, 29.0, 34.0).get(p.contrastLevel) : 99.0;
        },
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor inverseSurface() {
        return new DynamicPaletteColor(
            /* name= */ "inverse_surface",
            /* tone= */ (p) -> p.isDark ? 90.0 : 20.0,
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor tonalContainerSurfaceLowest() {
        return new DynamicPaletteColor(
            /* name= */ "tonal_container_surface_lowest",
            /* tone= */ (p) -> {
            if (isFidelity(p)) {
                return p.isDark
                    ? p.sourceColorHct.getTone() - 8.0
                    : p.sourceColorHct.getTone() + 8.0;
            }
            return p.isDark
                ? new ContrastCurve(22.0, 22.0, 26.0, 28.0).get(p.contrastLevel)
                : new ContrastCurve(94.0, 94.0, 92.0, 90.0).get(p.contrastLevel);
        },
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor tonalContainerSurfaceLow() {
        return new DynamicPaletteColor(
            /* name= */ "tonal_container_surface_low",
            /* tone= */ (p) -> {
            if (isFidelity(p)) {
                return p.isDark
                    ? p.sourceColorHct.getTone() - 2.0
                    : p.sourceColorHct.getTone() + 4.0;
            }
            return p.isDark
                ? new ContrastCurve(28.0, 28.0, 32.0, 34.0).get(p.contrastLevel)
                : new ContrastCurve(92.0, 92.0, 90.0, 88.0).get(p.contrastLevel);
        },
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor tonalContainerSurface() {
        return new DynamicPaletteColor(
            /* name= */ "tonal_container_surface",
            /* tone= */ (p) -> {
            if (isFidelity(p)) {
                return p.sourceColorHct.getTone();
            }
            return p.isDark
                ? new ContrastCurve(30.0, 30.0, 34.0, 36.0).get(p.contrastLevel)
                : new ContrastCurve(90.0, 90.0, 88.0, 86.0).get(p.contrastLevel);
        },
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor tonalContainerSurfaceHigh() {
        return new DynamicPaletteColor(
            /* name= */ "tonal_container_surface_high",
            /* tone= */ (p) -> {
            if (isFidelity(p)) {
                return p.isDark
                    ? p.sourceColorHct.getTone() + 5.0
                    : p.sourceColorHct.getTone() - 2.0;
            }
            return p.isDark
                ? new ContrastCurve(35.0, 35.0, 39.0, 41.0).get(p.contrastLevel)
                : new ContrastCurve(88.0, 88.0, 86.0, 84.0).get(p.contrastLevel);
        },
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor tonalContainerSurfaceHighest() {
        return new DynamicPaletteColor(
            /* name= */ "tonal_container_surface_highest",
            /* tone= */ (p) -> {
            if (isFidelity(p)) {
                return p.isDark
                    ? p.sourceColorHct.getTone() + 10.0
                    : p.sourceColorHct.getTone() - 4.0;
            }
            return p.isDark
                ? new ContrastCurve(40.0, 40.0, 44.0, 46.0).get(p.contrastLevel)
                : new ContrastCurve(86.0, 86.0, 84.0, 82.0).get(p.contrastLevel);
        },
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor onTonalContainer() {
        return new DynamicPaletteColor(
            /* name= */ "on_tonal_container",
            /* tone= */ (p) -> {
            if (isFidelity(p)) {
                return DynamicPaletteColor.foregroundTone(tonalContainerSurface().tone.apply(p),
                    new ContrastCurve(4.5, 6.0, 9.0, 12.0).get(p.contrastLevel),
                    false, p.isDark);
            }
            return p.isDark ? 90.0 : 30.0;
        },
        /* isBackground= */ false,
        /* background= */ (p) -> (isFidelity(p)) ? null : tonalContainerSurface(),
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

    public DynamicPaletteColor primaryContainerSurfaceLowest() {
        return new DynamicPaletteColor(
            /* name= */ "primary_container_surface_lowest",
            /* tone= */ (p) -> p.isDark
            ? new ContrastCurve(88.0, 88.0, 92.0, 94.0).get(p.contrastLevel)
            : new ContrastCurve(34.0, 34.0, 32.0, 30.0).get(p.contrastLevel),
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor primaryContainerSurfaceLow() {
        return new DynamicPaletteColor(
            /* name= */ "primary_container_surface_low",
            /* tone= */ (p) -> p.isDark
            ? new ContrastCurve(82.0, 82.0, 86.0, 88.0).get(p.contrastLevel)
            : new ContrastCurve(38.0, 38.0, 36.0, 34.0).get(p.contrastLevel),
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor primaryContainerSurface() {
        return new DynamicPaletteColor(
            /* name= */ "primary_container_surface",
            /* tone= */ (p) -> p.isDark
            ? new ContrastCurve(80.0, 80.0, 84.0, 86.0).get(p.contrastLevel)
            : new ContrastCurve(40.0, 40.0, 38.0, 36.0).get(p.contrastLevel),
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor primaryContainerSurfaceHigh() {
        return new DynamicPaletteColor(
            /* name= */ "primary_container_surface_high",
            /* tone= */ (p) -> p.isDark
            ? new ContrastCurve(76.0, 76.0, 80.0, 82.0).get(p.contrastLevel)
            : new ContrastCurve(45.0, 45.0, 43.0, 41.0).get(p.contrastLevel),
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor primaryContainerSurfaceHighest() {
        return new DynamicPaletteColor(
            /* name= */ "primary_container_surface_highest",
            /* tone= */ (p) -> p.isDark
            ? new ContrastCurve(74.0, 74.0, 78.0, 80.0).get(p.contrastLevel)
            : new ContrastCurve(50.0, 50.0, 48.0, 46.0).get(p.contrastLevel),
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor onPrimaryContainer() {
        return new DynamicPaletteColor(
            /* name= */ "on_primary_container",
            /* tone= */ (p) -> p.isDark ? 20.0 : 100.0,
            /* isBackground= */ false,
            /* background= */ (p) -> primaryContainerSurface(),
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(4.5, 7.0, 11.0, 21.0));
    }

    public DynamicPaletteColor onPrimaryContainerVariant() {
        return new DynamicPaletteColor(
            /* name= */ "on_primary_container_variant",
            /* tone= */ (p) -> p.isDark ? 30.0 : 95.0,
            /* isBackground= */ false,
            /* background= */ (p) -> primaryContainerSurface(),
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(4.5, 7.0, 11.0, 21.0));
    }

    public DynamicPaletteColor primaryContainerOutline() {
        return new DynamicPaletteColor(
            /* name= */ "primary_container_outline",
            /* tone= */ (p) -> p.isDark ? 30.0 : 100.0,
            /* isBackground= */ false,
            /* background= */ (p) -> primaryContainerSurface(),
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(1.0, 1.0, 3.0, 4.5));
    }

    public DynamicPaletteColor primaryContainerOutlineVariant() {
        return new DynamicPaletteColor(
            /* name= */ "primary_container_outline_variant",
            /* tone= */ (p) -> p.isDark ? 50.0 : 95.0,
            /* isBackground= */ false,
            /* background= */ (p) -> primaryContainerSurface(),
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(1.0, 1.0, 3.0, 4.5));
    }

    public DynamicPaletteColor inversePrimaryContainerSurface() {
        return new DynamicPaletteColor(
            /* name= */ "inverse_primary_container_surface",
            /* tone= */ (p) -> p.isDark
            ? new ContrastCurve(40.0, 40.0, 38.0, 36.0).get(p.contrastLevel)
            : new ContrastCurve(80.0, 80.0, 84.0, 86.0).get(p.contrastLevel),
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor inverseOnPrimaryContainer() {
        return new DynamicPaletteColor(
            /* name= */ "inverse_on_primary_container",
            /* tone= */ (p) -> p.isDark ? 100.0 : 20.0,
            /* isBackground= */ false,
            /* background= */ (p) -> inversePrimaryContainerSurface(),
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(4.5, 7.0, 11.0, 21.0));
    }

    public DynamicPaletteColor inversePrimaryContainerOutline() {
        return new DynamicPaletteColor(
            /* name= */ "inverse_primary_container_outline",
            /* tone= */ (p) -> p.isDark ? 100.0 : 30.0,
            /* isBackground= */ false,
            /* background= */ (p) -> inversePrimaryContainerSurface(),
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(1.0, 1.0, 3.0, 4.5));
    }

    public DynamicPaletteColor complementaryPrimaryContainerOutline() {
        return new DynamicPaletteColor(
            /* name= */ "complementary_primary_container_outline",
            /* tone= */ (p) -> p.isDark ? 70.0 : 0.0,
            /* isBackground= */ false,
            /* background= */ (p) -> inversePrimaryContainerSurface(),
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(1.0, 1.0, 3.0, 4.5));
    }

    private boolean isFidelity(DynamicPalette palette) {
    return palette.isFidelity;
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
