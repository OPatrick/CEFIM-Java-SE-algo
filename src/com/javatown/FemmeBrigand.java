package com.javatown;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 04/02/2022
 * Time: 10:08
 */
public class FemmeBrigand extends Dame implements HorsLaLoi {

    private int nbreDamesEnleves;
    private int recompense = 200;

    public FemmeBrigand(String nom) {
        super(nom);
    }

    @Override
    public void estEmprisonne(Cowboy cowboy) {
        parler("Damned, je suis faite ! " + cowboy.quelEstTonNom() + ", tu m’as eue !");
        this.etat = PRISONNIER;
    }

    @Override
    public void kidnappe(Dame dame) {
        dame.seFaitKidnapper(this);
        parler("Ah ah ! " + dame.quelEstTonNom() + ", tu es ma prisonnière désormais");
        this.nbreDamesEnleves++;
    }

    @Override
    public int getMiseAPrix() {
        return this.recompense;
    }

    public int getNbreDamesEnleves() {
        return this.nbreDamesEnleves;
    }

}
