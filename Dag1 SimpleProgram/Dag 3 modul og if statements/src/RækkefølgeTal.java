import java.util.Scanner;
public class RækkefølgeTal {
    public static void main(String[] args) {
        System.out.println(" Talende skal stå fra venstre mod højre ");

        Scanner input = new Scanner(System.in);
        int tal1 = input.nextInt();
        int tal2 = input.nextInt();
        int tal3 = input.nextInt();

        if (tal1 < tal2 && tal2 < tal3) {
            System.out.println("talene vil være voksende " + tal1 + " " + tal2 + " " + tal3);

        } else if (tal1 > tal2 && tal2 > tal3) {
            System.out.println(" talende vil være aftagende" + tal1 + " " + tal2 + " " + tal3);

        } else {
            System.out.println(" hverken eller" + tal1 + " " + tal2 + " " + tal3);

        }

    }
}