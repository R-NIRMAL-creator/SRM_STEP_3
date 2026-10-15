package main.java.Week8.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryFeeCalculator {

    static abstract class Delivery {
        final String type;
        final double weight;
        final double distance;

        Delivery(String type, double weight, double distance) {
            this.type = type;
            this.weight = weight;
            this.distance = distance;
        }

        abstract double fee();
    }

    static class StandardDelivery extends Delivery {
        StandardDelivery(String type, double weight, double distance) {
            super(type, weight, distance);
        }

        @Override
        double fee() {
            return 5 + 0.50 * weight + 0.10 * distance;
        }
    }

    static class ExpressDelivery extends Delivery {
        ExpressDelivery(String type, double weight, double distance) {
            super(type, weight, distance);
        }

        @Override
        double fee() {
            return 15 + 1.00 * weight + 0.20 * distance;
        }
    }

    static class InternationalDelivery extends Delivery {
        final double customsFee;

        InternationalDelivery(String type, double weight, double distance, double customsFee) {
            super(type, weight, distance);
            this.customsFee = customsFee;
        }

        @Override
        double fee() {
            return 25 + 2.00 * weight + 0.50 * distance + customsFee;
        }
    }

    static Delivery readDelivery(Scanner sc) {
        String type = sc.next();
        double weight = sc.nextDouble();
        double distance = sc.nextDouble();
        switch (type) {
            case "STANDARD":
                return new StandardDelivery(type, weight, distance);
            case "EXPRESS":
                return new ExpressDelivery(type, weight, distance);
            case "INTERNATIONAL":
                return new InternationalDelivery(type, weight, distance, sc.nextDouble());
            default:
                throw new IllegalArgumentException("Unknown delivery type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Delivery> deliveries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            deliveries.add(readDelivery(sc));
        }
        double total = 0;
        for (Delivery delivery : deliveries) {
            double fee = delivery.fee();
            total += fee;
            System.out.printf("%s: %.2f%n", delivery.type, fee);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
