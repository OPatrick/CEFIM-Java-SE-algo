package com.banque;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 31/01/2022
 * Time: 15:00
 */
public class Compte {

    public int numero = 0;
    private float solde = 0f;
    public float decouvertAutorise;

    public void depot(float valeur) {
        if (valeur < 0) {
            System.out.println("Désolé, mais un dépôt d'une valeur négative (" + valeur + " €) est impossible");
            return;
        }
        this.solde += valeur;
        System.out.println("Merci d'avoir déposé " + valeur + " € sur votre compte n° " + this.numero);
    }

    public void retrait(float valeur) {

        if (this.solde + this.decouvertAutorise < valeur) {
            System.out.println("Désolé, mais votre solde du compte n° " + this.numero + ", avec un découvert autorisé de " + this.decouvertAutorise + " €, ne permet pas un retrait de " + valeur + " €");
            return;
        }
        this.solde -= valeur;
        System.out.println("Vous venez de retirer " + valeur + " € de votre compte n° " + this.numero);
    }

    public float getSolde() {

        return this.solde;
    }

    public void afficherSolde() {

        System.out.println("Compte n°" + this.numero + " : " + this.getSolde() + " € (découvert autorisé de : " + this.decouvertAutorise + " €)");
    }

    public void virer(float valeur, Compte destinataire) {

        if (this.solde < valeur) {
            System.out.println("Désolé, mais votre solde du compte n° " + this.numero + " ne permet pas un virement de " + valeur + " €");
            return;
        }
        if (valeur < 0) {
            System.out.println("Désolé, mais un virement d'une valeur négative (" + valeur + " €) est impossible");
            return;
        }
        this.solde -= valeur;
        destinataire.depot(valeur);
        System.out.println("Virement de " + valeur + " € du compte n° " + this.numero + " vers le compte n° " + destinataire.numero);
    }

    public boolean equals(Compte compte) {
        if (compte == null) return false;
        return compte.numero == this.numero;
    }
}
