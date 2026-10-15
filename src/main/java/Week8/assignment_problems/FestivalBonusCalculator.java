package main.java.Week8.assignment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FestivalBonusCalculator {

    static abstract class Employee {
        final String name;
        final double monthlySalary;

        Employee(String name, double monthlySalary) {
            this.name = name;
            this.monthlySalary = monthlySalary;
        }

        abstract double bonus();
    }

    static class FullTimeEmployee extends Employee {
        FullTimeEmployee(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        @Override
        double bonus() {
            return monthlySalary * 0.10;
        }
    }

    static class PartTimeEmployee extends Employee {
        PartTimeEmployee(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        @Override
        double bonus() {
            return monthlySalary * 0.05;
        }
    }

    static class InternEmployee extends Employee {
        static final double FIXED_BONUS = 2000;

        InternEmployee(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        @Override
        double bonus() {
            return FIXED_BONUS;
        }
    }

    static Employee create(String type, String name, double monthlySalary) {
        switch (type) {
            case "FULLTIME":
                return new FullTimeEmployee(name, monthlySalary);
            case "PARTTIME":
                return new PartTimeEmployee(name, monthlySalary);
            case "INTERN":
                return new InternEmployee(name, monthlySalary);
            default:
                throw new IllegalArgumentException("Unknown employee type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double monthlySalary = sc.nextDouble();
            employees.add(create(type, name, monthlySalary));
        }
        double totalBonus = 0;
        for (Employee employee : employees) {
            double bonus = employee.bonus();
            totalBonus += bonus;
            System.out.printf("%s: %.2f%n", employee.name, bonus);
        }
        System.out.printf("Total Bonus: %.2f%n", totalBonus);
    }
}
