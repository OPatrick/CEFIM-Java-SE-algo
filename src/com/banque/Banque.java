package com.banque;

import java.util.Arrays;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 31/01/2022
 * Time: 15:01
 */
public class Banque {

    public String nom = "Free Bank for You";
    private Client[] clients = new Client[1];
    private static int dernierNumeroCompte = 1000;

    public void ajouterClient(String nom) {

        Client client = new Client(nom);
        this.clients = Arrays.copyOf(this.clients, this.clients.length + 1);
        this.clients[this.clients.length-1] = client;
        System.out.println("Bienvenue à " + client.getNom() + ", un nouveau compte a été créé avec le numéro " + client.getComptePrincipal().numero);
    }

    public static Compte attribuerNouveauCompte() {

        Compte compte = new Compte();
        compte.numero = ++dernierNumeroCompte;
        return compte;
    }

    public float bilanClient(Client client) {

        float solde = 0f;
        Compte[] comptes = client.getComptes();
        System.out.println("Bilan du compte de " + client.getNom());
        for (Compte compte: comptes) {
            System.out.println("Compte n° " + compte.numero);
            System.out.println("    Solde : " + compte.getSolde() + " €");
            solde += compte.getSolde();
        }
        System.out.println("Total : " + solde + " €");
        return solde;
    }

    public void afficherBilan() {

        System.out.println("Bilan de tous les clients");
        float solde = 0f;
        for (Client client : this.clients) {
            if (client == null) continue;
            System.out.println("Client " + client.getNom());
            solde += bilanClient(client);
        }
        System.out.println("Total de tous les clients : " + solde + " €");
    }

    public Client rechercherClient(String nom) {

        for (Client client : this.clients) {
            if (client != null && client.getNom().equals(nom)) return client;
        }
        return new Client("");
    }
}
