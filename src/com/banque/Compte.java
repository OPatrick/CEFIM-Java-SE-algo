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

    public void depot(float valeur) {
        this.solde += valeur;
        System.out.println("Merci d'avoir déposé " + valeur + " € sur votre compte n° " + this.numero);
    }

    public void retrait(float valeur) {

        if (this.solde < valeur) {
            System.out.println("Désolé, mais votre solde du compte n° " + this.numero + " ne permet pas un retrait de " + valeur + " €");
        }
        this.solde -= valeur;
    }

    public float getSolde() {

        return this.solde;
    }

    public void afficherSolde() {

        System.out.println("Le solde du compte n°" + this.numero + " est de " + this.getSolde() + " €");
    }

    public void virer(float valeur, Compte destinataire) {

    }
}
