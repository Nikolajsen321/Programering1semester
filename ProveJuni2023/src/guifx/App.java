package guifx;

import application.controller.Controller;
import application.model.Bane;
import application.model.Booking;
import application.model.Kategori;
import application.model.Spiller;
import javafx.application.Application;

import java.time.LocalDate;
import java.time.LocalTime;

public class App {
    public static void main(String[] args) {
        initStorage();
        Application.launch(Guifx.class);
    }

    private static void initStorage() {
        Kategori k1 = Controller.createKategori("Luksus",100,200);
        Kategori k2 = Controller.createKategori("Mellem",50,120);
        Kategori k3 = Controller.createKategori("Begynder",25,50);


        LocalTime startTid = LocalTime.of(9,0,0,0);
        LocalTime  slutTid = LocalTime.of(17,0,0,0);

        Bane b1 = Controller.createBane(1,true,startTid,slutTid,k1);
        Bane b2 = Controller.createBane(2,true,startTid,slutTid,k1);
        Bane b3 = Controller.createBane(3,true,startTid,slutTid,k2);
        Bane b4 = Controller.createBane(4,false,startTid,slutTid,k2);
        Bane b5 = Controller.createBane(5,false,startTid,slutTid,k3);
        Bane b6 = Controller.createBane(6,false,startTid,slutTid,k3);

        Spiller s1 = Controller.createSpiller("Andreas","DMU");
        Spiller s2 = Controller.createSpiller("Petra","DMU");
        Spiller s3 = Controller.createSpiller("Henrik","ITA");
        Spiller s4 = Controller.createSpiller("Ulla","ITA");


       Booking bk1 = s1.createBookning(LocalDate.of(2023,06,20),
               LocalTime.of(10,0),true);
       Booking bk2 = s1.createBookning(LocalDate.of(2023,06,22),
               LocalTime.of(10,0),false);

       bk1.setBane(b3);
       bk2.setBane(b2);

       Booking bk3 = s3.createBookning(LocalDate.of(2023,06,20),
               LocalTime.of(11,0),false);
       bk3.setBane(b3);
       Booking bk4 = s4.createBookning(LocalDate.of(2023,06,20),
               LocalTime.of(16,0),false);
       bk4.setBane(b3);
       Booking bk5 = s4.createBookning(LocalDate.of(2023,06,23),
               LocalTime.of(17,0),true);
       bk5.setBane(b5);

       String filNavn = "C:\\Users\\nikol\\OneDrive\\Skrivebord\\TekstfilProve.txt";
       Controller.udSkrivTiltekstfil(filNavn);


        System.out.println(Controller.findLedigBane(LocalDate.of(2023,06,
                20),LocalTime.of(10,00),k2));





    }
}
