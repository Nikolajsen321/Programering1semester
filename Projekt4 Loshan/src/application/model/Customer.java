package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Customer {

    private final String name;
    private final String mobile;
    private final ArrayList<Order> orders = new ArrayList<>();

    public Customer(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return name + "(" + mobile + ")";
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public ArrayList<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    void addOrder(Order order) {
        if (!orders.contains(order)) {
            orders.add(order);
            order.setCustomer(this);
        }
    }

    void removeOrder(Order order) {
        if (orders.contains(order)) {
            orders.remove(order);
            order.setCustomer(this);
        }
    }

}
