package main.java.Week9.assignment_problems;

import java.util.Scanner;

public class CityCabFareMeter {

    interface NightService {
        double NIGHT_SURCHARGE = 0.20;

        default double nightFare(double dayFare) {
            return dayFare * (1 + NIGHT_SURCHARGE);
        }
    }

    static abstract class Cab {
        static final double MINIMUM_FARE = 100;

        abstract double ratePerKm();

        double fare(double km) {
            return Math.max(km * ratePerKm(), MINIMUM_FARE);
        }
    }

    static class Mini extends Cab {
        @Override
        double ratePerKm() {
            return 10;
        }
    }

    static class Sedan extends Cab implements NightService {
        @Override
        double ratePerKm() {
            return 14;
        }
    }

    static class Suv extends Cab implements NightService {
        @Override
        double ratePerKm() {
            return 18;
        }
    }

    static Cab create(String type) {
        switch (type) {
            case "MINI":
                return new Mini();
            case "SEDAN":
                return new Sedan();
            case "SUV":
                return new Suv();
            default:
                throw new IllegalArgumentException("Unknown cab type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();
            Cab cab = create(type);
            double fare = cab.fare(km);
            if (time.equals("NIGHT")) {
                if (!(cab instanceof NightService)) {
                    System.out.printf("%s: night service not available%n", type);
                    continue;
                }
                fare = ((NightService) cab).nightFare(fare);
            }
            total += fare;
            System.out.printf("%s: %.2f%n", type, fare);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
