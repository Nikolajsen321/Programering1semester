package Opgave4;

import Opgave2.Swimmers;

import java.util.ArrayList;
import java.util.Arrays;

public class SwimmerApp4 {
    public static void main(String[] args) {
        TrainingPlan4 trainingPlan4 = new TrainingPlan4('A',16,10);

        ArrayList<Double> lapTimes = new ArrayList<>();
        lapTimes.add(1.02);
        lapTimes.add(1.01);
        lapTimes.add(0.99);
        lapTimes.add(0.98);
        lapTimes.add(1.02);
        lapTimes.add(1.04);
        lapTimes.add(0.99);
        trainingPlan4.createSwimmer("Hans",1994, lapTimes,"AGF");

        lapTimes = new ArrayList<>();
        lapTimes.add(1.03);
        lapTimes.add(1.01);
        lapTimes.add(1.02);
        lapTimes.add(1.05);
        lapTimes.add(1.03);
        lapTimes.add(1.06);
        lapTimes.add(1.03);
        trainingPlan4.createSwimmer("Jens",1995,lapTimes,"FCK");


        System.out.println(trainingPlan4.getSwimmersOnTrainingsPlan(0).toString());
        System.out.println(trainingPlan4.getSwimmersOnTrainingsPlan(1).toString());
        System.out.println();
        System.out.println(trainingPlan4.getAllSwimmersOnTrainingsPlan());
        trainingPlan4.removeSwimmer(trainingPlan4.getSwimmersOnTrainingsPlan(1));
        System.out.println(trainingPlan4.getAllSwimmersOnTrainingsPlan());




    }
}
