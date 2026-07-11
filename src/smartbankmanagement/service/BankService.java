package smartbankmanagement.service;

import smartbankmanagement.model.*;
import smartbankmanagement.util.AccountGenerator;
import smartbankmanagement.util.InputValidator;

import java.util.ArrayList;
import java.util.Scanner;

public class BankService {

    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Account> accounts = new ArrayList<>();

    private Scanner sc = new Scanner(System.in);

    private int customerCounter = 1;

    public void createCustomer() {

        System.out.println("\n----- Customer Registration -----");

        System.out.print("Enter Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Mobile : ");
        String mobile = sc.nextLine();

        if (!InputValidator.isValidMobile(mobile)) {
            System.out.println("Invalid Mobile Number.");
            return;
        }

        System.out.print("Enter Email : ");
        String email = sc.nextLine();

        if (!InputValidator.isValidEmail(email)) {
            System.out.println("Invalid Email.");
            return;
        }

        System.out.print("Enter Address : ");
        String address = sc.nextLine();

        Customer customer = new Customer(
                customerCounter++,
                name,
                mobile,
                email,
                address
        );

        customers.add(customer);

        System.out.println("Customer Registered Successfully.");
    }

    public void showAllCustomers() {

        if(customers.isEmpty()) {

            System.out.println("No Customers Found.");
            return;
        }

        for(Customer customer : customers) {

            System.out.println(customer);

            System.out.println("---------------------------");
        }
    }

    public Customer searchCustomer() {

        System.out.print("Enter Customer ID : ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Customer customer : customers) {

            if (customer.getCustomerId() == id) {
                return customer;
            }
        }

        System.out.println("Customer Not Found.");
        return null;
    }

    public void updateCustomer() {

        Customer customer = searchCustomer();

        if (customer == null) {
            return;
        }

        System.out.print("Enter New Name : ");
        customer.setName(sc.nextLine());

        System.out.print("Enter New Mobile : ");
        String mobile = sc.nextLine();

        if (InputValidator.isValidMobile(mobile)) {
            customer.setMobile(mobile);
        } else {
            System.out.println("Invalid Mobile Number.");
        }

        System.out.print("Enter New Email : ");
        String email = sc.nextLine();

        if (InputValidator.isValidEmail(email)) {
            customer.setEmail(email);
        } else {
            System.out.println("Invalid Email.");
        }

        System.out.print("Enter New Address : ");
        customer.setAddress(sc.nextLine());

        System.out.println("Customer Updated Successfully.");
    }

    public void deleteCustomer() {

        Customer customer = searchCustomer();

        if (customer == null) {
            return;
        }

        customers.remove(customer);

        System.out.println("Customer Deleted Successfully.");
    }

    public void createAccount() {

        Customer customer = searchCustomer();

        if (customer == null) {
            return;
        }

        System.out.println("Select Account Type");
        System.out.println("1. Savings");
        System.out.println("2. Current");

        int choice = sc.nextInt();

        AccountType accountType;

        if (choice == 1) {
            accountType = AccountType.SAVINGS;
        } else if (choice == 2) {
            accountType = AccountType.CURRENT;
        } else {
            System.out.println("Invalid Choice.");
            return;
        }

        System.out.print("Enter Opening Balance : ");
        double balance = sc.nextDouble();

        if (!InputValidator.isValidAmount(balance)) {
            System.out.println("Invalid Balance.");
            return;
        }

        System.out.print("Set 4 Digit PIN : ");
        int pin = sc.nextInt();
        sc.nextLine();

        if (!InputValidator.isValidPin(pin)) {
            System.out.println("Invalid PIN.");
            return;
        }

        String accountNumber = AccountGenerator.generateAccountNumber();

        Account account = new Account(
                accountNumber,
                customer,
                accountType,
                balance,
                pin
        );

        accounts.add(account);

        System.out.println("Account Created Successfully.");
        System.out.println("Account Number : " + accountNumber);
    }

    public Account login() {

        System.out.print("Enter Account Number : ");
        String accountNumber = sc.nextLine();

        System.out.print("Enter PIN : ");
        int pin = sc.nextInt();
        sc.nextLine();

        for (Account account : accounts) {

            if (account.getAccountNumber().equals(accountNumber)
                    && account.getPin() == pin) {

                System.out.println("Login Successful.");
                return account;
            }
        }

        System.out.println("Invalid Account Number or PIN.");
        return null;
    }

    public void depositMoney() {

        Account account = login();

        if (account == null) {
            return;
        }

        System.out.print("Enter Amount : ");
        double amount = sc.nextDouble();
        sc.nextLine();

        if (!InputValidator.isValidAmount(amount)) {
            System.out.println("Invalid Amount.");
            return;
        }

        account.deposit(amount);
    }

    public void withdrawMoney() {

        Account account = login();

        if (account == null) {
            return;
        }

        System.out.print("Enter Amount : ");
        double amount = sc.nextDouble();
        sc.nextLine();

        if (!InputValidator.isValidAmount(amount)) {
            System.out.println("Invalid Amount.");
            return;
        }

        account.withdraw(amount);
    }

    public void transferMoney() {

        Account sender = login();

        if (sender == null) {
            return;
        }

        System.out.print("Enter Receiver Account Number : ");
        String receiverAccountNumber = sc.nextLine();

        Account receiver = null;

        for (Account account : accounts) {

            if (account.getAccountNumber().equals(receiverAccountNumber)) {
                receiver = account;
                break;
            }
        }

        if (receiver == null) {
            System.out.println("Receiver Account Not Found.");
            return;
        }

        System.out.print("Enter Amount : ");
        double amount = sc.nextDouble();
        sc.nextLine();

        if (!InputValidator.isValidAmount(amount)) {
            System.out.println("Invalid Amount.");
            return;
        }

        if (sender.getBalance() < amount) {
            System.out.println("Insufficient Balance.");
            return;
        }

        sender.withdraw(amount);
        receiver.deposit(amount);

        System.out.println("Money Transferred Successfully.");
    }
    public void checkBalance() {

        Account account = login();

        if (account == null) {
            return;
        }

        System.out.println("Current Balance : ₹" + account.getBalance());
    }

    public void transactionHistory() {

        Account account = login();

        if (account == null) {
            return;
        }

        account.showTransactionHistory();
    }
    public void changePin() {

        Account account = login();

        if (account == null) {
            return;
        }

        System.out.print("Enter New PIN : ");
        int newPin = sc.nextInt();
        sc.nextLine();

        if (!InputValidator.isValidPin(newPin)) {
            System.out.println("Invalid PIN.");
            return;
        }

        account.setPin(newPin);

        System.out.println("PIN Changed Successfully.");
    }
}