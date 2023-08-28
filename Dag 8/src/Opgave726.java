import java.util.Arrays;
import java.util.Scanner;
public class Opgave726 {

    public static void main(String[] args) {

        System.out.println(" \n Skriv et tal for størelsen af Array");

        int list[] = inputArr();

        System.out.println( Arrays.toString(list) + " \n Det er " + isSorted(list) +
                " at alle talende er voksende " );
    }
        public static boolean isSorted(int[] list){
        for(int i = 0; i < list.length -1 ; i++){
            if( list[i] > list[i+1] ){
                return false;
            }
        }
        return true;
    }

    public static int[] inputArr() {

        Scanner input = new Scanner(System.in);

        int antal = input.nextInt();

        int[] list = new int[antal];

        System.out.println(" Indtast " + antal + " tal");

        for(int i = 0; i < antal; i++ ) {
            list[i] = input.nextInt();
        }

        return list;
    }
}
