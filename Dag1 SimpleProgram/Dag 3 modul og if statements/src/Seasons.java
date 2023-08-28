import java.util.Scanner;
public class Seasons {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println(" skriv dato ");

        int dag = input.nextInt();
        int maned = input.nextInt();

// metode "arstid" bliver called og udføre metoden med inputene maned og dag og gemmer String der returnes i variablen arstid
        String arstid = date(maned, dag);


        System.out.println(" Det vil sige d. " + dag + "/" + maned + " " + " er " + arstid + " 2022 " );

        // her bliver metoden dividere called og printed out uden at først gemmes i en variabel
        System.out.println( " \n det vil så sige hvis 3 går op i tallet vil Vinter blive til " + divider(3,21) );
        System.out.println(" det vil så sige hvis 3 går op i tallet vil Forår blive til " + divider(6,21) );
        System.out.println(" det vil så sige hvis 3 går op i tallet vil Sommer blive til " + divider(9,21) );
        System.out.println(" det vil så sige hvis 3 går op i tallet vil Vinter blive til " + divider(12,21) );
    }
    //metode der tjekker måned og dage og returner så en String til calleren der fortæller hvilken årstid det er
    public static String date(int month, int day) {

        String results = " ";

        if (month == 3 && month == 1) {
            if (day <= 31) {
                results = " Vinter ";
            }

        } else if (day <= 28 && month == 2) {
            results = " Vinter ";

        } else if (month > 3 && month <= 6) {
            if (day <= 31) {
                results = " Forår ";

            }

        } else if (month > 6 && month <= 9) {
            if (day <= 31) {
                results = " Sommer ";

            }
        } else if (month > 9 && month <= 12) {
            if (day <= 31) {
                results = " Efterår ";

            }
        }
        return results;
    }

// ny metode der tjekker om 3 går op i tallet
    public static String divider( int month, int day){
       String result = " ";
       if ( month % 3 == 0 && day >= 21){
           if( month == 3){
               result = " Forår ";


           } else if (month == 6){
               result = " Sommer ";

           } else if( month == 9){
               result = " Efterår";


           } else if( month == 12){
               result = " vinter";
           }

       }
           return result;

    }
}
