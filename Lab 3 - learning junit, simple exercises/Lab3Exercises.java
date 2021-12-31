import java.util.*;
import java.lang.String.*;
import java.lang.*;

public class Lab3Exercises {
    public static String pigLatinEncoder(String engInput){
        String plOutput = " ";
        int rule, count = 0, check = 0;
        String[] words;
        String word;

        // if there are spaces split into separate words
        // put them into string array
        words = engInput.split(" ");
        count = words.length;
        String[] outputArr = new String[count];

        for(int i = 0; i < count; i++){
            word = words[i];
            char firstl = word.charAt(0);
            if(checkconsonant(firstl) == 1){
                rule = 2;
            }
            else{
                rule = 1;
            }

            // move the consonant(s) to end, add - before and "ay" after
            // if y comes after a group of consonants treat it as a vowel
            if(rule == 1){
                int numofcon = 1, k = 2;
                check = checkconsonant(word.charAt(1));
                while(check == 0){
                    numofcon++;
                    check = checkconsonant(word.charAt(k));
                    k++;
                }
                String consonants = word.substring(0, numofcon);
                String noncon = word.substring(numofcon);
                outputArr[i] = noncon + "-" + consonants + "ay";
            }

            // when a word begins with a vowel, add "-way to end
            if(rule == 2){
                outputArr[i] = word + "-way";
            }
        }
        plOutput = Arrays.toString(outputArr);
        plOutput = plOutput.substring(1, plOutput.length() - 1);
        plOutput = plOutput.replaceAll(",", "");
        System.out.print(plOutput + "\n");
        return(plOutput);
    }
    public static int checkconsonant(char checkchar){
        int yesono = 0;
        if(checkchar=='a'||checkchar=='e'||checkchar=='i'||checkchar=='u'||checkchar=='o'){
            yesono = 1;
        }
        else if(checkchar=='A'||checkchar=='E'||checkchar=='I'||checkchar=='O'||checkchar=='U'){
            yesono = 1;
        }
        else if(checkchar == 'y' || checkchar == 'Y'){
            yesono = 2;
        }
        else{
            yesono = 0;
        }
        return(yesono);
    }

    public static String pigLatinDecoder(String pigInput){
        String engOutput = " ";
        int rule = 0, count = 0, partlen = 0;
        String[] words, parts;
        String word;
        String part1 = " ", part2 = " ";

        words = pigInput.split(" ");
        count = words.length;
        String[] engwords = new String[count];

        // split word at "-", if the string after the - is "way"
        // delete that part and print the word and with the w in front
        for(int i = 0; i < count; i++) {
            word = words[i];
            parts = word.split("-");
            part1 = parts[0];
            part2 = parts[1];
            if(part2.contains("way")){
                engwords[i] = "(" + part1 + "/" + "w" + part1 + ")";
            }
            else{
                //take of last two letters then add the strings
                part2 = part2.substring(0, part2.length() - 2);
                engwords[i] = part2 + part1;
            }
        }
        engOutput = Arrays.toString(engwords);
        engOutput = engOutput.substring(1, engOutput.length() - 1);
        engOutput = engOutput.replaceAll(",", "");
        System.out.print(engOutput + "\n");
        return(engOutput);
    }

    public static String randomCarsGenerator(int numcars){
        int randca = 0, randco = 0;
        String car = " ", color = " ", endstr = " ";
        String[] cars = new String[numcars];
        String[] colors = new String[numcars];
        Random random = new Random();
        int[] nocolor = new int[numcars];
        String[] carstring = new String[numcars];
        for(int j = 0; j < numcars; j++) {
            randca = random.nextInt(6);
            if(randca == 5 || randca == 6){
                nocolor[j] = 1;
            }
            switch (randca) {
                case 0:
                    car = " BMW";
                    break;
                case 1:
                    car = " SUV";
                    break;
                case 2:
                    car = " Volkswagen";
                    break;
                case 3:
                    car = " Sedan";
                    break;
                case 4:
                    car = " police car";
                    break;
                case 5:
                    car = " ambulance";
                    break;
                default:
                    car = " Jeep";
                    break;
            }
        cars[j] = car;
        }
        for(int k = 0; k < numcars; k++){
            randco = random.nextInt(4);
            switch(randco) {
                case 0:
                    color = " yellow";
                    break;
                case 1:
                    color = " red";
                    break;
                case 2:
                    color = " green";
                    break;
                case 3:
                    color = " blue";
                    break;
                default:
                    color = " white";
                    break;
            }
            colors[k] = color;
        }
        for(int l = 0; l < numcars; l++){
            if(nocolor[l] == 1) {
                carstring[l] = cars[l];
            }
            else{
                carstring[l] = colors[l] + cars[l];
            }
        }
        endstr = Arrays.toString(carstring);
        endstr = endstr.substring(1, endstr.length() - 1);
        System.out.println(endstr);
        return(endstr);

    }

    public static String hexToIntNBin(String hexInput){
        // the int that the letters rep. are ASCII - 55
        // the int of the char int is ASCII - 48
        String decandbin = " ";
        char temp;
        int newint = 0, g = 3, finalint = 0;
        int[] ints = new int[4];
        char[] chars = new char[4];
        hexInput = hexInput.substring(2, hexInput.length());
        for(int o = 0; o < 4; o++){
            chars[o] = hexInput.charAt(o);
            temp = chars[o];
            if(temp == 'A' || temp == 'B' || temp == 'C' || temp == 'D' || temp == 'E'|| temp == 'F'){
                ints[o] = (int)temp - 55;
                newint = ints[o];
            }
            else{
                ints[o] = chars[o] - 48;
                newint = ints[o];
            }
            double power = Math.pow(16.0, (double)g);
            g--;
            ints[o] = (int)power * newint;
            finalint = finalint + ints[o];
        }
        String binarystring = Integer.toBinaryString(finalint);
        decandbin = "Your number is " + finalint + " (in decimal) and " + binarystring + " (in binary).";
        System.out.print(decandbin);
        return(decandbin);
    }

    public static void main(String[] args){
        System.out.printf("%03d",7);

        //testing pigLatinEncoder
        System.out.println("Enter one or more words: ");
        Scanner usrin = new Scanner(System.in);
        String pigLatinin = usrin.nextLine();
        if(pigLatinin.isEmpty()){
            System.out.println("Incorrect input");
            System.exit(1);
        }
        String plout = pigLatinEncoder(pigLatinin);

        // testing pigLatinDecoder
        System.out.println("Enter one or more words in pig latin: ");
        usrin = new Scanner(System.in);
        String englishin = usrin.nextLine();
        if(englishin.isEmpty()){
            System.out.println("Incorrect input");
            System.exit(1);
        }
        String engout = pigLatinDecoder(englishin);

        // testing randomCarsGenerator
        System.out.println("Enter number of cars: ");
        usrin = new Scanner(System.in);
        int numofcars = usrin.nextInt();
        if(numofcars <= 0){
            System.out.println("Needs to be more than 0");
            System.exit(1);
        }
        String carsout = randomCarsGenerator(numofcars);

        // testing hexToIntNBin
        System.out.println("Enter number a number in hexidecimal: ");
        usrin = new Scanner(System.in);
        String hexstring = usrin.nextLine();
        if(hexstring.isEmpty()){
            System.out.println("Incorrect Input");
            System.exit(1);
        }
        String decandbin = hexToIntNBin(hexstring);
        System.out.print(7.8 == 78);
    }
}
// 3a. i.) type: boolean, value: false
//    ii.) type: double, value: 37.349999999999994
//   iii.) type: int, value: 312
//    iv.) type: int, value: 1721

// b. i.) prediction: 9.78, 9, 9, 18.78, 66.78
//        actual: 9.78, 9, 9, 18.78, 99.78
// The error I missed was I added the int with the ASCII value of the character
// but, I needed to add the ASCII value of both.
//   ii.) prediction: 7.000
//        actual: 007
// I thought it was saying to give it three decimal places
//  iii.) prediction: BeeByeBye
// This keeps giving me an error when I try and run it but, I think it would be this
// because unless you use replaceAll it only replaces the first instance of the letter

// c. Strings are immutable in Java because they are unmodifiable and its internal state
// remain the same after being created. To modify a string we simply create a new string object.
