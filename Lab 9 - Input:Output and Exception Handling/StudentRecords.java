import java.io.*;
import java.util.*;

public class StudentRecords {
    static int numOfJuniors = 0, numOfSeniors = 0, numOfSophomores = 0, numOfFreshman = 0;
    private static final String jun = "J", sen = "S", soph = "s", fresh = "F";

    public static void addStudent(String name, String year) throws IOException{
        FileWriter writeNames = new FileWriter("Resources/students.txt", true);
        if(year.equals(jun) || year.equals(soph) || year.equals(sen) || year.equals(fresh)) {
            String newStudent = year + " " + name + "\n";
            writeNames.write(newStudent);
            writeNames.close();
        }
        else{
            System.out.print("Invalid year");
        }
    }

    public static void deleteStudent(String name, String year) throws IOException {
        String fullLine = year + " " + name;
        File studentsFile = new File("/Users/janeschmidt/IdeaProjects/Lab 9/Resources/students.txt");
        File tempFile = new File("Resources/tempFile.txt");
        FileWriter writeNames = new FileWriter(tempFile, true);
        BufferedReader reader = new BufferedReader(new FileReader(studentsFile));
        String line = reader.readLine();
        while (line != null) {
            if (!line.equals(fullLine)) {
                writeNames.write(line + "\n");
            }
            line = reader.readLine();
        }
        reader.close();
        writeNames.close();

        boolean deleted = studentsFile.delete();
        boolean newFile  = tempFile.renameTo(new File("Resources/students.txt"));
        if(!deleted){
            System.out.println("Didn't delete :'(");
        } else if(!newFile){
            System.out.println("No new files");
        }
    }

    public static int countClasses() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("Resources/students.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                switch (line.charAt(0)) {
                    case 'F' -> numOfFreshman++;
                    case 's' -> numOfSophomores++;
                    case 'J' -> numOfJuniors++;
                    case 'S' -> numOfSeniors++;
                    default -> {continue;}
                }
                line = reader.readLine();
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Exception found:" + e.getMessage());
        }
        return(numOfFreshman + numOfSophomores + numOfJuniors + numOfSeniors);
    }
    public static void countStudents() throws IOException {
        countClasses();
        System.out.println("Number of freshman: " + numOfFreshman);
        System.out.println("Number of sophomores: " + numOfSophomores);
        System.out.println("Number of juniors: " + numOfJuniors);
        System.out.println("Number of seniors: " + numOfSeniors);
    }

    public static void main(String[] args) throws IOException {
        int x = 0;

        while(x == 0){
            System.out.println("1.Add a student to the file students.txt\n2.Delete a record");
            System.out.println("3.Count of seniors, juniors, sophomores, and freshman\n4.Total count of students\n5.Exit");
            Scanner in = new Scanner(System.in);
            int userInput = in.nextInt();
            in.nextLine();
            if(userInput == 1){
                System.out.print("Enter student name: ");
                String name = in.nextLine();
                System.out.println("Options: Freshman - F, Sophomore - s, Junior - J, Senior - S");
                System.out.print("Enter year of student: ");
                String year = in.nextLine();
                addStudent(name, year);
            }
            else if(userInput == 2){
                System.out.print("Enter student name: ");
                String name = in.nextLine();
                System.out.println("Options: Freshman - F, Sophomore - s, Junior - J, Senior - S");
                System.out.print("Enter year of student: ");
                String year = in.nextLine();
                deleteStudent(name, year);
            }
            else if(userInput == 3){
                countStudents();
            }
            else if(userInput == 4){
                int num = countClasses();
                System.out.println("Total number of students: " + num);
            }
            else if(userInput == 5){
                x = 1;
            }
        }
    }
}
