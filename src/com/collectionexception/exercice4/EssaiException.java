package com.collectionexception.exercice4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EssaiException {
    public static void main(String[] args) {
        int a, b, res;
        try (Scanner clavier = new Scanner(System.in)) {    // Non more need to close scanner since it uses automatic resources management
            a = clavier.nextInt();
            b = clavier.nextInt();
            res = a / b;
            System.out.println("le résultat de " + a + " divisé par " + b + " est " + res);
        } catch (ArithmeticException e) {
            System.out.println("oop ! un problème dans la division ");
            System.out.println("le message officiel est " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("oop ! un problème dans l'entrée des données... Essayez des nombres non nuls !");
            System.out.println("le message officiel est " + e.getMessage());
        } finally {
            System.out.println("le bloc finally sera toujours exécuté");
            System.out.println("et c'est là que l'on fermera par exemple les fichiers");
        }
        System.out.println("Fin du programme");
    }
}
