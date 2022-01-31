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
//        try {
            boolean shallWeContinue = true;
            while (shallWeContinue) {
                shallWeContinue = banqueInteractive.interaction();
            }
//        }  catch(RuntimeException e) {
//            System.out.println("Ouch... problème... Bye...");
//            System.out.println(e);
//        }

    }

    private boolean interaction() {

        System.out.println("\nBienvenue sur la banque " + this.banque.nom +
                "\nQuelle opération voulez-vous effectuer ?\n" +
                "    1) Ajouter un client\n" +
                "    2) Effectuer une opération sur un client\n" +
                "    3) Afficher un bilan général");
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
        System.out.println("Quelle opération voulez-vous effectuer sur le client M. Dupont ?\n" +
                "    1) Afficher un bilan\n" +
                "    2) Faire un retrait\n" +
                "    3) Faire un dépôt\n" +
                "    4) Faire un virement");

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
        }
        System.out.println("Compte n° " + numero + " trouvé. De combien se montera le retrait ? (max " + compte.getSolde() + " €)");
        int montant = scan.nextInt();
        compte.retrait(montant);
    }

    private void interactionOperationDepot() {
        System.out.println("Vous souhaitez effectuer un dépôt  pour le client " + this.client.getNom());
        System.out.println("A partir de quel numéro de compte ?");
        int numero = scan.nextInt();
        Compte compte = this.client.rechercherCompte(numero);
        if (compte.numero == 0) {
            System.out.println("Désolé, le compte n° " + numero + " n'a pas été trouvé pour le client " +  this.client.getNom());
        }
        System.out.println("Compte n° " + numero + " trouvé. De combien se montera le dépôt ?");
        int montant = scan.nextInt();
        compte.depot(montant);
    }

    private void interactionVirement() {
        System.out.println("interactionVirement");
    }

    private void interactionBilanGeneral() {
        System.out.println("interactionBilanGeneral");
    }
}
