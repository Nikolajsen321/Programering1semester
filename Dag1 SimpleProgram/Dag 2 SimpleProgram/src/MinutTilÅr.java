import java.util.Scanner;
public class MinutTilÅr {
    public static void main(String[] args ){

        System.out.println(" Skriv antal minuter");

        Scanner input = new Scanner(System.in);

        double minuter = input.nextDouble();
        double dage = minuter/60 / 24;
        double aar = dage/365;
        // hvor langte der til den næste værdi fra dage/365     altså  et tal + 329,44  ved 1000000 minuter
        double dagetil = dage % 365;

        System.out.println(" Antal minute " + minuter +   "  ar " + aar + " dage tilbage " + dagetil  );






    }
}
