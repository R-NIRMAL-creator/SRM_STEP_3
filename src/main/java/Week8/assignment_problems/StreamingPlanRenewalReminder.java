package main.java.Week8.assignment_problems;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StreamingPlanRenewalReminder {

    static abstract class Plan {
        final String name;
        final LocalDate startDate;

        Plan(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }

        abstract int validityDays();

        LocalDate renewalDate() {
            return startDate.plusDays(validityDays());
        }
    }

    static class BasicPlan extends Plan {
        BasicPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        @Override
        int validityDays() {
            return 30;
        }
    }

    static class StandardPlan extends Plan {
        StandardPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        @Override
        int validityDays() {
            return 90;
        }
    }

    static class PremiumPlan extends Plan {
        PremiumPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        @Override
        int validityDays() {
            return 365;
        }
    }

    static Plan create(String type, String name, LocalDate startDate) {
        switch (type) {
            case "BASIC":
                return new BasicPlan(name, startDate);
            case "STANDARD":
                return new StandardPlan(name, startDate);
            case "PREMIUM":
                return new PremiumPlan(name, startDate);
            default:
                throw new IllegalArgumentException("Unknown plan type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Plan> plans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());
            plans.add(create(type, name, startDate));
        }
        for (Plan plan : plans) {
            System.out.println(plan.name + ": " + plan.renewalDate());
        }
    }
}
