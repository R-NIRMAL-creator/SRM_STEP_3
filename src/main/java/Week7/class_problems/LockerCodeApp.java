package main.java.Week7.class_problems;

public class LockerCodeApp {

    static class Locker {
        private final int lockerNumber;
        private String code;

        Locker(int lockerNumber, String code) {
            this.lockerNumber = lockerNumber;
            this.code = code;
        }

        boolean changeCode(String currentCode, String newCode) {
            if (!code.equals(currentCode)) {
                return false;
            }
            code = newCode;
            return true;
        }

        int getLockerNumber() {
            return lockerNumber;
        }
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        System.out.println("Locker " + l.getLockerNumber());
        System.out.println(l.changeCode("1234", "5678") ? "success" : "rejected, code unchanged");
        System.out.println(l.changeCode("0000", "9999") ? "success" : "rejected, code unchanged");
    }
}
