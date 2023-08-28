package application.model;

import java.util.ArrayList;

public class Frivillig {
  private String navn;
  private String mobil;
  private int maksAntalTimer;
  private ArrayList<Vagt> vagter = new ArrayList<>();

    public Frivillig(String navn, String mobil, int maksAntalTimer) {
        this.navn = navn;
        this.mobil = mobil;
        this.maksAntalTimer = maksAntalTimer;
    }

    public String getNavn() {
        return navn;
    }

    public String getMobil() {
        return mobil;
    }

    public int getMaksAntalTimer() {
        return maksAntalTimer;
    }

    public void addVagt(Vagt vagt){
        if(!vagter.contains(vagt)){
            vagter.add(vagt);
            vagt.setFrivillig(this);
        }
    }

    public void removeVagt(Vagt vagt){
        if(vagter.contains(vagt)){
            vagter.remove(vagt);
            vagt.setFrivillig(null);
        }
    }

    public int ledigeTimer(){
        int antalTimerTilbage = maksAntalTimer;
        for(Vagt element : vagter) {
            antalTimerTilbage -= element.getTimer();
        }
        return antalTimerTilbage;

    }


    public String udskrivFrivillig(){
      String string = navn;
      return string;
    }




}
