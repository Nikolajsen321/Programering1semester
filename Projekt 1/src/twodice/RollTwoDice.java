package twodice;

import java.util.Arrays;
import java.util.Scanner;

public class RollTwoDice {

    private static int sum = 0;
    private static int rollCount = 0;

    private static int max = 0;

    private static int same = 0;
    private static int[] count = new int[7];



    public static void main(String[] args) {
        System.out.println("Welcome to the game of RollOneDie");

        printRules();
        System.out.println();

        playtwoDice();


        System.out.println();
        System.out.println("Thank you for playing RollOneDie");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of RollOneDie:");
        System.out.println("The player throws one die as long as he/she wants.");
        System.out.println("=====================================================");
    }

    private static void playtwoDice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Roll? ('no' stops) ");
        String answer = scanner.nextLine();
        while (!answer.equals("no")) {
            int[] face = rollDice();
            System.out.println("Eyes: " + Arrays.toString(face));
            System.out.println();

            updateStatistics(face);




            System.out.print("Roll? ('no' stops) ");
            answer = scanner.nextLine();
        }

        printStatistics();
        scanner.close();
    }

    private static int[] rollDice() {
        int[] eyes = new int[2];

        for (int i = 0; i < eyes.length; i++) {
            eyes[i] = (int) (Math.random() * 6 + 1);


            sum = sum + eyes[i];

            int dice1 = eyes[0];
            int dice2 = eyes[1];

            if (eyes[0] == eyes[1]) {
                same++;
            }

            if (eyes[0] + eyes[1] > max) {
                max = dice1 + dice2;
            }
        }


        return eyes;
    }









    private static void updateStatistics(int[] face)
    {
        rollCount++;
        count[face[0]]++;
        count[face[1]]++;
    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.printf("%13s %4d\n", "Roll count:", rollCount);
        System.out.println( " summen er " + sum );
        System.out.println(" Det er " + same + " par ");
        System.out.println(" det største tal er " + max);

        System.out.println(" \n Value count ");

        System.out.println(" Values:    [0, 1, 2, 3, 4, 5, 6]");

        System.out.println(" Ouccurence:" + Arrays.toString( count));
    }

}


