package Opgave3;

import java.util.ArrayList;

/**
 * Modeling a Swimmer
 */
public class    Swimmer {
    private String name;
    private String club;
    private int yearGroup;
    private ArrayList<Double> lapTimes;
    private TrainingPlan trainingPlan;

    /**
     * Initialize a new swimmer with name, club, yearGroup, and lap times.
     */ 

   public Swimmer(String name, int yearGroup, ArrayList<Double> lapTimes, String club) {
       this.name = name;
       this.yearGroup = yearGroup;
       this.lapTimes = lapTimes;
       this.club = club;
   }
    /**
     * Return the name of the swimmer
     */
    public String getName() {
        return this.name;
    }

    /**
     * Return the yearGroup of the swimmer
     */
    public int getYearGroup() {
        return this.yearGroup;
    }

    /**
     * Return the club of the swimmer
     */
    public String getClub() {
        return this.club;
    }

    /**
     * Register the club of the swimmer
     * @param club
     */
    public void setClub(String club) {
        this.club = club;
    }

    public TrainingPlan getTrainingPlan() {
        return trainingPlan;
    }

    public void setTrainingPlan(TrainingPlan trainingPlan1) {
        if(this.trainingPlan != trainingPlan1) {
            // Under del er til da swimmer kun kan være tilknyttet en træningsplan
//            så setmetoden skal altå fjerne eventuelle ekisterende tilknytning til en anden træningsplan
//            inden  swimmer bliver tilknyttet en ny trainingsplan i koden under
            TrainingPlan oldTrainingPlan = this.trainingPlan;
            if(oldTrainingPlan != null) {
               oldTrainingPlan.removeSwimmer(this);
            }
//            så opdateres link attributen i begge retninger
            this.trainingPlan = trainingPlan1;
            if(trainingPlan != null){
                trainingPlan.addSwimmer(this);
            }
        }
    }

    public int getTrainingsHoursEachWeek(){

        int weeklyTrainingHours = trainingPlan.getWeeklyStrengthHours() + trainingPlan.getWeeklyWaterHours();
        return weeklyTrainingHours;
    }



    /**
     * Return the fastest lap time
     */
    public double bestLapTime() {
        double best = Double.MAX_VALUE;
        for (double time: lapTimes) {
        	if(best > time) {
        		best = time;
        	}
        }
        return best;
    }

    @Override
    public String toString() {
        return "Swimmer{" +
                "name='" + name + '\'' +
                ", club='" + club + '\'' +
                ", yearGroup=" + yearGroup +
                ", lapTimes=" + lapTimes +
                '}';
    }
}
