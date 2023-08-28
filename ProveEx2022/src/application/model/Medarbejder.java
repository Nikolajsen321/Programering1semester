package application.model;

import java.time.LocalTime;
import java.util.ArrayList;

public class Medarbejder {
    private String navn;
    private int antalTimerPrDag;
    private LocalTime typiskMødetid;
    private ArrayList<Funktion> funktioner = new ArrayList<>();
    private ArrayList<Vagt> vagter = new ArrayList<>();

    public Medarbejder(String navn, int antalTimerPrDag, LocalTime typiskMødetid) {
        this.navn = navn;
        this.antalTimerPrDag = antalTimerPrDag;
        this.typiskMødetid = typiskMødetid;
    }


    public String getNavn() {
        return navn;
    }

    public int getAntalTimerPrDag() {
        return antalTimerPrDag;
    }

    public LocalTime getTypiskMødetid() {
        return typiskMødetid;
    }

    public ArrayList<Funktion> getFunktioner(){
        return new ArrayList<>(funktioner);
    }
    public void addFunktion(Funktion funktion){
        funktioner.add(funktion);
    }

    public void removeFunktion(Funktion funktion){
        funktioner.remove(funktion);
    }

    public ArrayList<Vagt> getVagter(){
        return new ArrayList<>(vagter);
    }
    public void addVagt(Vagt vagt){
        if(!vagter.contains(vagt)){
            vagter.add(vagt);
            vagt.addMedarbejder(this);
        }
    }

    public void removeVagt(Vagt vagt){
        if(vagter.contains(vagt)){
            vagter.remove(vagt);
            vagt.rmoveMedarbejder(this);
        }
    }


}
