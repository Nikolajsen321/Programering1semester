import java.util.Scanner;
public class NegativPoistivNul {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.println("indtast et nummer");
        int tal = input.nextInt();

        if( tal > 0 ){
            System.out.println("positiv");

        } else if( tal == 0 ){
            System.out.println("0");

        }else if(tal < 0){
            System.out.println(" negativ ");

        }



    }


}
