public class ProgramString {
    public static void main(String[] args){
        String ord1 = "Datamatiker";
        String ord2 = "Uddannelsen";

        // En metode der laver reference variablen om til stor bogstaver
        String upper = ord1.toUpperCase();

         // udskriver ord1 med storbogstaver
        System.out.println(" Laver variabel ord 1 om til stor "+ "" + upper);

        //  metode der laver ord1 om til små bogstaver
        String lower = ord2.toLowerCase();

        System.out.println("Laver variabel ord2 om til små bogstaver" + " " + lower);

     // sammen sætter ord1 og ord 2 med mellem rum
        System.out.println(ord1 + " " + ord2);

      // sammen sætter de to variabler hvor ord2 bliver lavet til lowercase
        String ord3 = ord1 + ord2.toLowerCase();

        // Udskriver ord1 sammensat med ord 3
        System.out.println(ord3);


        // udskriv længden af strengen fra ord3

        System.out.println("The length of " + ord3 + " is " + ord3.length());


        // få  kigger på en substring som er bogstaver 0 til n i ord1
        System.out.println(ord1.substring(0, 7));
          // ord2
        System.out.println(ord2.substring(2, 7));
        // ord3
        System.out.println(ord3.substring(ord3.length()/2));









    }
}
