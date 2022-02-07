package com.collectionexception.exercice5;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 07/02/2022
 * Time: 15:41
 */
public class OubliStupide {
    public static void main(String[] args) {
        int[] tab = null;
        try {
            System.out.println(tab[2]);
        } catch (NullPointerException e) {
            System.out.println("Il faut toujours initialiser un tableau avant de l'utiliser...");
        }
    }
}
