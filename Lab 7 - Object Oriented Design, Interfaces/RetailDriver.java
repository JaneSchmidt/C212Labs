import java.sql.Array;
import java.util.*;
import java.lang.*;

public class RetailDriver {
    private static final ArrayList<String> customerNames = new ArrayList<>();
    private static final ArrayList<String> storeNames = new ArrayList<>();
    private static final ArrayList<RetailStore> listOfStores = new ArrayList<>();
    private static final ArrayList<Customer> customers = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    // retail driver will have main menu, list of all stores, list of all customers


    public static void displayMainMenu(){
        String mainMenu = "Main Menu:\n1. Create a new store\n2. Create a new customer\n3. Enter the customer menu\n4. Add new item to store\n5. End program";
        System.out.println(mainMenu);
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        if (choice == 1) {
            System.out.print("Name of store: ");
            scan.nextLine();
            String storeName = scan.nextLine();
            createNewStore(storeName);
        } else if (choice == 2) {
            System.out.print("Name of customer: ");
            scan.nextLine();
            String customerName = scan.nextLine();
            customerNames.add(customerName);
            System.out.println("Enter customer budget: ");
            double budget = scan.nextDouble();
            System.out.println("Is customer wearing a mask (yes or no): ");
            scan.nextLine();
            String yesOrNo;
            yesOrNo = scan.nextLine();
            boolean maskStatus = yesOrNo.equals("yes");
            createNewCustomer(customerName, budget, maskStatus);
        } else if (choice == 3) {
            enterCustomerMenu();
        } else if (choice == 4) {
            System.out.println("Enter store name: ");
            scan.nextLine();
            String store = scan.nextLine();
            System.out.println("Enter item name: ");
            String item = scan.nextLine();
            System.out.println("Enter price: ");
            double price = scan.nextDouble();
            System.out.println("Enter quantity: ");
            int quantity = scan.nextInt();
            addItem(item, quantity, price, store);
        } else {
            System.exit(0);
        }
    }

    public static void createNewStore(String storeName){
        RetailStore newStore = new RetailStore();
        newStore.setStoreName(storeName);
        newStore.setNumberOfCustomers(0);
        listOfStores.add(newStore);
        storeNames.add(storeName);
        displayMainMenu();
    }

    public static void createNewCustomer(String customerName, double budget, boolean maskStatus){
        int x = 0;
        Customer newCustomer = new Customer();
        newCustomer.setCustomerName(customerName);
        newCustomer.setBudget(budget);
        newCustomer.setMaskStatus(maskStatus);
        customers.add(newCustomer);

        System.out.print("Enter store name: ");
        Scanner scan = new Scanner(System.in);
        String storeName = scan.nextLine();

        if(!maskStatus){
            System.out.println("Customer needs a mask before entering a store");
        }
        else {
            for (String name : storeNames) {
                if (storeName.equals(name)) {
                    x = 1;
                    RetailStore currentStore = findStore(listOfStores, storeName);
                    int numOfC = currentStore.getNumberOfCustomers();
                    if (numOfC >= 5) {
                        System.out.println("There are currently five customers already in the store");
                    } else {
                        currentStore.addCustomer(customerName);
                    }
                }
            }
            if (x == 0) {
                RetailStore newStore = new RetailStore();
                newStore.setStoreName(storeName);
                newStore.setNumberOfCustomers(0);
                listOfStores.add(newStore);
                storeNames.add(storeName);
                newStore.addCustomer(customerName);
            }
        }
        displayMainMenu();
    }

    public static void enterCustomerMenu(){
        System.out.println("Enter customer name: ");
        String customerName = scan.nextLine();
        if(!customerNames.contains(customerName)){
            customerNames.add(customerName);
            Customer newCustomer = new Customer();
            newCustomer.setCustomerName(customerName);
            System.out.println("Enter customer budget: ");
            newCustomer.setBudget(scan.nextDouble());
            customers.add(newCustomer);
        }
        else{
            for (String name : customerNames) {
                if (customerName.equals(name)) {
                    Customer currentCustomer = findCustomer(customers, customerName);
                }
            }
        }
        Customer newCustomer = new Customer();
        newCustomer.setCustomerName(customerName);
        System.out.println("Enter store name: ");
        scan.nextLine();
        String storeName = scan.nextLine();
        if(!storeNames.contains(storeName)){
            for (String name : storeNames) {
                if (storeName.equals(name)) {
                    RetailStore currentStore = findStore(listOfStores, storeName);
                }
            }
        }
        System.out.print("Enter customer budget");
        Customer.displayCustomerMenu();
    }

    public static void addItem(String itemName, int quantity, double price, String storeName){
        Item newItem = new Item();
        newItem.setItemName(itemName);
        newItem.setPrice(price);
        for (String name : storeNames) {
            if (storeName.equals(name)) {
                RetailStore currentStore = findStore(listOfStores, storeName);
                currentStore.itemInventory(itemName, quantity);
            } else {
                System.out.print("There are no stores under that name.");
            }
        }
        Item.addItem(itemName, price);
        displayMainMenu();
    }

    public static RetailStore findStore(Collection<RetailStore> listRetailStores, String storeName){
        return listRetailStores.stream().filter(store -> storeName.equals(store.getStoreName())).findAny().orElse(null);
    }

    public static Customer findCustomer(Collection<Customer> listOfCustomers, String customerName){
        return listOfCustomers.stream().filter(store -> customerName.equals(store.getCustomerName())).findAny().orElse(null);
    }

    public static void main(String[] args){
        displayMainMenu();
    }

}