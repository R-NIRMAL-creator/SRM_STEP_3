package main.java.Week7.class_problems;

public class QuizScorecardApp {

    static class Scorecard {
        private final boolean[] results;
        private int recorded;

        Scorecard(int totalQuestions) {
            this.results = new boolean[totalQuestions];
        }

        boolean recordAnswer(boolean correct) {
            if (recorded >= results.length) {
                return false;
            }
            results[recorded++] = correct;
            return true;
        }

        int getScore() {
            int score = 0;
            for (int i = 0; i < recorded; i++) {
                if (results[i]) {
                    score++;
                }
            }
            return score;
        }
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println("Score: " + sc.getScore());
        if (!sc.recordAnswer(true)) {
            System.out.println("Extra answer rejected, score stays " + sc.getScore());
        }
    }
}
