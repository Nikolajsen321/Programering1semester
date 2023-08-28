package application.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Bane {
    private int nummer;
    private boolean inde;
    private LocalTime førsteTid;
    private LocalTime sidsteTid;
    private ArrayList<Booking> bookinger = new ArrayList<>();

    private Kategori kategori;


    public Bane(int nummer, boolean inde, LocalTime førsteTid, LocalTime sidsteTid,Kategori kategori) {
        this.nummer = nummer;
        this.inde = inde;
        this.førsteTid = førsteTid;
        this.sidsteTid = sidsteTid;
        this.kategori = kategori;
    }

    public int getNummer() {
        return nummer;
    }

    public boolean isInde() {
        return inde;
    }

    public LocalTime getFørsteTid() {
        return førsteTid;
    }

    public LocalTime getSidsteTid() {
        return sidsteTid;
    }
    public ArrayList<Booking> getBookinger(){
        return new ArrayList<>(bookinger);
    }

    public void addBookning(Booking booking){
        if(!bookinger.contains(booking)){
            bookinger.add(booking);
            booking.setBane(this);
        }
    }

    public void removeBookning(Booking booking){
        if(bookinger.contains(booking)){
            bookinger.remove(booking);
            booking.setBane(null);
        }
    }

    public Kategori getKategori(){
        return kategori;
    }
    //Spørgsmålet er lidt forvirrende det jeg ikke helt ved her om de mener tiden førsteTid og sidsteTid,
    // Der nævnes ikke godt nok, så jeg går ud fra det alle tidere på bookningerne
    public int bookedeTimerPåDato(LocalDate dato){
        int samlettid = 0;
        for(Booking b : bookinger){
            if(b.getDato().isEqual(dato)){
                samlettid += b.getTid().getHour();
            }
        }
        return samlettid;

    }
    // jeg synes opgave beskrivelsen her var meget kluderet, og min opfattelse af hvad man skulle,
    // var ikke det der ønskes som jeg fandt ud af da vi havde 10 min tilbage derfor har jeg ikke
    // kunne nå at fikse den for skal bruge lidt tid på at løse den
    public int[] antalBookningPrTime(){
       int antalTimerÅben = sidsteTid.getHour() - førsteTid.getHour();
       int[] listMedAntalBookninger = new int[antalTimerÅben +1];


        for(int i = 0; i < bookinger.size(); i++) {
            LocalTime tid = sidsteTid;
            if(bookinger.get(i).getTid().isAfter(LocalTime.of(8,59))&& bookinger.get(i).getTid().isBefore(LocalTime.of(17,01))){
                listMedAntalBookninger[ bookinger.get(i).getTid().getHour() - førsteTid.getHour()]++;
            }
        }
        return listMedAntalBookninger;
    }

    public boolean tidLedig(LocalDate dato, LocalTime tid){
        boolean found = true;
        int i = 0;
        while(found && i < bookinger.size()){
            LocalTime k = bookinger.get(i).getTid();
            LocalDate c = bookinger.get(i).getDato();
            if(k.equals(tid) && c.equals(dato)){
                found = false;
            }
            i++;
        }
        return found;
    }

    public String udskrivBane(){
        String string = "";
        string = "Bane nr: " + nummer  +" kateogri " + kategori;
               for(Booking b : bookinger){
                   string += "\n" + b.udSkrivBookning() ;
               }
        if(inde){
            string+= " Inde";
        }else {
            string+= " Ude";
        }
        return string;

    }


    @Override
    public String toString() {
        String string = "";
               string = "Bane nr: " + nummer + " ("+førsteTid + "->" + sidsteTid +
                       ")" +" kateogri " + kategori;
//               for(Booking b : bookinger){
//                   string += "\n" + b.udSkrivBookning() ;
//               }
               if(inde){
                   string+= " Inde";
               }else {
                   string+= " Ude";
               }
               return string;
    }

}
