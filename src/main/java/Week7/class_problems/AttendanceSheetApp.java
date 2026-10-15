package main.java.Week7.class_problems;

public class AttendanceSheetApp {

    static class AttendanceSheet {
        private final String[] present;
        private int count;

        AttendanceSheet(int maxStudents) {
            this.present = new String[maxStudents];
        }

        void markPresent(String name) {
            if (count < present.length && !isPresent(name)) {
                present[count++] = name;
            }
        }

        int getPresentCount() {
            return count;
        }

        boolean isPresent(String name) {
            for (int i = 0; i < count; i++) {
                if (present[i].equals(name)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");
        System.out.println("Present count: " + sheet.getPresentCount());
        System.out.println("Ben present: " + sheet.isPresent("Ben"));
        System.out.println("Chen present: " + sheet.isPresent("Chen"));
    }
}
