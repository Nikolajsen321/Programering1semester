package application.controller;

import application.model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    private static Organisation organisation;

    public static Organisation createOrganisation(String navn){
         organisation = new Organisation(navn);
        return organisation;
    }

    public static  Organisation getOrganisation(){
        return organisation;
    }

    public static void updateOrganisation(Organisation organisation, String navn){
        organisation.setNavn(navn);
    }


    public static Konference createKonference( String navn, String lokation, LocalDate startDato, LocalDate slutDato, double pris){
      Konference konference = organisation.createKonference(navn,lokation,startDato,slutDato,pris);
      return konference;
    }


    public static Tilmelding createTilmelding(Konference konference, LocalDate ankomstDato, LocalDate afrejsningsDato, boolean fordragsholder ){
        Tilmelding tilmelding = konference.createTilmelding(ankomstDato,afrejsningsDato,fordragsholder);
        return tilmelding;
    }

    public static void setDeltagerTilTilmelding(Tilmelding tilmelding,Deltager deltager){
        tilmelding.setDeltager(deltager);
    }




    public static Deltager createDeltager(String navn, int alder,String telefon,String adresse){
        Deltager deltager = new Deltager(navn,alder,telefon,adresse);
        Storage.addDeltager(deltager);
        return deltager;
    }
    public static Deltager createDeltager(Tilmelding tilmelding,String navn, int alder,String telefon,String adresse){
        Deltager deltager = createDeltager(navn,alder,telefon,adresse);
        tilmelding.setDeltager(deltager);
        return deltager;

    }



    public static Udflugt createUdflugt(String navn, String lokation, double pris,LocalDate dato) {
        Udflugt udflugt = new Udflugt(navn, lokation, pris, dato);
        Storage.addUdflugt(udflugt);
        return udflugt;
    }

    public static void addUdflugtTilKonference(Konference konference, Udflugt udflugt){
        konference.addUdflugt(udflugt);
    }


    public static Hotel createHotel(String navn,String adresse, double prisDouble,double prisEnkel){
        Hotel hotel = new Hotel(navn,adresse,prisDouble,prisEnkel);
        Storage.addHotel(hotel);
        return hotel;
    }


    public static ArrayList<Hotel> getHoteller(){
        return Storage.getHoteller();
    }

    public static void addHotelTilKonference(Konference konference, Hotel hotel){
        konference.addHotel(hotel);
    }

    public static Tillæg createTillæg(Hotel hotel,String navnTillæg,double pris){
        Tillæg tillæg = hotel.createTillæg(pris,navnTillæg);
        return tillæg;
    }

    public static Firma createFirma(String navn,String telefon,String mail){
        Firma firma = new Firma(navn,telefon,mail);
        Storage.addFirma(firma);
        return firma;
    }

    public static void addFirmaTilTilmelding(Firma firma, Tilmelding tilmelding){
        firma.addTilmelding(tilmelding);
    }



}
