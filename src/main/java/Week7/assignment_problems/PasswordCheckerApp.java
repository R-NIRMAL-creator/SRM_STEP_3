package main.java.Week7.assignment_problems;

public class PasswordCheckerApp {

    static class PasswordChecker {
        private final String password;

        PasswordChecker(String password) {
            this.password = password;
        }

        String getStrength() {
            int length = password.length();
            if (length < 6) {
                return "Weak";
            } else if (length < 10) {
                return "Medium";
            }
            return "Strong";
        }
    }

    public static void main(String[] args) {
        System.out.println(new PasswordChecker("abcd").getStrength());
        System.out.println(new PasswordChecker("abcdefgh").getStrength());
        System.out.println(new PasswordChecker("abcdefghij").getStrength());
        System.out.println(new PasswordChecker("abcdefghijkl").getStrength());
    }
}
