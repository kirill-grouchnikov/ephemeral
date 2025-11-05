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
package org.pushingpixels.ephemeral.chroma.dynamiccolor;

// This is a modified version of the original source code, changed to fit the Chroma needs

public class ContainerConfiguration {
    private boolean isDark;
    private double contrastLevel;
    private double surfaceRangeAmplitudeFactor;

    public static ContainerConfiguration defaultLight() {
        return new ContainerConfiguration(false, 0.0f, 1.0f);
    }

    public static ContainerConfiguration defaultDark() {
        return new ContainerConfiguration(true, 0.0f, 1.0f);
    }

    public ContainerConfiguration(boolean isDark, double contrastLevel) {
        this(isDark, contrastLevel, 1.0);
    }

    public ContainerConfiguration(boolean isDark, double contrastLevel, double surfaceRangeAmplitudeFactor) {
        this.isDark = isDark;
        this.contrastLevel = contrastLevel;
        this.surfaceRangeAmplitudeFactor = surfaceRangeAmplitudeFactor;
    }

    public double getContrastLevel() {
        return this.contrastLevel;
    }

    public double getSurfaceRangeAmplitudeFactor() {
        return this.surfaceRangeAmplitudeFactor;
    }

    public boolean isDark() {
        return this.isDark;
    }
}
