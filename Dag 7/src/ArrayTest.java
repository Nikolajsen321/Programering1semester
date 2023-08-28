import java.util.Arrays;
import java.util.Scanner;
public class ArrayTest {
    public static void main(String[] args) {
        System.out.println(" \n Øvelse 2  ");
        int[] t = {4, 6, 7, 2, 3};

        System.out.println(sum(t));

        System.out.println();

        System.out.println(" Øvelse 3 ");

        int[] a = {4, 6, 7, 2, 3};
        int[] b = {4, 6, 8, 2, 6};

        System.out.println(Arrays.toString(sumArrays(a, b)));

        System.out.println(" \n Øvelse 3 to Arrays der ikke har den samme længde lægges sammen ");

        int[] a2 = {4, 6, 7, 2, 4, 5};
        int[] b2 = {4, 6, 8, 2, 4,};

        System.out.println(Arrays.toString(sumTwoArrays(a2, b2)));

        System.out.println();

        System.out.println(" Øvelse 4 \n");

        int[] t2 = {4, 3, 2, 6, 8};

        System.out.println(" Det har et ulige hvis" + " " + hasUneven(t2));

        System.out.println(" Den næste skulle gerne være  false");
        int[] t3 = {4, 2, 6, 8, 10};

        System.out.println(" Det har et lige hvis" + " " + hasUneven(t3));


    }

    public static int sum(int[] t) {
        int sumArray = 0;

        for (int i = 0; i < t.length; i++) {
            sumArray += t[i];
        }
        return sumArray;
    }

    public static int[] sumArrays(int[] a, int[] b) {

        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] + b[i];
        }
        return a;
    }

    public static int[] sumTwoArrays(int[] a, int[] b) {



        int[] longer = a.length >= b.length ? a: b;
        int[] shorter = a.length > b.length ? a: b;
        
        int[] c = new int[longer.length];

        if(a.length >= b.length){
            longer = a;

        } else {
            longer = b;
        }
        if(a.length <= b.length){
            shorter = a;

        } else {
            shorter = b;
        }
        for (int i = 0; i < longer.length; i++) {

            if (i < shorter.length) {
                c[i] = longer[i] + shorter[i];

            } else if (i < longer.length) {
                c[i] = longer[i];
            }
        }
        return c;
    }

    public static boolean hasUneven(int[] t) {
        boolean result;

        for (int i = 0; i < t.length; i++) {
            if (t[i] % 2 != 0) {
                return true;
            }

        }
        return false;
    }
}



