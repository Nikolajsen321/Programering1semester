package application.model;

public class Tillæg {
    private double pris;
    private String navnTillæg;
    public Tillæg(double pris, String navnTillæg) {
        this.pris = pris;
        this.navnTillæg = navnTillæg;
    }

    public double getPris() {
        return pris;
    }

    public String getNavnTillæg() {
        return navnTillæg;
    }

    @Override
    public String toString() {
        return navnTillæg + ", " + pris + "kr";
    }
}
