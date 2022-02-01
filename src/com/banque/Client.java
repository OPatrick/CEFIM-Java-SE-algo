package com.banque;

import java.util.Arrays;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 31/01/2022
 * Time: 15:01
 */
public class Client {

    private final String nom;
    private Compte[] comptes = new Compte[0];
    public int nbComptes = 0;

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

        System.out.println("Le client n° " + this.nom +" possède les comptes suivants :");
        float solde = 0;
        for (Compte compte: this.comptes) {
            solde += compte.getSolde();
            compte.afficherSolde();
        }
        System.out.println("Le solde du client " + this.nom + " est de " + solde + " €");
    }

    /**
     * @return int numéro du compte créé
     */
    public int ajouterCompte() {
        if (this.nbComptes == 100) {
            System.out.println("Désolé, chaque cliet est limité à 100 comptes." +
                    "Création d'un nouveau compte impossible");
            return 0;
        }
        this.nbComptes++;
        this.comptes = Arrays. copyOf(comptes, nbComptes);
        this.comptes[nbComptes-1] = Banque.attribuerNouveauCompte();
        return this.comptes[nbComptes-1].numero;
    }

    public Compte[] getComptes() {
        return this.comptes;
    }

    public Compte getCompteCourant() {
        return this.comptes[0];
    }

    public Compte rechercherCompte(int numeroDeCompte) {

        for (Compte compte: this.comptes)
           if (compte.numero == numeroDeCompte)
                return compte;
        return new Compte();
    }

    public void renflouer() {

        if (this.getCompteCourant() == null) {
            System.out.println("Le client " + this.nom + " n'a pas de compte principal !");
            return;
        }
        Compte cp = this.getCompteCourant();
        if (cp.getSolde() >= 0) return;

        float missing = - cp.getSolde();

        // First, look for total "renflouement" from one account
        for (Compte compte: this.comptes) {
            if (! cp.equals(compte) && (compte.getSolde() >= missing)) {
                compte.virer(missing, cp);
                return;
            }
        }

        // Then, look for partial "renflouements" from several accounts
        for (Compte compte: this.comptes) {
            if (cp.getSolde() >= 0) return;
            if (! cp.equals(compte) && (compte.getSolde() >= 0))
                    compte.virer(compte.getSolde(), cp);
        }
    }
}
