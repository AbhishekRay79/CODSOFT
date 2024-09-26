import java.util.Scanner;
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public void deposit(double amount) {
        balance += amount;
    }
}
public class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    withdraw(sc);
                    break;
                case 2:
                    deposit(sc);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
           
        }
        
    }

    private void withdraw(Scanner sc) {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private void deposit(Scanner sc) {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        account.deposit(amount);
        System.out.println("Deposit successful.");
    }

    private void checkBalance() {
        System.out.println("Your balance is: " + account.getBalance());
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0); 
        ATM atm = new ATM(account);
        atm.start();
    }
}

