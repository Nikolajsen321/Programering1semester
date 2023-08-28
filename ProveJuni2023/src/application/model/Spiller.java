package application.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Spiller {
    private String navn;
    private String uddanelse;
    private ArrayList<Booking> bookninger = new ArrayList<>();

    public Spiller(String navn, String uddanelse) {
        this.navn = navn;
        this.uddanelse = uddanelse;
    }

    public Booking createBookning(LocalDate dato, LocalTime tid, boolean single){
        Booking booking = new Booking(dato,tid,single,this);
        bookninger.add(booking);
        return booking;
    }

    public ArrayList<Booking> getBookninger(){
        return new ArrayList<>(bookninger);
    }

    public String getNavn() {
        return navn;
    }

    public String getUddanelse() {
        return uddanelse;
    }


    public int samletPris(Kategori kategori){
        int samletPris = 0;
        for(Booking b : bookninger){
            if(b.getBane().getKategori().equals(kategori)){
                samletPris += b.getBane().getKategori().getPrisKrDouble()
                        + b.getBane().getKategori().getPrisKrSingle();

            }
        }
        return samletPris;
    }

    @Override
    public String toString() {
        return  navn;
    }
}
