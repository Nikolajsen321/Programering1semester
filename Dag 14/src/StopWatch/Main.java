package StopWatch;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Timer stopWatch1 = new Timer();
        stopWatch1.start();
        System.out.println(stopWatch1.getStartTime());
        System.out.println("Tryk Enter for at se tid og s for stoppe tid tagning");

        giveTime(stopWatch1);
        stopWatch1.end();

        System.out.println("Start tid " + stopWatch1.getStartTime());
        System.out.println("antal sekunder " + stopWatch1.elapsed());
        System.out.println("Stop tid "+stopWatch1.getEndTime());
    }


    public static void giveTime(Timer stopWatch1)
    {
        while(stopWatch1.isWatching())
        {
            System.out.println(stopWatch1.elapsed());
        }
    }
}
