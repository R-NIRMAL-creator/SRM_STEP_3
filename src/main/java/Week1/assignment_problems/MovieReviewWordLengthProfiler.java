package main.java.Week1.assignment_problems;

public class MovieReviewWordLengthProfiler {

    static void classifyWordLengths(String review) {
        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;
        for (String word : review.split("\\s+")) {
            int length = word.replaceAll("[^A-Za-z]", "").length();
            if (length == 0) {
                continue;
            }
            if (length <= 4) {
                shortWords++;
            } else if (length <= 8) {
                mediumWords++;
            } else {
                longWords++;
            }
        }
        System.out.println("Short: " + shortWords + " | Medium: " + mediumWords + " | Long: " + longWords);
    }

    public static void main(String[] args) {
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}
