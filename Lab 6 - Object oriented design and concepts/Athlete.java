
public abstract class Athlete extends Person{
    private String athleteId;
    private String athleteTeam;
    private String athleteType;

    public Athlete(String firstName, String lastName, String birthdate, String athleteId, String athleteTeam, String athleteType) {
        super(firstName, lastName, birthdate);
        this.athleteId = athleteId;
        this.athleteTeam = athleteTeam;
        this.athleteType = athleteType;
    }
    public Athlete() {
        String athleteId = "";
        String athleteTeam = "";
        String athleteType = "";
    }
    public void setAthleteId(String aID){this.athleteId = aID;}
    public void setAthleteTeam(String aTeam){this.athleteTeam = aTeam;}
    public void setAthleteType(String aType){this.athleteType = aType;}
    public String getAthleteId(){return athleteId;}
    public String getAthleteTeam(){return athleteTeam;}
    public String getAthleteType(){return athleteType;}

    public abstract int getTotalTimePlayed();

    public String toString(){
        int tTimeP = getTotalTimePlayed();
        return(String.valueOf(tTimeP));
    }

}

