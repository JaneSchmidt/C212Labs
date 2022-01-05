import java.util.*;

// only needs to store the name and price of an item
public class Item {
    private String itemName;
    private double price;

    public Item(){
        itemName = "";
        price = 0.0;
    }

    public static HashMap<String, Double> items  = new HashMap<>();

    public static void addItem(String itemName, double price){items.put(itemName, price);}

    public void setItemName(String itemN){ itemName = itemN;}
    public void setPrice(double cost){price = cost;}
    public String getItemName(){return itemName;}
    public double getPrice(){return price;}

}
