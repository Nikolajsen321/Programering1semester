package Konto;

public class UngKonto extends Konto {
    private String forælreNavn;

    public UngKonto(String navn1, String forælreNavn1, int kontoNr1,double saldo1, double rente1)
    {
        super(navn1,kontoNr1,saldo1,rente1); // kalder constructor 1 i Superklassen  Konto

        this.forælreNavn = forælreNavn1;
    }

    public String getForælreNavn()
    {
        return forælreNavn;
    }

    public void setForælreNavn(String forælreNavn1)
    {
        this.forælreNavn = forælreNavn1;
    }

    @Override
    public void udskrivKonto() // udnytter der er en udskriv i super klassen
    {
        System.out.println("Forældre: " + forælreNavn);
        super.udskrivKonto();  // super sørg for at den ikke kalder sig selv men superklassen
    }

}
