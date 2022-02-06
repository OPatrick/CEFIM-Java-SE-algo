package com.patrick.e9i;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 03/02/2022
 * Time: 18:22
 */
public class AlgoTester {

    public static void iterate(IWorker worker, int numberOfTrials, Solutions solutions) {

        double startTime;
        double endTime;
        double duration = 0;

        for (int i=0; i<numberOfTrials; i++) {
            solutions.reset();
            startTime = System.nanoTime();

            worker.exec(solutions);

            endTime = System.nanoTime();
            duration += (endTime - startTime) / 1000.0;
        }
        duration /= numberOfTrials;
        solutions.setDuration(duration);
    }
}
