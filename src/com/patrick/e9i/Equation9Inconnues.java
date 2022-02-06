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
 *              " Analysis" :   après analyse métier pour trouver d'autres équations implicites, elle élimine beaucoup de possibilités et minimise le temps de calcul
 *
 *        Une comparaison des performances sur différentes machines :
 *
 */
public class Equation9Inconnues {

    public static void main(String[] args)
    {
        int trials = 10;
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
    }

}
