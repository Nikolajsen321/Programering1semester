package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Udflugt {

    private String navn;
    private String lokation;
    private double pris;
    private LocalDate dato;
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();


    public Udflugt(String navn, String lokation, double pris, LocalDate dato) {
        this.navn = navn;
        this.lokation = lokation;
        this.pris = pris;
        this.dato = dato;
    }

  public void addTilmelding(Tilmelding tilmelding){
        if(!tilmeldinger.contains(tilmelding)){
            tilmeldinger.add(tilmelding);
            tilmelding.addUdflugt(this);
        }
  }


  public void removeTilmelding(Tilmelding tilmelding){
        if(tilmeldinger.contains(tilmelding)){
            tilmeldinger.remove(tilmelding);
            tilmelding.removeUdflugt(this);
        }

  }

  public double getPris(){
        return pris;
  }

    @Override
    public String toString() {
        return navn +  ", " + lokation + ", " + dato + ", " + pris + " kr.";

    }
}
