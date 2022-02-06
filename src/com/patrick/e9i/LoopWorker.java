package com.patrick.e9i;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 03/02/2022
 * Time: 08:52
 */
public class LoopWorker implements IWorker {

    @Override
    public String getTitle() {
        return "Boucles imbriquées";
    }

    // a + 13 * b / c  + d + 12 * e - f -11 + g * h / i -10 = 66
    public void exec(Solutions solutions) {
        for (int a = 1; a < 10; a++) {
            for (int b = 1; b < 10; b++) {
                if (b != a) {
                    for (int c = 1; c < 10; c++) {
                        if (c != a && c != b) {
                            for (int d = 1; d < 10; d++) {
                                if (d != a && d != b && d != c) {
                                    for (int e = 1; e < 10; e++) {
                                        if (e != a && e != b && e != c && e != d) {
                                            for (int f = 1; f < 10; f++) {
                                                if (f != a && f != b && f != c && f != d && f != e) {
                                                    for (int g = 1; g < 10; g++) {
                                                        if (g != a && g != b && g != c && g != d && g != e && g != f) {
                                                            for (int h = 1; h < 10; h++) {
                                                                if (h != a && h != b && h != c && h != d && h != e && h != f && h != g) {
                                                                    for (int i = 1; i < 10; i++) {
                                                                        if (i != a && i != b && i != c && i != d && i != e && i != f && i != g && i != h) {

                                                                            solutions.addIterationTic();
                                                                            solutions.addSolution(new int[]{a, b, c, d, e, f, g, h, i});

                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
