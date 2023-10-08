package Ch13.Ch13DevEx.FinanceManager;

import java.util.Date;

public class CheckingAccount extends Account {
    // Data members specific to CheckingAccount
    private int numberOfChecksWrittenThisMonth = 0;
    private final double checkFee = 0.50; // Fee for checks written after the first 20

    // Constructors
    public CheckingAccount() {
        super();
    }

    public CheckingAccount(String name) {
        super(name);
    }

    public CheckingAccount(String name, double balance) {
        super(name, balance);
    }

    @Override
    void deposit(double amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalStateException("Amount to deposit cannot be negative");
        }

        balance += amount;

        dateOfTransaction = new Date();
        String date = sdf.format(dateOfTransaction);

        addTransaction("deposit", amount, 0.00, date);

        updateAccount(this);
    }

    @Override
    void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalStateException("Amount to withdraw cannot be negative");
        }

        double tempBalance = balance;
        tempBalance -= amount;

        if (tempBalance < 0) {
            throw new IllegalStateException("Not enough funds.");
        }

        balance -= amount;

        dateOfTransaction = new Date();
        String date = sdf.format(dateOfTransaction);

        double fee;

        // Check if the maximum number of checks for the month has been reached
        if (numberOfChecksWrittenThisMonth < 20) {
            fee = 0.00;
        } else {
            fee = checkFee;
        }

        numberOfChecksWrittenThisMonth++;
        addTransaction("withdraw", amount, fee, date);
        updateAccount(this);
    }
}
