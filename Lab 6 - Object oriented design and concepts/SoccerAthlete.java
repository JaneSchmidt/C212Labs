public abstract class SoccerAthlete extends Athlete{
    private String arenaType;
    private int numOfHalves;
    private int minutesPerHalf;

    public SoccerAthlete(String firstName, String lastName, String birthdate, String athleteId, String athleteTeam, String athleteType, String arenaType, int numOfHalves, int minutesPerHalf){
        super(firstName, lastName, birthdate, athleteType, athleteId, athleteTeam);
        this.arenaType = arenaType;
        this.numOfHalves = numOfHalves;
        this.minutesPerHalf = minutesPerHalf;
    }

    public SoccerAthlete() {
        String areaType = "";
        int numOfHalves = 0;
        int minutesPerHalf = 0;
    }

    public void setArenaType(String aType){this.arenaType = aType;}
    public void setNumOfHalves(int nOfH){this.numOfHalves = nOfH;}
    public void setMinutesPerHalf(int mPerH){this.minutesPerHalf = mPerH;}
    public String getArenaType(){return arenaType;}
    public int getNumOfHalves(){return numOfHalves;}
    public int getMinutesPerHalf(){return minutesPerHalf;}

    @Override
    public int getTotalTimePlayed(){
        return numOfHalves * minutesPerHalf;
    }

    public String toString(){
        int tTimeP = getTotalTimePlayed();
        return(String.valueOf(tTimeP));
    }
}
