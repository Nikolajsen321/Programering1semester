package application.model;

public class Antal {
    private int antal;
    private Funktion funktion;

     Antal(int antal) {
        this.antal = antal;
    }



    public int getAntal() {
        return antal;
    }

    public Funktion getFunktion(){
         return funktion;
    }

    public void setFunktion(Funktion funktion){
         if(this.funktion != funktion){
             this.funktion = funktion;
         }
    }
}
