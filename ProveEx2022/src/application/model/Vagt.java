package application.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Vagt {
    private String navn;
    private LocalDateTime tidFra;
    private LocalDateTime tidTil;
    private ArrayList<Antal> antaller = new ArrayList<>();
    private ArrayList<Medarbejder> medarbejders = new ArrayList<>();

    public Vagt(String navn, LocalDateTime tidFra, LocalDateTime tidTil) {
        this.navn = navn;
        this.tidFra = tidFra;
        this.tidTil = tidTil;
    }

    public String getNavn() {
        return navn;
    }

    public LocalDateTime getTidFra() {
        return tidFra;
    }

    public LocalDateTime getTidTil() {
        return tidTil;
    }

    public Antal createAntal(int antalPersoner) {
        Antal antal = new Antal(antalPersoner);
        antaller.add(antal);
        return antal;
    }

    public ArrayList<Medarbejder> getMedarbejders() {
        return new ArrayList<>(medarbejders);
    }

    public void addMedarbejder(Medarbejder medarbejder) {
        if (!medarbejders.contains(medarbejder)) {
            medarbejders.add(medarbejder);
            medarbejder.addVagt(this);
        }
    }

    public void rmoveMedarbejder(Medarbejder medarbejder) {
        if (medarbejders.contains(medarbejder)) {
            medarbejders.remove(medarbejder);
            medarbejder.removeVagt(this);
        }
    }

    public Medarbejder findMedarbejder(LocalTime tidspunkt, int antalTimer) {
        Medarbejder medarbejder = null;
        for (Medarbejder m : getMedarbejders()) {
            if (m.getAntalTimerPrDag() == antalTimer && m.getTypiskMødetid() == tidspunkt) {
                medarbejder = m;
            }
        }
        return medarbejder;
    }

    // Virke dårligt formuleret i opgave 3  vagten varighed er en Localdate det vil sige fra 12- 04 -2022 til
    // Til 13-04-2022 så menes der hele dagen  det vil sige 24 timer nej vel
    // hvad er varighed her er mit spørgsmål en vagt kan være en hel uge, men hvad er en uge i arbejds timer
    // arbejder alle 7.5 timer jeg vil gå ud fra vagten varighed er fraTid til tilTid som

    public int beregnTimeForbrug() {
        int count = medarbejders.size();
        int alleTimer = 0;
        alleTimer = tidTil.getHour() - tidFra.getHour() * count;
        return (int) Math.ceil(alleTimer * count);
    }

    public int antalMedarbejderMedFunktion(Funktion funktion){
        int antal = 0;
        for(Medarbejder m : medarbejders){
            for(Funktion f : m.getFunktioner()){
                if(funktion.equals(f)){
                    antal ++;
                }
            }
        }
        return antal;
    }
    
}

