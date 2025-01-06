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
    return tonalContainerSurface();
  }

    public DynamicPaletteColor tonalContainerSurfaceLowest() {
        return new DynamicPaletteColor(
            /* name= */ "tonal_container_surface_lowest",
            /* tone= */ (s) -> {
            if (isFidelity(s)) {
                return s.isDark
                    ? s.sourceColorHct.getTone() - 8.0
                    : s.sourceColorHct.getTone() + 8.0;
            }
            return s.isDark
                ? new ContrastCurve(22.0, 22.0, 26.0, 28.0).get(s.contrastLevel)
                : new ContrastCurve(94.0, 94.0, 92.0, 90.0).get(s.contrastLevel);
        },
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor tonalContainerSurfaceLow() {
        return new DynamicPaletteColor(
            /* name= */ "tonal_container_surface_low",
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
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor tonalContainerSurface() {
        return new DynamicPaletteColor(
            /* name= */ "tonal_container_surface",
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
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor tonalContainerSurfaceHigh() {
        return new DynamicPaletteColor(
            /* name= */ "tonal_container_surface_high",
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
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor tonalContainerSurfaceHighest() {
        return new DynamicPaletteColor(
            /* name= */ "tonal_container_surface_highest",
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
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor onTonalContainer() {
        return new DynamicPaletteColor(
            /* name= */ "on_tonal_container",
            /* tone= */ (s) -> {
            if (isFidelity(s)) {
                return DynamicPaletteColor.foregroundTone(tonalContainerSurface().tone.apply(s), 6.0);
            }
            return s.isDark ? 90.0 : 30.0;
        },
            /* isBackground= */ false,
            /* background= */ (s) -> tonalContainerSurface(),
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0));
    }

    public DynamicPaletteColor onTonalContainerVariant() {
        return new DynamicPaletteColor(
            /* name= */ "on_tonal_container_variant",
            /* tone= */ (s) -> s.isDark ? 80.0 : 40.0,
            /* isBackground= */ false,
            /* background= */ (s) -> tonalContainerSurface(),
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0));
    }

    public DynamicPaletteColor tonalContainerOutline() {
        return new DynamicPaletteColor(
            /* name= */ "tonal_container_outline",
            /* tone= */ (s) -> s.isDark ? 20.0 : 50.0,
            /* isBackground= */ false,
            /* background= */ this::highestSurface,
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(1.5, 3.0, 4.5, 7.0));
    }

    public DynamicPaletteColor tonalContainerOutlineVariant() {
        return new DynamicPaletteColor(
            /* name= */ "tonal_container_outline_variant",
            /* tone= */ (s) -> s.isDark ? 40.0 : 80.0,
            /* isBackground= */ false,
            /* background= */ this::highestSurface,
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(1.0, 1.0, 3.0, 4.5));
    }

    public DynamicPaletteColor primaryContainerSurfaceLowest() {
        return new DynamicPaletteColor(
            /* name= */ "primary_container_surface_lowest",
            /* tone= */ (s) -> s.isDark
            ? new ContrastCurve(88.0, 88.0, 92.0, 94.0).get(s.contrastLevel)
            : new ContrastCurve(34.0, 34.0, 32.0, 30.0).get(s.contrastLevel),
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor primaryContainerSurfaceLow() {
        return new DynamicPaletteColor(
            /* name= */ "primary_container_surface_low",
            /* tone= */ (s) -> s.isDark
            ? new ContrastCurve(82.0, 82.0, 86.0, 88.0).get(s.contrastLevel)
            : new ContrastCurve(38.0, 38.0, 36.0, 34.0).get(s.contrastLevel),
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor primaryContainerSurface() {
        return new DynamicPaletteColor(
            /* name= */ "primary_container_surface",
            /* tone= */ (s) -> s.isDark
            ? new ContrastCurve(80.0, 80.0, 84.0, 86.0).get(s.contrastLevel)
            : new ContrastCurve(40.0, 40.0, 38.0, 36.0).get(s.contrastLevel),
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor primaryContainerSurfaceHigh() {
        return new DynamicPaletteColor(
            /* name= */ "primary_container_surface_high",
            /* tone= */ (s) -> s.isDark
            ? new ContrastCurve(76.0, 76.0, 80.0, 82.0).get(s.contrastLevel)
            : new ContrastCurve(45.0, 45.0, 43.0, 41.0).get(s.contrastLevel),
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor primaryContainerSurfaceHighest() {
        return new DynamicPaletteColor(
            /* name= */ "primary_container_surface_highest",
            /* tone= */ (s) -> s.isDark
            ? new ContrastCurve(74.0, 74.0, 78.0, 80.0).get(s.contrastLevel)
            : new ContrastCurve(50.0, 50.0, 48.0, 46.0).get(s.contrastLevel),
            /* isBackground= */ true,
            /* background= */ null,
            /* secondBackground= */ null,
            /* contrastCurve= */ null);
    }

    public DynamicPaletteColor onPrimaryContainer() {
        return new DynamicPaletteColor(
            /* name= */ "on_primary_container",
            /* tone= */ (s) -> s.isDark ? 20.0 : 100.0,
            /* isBackground= */ false,
            /* background= */ (s) -> primaryContainerSurface(),
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(4.5, 7.0, 11.0, 21.0));
    }

    public DynamicPaletteColor onPrimaryContainerVariant() {
        return new DynamicPaletteColor(
            /* name= */ "on_primary_container_variant",
            /* tone= */ (s) -> s.isDark ? 30.0 : 95.0,
            /* isBackground= */ false,
            /* background= */ (s) -> primaryContainerSurface(),
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(4.5, 7.0, 11.0, 21.0));
    }

    public DynamicPaletteColor primaryContainerOutline() {
        return new DynamicPaletteColor(
            /* name= */ "primary_container_outline",
            /* tone= */ (s) -> s.isDark ? 30.0 : 100.0,
            /* isBackground= */ false,
            /* background= */ this::highestSurface,
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(1.0, 1.0, 3.0, 4.5),
            /* toneDeltaPair= */ null);
    }

    public DynamicPaletteColor primaryContainerOutlineVariant() {
        return new DynamicPaletteColor(
            /* name= */ "primary_container_outline_variant",
            /* tone= */ (s) -> s.isDark ? 50.0 : 95.0,
            /* isBackground= */ false,
            /* background= */ this::highestSurface,
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
