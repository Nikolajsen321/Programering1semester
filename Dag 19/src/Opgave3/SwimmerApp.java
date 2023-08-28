package Opgave3;

import java.util.ArrayList;

public class SwimmerApp {

    public static void main(String[] args) {
        TrainingPlan trainingPlan1 = new TrainingPlan('A',16,10);

        ArrayList<Double> lapTimes = new ArrayList<>();
        lapTimes.add(1.02);
        lapTimes.add(1.01);
        lapTimes.add(0.99);
        lapTimes.add(0.98);
        lapTimes.add(1.02);
        lapTimes.add(1.04);

        Swimmer swimmer1 = new Swimmer("Hans",1994,lapTimes,"AGF");
        trainingPlan1.addSwimmer(swimmer1);
        System.out.println(trainingPlan1.getSwimmer().get(0).toString());
        System.out.println(swimmer1.getTrainingPlan().toString());
//        trainingPlan1.removeSwimmer(swimmer1);
        System.out.println();

        TrainingPlan trainingPlan2 = new TrainingPlan('B',10,6);
        swimmer1.setTrainingPlan(trainingPlan2);
        System.out.println(trainingPlan2.getSwimmer().get(0).toString());
        System.out.println(swimmer1.getTrainingPlan().toString());
        trainingPlan2.removeSwimmer(swimmer1);
        System.out.println();

        trainingPlan1.addSwimmer(swimmer1);
        System.out.println( trainingPlan1.getSwimmer().get(0).toString());
        System.out.println(swimmer1.getTrainingPlan().toString());




    }
}
