package com.certification.trainer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.certification.trainer.CertificationTrainer.FILE_NOT_FOUND;
import static com.certification.trainer.CertificationTrainer.PROBLEM_FILE_IO;

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

    public String askString(String message) {
        return ui.askMultiple(message);
    }

    public Route askAction(String message) {
        int[] response = ask(message);
        return (response.length > 0 && response[0] == 1) ? Route.Create : Route.Play;
    }

    public void askNumberOfQuestions(String message) {
        this.trials = (ask(message))[0];
    }



    public void createQuestion(String... messages) {
        String question = askString(messages[0]);
        List<String> answers = new ArrayList<>();
        String answer;
        do {
            answer = askString(messages[1]);
            if (answer.length() > 0) {
                answers.add(answer);
            }
        } while (answer.length() > 0);
        int[] rightAnswers = ask(messages[2]);
        String explanation = askString(messages[3]);

        CertificationVO vo = new CertificationVO.VoBuilder()
                .setPath("")
                .setQuestion(question)
                .setAnswers(answers.toArray(new String[0]))
                .setRightAnswers(Arrays.stream(rightAnswers).boxed().collect(Collectors.toList()))
                .setExplanation(explanation)
                .build();

        try {
            this.repository.createQuestion(vo);
        } catch (FileNotFoundException e) {
            ui.display(FILE_NOT_FOUND + e.getMessage());
        } catch (IOException e) {
            ui.display(PROBLEM_FILE_IO + e.getMessage());
        }
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
            int[] answers = new int[0];
            while (answers.length < 1) {
                answers = parseInput(ui.getUserAnswer());
            }
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
        ui.display("\u001B[34m" + message + this.score + "/" + this.trials + "\u001B[0m");
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
        try {
            for (int i=0; i<tokens.length; i++) {
                results[i] = Integer.parseInt(tokens[i]);
            }
        } catch (NumberFormatException e) {
            results = new int[0];
        }
        return results;
    }
}
