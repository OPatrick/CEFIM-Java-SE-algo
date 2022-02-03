package com.patrick.javatown;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 03/02/2022
 * Time: 12:23
 */
public class Dame extends Humain{

    private String couleurRobe = "noire";

    private String etat = LIBRE;

    public Dame(String nom) {
        super(nom);
    }

    public void hurle() {
        this.parler("Au secours !");
    }

    public void seFaitKidnapper() {
        this.hurle();
        this.etat = CAPTIVE;
    }

    public void seFaitLiberer(Cowboy cowboy) {
        this.parler("Merci " + cowboy.quelEstTonNom() + " mon héros...");
        this.etat = LIBRE;
    }

    public String getEtat() {
        return this.etat;
    }

    public String getRobe() {
        return this.couleurRobe;
    }

    public void changerDeRobe(String couleur) {

        this.couleurRobe = couleur;
        this.parler("Regardez ma nouvelle robe " + this.couleurRobe);
    }
}
