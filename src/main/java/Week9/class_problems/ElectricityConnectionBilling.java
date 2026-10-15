package main.java.Week9.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElectricityConnectionBilling {

    static abstract class Connection {
        final String type;
        final double units;

        Connection(String type, double units) {
            this.type = type;
            this.units = units;
        }

        abstract double bill();
    }

    static class HomeConnection extends Connection {
        HomeConnection(String type, double units) {
            super(type, units);
        }

        @Override
        double bill() {
            if (units <= 100) {
                return units * 5;
            }
            return 100 * 5 + (units - 100) * 7;
        }
    }

    static class ShopConnection extends Connection {
        ShopConnection(String type, double units) {
            super(type, units);
        }

        @Override
        double bill() {
            return units * 8 + 100;
        }
    }

    static class FactoryConnection extends Connection {
        FactoryConnection(String type, double units) {
            super(type, units);
        }

        @Override
        double bill() {
            return Math.max(units * 6, 1000);
        }
    }

    static Connection create(String type, double units) {
        switch (type) {
            case "HOME":
                return new HomeConnection(type, units);
            case "SHOP":
                return new ShopConnection(type, units);
            case "FACTORY":
                return new FactoryConnection(type, units);
            default:
                throw new IllegalArgumentException("Unknown connection type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Connection> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();
            connections.add(create(type, units));
        }
        double total = 0;
        for (Connection connection : connections) {
            double bill = connection.bill();
            total += bill;
            System.out.printf("%s: %.2f%n", connection.type, bill);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
