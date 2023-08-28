import java.util.Scanner;
public class AfstandKort {
    public static void main(String[] args){

Scanner input = new Scanner(System.in);

System.out.println(" indtast distance kørt ");

double afstand = input.nextDouble();

System.out.println(" indtast fuel effektivtet");

double fueleff = input.nextDouble();

System.out.println(" pris pr gallon ");
double priceprgallon = input.nextDouble();

double milsbeforetank = afstand / fueleff;
double priceall = milsbeforetank * priceprgallon;

System.out.println(" det har kostet " + priceall);

    }
}
