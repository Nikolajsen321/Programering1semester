package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Konference {
    String navn;
    String lokation;
    LocalDate startDato;
    LocalDate slutDato;
    double pris;
    ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();
    ArrayList<Udflugt> udflugter = new ArrayList<>();
    ArrayList<Hotel> hoteler = new ArrayList<>();

    Konference(String navn, String lokation, LocalDate startDato, LocalDate slutDato, double pris) {
        this.navn = navn;
        this.lokation = lokation;
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.pris = pris;
    }

    public Tilmelding createTilmelding(LocalDate ankomstDato, LocalDate afrejsningsDato, boolean fordragsholder) {
        Tilmelding tilmelding = new Tilmelding(ankomstDato, afrejsningsDato, fordragsholder, this);
        tilmeldinger.add(tilmelding);
        return tilmelding;
    }

    public double getPris() {
        return pris;
    }


    public void addUdflugt(Udflugt udflugt) {
        if (!udflugter.contains(udflugt)) {
            udflugter.add(udflugt);
        }

    }

    public void addHotel(Hotel hotel) {
        hoteler.add(hotel);
    }


    public void removeHotel(Hotel hotel) {
        hoteler.remove(hotel);
    }


    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }

    public ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<>(udflugter);
    }

    public ArrayList<Hotel> getHoteler() {
        return new ArrayList<>(hoteler);
    }


    @Override
    public String toString() {
        return navn;
    }

    public String konferenceOversigt() {
        String string = "";
        string = navn + "\nStartdato: " + startDato + "\nSlutdato: " + slutDato +  "\nPris Pr Dag: " +
                pris +"\n-----------------------------------\nDeltager:";

        for (Tilmelding element : tilmeldinger) {
            if (element.getFordragsHolder()) {
                string += "\n" + element.getDeltager().toString() + "\nEr fordragsholder";

            } else {
                string += "\n" + element.getDeltager().toString();
            }

            if (element.getLedsagerNavn() != null) {
                string += "\nLedsager: " + element.getLedsagerNavn();
            }

           string += "\nPris i alt " + element.getSamletPrisForAlt();

            if (element.getFirma() != null) {
                string += "\nFirma: " + element.getFirma().getFirmaNavn();
            }
            string += "\n-----------------------------------";

        }
        return string;
    }
}













