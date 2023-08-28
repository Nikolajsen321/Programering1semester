import java.util.Arrays;
import java.util.Scanner;
public class Opgave7302 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(" indtast nummer");


        System.out.println(" indtast tal adskilt med mellemrum");

        int[] array = createArray();

        System.out.println(Arrays.toString(array));

        if(equals(array)){
            System.out.println(" der er 4 ens");
        }else{
            System.out.println(" der ikke 4 ens ");
        }


    }


    private static int[] createArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Indtast antal ");
        int antal = scanner.nextInt();
        int[] tal = new int[antal];
        for (int i = 0; i < tal.length; i++) {
//            String aktuelTalStreng = scanner.next();
//            int aktuelTal =Integer.parseInt(aktuelTalStreng);
            tal[i] = scanner.nextInt();
        }
        return tal;
    }

    public static boolean equals(int[] array) {
        int sameNum = 0;
        int count = 0;
        int conseutive = 4;
        for (int i = 0; i < array.length; i++) {
            sameNum = array[i];
            for (int j = i +1; j < array.length; j++ ) {
                if (sameNum == array[j]) {
                    count++;
                } else if ( conseutive > 3){
                    return true;
                }
                if( count >= conseutive){
                    return true;
                }
            }
        }
            return  false;
    }
}

