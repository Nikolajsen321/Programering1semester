package application.model;

public class Seat {

    private final int row;
    private final int nr;
    private final int price;
    private final SeatType seatType;

    public Seat(int row, int nr, int price, SeatType seatType) {
        this.row = row;
        this.nr = nr;
        this.price = price;
        this.seatType = seatType;
    }

    @Override
    public String toString() {
        return "Row " + row + " nr: " + nr + " (kr " + price + " " + seatType + ")";
    }

    public int getRow() {
        return row;
    }

    public int getNr() {
        return nr;
    }

    public int getPrice() {
        return price;
    }

    public SeatType getSeatType() {
        return seatType;
    }
}
