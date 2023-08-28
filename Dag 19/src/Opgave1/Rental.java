package Opgave1;

import java.util.ArrayList;

public class Rental {
    private int number;
    private int days;
    private String date;
    private ArrayList<Car> cars = new ArrayList<>();

    public Rental(int number1,String date1,int days1){
        this.number = number1;
        this.date = date1;
        this.days = days1;

    }

    public double getPrice(){
        double prices = 0;
        for(Car element : cars){
           prices += element.getDayPrice() * days;
        }
        return prices;
    }


    public void setDays(int days1){
        this.days = days1;
    }

    public int getDays(){
        return days;
    }
    public ArrayList<Car> getCars(){
        return new ArrayList<>(cars);
    }

    public void addCar(Car car){
        if(!cars.contains(car)){
            cars.add(car);
            car.addRental(this);
        }
    }
    public void removeCar(Car car){
        if(cars.contains(car)){
            cars.remove(car);
            car.removeRental(this);
        }
    }


}
