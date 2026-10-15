package main.java.Week9.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryLateFineCounter {

    static abstract class LibraryItem {
        final String title;
        final int daysLate;

        LibraryItem(String title, int daysLate) {
            this.title = title;
            this.daysLate = daysLate;
        }

        abstract double fine();
    }

    static class Book extends LibraryItem {
        Book(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        double fine() {
            return 2.0 * daysLate;
        }
    }

    static class Dvd extends LibraryItem {
        static final double MAX_FINE = 50;

        Dvd(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        double fine() {
            return Math.min(5.0 * daysLate, MAX_FINE);
        }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        double fine() {
            return 1.0 * daysLate;
        }
    }

    static LibraryItem create(String type, String title, int daysLate) {
        switch (type) {
            case "BOOK":
                return new Book(title, daysLate);
            case "DVD":
                return new Dvd(title, daysLate);
            case "MAGAZINE":
                return new Magazine(title, daysLate);
            default:
                throw new IllegalArgumentException("Unknown item type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();
            items.add(create(type, title, daysLate));
        }
        double totalFines = 0;
        for (LibraryItem item : items) {
            double fine = item.fine();
            totalFines += fine;
            System.out.printf("%s: %.2f%n", item.title, fine);
        }
        System.out.printf("Total Fines: %.2f%n", totalFines);
    }
}
