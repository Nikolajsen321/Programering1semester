package application.controller;

import application.model.*;
import application.storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    public static Show createShow(String name, LocalDate startDate, LocalDate endDate) {
        Show show = new Show(name, startDate, endDate);
        Storage.addShow(show);
        return show;
    }

    public static void deleteShow(Show show) {
        Storage.removeShow(show);
    }

    public static ArrayList<Show> getShow() {
        return Storage.getShows();
    }

    public static Customer createCustomer(String name, String mobile) {
        Customer customer = new Customer(name, mobile);
        Storage.addCustomer(customer);
        return customer;
    }

    public static void deleteCustomer(Customer customer) {
        Storage.removeCustomer(customer);
    }

    public static ArrayList<Customer> getKunder() {
        return Storage.getCustomers();
    }

    public static Seat createSeat(int row, int nr, int price, SeatType seatType) {
        Seat seat = new Seat(row, nr, price, seatType);
        Storage.addSeat(seat);
        return seat;
    }

    public static ArrayList<Seat> getSeats() {
        return Storage.getSeats();
    }

    public static Order createOrderWithSeats(Show show, Customer customer, LocalDate date, ArrayList<Seat> seats) {
        Order order = null;
        boolean state = true;
        boolean allSeatsAvailable = true;

        if (!date.isAfter(show.getStartDate()) || !date.isBefore(show.getEndDate())) {
            order = null;
            state = false;
        } else {
            for (Seat s : seats) {
                if (!show.isSeatAvailable(s.getRow(), s.getNr(), date)) {
                    allSeatsAvailable = false;
                }
            }
            if (!allSeatsAvailable) {
                order = null;
                state = false;
            }
        }
        if (state) {
            order = show.createOrder(date, customer);
            for (Seat s : seats) {
                order.addSeat(s);
            }
        }
        return order;
    }
}
