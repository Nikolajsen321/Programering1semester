package application.model;

import java.util.ArrayList;

public class Firma {
    private String firmaNavn;
    private String telefon;
    private String mail;
    private ArrayList<Tilmelding> ansatte = new ArrayList<>();

    public Firma(String firmaNavn, String telefon, String mail) {
        this.firmaNavn = firmaNavn;
        this.telefon = telefon;
        this.mail = mail;
    }

    public void addTilmelding(Tilmelding ansat){
        if(!ansatte.contains(ansat)){
            ansatte.add(ansat);
            ansat.setHvisFirma(this);
        }
    }

    public void remove(Tilmelding ansat) {
        if(ansatte.contains(ansat)){
            ansatte.remove(ansat);
            ansat.setHvisFirma(null);

        }

    }

    public String getFirmaNavn(){
        return firmaNavn;
    }
}
