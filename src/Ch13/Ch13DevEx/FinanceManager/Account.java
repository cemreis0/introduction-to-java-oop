package Ch13.Ch13DevEx.FinanceManager;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

// the superclass of savings and checking accounts
abstract class Account implements Serializable {
    // data members
    private static final String filePath = "src/Ch13/Ch13DevEx/FinanceManager/accounts/accounts.dat";
    private static final String tempFilePath = "src/Ch13/Ch13DevEx/FinanceManager/accounts/temp.dat";
    protected String name; // name of the account
    protected double balance; // current balance in the account
    protected Date dateOfTransaction; // date of each transaction
    protected SimpleDateFormat sdf; // format the transaction date
    protected List<String> transactions; // list of all transactions in the format: <operation type> <amount> <date>

    // constructors
    public Account() {
        init("no name", 0.00);
        createAccount();
    }
    public Account(String name) {
        init(name, 0.00);
        createAccount();
    }

    public Account(String name, double balance) {
        init(name, balance);
        createAccount();
    }

    abstract void deposit(double amount);

    abstract void withdraw(double amount);

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // constructor init method
    private void init(String name, double balance) throws IllegalArgumentException {
        this.name = name;
        this.balance = balance;
        transactions = new ArrayList<>();
        sdf = new SimpleDateFormat("HH.mm-dd.MM.yyyy");
    }

    // add new transaction to transactions arraylist
    protected void addTransaction(String type, double amount, double fee, String date) throws IllegalArgumentException {
        if (!type.equals("deposit") && !type.equals("withdraw")) {
            throw new IllegalStateException("Invalid transaction type.");
        }

        String transaction = type + "," + amount + "," + fee +  "," + date;

        transactions.add(transaction);
    }

    // crud: write this created object to the arraylist in the file
    protected void createAccount() {
        File file = new File(filePath);
        List<Account> accounts;
        try (
            // read stream
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            // get the accounts list and add this account
            accounts = (ArrayList) objectInputStream.readObject();
            accounts.add(this);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected static Account readAccount(String accountName) {
        File file = new File(filePath);
        List<Account> accounts;

        try (
                // Read stream
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {
            // Deserialize the list of accounts
            accounts = (List<Account>) objectInputStream.readObject();

            // Search for the account by name
            for (Account account : accounts) {
                if (account.getName().equals(accountName)) { // Assuming you have a method getName() to get the account name
                    return account;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null; // Return null if the account was not found
    }

    // CRUD: update an account, 1 - updated, 0 - not found, -1 - error
    protected int updateAccount(Account newAccount) {
        List<Account> accounts;

        try (
                // Read the existing accounts from the file
                FileInputStream fileInputStream = new FileInputStream(filePath);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            accounts = (List<Account>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            // Handle file not found exception
            return 0; // Account not found
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Error occurred during the update
        }

        // Find the account to update by comparing account names
        int indexOfAccountToUpdate = -1;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getName().equals(newAccount.getName())) {
                indexOfAccountToUpdate = i;
                break; // Exit the loop once the account is found
            }
        }

        if (indexOfAccountToUpdate != -1) {
            // Update the account in the ArrayList
            accounts.set(indexOfAccountToUpdate, newAccount);

            // Write the updated ArrayList back to the file
            try (
                FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
            ) {
                objectOutputStream.writeObject(accounts);
                return 1; // Account was updated
            } catch (Exception e) {
                e.printStackTrace();
                return -1; // Error occurred while writing the updated accounts
            }
        } else {
            return 0; // Account not found
        }
    }

    // CRUD: delete an account, 1 - deleted, 0 - not found, -1 - error
    protected static int deleteAccount(String accountName) {
        List<Account> accounts;

        try (
            // Read stream
            FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            // Read the accounts from the file
            accounts = (List<Account>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            // Handle file not found exception
            return 0; // Account not found
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Error occurred during the read
        }

        boolean accountDeleted = false;

        // Find the account to delete by comparing account names
        for (Account account : accounts) {
            if (accountName.equals(account.getName())) {
                accounts.remove(account);
                accountDeleted = true;
                break;
            }
        }

        if (accountDeleted) {
            // Write the updated ArrayList back to the file
            try (
                    FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
            ) {
                objectOutputStream.writeObject(accounts);
                return 1; // Account was deleted
            } catch (Exception e) {
                e.printStackTrace();
                return -1; // Error occurred during writing
            }
        } else {
            return 0; // Account not found
        }
    }
}
