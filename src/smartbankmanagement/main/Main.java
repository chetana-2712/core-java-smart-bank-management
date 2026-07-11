package smartbankmanagement.main;

import smartbankmanagement.model.Customer;
import smartbankmanagement.service.BankService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankService bank = new BankService();

        int choice;

        do {

            System.out.println("\n========== SMART BANK MANAGEMENT SYSTEM ==========");
            System.out.println("1. Register Customer");
            System.out.println("2. View All Customers");
            System.out.println("3. Search Customer");
            System.out.println("4. Update Customer");
            System.out.println("5. Delete Customer");
            System.out.println("6. Create Account");
            System.out.println("7. Deposit");
            System.out.println("8. Withdraw");
            System.out.println("9. Transfer Money");
            System.out.println("10. Check Balance");
            System.out.println("11. Transaction History");
            System.out.println("12. Change PIN");
            System.out.println("13. Exit");

            System.out.print("Enter Your Choice : ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    bank.createCustomer();
                    break;

                case 2:
                    bank.showAllCustomers();
                    break;

                case 3:
                    Customer customer = bank.searchCustomer();

                    if(customer != null){
                        System.out.println(customer);
                    }

                    break;

                case 4:
                    bank.updateCustomer();
                    break;

                case 5:
                    bank.deleteCustomer();
                    break;

                case 6:
                    bank.createAccount();
                    break;

                case 7:
                    bank.depositMoney();
                    break;

                case 8:
                    bank.withdrawMoney();
                    break;

                case 9:
                    bank.transferMoney();
                    break;

                case 10:
                    bank.checkBalance();
                    break;

                case 11:
                    bank.transactionHistory();
                    break;

                case 12:
                    bank.changePin();
                    break;

                case 13:
                    System.out.println("Thank You For Using Smart Bank.");
                    break;

                default:
                    System.out.println("Invalid Choice.");

            }

        } while (choice != 13);

        sc.close();

    }
}