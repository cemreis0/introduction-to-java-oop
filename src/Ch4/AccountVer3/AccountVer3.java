import java.text.*;

public class AccountVer3 {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.00");
        AccountVer3 acct;
        acct = new AccountVer3("Carl Smith", 50.00);
        acct.deduct(10);
        acct.deduct(10);
        acct.deduct(10);
        System.out.println("Owner: " + acct.getOwnerName());
        System.out.println("Bal : $" + df.format(acct.getCurrentBalance()));
    }
    // data members
    private static final double FEE = 0.50; // class constant
    private String ownerName;
    private double balance;

    // constructor
    public AccountVer3(String name, double startingBalance) {
        ownerName = name;
        balance = startingBalance;
    }

    // methods
    public void deduct(double amt) {
        balance -= amt + FEE;
    }
    public void add(double amt) {
        balance += amt;
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
