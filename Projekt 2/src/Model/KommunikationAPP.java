package Model;


import java.util.Scanner;
import java.util.SortedMap;

public class KommunikationAPP {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        int count = 0;
        int antal;
        String teamValg = "ja";
        String valg;
        String aktiv;
        String lokale;
        Team team1 = null;
        Students students1 = null;
        int[] karakterArray;
        Team[] teams = new Team[count];
        boolean aktivStatus = false;

        // Husk teamValg er sat til altid at være ja i starten for at den altid starter loop
        System.out.println("Vil du oprette et Team tast ja" +
                " ellers tast Nej");
        valg = input.nextLine();

        while(teamValg.equals("ja"))
        {

        if(teamValg.equals("ja"))
        {
            System.out.println("Hvad skal team hede? ");
            valg = input.nextLine();

            System.out.println("Hvad lokale skal team være i?");
            lokale = input.nextLine();



             // laver en ny temp hver gang der har 1+ indes i forhold til teams Array der holder alle teams
            // så derved kan Arrayen vokse for hver team
             Team[] temp = new Team[count +1];
            team1 = new Team(valg, lokale);

            // kopier gamle Array over i en ny Arry
            for(int j = 0; j < count; j++)
            {
                temp[j] = teams[j];
            }
            // teams bliver arrayen teams lig med den temp array
            teams = temp;
            // den nye index plads får plaveret team1
            teams[count] = team1;

            count++;


            System.out.println("Indtast antal studerende ");
            antal = input.nextInt();
            //Jeg benytter input.nextLine(); er for at den ikke springer min String navn = input.nextLine();
            //
            input.nextLine();


            for (int i = 0; i < antal; i++)
            {
                System.out.println("indtast navn");
                String navn = input.nextLine();

                System.out.println("Er studerende aktiv ja eller nej ");
                aktiv = input.nextLine();

                if (aktiv.equalsIgnoreCase("ja"))
                {
                    aktivStatus = true;
                } else
                {
                    aktivStatus = false;
                }

                System.out.println("Indtast karakter ");
                karakterArray = giveGrade();



                students1 = new Students(navn, aktivStatus, karakterArray);
                students1.generateMultipleChoiceAnswers();
                
                //Tilføjer student til det team der snakkes om
                team1.addStudent(students1);


            }

        }
            System.out.println("Vil du lave et ekstre team?");
            teamValg = input.nextLine();

        }




        System.out.println();
//        System.out.println( students1.corrtAnswers(team1.getCorrectAnswer()));
        int a = students1.getcorrtAnswersS(team1.getCorrectAnswer());

        for(int k = 0; k < teams.length; k++) {
            System.out.println(teams[k] );

        }

        System.out.println();

        System.out.println("Status for prøve ");
        String[] printTeam = team1.printTeam();

        System.out.println("Name" + "\t" + "average" + "\t\t" + "correctAnswers" + "\t\t" + "choice" +"\n");
        for(String t : printTeam)
        {
            System.out.println(t);
        }





    }


    private static int[] giveGrade() {
        System.out.println("Hvor mange karakter er der?");
        int antalKarakter = input.nextInt();
        input.nextLine();
        int[] karakterArray = new int[antalKarakter];

        for(int i = 0; i < karakterArray.length; i++)
        {
            System.out.println("Indtast din karakter " + (karakterArray.length - i));
            karakterArray[i] = input.nextInt();
        }
        input.nextLine();
        return karakterArray;

    }
}
