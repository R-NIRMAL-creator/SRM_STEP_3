package main.java.Week8.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExaminationQuestionGrader {

    static abstract class Question {
        final String type;
        final String correctAnswer;
        final String studentAnswer;
        final int points;

        Question(String type, String correctAnswer, String studentAnswer, int points) {
            this.type = type;
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        abstract double score();
    }

    static class ExactMatchQuestion extends Question {
        ExactMatchQuestion(String type, String correctAnswer, String studentAnswer, int points) {
            super(type, correctAnswer, studentAnswer, points);
        }

        @Override
        double score() {
            return studentAnswer.equals(correctAnswer) ? points : 0;
        }
    }

    static class EssayQuestion extends Question {
        EssayQuestion(String type, String correctAnswer, String studentAnswer, int points) {
            super(type, correctAnswer, studentAnswer, points);
        }

        @Override
        double score() {
            String answer = studentAnswer.toLowerCase();
            int matched = 0;
            for (String keyword : correctAnswer.split(",")) {
                if (answer.contains(keyword.trim().toLowerCase())) {
                    matched++;
                }
            }
            if (matched >= 2) {
                return points * 0.75;
            } else if (matched == 1) {
                return points * 0.50;
            }
            return 0;
        }
    }

    static Question parseQuestion(String line) {
        String type = line.substring(0, line.indexOf(' '));
        List<String> quoted = new ArrayList<>();
        int from = 0;
        while (true) {
            int start = line.indexOf('"', from);
            if (start < 0) {
                break;
            }
            int end = line.indexOf('"', start + 1);
            quoted.add(line.substring(start + 1, end));
            from = end + 1;
        }
        int points = Integer.parseInt(line.substring(line.lastIndexOf('"') + 1).trim());
        String correct = quoted.get(1);
        String student = quoted.get(2);
        switch (type) {
            case "MCQ":
            case "TF":
                return new ExactMatchQuestion(type, correct, student, points);
            case "ESSAY":
                return new EssayQuestion(type, correct, student, points);
            default:
                throw new IllegalArgumentException("Unknown question type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            questions.add(parseQuestion(sc.nextLine().trim()));
        }
        double totalScore = 0;
        for (Question question : questions) {
            double score = question.score();
            totalScore += score;
            System.out.printf("%s: %.2f%n", question.type, score);
        }
        System.out.printf("Total Score: %.2f%n", totalScore);
    }
}
