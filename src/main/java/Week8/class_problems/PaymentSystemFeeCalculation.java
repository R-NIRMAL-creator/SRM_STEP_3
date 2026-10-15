package main.java.Week8.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaymentSystemFeeCalculation {

    static abstract class Payment {
        final String type;
        final double amount;

        Payment(String type, double amount) {
            this.type = type;
            this.amount = amount;
        }

        abstract double adjustedAmount();
    }

    static class CardPayment extends Payment {
        CardPayment(String type, double amount) {
            super(type, amount);
        }

        @Override
        double adjustedAmount() {
            return amount * 1.02;
        }
    }

    static class WalletPayment extends Payment {
        WalletPayment(String type, double amount) {
            super(type, amount);
        }

        @Override
        double adjustedAmount() {
            return amount * 1.01;
        }
    }

    static class BankTransferPayment extends Payment {
        BankTransferPayment(String type, double amount) {
            super(type, amount);
        }

        @Override
        double adjustedAmount() {
            return amount;
        }
    }

    static Payment create(String type, double amount) {
        switch (type) {
            case "CARD":
                return new CardPayment(type, amount);
            case "WALLET":
                return new WalletPayment(type, amount);
            case "BANKTRANSFER":
                return new BankTransferPayment(type, amount);
            default:
                throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Payment> payments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            payments.add(create(type, amount));
        }
        double total = 0;
        for (Payment payment : payments) {
            double adjusted = payment.adjustedAmount();
            total += adjusted;
            System.out.printf("%s: %.2f%n", payment.type, adjusted);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
