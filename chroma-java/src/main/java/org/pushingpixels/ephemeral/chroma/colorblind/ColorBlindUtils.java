/*
 * Copyright 2025-2026 Ephemeral
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
package org.pushingpixels.ephemeral.chroma.colorblind;

import java.awt.*;

public class ColorBlindUtils {
    /**
     * Matrix for converting RGB to LMS.
     */
    private static double[][] rgbToLms = {
        { 0.05059983, 0.08585369, 0.00952420 },
        { 0.01893033, 0.08925308, 0.01370054 },
        { 0.00292202, 0.00975732, 0.07145979 }
    };

    /**
     * Matrix for converting LMS to RGB.
     */
    private static double[][] lmsToRgb = {
        { 30.830854, -29.832659, 1.610474 },
        { -6.481468, 17.715578, -2.532642 },
        { -0.375690, -1.199062, 14.273846 }
    };

    /**
     * Converts the specified color into color-blind version.
     *
     * @param orig     The original color.
     * @param kind     Color-blindness kind.
     * @return Color-blind version of the original color.
     */
    public static Color getColorBlindColor(Color orig, ColorBlindnessKind kind) {
        double r = orig.getRed();
        double g = orig.getGreen();
        double b = orig.getBlue();

        double[] rgbOrig = new double[] { r, g, b };
        double[] lms = mult3(rgbToLms, rgbOrig);
        double tmp = 0.0;

        double[] anchor = { 0.08008, 0.1579, 0.5897, 0.1284, 0.2237, 0.3636,
            0.9856, 0.7325, 0.001079, 0.0914, 0.007009, 0.0 };

        double[] rgbAnchor = {
            rgbToLms[0][0] + rgbToLms[0][1] + rgbToLms[0][2],
            rgbToLms[1][0] + rgbToLms[1][1] + rgbToLms[1][2],
            rgbToLms[2][0] + rgbToLms[2][1] + rgbToLms[2][2] };

        double a1, a2, b1, b2, c1, c2, inflection;

        switch (kind) {
            case PROTANOPIA:
                a1 = rgbAnchor[1] * anchor[8] - rgbAnchor[2] * anchor[7];
                b1 = rgbAnchor[2] * anchor[6] - rgbAnchor[0] * anchor[8];
                c1 = rgbAnchor[0] * anchor[7] - rgbAnchor[1] * anchor[6];
                a2 = rgbAnchor[1] * anchor[2] - rgbAnchor[2] * anchor[1];
                b2 = rgbAnchor[2] * anchor[0] - rgbAnchor[0] * anchor[2];
                c2 = rgbAnchor[0] * anchor[1] - rgbAnchor[1] * anchor[0];
                inflection = rgbAnchor[2] / rgbAnchor[1];
                tmp = lms[2] / lms[1];
                if (tmp < inflection)
                    lms[0] = -(b1 * lms[1] + c1 * lms[2]) / a1;
                else
                    lms[0] = -(b2 * lms[1] + c2 * lms[2]) / a2;
                break;

            case DEUTERANOPIA:
                a1 = rgbAnchor[1] * anchor[8] - rgbAnchor[2] * anchor[7];
                b1 = rgbAnchor[2] * anchor[6] - rgbAnchor[0] * anchor[8];
                c1 = rgbAnchor[0] * anchor[7] - rgbAnchor[1] * anchor[6];
                a2 = rgbAnchor[1] * anchor[2] - rgbAnchor[2] * anchor[1];
                b2 = rgbAnchor[2] * anchor[0] - rgbAnchor[0] * anchor[2];
                c2 = rgbAnchor[0] * anchor[1] - rgbAnchor[1] * anchor[0];
                inflection = rgbAnchor[2] / rgbAnchor[0];
                tmp = lms[2] / lms[0];
                /* See which side of the inflection line we fall... */
                if (tmp < inflection)
                    lms[1] = -(a1 * lms[0] + c1 * lms[2]) / b1;
                else
                    lms[1] = -(a2 * lms[0] + c2 * lms[2]) / b2;
                break;

            case TRITANOPIA:
                a1 = rgbAnchor[1] * anchor[11] - rgbAnchor[2] * anchor[10];
                b1 = rgbAnchor[2] * anchor[9] - rgbAnchor[0] * anchor[11];
                c1 = rgbAnchor[0] * anchor[10] - rgbAnchor[1] * anchor[9];
                a2 = rgbAnchor[1] * anchor[5] - rgbAnchor[2] * anchor[4];
                b2 = rgbAnchor[2] * anchor[3] - rgbAnchor[0] * anchor[5];
                c2 = rgbAnchor[0] * anchor[4] - rgbAnchor[1] * anchor[3];
                inflection = (rgbAnchor[1] / rgbAnchor[0]);
                tmp = lms[1] / lms[0];
                if (tmp < inflection)
                    lms[2] = -(a1 * lms[0] + b1 * lms[1]) / c1;
                else
                    lms[2] = -(a2 * lms[0] + b2 * lms[1]) / c2;
                break;

            default:
                break;
        }
        double[] rgbCb = mult3(lmsToRgb, lms);

        double nr = Math.min(255.0, Math.max(0.0, rgbCb[0]));
        double ng = Math.min(255.0, Math.max(0.0, rgbCb[1]));
        double nb = Math.min(255.0, Math.max(0.0, rgbCb[2]));
        return new Color((int) nr, (int) ng, (int) nb);
    }

    /**
     * Multiplies the specified 3x3 matrix by the specified 3x1 vector.
     *
     * @param matrix Matrix.
     * @param vector Vector.
     * @return Vector multiplication.
     */
    private static double[] mult3(double[][] matrix, double[] vector) {
        double[] res = new double[3];
        res[0] = matrix[0][0] * vector[0] + matrix[0][1] * vector[1]
            + matrix[0][2] * vector[2];
        res[1] = matrix[1][0] * vector[0] + matrix[1][1] * vector[1]
            + matrix[1][2] * vector[2];
        res[2] = matrix[2][0] * vector[0] + matrix[2][1] * vector[1]
            + matrix[2][2] * vector[2];
        return res;
    }
}
