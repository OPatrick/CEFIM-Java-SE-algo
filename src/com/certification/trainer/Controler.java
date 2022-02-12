package com.certification.trainer;

import java.util.ArrayList;
import java.util.List;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 10/02/2022
 * Time: 08:33
 */
public class Controler {

    private int trials = 20;
    private int trialIndex = 0;
    private int score = 0;

    private final UI ui;
    private final Repository repository;

    public Controler(UI ui, Repository repository) {
        this.ui = ui;
        this.repository = repository;
    }

    public int[] ask(String message) {
        String answer = ui.ask(message);
        return parseInput(answer);
    }

    public void askNumberOfQuestions(String message) {
            this.trials = (ask(message))[0];
    }

    public void display(String message) {
        ui.display(message);
    }

    public void nextQuestion(String winnerWord) {
        while (this.trialIndex < this.trials) {
            CertificationVO currentQuestion = this.repository.getQuestion();
            ui.display("\u001B[32m" + currentQuestion.getQuestion() + "\u001B[0m");
            for (int i = 0; i< currentQuestion.getAnswers().size(); i++) {
                ui.display((i+1) + ") " + currentQuestion.getAnswers().get(i));
            }
            int[] answers = parseInput(ui.getUserAnswer());
            if (isWinner(currentQuestion.getRightAnswers(), answers)) {
                ui.display("\u001B[34m" + winnerWord + "\u001B[0m");
                this.score++;
            } else {
                ui.display("\u001B[36m" + currentQuestion.getExplanation() + "\u001B[0m");
            }
            this.trialIndex++;
        }
    }

    public void displayScore(String message) {
        ui.display("\u001B[34m" + message + this.score + "\u001B[0m");
    }

    public boolean isWinner(List<Integer> rightAnswers, int[] answers) {
        if (rightAnswers.size() != answers.length) return false;
        for (int answer : answers) {
            if (! rightAnswers.contains(answer)) return false;
        }
        return true;
    }

    private int[] parseInput(String input) {
        String[] tokens = input.split("\\D+");
        int[] results = new int[tokens.length];
        for (int i=0; i<tokens.length; i++) {
            results[i] = Integer.parseInt(tokens[i]);
        }
        return results;
    }
}
