package codsoft;
import java.util.Scanner;
class Account 
{
    private double balance;

    public Account(double iBalance) 
    {
        this.balance = iBalance;
    }

    public double getBalance() 
    {
        return balance;
    }

    public void deposit(double amt) 
    {
        if (amt > 0) 
        {
           balance=balance+ amt;
           double newbalance=balance;
            System.out.println("Successfully deposited: ₹"+ amt);
            System.out.println("Updated balance:₹"+newbalance);
            
        } 
        else 
        {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amt) 
    {
        if (amt > 0 && amt <= balance) 
        {
            balance=balance- amt;
            System.out.println("Successfully withdrew: ₹" + amt);
            System.out.println("Current balance: ₹"+balance);
            return true;
        } 
        else 
        {
            System.out.println("Insufficient balance or invalid amount.");
            return false;
        }
    }
}

// Class to represent the ATM machine
class ATM {
    private Account uAccount;
    private Scanner scanner;

    public ATM(Account account) 
    {
        this.uAccount = account;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() 
    {
        int choice;
        do {
            System.out.println("Transaction Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) 
            {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Exiting. Thank you!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }while (choice != 4);
    }

    private void checkBalance() 
    {
        System.out.println("Current balance: ₹" + uAccount.getBalance());
    }

    private void deposit() 
    {
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        uAccount.deposit(amount);
    }

    private void withdraw() 
    {
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        uAccount.withdraw(amount);
    }
}

// Main class to run the program
public class TASK3 
{
    public static void main(String[] args) 
    {
        Account account = new Account(1000.00); // Initial balance
        ATM atm = new ATM(account);
        atm.showMenu();
    }
}
