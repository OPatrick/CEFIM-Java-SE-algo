package com.patrick.javatown;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 03/02/2022
 * Time: 12:22
 */
public class Cowboy extends Humain{

    private  int popularite;
    public static String VAILLANT = "vaillant";
    private String adjectif = VAILLANT;

    public Cowboy(String nom) {
        super(nom);
        this.boissonFavorite = "whisky";
    }

    public void matterBrigand() {
        this.parler("Prend ça, rascal !");
    }

    public void libererDame(Dame dame) {
        this.parler("Une dame avec une si jolie robe " + dame.getRobe() + " ne peut rester prisonnière");
        dame.seFaitLiberer(this);
        this.popularite++;
    }

    public void tirer(HorsLaLoi brigand) {
        commenter("Le " + this.adjectif + " " + this.quelEstTonNom() + " tire sur " + brigand.quelEstTonNom() + ". PAN !");
    }

    public int getPopularite() {
        return this.popularite;
    }

    public String getAdjectif() {
        return this.adjectif;
    }
}
