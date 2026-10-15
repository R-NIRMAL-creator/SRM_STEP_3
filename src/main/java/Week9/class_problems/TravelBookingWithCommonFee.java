package main.java.Week9.class_problems;

import java.util.Scanner;

public class TravelBookingWithCommonFee {

    static abstract class Booking {
        static final double BOOKING_FEE = 50;

        final double distanceKm;

        Booking(double distanceKm) {
            this.distanceKm = distanceKm;
        }

        abstract double baseFare();

        double totalFare() {
            return baseFare() + BOOKING_FEE;
        }
    }

    static class BusBooking extends Booking {
        BusBooking(double distanceKm) {
            super(distanceKm);
        }

        @Override
        double baseFare() {
            return 2 * distanceKm;
        }
    }

    static class TrainBooking extends Booking {
        TrainBooking(double distanceKm) {
            super(distanceKm);
        }

        @Override
        double baseFare() {
            return 1.5 * distanceKm;
        }
    }

    static class FlightBooking extends Booking {
        FlightBooking(double distanceKm) {
            super(distanceKm);
        }

        @Override
        double baseFare() {
            return 2500 + 4 * distanceKm;
        }
    }

    static Booking create(String mode, double distanceKm) {
        switch (mode) {
            case "BUS":
                return new BusBooking(distanceKm);
            case "TRAIN":
                return new TrainBooking(distanceKm);
            case "FLIGHT":
                return new FlightBooking(distanceKm);
            default:
                throw new IllegalArgumentException("Unknown travel mode: " + mode);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distanceKm = sc.nextDouble();
            System.out.printf("%s: %.2f%n", mode, create(mode, distanceKm).totalFare());
        }
    }
}
