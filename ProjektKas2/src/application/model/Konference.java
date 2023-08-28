package application.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

public class Konference {
    String navn;
    String lokation;
    LocalDate startDato;
    LocalDate slutDato;
    double pris;
    ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();
    ArrayList<Udflugt> udflugter = new ArrayList<>();
    ArrayList<Hotel> hoteler = new ArrayList<>();

    Konference(String navn,String lokation,LocalDate startDato,LocalDate slutDato,double pris){
        this.navn = navn;
        this.lokation = lokation;
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.pris = pris;
    }

    public Tilmelding createTilmelding( LocalDate ankomstDato, LocalDate afrejsningsDato,boolean fordragsholder) {
        Tilmelding tilmelding = new Tilmelding(ankomstDato,afrejsningsDato,fordragsholder,this);
        tilmeldinger.add(tilmelding);
        return tilmelding;
    }

    public double getPris(){
        return pris;
    }


    public void addUdflugt(Udflugt udflugt){
        if(!udflugter.contains(udflugt)) {
            udflugter.add(udflugt);
        }

    }

    public void addHotel(Hotel hotel){
            hoteler.add(hotel);
        }


    public void removeHotel(Hotel hotel){
    hoteler.remove(hotel);
    }


    public ArrayList<Tilmelding> getTilmeldinger(){
        return new ArrayList<>(tilmeldinger);
    }

    public ArrayList<Udflugt> getUdflugter(){
        return new ArrayList<>(udflugter);
    }

    public ArrayList<Hotel> getHoteler(){
        return new ArrayList<>(hoteler);
    }


    public String konferenceOversigt(){
        String string = "";
        string = navn + " Startdato: " + startDato + " Slutdato: " + slutDato + "\nDeltager:";

        for(Tilmelding element : tilmeldinger){
            if(element.getFordragsHolder()) {
                string += "\n" + element.getDeltager().toString() + " (fordragsholder)" ;

            }else{
                string += "\n" + element.getDeltager().toString();
            }

            if(element.getFirma() != null){
                string += " Firma " + element.getFirma().getFirmaNavn();
            }


        }



        return string;

    }

    @Override
    public String toString() {
        return  navn;
    }

}













