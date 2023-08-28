package Model;

import java.util.Arrays;

public class Team {
    private String name;
    private String room;

    private Students[] student = {};
    private  static final char[] correctAnswer = {'D', 'B', 'A', 'C', 'C','C','D','C','A','D'};
    private int studentIN = 0;



    public Team()
    {

    }
    public Team(String name1, String room1)
    {
        this.name = name1;
        this.room = room1;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {

        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }



    public void addStudent(Students student1)
    {

        // Metoden får input fra call'eren som skal være på den  studentIN +1  index plads
        //men først skal alt fra  student arrayed overføres til temp array, student array bliver så lig temå array reference
        // og den sidte plads der står null på  bliver til student[studentIN(+1)] index
        Students[] temp = new Students[studentIN +1];
        for(int i = 0; i < studentIN; i++)
        {
            temp[i] = student[i];
        }
        student = temp;
        student[studentIN] = student1;

        studentIN ++;

    }
    public void removeStudent(String name) {
        int place = -1;
        for (int i = 0; i < studentIN && place == -1; i++) {
            if (name.equals(student[i].getName())) {
                place = i;
            }
        }
        if( place != -1){
            studentIN --;
            Students[] temp = new Students[studentIN];
            for (int i = 0; i < studentIN; i++) {
                if (i < place) {
                    temp[i] = student[i];
                }else
                {
                    temp[i] = student[i + 1];
                }
            }
                student = temp;
        }
        else{
            System.out.println("Student not in team");
        }
    }


    public Students[] getStudent() {
        return student;
    }

    public int getStudentIN() {
        return studentIN;
    }

    public double teamAverage()
    {
        double teamAverage = 0;
        for(Students i :student )
        {
            teamAverage += i.averageGrade();
        }
       teamAverage = teamAverage / student.length;
        return teamAverage;
    }

    public Students[] highscoreStudent(double minAverage)
    {
        int highScore = 0;
        Students[] acvtiveStudents = new Students[studentIN];
        for(int i = 0; i < studentIN; i++)
        {
            if(student[i].isActive() && student[i].averageGrade() >= minAverage)
            {
                acvtiveStudents[highScore] = student[i];
                highScore++;
            }
        }
        return acvtiveStudents;

    }

    public  char[] getCorrectAnswer() {
        return correctAnswer;
    }

    public String getStringCorrectAnswers()
    {
        String string = "";
        for(char element : correctAnswer)
        {
            string +=  element;
        }
        return string;

    }

    public String[] printTeam()
    {
        int count = 0;
        String[] studerende = new String[student.length];
        for(Students element : student)
        {
            studerende[count] = element.getName() + "\t\t" + element.averageGrade() + "\t" + "\t"+ element.getcorrtAnswersS(correctAnswer)+
                    "\t\t\t\t" + element.getMultipleChoiceAnswers() + "\t\t" + getStringCorrectAnswers();
            count++;
        }
        return studerende;
    }

    public int[] countStudentCorrectAnswers()
    {
        int[] counterCorrectAnswers = new int[10];

        for (int i = 0; i < correctAnswer.length; i++)
        {
            for (int j = 0; j < student.length; j++)
            {
                if(correctAnswer[i] == student[j].getMultiplechoiceAnswers(i))
                {
                    counterCorrectAnswers[i] ++;
                }

            }


        }
        return counterCorrectAnswers;

    }





    @Override
    public String toString() {

              String string =
              name + ":" + "\n"+
              room + ":" +"\n" +
              "Students:";
              countStudentCorrectAnswers();

              for(Students element : student)
              {
                  string += "\n" + element.toString();
              }






//


              return string;
    }
}
