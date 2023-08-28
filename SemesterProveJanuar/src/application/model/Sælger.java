package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Sælger {
    private String navn;
    private int studiekortNummer;
    private String mobil;
    private ArrayList<Salgsannonce> salgsannoncer = new ArrayList<>();

    public Sælger(String navn, int studiekortNummer, String mobil) {
        this.navn = navn;
        this.studiekortNummer = studiekortNummer;
        this.mobil = mobil;
    }


    public String getNavn() {
        return navn;
    }

    public int getStudiekortNummer() {
        return studiekortNummer;
    }

    public String getMobil() {
        return mobil;
    }

    public ArrayList<Salgsannonce> getSalgsannoncer(){
        return new ArrayList<>(salgsannoncer);
    }

    public Salgsannonce createSalgsAnnoce(){
        Salgsannonce salgsannonce = new Salgsannonce(this);
        salgsannoncer.add(salgsannonce);
        return salgsannonce;
    }


    public void addSalgsannonce(Salgsannonce salgsannonce){
        if(!salgsannoncer.contains(salgsannonce)){
            salgsannoncer.add(salgsannonce);
            salgsannonce.setSælger(this);
        }
    }


    public void removeSalgsannonce(Salgsannonce salgsannonce){
        if(salgsannoncer.contains(salgsannonce)){
            salgsannoncer.remove(salgsannonce);
            salgsannonce.setSælger(null);
        }

    }
    public ArrayList<Vare> alleIkkeSolgteVarerIkKategori(Varekategori varekategori){
        ArrayList<Vare> vares = new ArrayList<>();
        for(Salgsannonce salgsannonce : salgsannoncer){
              for(Vare vare : salgsannonce.getVarer()){
                  if(salgsannonce.isAktiv() && vare.isSolgt() == false && vare.getVarekategori() == varekategori)
                      vares.add(vare);
                  }
              }
        return vares;
        }

    @Override
    public String toString() {
        return  navn;
    }
}


