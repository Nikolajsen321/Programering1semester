import java.util.Arrays;
import java.util.Scanner;
public class opgave5s7d3M {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int[] counts = new int[51];

        int num = -1;
        int count = 0;

        System.out.println(" indtast tal mellem 1 og  50 og slut med 0");

        int[] holderArray = {};
        while( num != 0){
            num = input.nextInt();
            holderArray = createArray(num);

            if(num >= 1 && num <= 50){
                counts[num]++;
            }


        }
       String a = Arrays.toString(counts);
        for(int i = 0; i <= 50; i++){
            count++;
            if( counts[i] != 0){
                System.out.println( i + " findes " + counts[i] + " gange");
            }
        }
        System.out.println(num);
        System.out.println("Arrayen giver altså antal gange det tal går igen ");
        System.out.println(Arrays.toString(counts).toString());
        System.out.println();
        System.out.println("HolderArray: " + Arrays.toString(holderArray));

    }

    private static int[] createArray(int num) {
        int count = 0;
        count++;
        int[] holderArray = new int[count];
        for(int i = 0; i < count; i++)
        {
            holderArray[i] = num;
        }
        return holderArray;

    }
}
