package applikation.model;

import java.time.LocalDate;
import java.util.ArrayList;
import applikation.model.Plads;

public class Kunde {
    private String navn;
    private String mobil;
    private ArrayList<Bestilling> bestillinger;

    public Kunde(String navn, String mobil) {
        this.navn = navn;
        this.mobil = mobil;
    }

    public String getNavn() {
        return navn;
    }

    public String getMobil() {
        return mobil;
    }

    public ArrayList<Bestilling> getBestillinger() {
        return new ArrayList<>(bestillinger);
    }

     void addBestilling(Bestilling bestilling){
        if(!bestillinger.contains(bestilling)){
            bestillinger.add(bestilling);
        }

    }

    void removeBestilling(Bestilling bestilling){
        if(bestillinger.contains(bestilling)){
            bestillinger.remove(bestilling);
        }

    }

    public ArrayList<Plads> bestilttePladserTilForStillingPåDag(Forstilling forstilling, LocalDate dato){
        ArrayList<Plads> bestiltePladserForKunde = new ArrayList<>();
        for(Bestilling bestilling : bestillinger) {
            if (bestilling.getDato().equals(dato) && bestilling.getForstilling().equals(forstilling)) {
                bestiltePladserForKunde.addAll(bestilling.getPladser());
            }
        }
        return bestiltePladserForKunde;
    }

    @Override
    public String toString() {
        return "Navn " + navn + " mobiNr " +"("  + mobil + ")";
    }
}

