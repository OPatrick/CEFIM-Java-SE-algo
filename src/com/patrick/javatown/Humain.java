package com.patrick.javatown;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 03/02/2022
 * Time: 12:00
 */
public class Humain {

    private final String nom;
    protected String boissonFavorite = "eau";

    public static String LIBRE = "libre";
    public static String CAPTIVE = "captive";
    public static String PRISON = "prisonnier";

    public Humain(String nom) {
        this.nom = nom;
    }

    public void parler(String text) {
        System.out.println("(" + this.quelEstTonNom() + ") « " + text + " »");
    }

    public void presentation() {
        parler("Bonjour, je suis " + this.quelEstTonNom() + " et j'aime boire du " + this.quelEstTaBoissonFavorite());
    }

    public void boire() {
        parler("Ah ! un bon verre de " + quelEstTaBoissonFavorite() + " ! GLOUPS !");
    }

    public String quelEstTonNom() {
        return this.nom;
    }

    public String quelEstTaBoissonFavorite() {
        return this.boissonFavorite;
    }

    public void commenter(String message) {
        System.out.println("/* " + message + " */");
    }

}
