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
package org.pushingpixels.ephemeral.chroma.utils;

import org.pushingpixels.ephemeral.chroma.dynamiccolor.ContainerConfiguration;
import org.pushingpixels.ephemeral.chroma.dynamiccolor.ContrastCurve;

// This is a modified version of the original source code, changed to fit the Chroma needs

public class ContrastCurveUtils {
    public static ContrastCurve getPrimaryContainerSurfaceLowestCurve(ContainerConfiguration containerConfiguration) {
        double amplitudeFactor = containerConfiguration.getSurfaceRangeAmplitudeFactor();
        if (containerConfiguration.isDark()) {
            double base = 88.0;
            return new ContrastCurve(
                /* low */ base,
                /* normal */ base,
                /* medium */ base + amplitudeFactor * 4.0,
                /* high */ base + amplitudeFactor * 6.0);
        } else {
            double base = 34;
            return new ContrastCurve(
                /* low */ base,
                /* normal */ base,
                /* medium */ base - amplitudeFactor * 2.0,
                /* high */ base - amplitudeFactor * 4.0);
        }
    }

    public static ContrastCurve getPrimaryContainerSurfaceLowCurve(ContainerConfiguration containerConfiguration) {
        double amplitudeFactor = containerConfiguration.getSurfaceRangeAmplitudeFactor();
        if (containerConfiguration.isDark()) {
            double base = 82.0;
            return new ContrastCurve(
                /* low */ base,
                /* normal */ base,
                /* medium */ base + amplitudeFactor * 4.0,
                /* high */ base + amplitudeFactor * 6.0);
        } else {
            double base = 38;
            return new ContrastCurve(
                /* low */ base,
                /* normal */ base,
                /* medium */ base - amplitudeFactor * 2.0,
                /* high */ base - amplitudeFactor * 4.0);
        }
    }

    public static ContrastCurve getPrimaryContainerSurfaceCurve(ContainerConfiguration containerConfiguration) {
        double amplitudeFactor = containerConfiguration.getSurfaceRangeAmplitudeFactor();
        if (containerConfiguration.isDark()) {
            double base = 80.0;
            return new ContrastCurve(
                /* low */ base,
                /* normal */ base,
                /* medium */ base + amplitudeFactor * 4.0,
                /* high */ base + amplitudeFactor * 6.0);
        } else {
            double base = 40;
            return new ContrastCurve(
                /* low */ base,
                /* normal */ base,
                /* medium */ base - amplitudeFactor * 2.0,
                /* high */ base - amplitudeFactor * 4.0);
        }
    }

    public static ContrastCurve getPrimaryContainerSurfaceHighCurve(ContainerConfiguration containerConfiguration) {
        double amplitudeFactor = containerConfiguration.getSurfaceRangeAmplitudeFactor();
        if (containerConfiguration.isDark()) {
            double base = 76;
            return new ContrastCurve(
                /* low */ base,
                /* normal */ base,
                /* medium */ base + amplitudeFactor * 4.0,
                /* high */ base + amplitudeFactor * 6.0);
        } else {
            double base = 45;
            return new ContrastCurve(
                /* low */ base,
                /* normal */ base,
                /* medium */ base - amplitudeFactor * 2.0,
                /* high */ base - amplitudeFactor * 4.0);
        }
    }

    public static ContrastCurve getPrimaryContainerSurfaceHighestCurve(ContainerConfiguration containerConfiguration) {
        double amplitudeFactor = containerConfiguration.getSurfaceRangeAmplitudeFactor();
        if (containerConfiguration.isDark()) {
            double base = 74;
            return new ContrastCurve(
                /* low */ base,
                /* normal */ base,
                /* medium */ base + amplitudeFactor * 4.0,
                /* high */ base + amplitudeFactor * 6.0);
        } else {
            double base = 50;
            return new ContrastCurve(
                /* low */ base,
                /* normal */ base,
                /* medium */ base - amplitudeFactor * 2.0,
                /* high */ base - amplitudeFactor * 4.0);
        }
    }

    public static ContrastCurve getPrimaryContainerSurfaceDimCurve(ContainerConfiguration containerConfiguration) {
        double amplitudeFactor = containerConfiguration.getSurfaceRangeAmplitudeFactor();
        if (containerConfiguration.isDark()) {
            double base = 70;
            return new ContrastCurve(
                /* low */ base,
                /* normal */ base,
                /* medium */ base + amplitudeFactor * 4.0,
                /* high */ base + amplitudeFactor * 6.0);
        } else {
            double base = 32;
            return new ContrastCurve(
                /* low */ base,
                /* normal */ base,
                /* medium */ base - amplitudeFactor * 2.0,
                /* high */ base - amplitudeFactor * 4.0);
        }
    }

    public static ContrastCurve getPrimaryContainerSurfaceBrightCurve(ContainerConfiguration containerConfiguration) {
        double amplitudeFactor = containerConfiguration.getSurfaceRangeAmplitudeFactor();
        if (containerConfiguration.isDark()) {
            double base = 92;
            return new ContrastCurve(
                /* low */ base,
                /* normal */ base,
                /* medium */ base + amplitudeFactor * 4.0,
                /* high */ base + amplitudeFactor * 6.0);
        } else {
            double base = 55;
            return new ContrastCurve(
                /* low */ base,
                /* normal */ base,
                /* medium */ base - amplitudeFactor * 2.0,
                /* high */ base - amplitudeFactor * 4.0);
        }
    }

    public static ContrastCurve getInversePrimaryContainerSurfaceCurve(ContainerConfiguration containerConfiguration) {
        double amplitudeFactor = containerConfiguration.getSurfaceRangeAmplitudeFactor();
        if (containerConfiguration.isDark()) {
            double base = 40;
            return new ContrastCurve(
                /* low */ base,
                /* normal */ base,
                /* medium */ base - amplitudeFactor * 2.0,
                /* high */ base - amplitudeFactor * 4.0);
        } else {
            double base = 80;
            return new ContrastCurve(
                /* low */ base,
                /* normal */ base,
                /* medium */ base + amplitudeFactor * 4.0,
                /* high */ base + amplitudeFactor * 6.0);
        }
    }
}
