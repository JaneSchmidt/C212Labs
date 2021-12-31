import java.util.*;

public class MyArrayList {
    private int size;
    private int[] data;

    public MyArrayList(){
        size = 0;
        data = new int[16];
    }

    public void add (int n) {
        System.out.println(n);

        if(data.length == size){
            data = Arrays.copyOf(data, size + 1);
            data[size-1] = n;
        }
        else{
            data[size-1] = n;
        }
        size++;
    }

    public void remove(int index){

        for(int i = index + 1; i < size; i++){
            int temp = data[i];
            data[i - 1] = temp;
        }
        size--;
    }

    public String tooString(){
        String stringForm = "";
        char last = (char)data[size - 1];
        for (int index = 0; index < size - 1; index++) {
            String temp = String.valueOf(index);
            stringForm = stringForm + temp + ", ";
        }
        stringForm = "[" + stringForm + last + "]";
        return(stringForm);
    }

    public int getSize(){
        return(size);
    }

    public boolean isEmpty(){
        boolean yesno = data.length == 0;
        return(yesno);
    }

    public boolean contains(int n){
        boolean yesno = false;
        for(int index : data){
            if(data[index] == n){
                yesno = true;
                break;
            }
        }
        return(yesno);
    }

    public int indexOf(int n){
        int index = -1;
        for(int i = 0; i < data.length; i++){
            if(data[i] == n){
                index = i;
                break;
            }
        }
        return(index);
    }

    public static void main(String [] args){
        MyArrayList array1 = new MyArrayList();
        array1.size = 10;
        array1.data = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        array1.add(11);
        String random = array1.tooString();
        System.out.println("String: " + random);
        System.out.println("size: " + array1.getSize());
        System.out.println("is empty: " + array1.isEmpty());
        System.out.println("contains: " + array1.contains(2));
        System.out.println("index of: " + array1.indexOf(4));

    }
}
