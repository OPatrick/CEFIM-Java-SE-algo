package com.javatown;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 03/02/2022
 * Time: 12:23
 */
public class Dame extends Humain implements VisagePale {

    private String couleurRobe = "noire";

    public Dame(String nom) {
        super(nom);
        this.boissonFavorite = "lait";
    }

    @Override
    public String quelEstTonNom() {
        return "Miss " + super.quelEstTonNom();
    }

    public void hurle(HorsLaLoi brigand) {
        this.parler("Au secours ! " + brigand.quelEstTonNom() + " me veut du mal !");
    }

    public void seFaitKidnapper(HorsLaLoi brigand) {
        this.hurle(brigand);
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

    @Override
    public void scalp() {
        parler("Pas mes cheveux ! Pitié !");
    }

}
