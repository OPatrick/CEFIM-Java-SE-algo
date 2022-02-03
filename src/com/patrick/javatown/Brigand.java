package com.patrick.javatown;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 03/02/2022
 * Time: 12:21
 */
public class Brigand extends Humain {

    public final String MECHANT = "méchant";
    private String look = MECHANT;

    private int nbreDamesEnleves;
    private int recompense = 100;
    private String etat = LIBRE;

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

    public void kidnappe(Dame dame) {
        dame.seFaitKidnapper();
        parler("Ah ah ! " + dame.quelEstTonNom() + ", tu es mienne désormais");
        this.nbreDamesEnleves++;
    }

    public void estCapture(Cowboy cowboy) {
        parler("Damned, je suis fait ! " + cowboy.quelEstTonNom() + ", tu m’as eu !");
        this.etat = PRISON;
    }

    public String getEtat() {
        return this.etat;
    }

    public int getMiseAPrix() {
        return this.recompense;
    }

    public int getNbreDamesEnleves() {
        return this.nbreDamesEnleves;
    }

    public String getLook() {
        return this.look;
    }
}