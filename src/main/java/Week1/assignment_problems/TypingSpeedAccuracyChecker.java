package main.java.Week1.assignment_problems;

public class TypingSpeedAccuracyChecker {

    static void checkTypingAccuracy(String original, String typed) {
        if (original.length() != typed.length()) {
            System.out.println("Both texts must have the same length");
            return;
        }
        int total = original.length();
        int matched = 0;
        int firstMismatch = -1;
        for (int i = 0; i < total; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }
        double accuracy = total == 0 ? 100.0 : matched * 100.0 / total;
        String mismatchInfo = "No Mismatches";
        if (firstMismatch != -1) {
            mismatchInfo = "First Mismatch at position " + (firstMismatch + 1)
                    + " ('" + original.charAt(firstMismatch) + "' vs '" + typed.charAt(firstMismatch) + "')";
        }
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | %s%n", matched, total, accuracy, mismatchInfo);
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}
