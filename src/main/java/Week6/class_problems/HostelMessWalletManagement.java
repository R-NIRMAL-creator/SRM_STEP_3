package main.java.Week6.class_problems;

public class HostelMessWalletManagement {

    static class MessWallet {
        private double balance;

        MessWallet(double openingBalance) {
            if (openingBalance < 0) {
                System.out.println("Warning: negative balance given, starting at 0");
                this.balance = 0;
            } else {
                this.balance = openingBalance;
            }
        }

        void topUp(double amount) {
            if (amount <= 0) {
                System.out.println("Top-up rejected: amount must be positive");
                return;
            }
            balance += amount;
        }

        void deduct(double amount) {
            if (amount <= 0) {
                System.out.println("Deduct rejected: amount must be positive");
            } else if (amount > balance) {
                System.out.println("Deduct rejected: insufficient balance");
            } else {
                balance -= amount;
            }
        }

        double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        System.out.println("Balance after top-up: " + wallet.getBalance());
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}
