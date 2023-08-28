package application.model;

public class Deltager {
    private String navn;
    private int alder;
    private String telefon;
    private String adresse;

    public Deltager(String navn, int alder, String telefon, String adresse) {
        this.navn = navn;
        this.alder = alder;
        this.telefon = telefon;
        this.adresse = adresse;
    }

    public String getNavn(){
        return navn;
    }


    @Override
    public String toString() {
        return
                "navn " + navn +
                " alder " + alder +
                " telefon " + telefon +
                " adresse " + adresse;
    }
}
