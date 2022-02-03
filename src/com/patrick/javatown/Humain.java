package com.patrick.javatown;

import java.util.SplittableRandom;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 03/02/2022
 * Time: 12:00
 */
public class Humain {

    private final String nom;
    private final String boissonFavorite = "eau";

    public static String LIBRE = "libre";
    public static String CAPTIVE = "captive";
    public static String PRISON = "prisonnier";

    public Humain(String nom) {
        this.nom = nom;
    }

    public void parler(String text) {
        System.out.println("(" + this.nom + ") « " + text + " »");
    }

    public void presente() {
        System.out.println("Bonjour, je suis " + this.nom + " et j'aime boire de " + this.boissonFavorite);
    }

    public void boire() {
        System.out.println("Ah ! un bon verre de " + this.boissonFavorite + " ! GLOUPS !");
    }

    public String quelEstTonNom() {
        return this.nom;
    }

    public String quelEstTaBoissonFavorite() {
        return this.boissonFavorite;
    }
}
