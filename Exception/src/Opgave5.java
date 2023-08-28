import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Opgave5 {
    public static void main(String[] args) {

        String filNavn = "C://Users//nikol//OneDrive//Skrivebord//readingtal.txt";
        Scanner input = new Scanner(System.in);


        try(Scanner scan = new Scanner(System.in); PrintWriter printWriter = new PrintWriter(filNavn)) {
            System.out.println("Indtast tal afslut på -1 ");
            int indTastTal = input.nextInt();
            while (indTastTal != -1) {
                if (indTastTal > 0) {
                    printWriter.println(indTastTal);
                } else {
                    System.out.println("Skal være større end 0");
                }
                indTastTal = input.nextInt();
            }
            System.out.println("Filen er lavet");

        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        catch (InputMismatchException e){
            System.out.println("Du skal indtaste et tal");
        }
    }

    }

