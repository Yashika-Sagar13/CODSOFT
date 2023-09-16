
import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

// Class to represent the ATM machine
class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        userAccount = account;
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            displayMenu();
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 4:
                    quit = true;
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option (1-4).");
            }
        }
        scanner.close();
    }

    public void checkBalance() {
        double balance = userAccount.getBalance();
        System.out.println("Your account balance is: $" + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            userAccount.deposit(amount);
            System.out.println("Deposit successful. Your new balance is: $" + userAccount.getBalance());
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (userAccount.withdraw(amount)) {
                System.out.println("Withdrawal successful. Your new balance is: $" + userAccount.getBalance());
            } else {
                System.out.println("Insufficient funds. Withdrawal failed.");
            }
        } else {
            System.out.println("Invalid withdrawal amount. Please enter a positive amount.");
        }
    }
}

public class AtmMachine {
    public static void main(String[] args) {
        // Create a user's bank account with an initial balance of $1000
        BankAccount userAccount = new BankAccount(1000);

        // Create an ATM instance and connect it to the user's account
        ATM atm = new ATM(userAccount);

        // Run the ATM
        atm.run();
    }
}

