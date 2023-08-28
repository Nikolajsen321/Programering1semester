package Konto;

public class Konto {

    private double saldo;
    private double rente;
    private int kontoNr;

    private String navn;




    public Konto( String navn1, int kontoNr1, double saldo1, double rente1 )
    {
        this.navn = navn1;
        this.kontoNr = kontoNr1;
        this.saldo = saldo1;
        this.rente = rente1;
    }


    public String getNavn()
    {
        return navn;
    }

    public void setNavn( String navn1 )
    {
        this.navn = navn1;
    }

    public int getKontoNr()
    {
        return kontoNr;
    }


    public void setKontoNr( int kontoNr1)
    {
        this.kontoNr = kontoNr1;
    }

    public double getSaldo()
    {
        return saldo;
    }


    public void setSaldo( int saldo1)
    {
        this.saldo = saldo1;
    }


    public double getRente()
    {
        return rente;
    }


    public void setRente( double rente1)
    {
        this.rente = rente1;
    }

    public void udskrivKonto()
    {
        System.out.println("Navn: " + navn);
        System.out.println("KontoNr: " + kontoNr);
        System.out.println("Saldo: " + saldo);
        System.out.println("Rente: " + rente+"%");

    }

}

