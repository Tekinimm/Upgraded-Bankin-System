import java.util.Scanner;

public class test {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("John", 100);
        BankAccount account2 = new BankAccount("Rick", 200);

        BankAccount activeAccount = account1; // varsayılan hesap
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n1. Show Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Switch Account");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    activeAccount.showBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    activeAccount.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdraw amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    activeAccount.withdraw(withdrawAmount);
                    break;
                case 4:
                    activeAccount = (activeAccount == account1) ? account2 : account1;
                    System.out.println("Switched to account: " + activeAccount.ownerName);
                    break;
                case 5:
                    isRunning = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

class BankAccount {
    String ownerName;
    double balance;

    BankAccount(String ownerName, double balance) {
        this.ownerName = ownerName;
        this.balance = balance;
    }

    void showBalance() {
        System.out.println(ownerName + "'s balance: $" + balance);
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Amount must be greater than 0.");
        }
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdraw successful. New balance: $" + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}
