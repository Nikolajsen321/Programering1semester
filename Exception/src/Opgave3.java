import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Opgave3 {
    public static void main(String[] args) {
        File fileIn = new File("C:/Users/nikol/OneDrive/Skrivebord/heletal.txt");
        System.out.println(fileIn.exists());

        ArrayList<Integer> tal = new ArrayList<>();

        try(Scanner scan = new Scanner(fileIn)) {
            while (scan.hasNext()){
                int temp = scan.nextInt();
                tal.add(temp);
//                Collections.reverse(tal);
//                System.out.print(temp+ " ");
            }

        }  catch (IOException e) {
            // IOException er exception thrown når man vil have adgang til filer og mapper streams
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        System.out.println(tal);
        // det vil %4d betyder der skal være 4 tal til højre hvor -4 vil være mod venstre

        for(int i = tal.size() -1; i >= 0; i--){
            System.out.printf("%-4d",tal.get(i));
//            System.out.println(tal.get(i));
        }
        System.out.println();
        System.out.println(tal.size());
        System.out.println(fileIn.canRead());
        // ikke en mappe så skal være false
        System.out.println(fileIn.isDirectory());
    }

}

