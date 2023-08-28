package pigsgame;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class PigsGame {

    static private String player1 = " ";
    static private String player2 = " ";
    static private int pointP1Sum = 0;
    static private int pointP2Sum = 0;
    static private int roundNR = 1;
    static private int roundCountP1;
    static private int roundCountP2;
    static private double rollP1 = 0.00;
    static private double rollP2 = 0.00;
    static private int roll = 0;
    static private int maxPoint = 0;
    static  private boolean  whosTurn  = true;

    public static void main(String[] args) {
        
        rulesForGame();
        playOneDie();
    }

    private static void playOneDie() {

        boolean rollAgian = true;

        System.out.print(" Enter player 1 name: ");
        player1 = playerOne();
        System.out.print(" Enter player 2 name:");
        player2 = playerTwo();

        Scanner scanner = new Scanner(System.in);
        System.out.print(" Enter score amount: ");


        maxPoint = scanner.nextInt();

        System.out.println("Press ENTER to start!");
        String answer = scanner.nextLine();
        boolean winnerFound = false;

        while (!winnerFound) {
            System.out.println("_________________________");
            System.out.println(" \n *ROUND " + roundNR+"*");
            System.out.println("Write 'no' and press ENTER to end your turn.");

            //player 1
            if (whosTurn) {

                pointP1Sum += sumPoints(player1, pointP1Sum);
                System.out.println(player1 + " now has " + pointP1Sum + " points.");


            if (pointP1Sum >= maxPoint){
                System.out.println(player1 + " Has won!");
                winnerFound = true;
                }

            // player 2
            }else {
                pointP2Sum += sumPoints(player2,pointP2Sum);
                System.out.println(player2 + " now has " + pointP2Sum + " points. ");

            if(  pointP2Sum >= maxPoint){
                System.out.println(player2 + " Has won!");
                winnerFound = true;
                }
                roundNR++;

            }
            whosTurn = !whosTurn;
        }

        scanner.close();
        printStatistics();
        }

    private static void rulesForGame() {
        System.out.println("=====================================================");
        System.out.println("The player throws two dice as many times as he/she wants.");
        System.out.println(" If the player throws a 1 on a single die, he/she loses all points gained in the round. ");
        System.out.println("If the player throws two 1's in a single throw, the player loses ALL points.");
        System.out.println(" If the player choses to end his/her round, all" +
                " the eyes will be added to the players total points. ");
        System.out.println("=====================================================");

    }
       private static int sumPoints(String navn, int points){
        Scanner scanner = new Scanner(System.in);
//           System.out.println(" Press ENTER to start! ");
//           String answer = scanner.nextLine();
        int roundPoint = 0;
           System.out.println( " \n It is now " + navn +"'s turn");
           System.out.println(" Points before the round: "+points);

           String answer = scanner.nextLine();
        while( !answer.equals("no")){
            int[]face = rollDie();
            System.out.println("You got: "+ Arrays.toString(face));
            roll++;
            System.out.println( " Rolls this turn: "+ roll);

            if (face[0]==1 && face[1] == 1){
                System.out.println("YOU LOSE ALL YOUR POINTS!!!");
                updateRollCount(whosTurn, roll);
                roll = 0;
                points = points - roundPoint;
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

                System.out.println( "\n Do you wish to throw again?");
                System.out.println(" Points in this round: " + roundPoint);
                System.out.println(" Points in total:"+(points + roundPoint));
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

            System.out.println( player1 + " got " + pointP1Sum + " points" );
            System.out.println(" Has on average rolled " + (rollP1 / roundCountP1)  + " times per round" );
            System.out.println(" ----------------- ");
            System.out.println( player2 + " got " + pointP2Sum + " points" );
            System.out.println(" Has on average rolled " +( rollP2 / roundCountP2)  +" times per round" );
        }

    }

