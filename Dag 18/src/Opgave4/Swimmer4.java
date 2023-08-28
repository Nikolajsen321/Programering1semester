package Opgave4;

import model.TrainingPlan;

import java.util.ArrayList;

public class Swimmer4 {
    private String name;
    private String club;
    private int yearGroup;
    private ArrayList<Double> lapTimes;

    Swimmer4(String name1, int yearGroup1,ArrayList<Double> lapTimes1,String club1){
        this.name = name1;
        this. yearGroup = yearGroup1;
        this.lapTimes = lapTimes1;
        this.club = club1;
    }

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



    @Override
    public String toString() {
        return "Swimmer4{" +
                "name='" + name + '\'' +
                ", club='" + club + '\'' +
                ", yearGroup=" + yearGroup +
                ", lapTimes=" + lapTimes +
                '}';
    }
}
