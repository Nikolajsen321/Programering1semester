package Game;

import java.util.Random;
import java.util.Scanner;

public class Player {
    private String name;
    private int age;
    private int score;
    Random random;

    public Player(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;



    }

    @Override
    public String toString(){
        return ("Player " + name + " score is " + score);

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge()  {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore()  {
        return score;
    }

//    public void setScore(int score) {
//        this.score = score;
//    }



}
