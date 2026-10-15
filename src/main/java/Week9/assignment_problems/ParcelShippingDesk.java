package main.java.Week9.assignment_problems;

import java.util.Scanner;

public class ParcelShippingDesk {

    interface Insurable {
        double INSURANCE_RATE = 0.02;

        default double insurance(double declaredValue) {
            return declaredValue * INSURANCE_RATE;
        }
    }

    static abstract class Parcel {
        final double weight;

        Parcel(double weight) {
            this.weight = weight;
        }

        abstract double charge();
    }

    static class StandardParcel extends Parcel {
        StandardParcel(double weight) {
            super(weight);
        }

        @Override
        double charge() {
            return 40 + 10 * weight;
        }
    }

    static class ExpressParcel extends Parcel implements Insurable {
        ExpressParcel(double weight) {
            super(weight);
        }

        @Override
        double charge() {
            return 80 + 15 * weight;
        }
    }

    static class FragileParcel extends StandardParcel implements Insurable {
        static final double HANDLING_FEE = 50;

        FragileParcel(double weight) {
            super(weight);
        }

        @Override
        double charge() {
            return super.charge() + HANDLING_FEE;
        }
    }

    static Parcel create(String type, double weight) {
        switch (type) {
            case "STANDARD":
                return new StandardParcel(weight);
            case "EXPRESS":
                return new ExpressParcel(weight);
            case "FRAGILE":
                return new FragileParcel(weight);
            default:
                throw new IllegalArgumentException("Unknown parcel type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double declaredValue = sc.nextDouble();
            Parcel parcel = create(type, weight);
            double charge = parcel.charge();
            double insurance = 0;
            if (parcel instanceof Insurable) {
                insurance = ((Insurable) parcel).insurance(declaredValue);
            }
            double total = charge + insurance;
            grandTotal += total;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", type, charge, insurance, total);
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
    }
}
