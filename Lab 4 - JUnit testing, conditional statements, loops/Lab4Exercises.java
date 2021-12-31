import java.util.*;

public class Lab4Exercises {
    // generate a rand num between 0 and 9 then add 1
    // asks for guess, tell higher or lower, print amount guesses
    public static int SecretNumber(int usrguess){
        int guess_count = 1, randint;

        Random random = new Random();
        randint = random.nextInt(9);
        randint++;

        while(usrguess != randint){
            if(usrguess < randint){
                System.out.print("Wrong! The number is higher.\n Enter a new guess: ");
                Scanner user = new Scanner(System.in);
                usrguess = user.nextInt();
                guess_count++;
            }
            if(usrguess > randint) {
                System.out.print("Wrong! The number is lower.\n Enter a new guess: ");
                Scanner user = new Scanner(System.in);
                usrguess = user.nextInt();
                guess_count++;
            }
        }
        System.out.print("Good job! You guessed " + guess_count + " times.\n");
        return(guess_count);
    }

    // takes two ints and returns the base to the power of exponent
    // no math.pow, no negative numbers can be used
    // account for if either number is zero
    public static int exponentCalculator(int base, int exponent){
        int usebase, exp2;
        usebase = base;
        exp2 = exponent;
        exponent--;

        if(base <= 0) throw new IllegalArgumentException("Incorrect input");
        if(exp2 < 0) throw new IllegalArgumentException("Incorrect input");

        if(exp2 == 0){
            base = 1;
        }
        else {
            for (int k = 0; k < exponent; k++) {
                base = base * usebase;
            }
        }
        System.out.print(usebase + " to the " + exp2 + " power is: " + base + "\n");
        return(base);
    }

    public static void DesigningPatterns(char menuOption){
        Random random = new Random();
        int randint = random.nextInt(7) + 3;
        int yesorno = 0;
        String patA = "*", patB = "5", patC = " ", patD = "* ";

        //when it loops it prints the last two you chose 
        while(yesorno == 0) {
            randint = random.nextInt(7) + 3;
            String pattern = new String();
            if (menuOption == 'A') {
                int spacesForA = randint + 1, start = 2;
                for (int l = 0; l <= randint; l++) {
                    //this keeps giving me an error
                    pattern = pattern + patC.repeat(spacesForA) + patA.repeat(l) + "\n";
                    spacesForA--;
                }
                for (int l = (randint - 1); l > 0; l--) {
                    pattern = pattern + patC.repeat(start) + patA.repeat(l) + "\n";
                    start++;
                }
                System.out.print(pattern);
                menuOption = printMenu(2);
            }

            else if (menuOption == 'B') {
                for (int i = 1; i < randint; i++) {
                    pattern = pattern + patB.repeat(i) + "\n";
                }
                System.out.print(pattern);
                menuOption = printMenu(2);
            }

            else if (menuOption == 'C') {
                int spaces = (randint * 2) - 3;
                for (int i = 0; i <= randint; i++) {
                    if (i == 0) {
                        pattern = pattern + patD.repeat(randint) + "\n";
                    } else if (i > 0 && i < randint) {
                        pattern = pattern + patA + patC.repeat(spaces) + patA + "\n";
                    } else if (i == randint) {
                        pattern = pattern + patD.repeat(randint) + "\n";
                    }
                }
                System.out.print(pattern);
                menuOption = printMenu(2);
            }

            else if (menuOption == 'D') {
                String patE = "-", patF = "+", patG = "=";
                for (int i = randint; i > 0; i--) {
                    pattern = pattern + patE.repeat(i) + "\n";
                    i--;
                    if(i > 0) {
                        pattern = pattern + patF.repeat(i) + "\n";
                        i--;
                    }
                    if(i > 0) {
                        pattern = pattern + patG.repeat(i) + "\n";
                        i--;
                    }
                }
                System.out.print(pattern);
                menuOption = printMenu(2);
            }
            else if (menuOption == 'E') {
                yesorno = 1;
            }
            else throw new IllegalArgumentException("Incorrect input");
        }
    }

    public static Character printMenu(int idk){
        System.out.println("Pattern menu (only type the letter):\nOption A\nOption B\nOption C\nOption D\nOption E");
        System.out.print("Your next choice: ");
        Scanner user = new Scanner(System.in);
        char option = user.next().charAt(0);
        return option;
    }

    //print a box of #'s with the width and height given
    public static String printPounds(int width, int height){
        String pattern = "";
        String width_patt;
        String pound = "#";

        if(width <= 0) throw new IllegalArgumentException("Incorrect input");
        if(height <= 0) throw new IllegalArgumentException("Incorrect input");

        width_patt = pound.repeat(width) + "\n";
        pattern = width_patt.repeat(height);
        System.out.print(pattern);

        return(pattern);
    }

    public static void main(String[] args){
        // if they type a lowercase letter change it to upper case

        //testing SecretNumber
        System.out.print("Guess the random number between 1 and 10: ");
        Scanner user = new Scanner(System.in);
        int usrin = user.nextInt();
        if(usrin > 10 || usrin < 1) throw new IllegalArgumentException("Incorrect input");
        SecretNumber(usrin);

        //testing exponentCalculator
        System.out.print("Give the base number: ");
        user = new Scanner(System.in);
        int base = user.nextInt();
        System.out.print("Give the exponent number: ");
        user = new Scanner(System.in);
        int exponent = user.nextInt();
        exponentCalculator(base, exponent);

        //testing DesigningPatterns
        System.out.println("Pattern menu (only type the letter):\nOption A\nOption B\nOption C\nOption D\nOption E");
        System.out.print("Your choice: ");
        user = new Scanner(System.in);
        char option = user.next().charAt(0);
        if(Character.isLowerCase(option)){
            Character.toUpperCase(option);
        }
        if((int)option > 70 || (int)option < 65) {
            throw new IllegalArgumentException("Incorrect input");
        }
        DesigningPatterns(option);

        //testing printPounds
        user = new Scanner(System.in);
        System.out.print("Enter the width: ");
        int width = user.nextInt();
        System.out.print("Enter the height: ");
        int height = user.nextInt();
        printPounds(width, height);



    }
}
