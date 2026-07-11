package smartbankmanagement.model;

import java.util.ArrayList;

public class Account {

    private String accountNumber;
    private AccountType accountType;
    private Customer customer;
    private double balance;
    private int pin;
    ;
    private ArrayList<Transaction> transactionHistory;

    public Account(String accountNumber,Customer customer,AccountType accountType, double balance, int pin) {
        this.accountNumber = accountNumber;
        this.customer=customer;
        this.accountType = accountType;
        this.balance = balance;
        this.pin = pin;
        this.transactionHistory = new ArrayList<>();
    }

    // Getters

    public String getAccountNumber() {
        return accountNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public int getPin() {
        return pin;
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    // Setter

    public void setPin(int pin) {
        this.pin = pin;
    }

    // Deposit

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;

            transactionHistory.add(
                    new Transaction(TransactionType.DEPOSIT, amount, balance)
            );

            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    // Withdraw

    public void withdraw(double amount) {
        if (amount <= balance) {

            balance -= amount;

            transactionHistory.add(
                    new Transaction(TransactionType.WITHDRAW, amount, balance)
            );

            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient Balance.");
        }
    }

    // Display Transaction History

    public void showTransactionHistory() {

        if (transactionHistory.isEmpty()) {
            System.out.println("No Transactions Found.");
            return;
        }

        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    @Override
    public String toString() {

        return "\nAccount Number : " + accountNumber +
                "\nAccount Type : " + accountType +
                "\nBalance : ₹" + balance;
    }
}