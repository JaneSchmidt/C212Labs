import java.util.*;

public class Receipt {
    private static double total;
    private static final ArrayList<Item> receipt = new ArrayList<>();
    private static ArrayList<Integer> quantities = new ArrayList<>();
    // create a new receipt based on the items in the shopping cart

    public static void addToReceipt(Item newItem, double price, int quantity){
        receipt.add(newItem);
        quantities.add(quantity);
        price = price * quantity;
        total = total + price;
    }
    public static void createReceipt(){
        String receiptToPrint = "";
        for(int i = 0; i < receipt.size(); i++){
            receiptToPrint = receiptToPrint + quantities.get(i) + " "  + toString(receipt.get(i)) + "\n";
        }
        System.out.println(receiptToPrint + "\nTotal: " + total);
    }
    
    public static String toString(Item newItem){
        String name = newItem.getItemName();
        double price = newItem.getPrice();
        String toPrint = name + " " + price;
        return(toPrint);
    }

}
