package Opgave3;

public class Car {
    private String license;
    private double pricePerDay;
    private int purchaseYear;

    public Car(String license1,int purchaseYear1){
        this.license = license1;
        this.purchaseYear = purchaseYear1;
    }
    public void setDayPrice(double price){
        this.pricePerDay = price;
    }
    public double getDayPrice() {
        return pricePerDay;
    }

    public String getLicense() {
        return license;
    }



    public int getPurchaseYear() {
        return purchaseYear;
    }



}
