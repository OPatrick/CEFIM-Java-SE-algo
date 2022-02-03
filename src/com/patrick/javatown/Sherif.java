package com.patrick.javatown;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 03/02/2022
 * Time: 16:27
 */
public class Sherif extends Cowboy{

    private int nbreBrigandsCoffres;

    public Sherif(String nom) {
        super(nom);
    }

    @Override
    public void presentation() {
        super.presentation();
        parler("J'ai coffré " + getNbreBrigandsCoffres() + " brigands");
    }

    @Override
    public String quelEstTonNom() {
        return "Shérif " + super.quelEstTonNom();
    }

    public void emprisonne(Brigand brigand) {
//        if (brigand instanceof Sherif) return;    TODO tous les sherifs sont honnêtes
        parler("Au nom de la loi, je vous arrête");
        brigand.estCapture(this);
    }

    public void rechercherBrigand(Brigand brigand) {
        commenter("OYEZ OYEZ BRAVE GENS !! " + brigand.getMiseAPrix() + " $ a qui arrêtera " + brigand.quelEstTonNom() + ", mort ou vif !!");
    }

    public int getNbreBrigandsCoffres() {
        return this.nbreBrigandsCoffres;
    }
}
