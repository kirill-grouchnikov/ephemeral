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

/**
 * Configuration for a container's appearance, including dark/light mode,
 * contrast level, and surface range amplitude.
 */
public class ContainerConfiguration {
    private boolean isDark;
    private double contrastLevel;
    private double surfaceRangeAmplitudeFactor;

    /**
     * Returns the default light container configuration.
     * @return a light container configuration with default settings
     */
    public static ContainerConfiguration defaultLight() {
        return new ContainerConfiguration(false, 0.0f, 1.0f);
    }

    /**
     * Returns the default dark container configuration.
     * @return a dark container configuration with default settings
     */
    public static ContainerConfiguration defaultDark() {
        return new ContainerConfiguration(true, 0.0f, 1.0f);
    }

    /**
     * Creates a container configuration with the specified dark mode and contrast level.
     * @param isDark whether the container is in dark mode
     * @param contrastLevel the contrast level (0.0 to 1.0)
     */
    public ContainerConfiguration(boolean isDark, double contrastLevel) {
        this(isDark, contrastLevel, 1.0);
    }

    /**
     * Creates a container configuration with the specified settings.
     * @param isDark whether the container is in dark mode
     * @param contrastLevel the contrast level (0.0 to 1.0)
     * @param surfaceRangeAmplitudeFactor the amplitude factor for surface range
     */
    public ContainerConfiguration(boolean isDark, double contrastLevel, double surfaceRangeAmplitudeFactor) {
        this.isDark = isDark;
        this.contrastLevel = contrastLevel;
        this.surfaceRangeAmplitudeFactor = surfaceRangeAmplitudeFactor;
    }

    /**
     * Returns the contrast level.
     * @return the contrast level
     */
    public double getContrastLevel() {
        return this.contrastLevel;
    }

    /**
     * Returns the surface range amplitude factor.
     * @return the surface range amplitude factor
     */
    public double getSurfaceRangeAmplitudeFactor() {
        return this.surfaceRangeAmplitudeFactor;
    }

    /**
     * Returns whether the container is in dark mode.
     * @return true if dark mode, false otherwise
     */
    public boolean isDark() {
        return this.isDark;
    }
}
