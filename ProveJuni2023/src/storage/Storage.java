package storage;

import application.model.Bane;
import application.model.Kategori;
import application.model.Spiller;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Spiller> spillers = new ArrayList<>();
    private static ArrayList<Bane> baner = new ArrayList<>();
    private static ArrayList<Kategori> kategorier = new ArrayList<>();

    public static ArrayList<Spiller> getSpiller(){
        return new ArrayList<>(spillers);
    }
    public static void addSpiler(Spiller spiller){
        spillers.add(spiller);
    }
    public static ArrayList<Bane> getBaner(){
        return new ArrayList<>(baner);
    }
    public static void addBane(Bane bane){
        baner.add(bane);
    }
    public static ArrayList<Kategori> getKategorier(){
        return new ArrayList<>(kategorier);
    }
    public static void addKategori(Kategori kategori){
        kategorier.add(kategori);
    }


}
