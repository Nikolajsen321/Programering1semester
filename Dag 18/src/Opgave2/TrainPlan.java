package Opgave2;

import model.Swimmer;

import java.util.ArrayList;

public class TrainPlan {
    private char level;
    private int weeklyWaterHours;
    private int weeklyStrengthHours;
    private ArrayList<Swimmers> swimmersTrainPlan = new ArrayList<>();

    public TrainPlan(char level, int weeklyWaterHours, int weeklyStrengthHours) {
        this.level = level;
        this.weeklyWaterHours = weeklyWaterHours;
        this.weeklyStrengthHours = weeklyStrengthHours;
    }

    public char getLevel() {
        return level;
    }

    public void setLevel(char niveau) {
        this.level = niveau;
    }

    public int getWeeklyStrengthHours() {
        return weeklyStrengthHours;
    }

    public void setWeeklyStrengthHours(int weeklyStrengthHours) {
        this.weeklyStrengthHours = weeklyStrengthHours;
    }

    public int getWeeklyWaterHours() {
        return weeklyWaterHours;
    }

    public void setWeeklyWaterHours(int weeklyWaterHours) {
        this.weeklyWaterHours = weeklyWaterHours;
    }

    public ArrayList<Swimmers> getSwimmersTrainPlan() {

        return new ArrayList<>(swimmersTrainPlan);
    }

    public void setSwimmersTrainPlan(ArrayList<Swimmers> swimmersTrainPlan) {
        this.swimmersTrainPlan = swimmersTrainPlan;
    }

    public void addSwimmers(Swimmers swimmers)
    {
        if(!swimmersTrainPlan.contains(swimmers)){
            swimmersTrainPlan.add(swimmers);
        }
    }

    public void removeSwimmers(Swimmers swimmers){
        if(swimmersTrainPlan.contains(swimmers)){
            swimmersTrainPlan.remove(swimmers);
        }

    }


//    public String giveTrainingplan() {
//         String string = "TrainingPlan{" +
//                "level=" + level +
//                ", weeklyWaterHours=" + weeklyWaterHours +
//                ", weeklyStrengthHours=" + weeklyStrengthHours +
//                '}';
//         for(Swimmers element : swimmersTrainPlan){
//             string += "\t" + element.toString();
//         }
//
//        return string;
//    }
}
