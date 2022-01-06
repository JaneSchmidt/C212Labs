import java.util.ArrayList;
import java.util.Arrays;

public class ExceptionExercises {

    public static void main(String[] args) {

        System.out.println("Calling problem 1:");
        System.out.println("Final product: " + Arrays.toString(problem1()));

        System.out.println();
        try {
            System.out.println("Calling problem 2:");
            System.out.println("Final product: " + problem2().toString());
        } catch(NullPointerException e){
            System.out.println("toString produces a null pointer");
        }

    }

    static int[] problem1(){
        int[] intArray = {1,2,3,4,5};
        try {
            for (int i = 0; i <= intArray.length; i++) {          //looping through elements in i
                intArray[i] = intArray[i - 1] + intArray[i];    //intArray[i] becomes the sum of itself and the element before it
            }
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Exception encountered:" + e.getMessage());
        }
        return intArray;
    }


    static ArrayList<Integer> problem2(){
        // I don't know how to fix this
        ArrayList<Integer> myArrayList = null;
            for (int i = 0; i < 10; i++) {
                try {
                    myArrayList.add(i);
                    myArrayList.set(i, i / myArrayList.get(i - 1));
                } catch(NullPointerException e) {
                    System.out.println("Exception encountered:" + e.getMessage());
                } catch(Exception e){
                        System.out.println("Exception encountered: " + e.getMessage());
                } finally {
                    myArrayList = new ArrayList<>();
                }
            }
        return myArrayList;
    }
}
