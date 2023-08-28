package applikation.model;

import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Forstilling {
    private String navn;
    private LocalDate startDato;
    private LocalDate slutDato;
    private ArrayList<Bestilling> bestilinger;

    public Forstilling(String navn1, LocalDate startDato1, LocalDate slutDato1){
        this.navn = navn1;
        this.startDato = startDato1;
        this.slutDato = slutDato1;

    }

    public String getNavn() {
        return navn;
    }


    public LocalDate getStartDato() {
        return startDato;
    }



    public LocalDate getSlutDato() {
        return slutDato;
    }




    public Bestilling createBestilling(LocalDate dato,Kunde kunde){
        Bestilling bestilling = new Bestilling(dato, this,kunde);
        bestilinger.add(bestilling);
        return bestilling;
    }



    public boolean erPladsLedig(int række,int nr, LocalDate dato){
        for(Bestilling bestilling : bestilinger){
            if(bestilling.getDato().equals(dato)){
                for(Plads plads : bestilling.getPladser()){
                    if(plads.getRække() == række && plads.getNr() == nr){
                        return false;
                    }
                }
            }
        }
        return true;
    }




    public int antalBestiltePladserPåDag(LocalDate dato){
        int bookedSæder = 0;
        for(int i = 0; i < bestilinger.size(); i++){
            if(dato.equals(bestilinger.get(i).getDato())){
                bookedSæder += bestilinger.get(i).getPladser().size();
            }
        }
        return bookedSæder;

    }

    public LocalDate succesDato(){
        LocalDate mostSuccesFuldDag = bestilinger.get(0).getDato();
        int flestSolgtePladser = bestilinger.get(0).getPladser().size();

        for(int i = 0; i < bestilinger.size(); i ++){
            Bestilling bestillinger = bestilinger.get(i);
            LocalDate orderDato = bestillinger.getDato();
            int pladserSolgt = bestillinger.getPladser().size();

            if(flestSolgtePladser < bestillinger.getPladser().size()){
                mostSuccesFuldDag = orderDato;
                flestSolgtePladser = pladserSolgt;

            }else if(flestSolgtePladser == flestSolgtePladser && !mostSuccesFuldDag.equals(orderDato)){
                mostSuccesFuldDag = orderDato;
            }
        }
        return mostSuccesFuldDag;
    }




    @Override
    public String toString() {
        return navn + " (Fra " + startDato + " Til " + slutDato +" )";
    }
}
