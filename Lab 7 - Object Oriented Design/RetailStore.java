import java.util.ArrayList;
import java.util.HashMap;

public class RetailStore {
    private static int numberOfCustomers;
    private static final ArrayList<String> listOfCustomers = new ArrayList<>();
    private static String storeName;
    public static HashMap<String, Integer> storeItems  = new HashMap<>();


    public RetailStore() {
        storeName = "";
        numberOfCustomers = 0;
    }

    public void setStoreName(String storeN){storeName = storeN;}
    public String getStoreName(){return storeName;}

    public static void addCustomer(String customerName) {
        numberOfCustomers++;
        listOfCustomers.add(customerName);
    }

    public static void removeCustomer(String customerName) {
        numberOfCustomers--;
        listOfCustomers.remove(customerName);
    }

    public static int getNumberOfCustomers() {
        return numberOfCustomers;
    }
    public void setNumberOfCustomers(int numOC){numberOfCustomers = numOC;}

    public static void itemInventory(String item, int quantity) {
        storeItems.put(item, quantity);
    }
}
