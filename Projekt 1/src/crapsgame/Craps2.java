package crapsgame;
import java.util.Arrays;
import java.util.Scanner;
public class Craps2 {
    private static int lose = 0;
    private static int win = 0;
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args){

        playCraps();

    }
    public static void playCraps(){
        Scanner scanner = new Scanner(System.in);
        System.out.print(" \n Welcome to Craps press Enter to play! ( ' no ' stops ) " );
        String answer = scanner.nextLine();

        while(!answer.equals("no")){
            int[] face = rollDice();
            System.out.println( " Eyes " + Arrays.toString( face ));
            System.out.println();

            int faceSum = face[0] + face[1];


            if( faceSum == 7 || faceSum == 11){
                System.out.println( " You win ");
                win++;

            }else if( faceSum == 2 ||faceSum== 3 || faceSum == 12){
                System.out.println("  You lose ");
                lose++;

            } else {
                if(rollforPoint(faceSum)){
                    System.out.println(" You win ");
                    win++;

                }else{
                    System.out.println( " You lose  ");
                    lose++;
                }

            }
            System.out.println(" Roll ? ( 'no' stops)");
            answer = input.nextLine();

        }
        printStatistics();
        scanner.close();



    }
    public static int[] rollDice(){
        int[] dice = new int[2];

        for( int i = 0; i < dice.length; i++){
            dice[i] = (int) (Math.random() * 6 + 1);
        }

        return dice;
    }

    private static boolean rollforPoint(int point){
        int[] faces;
        int sumPoint = 0;

        System.out.println(" Keep rolling  ");
          input.nextLine();

        while( sumPoint != 7) {
            faces = rollDice();
            System.out.println(" Eyes " + Arrays.toString(faces) + " \n ");
            sumPoint = faces[0] +faces[1];

            if (sumPoint == point) {
                return true;
            }else if ( sumPoint != 7){
                System.out.println(" Keep rolling ");
                input.nextLine();
            }
        }
        return false;
    }

    private static void printStatistics(){
        System.out.println( " \n Results:");
        System.out.println(" ------- ");

        System.out.printf(" %14s  %4d \n ", " winscore", win);
        System.out.printf(" %14s %4d \n"," loserscore ", lose);

//        System.out.printf("%17s %4d",);
    }
}
