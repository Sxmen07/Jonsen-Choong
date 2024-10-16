
import java.util.Scanner;

public class Pizzon {

    // Declare private variables for the pizza's name, number of slices, and price
    private String name;
    private int slice;
    private double price;

    //Overloaded constructor that initializes the pizza's name, number of slices, and price
    public Pizzon(String n, int s, double p) {
        name = n;
        slice = s;
        price = p;
    }

    // Method to display the hunger level menu to the customer
    public static void hungerMenu() {
        System.out.printf("%40s\n", "Welcome to Jonsen's Pizza Calculator");
        System.out.println("--------------------------------------------------------");
        System.out.println("How hungry are you today??");
        System.out.println("1. Light – 1 slice per person");
        System.out.println("2. Medium – 2 slices per person");
        System.out.println("3. Ravenous – 4 slices per person\n");
    }

    // Method that allows the customer to enter the number of people in each hunger category
    public static int personHunger() {
        int light, medium, ravenous;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of people in Light hunger: ");
        light = checkInt(sc);
        System.out.print("Enter number of people in Medium hunger: ");
        medium = checkInt(sc);
        System.out.print("Enter number of people in Ravenous hunger: ");
        ravenous = checkInt(sc);

        // Returns the total number of slices required based on the input
        return light * 1 + medium * 2 + ravenous * 4;
    }

    // Method to display the pizza menu, taking eight pizza objects as parameters
    public static void menu(Pizzon p1, Pizzon p2, Pizzon p3, Pizzon p4, Pizzon p5, Pizzon p6, Pizzon p7, Pizzon p8) {
        System.out.println("--------------------------------------------------------");
        System.out.printf("%30s\n", "Pizza Menu");
        System.out.println("--------------------------------------------------------");
        System.out.printf("%-5s %-20s %-10s %-10s\n", "No.", "Name", "Slices", "Price ($)");
        // Print details for each pizza
        System.out.printf("1. %-25s %-10d %.2f\n", p1.name, p1.slice, p1.price);
        System.out.printf("2. %-25s %-10d %.2f\n", p2.name, p2.slice, p2.price);
        System.out.printf("3. %-25s %-10d %.2f\n", p3.name, p3.slice, p3.price);
        System.out.printf("4. %-25s %-10d %.2f\n", p4.name, p4.slice, p4.price);
        System.out.printf("5. %-25s %-10d %.2f\n", p5.name, p5.slice, p5.price);
        System.out.printf("6. %-25s %-10d %.2f\n", p6.name, p6.slice, p6.price);
        System.out.printf("7. %-25s %-10d %.2f\n", p7.name, p7.slice, p7.price);
        System.out.printf("8. %-25s %-10d %.2f\n", p8.name, p8.slice, p8.price);
        System.out.println("--------------------------------------------------------");
        System.out.println("***Each pizza is served in the number of slices shown. Please select based on your desired number of slices.***\n");
    }

    // Method that allows the customer to order pizzas based on the required number of slices
    public static double orderPizza(Pizzon p1, Pizzon p2, Pizzon p3, Pizzon p4, Pizzon p5, Pizzon p6, Pizzon p7, Pizzon p8, int requiredSlices) {
        int num = 0, totalSlicesOrdered = 0, pizzasOrderedInCurrentSelection = 0;
        double totalCost = 0;
        Scanner sc = new Scanner(System.in);

        // Loop until the total number of slices ordered meets or exceeds the required number
        while (totalSlicesOrdered < requiredSlices) {
            System.out.print("Enter menu number to select your pizza (1-8): ");
            num = checkInt(sc);

            // Process the selection based on the pizza menu
            switch (num) {
                case 1 -> {
                    System.out.print("How many Margherita Pizzas would you like to order? ");
                    pizzasOrderedInCurrentSelection = checkInt(sc);
                    totalSlicesOrdered += p1.slice * pizzasOrderedInCurrentSelection;
                    totalCost += p1.price * pizzasOrderedInCurrentSelection;
                }
                case 2 -> {
                    System.out.print("How many Capricciosa Pizzas would you like to order? ");
                    pizzasOrderedInCurrentSelection = checkInt(sc);
                    totalSlicesOrdered += p2.slice * pizzasOrderedInCurrentSelection;
                    totalCost += p2.price * pizzasOrderedInCurrentSelection;
                }
                case 3 -> {
                    System.out.print("How many Calzone Pizzas would you like to order? ");
                    pizzasOrderedInCurrentSelection = checkInt(sc);
                    totalSlicesOrdered += p3.slice * pizzasOrderedInCurrentSelection;
                    totalCost += p3.price * pizzasOrderedInCurrentSelection;
                }
                case 4 -> {
                    System.out.print("How many Alletterata Pizzas would you like to order? ");
                    pizzasOrderedInCurrentSelection = checkInt(sc);
                    totalSlicesOrdered += p4.slice * pizzasOrderedInCurrentSelection;
                    totalCost += p4.price * pizzasOrderedInCurrentSelection;
                }
                case 5 -> {
                    System.out.print("How many Vulcanica Pizzas would you like to order? ");
                    pizzasOrderedInCurrentSelection = checkInt(sc);
                    totalSlicesOrdered += p5.slice * pizzasOrderedInCurrentSelection;
                    totalCost += p5.price * pizzasOrderedInCurrentSelection;
                }
                case 6 -> {
                    System.out.print("How many Viandante Pizzas would you like to order? ");
                    pizzasOrderedInCurrentSelection = checkInt(sc);
                    totalSlicesOrdered += p6.slice * pizzasOrderedInCurrentSelection;
                    totalCost += p6.price * pizzasOrderedInCurrentSelection;
                }
                case 7 -> {
                    System.out.print("How many Memento Pizzas would you like to order? ");
                    pizzasOrderedInCurrentSelection = checkInt(sc);
                    totalSlicesOrdered += p7.slice * pizzasOrderedInCurrentSelection;
                    totalCost += p7.price * pizzasOrderedInCurrentSelection;
                }
                case 8 -> {
                    System.out.print("How many Sciuccaglia Pizzas would you like to order? ");
                    pizzasOrderedInCurrentSelection = checkInt(sc);
                    totalSlicesOrdered += p8.slice * pizzasOrderedInCurrentSelection;
                    totalCost += p8.price * pizzasOrderedInCurrentSelection;
                }
                default -> {
                    System.out.println("Invalid menu number! Please select a valid pizza (1-8).");
                    continue;
                }
            }

            // If the total slices ordered is less than required, prompt message to require customer to order more
            if (totalSlicesOrdered < requiredSlices) {
                System.out.printf("You still need %d more slice(s).\n", requiredSlices - totalSlicesOrdered);
            }
        }

        // Display the total number of slices ordered and the total cost of the order
        System.out.printf("\nThe total slices of pizza you ordered: %d\n", totalSlicesOrdered);
        System.out.printf("Total cost for your order: RM%.2f\n", totalCost);

        // Returns the total cost of the pizzas ordered
        return totalCost;
    }

    // Method to validate that the customer input is a valid integer
    public static int checkInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            sc.next();
            System.out.print("Please enter a valid integer: ");
        }
        int result = sc.nextInt();
        sc.nextLine();  // Consume the newline character
        return result;
    }

    public static void main(String args[]) {
        int requiredSlices = 0;
        char exitCustomer;
        Scanner sc = new Scanner(System.in);

        // Create new objects for 8 different types of pizza
        Pizzon p1 = new Pizzon("Margherita Pizza", 8, 12.9);
        Pizzon p2 = new Pizzon("Capricciosa Pizza", 4, 14.5);
        Pizzon p3 = new Pizzon("Calzone Pizza", 4, 11.0);
        Pizzon p4 = new Pizzon("Alletterata Pizza", 6, 16.0);
        Pizzon p5 = new Pizzon("Vulcanica Pizza", 10, 13.5);
        Pizzon p6 = new Pizzon("Viandante Pizza", 8, 15.0);
        Pizzon p7 = new Pizzon("Memento Pizza", 8, 10.0);
        Pizzon p8 = new Pizzon("Sciuccaglia Pizza", 10, 17.0);

        // Repeat the process until the customer chooses not to continue
        do {
            hungerMenu();
            requiredSlices = personHunger();
            System.out.printf("\nBased on your hunger levels, you need %d slices of pizza.\n", requiredSlices);
            System.out.println("Please choose from the menu below.");
            menu(p1, p2, p3, p4, p5, p6, p7, p8);
            orderPizza(p1, p2, p3, p4, p5, p6, p7, p8, requiredSlices);

            System.out.print("Do you wish to continue (Y/N): ");
            exitCustomer = sc.next().toUpperCase().charAt(0);  // Convert to uppercase directly during input
            System.out.println("");
        } while (exitCustomer == 'Y');  // Loop continues if the customer inputs 'Y'
    }
}
