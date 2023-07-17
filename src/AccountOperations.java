public class AccountOperations {
    public static void main(String[] args) {
        Account acct, acct1, acct2;

        String myName = "Cem Cem";

        acct = new Account("Cem Reis", 250.00);
        acct.setOwnerName(myName);

        acct.add(25.00);
        acct.deduct(50);

        acct1 = new Account("John Smith", 500);
        acct1.setOwnerName("John Doe");

        acct2 = new Account("John Doe", 125);
        acct2.setOwnerName("John Doe");

        // output
        System.out.println("Hi, " + acct.ownerName + "!" + "\n" + "Current balance: $" + acct.getCurrentBalance());
    }
}

class Account {
    public String ownerName;
    public double balance;

    public Account(String name, double startingBalance) {
        ownerName = name;
        balance = startingBalance;
    }

    public void add(double amt) {
        balance += amt;
    }

    public void deduct(double amt) {
        balance -= amt;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String name) {
        ownerName = name;
    }

    public double getCurrentBalance() {
        return balance;
    }
}
