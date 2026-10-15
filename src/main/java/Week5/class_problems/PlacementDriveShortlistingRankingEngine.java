package main.java.Week5.class_problems;

import java.util.Arrays;

public class PlacementDriveShortlistingRankingEngine {

    static class Candidate implements Comparable<Candidate> {
        private final String name;
        private final double cgpa;
        private final int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        static boolean isEligible(double cgpa) {
            return cgpa >= 7.0;
        }

        static boolean isEligible(double cgpa, int codingScore) {
            return cgpa >= 6.5 && codingScore >= 60;
        }

        boolean qualifies() {
            return isEligible(cgpa) || isEligible(cgpa, codingScore);
        }

        double compositeScore() {
            return cgpa * 10 + codingScore * 0.5;
        }

        String getName() {
            return name;
        }

        @Override
        public int compareTo(Candidate other) {
            return Double.compare(other.compositeScore(), this.compositeScore());
        }
    }

    static String shortlistAndRank(Candidate[] candidates) {
        int count = 0;
        for (Candidate candidate : candidates) {
            if (candidate.qualifies()) {
                count++;
            }
        }
        Candidate[] shortlisted = new Candidate[count];
        int index = 0;
        for (Candidate candidate : candidates) {
            if (candidate.qualifies()) {
                shortlisted[index++] = candidate;
            }
        }
        Arrays.sort(shortlisted);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            result.append(i + 1)
                  .append(". ")
                  .append(shortlisted[i].getName())
                  .append(" (")
                  .append(String.format("%.1f", shortlisted[i].compositeScore()))
                  .append(")");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(candidates));
    }
}
