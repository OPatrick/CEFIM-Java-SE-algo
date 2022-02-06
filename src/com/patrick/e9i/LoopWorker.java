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
//        float resultat =  - 21; // -11 -10
//        float resultat =  0;
//        float resultat;
//        float m1;
//        float m2;
        for (int a = 1; a < 10; a++) {
//            resultat += a;
            for (int b = 1; b < 10; b++) {
                if (b != a) {
//                    m1 = 13 * b;
                    for (int c = 1; c < 10; c++) {
                        if (c != a && c != b) {
//                            resultat +=  m1 /  (float) c;
                            for (int d = 1; d < 10; d++) {
                                if (d != a && d != b && d != c) {
//                                    resultat += d;
                                    for (int e = 1; e < 10; e++) {
                                        if (e != a && e != b && e != c && e != d) {
//                                            resultat += 12 * e;
                                            for (int f = 1; f < 10; f++) {
                                                if (f != a && f != b && f != c && f != d && f != e) {
//                                                    resultat -=  f;
                                                    for (int g = 1; g < 10; g++) {
                                                        if (g != a && g != b && g != c && g != d && g != e && g != f) {
                                                            for (int h = 1; h < 10; h++) {
                                                                if (h != a && h != b && h != c && h != d && h != e && h != f && h != g) {
//                                                                    m2 = g * h;
                                                                    for (int i = 1; i < 10; i++) {
                                                                        if (i != a && i != b && i != c && i != d && i != e && i != f && i != g && i != h) {
//                                                                            resultat += m2 / (float)  i;
//                                                                            resultat -= 21f;
//                                                                            resultat = (float) a - 21f + m1 /(float) c + (float) d + 12f * (float) e - (float) f  + m2 / (float) i;

//                                                                            resultat =  - 21;
//                                                                            resultat += a;
//                                                                            m1 = 13 * b;
//                                                                            resultat +=  m1 /  (float) c;
//                                                                            resultat += d;
//                                                                            resultat += 12 * e;
//                                                                            resultat -=  f;
//                                                                            m2 = g * h;
//                                                                            resultat += m2 / (float)  i;

//                                                                            resultat = -21 + a + 13 * b / (float) c  + d + 12 * e - f  + g * h / (float) i;

//                                                                            if (resultat == 66) {
                                                                                solutions.addSolution(new int[]{a, b, c, d, e, f, g, h, i});
//                                                                            }
                                                                            solutions.addIterationTic();
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
