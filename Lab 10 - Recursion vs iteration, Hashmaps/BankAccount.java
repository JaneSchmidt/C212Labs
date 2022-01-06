import java.io.*;
import java.util.*;

public class BankAccount {
    private ArrayList<String> clientsInformation = new ArrayList<>();
    private HashMap<String, Integer> balances = new HashMap<>();

    public BankAccount(String filename) throws IOException{
        File transactionsFile = new File(filename);
        boolean exists = transactionsFile.exists();
        if(!exists) throw new IllegalArgumentException("File does not exist");
        BufferedReader reader = new BufferedReader(new FileReader(transactionsFile));
        String line = reader.readLine();
        while(line != null){
            clientsInformation.add(line);
            line = reader.readLine();
        }
    }

    public HashMap<String, Integer> currentBalances(){
        /* this is supposed to take the array list as an input, does that mean
        /* it needs to be an argument of the method? */
        ArrayList<String> noRepeats = new ArrayList<>();
        ArrayList<String> types = new ArrayList<>();
        ArrayList<Integer> listOfBalances = new ArrayList<>();
        String name, type;
        int quantity;

        /* this loop is creating parallel arraylists for the info from
        /* the file    */
        for (String tempClient : clientsInformation) {
            String[] tempArray = tempClient.split(",");
            name = tempArray[0];
            quantity = Integer.parseInt(tempArray[1]);
            type = tempArray[2];

            noRepeats.add(name);
            listOfBalances.add(quantity);
            types.add(type);
        }

        /* this loop checks for repeats of names then computes the appropriate
        /* computation and deletes the other instances of that name       */
        for(int i = 0; i < noRepeats.size(); i++){
            name = noRepeats.get(i);
            int count = 0;
            int currentBalance = listOfBalances.get(i);;
            for(int j = 0; j < noRepeats.size(); j++){
                if(name.equals(noRepeats.get(j))){
                    int depositAmount, withdrawalAmount;
                    count++;
                    if(count > 1){
                        type = types.get(j);
                        if(type.equals("d")){
                            depositAmount = listOfBalances.get(j);
                            currentBalance = currentBalance + depositAmount;
                            listOfBalances.set(i, currentBalance);

                        } else if(type.equals("w")){
                            withdrawalAmount = listOfBalances.get(j);
                            currentBalance = currentBalance - withdrawalAmount;
                            listOfBalances.set(i, currentBalance);

                        } else{ System.out.println("shouldn't get here"); }

                        noRepeats.remove(j);
                        listOfBalances.remove(j);
                        types.remove(j);
                    }
                }
            }
        }
            /* this adds the information to the hashmap after being processed */
            for(int k = 0; k < noRepeats.size(); k++) {
                name = noRepeats.get(k);
                quantity = listOfBalances.get(k);
                balances.put(name, quantity);
            }
        return balances;
    }

    public HashMap<String, Integer> updateBalances(){
        for(Map.Entry mapElement : balances.entrySet()){
            String key = (String)mapElement.getKey();
            int value = ((int)mapElement.getValue());
            if(value > 1500){
                value = value + 100;
                balances.replace(key, value);
            }
        }
        return balances;
    }

    public static void main(String[] args) throws IOException {
        BankAccount newBank = new BankAccount("Resources/transactions.txt");
        HashMap<String, Integer> clientBalances = newBank.currentBalances();
        for(Map.Entry mapElement : clientBalances.entrySet()){
            String key = (String)mapElement.getKey();
            int value = ((int)mapElement.getValue());
            System.out.println("Client: " + key + "     Balance: " + value);
        }
        clientBalances = newBank.updateBalances();
        System.out.println("Updated balances: ");
        for(Map.Entry mapElement : clientBalances.entrySet()){
            String key = (String)mapElement.getKey();
            int value = ((int)mapElement.getValue());
            System.out.println("Client: " + key + "     Balance: " + value);
        }
    }
}
