import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Opgave4 {
    public static void main(String[] args) {
        String fileNavn = "C://Users//nikol//OneDrive//Skrivebord//Datamatiker//programering//chekOmTalErI.txt";
        Scanner input = new Scanner(System.in);

        System.out.println("Skriv det tal du vil lede efter");
        int target = input.nextInt();

        if(linFileSearch(fileNavn,target)){
            System.out.println("tallet " + target + " er i filen");
        }else {
            System.out.println("tallet " + target + " er ikke i filen");
        }
    }
    private static boolean linFileSearch(String fileNavn, int target) {
        File fileFileNavn = new File(fileNavn);
        boolean isTheNumberThere = false;
        try (Scanner scanner = new Scanner(fileFileNavn)){
            while (scanner.hasNext() && isTheNumberThere == false){
                if(scanner.nextInt() == target){
                    isTheNumberThere = true;
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return  isTheNumberThere;
    }
}
