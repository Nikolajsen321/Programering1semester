package applikation.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bestilling {
    private LocalDate dato;
    private Forstilling forstilling;
    private ArrayList<Plads> pladser;
    private Kunde kunde;


     Bestilling(LocalDate dato1,Forstilling forstilling,Kunde kunde){
        this.dato = dato1;
        this.forstilling = forstilling;
        this.kunde = kunde;
        kunde.addBestilling(this);
    }

    public LocalDate getDato() {
        return dato;
    }

    public void addPlads(Plads plads){
         pladser.add(plads);
    }

    public void removePlads(Plads plads){
         pladser.add(plads);
    }

    public Kunde getKunde() {
        return kunde;
    }

    public ArrayList<Plads> getPladser(){
        return new ArrayList<>(pladser);
    }

    public void setKunde(Kunde kunde) {
         if(this.kunde != kunde) {
             Kunde gammelKunde = this.kunde;
             if(gammelKunde != null){
                 gammelKunde.removeBestilling(this);
             }
             this.kunde = kunde;
             if(kunde != null){
                 kunde.addBestilling(this);
             }
         }
    }
    public int samletPris(){
         int samletPrisForBestilling = 0;
         for(int i = 0; i < pladser.size(); i ++){
             samletPrisForBestilling += pladser.get(i).getPris();
         }
         return samletPrisForBestilling;

    }

    public Forstilling getForstilling() {
        return forstilling;
    }
}
