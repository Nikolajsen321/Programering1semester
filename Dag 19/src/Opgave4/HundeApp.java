package Opgave4;

import java.util.ArrayList;
import java.util.SortedMap;

public class HundeApp {
    public static void main(String[] args) {
        int pris = 0;

        Hund hund1 = new Hund("Hans",true,10000, Race.BOKSER);
        Hund hund2 = new Hund("Benny",true, 2000,Race.PUDDEL);
        Hund hund3 = new Hund("Karsten",false,2000,Race.TERRIER);
        Hund hund4 = new Hund("Rex",true,1000,Race.BOKSER);
        ArrayList<Hund> hunde = new ArrayList<>();

        hunde.add(hund1);
        hunde.add(hund2);
        hunde.add(hund3);
        hunde.add(hund4);

        System.out.println(samledePris(hunde,Race.TERRIER));
        System.out.println(samledePris(hunde,Race.BOKSER));
        

        }

    public static int samledePris(ArrayList<Hund> hunde ,Race race){
        int samledePrisForRace = 0;
        for(Hund element : hunde){
            if(element.getRace() == race){
                samledePrisForRace += element.getPris();
            }
        }
        return samledePrisForRace;

    }
}
