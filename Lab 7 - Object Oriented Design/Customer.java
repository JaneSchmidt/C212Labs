import java.util.*;

public class Customer{
    private static final HashMap<String, Integer> shoppingCart = new HashMap<>();
    private static String customerName;
    private static double budget;
    private static boolean maskStatus;

    public static void displayCustomerMenu(){
        String customerMenu = "Customer Menu:\n1. Add to cart\n2. Display current shopping cart\n3. Check out/leave store\n4. Exit the menu\n";
        System.out.println(customerMenu);
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        if (choice == 1) {
            System.out.println("Name of item to add to cart: ");
            scan.nextLine();
            String itemName = scan.nextLine();
            System.out.println("Price of item to add to cart: ");
            double itemCost = scan.nextDouble();
            System.out.println("Quantity of item to add to cart: ");
            int quantity = scan.nextInt();
            addToCart(itemName, itemCost, quantity);
        } else if (choice == 2) {
            displayCart();
        } else if (choice == 3) {
            checkOut(customerName);
        } else if (choice == 4) {
            exitMenu();
        } else {
            System.out.println("Incorrect Input");
        }
    }

    public static void addToCart(String name, double price, int quantity){
        // store all the items in their cart and store the quantity of each item
        // customer menu: add to cart: update the quantities and shopping cart
        double totalCost = price*quantity;
        if((budget - totalCost) < 0){
            System.out.print("I'm sorry this items is out of your store budget");
            displayCustomerMenu();
        }
        else {
            Item newItem = new Item();
            newItem.setItemName(name);
            newItem.setPrice(price);
            shoppingCart.put(name, quantity);
            Receipt.addToReceipt(newItem, price, quantity);
            budget = budget - totalCost;
            displayCustomerMenu();
        }
    }

    public static void displayCart(){
        System.out.println(shoppingCart);
        displayCustomerMenu();
    }

    public static void checkOut(String customerName){
        //update store customer list
        Receipt.createReceipt();
        RetailStore.removeCustomer(customerName);
        displayCustomerMenu();
    }

    public static void exitMenu(){
        RetailDriver.displayMainMenu();
    }

    public void setCustomerName(String customerN){customerName = customerN;}
    public String getCustomerName(){return customerName;}
    public void setBudget(double money){budget = money;}
    public double getBudget(){return budget;}
    public void setMaskStatus(boolean maskStat){maskStatus = maskStat;}
    public boolean getMaskStatus(){return maskStatus;}
}
