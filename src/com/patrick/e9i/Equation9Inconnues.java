package com.patrick.e9i;

/**
 * (c) Patrick Brouillé
 * User: patrick
 * Date: 28/01/2022
 * Time: 12:10
 *
 *         Exercice Java de base (sans framework)
 *
 *         Trouver un algorithme avec au moins une solution pour l'équation suivante :
 *              x1 + 13 * x2 / x3  + x4 + 12 x5 - x6 -11 + x7 * x8 / x9 -10 = 66
 *
 *         3 solutions sont envisagées :
 *              "Brut force" :  9 boucles imbriquées
 *              "Recursive" :  appels récursifs d'une même fonction en changeant ses paramètres
 *              "Hybrid" :       après analyse métier pour trouver d'autres équations implicites, elle élimine beaucoup de possibilités et minimise les temps de calcul
 *
 *        Une comparaison des performances sur différentes machines :
 *
 */
public class Equation9Inconnues {

    public static void main(String[] args)
    {
        int trials = 1;
        IWorker[] workers = new IWorker[3];

        /* Force brute */
        workers[0] = new LoopWorker();

        /* Récursivité */
        workers[1] = new RecursiveWorker();

        /* Analyse métier */
        workers[2] = new AnalysisWorker();

        System.out.println("\n");

        for (IWorker worker : workers) {
            Solutions solutions =  new Solutions();
            AlgoTester.iterate(worker, trials, solutions);
            System.out.print(worker.getTitle() + " | ");
            System.out.println(solutions);


        }

//        double d = 2/3;
//        System.out.println("d = " + d);
//        float f = 2/3f;
//        System.out.println("f = " + f);

//        System.out.println("\nUne solution est " + sorted);
//        System.out.println("Brut force : execution time: " + (int) duration + " µs, " + countIterations + " loop iterations");

        /* Récursivité */
//        for (int i=0; i<maxTrials; i++) {
//            countRecursive = 0;
//            depth = 0;
//            List<Float> numbers= Arrays.asList(1f,2f,3f,4f,5f,6f,7f,8f,9f);
//            sorted = new ArrayList<>();
//            startTime = System.nanoTime();
//            success = magicalSort(sorted, numbers);
//            endTime = System.nanoTime();
//            duration2 += (endTime-startTime)/1000;
//        }
//        duration2 /= maxTrials;
//
//        if (success) {
//            System.out.println("\nUne solution est " + sorted);
//        }
//        System.out.println("Recursive : execution time: " + (int) duration2 + " µs, " + countRecursive + " recursive iterations, depth : " + depth + "\n");

        /* Solution analyse métier */
//        for (int i=0; i<maxTrials; i++) {
//            countRecursive = 0;
//            depth = 0;
//            countIterations = 0;
//            startTime = System.nanoTime();
//            sorted = hybrid();
//            endTime = System.nanoTime();
//            duration3 += (endTime-startTime)/1000;
//        }
//        duration3 /= maxTrials;
//
//        if (success) {
//            float result =
//                    sorted.get(0)
//                            + 13 * sorted.get(1) / sorted.get(2)
//                            + sorted.get(3)
//                            + 12 * sorted.get(4)
//                            - sorted.get(5)
//                            - 11
//                            + sorted.get(6) * sorted.get(7) / sorted.get(8)
//                            -10;
//
//            System.out.println("Une solution est " + sorted + " -> check : " + result);
//        }
//        System.out.println("Hybrid : execution time: " + (int) duration3 + " µs, " + (int) ((duration-duration3)/duration3) + " times better, " + countIterations + " loop iterations, " + countRecursive + " recursive iterations, depth : " + depth);

        /* Solution Arthur */

//        for (int i=0; i<maxTrials; i++) {
//            countIterations = 0;
//            startTime = System.nanoTime();
//            solutions = listArthur();
//            endTime = System.nanoTime();
//            duration4 += (endTime-startTime)/1000;
//        }
//        duration4 /= maxTrials;
//
//        System.out.println("\nLes solutions sont :");
//        for (int[] solution : solutions) {
//            float result =
//                    solution[0]
//                    + 13 * solution[1] / (float) solution[2]
//                    + solution[3]
//                    + 12 * solution[4]
//                    - solution[5]
//                    - 11
//                    + solution[6] * solution[7] / (float) solution[8]
//                    -10;
//            System.out.println(Arrays.toString(solution) + " -> " + result);
//        }

//        System.out.println("Arthur : execution time: " + (int) duration4 + " µs, " + countIterations + " loop iterations, " + solutions.size() + " solutions ");

//        for (int[] solution : solutions) {
//            System.out.println(Arrays.toString(solution));
//        }

    }

}
