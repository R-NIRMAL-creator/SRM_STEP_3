package main.java.Week8.assignment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HostelElectricityBill {

    static abstract class Room {
        final String type;
        final int units;

        Room(String type, int units) {
            this.type = type;
            this.units = units;
        }

        abstract double bill();
    }

    static class SingleRoom extends Room {
        SingleRoom(String type, int units) {
            super(type, units);
        }

        @Override
        double bill() {
            return 8.0 * units;
        }
    }

    static class SharedRoom extends Room {
        final int occupants;

        SharedRoom(String type, int units, int occupants) {
            super(type, units);
            this.occupants = occupants;
        }

        @Override
        double bill() {
            return 6.0 * units / occupants;
        }
    }

    static class AcRoom extends Room {
        static final double FIXED_CHARGE = 200;

        AcRoom(String type, int units) {
            super(type, units);
        }

        @Override
        double bill() {
            return 10.0 * units + FIXED_CHARGE;
        }
    }

    static Room readRoom(Scanner sc) {
        String type = sc.next();
        int units = sc.nextInt();
        switch (type) {
            case "SINGLE":
                return new SingleRoom(type, units);
            case "SHARED":
                return new SharedRoom(type, units, sc.nextInt());
            case "AC":
                return new AcRoom(type, units);
            default:
                throw new IllegalArgumentException("Unknown room type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rooms.add(readRoom(sc));
        }
        double total = 0;
        for (Room room : rooms) {
            double bill = room.bill();
            total += bill;
            System.out.printf("%s: %.2f%n", room.type, bill);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
