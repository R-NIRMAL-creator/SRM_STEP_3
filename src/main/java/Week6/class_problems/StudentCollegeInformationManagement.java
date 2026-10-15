package main.java.Week6.class_problems;

public class StudentCollegeInformationManagement {

    static class Student {
        static String collegeName = "SRM Institute of Science and Technology";
        static int studentCount = 0;

        String name;
        int attendance;

        Student(String name, int attendance) {
            this.name = name;
            this.attendance = attendance;
            studentCount++;
        }

        static void printCollegeInfo() {
            System.out.println(collegeName);
            System.out.println("Students created: " + studentCount);
        }
    }

    public static void main(String[] args) {
        new Student("Asha", 92);
        new Student("Ravi", 88);
        Student.printCollegeInfo();
    }
}
