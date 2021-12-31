public abstract class BasketballAthlete extends Athlete{
    private String arenaType;
    private int numOfQuarters;
    private int minutesPerQuarter;

    public BasketballAthlete(String firstName, String lastName, String birthdate, String athleteId, String athleteTeam, String athleteType, String arenaType, int numOfQuarters, int minutesPerQuarter){
        super(firstName, lastName, birthdate, athleteType, athleteId, athleteTeam);
        this.arenaType = arenaType;
        this.numOfQuarters = numOfQuarters;
        this.minutesPerQuarter = minutesPerQuarter;
    }

    public BasketballAthlete() {
        String arenaType = "";
        int numOfQuarters = 0;
        int minutesPerQuarter = 0;
    }
    public void setArenaType(String aType){this.arenaType = aType;}
    public void setNumOfQuarters(int nOfQ){this.numOfQuarters = nOfQ;}
    public void setMinutesPerQuarter(int mPerQ){this.minutesPerQuarter = mPerQ;}
    public String getArenaType(){return arenaType;}
    public int getNumOfQuarters(){return numOfQuarters;}
    public int getMinutesPerQuarter(){return minutesPerQuarter;}

    @Override
    public int getTotalTimePlayed(){
        return numOfQuarters * minutesPerQuarter;
    }

    public String toString(){
        int tTimeP = getTotalTimePlayed();
        return(String.valueOf(tTimeP));
    }
}