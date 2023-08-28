import java.util.Arrays;
import java.util.Scanner;
public class Opgave5s7d3 {
    public static void main(String[] args) {

        System.out.println(" Hvor stor skal arrayen være? ");
        int[] testArray = createArray();

        System.out.println(" Tallende i arrayen er ");
        displayArray(testArray);

//        System.out.println( displayArray(testArray));

        System.out.println();
        int[] count = countInt(testArray);

        System.out.println(" Tallende er der ");
        displayCount(count, testArray);


//        int[] testArray = new int[50];

//        System.out.println(Arrays.toString(countInt(testArray)) + Arrays.toString( testArray ));


    }


    public static int[] createArray() {
        Scanner input = new Scanner(System.in);

        int antal = input.nextInt();


        int[] a = new int[antal];


        System.out.println(" indtast " + antal + " tal");

        for (int i = 0; i < a.length; i++) {
            a[i] = input.nextInt();

            while (a[i] > 49 || a[i] < 1) {
                System.out.println(" Prøv igen mindre en 50 og større end 0 " + a[i] + " er ude for tal ");
                a[i] = input.nextInt();
            }

        }
        return a;

    }


    public static void displayArray(int[] a) {
        // Den metode viser hvordan Arrayen man har skreven ind ser ud  lodret
        String result = " ";
        for (int i = 0; i < a.length; i++) {

            if (i  ==  0 ) {
                System.out.println(a[i]);
//                result += Integer.toString(a[i]);
            } else {
                System.out.println(a[i] + " ");
//                result += Integer.toString(a[i]) +  " ";

            }

        }
//        return result;
    }

    public static int[] countInt(int[] a) {
/* følgende selektion statment siger at hvis a[i] = a[j] så skal den lægge 1 til count[i] = 1
                osv  det vil altså sige arrayen er lavet så hvis jeg vælger den skal være
                5 stor og  indholde [1, 1, 2, 3, 4,]  så de  sige den kigger først fx a[0] og køre j
                antal a.length  gange igennem   så er  a[0] = [1] ? ja lægger 1 ++ til count[0] her fx count[0] = 2
                 */

        int[] count = new int[a.length];

        for (int i = 0; i < count.length; i++) {

            for (int j = 0; j < a.length; j++) {
                if (a[i] == a[j]) {
                    count[i]++;
                }

            }
        }
        return count;
    }

    public static void displayCount(int[] count, int[] a) {
        String array = " ";
        String countArray = "";

        String result = " ";

        int count1 = 0;

        for (int i = 0; i < count.length; i++) {
//                System.out.println( a[i] + " er der " + count[i]);
            for (int j = 0; j < count.length; j++) {
                if (a[i] != a[j]) {
                    array = Integer.toString(a[i]);
                    countArray = Integer.toString(count[i]);


                }


            }

            System.out.println( array + " er der " + countArray );


        }

    }
}



