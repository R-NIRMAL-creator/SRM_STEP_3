package main.java.Week8.assignment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CampusParkingChargeCalculator {

    static abstract class Vehicle {
        final String type;
        final int hours;

        Vehicle(String type, int hours) {
            this.type = type;
            this.hours = hours;
        }

        abstract double charge();
    }

    static class Bike extends Vehicle {
        Bike(String type, int hours) {
            super(type, hours);
        }

        @Override
        double charge() {
            return 10.0 * hours;
        }
    }

    static class Car extends Vehicle {
        Car(String type, int hours) {
            super(type, hours);
        }

        @Override
        double charge() {
            return 30.0 + 20.0 * (hours - 1);
        }
    }

    static class Truck extends Vehicle {
        static final double MINIMUM_CHARGE = 100;

        Truck(String type, int hours) {
            super(type, hours);
        }

        @Override
        double charge() {
            return Math.max(50.0 * hours, MINIMUM_CHARGE);
        }
    }

    static Vehicle create(String type, int hours) {
        switch (type) {
            case "BIKE":
                return new Bike(type, hours);
            case "CAR":
                return new Car(type, hours);
            case "TRUCK":
                return new Truck(type, hours);
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            vehicles.add(create(type, hours));
        }
        double total = 0;
        for (Vehicle vehicle : vehicles) {
            double charge = vehicle.charge();
            total += charge;
            System.out.printf("%s: %.2f%n", vehicle.type, charge);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
