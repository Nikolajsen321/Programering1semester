package model;

public class ChildApp {

    // Metoden skal returenre en tekststreng der beskriver hvilken institution et barn skal gå i, afhængig af barnets alder.
    // Reglerne for dette kan ses på opgavedsedlen
    //
    public static String institution(int age) {
        String result = " ";
        if (age < 1) {
            result = " Hjemme ";

        }
        return result;
    }
     //Metoden skal returenre en tekststreng der beskriver hvilket gymnastikhold et barn skal gå på, afhængig af barnets alder og køn.
    // Reglerne for dette kan ses på opgavedsedlen

   public static String team(boolean isBoy, int age) {
       String result = " ";
       if (isBoy) {

           if( age < 8){
               result = " young cubs ";
// kan også bare sige else
           }else if( age >= 8 ){
               result = " Cool boys ";
           }

       }else if ( !isBoy) {
           if (age < 8) {
               result = " Tumbling girls ";

           } else if (age >= 8) {
               result = " Springly girls ";
           }
       }
       return result;
   }

    public static void main(String[] args) {
        System.out.println(" Et barn på 0 skal være " + institution(0));
        System.out.println(" Et barn på 0 skal være " + institution(1));
        System.out.println("Et barn på 5 skal i" + institution(5));

        System.out.println("Et dreng på 7 skal i" + team(true,7));
        System.out.println("Et dreng på 8 skal i" + team(true,8));
        System.out.println("Et dreng på 9 skal i" + team(true,9));

        System.out.println("En pige på 8 skal i" + team(false,8));
        System.out.println("En pige på 9 skal i" + team(false,9));
    }
}

