import java.util.Scanner;
public class NewTeam {
    //Først invokes main method og en activation record laver og stacker main i et area af memory "call stack"
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println(" vælg venligst køn ");

        String gender = input.nextLine();

        System.out.println(" vælg venligst alder ");
        int alder = input.nextInt();

// Her benytter den så den metode jeg har lavet i main Hold den bliver called
        String holdet = Hold(alder,gender);

        System.out.println( " Barnet skal gå på holdet " + holdet );
    }
/*så laves en ny activation record  når den method er færdig fjernes den fra stacken i form first in lastout
 ind: main så Hold   ud: Hold så main  */
    public static String Hold(int age, String gen) {
        //String notgirl = " dreng ";
        //String girl = " pige ";

        String result = "";

        /* variable.equalsIgnoreCase er en String metode der sammenligner
         en String variable / eller " tekst/ ord "  er ens uden at
          tag højde for stor eller små bogstaver den ignore altså "the case of the letters" */

        if (age < 8 && gen.equalsIgnoreCase(" pige ")) {

            String team = " tumbling girls ";
            result = team;

        } else if (age < 8 && gen.equalsIgnoreCase("dreng")) {

            String team = "young cubs";
            result = team;

        } else if (age >= 8 && gen.equalsIgnoreCase("pige")) {

            String team = " Springy girls ";
            result = team;

        } else if(age >= 8 && gen.equalsIgnoreCase( "dreng")){

            String team = " Cool boys ";
            result = team;

        }
        /* returner værdi/teks til invokernen Hold i main programmet,
          og gemmer værdien som string i variablen holdet */

            return result;

    }
}



