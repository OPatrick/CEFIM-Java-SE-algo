package com.patrick.e9i;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 05/02/2022
 * Time: 11:24
 *
 *              Equation à 9 Inconnues  :  a + 13 * b / c  + d + 12 * e - f -11 + g * h / i -10 = 66
 */
public class E9iEssaiCalculs {

    static int[][] solutions = {{2, 6, 9, 8, 5, 1, 4, 7, 3}, {2, 6, 9, 8, 5, 1, 7, 4, 3}, {8, 6, 9, 2, 5, 1, 4, 7, 3}, {8, 6, 9, 2, 5, 1, 7, 4, 3}};

    public static void main(String[] args) {

        double startTime;
        double endTime;
        double duration = 0;

        System.out.println("\nEquation à 9 Inconnues  :  a + 13 * b / c  + d + 12 * e - f -11 + g * h / i -10 = 66\n");

        for (int[] solution : solutions) {

            float resultAsFloat;
            int resultAsInt;

            // Calcul du résultat avec cast en float
            startTime = System.nanoTime();
            resultAsFloat =
                    (float) solution[0]
                    + 13f*(float) solution[1]/((float) solution[2])
                    + (float) solution[3]
                    + 12f * (float) solution[4]
                    - (float) solution[5]
                    -11f
                    + (float) solution[6]  * (float) solution[7]  / ((float) solution[8])
                    -10f;
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000.0;
            System.out.print( (resultAsFloat == 66 ? "\u2714  " : " \u2718 "));
            System.out.println(" result as float (" + duration + " µs): (a)[" + ((float) solution[0]) + "] + (13 * b / c)[" + (13f*(float) solution[1]/((float) solution[2])) + "] + (d) [" + ((float) solution[3]) + "] +(12 * e)["
                    + (12f * (float) solution[4]) + "] - (f)[" + ((float) solution[5]) + "] - " + (11f) + " + (g * h / i)["  + ((float) solution[6]  * (float) solution[7]  / ((float) solution[8])) + "] - " + (10f) + " = " + resultAsFloat);

            // Calcul du résultat avec cast en float mais littérales calculées en premier
            startTime = System.nanoTime();
           resultAsFloat =
                    -11f -10f
                    + (float) solution[0]
                    + 13f*(float) solution[1]/((float) solution[2])
                    + (float) solution[3]
                    + 12f * (float) solution[4]
                    - (float) solution[5]
                    + (float) solution[6]  * (float) solution[7]  / ((float) solution[8]);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000.0;
            System.out.print( (resultAsFloat == 66 ? "\u2714  " : " \u2718 ") );
            System.out.println(" result with literals first (" + duration + " µs): -11 -10 + (a)[" + ((float) solution[0]) + "] + (13 * b / c)[" + (13f*(float) solution[1]/((float) solution[2])) + "] + (d) ["
                    + ((float) solution[3]) + "] +(12 * e)[" + (12f * (float) solution[4]) + "] - (f)[" + ((float) solution[5])
                    + "] +  (g * h / i)["  + ((float) solution[6]  * (float) solution[7]  / ((float) solution[8])) + "] = " + resultAsFloat);

            // Calcul du résultat sans cast
            startTime = System.nanoTime();
            resultAsInt =
                    solution[0]
                            + 13 * solution[1] / solution[2]
                            + solution[3]
                            + 12 * solution[4]
                            - solution[5]
                            -11
                            + solution[6]  * solution[7]  / solution[8]
                            -10;
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000.0;
            System.out.print( (resultAsInt == 66 ? "\u2714  " : " \u2718 ") );
            System.out.println(" result as int (" + duration + " µs): (a)[" + solution[0] + "] + (13 * b / c)[" + (13*solution[1]/solution[2]) + "] + (d) [" + solution[3] + "] +(12 * e)["
                    + 12 * solution[4] + "] - (f)[" + solution[5] + "] - " + 11 + " +  (g * h / i)["  + (solution[6]  * solution[7]  / solution[8]) + "] - " + 10 + " = " + resultAsInt);

            // Calcul du résultat avec cast en float uniquement en dénominateur de division
            startTime = System.nanoTime();
            resultAsFloat =
                    solution[0]
                            + 13 * solution[1] / (float) solution[2]
                            + solution[3]
                            + 12 * solution[4]
                            - solution[5]
                            -11
                            + solution[6]  * solution[7]  / (float) solution[8]
                            -10;
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000.0;
            System.out.print( (resultAsFloat == 66 ? "\u2714  " : " \u2718 ") );
            System.out.println(" result with selected casting to float (" + duration + " µs): (a)[" + solution[0] + "] + (13 * b / (float) c)[" + (13*solution[1]/solution[2]) + "] + (d) [" + solution[3] + "] +(12 * e)["
                    + 12 * solution[4] + "] - (f)[" + solution[5] + "] - " + 11 + " +  (g * h / (float) i)["  + (solution[6]  * solution[7]  / solution[8]) + "] - " + 10 + " = " + resultAsFloat);

            // Calcul du résultat avec cast en float uniquement en dénominateur de division et litérales calculées en premier
            startTime = System.nanoTime();
           resultAsFloat =
                             -21
                            + solution[0]
                            + 13 * solution[1] / (float) solution[2]
                            + solution[3]
                            + 12 * solution[4]
                            - solution[5]
                            + solution[6]  * solution[7]  / (float) solution[8];
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000.0;
            System.out.print( (resultAsFloat == 66 ? "\u2714  " : " \u2718 "));
            System.out.println(" result with selected casting to float & litterals first (" + duration + " µs): -21 + (a)[" + solution[0] + "] + (13 * b / (float) c)[" + (13*solution[1]/solution[2]) + "] + (d) [" + solution[3] + "] +(12 * e)["
                    + 12 * solution[4] + "] - (f)[" + solution[5] + "] +  (g * h / (float) i)["  + (solution[6]  * solution[7]  / solution[8]) + "] = " + resultAsFloat);

            System.out.println();
        }
    }

}
