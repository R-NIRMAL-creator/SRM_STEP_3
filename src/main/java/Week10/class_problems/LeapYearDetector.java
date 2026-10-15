package main.java.Week10.class_problems;

import java.util.Scanner;

public class LeapYearDetector {

    static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        System.out.println(isLeapYear(year) ? "Leap year" : "Not a leap year");
    }
}
