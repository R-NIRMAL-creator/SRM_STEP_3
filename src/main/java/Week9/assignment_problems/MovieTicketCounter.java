package main.java.Week9.assignment_problems;

import java.util.Scanner;

public class MovieTicketCounter {

    static abstract class Ticket {
        static final double CONVENIENCE_FEE = 20;

        abstract double price();

        double amount(int count) {
            return count * (price() + CONVENIENCE_FEE);
        }
    }

    static class RegularTicket extends Ticket {
        @Override
        double price() {
            return 150;
        }
    }

    static class PremiumTicket extends Ticket {
        @Override
        double price() {
            return 250;
        }
    }

    static class ReclinerTicket extends Ticket {
        @Override
        double price() {
            return 400;
        }
    }

    static Ticket create(String seat) {
        switch (seat) {
            case "REGULAR":
                return new RegularTicket();
            case "PREMIUM":
                return new PremiumTicket();
            case "RECLINER":
                return new ReclinerTicket();
            default:
                throw new IllegalArgumentException("Unknown seat type: " + seat);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();
            double amount = create(seat).amount(count);
            total += amount;
            System.out.printf("%s: %.2f%n", seat, amount);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
