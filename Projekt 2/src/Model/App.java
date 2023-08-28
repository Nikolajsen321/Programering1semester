package Model;

public class App {
    public static void main(String[] args) {
        Team team1 = new Team("Team1","A1.32");
        Team team2 = new Team("Team2", "A1.36");
        Students student1 = new Students( "Karsten",true,new int[]{12,69,60});
        Students student2 = new Students( "Sten",true,new int[]{12,10}  );
        Students student3 = new Students( "Bent",true,new int[]{1200 - 15}  );
        Students student4 = new Students( "Martin",true,new int[]{1}  );
        Students student5 = new Students( "Morten",true,new int[]{0,0,0}  );
        Students student6 = new Students( "Søren",true,new int[]{ 99 * 99,69,69,420,911} );

        team1.addStudent(student1); team1.addStudent(student2); team1.addStudent(student3);
        team2.addStudent(student4); team2.addStudent(student5); team2.addStudent(student6);

        System.out.println(team1.toString());
        System.out.println();
        System.out.println(team2.toString());
        team1.removeStudent("Bent");
        team2.removeStudent("Søren");

        System.out.println();
        System.out.println(team1.toString());
        System.out.println();
        System.out.println(team2.toString());


        System.out.println("\nListe af gode studenter med gennemsnit over 4");
        System.out.println("Name" + "\t" + "Average grade");

         Students[] goodStudents = team1.highscoreStudent(4);
         for(Students s : goodStudents)
         {
             System.out.println(s.getName() +"\t" + "\t" + s.averageGrade());
         }

         student1.generateMultipleChoiceAnswers();
        System.out.println();
        System.out.println( student1.getcorrtAnswersS(team1.getCorrectAnswer()));
        System.out.println();

        String[] teams = team1.printTeam();
        System.out.println("Name" + "\t" + "average" + "\t\t" + " correctAnswers\t\t choices\t\trightAnswers");
        for(String t : teams)
        {
            System.out.println(t);
        }

        int[] correctAnswers = team1.countStudentCorrectAnswers();
        for(int i = 0; i < correctAnswers.length; i++)
        {
            if (correctAnswers[i] > 0 && correctAnswers[i] == 1) {
                System.out.println(correctAnswers[i] + " student have answered question " + (i+1) + " correct.");
            } else if (correctAnswers[i] >= 2) {
                System.out.println(correctAnswers[i] + " students have answered question " + (i+1) + " correct.");
            }

        }




    }


}
