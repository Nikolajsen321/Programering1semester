package application.model;


import java.time.LocalDate;
import java.util.ArrayList;

public class Show {

    private final String name;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final ArrayList<Order> orders = new ArrayList<>();

    public Show(String name, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return name + " (Fra " + startDate + " til " + endDate + ")";
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public ArrayList<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    public Order createOrder(LocalDate dato, Customer customer) {
        Order order = new Order(dato, this, customer);
        orders.add(order);
        return order;
    }

    public boolean isSeatAvailable(int row, int nr, LocalDate date) {
        for (Order o : orders) {
            if (o.getDate().equals(date)) {
                for (Seat s : o.getSeats()) {
                    if (s.getRow() == row && s.getNr() == nr) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int amountOfBookedSeatsOnTheDay(LocalDate date) {
        int bookedSeats = 0;
        for (int i = 0; i < orders.size(); i++) {
            if (date.equals(orders.get(i).getDate())) {
                bookedSeats += orders.get(i).getSeats().size();
            }
        }
        return bookedSeats;
    }

    public LocalDate successDate() {
        LocalDate mostSuccessfulDate = orders.get(0).getDate();
        int mostSeatsSold = orders.get(0).getSeats().size();
        boolean multipleDates = false;

        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            LocalDate orderDate = order.getDate();
            int seatsSold = order.getSeats().size();
            if (seatsSold > mostSeatsSold) {
                mostSuccessfulDate = orderDate;
                mostSeatsSold = seatsSold;
                multipleDates = false;
            } else if (seatsSold == mostSeatsSold && !mostSuccessfulDate.equals(orderDate)) {
                multipleDates = true;
            }
        }

        if (multipleDates) {
            return null;
        } else {
            return mostSuccessfulDate;
        }
    }
}
