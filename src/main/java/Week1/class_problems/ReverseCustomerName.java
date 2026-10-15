package main.java.Week1.class_problems;

public class ReverseCustomerName {

    static String reverseCustomerName(String customerName) {
        char[] letters = customerName.toCharArray();
        char[] reversed = new char[letters.length];
        for (int i = 0; i < letters.length; i++) {
            reversed[i] = letters[letters.length - 1 - i];
        }
        return new String(reversed);
    }

    public static void main(String[] args) {
        String customerName = "Sunil";
        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reverseCustomerName(customerName));
    }
}
