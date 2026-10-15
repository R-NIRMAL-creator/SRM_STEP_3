package main.java.Week10.class_problems;

import java.util.Scanner;

public class WordReverserPalindromeChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        String reversed = new StringBuilder(word).reverse().toString();
        String status = word.equalsIgnoreCase(reversed) ? "palindrome" : "not a palindrome";
        System.out.println(reversed + " - " + status);
    }
}
