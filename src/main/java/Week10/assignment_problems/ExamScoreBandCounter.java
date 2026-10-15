package main.java.Week10.assignment_problems;

public class ExamScoreBandCounter {

    static int firstIndexAtLeast(int[] scores, int target) {
        int left = 0;
        int right = scores.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static int countInBand(int[] scores, int low, int high) {
        int firstInBand = firstIndexAtLeast(scores, low);
        int firstAboveBand = firstIndexAtLeast(scores, high + 1);
        return firstAboveBand - firstInBand;
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        System.out.println(countInBand(scores, 42, 58));
        System.out.println(countInBand(scores, 90, 100));
        System.out.println(countInBand(scores, 0, 100));
        System.out.println(countInBand(scores, 58, 58));
        System.out.println(countInBand(scores, 36, 41));
    }
}
