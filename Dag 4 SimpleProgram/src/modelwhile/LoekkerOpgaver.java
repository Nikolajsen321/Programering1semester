
package modelwhile;
import java.util.Scanner;
public class LoekkerOpgaver {

    public static void main(String[] args) {

//        Kald af metoder der afprøver opgave 1

//        System.out.println(summerEven(100));
        System.out.println(summerEven(100));

        System.out.println(summerSquare(10));
        System.out.println(sumOdd(3, 19));

        allPowers(20);

        Scanner input = new Scanner(System.in);
        System.out.println(" indtast et tal på mere end eller mindst 3 cifre ");
        int scan = input.nextInt();

        System.out.println( sumDigits(scan));

        System.out.println( sumOddDigits(scan));


    }

    // Metoden returnerer summen af alle lige tal mellem 2 og n
    public static int summerEven(int n) {
        int result = 0;
        int sum = 0;
        int i = 2;

        while(i <= n){
            if( i % 2 == 0){
                sum = sum + i;
            }
            i++;

        }
        // TODO Opgave 1.a
        return sum;
    }

    // Metoden returnerer summen af alle kvdrater mellem 1*1 og n*n
    public static int summerSquare(int n) {
        int sum = 0;
        int i = 1;

        while(i<=n){
            sum = sum + i * i;
            i++;

        }

        // TODO Opgave 1.b
        return sum;
    }

    // Metoden returnerer summen af alle ulige tal mellem a og b
    public static int sumOdd(int a, int b) {
        int sum = 0;

        while(a <= b){
            if( a % 2 != 0){
                sum = sum +a;
            }
            a++;
        }

        // TODO Opgave 1.c
        return sum;
    }

    // Metoden udskriver 2 potenser fra  f
    public static void allPowers(int n) {
        int i = 0;
        int sum = 0;
        int count = 1;

        while(i <= n){
                count = count *2;
                System.out.println(count);

            i ++;
        }

        // TODO Opgave 1.d
    }
    public static int sumDigits( int p ){
        int dig = 0;
        int sum = 0 ;

        while( p > 0){
            dig = p % 10;
            sum = sum + dig;
            p = p / 10;
        }
        return sum;

    }
    public static int sumOddDigits( int x){
        int i = 1;
        int dig = 0;
        int sum = 0;

        while( x > 0 ) {

            if(x % 2 !=0){
                dig = x % 10;
                sum = sum + dig;
            }
            x = x/10;
        }
        return sum;
    }
}
