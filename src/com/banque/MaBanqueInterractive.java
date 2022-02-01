package com.banque;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 31/01/2022
 * Time: 14:59
 */
public class MaBanqueInterractive {

    private static final Scanner scan = new Scanner(System.in);
    private Banque banque;
    private Client client;

    public static void main(String[] args) {

        MaBanqueInterractive banqueInteractive = new MaBanqueInterractive();
        banqueInteractive.banque = new Banque();
        try {
            boolean shallWeContinue = true;
            while (shallWeContinue) {
                shallWeContinue = banqueInteractive.interaction();
            }
        }  catch(RuntimeException e) {
            System.out.println("Ouch... problème... Bye...");
//            System.out.println(e);
        }
    }

    private boolean interaction() {

        System.out.println("\nBienvenue sur la banque " + this.banque.nom +
                "\nQuelle opération voulez-vous effectuer ?\n" +
                "    1) Ajouter un client\n" +
                "    2) Effectuer une opération sur un client\n" +
                "    3) Afficher un bilan général\n" +
                "    4) Renflouer les comptes");
        int choix;
        try {
            choix = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Nous n'avons pas compris votre réponse");
            return false;
        }
        switch (choix) {
            case 1 -> interactionAjoutClient();
            case 2 -> interactionOperationClient();
            case 3 -> interactionBilanGeneral();
            case 4 -> interactionRenflouer();
            default ->System.out.println("Nous n'avons pas compris votre réponse");
        }
        return true;
    }

    private void interactionAjoutClient() {
        System.out.println("Vous avez choisi d'ajouter un client. Entrez son nom :");
        String nom = scan.next();
        this.banque.ajouterClient(nom);
    }

    private void interactionOperationClient() {

        System.out.println("Vous avez choisi d'effectuer une opération sur un client. Entrez son nom :");
        String nom = scan.next();
        // Trouver le client
        Client client = this.banque.rechercherClient(nom);
        if (client.getNom().equals("")) {
            System.out.println("Client " + nom + " non trouvé");
            return;
        }
        this.client = client;
        System.out.println("Client " + this.client.getNom() + " trouvé.\n" +
                "Les comptes associés sont :");
        for (Compte compte : this.client.getComptes()) {
            System.out.println("    n° " + compte.numero + " : " + compte.getSolde() + " €");
        }
        System.out.println("""
                Quelle opération voulez-vous effectuer sur le client M. Dupont ?
                    1) Afficher un bilan
                    2) Faire un retrait
                    3) Faire un dépôt
                    4) Faire un virement
                    5) Ajouter un compte""");

        int choix;
        try {
            choix = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Nous n'avons pas compris votre réponse");
            return;
        }
        switch (choix) {
            case 1 -> interactionBilanClient();
            case 2 -> interactionOperationRetrait();
            case 3 -> interactionOperationDepot();
            case 4 -> interactionVirement();
            case 5 -> interactionAjouterCompte();
            default ->System.out.println("Nous n'avons pas compris votre réponse");
        }
    }

    private void interactionBilanClient() {
        System.out.println("Vous souhaitez afficher le bilan de " + this.client.getNom());
        this.banque.bilanClient(this.client);
    }

    private void interactionOperationRetrait() {
        System.out.println("Vous souhaitez effectuer un retrait  pour le client " + this.client.getNom());
        System.out.println("A partir de quel numéro de compte ?");
        int numero = scan.nextInt();
        Compte compte = this.client.rechercherCompte(numero);
        if (compte.numero == 0) {
            System.out.println("Désolé, le compte n° " + numero + " n'a pas été trouvé pour le client " +  this.client.getNom());
            return;
        }
        System.out.println("Compte n° " + numero + " trouvé. De combien se montera le retrait ? (max " + compte.getSolde() + " €)");
        int montant = scan.nextInt();
        compte.retrait(montant);
    }

    private void interactionOperationDepot() {
        System.out.println("Vous souhaitez effectuer un dépôt  pour le client " + this.client.getNom());
        System.out.println("Sur quel numéro de compte ?");
        int numero = scan.nextInt();
        Compte compte = this.client.rechercherCompte(numero);
        if (compte.numero == 0) {
            System.out.println("Désolé, le compte n° " + numero + " n'a pas été trouvé pour le client " +  this.client.getNom());
            return;
        }
        System.out.println("Compte n° " + numero + " trouvé. De combien se montera le dépôt ?");
        int montant = scan.nextInt();
        compte.depot(montant);
    }

    private void interactionVirement() {

        this.client.afficherSolde();
        if (client.nbComptes < 2) {
            System.out.println("Désolé, le client n° " + client.getNom() + " ne possède pas de comptes");
            return;
        }
        System.out.println("Vous souhaitez faire un virement de quel compte à quel compte ?");

        int numeroFrom = scan.nextInt();
        int numeroTo = scan.nextInt();

        Compte compteFrom = this.client.rechercherCompte(numeroFrom);
        if (compteFrom.numero == 0) {
            System.out.println("Désolé, le compte n° " + numeroFrom + " n'a pas été trouvé pour le client " +  this.client.getNom());
            return;
        }
        Compte compteTo = this.client.rechercherCompte(numeroTo);
        if (compteTo.numero == 0) {
            System.out.println("Désolé, le compte n° " + numeroTo + " n'a pas été trouvé pour le client " +  this.client.getNom());
            return;
        }
        System.out.println("Vous avez demandé un virement du compte n° " + compteFrom.numero + " vers le compte n° " + compteTo.numero + ". De combien ?");
        float montant = scan.nextFloat();
        compteFrom.virer(montant, compteTo);
    }

    private void  interactionAjouterCompte() {
        int numeroCompte = client.ajouterCompte();
        System.out.println("Le compte n° " + numeroCompte + " a été attribué à " + client.getNom());
    }

    private void interactionBilanGeneral() {
        this.banque.afficherBilan();
    }

    private void interactionRenflouer() {
        System.out.println("Vous avez choisi d'effectuer une opération de renflouement de vos comptes clients. C'est parti !\nAVANT");
        this.banque.afficherBilan();
        this.banque.renflouer();
        System.out.println("APRES");
        this.banque.afficherBilan();
    }
}
