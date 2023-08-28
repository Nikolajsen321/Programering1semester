package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Job {
    private String kode;
    private String beskrivelse;
    private LocalDate dato;
    private int timeHonorar;
    private int antalTimer = 0;
    private ArrayList<Vagt> vagter = new ArrayList<>();

    Job(String kode, String beskrivelse, LocalDate dato, int timeHonorar, int antalTimer) {
        this.kode = kode;
        this.beskrivelse = beskrivelse;
        this.dato = dato;
        this.timeHonorar = timeHonorar;
        this.antalTimer = antalTimer;
    }


    public String getKode() {
        return kode;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public LocalDate getDato() {
        return dato;
    }

    public int getTimeHonorar() {
        return timeHonorar;
    }

    public int getAntalTimer() {
        return antalTimer;
    }

    public Vagt createVagt(int timer){
        Vagt vagt = new Vagt(timer,this);
        vagter.add(vagt);
        return vagt;
    }


    public ArrayList<Vagt> getVagter(){
        return new ArrayList<>(vagter);
    }




    public int ikkeBesatteTimer(){
        int timerTilbage = antalTimer;
        for(Vagt element : vagter){
           timerTilbage -=element.getTimer();
        }
        return timerTilbage;
    }

}
