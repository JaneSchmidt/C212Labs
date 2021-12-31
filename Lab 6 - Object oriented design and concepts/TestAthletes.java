import java.util.*;

public class TestAthletes {
    public static void main(String [] args){
        System.out.print("Enter the number of Athletes: ");
        Scanner scan = new Scanner(System.in);
        int numOfAthletes = scan.nextInt();

        List<Athlete> athleteList = new ArrayList<Athlete>(numOfAthletes);
        int[] numOfPeriods = new int[numOfAthletes];
        int[] minutesPerPeriod = new int[numOfAthletes];
        int[] numOfHalves = new int[numOfAthletes];
        int[] minutesPerHalf = new int[numOfAthletes];
        int[] numOfQuarters = new int[numOfAthletes];
        int[] minutesPerQuarter = new int[numOfAthletes];
        String[] firstName = new String[numOfAthletes];
        String[] lastName = new String[numOfAthletes];
        String[] birthdate = new String[numOfAthletes];
        String[] type = new String[numOfAthletes];
        String[] team = new String[numOfAthletes];
        String[] ID = new String[numOfAthletes];


        for(int i = 0; i < numOfAthletes; i++){
            System.out.println("Enter the following information for Athlete " + (i + 1) + ": ");
            System.out.print("First Name: ");
            firstName[i] = scan.next();
            System.out.print("Last Name: ");
            lastName[i] = scan.next();
            System.out.print("Birthdate: ");
            birthdate[i] = scan.next();
            System.out.print("Athlete Type: ");
            type[i] = scan.next();
            System.out.print("Team Played For: ");
            team[i] = scan.next();
            System.out.print("ID: ");
            ID[i] = scan.next();

            if(type[i].equals("Hockey")){
                HockeyAthlete hockeyAthlete = new HockeyAthlete(){};
                hockeyAthlete.setFirstName(firstName[i]);
                hockeyAthlete.setLastName(lastName[i]);
                hockeyAthlete.setBirthdate(birthdate[i]);
                hockeyAthlete.setAthleteType(type[i]);
                hockeyAthlete.setAthleteTeam(team[i]);
                hockeyAthlete.setAthleteId(ID[i]);
                hockeyAthlete.setArenaType("Hockey");
                System.out.print("Number of Periods: ");
                numOfPeriods[i] = scan.nextInt();
                hockeyAthlete.setNumOfPeriods(numOfPeriods[i]);
                System.out.print("Minutes per Period: ");
                minutesPerPeriod[i] = scan.nextInt();
                hockeyAthlete.setMinutesPerPeriod(minutesPerPeriod[i]);
                athleteList.add(hockeyAthlete);

            }
            else if(type[i].equals("Soccer")){
                SoccerAthlete soccerAthlete = new SoccerAthlete(){};
                soccerAthlete.setFirstName(firstName[i]);
                soccerAthlete.setLastName(lastName[i]);
                soccerAthlete.setBirthdate(birthdate[i]);
                soccerAthlete.setAthleteType(type[i]);
                soccerAthlete.setAthleteTeam(team[i]);
                soccerAthlete.setAthleteId(ID[i]);
                soccerAthlete.setArenaType("Soccer");
                System.out.print("Number of Halves: ");
                numOfHalves[i] = scan.nextInt();
                soccerAthlete.setNumOfHalves(numOfHalves[i]);
                System.out.print("Minutes per Half: ");
                minutesPerHalf[i] = scan.nextInt();
                soccerAthlete.setMinutesPerHalf(minutesPerHalf[i]);
                athleteList.add(soccerAthlete);
            }
            else if(type[i].equals("Basketball")){
                BasketballAthlete basketballAthlete = new BasketballAthlete(){};
                basketballAthlete.setFirstName(firstName[i]);
                basketballAthlete.setLastName(lastName[i]);
                basketballAthlete.setBirthdate(birthdate[i]);
                basketballAthlete.setAthleteType(type[i]);
                basketballAthlete.setAthleteTeam(team[i]);
                basketballAthlete.setAthleteId(ID[i]);
                basketballAthlete.setArenaType("basketball");
                System.out.print("Number of Quarters: ");
                numOfQuarters[i] = scan.nextInt();
                basketballAthlete.setNumOfQuarters(numOfQuarters[i]);
                System.out.print("Minutes per Quarter: ");
                minutesPerQuarter[i] = scan.nextInt();
                basketballAthlete.setMinutesPerQuarter(minutesPerQuarter[i]);
                athleteList.add(basketballAthlete);
            }
            else{
                System.out.println("Incorrect athlete type: must be Hockey, Basketball, or Soccer");
            }
        }
    }
}
