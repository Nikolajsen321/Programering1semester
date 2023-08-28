import java.util.Scanner;
public class Opgave3Investment {
    public static void main(String[] args){
        /* et program der fortæller hvor meget man har optjent ved at indsætte et hvis antal penge
        ved en konstant rate over x antal år
         */
        Scanner input = new Scanner(System.in);
        System.out.println(" indtast mængden af penge du vil indsætte");

        double indsatMængde = input.nextDouble();
        System.out.println(" indtast den rate som opsaringen har i decimal ");
        double procentRaten = input.nextDouble();
        System.out.println(" hvor mange år vil du kigge på? ");
        int antalAr = input.nextInt();

        double fortjening = intrestRate(indsatMængde,antalAr , procentRaten);
        System.out.println(" efter " + antalAr + " vil der være " + fortjening);
    }
    public static double intrestRate(double penge,int years, double monthlyrate){
        int i = 0;
        double sum = 0 ;
        double faktor1 = 0;
        double faktor2 = 0;
        double interestly = 0;

        while( i < years){
            double r =  monthlyrate;
            // procent pr. år
            faktor1 = (1 + r);
            faktor2 = faktor1;
            penge = penge * faktor1;
            faktor1 += faktor2;

//            faktor1 = faktor * monthlyrate+ faktor1 * monthlyrate;
//            faktor1 = faktor + faktor1 + (faktor1 * monthlyrate);

            i++;
        }

        return penge;
    }
}
