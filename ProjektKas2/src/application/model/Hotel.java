package application.model;

import java.util.ArrayList;

public class Hotel {
    private String navn;
    private String adresse;
    private double prisDoubbelt;
    private double prisEnkelt;

    private ArrayList<Tillæg> tillægs = new ArrayList<>();

    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

    public Hotel(String navn, String adresse, double prisDoubbelt, double prisEnkelt) {
        this.navn = navn;
        this.adresse = adresse;
        this.prisDoubbelt = prisDoubbelt;
        this.prisEnkelt = prisEnkelt;
    }


    public Tillæg createTillæg(double pris, String navnTillæg){
        Tillæg tillæg = new Tillæg(pris,navnTillæg);
        tillægs.add(tillæg);
        return tillæg;
    }

    public ArrayList<Tillæg> getTillægs(){
        return new ArrayList<>(tillægs);
    }

    public ArrayList<Tilmelding> getTilmeldinger(){
        return new ArrayList<>(tilmeldinger);
    }


    public void addTilmeldinger(Tilmelding tilmelding){
        if(!tilmeldinger.contains(tilmelding)){
            tilmeldinger.add(tilmelding);
            tilmelding.setHotel(this);
        }
    }

    public void removeTilmedlinger(Tilmelding tilmelding){
        if(tilmeldinger.contains(tilmelding)){
            tilmeldinger.remove(tilmelding);
            tilmelding.setHotel(null);
        }
    }

    public double getPrisDoubbelt(){
        return prisDoubbelt;
    }

    public double getPrisEnkelt(){
        return prisEnkelt;
    }




    public String getHotelOversigt(){
        String string = " ";
        string = navn + "\nAdresse: " + adresse + "\nDobbelt " + prisDoubbelt + ", Enkelt " + prisEnkelt;

        for(Tilmelding element : tilmeldinger){
            string += "\n" + element.getDeltager().getNavn();
        }

        return string;

    }

    @Override
    public String toString() {
        return  navn;
    }
}
