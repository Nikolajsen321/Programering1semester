package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tilmelding {
    private LocalDate ankomstDato;
    private LocalDate afrejsningsDato;
    private boolean fordragsHolder;
    private Deltager deltager;
    private ArrayList<Tillæg> tillægs = new ArrayList<>();
    private Hotel hotel;
    private String ledsagerNavn;

    private Firma hvisFirma;

    private Konference konference;

    private ArrayList<Udflugt> udflugter = new ArrayList<>();


    public Tilmelding(LocalDate ankomstDato, LocalDate afrejsningsDato,boolean fordragsHolder,Konference konference) {
        this.ankomstDato = ankomstDato;
        this.afrejsningsDato = afrejsningsDato;
        this.fordragsHolder = fordragsHolder;
        this.konference = konference;

    }

    public Deltager getDeltager() {
        return deltager;
    }



    public boolean getFordragsHolder(){
        return fordragsHolder;

    }



    public Hotel getHotel() {
        return hotel;
    }

    public Firma getHvisFirma() {
        return hvisFirma;
    }

    public void setDeltager(Deltager deltager) {
        this.deltager = deltager;
    }

    public void setHotel(Hotel hotel) {
        if(this.hotel != hotel){
            Hotel gammelHotel = this.hotel;
            if(gammelHotel != null){
                gammelHotel.removeTilmedlinger(this);
            }
            this.hotel = hotel;
            if(hotel != null){
                hotel.addTilmeldinger(this);
            }
        }
    }






    public void setLedsagerNavn(String ledsagerNavn) {
        this.ledsagerNavn = ledsagerNavn;
    }

    public String getLedsagerNavn(){
        return ledsagerNavn;
    }

    public void setHvisFirma(Firma hvisFirma) {
        if(this.hvisFirma != hvisFirma){
            Firma gammelFirma = this.hvisFirma;
            if(gammelFirma != null){
                gammelFirma.remove(this);
            }
            this.hvisFirma = hvisFirma;
            if(hvisFirma != null){
                hvisFirma.addTilmelding(this);
            }
        }
    }

    public Firma getFirma(){
        return hvisFirma;
    }

    public ArrayList<Udflugt> getUdflugter(){
        return new ArrayList<>(udflugter);
    }


    public void addUdflugt(Udflugt udflugt){
        if(!udflugter.contains(udflugt)){
            udflugter.add(udflugt);
            udflugt.addTilmelding(this);
        }
    }

    public void removeUdflugt(Udflugt udflugt){
        if(udflugter.contains(udflugt)){
            udflugter.remove(udflugt);
            udflugt.removeTilmelding(this);
        }
    }


    public double getSamletPrisForHotelOgTillæg(){
        double sumPris = 0;
       if(hotel == null){
           sumPris = 0;
       }else {
           if (hotel.getPrisDoubbelt() != 0 || hotel.getPrisEnkelt() != 0) {
               if (ledsagerNavn != null) {
                   sumPris = hotel.getPrisDoubbelt();
               } else {
                   sumPris = hotel.getPrisEnkelt();
               }
               for (Tillæg element : tillægs) {
                   sumPris += element.getPris();
               }
           } else {
               sumPris = 0;
           }
       }
        return sumPris * (antalDage()-1) ;
    }

    public int antalDage(){
        int dagenAfrejsning =  afrejsningsDato.getDayOfMonth();
        int dagenAnkomst = ankomstDato.getDayOfMonth();

        return dagenAfrejsning - dagenAnkomst +1;
    }
    public double getKonferencePris(){
        double konferencePris = 0;
        if(fordragsHolder) {
            konferencePris = 0;
        }else {
            konferencePris = konference.getPris() * antalDage();
        }
        return konferencePris;
    }


    public double getUdflugtPris(){
       double sumUdflugtPriser = 0;

       for(Udflugt element : udflugter){
           sumUdflugtPriser += element.getPris();
       }
        return sumUdflugtPriser;
    }


    public double getSamletPrisForAlt(){
        return getSamletPrisForHotelOgTillæg() + getUdflugtPris() + getKonferencePris();
    }


    public void addTillæg(Tillæg tillæg) {
       tillægs.add(tillæg);
    }
}
