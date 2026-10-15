package main.java.Week9.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WeeklyStaffPay {

    static abstract class Staff {
        final String name;

        Staff(String name) {
            this.name = name;
        }

        abstract double pay();
    }

    static class FullTimeStaff extends Staff {
        final double weeklySalary;

        FullTimeStaff(String name, double weeklySalary) {
            super(name);
            this.weeklySalary = weeklySalary;
        }

        @Override
        double pay() {
            return weeklySalary;
        }
    }

    static class HourlyStaff extends Staff {
        static final double REGULAR_HOURS = 40;
        static final double OVERTIME_MULTIPLIER = 1.5;

        final double hours;
        final double rate;

        HourlyStaff(String name, double hours, double rate) {
            super(name);
            this.hours = hours;
            this.rate = rate;
        }

        @Override
        double pay() {
            if (hours <= REGULAR_HOURS) {
                return hours * rate;
            }
            double overtimeHours = hours - REGULAR_HOURS;
            return REGULAR_HOURS * rate + overtimeHours * rate * OVERTIME_MULTIPLIER;
        }
    }

    static class Intern extends Staff {
        final double stipend;

        Intern(String name, double stipend) {
            super(name);
            this.stipend = stipend;
        }

        @Override
        double pay() {
            return stipend;
        }
    }

    static Staff readStaff(Scanner sc) {
        String type = sc.next();
        String name = sc.next();
        switch (type) {
            case "FULLTIME":
                return new FullTimeStaff(name, sc.nextDouble());
            case "HOURLY":
                return new HourlyStaff(name, sc.nextDouble(), sc.nextDouble());
            case "INTERN":
                return new Intern(name, sc.nextDouble());
            default:
                throw new IllegalArgumentException("Unknown staff type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Staff> staff = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            staff.add(readStaff(sc));
        }
        double totalPayroll = 0;
        for (Staff member : staff) {
            double pay = member.pay();
            totalPayroll += pay;
            System.out.printf("%s: %.2f%n", member.name, pay);
        }
        System.out.printf("Total Payroll: %.2f%n", totalPayroll);
    }
}
