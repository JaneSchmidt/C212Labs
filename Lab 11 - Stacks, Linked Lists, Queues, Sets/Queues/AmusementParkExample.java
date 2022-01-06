package Queues;

import java.util.ArrayList;

public class AmusementParkExample {
    public static void main(String[] args){
        Ride cyclone = new Ride();
        cyclone.setName("The Cyclone");
        cyclone.setCapacity(8);
        cyclone.setHasFastPass(true);

        ArrayList<Customer> cycloneRiders = new ArrayList<>();
        int count = 1;
        for(int i = 0; i < 20; i ++){
            Customer newRider = new Customer();
            newRider.setName(Integer.toString(i));
            if(count % 5 == 0) { newRider.setFastPassStatus(3);}
            else{ newRider.setFastPassStatus(0); }
            count++;
            cycloneRiders.add(newRider);
        }
        cyclone.addToQueue(cycloneRiders);

        Ride dropTower = new Ride();
        dropTower.setName("The Drop Tower");
        dropTower.setCapacity(4);
        dropTower.setHasFastPass(false);

        ArrayList<Customer> dropTowerRiders = new ArrayList<>();
        count = 1;
        for(int i = 0; i < 20; i ++){
            Customer newRider = new Customer();
            newRider.setName(Integer.toString(i));
            if(count % 5 == 0) { newRider.setFastPassStatus(1); }
            else{ newRider.setFastPassStatus(0); }
            count++;
            dropTowerRiders.add(newRider);
        }
        dropTower.addToQueue(dropTowerRiders);

        AmusementPark JaneLand = new AmusementPark();
        JaneLand.addToPark(cyclone);
        JaneLand.printStats(cyclone);
        JaneLand.addToPark(dropTower);
        JaneLand.printStats(dropTower);
    }
}
