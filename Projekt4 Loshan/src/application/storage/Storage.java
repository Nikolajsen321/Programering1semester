package application.storage;

import application.model.Order;
import application.model.Show;
import application.model.Customer;
import application.model.Seat;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Show> shows = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Seat> seats = new ArrayList<>();
    private static ArrayList<Order> orders = new ArrayList<>();

    public static ArrayList<Show> getShows() {
        return new ArrayList<>(shows);
    }

    public static void addShow(Show show) {
        shows.add(show);
    }

    public static void removeShow(Show show) {
        shows.add(show);
    }

    public static ArrayList<Customer> getCustomers() {
        return new ArrayList<>(customers);
    }

    public static void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public static void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    public static void addSeat(Seat seat) {
        seats.add(seat);
    }

    public static void removeSeat(Seat seat) {
        seats.remove(seat);
    }

    public static ArrayList<Seat> getSeats() {
        return new ArrayList<>(seats);
    }

    public static ArrayList<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    public static void createOrder(Order order) {
        orders.add(order);
    }

    public static void deleteOrder(Order order) {
        orders.remove(order);
    }

}
