package Opgave2;

import java.util.ArrayList;

public class Person {
    private String name;
    private int age;
    private ArrayList<Gift> giftReciving = new ArrayList<>();



    public Person(String name1,int age1){
        this.name = name1;
        this.age = age1;
    }
    public ArrayList<Gift> recivedGifts(){
        return new ArrayList<>(giftReciving);
    }
    public void setAge(int age1){
        this.age = age1;
    }

    public void addGifts(Gift gift){
        if(!giftReciving.contains(gift)){
            giftReciving.add(gift);
        }
    }

    public void removeGifts(Gift gift){
        if(giftReciving.contains(gift)){
            giftReciving.remove(gift);
        }
    }

    public ArrayList<Gift> getGiftReciving(){
        return new ArrayList<>(giftReciving);
    }

    public double sumOfValueFromAllGifts(){
        double sumOfValues = 0;
        for(int i = 0; i < giftReciving.size(); i++) {
            sumOfValues += giftReciving.get(i).getPrice();
        }
        return sumOfValues;

    }

    public ArrayList<Person> givenBy(){
        ArrayList<Person> personGiven = new ArrayList<>();
        for(int i = 0; i < giftReciving.size(); i++) {
            personGiven.add(giftReciving.get(i).getGiftGiver());
        }
        return personGiven;
    }


    @Override
    public String toString(){
        String string = name + " der er " + age + " år";
        return string;
    }
}
