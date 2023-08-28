package storage;

import apllication.model.Afdeling;
import apllication.model.Ansat;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Afdeling> afdelinger = new ArrayList<>();
    private static ArrayList<Ansat> ansatte = new ArrayList<>();


    public static ArrayList<Afdeling> getAfdelinger(){
        return new ArrayList<>(afdelinger);
    }

    public static void addAfdeling(Afdeling afdeling){
        afdelinger.add(afdeling);
    }
    public static void removeAfdeling(Afdeling afdeling){
        afdelinger.remove(afdeling);
    }

    public static ArrayList<Ansat> getAnsat(){
        return new ArrayList<>(ansatte);
    }

    public static void addAnsat(Ansat ansat){
        ansatte.add(ansat);
    }
    public static void removeAnsat(Ansat ansat){
        ansatte.remove(ansat);
    }


}
