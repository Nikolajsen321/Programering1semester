package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {

    private LocalDate date;
    private Show show;
    private ArrayList<Seat> seats = new ArrayList<>();
    private Customer customer;

    Order(LocalDate date, Show show, Customer customer) {
        this.date = date;
        this.show = show;
        customer.addOrder(this);
    }

    public LocalDate getDate() {
        return date;
    }

    public ArrayList<Seat> getSeats() {
        return new ArrayList<>(seats);
    }

    public Customer getCustomers() {
        return customer;
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
    }

    public void removeSeat(Seat seat) {
        seats.remove(seat);
    }

    public void setCustomer(Customer customer) {
        if (this.customer != customer) {
            Customer oldCustomer = this.customer;
            if (oldCustomer != null) {
                oldCustomer.removeOrder(this);
            }
            this.customer = customer;
            if (customer != null) {
                customer.addOrder(this);
            }
        }
    }

    public int totalPrice() {
        int totalPrice = 0;
        for (Seat s : seats) {
            totalPrice += s.getPrice();
        }
        return totalPrice;
    }

}
