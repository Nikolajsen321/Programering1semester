package application.gui;

import application.controller.Controller;
import application.model.Show;
import application.model.Customer;
import application.model.Seat;
import application.model.SeatType;
import application.storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        initStorage();
        testPrint();
        OrderPane.launch(OrderPane.class);
    }


    public static void initStorage() {

        LocalDate startEvita = LocalDate.of(2023, 8, 10);
        LocalDate endEvita = LocalDate.of(2023, 8, 20);

        LocalDate startLykkePer = LocalDate.of(2023, 9, 1);
        LocalDate endLykkePer = LocalDate.of(2023, 9, 10);

        LocalDate startChess = LocalDate.of(2023, 8, 21);
        LocalDate endChess = LocalDate.of(2023, 8, 30);

        Show f1 = Controller.createShow("Evita", startEvita, endEvita);

        Controller.createShow("Lykke Per", startLykkePer, endLykkePer);

        Controller.createShow("Chess", startChess, endChess);

        Customer customer = Controller.createCustomer("Anders Hansen", "11223344");
        Controller.createCustomer("Peter Hansen", "12345678");

        Controller.createCustomer("Niels Madsen", "12341234");

        System.out.println("Name: " + f1.getName() + "\nStart: " + f1.getStartDate() + "\nEnd: " + f1.getEndDate());
        System.out.println(customer.getName());
        System.out.println();
        System.out.println(Storage.getShows());

        Seat seat;
        for (int i = 1; i <= 15; i++) {
            for (int j = 1; j <= 20; j++) {
                if (5 >= i) {
                    if (j < 3 || j > 18) {
                        seat = Controller.createSeat(i, j, 450, SeatType.STANDARD);
                    } else {
                        seat = Controller.createSeat(i, j, 500, SeatType.STANDARD);
                    }
                } else if (10 >= i && i > 5) {
                    if (j < 3 || j > 18) {
                        seat = Controller.createSeat(i, j, 400, SeatType.STANDARD);
                    } else if (i == 10 && j > 7 && j < 13) {
                        seat = Controller.createSeat(i, j, 450, SeatType.WHEELCHAIR);
                    } else {
                        seat = Controller.createSeat(i, j, 450, SeatType.STANDARD);
                    }
                } else {
                    if (i == 11 && j > 7 && j < 13) {
                        seat = Controller.createSeat(i, j, 400, SeatType.EXTRALEGROOM);
                    } else {
                        seat = Controller.createSeat(i, j, 400, SeatType.STANDARD);
                    }
                }
            }

        }

    }

    public static void testPrint() {
        Show show;
        for (int i = 0; i < 3; i++) {
            show = Storage.getShows().get(i);
            System.out.println(show.getName() + "StartDate: " + show.getStartDate() + show.getEndDate());
        }
        System.out.println();
        Customer customer;
        for (int i = 0; i < 3; i++) {
            customer = Storage.getCustomers().get(i);
            System.out.println("Name " + customer.getName() + " MobileNr: " + customer.getMobile());
        }
        ArrayList<Seat> seats = Storage.getSeats();
        for (int j = 0; j < seats.size(); j++ ){
            System.out.println("Row: " + seats.get(j).getRow() + " SeatNr: " + seats.get(j).getNr() +
                    " \n SeatType " + seats.get(j).getSeatType() + "\nprice: " + seats.get(j).getPrice() + "\n");
        }
    }
}

