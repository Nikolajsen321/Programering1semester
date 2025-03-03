package applikation.model;

public class Plads {
    private int række;
    private int nr;
    private int pris;
    private PladsType pladsType;

    public Plads(int række, int nr, int pris, PladsType pladsType) {
        this.række = række;
        this.nr = nr;
        this.pris = pris;
        this.pladsType = pladsType;
    }

    public int getRække() {
        return række;
    }

    public void setRække(int række){
        this.række = række;
    }

    public int getNr() {
        return nr;
    }

    public int getPris() {
        return pris;
    }

    public PladsType getPladsType() {
        return pladsType;
    }

    @Override
    public String toString() {
            return "Række: " + række + "\n Nummer: " + nr + "\nPrice: " + pris+ "\n Plads type: " + pladsType;

    }
}
