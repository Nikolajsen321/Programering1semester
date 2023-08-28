import java.util.Scanner;
public class ComputeAverage {
    public static void main(String[] args){
        // udregning af gennemsnit fra input

        // laver et Scanner objekt
        Scanner input = new Scanner(System.in);

        // få brugerr til at skrive et input
        System.out.print("Enter three numbers");

        //Lav varibel og vælg specifik data type ved invoke scanner objekt metoden læser fra keyboard ansinger variabel med data
        // data type double (float)
        double number1 = input.nextDouble();
        double number2 = input.nextDouble();
        double number3 = input.nextDouble();

        // udregning af gennemsnit
        double average = ((number1 + number2 + number3) / 3);

        // Display results
        System.out.println("The average of" + number1 + " " + number2 + " " + number3 + " is " + average);

    }

}
