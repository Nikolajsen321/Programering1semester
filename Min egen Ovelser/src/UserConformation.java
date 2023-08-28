import java.util.Scanner;
public class UserConformation {
    // Sentinel value signifikere end of input  så det vil sige
    // et loop der bruger følgende kaldes sentinel - controlled loop
    public static void main(String[] args){
        /* der skal laves et program som bliver der aflæser og udregner sum for et uspecifik antal af nummer
         men skal stoppe hvis inputtet er 0*/

        Scanner input = new Scanner(System.in);

        // starter med initial data
        System.out.println(" Enter an integere (the input ends if it's 0): ");
        int data = input.nextInt();
// bliv ved med at læse til input er 0
        int sum = 0;
        int antal =1;
        while(data != 0){
            sum += data;
            // læs næste int
            System.out.println( antal + ":" + " Enter an integere (the input ends if it's 0): " + " og summen er"+
                   " " + sum);
            antal++;
            data = input.nextInt();


        }

        System.out.println(" Summen er " + sum);





    }

}


