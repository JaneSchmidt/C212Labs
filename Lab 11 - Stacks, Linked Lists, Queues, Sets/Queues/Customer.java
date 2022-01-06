package Queues;

public class Customer implements Comparable<Customer>{
    private String name;
    private int fastPassStatus;

    public Customer() {
        String name = "Customer";
        int fastPassStatus = 0;
    }

    public void setName(String input) {name = input;}
    public void setFastPassStatus(int input) {fastPassStatus = input;}
    public String getName() {return name;}
    public int getFastPassStatus() {return fastPassStatus;}


    @Override
    public int compareTo(Customer customer) {
        if(customer.fastPassStatus == 0){
            return 0;
        }
        else {
            return 1;
        }
    }
}