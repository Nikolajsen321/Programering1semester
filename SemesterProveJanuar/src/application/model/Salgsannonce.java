package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Salgsannonce {
    private static int antalAnnoncer = 1;
    private  int annonceNummer;

    private boolean aktiv;
    private LocalDate udløbsdato;
    private Sælger sælger;
    private ArrayList<Vare> varer = new ArrayList<>();

     Salgsannonce(){
        this.annonceNummer += antalAnnoncer;
        antalAnnoncer++;

    }

     Salgsannonce(Sælger sælger) {
        this();
        this.aktiv = true;
        this.udløbsdato = LocalDate.now().plusMonths(1);
        this.sælger = sælger;
    }

    public boolean isAktiv() {
        return aktiv;
    }

    public void setSælger(Sælger sælger1){
        if(this.sælger != sælger1){
            Sælger gammelSælger = this.sælger;
            if(gammelSælger != null){
                gammelSælger.removeSalgsannonce(this);
            }
            this.sælger = sælger1;
            if(sælger1 != null){
                sælger.addSalgsannonce(this);
            }
        }
    }

    public Sælger getSælger(){
        return sælger;
    }

    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }

    public int getAntalAnnoncer() {
        return antalAnnoncer;
    }

    public LocalDate getUdløbsdato() {
        return udløbsdato;
    }

    public ArrayList<Vare> getVarer(){
        return new ArrayList<>(varer);
    }
    public void addSalgsannonce(Vare vare){
        if(!varer.contains(vare)){
            varer.add(vare);
            vare.setSalgsannonce(this);
        }
    }

    public void addVarer(Vare vare){
        if(!varer.contains(vare)){
            varer.add(vare);
            vare.setSalgsannonce(this);
        }
    }

    public void removeVarer(Vare vare) {
        if(varer.contains(vare)){
            varer.add(vare);
            vare.setSalgsannonce(null);
        }
    }

    public int samletAnnonceUdbud(){
        int samletPris = 0;
        for(Vare v : varer){
           samletPris += v.getUdbudspris();
        }
        return samletPris;
    }

    public void salgsAnnonceStadigAktiv(){
        int count = 0;
        boolean udløbet = false;

        for (Vare vare : varer) {
            if (vare.isSolgt()) {
                count++;
            }
        }

        if(this.udløbsdato==LocalDate.now()){
            udløbet = true;
        }

        if(count==varer.size() || udløbet){
            this.aktiv=false;
        }

    }


    @Override
    public String toString() {
        return  annonceNummer + " " +sælger +
                " "+ udløbsdato;
    }
}
