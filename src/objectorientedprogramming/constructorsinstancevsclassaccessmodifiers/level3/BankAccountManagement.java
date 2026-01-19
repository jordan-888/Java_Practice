
package objectorientedprogramming.constructorsinstancevsclassaccessmodifiers.level3;
class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Public method to get balance
    public double getBalance() {
        return balance;
    }

    // Public method to update balance (deposit)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
            System.out.println("New Balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Public method to update balance (withdraw)
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
            System.out.println("New Balance: $" + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    // Method to display account details
    public void displayDetails() {
        System.out.println("Bank Account Details:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
        System.out.println("------------------------");
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    // Constructor
    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    // Method to calculate and add interest
    public void addInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
        System.out.println("Interest added: $" + interest);
    }

    // Method to display savings account details
    public void displaySavingsDetails() {
        System.out.println("Savings Account Details:");
        System.out.println("Account Number: " + accountNumber); // public - accessible
        System.out.println("Account Holder: " + accountHolder); // protected - accessible in subclass
        System.out.println("Balance: $" + getBalance()); // private - accessed via getter
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("------------------------");
    }
}

public class BankAccountManagement {
    public static void main(String[] args) {
        System.out.println("=== Bank Account Management ===\n");

        // Create bank account object
        BankAccount account = new BankAccount("ACC123456", "John Doe", 1000.0);
        account.displayDetails();

        // Access public member directly
        System.out.println("Accessing public member: Account Number = " + account.accountNumber);

        // Access private member via getter
        System.out.println("Accessing private member via getter: Balance = $" + account.getBalance());

        // Perform transactions
        System.out.println("\nPerforming transactions:");
        account.deposit(500.0);
        account.withdraw(200.0);
        account.displayDetails();

        // Create savings account object
        System.out.println("\n=== Savings Account ===");
        SavingsAccount savings = new SavingsAccount("SAV789012", "Jane Smith", 5000.0, 3.5);
        savings.displaySavingsDetails();

        System.out.println("\nAdding interest:");
        savings.addInterest();
        savings.displaySavingsDetails();
    }
}
