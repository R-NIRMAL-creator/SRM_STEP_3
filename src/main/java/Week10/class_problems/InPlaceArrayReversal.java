package main.java.Week10.class_problems;

import java.util.Arrays;
import java.util.Scanner;

public class InPlaceArrayReversal {

    static int[] parseNumbers(String line) {
        String[] parts = line.replace("[", "").replace("]", "").replace(",", " ").trim().split("\\s+");
        int[] numbers = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }
        return numbers;
    }

    static void reverse(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] tokens = parseNumbers(sc.nextLine());
        reverse(tokens);
        System.out.println(Arrays.toString(tokens));
    }
}
