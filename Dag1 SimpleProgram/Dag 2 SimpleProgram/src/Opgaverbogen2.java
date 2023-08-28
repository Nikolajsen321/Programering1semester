import java.util.Scanner;
public class Opgaverbogen2 {
    public static void main(String[] args){
        // laver et scanner objekt
        Scanner input = new Scanner(System.in);

        System.out.println("indtast det nummer du vil kigge på fra over 0 til 1000");

        int number = input.nextInt();

        int digits1 = number % 10;
        number = number / 10;

        int digts2 = number % 10;
         number = number / 10;

        int digts3 = number % 10;

        int sum = digits1 + digts2 + digts3;

        System.out.println(" sum for alle digits for"+ " " + number + " er " + sum);





        }



    }

