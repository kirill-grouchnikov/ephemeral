/*
 * Copyright 2021 Google LLC
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

package org.pushingpixels.ephemeral.chroma.palettes;

import org.pushingpixels.ephemeral.chroma.hct.Hct;

import java.util.HashMap;
import java.util.Map;

// This is a modified version of the original source code, changed to fit the Chroma needs

/**
 * A convenience class for retrieving colors that are sourced from an interpolation
 * between two HCT seeds.
 *
 * <p>BimodalTonalPalette is intended for use in a single thread due to its stateful caching.
 */
public final class BimodalTonalPalette implements BaseTonalPalette {
  private final TonalPalette palette1;
  private final TonalPalette palette2;
  private final double transitionToneStart;
  private final double transitionToneEnd;

  private Map<Integer, Integer> cache;

  private BimodalTonalPalette(
      TonalPalette palette1,
      TonalPalette palette2,
      double transitionToneStart,
      double transitionToneEnd) {
    this.palette1 = palette1;
    this.palette2 = palette2;
    this.transitionToneStart = transitionToneStart;
    this.transitionToneEnd = transitionToneEnd;
    this.cache = new HashMap<>();
  }

  public static BimodalTonalPalette from(Hct hct1, Hct hct2, double transitionToneStart,
      double transitionToneEnd) {
    return new BimodalTonalPalette(TonalPalette.fromHct(hct1), TonalPalette.fromHct(hct2),
        transitionToneStart, transitionToneEnd);
  }

  @Override
  public int tone(int tone) {
    int tone1 = this.palette1.tone(tone);
    int tone2 = this.palette2.tone(tone);

    Integer answer = cache.get(tone);
    if (answer == null) {
      if (tone <= this.transitionToneStart) {
        answer = tone1;
      } else if (tone >= this.transitionToneEnd) {
        answer = tone2;
      } else {
        double fraction = (tone - transitionToneStart) / (transitionToneEnd - transitionToneStart);
        // Interpolate hue and chroma, but leave the tone
        Hct hct1 = Hct.fromInt(tone1);
        Hct hct2 = Hct.fromInt(tone2);
        double interpolatedHue =
            hct1.getHue() * (1.0 - fraction) + hct2.getHue() * fraction;
        double interpolatedChroma =
            hct1.getChroma() * (1.0 - fraction) + hct2.getChroma() * fraction;
        answer = Hct.from(interpolatedHue, interpolatedChroma, tone).toInt();
      }
      cache.put(tone, answer);
    }
    return answer;
  }

  /** Given a tone, use hue and chroma of palette to create a color, and return it as HCT. */
  @Override
  public Hct getHct(double tone) {
    Hct hct1 = this.palette1.getHct(tone);
    Hct hct2 = this.palette2.getHct(tone);

    if (tone <= this.transitionToneStart) {
      return hct1;
    } else if (tone >= this.transitionToneEnd) {
      return hct2;
    } else {
      double fraction = (tone - transitionToneStart) / (transitionToneEnd - transitionToneStart);
      // Interpolate hue and chroma, but leave the tone
      double interpolatedHue =
          hct1.getHue() * (1.0 - fraction) + hct2.getHue() * fraction;
      double interpolatedChroma =
          hct1.getChroma() * (1.0 - fraction) + hct2.getChroma() * fraction;
      return Hct.from(interpolatedHue, interpolatedChroma, tone);
    }
  }
}
