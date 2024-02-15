import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nWelcome to the Rabbit Express!");
        // Create a list to store all the packages
        List<BasePackage> packages = new ArrayList<>();
        // Open a scanner to read user input
        Scanner scanner = new Scanner(System.in);
        double totalCost = 0;

        // Menu Loop
        while (true) {
            System.out.println("\nPackage Types Available:");
            System.out.println("1. First Class Package");
            System.out.println("2. Priority Package");
            System.out.println("3. Two Day Package");
            System.out.println("4. Overnight Package");
            System.out.println("5. Exit");
            System.out.print("\nEnter your action: ");
            int choice = scanner.nextInt();

            if (choice == 5) {
                break;
            }

            System.out.print("\nEnter the sender's name: ");
            String sender = scanner.next();
            System.out.print("Enter the recipient's name: ");
            String recipient = scanner.next();
            System.out.print("Enter the weight of the package (lbs): ");
            double weight = scanner.nextDouble();

            BasePackage pkg = null;
            String rabbitExpress = "No";
            
            // Creating the package based on the user's choice
            switch (choice) {
                case 1:
                    pkg = new FirstClassPackage(sender, recipient, weight);
                    break;
                case 2:
                    pkg = new PriorityPackage(sender, recipient, weight);
                    break;
                case 3:
                    pkg = new TwoDayPackage(sender, recipient, weight);
                    break;
                case 4:
                    // Prompting the user if they want to use Rabbit Express
                    System.out.print("Would you like to use Rabbit Express? (Yes/No) ");
                    rabbitExpress = scanner.next();
                    pkg = new OvernightPackage(sender, recipient, weight);
                    break;
            }

            // If the package was created, add it to the list and calculate the cost
            if (pkg != null) {
                double cost;
                // If the package is an OvernightPackage and the user wants to use Rabbit Express, calculate the cost using Rabbit Express
                if (pkg instanceof OvernightPackage && rabbitExpress.equalsIgnoreCase("Yes")) {
                    cost = ((OvernightPackage) pkg).rabbitExpress();
                // Otherwise, calculate the cost normally
                } else {
                    cost = pkg.calculateCost();
                }
                // Adding the package to the list and updating the total cost
                packages.add(pkg);
                System.out.println("\nPackage added. Cost: $" + cost);
                totalCost += cost;
            }
        }

        // Printing all the packages and the total cost
        System.out.println("\nAll packages:");
        for (int i = 0; i < packages.size(); i++) {
            BasePackage pkg = packages.get(i);
            if (pkg instanceof FirstClassPackage) {
                System.out.println("First Class Package");
            } else if (pkg instanceof PriorityPackage) {
                System.out.println("Priority Package");
            } else if (pkg instanceof TwoDayPackage) {
                System.out.println("Two Day Package");
            } else if (pkg instanceof OvernightPackage) {
                System.out.println("Overnight Package");
            }
            System.out.println("Sender: " + pkg.getSenderName());
            System.out.println("Recipient: " + pkg.getRecipientName());
        }
        System.out.println("\nTotal cost of all packages: $" + totalCost);

        // Closing the scanner
        scanner.close();
    }
}
