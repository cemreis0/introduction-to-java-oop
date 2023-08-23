public class Assertions {
    public static void main(String[] args) {
        BankAccount acct = new BankAccount(200);
        acct.deposit(25);
        System.out.println("Current Balance: " + acct.getBalance());
    }
}

class BankAccount {
    // data members
    private double balance;

    // constructors
    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        double oldBalance = balance;

        balance += amount;

        assert balance > oldBalance;
    }

    public void withdraw(double amount) {
        double oldBalance = balance;

        balance -= amount;

        assert balance < oldBalance;
    }

    public double getBalance() {
        return balance;
    }
}