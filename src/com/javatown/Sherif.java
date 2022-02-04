package com.javatown;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 03/02/2022
 * Time: 16:27
 */
public class Sherif extends Cowboy{

    private int nbreHorsLaLoiCoffres;

    public Sherif(String nom) {
        super(nom);
    }

    @Override
    public void presentation() {
        super.presentation();
        parler("J'ai coffré " + getNbreHorsLaLoiCoffres() + " hors la loi");
    }

    @Override
    public String quelEstTonNom() {
        return "Shérif " + super.quelEstTonNom();
    }

    public void emprisonne(HorsLaLoi brigand) {
//        if (brigand instanceof Sherif) return;    TODO tous les sherifs sont honnêtes
        parler("Au nom de la loi, je vous arrête");
        brigand.estEmprisonne(this);
        this.nbreHorsLaLoiCoffres++;
    }

    public void rechercherHorsLaLoi(HorsLaLoi brigand) {
        commenter("OYEZ OYEZ BRAVE GENS !! " + brigand.getMiseAPrix() + " $ a qui arrêtera " + brigand.quelEstTonNom() + ", mort ou vif !!");
    }

    public int getNbreHorsLaLoiCoffres() {
        return this.nbreHorsLaLoiCoffres;
    }
}
