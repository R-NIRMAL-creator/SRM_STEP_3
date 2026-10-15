package main.java.Week10.class_problems;

import java.util.Scanner;

public class PrimeNumberChecker {

    static boolean isPrime(long number) {
        if (number < 2) {
            return false;
        }
        for (long i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long number = sc.nextLong();
        System.out.println(number + (isPrime(number) ? " is prime" : " is not prime"));
    }
}
