package application.model;

public class Vare {
    private Varekategori varekategori;
    private String navn;
    private int udbudspris;
    private boolean solgt;
    private Salgsannonce salgsannonce;


    public Vare(Varekategori varekategori, String navn,int udbudspris) {
        this.varekategori = varekategori;
        this.navn = navn;
        this.udbudspris = udbudspris;
        this.solgt = false;
    }

    public Varekategori getVarekategori() {
        return varekategori;
    }

    public String getNavn() {
        return navn;
    }

    public int getUdbudspris() {
        return udbudspris;
    }


    public boolean isSolgt() {
        return solgt;
    }

    public void setUdbudspris(int udbudspris) {
        this.udbudspris = udbudspris;
    }



    public void setSolgt(boolean solgt) {
        this.solgt = solgt;
    }

    public Salgsannonce getSalgsannonce(){
        return salgsannonce;
    }


    public void setSalgsannonce(Salgsannonce salgsannonce) {
        if(this.salgsannonce != salgsannonce){
            Salgsannonce gammelSalgsannoce = this.salgsannonce;
            if(gammelSalgsannoce != null){
                gammelSalgsannoce.removeVarer(this);
            }
            this.salgsannonce = salgsannonce;
            if(salgsannonce != null){
                salgsannonce.addVarer(this);
            }
        }
    }

    @Override
    public String toString() {
        String string = navn + " "+ udbudspris;

        if(solgt){
            string+= " Solgt";
        }else {
            string += " til salg";
        }

        return string;
    }
}
