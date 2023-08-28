import java.util.Scanner;
public class Opgave3Financial {

    public static void main(String[] args) {
        System.out.println(" indtast den mængde du har indtjent i registeret ");
        Scanner input = new Scanner(System.in);

        double salgsMengde = input.nextDouble();
        String udbytte = compute(salgsMengde);
        if(salgsMengde > 0) {

            System.out.println(" hvis du har tjent " + salgsMengde + " får du i udbytte" + " \n " + udbytte);
        }
    }
    public static String compute(double salesAmount) {
        Scanner input = new Scanner(System.in);
        String overAllProvition = " ";
        String provition = " ";
        String provition1 = " ";
        int i = 1;

//        double procent;
        double amount = 1;

        while (salesAmount!= 0) {
            if (salesAmount <= 5000) {
                amount = salesAmount * 6 / 100;
                provition = Double.toString(amount);
                provition = " DKK " + provition + provition1;
                provition1 = " + " + provition;

            } else if (5000 < salesAmount && salesAmount <= 10000) {
                amount = salesAmount * 8 / 100;
                provition = Double.toString(amount);
                provition = " DKK " + provition + provition1;
                provition1 = " + " + provition;

            } else if (salesAmount >= 10000) {
                amount = salesAmount * 10 / 100;
                provition = Double.toString(amount);
                provition = " DKK " + provition + provition1;
                provition1 =  " + " + provition;

            }
            if (salesAmount > 0){
                overAllProvition += "[" + i + "]" + " får du i provition \n " + provition + " \n ";
            }
            System.out.println( overAllProvition + "DKK" );
            salesAmount = input.nextDouble();

            i++;

        }

        return provition;
    }

}