package main.java.Week8.class_problems;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryItemDueDateCalculator {

    static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);

    static abstract class LibraryItem {
        final String title;

        LibraryItem(String title) {
            this.title = title;
        }

        abstract int borrowingDays();

        LocalDate dueDate() {
            return CURRENT_DATE.plusDays(borrowingDays());
        }
    }

    static class Book extends LibraryItem {
        Book(String title) {
            super(title);
        }

        @Override
        int borrowingDays() {
            return 14;
        }
    }

    static class Dvd extends LibraryItem {
        Dvd(String title) {
            super(title);
        }

        @Override
        int borrowingDays() {
            return 7;
        }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title) {
            super(title);
        }

        @Override
        int borrowingDays() {
            return 3;
        }
    }

    static LibraryItem create(String type, String title) {
        switch (type) {
            case "BOOK":
                return new Book(title);
            case "DVD":
                return new Dvd(title);
            case "MAGAZINE":
                return new Magazine(title);
            default:
                throw new IllegalArgumentException("Unknown item type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String type = line.substring(0, line.indexOf(' '));
            String title = line.substring(line.indexOf('"') + 1, line.lastIndexOf('"'));
            items.add(create(type, title));
        }
        for (LibraryItem item : items) {
            System.out.println(item.title + ": " + item.dueDate());
        }
    }
}
