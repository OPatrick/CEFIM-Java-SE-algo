package com.javatown;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 03/02/2022
 * Time: 12:22
 */
public class Cowboy extends Humain implements VisagePale{

    private  int popularite;
    public static String VAILLANT = "vaillant";
    private String adjectif = VAILLANT;

    public Cowboy(String nom) {
        super(nom);
        this.boissonFavorite = "whisky";
    }

    public void arreterBrigand(HorsLaLoi brigand) {
        this.parler("Prend ça, rascal !");
        brigand.estEmprisonne(this);
    }

    public void libererDame(Dame dame) {
        this.parler("Une dame avec une si jolie robe " + dame.getRobe() + " ne peut rester prisonnière. Je te libère...");
        dame.seFaitLiberer(this);
        this.popularite++;
        this.parler("Tu es la " +  getPopularite() + " ème prisonnière que je libère !");
    }

    public void tirer(HorsLaLoi brigand) {
        commenter("Le " + getAdjectif() + " " + this.quelEstTonNom() + " tire sur " + brigand.quelEstTonNom() + ". PAN !");
    }

    public int getPopularite() {
        return this.popularite;
    }

    public String getAdjectif() {
        return this.adjectif;
    }

    @Override
    public void scalp() {
        parler("Touche pas à mon chapeau ! Aïe ma tête !");
    }

}
