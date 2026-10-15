package main.java.Week9.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GardenPlotAreaReport {

    static abstract class Plot {
        final String shape;
        final String owner;

        Plot(String shape, String owner) {
            this.shape = shape;
            this.owner = owner;
        }

        abstract double area();
    }

    static class CirclePlot extends Plot {
        final double radius;

        CirclePlot(String shape, String owner, double radius) {
            super(shape, owner);
            this.radius = radius;
        }

        @Override
        double area() {
            return Math.PI * radius * radius;
        }
    }

    static class RectanglePlot extends Plot {
        final double length;
        final double width;

        RectanglePlot(String shape, String owner, double length, double width) {
            super(shape, owner);
            this.length = length;
            this.width = width;
        }

        @Override
        double area() {
            return length * width;
        }
    }

    static class TrianglePlot extends Plot {
        final double base;
        final double height;

        TrianglePlot(String shape, String owner, double base, double height) {
            super(shape, owner);
            this.base = base;
            this.height = height;
        }

        @Override
        double area() {
            return 0.5 * base * height;
        }
    }

    static Plot readPlot(Scanner sc) {
        String shape = sc.next();
        String owner = sc.next();
        switch (shape) {
            case "CIRCLE":
                return new CirclePlot(shape, owner, sc.nextDouble());
            case "RECTANGLE":
                return new RectanglePlot(shape, owner, sc.nextDouble(), sc.nextDouble());
            case "TRIANGLE":
                return new TrianglePlot(shape, owner, sc.nextDouble(), sc.nextDouble());
            default:
                throw new IllegalArgumentException("Unknown shape: " + shape);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Plot> plots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            plots.add(readPlot(sc));
        }
        double totalArea = 0;
        for (Plot plot : plots) {
            double area = plot.area();
            totalArea += area;
            System.out.printf("%s (%s): %.2f%n", plot.owner, plot.shape, area);
        }
        System.out.printf("Total Area: %.2f%n", totalArea);
    }
}
