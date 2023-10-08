package Ch13.Ch13DevEx.FinanceManager;

import java.util.Date;

public class SavingsAccount extends Account {
    // data members
    private int numberOfWithdrawalsThisMonth = 0;
    private final double withdrawFee = 1.00; // after the third withdraw in a month

    // constructors
    public SavingsAccount() {
        super();
    }
    public SavingsAccount(String name) {
        super(name);
    }
    public SavingsAccount(String name, double balance) {
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
        if (numberOfWithdrawalsThisMonth < 3) {
            fee = 0.00;
        } else {
            fee = 1.00;
        }

        numberOfWithdrawalsThisMonth++;
        addTransaction("withdraw", amount, 0.00, date);
        updateAccount(this);
    }
}
