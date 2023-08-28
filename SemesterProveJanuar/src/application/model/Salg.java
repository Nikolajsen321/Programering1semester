package application.model;

import java.util.ArrayList;

public class Salg {
    private String købersNavn;
    private int aftalteSamletPris;
    private ArrayList<Vare> varer = new ArrayList<>();

    public Salg(String købersNavn, int aftalteSamletPris,ArrayList<Vare> varer) {
        this.købersNavn = købersNavn;
        this.aftalteSamletPris = aftalteSamletPris;
        this.varer = varer;
        for(Vare vare : varer){
            vare.setSolgt(true);
            if(vare.getSalgsannonce() != null) {
                vare.getSalgsannonce().salgsAnnonceStadigAktiv();
            }

        }
    }

    public String getKøbersNavn() {
        return købersNavn;
    }

    public int getAftalteSamletPris() {
        return aftalteSamletPris;
    }

    public ArrayList<Vare> getVarer(){
        return new ArrayList<>(varer);
    }


    public String getBuyer() {
        int samletPris = 0;
        String string = købersNavn + ":" +"\n";


        for(Vare vare : varer){
            string += vare.getNavn() + vare.getUdbudspris() + "\n";
            samletPris += vare.getUdbudspris();
        }
        string += "Aftalt pris:" + aftalteSamletPris  + " " + "rabat er " + (samletPris - aftalteSamletPris);

        return string;
    }
}
