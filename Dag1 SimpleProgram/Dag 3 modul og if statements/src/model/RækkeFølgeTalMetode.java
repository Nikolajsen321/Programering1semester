package model;
import java.util.Scanner;

public class RækkeFølgeTalMetode {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println(" Indtast 3 tal i hvilken som helst rækkefølge og programmet fortællet om" +
                " det er voksende, aftagende eller random rækkefølge");

        int tal1 = input.nextInt();
        int tal2 = input.nextInt();
        int tal3 = input.nextInt();


        String lineup = order(tal1, tal2 ,tal3 );

        System.out.println(" rækken er "+ lineup);

        System.out.println(" rækken er " + order(tal1,tal2,tal3));

        System.out.println(" rækken er " + order(1,3,2));

    }
    public static String order(int num1, int num2, int num3 ){
        String result = " ";

        if( num1 < num2 && num2 < num3){
            result = "Voksende ";

        }else if( num1 > num2 && num2 > num3){
            result = "Aftagnende ";

        } else
            result = "Random ";

        return result;
    }

}
