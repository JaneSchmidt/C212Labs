public abstract class HockeyAthlete extends Athlete{
    private String arenaType;
    private int numOfPeriods;
    private int minutesPerPeriod;

    public HockeyAthlete(String firstName, String lastName, String birthdate, String athleteId, String athleteTeam, String athleteType, String arenaType, int numOfPeriods, int minutesPerPeriod){
        super(firstName, lastName, birthdate, athleteType, athleteId, athleteTeam);
        this.arenaType = arenaType;
        this.numOfPeriods = numOfPeriods;
        this.minutesPerPeriod = minutesPerPeriod;
    }

    public HockeyAthlete() {
        String arenaType = "";
        String numOfPeriods = "";
        String minutesPerPeriod = "";
    }

    public void setArenaType(String aType){this.arenaType = aType;}
    public void setNumOfPeriods(int nOfP){this.numOfPeriods = nOfP;}
    public void setMinutesPerPeriod(int mPerP){this.minutesPerPeriod = mPerP;}
    public String getArenaType(){return arenaType;}
    public int getNumOfPeriods(){return numOfPeriods;}
    public int getMinutesPerPeriod(){return minutesPerPeriod;}


    @Override
    public int getTotalTimePlayed(){
        return numOfPeriods * minutesPerPeriod;
    }

    public String toString(){
        int tTimeP = getTotalTimePlayed();
        return(String.valueOf(tTimeP));
    }

}
