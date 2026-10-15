package main.java.Week10.class_problems;

import java.util.Scanner;

public class StudentResultCardGenerator {

    static class Student {
        private final String name;
        private final int[] marks;

        Student(String name, int[] marks) {
            this.name = name;
            this.marks = marks;
        }

        double average() {
            int sum = 0;
            for (int mark : marks) {
                sum += mark;
            }
            return (double) sum / marks.length;
        }

        char grade() {
            double average = average();
            if (average >= 75) {
                return 'B';
            } else if (average >= 60) {
                return 'C';
            } else if (average >= 40) {
                return 'D';
            } else {
                return 'F';
            }
        }

        void printCard() {
            System.out.printf("%s: Average %.1f, Grade %c%n", name.toUpperCase(), average(), grade());
        }
    }

    static Student parseStudent(String line) {
        int open = line.indexOf('[');
        String name = line.substring(0, open).trim();
        String[] parts = line.substring(open + 1, line.indexOf(']')).split(",");
        int[] marks = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            marks[i] = Integer.parseInt(parts[i].trim());
        }
        return new Student(name, marks);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                break;
            }
            parseStudent(line).printCard();
        }
    }
}
