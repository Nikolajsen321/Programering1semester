import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Opgave6 {
    public static void main(String[] args) {
      String filNavn = "C:/Users/nikol/OneDrive/Skrivebord/Datamatiker/programering/Opgave6.txt";
        try {
            PrintWriter printWriter = new PrintWriter(filNavn);

            // indlaes antal tal i filen
            Scanner scan = new Scanner(System.in);
            System.out.print("Antal tal der skal skrives i filen: ");
            int antal = scan.nextInt();

            // skab tilfældige tal generator Random
            Random rnd = new Random();

            // generer og skriv de tilfældige tal
            for (int n = 1; n <= antal; n++) {
                int tal = rnd.nextInt(1000);
                printWriter.println(tal);
            }

            printWriter.println();

            // skriv filen
            printWriter.close();
            System.out.println("Højest tal er "+max(filNavn));
            System.out.println("Mindste tal er " + minmum(filNavn));
            scan.close();

            System.out.println("Filen er lavet");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


    public static int max(String fileNavn) throws IOException {
        File fil = new File(fileNavn);
        Scanner scanner = new Scanner(fil);
        int biggest = 0;
        while (scanner.hasNext()) {
            int temp = scanner.nextInt();
            if (biggest < temp) {
                biggest = temp;
            }
        }
        return biggest;
    }

    public static int minmum(String fileNavn) throws IOException {
        File fil = new File(fileNavn);
        Scanner scanner = new Scanner(fil);
        int biggest = scanner.nextInt();
        while (scanner.hasNext()) {
            int temp = scanner.nextInt();
            if (biggest > temp) {
                biggest = temp;
            }
        }
        return biggest;
    }



}
