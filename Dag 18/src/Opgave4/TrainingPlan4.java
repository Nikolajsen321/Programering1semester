package Opgave4;

import Opgave2.Swimmers;

import java.util.ArrayList;

public class TrainingPlan4 {
    private char level;
    private int weeklyWaterHours;
    private int weeklyStrengthHours;

    private ArrayList<Swimmer4> swimmers = new ArrayList<>();

    public TrainingPlan4(char level, int weeklyWaterHours, int weeklyStrengthHours) {
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

    public Swimmer4 getSwimmersOnTrainingsPlan(int indexNr){
        return new ArrayList<>(swimmers).get(indexNr);
    }
    public String getAllSwimmersOnTrainingsPlan() {
        String string = "";
        for (int i = 0; i < swimmers.size(); i++) {
            string += getSwimmersOnTrainingsPlan(i).toString() + "\n";
        }
        return string;
    }


    public Swimmer4 createSwimmer(String name,int yearsGroup1,ArrayList<Double> laptime1,String club1 ){
          Swimmer4 swimmer = new Swimmer4(name,yearsGroup1,laptime1,club1);
          swimmers.add(swimmer);
          return swimmer;
    }
    public void removeSwimmer(Swimmer4 swimmer){
        if(swimmers.contains(swimmer)){
            swimmers.remove(swimmer);
        }
    }



}
