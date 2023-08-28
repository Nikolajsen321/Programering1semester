import java.util.InputMismatchException;
import java.util.Scanner;

public class Opgave1 {
    public static void main(String[] args) {
            int[] prim = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

            try (Scanner scan = new Scanner(System.in)) {
                System.out.print("Hvilket nr. primtal skal vises?: ");
                int n = scan.nextInt();
                System.out.println("Primtal nr. " + n + " er "
                        + prim[n - 1] + "\n");
            } catch (ArrayIndexOutOfBoundsException ube){
                System.out.println("Den er ude for index længden 1- 10");
                ube.printStackTrace();

            }
            catch (InputMismatchException eM){
                System.out.println("Du har lavet noget som ikke er et tal");
            }

            catch (IllegalArgumentException iE){
                System.out.println("Forkert");
            }


            catch (Exception e){
                System.out.println("Der er  måske flere");
            }

//            finally {
//                System.out.println("Lukker ned");
//            }
        }
    }

