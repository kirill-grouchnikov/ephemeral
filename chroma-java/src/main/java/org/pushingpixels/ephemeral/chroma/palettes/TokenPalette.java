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

public interface TokenPalette {
  int getContainerSurfaceLowest();

  int getContainerSurfaceLow();

  int getContainerSurface();

  int getContainerSurfaceHigh();

  int getContainerSurfaceHighest();

  int getContainerSurfaceDim();

  int getContainerSurfaceBright();

  int getContainerShadow();

  int getOnContainerLow();

  int getOnContainer();

  int getOnContainerHigh();

  int getContainerOutlineLow();

  int getContainerOutline();

  int getContainerOutlineHigh();

  int getInverseContainerSurface();

  int getInverseOnContainer();

  int getInverseContainerOutline();

  int getComplementaryContainerOutline();

  int getComplementaryOnContainer();

  int getAccentOnContainer();

  int getMarkerOnContainer();

  int getComplementaryMarkerOnContainer();
}
