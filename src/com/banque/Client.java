package com.banque;

import java.util.Arrays;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 31/01/2022
 * Time: 15:01
 */
public class Client {

    private String nom;
    private Compte[] comptes = new Compte[0];
    private int nbComptes = 0;

    public Client(String nomDuClient) {
        this.nom = nomDuClient;
        ajouterCompte();
    }

    public String getNom() {
        return this.nom;
    }

    public float getSolde() {
        float solde = 0;
        for (Compte compte: this.comptes)
            solde += compte.getSolde();
        return solde;
    }

    public void afficherSolde() {

        System.out.println("Le solde du client " + this.nom + " est de " + this.getSolde() + " €");
    }

    /**
     * @return int numéro du compte créé
     */
    public int ajouterCompte() {
        if (this.nbComptes == 100) {
            System.out.println("Désolé, chaque cliet est limité à 100 comptes, création d'un nouveau compte impossible");
            return 0;
        }
        this.comptes = Arrays. copyOf(comptes, nbComptes+1);
        this.comptes[nbComptes] = Banque.attribuerNouveauCompte();
        this.nbComptes++;
        return this.comptes[nbComptes-1].numero;
    }

    public Compte[] getComptes() {
        return this.comptes;
    }

    public Compte rechercherCompte(int numeroDeCompte) {
        for (Compte compte: this.comptes)
           if (compte.numero == numeroDeCompte)
                return compte;
        return new Compte();
    }

}
