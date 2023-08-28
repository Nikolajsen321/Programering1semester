import java.util.Scanner;
public class Opgave3 {
    public static void main(String[] args){
        /* lav et program hvor man skriver en række af tal, hvor metodens opgave er at ændre rækkefølgen på
        rækken
         Systemet skal tag molius af 10 for taget og derved gemmes cifrerne i omvendt række følge
         der skal laves et loop der bliver ved til tallet der indtastes er lig 0
         */
        String test = "2";
        double test2 = 0;
        test2 = Double.parseDouble(test);

        System.out.println(test2);
        System.out.println(" indtast en talrække ");

        Scanner input = new Scanner(System.in);
        int tal = input.nextInt();

        int line = reverse( tal);

        System.out.println( line );



    }
    public static int reverse(int number){
        int digit = 0;
        int rev = 0;

        while( number > 0) {

            digit = number % 10;

            rev = rev * 10 + digit;

            number = number / 10;

        }

        return rev;

    }
}
