package main.java.Week1.class_problems;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    static char findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < text.length(); i++) {
            if (frequency.get(text.charAt(i)) == 1) {
                return text.charAt(i);
            }
        }
        return '\0';
    }

    static void report(String text) {
        char result = findFirstNonRepeatingChar(text);
        if (result == '\0') {
            System.out.println("No Non-Repeating Character Found");
        } else {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        }
    }

    public static void main(String[] args) {
        report("swiss");
        report("aabbcc");
    }
}
