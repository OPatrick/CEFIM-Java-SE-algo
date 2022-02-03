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
        dame.hurle();
        System.out.println("Dame état : " + dame.getEtat());
        dame.seFaitKidnapper();
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

        Cowboy cowboy = new Cowboy("Super CowBoy");
        cowboy.presentation();
        cowboy.boire();
        cowboy.matterBrigand();
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
        brigand.estCapture(cowboy);
        System.out.println("Brigand état : " + brigand.getEtat());
    }
}
