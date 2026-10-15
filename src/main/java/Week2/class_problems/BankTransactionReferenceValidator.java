package main.java.Week2.class_problems;

public class BankTransactionReferenceValidator {

    static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: reference must be exactly 14 characters";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: date and sequence number must be digits";
            }
        }
        StringBuilder line = new StringBuilder();
        line.append("[").append(reference, 0, 3).append("] DATE: ")
            .append(reference, 3, 5).append("/")
            .append(reference, 5, 7).append("/")
            .append(reference, 7, 9)
            .append(" | SEQ: ").append(reference.substring(9));
        return line.toString();
    }

    public static void main(String[] args) {
        System.out.println(validateAndFormat(normalizeReference(" hdf03022600042 ")));
        System.out.println(validateAndFormat(normalizeReference("12F03022600042")));
        System.out.println(validateAndFormat(normalizeReference("hdf0302260004")));
        System.out.println(validateAndFormat(normalizeReference("hdf0302X600042")));
    }
}
