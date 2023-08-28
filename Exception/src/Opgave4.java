import filer.PrintWriterTal;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Opgave4 {
    public static void main(String[] args) {
        String fileName = "C://Users//nikol//OneDrive//Skrivebord//addblok";

        try(Scanner scan = new Scanner(System.in); PrintWriter printWriter = new PrintWriter(fileName)) {

            for(int i = 0; i < 100; i++){
                if( i % 2 != 0) {
                    printWriter.println(i);
                }
            }

            System.out.println("Færdig");


        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
