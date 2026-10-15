package main.java.Week9.assignment_problems;

import java.util.Scanner;

public class HomeApplianceEnergyReport {

    static final double RATE_PER_UNIT = 8;

    interface SaverMode {
        double SAVING = 0.25;

        default double saverUnits(double units) {
            return units * (1 - SAVING);
        }
    }

    static abstract class Appliance {
        abstract double watts();

        double units(double hours) {
            return watts() * hours / 1000;
        }
    }

    static class Fridge extends Appliance {
        @Override
        double watts() {
            return 150;
        }
    }

    static class AirConditioner extends Appliance implements SaverMode {
        @Override
        double watts() {
            return 1500;
        }
    }

    static class Television extends Appliance {
        @Override
        double watts() {
            return 100;
        }
    }

    static class WashingMachine extends Appliance implements SaverMode {
        @Override
        double watts() {
            return 500;
        }
    }

    static Appliance create(String name) {
        switch (name) {
            case "FRIDGE":
                return new Fridge();
            case "AC":
                return new AirConditioner();
            case "TV":
                return new Television();
            case "WASHER":
                return new WashingMachine();
            default:
                throw new IllegalArgumentException("Unknown appliance: " + name);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double totalCost = 0;
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String name = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean saverRequested = parts.length > 2 && parts[2].equals("SAVER");
            Appliance appliance = create(name);
            double units = appliance.units(hours);
            if (saverRequested) {
                if (!(appliance instanceof SaverMode)) {
                    System.out.printf("%s: saver mode not supported%n", name);
                    continue;
                }
                units = ((SaverMode) appliance).saverUnits(units);
            }
            double cost = units * RATE_PER_UNIT;
            totalCost += cost;
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", name, units, cost);
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
    }
}
