package apllication.model;

import java.util.ArrayList;

public class Afdeling {
    private String by;
    private int telefonNr;
    private ArrayList<Biltype> biltyper;
    private ArrayList<Ansat> ansatte;


    public Afdeling(String by,int telefonNr){
        this.by = by;
        this.telefonNr = telefonNr;

    }

    public String getBy(){
        return by;
    }

    public void setBy(String by){
        this.by = by;
    }

    public int getTelefonNr(){
        return telefonNr;
    }

    public void setTelefonNr(int telefonNr){
        this.telefonNr = telefonNr;
    }


    @Override
    public String toString() {
        return "Afdeling" + by +
                ", telefonNr" + telefonNr;
    }

    public ArrayList<Ansat> getAnsatte(){
        return new ArrayList<>(ansatte);
    }

    public void addAnsat(Ansat ansat){
        if(!ansatte.contains(ansat)){
            ansatte.add(ansat);
        }
    }

    public void removeAnsat(Ansat ansat){
        if(ansatte.contains(ansat)){
            ansatte.remove(ansat);
        }
    }

//    Returner count af ansatte
    public int ansatCount(){
        return ansatte.size();
    }

    public ArrayList<Biltype> getBiltyper(){
        return new ArrayList<>(biltyper);
    }

    public void addBiltype(Biltype biltype){
        if(!biltyper.contains(biltype)){
            biltyper.add(biltype);
        }
    }

    public void removeBiltyper(Biltype biltype){
        if(biltyper.contains(biltype)){
            biltyper.remove(biltype);
        }
    }
}
