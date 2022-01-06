import java.util.Scanner;

public class RecursiveOrIterative {
    public static boolean isIntPalindromeIterative(int input){
        int i = 0, count = 0;
        int[] intArray = new int[10];
        while(input > 0) {
            intArray[i] = input % 10;
            input = input / 10;
            i++;
            count++;
        }

        int index = count - 1;
        for(int j = 0; j < count; j++){
            if(index == j){
                return true;
            }
            else if(intArray[j] != intArray[index]){
                return false;
            }
            else if(index < j){
                return true;
            }
            index--;
        }
        /* shouldn't get here */
        return true;
    }

    public static boolean isStrPalindromeIterative(String input){
        int index = input.length() - 1;
        for(int i = 0; i < input.length(); i++){
            if(index == i){
                return true;
            }
            else if(input.charAt(i) != input.charAt(index)){
                return false;
            }
            else if(index < i){
                return true;
            }
            index--;
        }
        /* shouldn't get here */
        return true;
    }

    public static boolean isIntPalindromeRecursive(int input){
        /* I don't know if this is actually recursion because it also has iteration */
        int i = 0, count = 0, newInput = 0;
        int[] intArray = new int[10];
        while(input > 0) {
            intArray[i] = input % 10;
            input = input / 10;
            i++;
            count++;
        }
        if(count == 0 || count == 1){
            return true;
        }

        count = count - 1;
        int temp = count - 1;

        if(intArray[0] == intArray[count]){
            for(int j = 1; j < temp; j++){
                newInput = newInput * 10 + intArray[j] * 10;
            }
            newInput = newInput + intArray[temp];
            return isIntPalindromeRecursive(newInput);
        }

        return false;
    }

    public static boolean isStrPalindromeRecursive(String input){
        if(input.length() == 0 || input.length() == 1){
            return true;
        }
        if(input.charAt(0) == input.charAt(input.length() - 1)){
            return isStrPalindromeRecursive(input.substring(1, input.length() - 1));
        }
        return false;
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
            System.out.println("Is is palindrome (iterative): " + isIntPalindromeIterative(testingInt));
            System.out.println("Is is palindrome (Recursive): " + isIntPalindromeRecursive(testingInt));

            System.out.println("Enter word: ");
            scan.nextLine();
            String testingStr = scan.nextLine();
            if(testingStr.equals("5")){
                System.exit(0);
            }
            System.out.println("Is is palindrome (iterative): " + isStrPalindromeIterative(testingStr));
            System.out.println("Is is palindrome (Recursive): " + isStrPalindromeRecursive(testingStr));
        }
    }
}
