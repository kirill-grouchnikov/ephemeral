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
    return containerSurface();
  }

    public DynamicPaletteColor containerSurfaceLowest() {
        return new DynamicPaletteColor(
            /* name= */ "container_surface_lowest",
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

    public DynamicPaletteColor containerSurfaceLow() {
        return new DynamicPaletteColor(
            /* name= */ "container_surface_low",
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

    public DynamicPaletteColor containerSurface() {
        return new DynamicPaletteColor(
            /* name= */ "container_surface",
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

    public DynamicPaletteColor containerSurfaceHigh() {
        return new DynamicPaletteColor(
            /* name= */ "container_surface_high",
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

    public DynamicPaletteColor containerSurfaceHighest() {
        return new DynamicPaletteColor(
            /* name= */ "container_surface_highest",
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

    public DynamicPaletteColor onContainer() {
        return new DynamicPaletteColor(
            /* name= */ "on_container",
            /* tone= */ (p) -> {
                if (isFidelity(p)) {
                    return DynamicPaletteColor.foregroundTone(containerSurface().tone.apply(p), 6.0);
                }
                return p.isDark ? 90.0 : 30.0;
            },
            /* isBackground= */ false,
            /* background= */ (p) -> containerSurface(),
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0));
    }

    public DynamicPaletteColor onContainerVariant() {
        return new DynamicPaletteColor(
            /* name= */ "on_container_variant",
            /* tone= */ (p) -> p.isDark ? 80.0 : 40.0,
            /* isBackground= */ false,
            /* background= */ (p) -> containerSurface(),
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(3.0, 4.5, 7.0, 11.0));
    }

    public DynamicPaletteColor containerOutline() {
        return new DynamicPaletteColor(
            /* name= */ "container_outline",
            /* tone= */ (p) -> p.isDark ? 20.0 : 50.0,
            /* isBackground= */ false,
            /* background= */ this::highestSurface,
            /* secondBackground= */ null,
            /* contrastCurve= */ new ContrastCurve(1.5, 3.0, 4.5, 7.0));
    }

    public DynamicPaletteColor containerOutlineVariant() {
        return new DynamicPaletteColor(
            /* name= */ "container_outline_variant",
            /* tone= */ (p) -> p.isDark ? 40.0 : 80.0,
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
