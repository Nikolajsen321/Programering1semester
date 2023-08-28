package Opgave1;

import java.util.ArrayList;

public class Car {
    private String license;
    private double pricePerDay;
    private int purchaseYear;
    ArrayList<Rental> rentals = new ArrayList<>();

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

    public void addRental(Rental rental){
        if(!rentals.contains(rental)){
            rentals.add(rental);
            rental.addCar(this);
        }
    }
    public void removeRental(Rental rental){
        if(rentals.contains(rental)){
            rentals.remove(rental);
            rental.removeCar(this);
        }
    }


    public String getLicense() {
        return license;
    }



    public int getPurchaseYear() {
        return purchaseYear;
    }

    public int longestDaysRented(){
        int highestDaysRented = 0;

        for(int i = 0; i < rentals.size(); i++) {
            if(highestDaysRented < rentals.get(i).getDays())
            highestDaysRented = rentals.get(i).getDays();
        }
        return highestDaysRented;
    }


}
