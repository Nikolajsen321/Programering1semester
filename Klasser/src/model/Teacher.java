package model;
import model.Person;

public class Teacher extends Person {
    private double sallary;
    private int years;
    private double yearlySallary;
    private double totalSallary;


    public Teacher(String name, String address, String qualification, double sallary, int years) {

        super(name, address, qualification);

        this.sallary = sallary;
        this.years = years;
//        this.totalSallary = totalSallary();



    }

    public double getSallary() {
        return sallary;
    }

    public void setSallary(double sallary) {
        this.sallary = sallary;
    }

    public int getYears(){
        return years;
    }

    public void setYears( int years ){
        this.years = years;
    }


    private double yearlySallary(){
        double yearlySallary = sallary  * 12   * 1.125;
        return yearlySallary;
    }

    private double totalSallary(){
        yearlySallary = yearlySallary() * years;
        return yearlySallary;
    }


    public void udskrivAdresse() {
        System.out.println("Adresseoplysninger: " + address);

    }

    @Override
    public void udskrivPerson() { // løsning på udskriv, hvor vi
        // udnytter, at der er en udskriv i superklassen
        super.udskrivPerson(); // nødvendigt med super for ikke at kalde sig
        // selv.
        System.out.println("måneds lønnen er: " + sallary + " kr");
        System.out.println("efter " + years + " er der " + totalSallary());

    }
}
