package com.certification.trainer;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 10/02/2022
 * Time: 08:32
 */
public class CertificationTrainer {

    public static String FILE_NOT_FOUND = "Fichier non trouvé : ";
    public static String PROBLEM_FILE_IO = "Problème d'accès fichier : ";

    public static void main(String[] args) {

        UI ui = new UI();
        Repository repository = new Repository(50);
        Controler controler = new Controler(ui, repository);

        Route route = controler.askAction("1) Créer ou 2) jouer ?");
        if (route.equals(Route.Create)) {
            controler.createQuestion(
                    "Quelle question sera posée ?",
                    "Veuillez entrer une réponse possible",
                    "Veuillez renseigner les numéros des bonnes réponses",
                    "Merci d'expliquer les bonnes et les mauvaises réponses"
            );
        } else {
            controler.askNumberOfQuestions("Combien de questions ce jour ?");
            controler.display("C'est parti");
            controler.nextQuestion("Bien joué");
            controler.displayScore("Votre score est de ");
        }
    }
}
