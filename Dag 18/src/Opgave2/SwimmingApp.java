package Opgave2;

import model.Swimmer;
import model.TrainingPlan;

import java.util.ArrayList;

public class SwimmingApp {
    public static void main(String[] args) {
        TrainPlan t1 = new TrainPlan('A',16,10);

        ArrayList<Double> lapTimes = new ArrayList<>();
        lapTimes.add(1.02);
        lapTimes.add(1.01);
        lapTimes.add(0.99);
        lapTimes.add(0.95);
        lapTimes.add(1.02);
        lapTimes.add(1.04);
        lapTimes.add(0.99);
        Swimmers s1 = new Swimmers("Jan", 1994, lapTimes, "AGF");
        t1.addSwimmers(s1);

        lapTimes = new ArrayList<>();
        lapTimes.add(1.05);
        lapTimes.add(1.01);
        lapTimes.add(1.04);
        lapTimes.add(1.06);
        lapTimes.add(1.08);
        lapTimes.add(1.04);
        lapTimes.add(1.02);
        Swimmers s2 = new Swimmers("Bo", 1995, lapTimes, "Lyseng");
        t1.addSwimmers(s2);


        lapTimes = new ArrayList<>();
        lapTimes.add(1.03);
        lapTimes.add(1.01);
        lapTimes.add(1.02);
        lapTimes.add(1.05);
        lapTimes.add(1.03);
        lapTimes.add(1.06);
        lapTimes.add(1.03);
        Swimmers s3 = new Swimmers("Mikkel", 1993, lapTimes, "AIA-Tranbjerg");
        t1.addSwimmers(s3);

        System.out.println("Træningsplan:");
        System.out.println(t1.getLevel());
        System.out.println("Følgende svømmer følger træningsplanen");

        for (Swimmers element :t1.getSwimmersTrainPlan()) {
            System.out.println(element.getName() + "'s bedste tid: " + element.bestLapTime());
        }

    }
}
