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

import org.pushingpixels.ephemeral.chroma.colorblind.ColorBlindUtils;
import org.pushingpixels.ephemeral.chroma.colorblind.ColorBlindnessKind;
import org.pushingpixels.ephemeral.chroma.hct.Hct;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

// This is a modified version of the original source code, changed to fit the Chroma needs

/**
 * A convenience class for wrapping a tonal palette in one of the supported color blindness modes.
 *
 * <p>ColorBlindTonalPalette is intended for use in a single thread due to its stateful caching.
 */
public final class ColorBlindTonalPalette implements BaseTonalPalette {
  private final BaseTonalPalette palette;
  private final ColorBlindnessKind colorBlindnessKind;

  private Map<Integer, Integer> cache;

  private ColorBlindTonalPalette(BaseTonalPalette palette, ColorBlindnessKind colorBlindnessKind) {
    this.palette = palette;
    this.colorBlindnessKind = colorBlindnessKind;
    this.cache = new HashMap<>();
  }

  public static ColorBlindTonalPalette from(BaseTonalPalette palette, ColorBlindnessKind colorBlindnessKind) {
    return new ColorBlindTonalPalette(palette, colorBlindnessKind);
  }

  @Override
  public int tone(int tone) {
    Integer answer = cache.get(tone);
    if (answer == null) {
      int base = this.palette.tone(tone);
      answer = ColorBlindUtils.getColorBlindColor(new Color(base), this.colorBlindnessKind).getRGB();
      cache.put(tone, answer);
    }
    return answer;
  }

  /** Given a tone, use hue and chroma of palette to create a color, and return it as HCT. */
  @Override
  public Hct getHct(double tone) {
    Hct base = this.palette.getHct(tone);
    return Hct.fromInt(ColorBlindUtils.getColorBlindColor(new Color(base.toInt()), this.colorBlindnessKind).getRGB());
  }
}
