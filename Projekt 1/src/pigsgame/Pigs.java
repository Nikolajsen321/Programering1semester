package pigsgame;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Pigs {
    Scanner input = new Scanner(System.in);
    static private String player1 = " ";

    static private int pointP1Sum = 0;
    static private double count = 1.00;
    static private int roundNR = 1;
    static private int roundCountP1;
    static private int roundCountP2;
    static private double rollP1 = 0.00;
    static private double rollP2 = 0.00;
    static private int roll = 0;

    static private String player2 = " ";

    static private int pointP2Sum = 0;

    static private int maxPoint = 0;

    static  private boolean  whosTurn  = true;









    public static void main(String[] args) {
        rulesForGame();
        playOneDie();

    }


    private static void playOneDie() {
//        boolean winnerFound = true;
        boolean rollAgian = true;

        System.out.println(" Player 1 indtast dit navn");
        player1 = playerOne();
        System.out.println(" Player 2 indtast dit navn");
        player2 = playerTwo();

        Scanner scanner = new Scanner(System.in);
        System.out.println(" Hvor mange point for at vinde ? ");


        maxPoint = scanner.nextInt();

        System.out.println("Tryk enter for at starte");
        String answer = scanner.nextLine();
        boolean winnerFound = false;

        while (!winnerFound) {
            System.out.println("*****************************");
            System.out.println(" \n *Round " + roundNR+"*");

            //player 1
            if (whosTurn) {

                pointP1Sum += sumPoints(player1, pointP1Sum);

                System.out.println(player1 + " got " + pointP1Sum);

                System.out.println( rollP1);


                if(  pointP1Sum >= maxPoint){
                    System.out.println(player1 + " Has won!");
                    winnerFound = true;
                }
                }else {
                // player 2

                pointP2Sum += sumPoints(player2,pointP2Sum);

                System.out.println(player2 + " now has " + pointP2Sum + " points ");

                System.out.println(rollP2);


            if(  pointP2Sum >= maxPoint){
                System.out.println(player2 + " Has won!");
                winnerFound = true;
                }
                roundNR++;
                count++;
            }
            whosTurn = !whosTurn;
        }

        scanner.close();
        printStatistics();
        }

    private static void rulesForGame() {
        System.out.println("=====================================================");
        System.out.println("The player throws two dice as long as he/she wants.");
        System.out.println(" If the player throws a one he loses the round. ");
        System.out.println("If the player throws two 1's in a single throw, the player loses ALL points.");
        System.out.println(" if the player choses to stop doing his round all." +
                " the eyes will be add to a point counter ");
        System.out.println("=====================================================");

    }
       private static int sumPoints(String navn, int points){
        Scanner scanner = new Scanner(System.in);
//           System.out.println(" tryk enter for start");
//           String answer = scanner.nextLine();
        int roundPoint = 0;
           System.out.println( " \n It is now " + navn +"'s turn");
           System.out.println(" Points before the round: "+points);

           String answer = scanner.nextLine();
        while( !answer.equals("no")){
            int[]face = rollDie();
            System.out.println("You got: "+ Arrays.toString(face));

            roll++;


            System.out.println( " Number of rolls "+ roll);

            if (face[0]==1 && face[1] == 1){
                System.out.println("YOU LOSE ALL YOUR POINTS!!!");
                updateRollCount(whosTurn, roll);
                roll = 0;
                points = points -roundPoint;
                return -points - roundPoint;
            }

            if( face[0] == 1 || face[1] ==1 ) {
                updateRollCount(whosTurn, roll);
                roll = 0;
                return 0;
            } else{
                roundPoint += face[0] +face[1];
               if (points + roundPoint >= maxPoint) {
                   return roundPoint;
               }

                System.out.println( "\n vil du slå igen ?");
                System.out.println(" point i denne runde " + roundPoint);
                System.out.println(" points i alt:"+(points + roundPoint));
                answer = scanner.nextLine();
            }
        }
           updateRollCount(whosTurn, roll);
        roll = 0;


        return roundPoint;
}

    private static void updateRollCount(boolean whosTurn, int roll) {
        if(whosTurn){
            rollP1 += roll;
            roundCountP1++;
        }else if( !whosTurn){
            rollP2 += roll;
            roundCountP2++;
        }

    }


    private static String playerTwo() {
        Scanner input = new Scanner(System.in);
        String navn = input.nextLine();

        return navn;
    }

    private static String  playerOne() {
        Scanner input = new Scanner(System.in);
        String navn = input.nextLine();

        return navn;
    }

        private static int[] rollDie () {
        int[] eyes = new int[2];
        for(int i = 0; i < eyes.length; i++) {
            eyes[i] = (int) (Math.random() * 6 + 1);
        }

        return eyes;
        }

        private static void printStatistics () {
            System.out.println("\nResults:");
            System.out.println("-------");

            System.out.println( player1 + " fik " + pointP1Sum + " points" );
            System.out.println(" Har i gennemsnit kastet " + (rollP1 / roundCountP1)  + " pr. runde" );
            System.out.println(" ----------------- ");
            System.out.println( player2 + " fik " + pointP2Sum + " points" );
            System.out.println(" Har i gennemsnit kaset " +( rollP2 / roundCountP2)  +" Pr. runde" );
        }

    }

