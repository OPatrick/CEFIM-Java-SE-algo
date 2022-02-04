package com.javatown;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 04/02/2022
 * Time: 09:48
 */
public class Ripoux extends Sherif implements HorsLaLoi {

    private int nbreDamesEnleves;
    private int recompense = 500;

    public Ripoux(String nom) {
        super(nom);
    }

    @Override
    public void estEmprisonne(Cowboy cowboy) {
        parler("Damned, je suis fait ! " + cowboy.quelEstTonNom() + ", tu m’as eu !");
        this.etat = PRISONNIER;
    }

    @Override
    public void kidnappe(Dame dame) {
        dame.seFaitKidnapper(this);
        parler("Ah ah ! " + dame.quelEstTonNom() + ", tu es mienne désormais");
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
