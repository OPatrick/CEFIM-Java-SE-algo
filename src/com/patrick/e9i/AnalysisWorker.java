package com.patrick.e9i;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 03/02/2022
 * Time: 08:52
 */
public class AnalysisWorker implements IWorker {

    private Solutions solutions;

    @Override
    public String getTitle() {
        return "Analyse métier";
    }

    public void exec(Solutions solutions) {

        this.solutions = solutions;
//        float result = 0f;

        for (int i=1; i<10; i++) {
//            result += 13f * (float) i;
            for (int j=1; j<10; j++) {
                if (j == i) continue;
//                result /= (float) j;
                for (int k = 1; k < 10; k++) {
                    if (k == j || k == i) continue;
//                    float x3 = (float) k;
                    for (int l = 1; l < 10; l++) {
                        if (l == k || l == j || l == i) continue;
//                        float x4 = (float) l;
//                        float t4 = x3 * x4;
                        for (int m = 1; m < 10; m++) {
                            if (m == l || m == k || m == j || m == i) continue;
//                            float x5 = (float) m;
//                            float t5 = t4 / x5;

                            this.solutions.addIterationTic();

//                            result += t5;
//                            System.out.println("13*" + i + "/" + j + " + " + k + "*" + l + "/" + m + " = " + result);
                            float result = 13 * i / (float) j + k * l / (float) m -21;

                            if (Math.round(result) == result) {

//                                result -= 21; // -11 - 10;

                                int[] sorted = new int[]{i, j, k, l, m};
                                int[] unSorted= new int[4];
                                int index = 0;
                                for (int n = 1; n<10; n++) {
                                    if (n != i && n!= j && n!= k && n!= l && n!= m) {
                                        unSorted[index] = n;
                                        index++;
                                    }
                                }

                                magicalSortOptimzed(sorted, unSorted, (int) result, 0);
                            }
                        }
                    }
                }
            }
        }
    }

    public void magicalSortOptimzed(int[] sorted, int[] unsorted, int tempResult, int depth) {

        int[] sortedBigger = Arrays.copyOf(sorted, sorted.length +1);
        int[] shortedUnsorted;

        depth++;

        this.solutions.addRecursiveTic();

        if (sorted.length == 8) {
                solutions.addSolution(new int[]{sorted[5], sorted[0], sorted[1], sorted[6], sorted[7], unsorted[0], sorted[2], sorted[3], sorted[4]});
                solutions.setDepth(depth);
            return ;
        }
        for (int i=0; i<unsorted.length; i++) {

            // Start to copy up to index in loop
            shortedUnsorted =  new int[unsorted.length-1];
            for(int key=0; key<i; key++) {
                shortedUnsorted[key] = unsorted[key];
            }
            // Shift ième element from unsorted
            sortedBigger[sorted.length] = unsorted[i];
            //  Copy from index excluded
            for(int key=i+1; key<unsorted.length; key++) {
                shortedUnsorted[key-1] = unsorted[key];
            }

            // Call recursive
            magicalSortOptimzed(sortedBigger, shortedUnsorted, tempResult, depth);
        }
    }

}
