import java.util.Scanner;
public class NegativPositivNulMetode {
    public static void main(String[] args ){


        Scanner input = new Scanner(System.in);
        System.out.println(" Indtast et tal ");
        int tal = input.nextInt();




        String tegn = sign(tal);

        System.out.println(" taller er altså " + tal + " " + tegn );

//        System.out.println( " tallet er altså et " + sign(0));
//        System.out.println( " tallet er altså et " + sign(10));
//        System.out.println( " tallet er altså et " + sign(-1));

    }

    public static String sign( int num ){

        String result = " ";

        if( num == 0){
            result = " nul ";

        } else if( num > 0){
            result = " positv ";
        }else if( num < 0){
            result = " negativ ";
        }

        return result;
    }

}
