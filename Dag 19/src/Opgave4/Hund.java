package Opgave4;

public class Hund {
    private String name;
    private boolean stamtavle;
    private int pris;
    private Race race;

    public Hund(String name1, boolean stamtavle1,int pris1,Race race1){
        this.name = name1;
        this.stamtavle = stamtavle1;
        this.pris = pris1;
        this.race = race1;
    }

    public Race getRace(){
        return race;
    }
    public int getPris(){
        return pris;
    }


    public String getStamtavle(){
        String string = "";
        if(stamtavle){
            string = "Har Stamtavle";
        }else{
            string = "Har ikke stamtavle";
        }
        return string;
    }
}
