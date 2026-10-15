package main.java.Week6.assignment_problems;

public class EmployeeCompanyInformationManagement {

    static class Employee {
        static String companyName = "Bright Horizon Technologies";
        static int employeeCount = 0;

        String empName;
        double salary;

        Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }

        static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }

    public static void main(String[] args) {
        new Employee("Asha", 40000);
        new Employee("Ravi", 45000);
        new Employee("Neha", 50000);
        Employee.printCompanyInfo();
    }
}
