import java.util.Arrays;
import java.util.Scanner;
public class Opgave5 {
    public static void main(String[] args){



        System.out.println(" \nLav et Program der tæller og viser antal lige og ulige tal\n");

//        System.out.println(" Hvor stor skal Arrayen være?");


        int[] array = createArray();

        System.out.println(unEveCount(array) + " \n " + Arrays.toString(array));




//        int[] a1 = {0,1,2,3,4,5,6,7,8,9};


//        System.out.println(unEveCount(a1));




    }

    public static String unEveCount(int[] a){
        Scanner input = new Scanner(System.in);

        String result = " ";
        String countLige1 = " ";
        String countUlige1 = " ";

        int countLige = 0;
        int countUlige = 0;

        for(int i = 0; i < a.length; i++) {

            if (a[i] % 2 == 0) {
                countLige++;
                countLige1 = Integer.toString(countLige);


            } else {
                countUlige++;
                countUlige1 = Integer.toString(countUlige);


            }
            result = " antal lige " + countLige1 + " antal ulige " + countUlige1;
        }

            return result;

        }

        public static int[] createArray(){
            Scanner input = new Scanner(System.in);
            System.out.println(" Hvor stor skal Arrayen være?");

            int arraySeize = input.nextInt();

            int[] a = new int[arraySeize];

            System.out.println(" indtast " + arraySeize + " tal ");


            for(int i = 0; i < a.length; i++){
                a[i] = input.nextInt();
//                while( a[i] < 1  || a[i] > 49) {
//                    System.out.println( "Prøv i gen ");
//                    a[i] = input.nextInt();
//
//                }

            }

          return a;
        }



    }


