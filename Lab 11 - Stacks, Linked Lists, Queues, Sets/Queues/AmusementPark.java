package Queues;

import java.util.ArrayList;

public class AmusementPark {
    private ArrayList<Ride> rides = new ArrayList<>();

    public void addToPark(Ride newRide){
        rides.add(newRide);
    }

    public void printStats(Ride newRide){
        if(newRide.getNumberInQueue() == 0){
            System.out.println("Name: " + newRide.getName());
            System.out.println("Capacity: " + newRide.getCapacity());
            System.out.println("Number of people in line: 0");
        }
        else {
            while (newRide.getNumberInQueue() > 0) {
                System.out.println("Name: " + newRide.getName());
                System.out.println("Capacity: " + newRide.getCapacity());
                System.out.println("Number of people in line: " + newRide.getNumberInQueue());
                newRide.run();
            }
        }
    }
}
