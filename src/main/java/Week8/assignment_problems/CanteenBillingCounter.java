package main.java.Week8.assignment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CanteenBillingCounter {

    static abstract class Customer {
        final String type;
        final double amount;

        Customer(String type, double amount) {
            this.type = type;
            this.amount = amount;
        }

        abstract double finalAmount();
    }

    static class StudentCustomer extends Customer {
        StudentCustomer(String type, double amount) {
            super(type, amount);
        }

        @Override
        double finalAmount() {
            return amount * 0.90;
        }
    }

    static class StaffCustomer extends Customer {
        StaffCustomer(String type, double amount) {
            super(type, amount);
        }

        @Override
        double finalAmount() {
            return amount * 0.95;
        }
    }

    static class GuestCustomer extends Customer {
        static final double SERVICE_CHARGE = 10;

        GuestCustomer(String type, double amount) {
            super(type, amount);
        }

        @Override
        double finalAmount() {
            return amount + SERVICE_CHARGE;
        }
    }

    static Customer create(String type, double amount) {
        switch (type) {
            case "STUDENT":
                return new StudentCustomer(type, amount);
            case "STAFF":
                return new StaffCustomer(type, amount);
            case "GUEST":
                return new GuestCustomer(type, amount);
            default:
                throw new IllegalArgumentException("Unknown customer type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Customer> bills = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            bills.add(create(type, amount));
        }
        double total = 0;
        for (Customer bill : bills) {
            double finalAmount = bill.finalAmount();
            total += finalAmount;
            System.out.printf("%s: %.2f%n", bill.type, finalAmount);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
