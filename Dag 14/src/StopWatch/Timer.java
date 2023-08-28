package StopWatch;

import javax.swing.*;
import java.time.LocalTime;
import java.util.Scanner;

public class Timer {
    private LocalTime startTime;
    private LocalTime endTime;
    private double startCounter;
    private double elapsed;
    private boolean watching;




    public Timer() {



    }


    public void start() {

        this.startTime = LocalTime.now();
        this.startCounter = System.currentTimeMillis();
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }


    public void end() {
        this.endTime = LocalTime.now();
    }


    public boolean isWatching() {
        Scanner input = new Scanner(System.in);
        boolean valg;
        if ((input.nextLine().equals(""))) {
            valg = true;
        } else {
            valg = false;
        }
        return valg;
    }


    public double elapsed() {
        this.elapsed = (System.currentTimeMillis() - startCounter)/1000;
        return elapsed;
    }


}






