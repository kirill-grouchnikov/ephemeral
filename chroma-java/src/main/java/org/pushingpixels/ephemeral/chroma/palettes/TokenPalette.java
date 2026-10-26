/*
 * Copyright 2022 Google LLC
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

// This is a modified version of the original source code, changed to fit the Chroma needs

/**
 * Interface for accessing named color tokens (roles) in the Ephemeral Design system.
 */
public interface TokenPalette {
  /**
   * Returns the lowest contrast surface container color.
   * @return ARGB color value
   */
  int getContainerSurfaceLowest();

  /**
   * Returns the low contrast surface container color.
   * @return ARGB color value
   */
  int getContainerSurfaceLow();

  /**
   * Returns the base surface container color.
   * @return ARGB color value
   */
  int getContainerSurface();

  /**
   * Returns the high contrast surface container color.
   * @return ARGB color value
   */
  int getContainerSurfaceHigh();

  /**
   * Returns the highest contrast surface container color.
   * @return ARGB color value
   */
  int getContainerSurfaceHighest();

  /**
   * Returns the dimmed surface container color.
   * @return ARGB color value
   */
  int getContainerSurfaceDim();

  /**
   * Returns the bright surface container color.
   * @return ARGB color value
   */
  int getContainerSurfaceBright();

  /**
   * Returns the shadow color.
   * @return ARGB color value
   */
  int getContainerShadow();

  /**
   * Returns the low contrast on-container color.
   * @return ARGB color value
   */
  int getOnContainerLow();

  /**
   * Returns the on-container color.
   * @return ARGB color value
   */
  int getOnContainer();

  /**
   * Returns the high contrast on-container color.
   * @return ARGB color value
   */
  int getOnContainerHigh();

  /**
   * Returns the low contrast outline color.
   * @return ARGB color value
   */
  int getContainerOutlineLow();

  /**
   * Returns the outline color.
   * @return ARGB color value
   */
  int getContainerOutline();

  /**
   * Returns the high contrast outline color.
   * @return ARGB color value
   */
  int getContainerOutlineHigh();

  /**
   * Returns the inverse surface container color.
   * @return ARGB color value
   */
  int getInverseContainerSurface();

  /**
   * Returns the inverse on-container color.
   * @return ARGB color value
   */
  int getInverseOnContainer();

  /**
   * Returns the inverse outline color.
   * @return ARGB color value
   */
  int getInverseContainerOutline();

  /**
   * Returns the complementary outline color.
   * @return ARGB color value
   */
  int getComplementaryContainerOutline();

  /**
   * Returns the complementary on-container color.
   * @return ARGB color value
   */
  int getComplementaryOnContainer();

  /**
   * Returns the accent on-container color.
   * @return ARGB color value
   */
  int getAccentOnContainer();

  /**
   * Returns the marker on-container color.
   * @return ARGB color value
   */
  int getMarkerOnContainer();

  /**
   * Returns the complementary marker on-container color.
   * @return ARGB color value
   */
  int getComplementaryMarkerOnContainer();
}
