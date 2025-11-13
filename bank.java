import java.util.Scanner;

// Base Class: Account
class Account {
    protected String customerName;
    protected int accountNumber;
    protected String accountType;
    protected double balance;

    // Constructor
    public Account(String name, int accNo, String type, double initialBalance) {
        this.customerName = name;
        this.accountNumber = accNo;
        this.accountType = type;
        this.balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: Rs. " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Display balance
    public void displayBalance() {
        System.out.println("Account Holder: " + customerName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Current Balance: Rs. " + balance);
    }

    // Abstract method placeholders (to be implemented by subclasses)
    public void withdraw(double amount) {}
    public void computeInterest() {}
}

// Derived Class: Savings Account
class SavAccount extends Account {
    private static final double INTEREST_RATE = 0.05; // 5% annual interest

    public SavAccount(String name, int accNo, double initialBalance) {
        super(name, accNo,"Savings", initialBalance);
    }

    // Compute compound interest (annually)
    @Override
    public void computeInterest() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of years: ");
        double time = sc.nextDouble();

        System.out.print("Enter number of times interest compounded per year (e.g., 4 for quarterly): ");
        int n = sc.nextInt();

        double amount = balance * Math.pow((1 + INTEREST_RATE / n), n * time);
        double interest = amount - balance;

        balance = amount;
        System.out.println("Compound interest of Rs. " + String.format("%.2f", interest) + " added to your account.");
    }
    // Withdrawal method
    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: Rs. " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

// Derived Class: Current Account
class CurAccount extends Account {
    private static final double MIN_BALANCE = 1000.0;
    private static final double SERVICE_CHARGE = 100.0;

    public CurAccount(String name, int accNo, double initialBalance) {
        super(name, accNo, "Current", initialBalance);
    }

    // No interest for current account
    @Override
    public void computeInterest() {
        System.out.println("No interest for current accounts.");
    }

    // Withdrawal method with minimum balance check
    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: Rs. " + amount);

            // Check for minimum balance
            if (balance < MIN_BALANCE) {
                balance -= SERVICE_CHARGE;
                System.out.println("Balance below Rs. " + MIN_BALANCE + ". Service charge of Rs. " + SERVICE_CHARGE + " imposed.");
            }
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

// Main Bank class to test the program
public class bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter customer name:");
        String name = sc.nextLine();

        System.out.println("Enter account number:");
        int accNo = sc.nextInt();

        System.out.println("Enter initial balance:");
        double initialBalance = sc.nextDouble();

        System.out.println("Enter account type (1 for Savings, 2 for Current):");
        int typeChoice = sc.nextInt();

        Account account;

        if (typeChoice == 1) {
            account = new SavAccount(name, accNo, initialBalance);
        } else {
            account = new CurAccount(name, accNo, initialBalance);
        }

        int choice;
        do {
            System.out.println("\n--- BANK MENU ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            System.out.println("4. Compute Interest");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double wd = sc.nextDouble();
                    account.withdraw(wd);
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    account.computeInterest();
                    break;
                case 5:
                    System.out.println("Thank you for banking with us!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}              
