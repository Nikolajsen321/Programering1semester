import java.util.Scanner; // Scanner er i java.util package  (import class)
public class KeyboardVariable {
    public static void main(String[] args){
        /* for at sende ud på skærm bruger Java System.out til at henvise til standard output device
        Hvor System.in er et standard input device som et keyboard,
        for at lave console input skal man bruge Scanner class for at lave et objekt der læser input fra
        system in på følenge måde */
        Scanner input = new Scanner (System.in);  // (Create a Scanner) input bliver declared en variable hvis type er scanner
        /* Syntax: new Scanner(System.in) laver et objekt af Scanner typen
         Hele Syntax: Scanner input = new Scanner(System.in)  laver et Scanner objekt og assinger reference til
         variable  input */
        /* Et objekt kan invoke dens metode, det er at få den til ugøre en opgave
          her er det dobule nextDouble() der gør man læse en double værdien som: */
        double radius = input.nextDouble();  /* (read double) bruges til at læse variablen,
        læser fra keyboard assinger til variable radius */
        // (Compute = udregning) af areal A = r^2 * pi
        double area = radius * radius * 3.14159;
        //Display result
        System.out.println("The area for the cirle of radius " +
                radius + " is "+ area);

        // her fungere + både som addition og som en concatening (forbinde fx to string ind til 1

    }
}


/* variable som radius og area corrospond til memory location for at declare en variable vælger man en specfik data type
fx int, real numbers,  osv.  det den type der lagers i variablen
java giver simpel data types ( kaldet primitive data types / fundamental types) -
  - for at repræsentere integers, real numbers, bogstaver, og Boolean types
  "floating point numbers"( Real numbers (tal med decimal))  metoden kendt som "floating point"
 */

    /* import java.util.Scanner; kaldes en Specfik import, da man specfier en single class
    i import statement
    Wildcard import  importer alle class i packagen ved at bruge import java.util. *;
    der ingen performanve forskel på dem
     */

/* Identifiers fx i ComputeAverage class filen, er ComputeAverage, main, input, number1 osv
er navnet for ting der appear i programmet, de kaldes for identiffiers følger reglerne:
1. sequence af characters der indholder letters, digits, underscores ( _ )  og dollar tegn ( $ )
2. skal starte med letter, ( _ ), ( $ )  kan ikke starte med digigt (tal)
3. Kan ikke være et reserved word Reserved words har specifik mening i Java, ex Keyword er reserved word
4. En identifier kan være af hvilken som helt længde
 */
