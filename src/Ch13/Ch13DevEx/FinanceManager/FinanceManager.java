package Ch13.Ch13DevEx.FinanceManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FinanceManager {
    public static void main(String[] args) {
        final String filePath = "src/Ch13/Ch13DevEx/FinanceManager/accounts/accounts.dat";
        List<Account> accounts = new ArrayList<>();

        Account savings1 = new SavingsAccount("Savings 1");
        Account savings2 = new SavingsAccount("Savings 2");
        Account checking1 = new CheckingAccount("Checking 1");
        Account checking2 = new CheckingAccount("Checking 2");

        savings1.deposit(100);
        savings2.deposit(250);
        checking1.deposit(450);
        checking2.deposit(50);
        savings1.withdraw(50);
        savings2.withdraw(75);
        checking1.withdraw(25);
        checking2.withdraw(50);

        accounts.add(savings1);
        accounts.add(savings2);
        accounts.add(checking1);
        accounts.add(checking2);

        // save the accounts to a file
        File file = new File(filePath);
        try (
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {
            objectOutputStream.writeObject(accounts);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // read the accounts from the file
        List<Account> accountList;
        try (
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            accountList = (List<Account>) objectInputStream.readObject();

            for (Account account : accountList) {
                System.out.println("---------------");
                System.out.println("Name: " +account.getName());
                System.out.println("Balance: " + account.getBalance());

                for (String transaction : account.getTransactions()) {
                    String[] parts = transaction.split(",");
                    System.out.format("%25s%25s%25s%25s", parts[0], parts[1], parts[2], parts[3]);
                    System.out.println();
                }
                System.out.println("---------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

