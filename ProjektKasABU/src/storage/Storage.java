package storage;

import application.model.Deltager;
import application.model.Firma;
import application.model.Hotel;
import application.model.Udflugt;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Deltager> deltagers = new ArrayList<>();
    private static ArrayList<Hotel> hoteller = new ArrayList<>();
    private static ArrayList<Udflugt> udflugter = new ArrayList<>();
    private static ArrayList<Firma> firmaer = new ArrayList<>();


    public static ArrayList<Deltager> getDeltager(){
        return new ArrayList<>(deltagers);
    }

    public static void addDeltager(Deltager deltager){
        deltagers.add(deltager);
    }

    public static void removeDeltager(Deltager deltager){
        deltagers.remove(deltager);
    }

    public static ArrayList<Hotel> getHoteller(){
        return new ArrayList<>(hoteller);
    }

    public static void addHotel(Hotel hotel){
        hoteller.add(hotel);
    }

    public static void removeHotel(Hotel hotel){
        hoteller.remove(hotel);
    }


    public static ArrayList<Udflugt> getUdflugter(){
        return new ArrayList<>(udflugter);
    }

    public static void addUdflugt(Udflugt udflugt){
        udflugter.add(udflugt);
    }

    public static void removeUdflugt(Udflugt udflugt){
        udflugter.remove(udflugt);
    }

    public static ArrayList<Firma> getFirmaer(){
        return new ArrayList<>(firmaer);
    }

    public static void addFirma(Firma firma){
        firmaer.add(firma);
    }

    public static void removeFirma(Firma firma){
        firmaer.remove(firma);
    }


}

