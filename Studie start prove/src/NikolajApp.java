import java.util.Scanner;

public class NikolajApp {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Indtast navn: ");
        String navn = input.nextLine();

        System.out.println("Indtast løn: ");
        int lon = input.nextInt();

        input.nextLine();

        System.out.println("Indtast alder: ");
        int alder = input.nextInt();


        if(alder >= 50)
        {
            lon *= 1.1;
        }else if( alder < 35 )
        {
            lon *= 1.05;
        }else
        {
            lon *= 1.08;
        }
        System.out.println(navn + " " + "Nye løn er " + lon);


    }
}
