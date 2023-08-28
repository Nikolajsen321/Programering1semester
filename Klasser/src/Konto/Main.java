package Konto;
import java.awt.*;
import java.util.Scanner;
import java.io.*;


public class Main {
    private static final String stopColor = " \u001B[0m";
    private static final String colorBlack = "\u001B[30m";
    private static final String colorRed = "\u001B[31m";
    private static final String colorGreen = "\u001B[32m";
    private static final String colorYellow = "\u001B[33m";
    private static final String colorBlue = "\u001B[34m";
    private static final String colorPurple = "\u001B[35m";
    private static final String colorCyan = "\u001B[36m";
    private static final String colorWhite = "\u001B[37m";


    public static void main (String[] args)
    {
//        Scanner input = new Scanner(System.in);
//        int chose = input.nextInt();
        Konto konto1 = new Konto("Karsten",1115550040,50000,10);
        UngKonto ungkonto1 = new UngKonto("Jonas","Karsten",4555300,4000,45);
        Børneopsparing børneopsparing1 = new Børneopsparing("Simon","Mia", 455531,500,40);

        String konto = "Konto";
        Color colo1 = Color.RED;

        System.out.println( colorRed + " konto er rød " + konto + stopColor );

        System.out.println(colorYellow +" Denne text er farvet " + stopColor );

        System.out.println();

        System.out.println();

        System.out.println("UngKonto: ");
        ungkonto1.udskrivKonto();

        System.out.println();

        System.out.println("Børneopsparing: ");
        børneopsparing1.udskrivKonto();
    }
}
