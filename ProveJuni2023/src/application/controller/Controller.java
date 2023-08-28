package application.controller;

import application.model.Bane;
import application.model.Booking;
import application.model.Kategori;
import application.model.Spiller;
import storage.Storage;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    public static Spiller createSpiller(String navn, String uddanelse){
        Spiller spiller = new Spiller(navn,uddanelse);
        Storage.addSpiler(spiller);
        return spiller;
    }

    public static Booking createBookning(LocalDate dato, LocalTime tid, boolean single, Spiller spiller){
       Booking booking = spiller.createBookning(dato,tid,single);
        return booking;
    }
    public static Bane createBane(int nummer, boolean inde, LocalTime førsteTid, LocalTime sidsteTid, Kategori kategori){
        Bane bane = new Bane(nummer,inde,førsteTid,sidsteTid,kategori);
        Storage.addBane(bane);
        return bane;
    }

    public static Kategori createKategori(String navn, int prisKrSingle, int prisKrDouble){
        Kategori kategori = new Kategori(navn,prisKrSingle,prisKrDouble);
        Storage.addKategori(kategori);
        return kategori;
    }

    public static int samletBooketDouble(String uddanelse, Kategori kategori){
        int samletPris = 0;
        for(Spiller s : Storage.getSpiller()){
            if(s.getUddanelse().equals(uddanelse)){
                for(Booking b : s.getBookninger()){
                    if(!b.isSingle()){
                       samletPris += b.getBane().getKategori().getPrisKrDouble();
                    }
                }
            }
        }
        return samletPris;
    }
    public static Bane findLedigBane(LocalDate date,LocalTime time,Kategori kategori){
        boolean found =  true;
        Bane ledigeBane = null;
        int i = 0;
        while (found && i < Storage.getBaner().size() ){
            if(Storage.getBaner().get(i).tidLedig(date,time) &&
                    Storage.getBaner().get(i).getKategori().equals(kategori )){
                found = false;
                ledigeBane = Storage.getBaner().get(i);
            }
            i++;


        }
        return ledigeBane;
    }

    public static void udSkrivTiltekstfil(String filNavn){
        ArrayList<Bane> baner = new ArrayList<>(Storage.getBaner());
        try(Scanner scan = new Scanner(System.in); PrintWriter printWriter = new PrintWriter(filNavn)) {
            for(Bane b : baner){
                printWriter.println(b.udskrivBane());
            }
            System.out.println("Færdig");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
