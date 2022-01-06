package Queues;

import java.util.*;

public class Ride {
    private int capacity;
    private String name;
    private PriorityQueue<Customer> names = new PriorityQueue<>();
    private Queue<Customer> noPassNames = new LinkedList<>();
    private Boolean hasFastPass;

    public Ride() {
        capacity = 0;
        name = "";
        hasFastPass = true;
    }

    public void run(){
        HashMap<Customer, String> toPrint = new HashMap<>();
        /*.poll()  removes top object
        /* removes people from the queue until ride capacity
        /* print the order people were removed and fast pass status */
        if (getHasFastPass()) {
            for (int i = 0; i < capacity; i++) {
                if(names.poll() != null) {
                    Customer temp = names.poll();
                    if(temp.getFastPassStatus() == 1){
                        toPrint.put(temp, "FastPass Holder");
                    }
                    else {
                        toPrint.put(temp, "N/A");
                    }
                }
            }
        } else {
            for (int i = 0; i < capacity; i++) {
                if(noPassNames.poll() != null) {
                    Customer temp = noPassNames.poll();
                    if(temp.getFastPassStatus() == 1){
                        toPrint.put(temp, "FastPass Holder");
                    }
                    else {
                        toPrint.put(temp, "N/A");
                    }
                }
            }
        }
        System.out.println("Order Removed" + toPrint);
    }

    public void addToQueue(ArrayList<Customer> listOfCustomers){
        /* add a list of customers to the queue */
        if(getHasFastPass()){
            names.addAll(listOfCustomers);
        }
        else{
            noPassNames.addAll(listOfCustomers);
        }
    }

    public void setCapacity(int cap){capacity = cap;}
    public void setName(String rideName){name = rideName;}
    public void setHasFastPass(Boolean yesOrNo){hasFastPass = yesOrNo;}
    public int getCapacity(){return capacity;}
    public String getName(){return name;}
    public int getNumberInQueue(){
        if(getHasFastPass()){
            return names.size();
        }
        else{
            return noPassNames.size();
        }
    }
    public Boolean getHasFastPass(){return hasFastPass;}
}
