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
public class RecursiveWorker implements IWorker {

    private Solutions solutions;

    @Override
    public String getTitle() {
        return "Récursivité       ";
    }

    public void exec(Solutions solutions) {

        this.solutions = solutions;
        int[] unsorted= {1,2,3,4,5,6,7,8,9};
        int[] sorted = {};

        magicalSort(sorted, unsorted, 0);
    }

    public void magicalSort(int[] sorted, int[] unsorted, int depth) {

        int[] sortedBigger = Arrays.copyOf(sorted, sorted.length +1);
        int[] shortedUnsorted = new int[unsorted.length-1];;

        depth++;

        this.solutions.addRecursiveTic();

        if (sorted.length == 8) {
            sortedBigger[sorted.length] = unsorted[0];
            this.solutions.addSolution(sortedBigger);
            solutions.setDepth(depth);
            return;
        }

        for (int i=0; i<unsorted.length; i++) {

            // Start to copy up to index in loop
            for(int j=0; j<i; j++) {
                shortedUnsorted[j] = unsorted[j];
            }
            // Shift nth element from unsorted
            sortedBigger[sorted.length] = unsorted[i];
            //  Copy from index excluded
            for(int j=i+1; j<unsorted.length; j++) {
                shortedUnsorted[j-1] = unsorted[j];
            }

            // Call recursive
            magicalSort(sortedBigger, shortedUnsorted, depth);
        }
    }

}
