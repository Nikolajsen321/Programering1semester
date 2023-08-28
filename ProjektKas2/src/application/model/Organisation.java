package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Organisation {
    private String navn;
    private ArrayList<Konference> konerencer = new ArrayList<>();

    public Organisation(String navn1){
        this.navn = navn1;

    }

    public Konference createKonference(String navn, String lokation, LocalDate startDato,LocalDate slutDato, double pris){
        Konference konference = new Konference(navn,lokation,startDato,slutDato,pris);
        konerencer.add(konference);
        return konference;
    }

    public ArrayList<Konference> getKonerencer(){
        return new ArrayList<>(konerencer);
    }


    public void setNavn(String navn) {
        this.navn = navn;
    }
}
