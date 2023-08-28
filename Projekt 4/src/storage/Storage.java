package storage;

import applikation.model.Bestilling;
import applikation.model.Forstilling;
import applikation.model.Plads;
import applikation.model.Kunde;

import java.util.ArrayList;

public class Storage {

    private static ArrayList<Forstilling> forstillinger = new ArrayList<>();
    private static ArrayList<Kunde> kunder = new ArrayList<>();
    private static ArrayList<Plads> pladser = new ArrayList<>();



    public static ArrayList<Forstilling> getForstillinger(){
        return new ArrayList<>(forstillinger);
    }
    public static void addForstiling(Forstilling forstilling){
        forstillinger.add(forstilling);
    }
    public static void removeForstiling(Forstilling forstilling){
        forstillinger.remove(forstilling);
    }

    public static ArrayList<Kunde> getKunder(){
        return new ArrayList<>(kunder);
    }
    public static void addKunde(Kunde kunde){
        kunder.add(kunde);
    }
    public static void removeKunde(Kunde kunde){
        kunder.remove(kunde);
    }

    public static ArrayList<Plads> getPladser(){
        return new ArrayList<>(pladser);
    }
    public static void addPlads(Plads plads){
        pladser.add(plads);
    }
    public static void removePlads(Plads plads){
        pladser.remove(plads);
    }




}
