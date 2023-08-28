package Opgaver2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Opgave2 {
    public static void main(String[] args) {

        File fileIn = new File("C:/Users/nikol/OneDrive/Skrivebord/heletal.txt");

        try(Scanner scan = new Scanner(fileIn)) {

            while (scan.hasNext()){
                System.out.println(scan.nextInt() * 2);
            }
            scan.close();
        }  catch (IOException e) {
            System.out.println(e.getMessage());
        }

        }

    }


