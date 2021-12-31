import java.util.*;

public class Lab5Exercises {

    //calculate the min and max strings and lengths
    //print both the arrays with the lengths and the strings in the form given
    public static void MinMaxLen(ArrayList<String> usrinput){
        ArrayList<Integer> lengths = new ArrayList<Integer>();
        int size = usrinput.size(), tempint, mindex = 0, maxdex = 0;
        int [] minmaxnums = new int[2];
        String [] minmaxstrings = new String[2];

        for (String list : usrinput) {
            tempint = list.length();
            lengths.add(tempint);
        }
        int min = lengths.get(0);
        int max = lengths.get(0);
        for(int j = 1; j < size; j++){
            int minmax = lengths.get(j);
            if(min > minmax){
                min = minmax;
                mindex = j;
            }
            else if(max < minmax) {
                max = minmax;
                maxdex = j;
            }
        }
        minmaxnums[0] = min;
        minmaxnums[1] = max;
        minmaxstrings[0] = usrinput.get(mindex);
        minmaxstrings[1] = usrinput.get(maxdex);

        System.out.println(Arrays.toString(minmaxnums));
        System.out.println(Arrays.toString(minmaxstrings));
    }

    public static void studentDirectory(int minAge, int minYear, int minGrade) {
        // [studentID, studentAge, studentYear, studentGrade]
        int[][] students = {{1, 17, 11, 94}, {2, 13, 9, 70}, {3, 18, 12, 84}, {4, 14, 10, 46}, {5, 14, 9, 100}, {6, 16, 10, 68}};
        int studentID;
        String saveID = "";

        for (int i = 0; i < students.length; i++) {
            studentID = students[i][0];
            int dontsave = 0;
            System.out.println("Student ID: " + studentID);
            for (int j = 1; j < 4; j++) {
                int current = students[i][j];
                if (current == -1) {
                }
                else if (j == 1) {
                    if (current < minAge) {
                        dontsave = 1;
                    }
                }
                else if (j == 2) {
                    if (current < minYear) {
                        dontsave = 1;
                    }
                }
                else if (j == 3) {
                    if (current < minGrade) {
                        dontsave = 1;
                    }
                }

            }
            System.out.println("dontsave: " + dontsave);
            if (dontsave == 0) {
                saveID = saveID + studentID + "\n";
            }
        }
        System.out.print(saveID);
    }
    

    public static void main(String [] args){

        //testing MinMaxLen
        int x = 0, i = 0;
        ArrayList<String> list = new ArrayList<String>();
        String temp = " ";
        Scanner scan = new Scanner(System.in);

        while(x == 0) {
            System.out.print("Enter a word (enter -1 when finished): ");
            temp = scan.nextLine();
            if(temp.isEmpty()) throw new IllegalArgumentException("You didn't type anything");
            if(temp.equals("-1")){
                x = 1;
            }
            else {
                list.add(temp);
            }
        }
        MinMaxLen(list);


        //testing Student Directory
        System.out.println("Minimum Age: ");
        int age = scan.nextInt();
        System.out.println("Minimum Year: ");
        int year = scan.nextInt();
        System.out.println("Minimum Grade: ");
        int grade = scan.nextInt();
        studentDirectory(age, year, grade);


    // check the inputs for both
    }


}
