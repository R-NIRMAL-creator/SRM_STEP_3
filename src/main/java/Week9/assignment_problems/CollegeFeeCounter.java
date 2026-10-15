package main.java.Week9.assignment_problems;

import java.util.Scanner;

public class CollegeFeeCounter {

    interface BusUser {
        double TRANSPORT_FEE = 12000;

        default double transportFee() {
            return TRANSPORT_FEE;
        }
    }

    static abstract class Student {
        static final double NORMAL_TUITION = 40000;

        final String name;

        Student(String name) {
            this.name = name;
        }

        abstract double tuition();
    }

    static class DayScholar extends Student implements BusUser {
        DayScholar(String name) {
            super(name);
        }

        @Override
        double tuition() {
            return NORMAL_TUITION;
        }
    }

    static class Hosteller extends Student {
        static final double HOSTEL_FEE = 60000;

        Hosteller(String name) {
            super(name);
        }

        @Override
        double tuition() {
            return NORMAL_TUITION + HOSTEL_FEE;
        }
    }

    static class ScholarshipStudent extends Student implements BusUser {
        ScholarshipStudent(String name) {
            super(name);
        }

        @Override
        double tuition() {
            return NORMAL_TUITION / 2;
        }
    }

    static Student create(String type, String name) {
        switch (type) {
            case "DAY_SCHOLAR":
                return new DayScholar(name);
            case "HOSTELLER":
                return new Hosteller(name);
            case "SCHOLAR":
                return new ScholarshipStudent(name);
            default:
                throw new IllegalArgumentException("Unknown student type: " + type);
        }
    }

    static double totalFee(Student student) {
        double fee = student.tuition();
        if (student instanceof BusUser) {
            fee += ((BusUser) student).transportFee();
        }
        return fee;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCollected = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Student student = create(type, name);
            double fee = totalFee(student);
            totalCollected += fee;
            System.out.printf("%s: %.2f%n", student.name, fee);
        }
        System.out.printf("Total Collected: %.2f%n", totalCollected);
    }
}
