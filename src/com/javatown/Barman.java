package com.javatown;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 03/02/2022
 * Time: 16:01
 */
public class Barman extends Humain {

    private String nomDuBar;

    public Barman(String nom) {
        super(nom);
        this.boissonFavorite = "vin";
        this.nomDuBar = "Chez " + nom;
    }

    public Barman(String nom, String nomDuBar) {
        super(nom);
        this.boissonFavorite = "vin";
        this.nomDuBar = nomDuBar;
    }

    @Override
    public void presentation() {
        super.presentation();
        parler("Mon bar s'appelle " + this.nomDuBar);
    }

    @Override
    public void parler(String text) {
        super.parler(text + " Coco");
    }

    public void servir(Humain humain) {
        parler("Voici " + humain.quelEstTonNom() + " ton verre favoris : " + humain.quelEstTaBoissonFavorite());
    }
}
