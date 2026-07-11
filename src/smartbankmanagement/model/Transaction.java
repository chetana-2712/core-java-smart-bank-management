package smartbankmanagement.model;

import java.time.LocalDateTime;

public class Transaction {

    private TransactionType transactionType;
    private double amount;
    private double balance;
    private LocalDateTime dateTime;

    public Transaction(TransactionType transactionType, double amount, double balance) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.balance = balance;
        this.dateTime = LocalDateTime.now();
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "Type=" + transactionType +
                ", Amount=" + amount +
                ", Balance=" + balance +
                ", Date=" + dateTime +
                '}';
    }
}