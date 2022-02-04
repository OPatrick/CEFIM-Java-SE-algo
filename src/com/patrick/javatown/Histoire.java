package com.patrick.javatown;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 03/02/2022
 * Time: 11:58
 */
public class Histoire {

    public static void main(String[] args) {

        /* test classe mère */
        Humain h = new Humain("toto");
        h.presentation();
        h.boire();
        System.out.println();

        /* test classe Dame */
        Dame dame = new Dame("Zoupette");
        dame.presentation();
        dame.boire();
        System.out.println("Couleur robe : " + dame.getRobe());
        dame.changerDeRobe("rouge");
        System.out.println("Dame état : " + dame.getEtat());
        System.out.println();

        /* test classe Brigand */
        Brigand brigand = new Brigand("El Diablo");
        brigand.presentation();
        brigand.boire();
        System.out.println("Mise à prix : " + brigand.getMiseAPrix());
        System.out.println("Brigand état : " + brigand.getEtat());
        System.out.println("Look : " + brigand.getLook());
        System.out.println("Nombre de dames enlevées avant enlèvement : " + brigand.getNbreDamesEnleves());
        brigand.kidnappe(dame);
        System.out.println("Nombre de dames enlevées après enlèvement : " + brigand.getNbreDamesEnleves());
        System.out.println();

        dame.hurle(brigand);
        dame.seFaitKidnapper(brigand);
        System.out.println("Dame état : " + dame.getEtat());
        System.out.println();

        /* test classe Cowboy */
        Cowboy cowboy = new Cowboy("Super CowBoy");
        cowboy.presentation();
        cowboy.boire();
        cowboy.arreterBrigand(brigand);
        cowboy.tirer(brigand);
        System.out.println("Adjectif : " + cowboy.getAdjectif());
        System.out.println("Popularité avant libération de la dame : " + cowboy.getPopularite());
        System.out.println("Cowboy état : " + dame.getEtat());
        cowboy.libererDame(dame);
        System.out.println("Popularité après  libération de la dame : " + cowboy.getPopularite());
        System.out.println("Cowboy état : " + dame.getEtat());

        cowboy.libererDame(dame);
        System.out.println("Dame état : " + dame.getEtat());

        System.out.println("Brigand état : " + brigand.getEtat());
        brigand.estEmprisonne(cowboy);
        System.out.println("Brigand état : " + brigand.getEtat());
        System.out.println();

        /* test classe Brigand */
        Barman barman = new Barman("Mister Cocktail");
        barman.presentation();
        barman.parler("Helllo toi");
        barman.boire();
        barman.servir(h);
        System.out.println();

        /* test classe Shérif */
        Sherif sherif = new Sherif("Fais-moi-Peur");
        sherif.presentation();
        sherif.parler("Helllo toi");
        sherif.boire();
        System.out.println("Nom : " + sherif.quelEstTonNom());
        sherif.rechercherHorsLaLoi(brigand);
        sherif.emprisonne(brigand);
        System.out.println();

        Cowboy clint = new Sherif("Clint");
        clint.presentation();   // Sherif.presentation / Cowboy.presentation / Humain.presentation / (Sherif.quelEstTonNOM + Humain.quelEstTaBoissonFavorite)
        // Un cowboy ne peut pas coffrer de brigand en étant manipulé comme cowbow, caster
        ((Sherif) clint).emprisonne(brigand);
        System.out.println("Nombre brigands coffrés : " + ((Sherif) clint).getNbreHorsLaLoiCoffres());
        System.out.println();

    }
}
