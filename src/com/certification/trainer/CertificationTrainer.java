package com.certification.trainer;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 10/02/2022
 * Time: 08:32
 */
public class CertificationTrainer {

    public static void main(String[] args) {

        UI ui = new UI();
        Repository repository = new Repository(50);
        Controler controler = new Controler(ui, repository);

        controler.askNumberOfQuestions("Combien de questions ce jour ?");
        controler.display("C'est parti");
        controler.nextQuestion("You win! Great job");
        controler.displayScore("Votre score est de ");
    }
}
