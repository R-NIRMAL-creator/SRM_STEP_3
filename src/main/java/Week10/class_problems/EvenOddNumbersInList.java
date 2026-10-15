package main.java.Week10.class_problems;

import java.util.Scanner;

public class EvenOddNumbersInList {

    static int[] parseNumbers(String line) {
        String[] parts = line.replace("[", "").replace("]", "").replace(",", " ").trim().split("\\s+");
        int[] numbers = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }
        return numbers;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = parseNumbers(sc.nextLine());
        int even = 0;
        int odd = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
}
