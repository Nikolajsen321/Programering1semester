package application.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {
    private LocalDate dato;
    private LocalTime tid;
    private boolean single;
    private Spiller spiller;
    private Bane bane;

     Booking(LocalDate dato, LocalTime tid, boolean single,Spiller spiller) {
        this.dato = dato;
        this.tid = tid;
        this.single = single;
        this.spiller = spiller;
    }

    public LocalDate getDato() {
        return dato;
    }

    public LocalTime getTid() {
        return tid;
    }

    public boolean isSingle() {
        return single;
    }

    public Bane getBane(){
         return bane;
    }
    public Spiller getSpiller(){
         return spiller;
    }

    public void setBane(Bane bane){
         if(this.bane != bane){
             Bane gammelBane = this.bane;
             if(gammelBane != null){
                 gammelBane.removeBookning(this);
             }
             this.bane = bane;
             if(bane != null){
                 bane.addBookning(this);
             }
         }

    }

    @Override
    public String toString() {
        String string =" bane "+  bane.getNummer() +" dato " + dato +
                ", tid=" + tid;
        if(single){
            string += " single";
        }else {
            string += " double";
        }
        if(bane.isInde()){
            string += " inde";
        }else {
            string += " ude";
        }
        return string;


    }

    public String udSkrivBookning(){
         String string = "";
         string = " Dato " + dato + " Kl " + tid + "Spiller " + spiller.getNavn() ;
         if(single){
             string += " Single";
         }else {
             string += " Double";
         }
         return string;

    }
}
