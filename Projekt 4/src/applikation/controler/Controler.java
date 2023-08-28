package applikation.controler;

import applikation.model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controler {
    public static Forstilling createForstilling(String navn, LocalDate startDato, LocalDate slutDato) {
        Forstilling forstilling = new Forstilling(navn, startDato, slutDato);
        Storage.addForstiling(forstilling);
        return forstilling;
    }
    public static ArrayList<Forstilling> getForstillinger() {
        return Storage.getForstillinger();
    }

    public static Kunde createKunde(String navn, String mobil) {
        Kunde kunde = new Kunde(navn, mobil);
        Storage.addKunde(kunde);
        return kunde;
    }

    public static Plads createPlads(int række, int nr, int pris, PladsType pladsType) {
        Plads plads = new Plads(række, nr, pris, pladsType);
        Storage.addPlads(plads);
        return plads;
    }

    public static ArrayList<Plads> getPladser(){
        return Storage.getPladser();
    }




    public static Bestilling opretBestilling(Forstilling forstilling, Kunde kunde, LocalDate dato, ArrayList<Plads> pladser) {
        Bestilling bestilling = null;
        boolean state = true;
        boolean allsæderLedig = true;

        if (!dato.isBefore(forstilling.getStartDato()) || !dato.isAfter(forstilling.getSlutDato())) {
            bestilling = null;
            state = false;

        } else {
            for (Plads plads : pladser) {
                if (!forstilling.erPladsLedig(plads.getRække(), plads.getNr(), dato)) {
                   allsæderLedig = false;
                }
                if(!allsæderLedig){
                    bestilling = null;
                    state = false;
                }
            }
        }
        if(state) {
            bestilling = forstilling.createBestilling(dato, kunde);
            for (Plads plads : pladser) {
                bestilling.addPlads(plads);
            }
        }
        return bestilling;
    }
}