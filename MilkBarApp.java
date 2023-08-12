import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class represents a simple Milk Bar application.
 * It allows users to order items from the menu and calculates the total cost of the order.
 */
public class MilkBarApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Item> menu = new ArrayList<>();
        menu.add(new Item("Milkshake", 3.5));
        menu.add(new Item("Ice Cream Sundae", 4.0));
        menu.add(new Item("Smoothie", 3.0));
        menu.add(new Item("Specialty Drink", 2.5));

        System.out.println("Welcome to the Milk Bar!");
        System.out.println("Menu:");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i).getName() + " - $" + menu.get(i).getPrice());
        }

        Order order = new Order();

        while (true) {
            System.out.println("Enter the item number to add to your order (0 to finish):");
            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            }

            if (choice > 0 && choice <= menu.size()) {
                order.addItem(menu.get(choice - 1));
                System.out.println(menu.get(choice - 1).getName() + " added to your order.");
            } else {
                System.out.println("Invalid choice. Please enter a valid item number.");
            }
        }

        System.out.println("Your order:");
        for (Item item : order.getItems()) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }

        System.out.println("Total: $" + order.getTotal());
        System.out.println("Thank you for visiting the Milk Bar!");
    }
}

class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private List<Item> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }
}
