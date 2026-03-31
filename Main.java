import java.util.*;

class Expense {
    String category;
    double amount;

    Expense(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    void display() {
        System.out.println("Category: " + category + " | Amount: Rs." + amount);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Expense> expenses = new ArrayList<>();

        while (true) {
            System.out.println("\n===== Expense Tracker =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Total Expense");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                sc.next();
                continue;
            }

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();

                    System.out.print("Enter category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();

                    if (amount <= 0) {
                        System.out.println("Amount must be positive!");
                        break;
                    }

                    expenses.add(new Expense(category, amount));
                    System.out.println("Expense added successfully!");
                    break;

                case 2:
                    if (expenses.isEmpty()) {
                        System.out.println("No expenses recorded.");
                    } else {
                        System.out.println("\n--- Expense List ---");
                        for (Expense e : expenses) {
                            e.display();
                        }
                    }
                    break;

                case 3:
                    double total = 0;
                    for (Expense e : expenses) {
                        total += e.amount;
                    }
                    System.out.println("Total Expense: Rs." + total);
                    break;

                case 4:
                    System.out.println("Exiting... Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}