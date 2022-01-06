package Stack;
import java.util.*;

public class IsPalindrome {
    /* takes an int and copies each individual int into
    /* a Stack, then copies that stack into a new one but reverse
    /* then compares them int by int */
    public static boolean isIntPalindrome(int input){
        int i, count = 0;
        Stack<Integer> originalInt = new Stack<>();
        Stack<Integer> reverseInt = new Stack<>();
        while(input > 0) {
            i = input % 10;
            originalInt.add(i);
            input = input / 10;
            count++;
        }
        if(originalInt.isEmpty()){
            System.out.println("Empty stack");
        }

        count = count - 1;
        for(int k = count; k > -1; k--) {
            int temp = originalInt.get(k);
            reverseInt.add(temp);
        }
        if(reverseInt.isEmpty()){
            System.out.println("Empty Stack 2");
        }

        for(int j = 0; j < count; j ++){
            if(!Objects.equals(originalInt.get(j), reverseInt.get(j))){
                return false;
            }
        }
        return true;
    }

    /* takes a word and copies each individual character into
    /* a Stack and in the same loop copies it reverse into another stack
    /* then compares the two character by characterm */
    public static boolean isStrPalindrome(String input){
        Stack<Character> originalStr = new Stack<>();
        Stack<Character> reverseStr = new Stack<>();

        int index = input.length() - 1;
        for(int i = 0; i < input.length(); i++){
            originalStr.add(input.charAt(i));
            reverseStr.add(input.charAt(index));
            index--;
        }

        if(originalStr.isEmpty()){
            System.out.println("Empty stack");
        }
        if(reverseStr.isEmpty()){
            System.out.println("Empty Stack 2");
        }

        index = input.length() - 1;
        for(int j = 0; j < index; j ++){
            if(!Objects.equals(originalStr.get(j), reverseStr.get(j))){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        while(true) {
            System.out.println("Enter '5' to exit\n");
            System.out.println("Enter integer: ");
            Scanner scan = new Scanner(System.in);
            int testingInt = scan.nextInt();
            if(testingInt == 5){
                System.exit(0);
            }
            System.out.println("Is Int palindrome: " + isIntPalindrome(testingInt));

            System.out.println("Enter word: ");
            scan.nextLine();
            String testingStr = scan.nextLine();
            if(testingStr.equals("5")){
                System.exit(0);
            }
            System.out.println("Is Str palindrome: " + isStrPalindrome(testingStr));
        }
    }
}
