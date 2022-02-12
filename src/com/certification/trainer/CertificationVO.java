package com.certification.trainer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 10/02/2022
 * Time: 08:39
 */
public class CertificationVO {

    private final String path;
    private final String question;
    private final List<String> answers;
    private final List<Integer> rightAnswers;
    private final String explanation;

    private CertificationVO(String path, String question, List<String> answers, List<Integer> rightAnswers, String explanation) {
        this.path = path;
        this.question = question;
        this.answers = answers;
        this.rightAnswers = rightAnswers;
        this.explanation = explanation;
    }

    public String getPath() {
        return this.path;
    }

    public String getQuestion() {
        return this.question;
    }

    public List<String> getAnswers() {
        return this.answers;
    }

    public List<Integer> getRightAnswers() {
        return this.rightAnswers;
    }

    public String getExplanation() {
        return this.explanation;
    }

    public static class VoBuilder {

        private String path;
        private String question;
        private final List<String> answers = new ArrayList<>();
        private List<Integer> rightAnswers = new ArrayList<>();
        private String explanation;

        public VoBuilder setPath(String path) {
            this.path = path;
            return this;
        }

        public VoBuilder setQuestion(String question) {
            this.question = question;
            return this;
        }

        public VoBuilder setAnswers(String[] answers) {
            this.answers.addAll(Arrays.asList(answers));
            return this;
        }

        public VoBuilder setRightAnswers(List<Integer> rightAnswers) {
            this.rightAnswers = rightAnswers;
            return this;
        }

        public VoBuilder setExplanation(String explanation) {
            this.explanation = explanation;
            return this;
        }

        public CertificationVO build() {
            return new CertificationVO(path, question, answers, rightAnswers, explanation);
        }
    }
}
