package com.patrick.javatown;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 04/02/2022
 * Time: 10:23
 */
public class Indien extends Humain {

    private int nombrePlumes;
    private String totem;

    public Indien(String nom) {
        super(nom);
        this.totem = "Coyote";
        this.boissonFavorite = "jus de racine";
    }

    public Indien(String nom, String totem) {
        super(nom);
        this.boissonFavorite = "jus de racine";
        this.totem = totem;
    }

    @Override
    public void parler(String text) {
        super.parler(text + " Ugh !");
    }

    @Override
    public void presentation() {
        super.presentation();
        parler("Moi avoir " + this.nombrePlumes + " plumes, ah ah !");
    }

    public void scalper(VisagePale visagePale) {
        parler("Moi scalper toi");
        visagePale.scalp();
        this.nombrePlumes++;
    }

    public int getNombrePlumes() {
        return this.nombrePlumes;
    }
}
