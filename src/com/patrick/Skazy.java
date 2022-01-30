package com.patrick;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * (c) Patrick Brouillé
 * User: patrick
 * Date: 28/01/2022
 * Time: 12:10
 */
public class Skazy {

    public static int countRecursive = 0;
    public static int count2 = 0;
    public static int countIterations = 0;
    public static int depth = 0;

    public static void main(String[] args)
    {
        int maxTrials = 1000;

        List<Float> sorted = new ArrayList<>();
        double startTime;
        boolean success = false;
        double endTime;
        double duration = 0;
        double duration2 = 0;
        double duration3 = 0;

        /* Force brute */
        for (int i=0; i<maxTrials; i++) {
            countIterations = 0;
            startTime = System.nanoTime();
            sorted = loops();
            endTime = System.nanoTime();
            duration += (endTime - startTime) / 1000.0;
        }
        duration /= maxTrials;

        System.out.println("\nUne solution est " + sorted);
        System.out.println("Brut force : execution time: " + (int) duration + " µs, " + countIterations + " loop iterations");

        /* Récursivité */
        for (int i=0; i<maxTrials; i++) {
            countRecursive = 0;
            depth = 0;
            List<Float> numbers= Arrays.asList(1f,2f,3f,4f,5f,6f,7f,8f,9f);
            sorted = new ArrayList<>();
            startTime = System.nanoTime();
            success = magicalSort(sorted, numbers);
            endTime = System.nanoTime();
            duration2 += (endTime-startTime)/1000;
        }
        duration2 /= maxTrials;

        if (success) {
            System.out.println("\nUne solution est " + sorted);
        }
        System.out.println("Recursive : execution time: " + (int) duration2 + " µs, " + countRecursive + " recursive iterations, depth : " + depth + "\n");

//        double startTime2 = System.nanoTime();
//        division();
//        double endTime2 = System.nanoTime();
//        System.out.println("Division Force : execution time: " + (endTime2-startTime2)/1000 + "µs, " + count2 + " iterations, depth : " + depth + "\n");

        /* Solution analyse métier */
        for (int i=0; i<maxTrials; i++) {
            countRecursive = 0;
            depth = 0;
            countIterations = 0;
            startTime = System.nanoTime();
            sorted = hybrid();
            endTime = System.nanoTime();
            duration3 += (endTime-startTime)/1000;
        }
        duration3 /= maxTrials;

        if (success) {
            float result =
                    sorted.get(0)
                            + 13 * sorted.get(1) / sorted.get(2)
                            + sorted.get(3)
                            + 12 * sorted.get(4)
                            - sorted.get(5)
                            - 11
                            + sorted.get(6) * sorted.get(7) / sorted.get(8)
                            -10;

            System.out.println("Une solution est " + sorted + " -> check : " + result);
        }
        System.out.println("Hybrid : execution time: " + (int) duration3 + " µs, " + (int) ((duration-duration3)/duration3) + " times better, " + countIterations + " loop iterations, " + countRecursive + " recursive iterations, depth : " + depth);
    }

    public static boolean magicalSort(List<Float> sorted, List<Float> unsorted) {

        countRecursive++;
        depth++;

        if (sorted.size() == 8) {
            float result =
                    sorted.get(0)
                            + 13 * sorted.get(1) / sorted.get(2)
                            + sorted.get(3)
                            + 12 * sorted.get(4)
                            - sorted.get(5)
                            - 11
                            + sorted.get(6) * sorted.get(7) / unsorted.get(0)
                            -10;

            if (result == 66f) {
                sorted.add(unsorted.get(0));
                return true;
            } else {
                depth--;
                return false;
            }
        }
        for (int i=0; i<unsorted.size(); i++) {

            List<Float> shortedUnsorted = new ArrayList<>(unsorted);
            // Shift ième element from unsorted
            float number  = shortedUnsorted.remove(i);
            // Add element to sorted
            sorted.add(number);

            // Call recursive
            if (magicalSort(sorted, shortedUnsorted)) {
                return true;
            } else {
                // Unshift last value from sorted
                sorted.remove(sorted.size()-1);
            }

        }
        depth--;
        return false;
    }

    public static void division() {
        for (int i=1; i<10; i++) {
            float x1 = (float) i;
            float t1 = 13 * x1;
            for (int j=1; j<10; j++) {
                if (j == i) continue;
                float x2 = (float) j;
                float t2 = t1 / x2;
                for (int k = 1; k < 10; k++) {
                    if (k == j || k == i) continue;
                    float x3 = (float) k;
                    for (int l = 1; l < 10; l++) {
                        if (l == k || l == j || l == i) continue;
                        float x4 = (float) l;
                        float t4 = x3 * x4;
                        for (int m = 1; m < 10; m++) {
                            if (m == l || m == k || m == j || m == i) continue;
                            float x5 = (float) m;
                            float t5 = t4 / x5;
                            float result = t2 + t5;

                            if (Math.floor(result) == result) {
//                                System.out.println("13*" + i + "/" + j + " + " + k + "*" + l + "/" + m + " = " + result);
                                count2++;
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public static List<Float> hybrid() {
        for (int i=1; i<10; i++) {
            float x1 = (float) i;
            float t1 = 13 * x1;
            for (int j=1; j<10; j++) {
                if (j == i) continue;
                float x2 = (float) j;
                float t2 = t1 / x2;
                for (int k = 1; k < 10; k++) {
                    if (k == j || k == i) continue;
                    float x3 = (float) k;
                    for (int l = 1; l < 10; l++) {
                        if (l == k || l == j || l == i) continue;
                        float x4 = (float) l;
                        float t4 = x3 * x4;
                        for (int m = 1; m < 10; m++) {
                            if (m == l || m == k || m == j || m == i) continue;
                            float x5 = (float) m;
                            float t5 = t4 / x5;

                            countIterations++;

                            float result = t2 + t5;
//                            System.out.println("13*" + i + "/" + j + " + " + k + "*" + l + "/" + m + " = " + result);

                            if (Math.floor(result) == result) {

                                result -= 21; // -11 - 10;

                                List<Float> sorted = new ArrayList<>();
                                sorted.add(x1);
                                sorted.add(x2);
                                sorted.add(x3);
                                sorted.add(x4);
                                sorted.add(x5);
                                List<Float> unSorted= new ArrayList<>();
                                for (int n = 1; n<10; n++) {
                                    if (n != i && n!= j && n!= k && n!= l && n!= m) {
                                        unSorted.add((float) n);
                                    }
                                }

                                if (magicalSortOptimzed(sorted, unSorted, result)) {
                                    List<Float> newlySorted = new ArrayList<>();
                                    newlySorted.add(sorted.get(5)); // x1
                                    newlySorted.add(sorted.get(0)); // x2
                                    newlySorted.add(sorted.get(1)); // x3
                                    newlySorted.add(sorted.get(6)); // x4
                                    newlySorted.add(sorted.get(7)); // x5
                                    newlySorted.add(sorted.get(8)); // x6
                                    newlySorted.add(sorted.get(2)); // x7
                                    newlySorted.add(sorted.get(3)); // x8
                                    newlySorted.add(sorted.get(4)); // x9
//                                    System.out.println("Une solution est " + newlySorted);
                                    return newlySorted;
                                }
                            }
                        }
                    }
                }
            }
        }
        return new ArrayList<>();
    }

    public static boolean magicalSortOptimzed(List<Float> sorted, List<Float> unsorted, float tempResult) {

        countRecursive++;
        depth++;

        if (sorted.size() == 8) {
            float result = tempResult   // x2, x3, x7, x8, x9
                    + sorted.get(5) // x1
                    + sorted.get(6) // x4
                    + 12 * sorted.get(7) // x5
                    - unsorted.get(0) // x6
                    ;
            if (result == 66f) {
                sorted.add(unsorted.get(0));
                return true;
            } else {
                depth--;
                return false;
            }
        }
        for (int i=0; i<unsorted.size(); i++) {

            List<Float> shortedUnsorted = new ArrayList<>(unsorted);
            // Shift ième element from unsorted
            float number  = shortedUnsorted.remove(i);
            // Add element to sorted
            sorted.add(number);

            // Call recursive
            if (magicalSortOptimzed(sorted, shortedUnsorted, tempResult)) {
                return true;
            } else {
                // Unshift last value from sorted
                sorted.remove(sorted.size()-1);
            }

        }
        depth--;
        return false;
    }

    public static List<Float> loops() {
        for (int i=1; i<10; i++) {
            float x1 = (float) i;
            float t1 = x1 -11 -10;
            for (int j=1; j<10; j++) {
                if (j == i) continue;
                float x2 = (float) j;
                float t2 = 13*x2;
                for (int k = 1; k < 10; k++) {
                    if (k == j || k == i) continue;
                    float x3 = (float) k;
                    float t3 = t1 + t2 / x3;
                    for (int l = 1; l < 10; l++) {
                        if (l == k || l == j || l == i) continue;
                        float x4 = (float) l;
                        float t4 = t3 + x4;
                        for (int m = 1; m < 10; m++) {
                            if (m == l || m == k || m == j || m == i) continue;
                            float x5 = (float) m;
                            float t5 = t4 + 12 * x5;
                            for (int n = 1; n < 10; n++) {
                                if (n == m || n == l || n == k || n == j || n == i) continue;
                                float x6 = (float) n;
                                float t6 = t5 - x6;
                                for (int p = 1; p < 10; p++) {
                                    if (p == n || p == m || p == l || p == k || p == j || p == i) continue;
                                    float x7 = (float) p;
                                    for (int q = 1; q < 10; q++) {
                                        if (q == p || q == n || q == m || q == l || q == k || q == j || q == i) continue;
                                        float x8 = (float) q;
                                        float t8 = x7 * x8;
                                        for (int r = 1; r < 10; r++) {
                                            if (r == q || r == p || r == n || r == m || r == l || r == k || r == j || r == i) continue;
                                            float x9 = (float) r;

                                            float result = t6 + t8 / x9;
//                                            float result =
//                                                    x1
//                                                    + 13 * x2 / x3
//                                                    + x4
//                                                    + 12 * x5
//                                                    - x6
//                                                    - 11
//                                                    + x7 * x8 / x9
//                                                    - 10
                                            ;
                                            if (66f == result) {
//                                                System.out.print("\n" + i + " + 13 * " + j + " / " + k + " + " + l + " + 12 * " + m + " -" + n + " - 11  + " + p + " * " + q + " / " + r + " - 10 = " + result);
                                                return Arrays.asList(x1, x2, x3, x4, x5, x6, x7, x8, x9);
                                            }
                                            countIterations++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return new ArrayList<>();
    }
}
