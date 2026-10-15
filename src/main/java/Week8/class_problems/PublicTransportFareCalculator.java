package main.java.Week8.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PublicTransportFareCalculator {

    static abstract class Journey {
        final String type;
        final double distance;

        Journey(String type, double distance) {
            this.type = type;
            this.distance = distance;
        }

        abstract double fare();
    }

    static class BusJourney extends Journey {
        static final double MAX_FARE = 10;

        BusJourney(String type, double distance) {
            super(type, distance);
        }

        @Override
        double fare() {
            return Math.min(2 + 0.10 * distance, MAX_FARE);
        }
    }

    static class TrainJourney extends Journey {
        TrainJourney(String type, double distance) {
            super(type, distance);
        }

        @Override
        double fare() {
            return 3 + 0.15 * distance;
        }
    }

    static class MetroJourney extends Journey {
        final double peakHourFactor;

        MetroJourney(String type, double distance, double peakHourFactor) {
            super(type, distance);
            this.peakHourFactor = peakHourFactor;
        }

        @Override
        double fare() {
            return (1.50 + 0.20 * distance) * peakHourFactor;
        }
    }

    static Journey readJourney(Scanner sc) {
        String type = sc.next();
        double distance = sc.nextDouble();
        switch (type) {
            case "BUS":
                return new BusJourney(type, distance);
            case "TRAIN":
                return new TrainJourney(type, distance);
            case "METRO":
                return new MetroJourney(type, distance, sc.nextDouble());
            default:
                throw new IllegalArgumentException("Unknown transport type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Journey> journeys = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            journeys.add(readJourney(sc));
        }
        double total = 0;
        for (Journey journey : journeys) {
            double fare = journey.fare();
            total += fare;
            System.out.printf("%s: %.2f%n", journey.type, fare);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
