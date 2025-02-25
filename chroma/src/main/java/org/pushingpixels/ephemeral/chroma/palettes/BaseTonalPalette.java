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

// This is a modified version of the original source code, changed to fit the Chroma needs

public interface BaseTonalPalette {
  /**
   * Create an ARGB color from this palette and the provided HCT tone.
   *
   * @param tone HCT tone, measured from 0 to 100.
   * @return ARGB representation of a color with that tone.
   */
  public int tone(int tone);

  /**
   * Given a tone, return the HCT color that corresponds to it in this palette.
   */
  public Hct getHct(double tone);
}
