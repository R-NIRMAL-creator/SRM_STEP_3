package main.java.Week10.class_problems;

import java.util.Scanner;

public class DigitSumNumberReversal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long number = sc.nextLong();
        int sum = 0;
        long reverse = 0;
        while (number > 0) {
            int digit = (int) (number % 10);
            sum += digit;
            reverse = reverse * 10 + digit;
            number /= 10;
        }
        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reverse);
    }
}
