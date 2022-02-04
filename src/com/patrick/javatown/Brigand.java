package com.patrick.javatown;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 03/02/2022
 * Time: 12:21
 */
public class Brigand extends Humain implements HorsLaLoi, VisagePale {

    public final String MECHANT = "méchant";
    private String look = MECHANT;

    private int nbreDamesEnleves;
    private int recompense = 100;

    public Brigand(String nom) {
        super(nom);
        this.boissonFavorite = "tord-boyaux";
    }

    @Override
    public String quelEstTonNom() {
        return super.quelEstTonNom() + " le " + this.look;
    }

    @Override
    public void presentation() {
        super.presentation();
        parler("J'ai l'air " + this.look + " et j'ai déjà kidnappé " + getNbreDamesEnleves() + " dames !");
        parler("Ma tête est mise à prix " + getMiseAPrix() + "$ !");
    }

    @Override
    public void kidnappe(Dame dame) {
        dame.seFaitKidnapper(this);
        parler("Ah ah ! " + dame.quelEstTonNom() + ", tu es mienne désormais");
        this.nbreDamesEnleves++;
    }

    @Override
    public void estEmprisonne(Cowboy cowboy) {
        parler("Damned, je suis fait ! " + cowboy.quelEstTonNom() + ", tu m’as eu !");
        this.etat = PRISONNIER;
    }

    @Override
    public int getMiseAPrix() {
        return this.recompense;
    }

    public int getNbreDamesEnleves() {
        return this.nbreDamesEnleves;
    }

    public String getLook() {
        return this.look;
    }

    @Override
    public void scalp() {
        parler("Aïe ma tête !");
    }
}
