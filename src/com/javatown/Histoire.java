package com.javatown;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 03/02/2022
 * Time: 11:58
 */
public class Histoire {

    public static void main(String[] args) {

        System.out.println("\nPrésentations :");

        Dame dame = new Dame("Zoupette");
        dame.presentation();
        FemmeBrigand mauvaiseDame = new FemmeBrigand("Jeanne MalTournée");
        mauvaiseDame.presentation();
        Cowboy cowboy = new Cowboy("Horse Rider");
        cowboy.presentation();
        Sherif sherif = new Sherif("Super Cop");
        sherif.presentation();
        Ripoux ripoux = new Ripoux("Ripoux Ytory");
        ripoux.presentation();
        Indien indien = new Indien("Homme-Qui-Subit-Injustice-Des-Blancs");
        indien.presentation();
        Barman barman = new Barman("Mister Cocktails", "Vous le méritez bien");
        barman.presentation();

        System.out.println("\nEt l'histoire commence...");

        mauvaiseDame.kidnappe(dame);
        cowboy.libererDame(dame);
        dame.changerDeRobe("rouge");
        ripoux.kidnappe(dame);
        cowboy.libererDame(dame);
        indien.scalper(ripoux);
        sherif.emprisonne(ripoux);
        barman.servir(sherif);

        System.out.println();
    }
}
