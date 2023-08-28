package Konto;

public class Børneopsparing extends Konto
{
    private String forældre;

    public Børneopsparing(String navn1,String forældre1, int kontoNr1,double saldo1, double rente1)
    {
        super(navn1,kontoNr1,saldo1,rente1);
        this.forældre = forældre1;

    }

    public String getForældre()
    {
        return forældre;
    }
    public void setForældre(String forældre1)
    {
        this.forældre = forældre1;
    }


    @Override
    public void udskrivKonto()
    {
        System.out.println("Forældre: " + forældre);
        super.udskrivKonto();
    }
}
