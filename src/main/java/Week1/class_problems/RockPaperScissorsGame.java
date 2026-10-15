package main.java.Week1.class_problems;

import java.util.Random;

public class RockPaperScissorsGame {

    static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    static boolean beats(String move, String other) {
        return (move.equals("Rock") && other.equals("Scissors"))
                || (move.equals("Paper") && other.equals("Rock"))
                || (move.equals("Scissors") && other.equals("Paper"));
    }

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }
        return beats(playerMove, computerMove) ? "Player Wins" : "Computer Wins";
    }

    public static void main(String[] args) {
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        Random random = new Random();
        int wins = 0;
        int losses = 0;
        int draws = 0;
        System.out.printf("%-7s| %-12s| %-14s| %s%n", "Round", "Player Move", "Computer Move", "Result");
        for (int i = 0; i < playerMoves.length; i++) {
            String computerMove = MOVES[random.nextInt(MOVES.length)];
            String result = playRound(playerMoves[i], computerMove);
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
            System.out.printf("%-7d| %-12s| %-14s| %s%n", i + 1, playerMoves[i], computerMove, result);
        }
        double winPercentage = wins * 100.0 / playerMoves.length;
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, winPercentage);
    }
}
