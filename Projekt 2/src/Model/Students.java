package Model;

import java.util.Arrays;
import java.util.Random;

public class Students {
    private String name;
    private boolean active;
    private int[] grades = {};
    private char[] multiplechoiceAnswers;



    public Students()
    {

    }

    public Students(String name1, boolean active1, int[] grades1 ) {
        this.name = name1;
        this.active = active1;
        this.grades = grades1;
        multiplechoiceAnswers = new char[10];
        generateMultipleChoiceAnswers();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }




    public int[] getGrades() {
        return grades;
    }

    public int getHighestGrade()
    {
        int highestGrade = Integer.MIN_VALUE;
        for(int studentGrade : grades)
        {
            if(studentGrade > highestGrade)
            {
                highestGrade = studentGrade;
            }

        }
        return highestGrade;

    }

    public double averageGrade()
    {
        double average = 0;
        for(int element : grades )
        {
            average += element;
        }
         average /= grades.length;
        return average;
    }

    public void generateMultipleChoiceAnswers()
    {
        Random random = new Random();
        char answer;
        for(int i = 0; i < multiplechoiceAnswers.length; i++)
        {
            answer = (char) (random.nextInt(4) + 'A');
            multiplechoiceAnswers[i] = answer;
        }

    }

    public String getMultipleChoiceAnswers()
    {
        String string = "";
        for(char element : multiplechoiceAnswers)
        {
            string += element;
        }
        return string;
    }

    public int getcorrtAnswersS(char[] correct)
    {
        int correctAnswer1 = 0;
        for(int i = 0;i < multiplechoiceAnswers.length; i++)
        {
            if(multiplechoiceAnswers[i] == correct[i])
            {
                correctAnswer1 ++;
            }
        }
        return  correctAnswer1;
    }

    public char getMultiplechoiceAnswers(int i) {
        return multiplechoiceAnswers[i];

    }

    @Override
    public String toString() {
        String string = "{" +
                  name + '\'' +
                ", active =" + active +
                ", grades =" + Arrays.toString(grades) +
                " Highest grade " + getHighestGrade() +
                " Gennemsnitlig karakter " + averageGrade();


//                "Number of right answers" corrtAnswers();

        return string;

    }
}
