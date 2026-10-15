package main.java.Week1.class_problems;

public class BmiCalculatorForTeam {

    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        }
        return "Obese";
    }

    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.printf("%-8s| %-11s| %-12s| %-7s| %s%n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf("%-8d| %-11.2f| %-12.1f| %-7.2f| %s%n",
                    i + 1, heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        double[] heights = {1.75, 1.60, 1.82, 1.68, 1.55, 1.90, 1.72, 1.65, 1.78, 1.58};
        double[] weights = {70, 90, 58, 78, 52, 105, 95, 49, 72, 68};
        printWellnessReport(heights, weights);
    }
}
