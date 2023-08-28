package guifx;

import applikation.controler.Controler;
import applikation.model.Forstilling;
import applikation.model.Kunde;
import applikation.model.Plads;
import applikation.model.PladsType;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    //Undskyld for stavefejl
    public static void main(String[] args) {
        initStorage();
//        testPrint();
        BestillingPane.launch(BestillingPane.class);

    }


    public static void initStorage() {

        LocalDate startEvita = LocalDate.of(2023, 8, 10);
        LocalDate endEvita = LocalDate.of(2023, 8, 20);

        LocalDate startLykkePer = LocalDate.of(2023, 9, 1);
        LocalDate endLykkePer = LocalDate.of(2023, 9, 10);

        LocalDate startChess = LocalDate.of(2023, 8, 21);
        LocalDate endChess = LocalDate.of(2023, 8, 30);


        Forstilling f1 = Controler.createForstilling("Evita", startEvita, endEvita);

        Controler.createForstilling("Lykke Per", startLykkePer, endLykkePer);

        Controler.createForstilling("Chess", startChess, endChess);

        Kunde kunde = Controler.createKunde("Anders Hansen", "11223344");
        Controler.createKunde("Peter Hansen", "12345678");

        Controler.createKunde("Niels Madsen", "12341234");


        System.out.println("Name: " + f1.getNavn() + "\nStart: " + f1.getStartDato() + "\nEnd: " + f1.getSlutDato());
        System.out.println(kunde.getNavn());
        System.out.println();
        System.out.println(Storage.getForstillinger());

        Plads plads;
        for (int i = 1; i <= 15; i++) {
            for (int j = 1; j <= 20; j++) {
                if (5 >= i) {
                    if (j < 3 || j > 18) {
                        plads = Controler.createPlads(i, j, 450, PladsType.STANDARD);
                    } else {
                        plads = Controler.createPlads(i, j, 500, PladsType.STANDARD);
                    }
                } else if (10 >= i && i > 5) {
                    if (j < 3 || j > 18) {
                        plads = Controler.createPlads(i, j, 400, PladsType.STANDARD);
                    } else if (i == 10 && j > 7 && j < 13) {
                        plads = Controler.createPlads(i, j, 450, PladsType.KØRESTOL);
                    }else {
                        plads = Controler.createPlads(i, j, 450, PladsType.STANDARD);
                    }
                } else {
                    if (i == 11 && j > 7 && j < 13) {
                        plads = Controler.createPlads(i, j, 400, PladsType.EKSTRABEN);
                    }else {
                        plads = Controler.createPlads(i, j, 400, PladsType.STANDARD);
                    }}
            }

        }



    }

//    public static void testPrint() {
//        Forstilling forstilling;
//        for (int i = 0; i < 3; i++) {
//            forstilling = Storage.getForstillinger().get(i);
//            System.out.println(forstilling.getNavn() + "StartDato: " + forstilling.getStartDato() + forstilling.getSlutDato());
//        }
//        System.out.println();
//        Kunde kunde;
//        for (int i = 0; i < 3; i++) {
//            kunde = Storage.getKunder().get(i);
//            System.out.println("Navn " + kunde.getNavn() + " MobilNr: " + kunde.getMobil());
//        }
//        ArrayList<Plads> pladser = Storage.getPladser();
//        for(int j = 0; j < pladser.size(); j++ ){
//            System.out.println("Række: " + pladser.get(j).getRække() + " PladsNr: " + pladser.get(j).getNr() +
//                    " \n PladsType " + pladser.get(j).getPladsType() + "\npris: " + pladser.get(j).getPris() + "\n");
//        }
//    }
    }



