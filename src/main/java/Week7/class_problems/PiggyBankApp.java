package main.java.Week7.class_problems;

public class PiggyBankApp {

    static class PiggyBank {
        private final String id;
        private int savings;

        PiggyBank(String id) {
            this.id = id;
            this.savings = 0;
        }

        void deposit(int amount) {
            if (amount > 0) {
                savings += amount;
            }
        }

        boolean withdraw(int amount) {
            if (amount <= 0 || amount > savings) {
                return false;
            }
            savings -= amount;
            return true;
        }

        int getSavings() {
            return savings;
        }

        String getId() {
            return id;
        }
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        System.out.println("Piggy bank " + pb.getId() + " starts at " + pb.getSavings());
        pb.deposit(100);
        System.out.println("savings = " + pb.getSavings());
        pb.withdraw(30);
        System.out.println("savings = " + pb.getSavings());
        if (!pb.withdraw(500)) {
            System.out.println("rejected, savings stays " + pb.getSavings());
        }
    }
}
