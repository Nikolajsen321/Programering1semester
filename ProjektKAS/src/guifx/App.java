package guifx;

import application.controller.Controller;
import application.model.*;
import javafx.application.Application;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        initStorage();
        Application.launch(StartWindow.class);
    }

    public static void initStorage(){
       Organisation organisation = Controller.createOrganisation("Miljø");
        LocalDate start = LocalDate.of(2023,12,18);

        LocalDate slut = LocalDate.of(2023,12,20);
        Hotel h1 = Controller.createHotel("Den Hvide Svane","Adresse1",1250,1050);
        Tillæg tillæg1H1 = Controller.createTillæg(h1,"Wifi",50);


        Hotel h2 = Controller.createHotel("Høtel Phønix","Adresse2",800,700);
        Tillæg tillæg1H2 = Controller.createTillæg(h2,"Wifi",75);
        Tillæg tillæg2H2 = Controller.createTillæg(h2,"Bad",200);


        Hotel h3 = Controller.createHotel("Pension Tusindfryd","Adresse3",600,500);
        Tillæg tillæg1H3 = Controller.createTillæg(h3,"Morgenmad",100);




        Udflugt u1 = Controller.createUdflugt("Byrundtur","Odense",125,LocalDate.of(2023,05,18));
        Udflugt u2 = Controller.createUdflugt("Egeskov","",75,LocalDate.of(2023,05,19));
        Udflugt u3 = Controller.createUdflugt("Trapholt Museum","Kolding",200,LocalDate.of(2023,05,20));


        Konference konference1 = Controller.createKonference("Hav og Himmel","Odense Uni",start,slut,1500);
        Konference konference2 = Controller.createKonference("Natur og Kreatur","Skoven",start,slut,1300);

        Tilmelding tilmelding1 = Controller.createTilmelding(konference1,start,slut,false);
        Tilmelding tilmelding2 = Controller.createTilmelding(konference1,start,slut,false);
        Tilmelding tilmelding3 = Controller.createTilmelding(konference1,start,slut,false);
        Tilmelding tilmelding4 = Controller.createTilmelding(konference1,start,slut,true);




        Deltager deltager1 = Controller.createDeltager(tilmelding1,"Finn Madsen",55,"32322332","by");

        Deltager deltager2 = Controller.createDeltager(tilmelding2,"Niels Petersen",55,"3443","by2");
        h1.addTilmeldinger(tilmelding2);

        Deltager deltager3 = Controller.createDeltager(tilmelding3,"Peter Sommer",55,"23223","by3");
        tilmelding3.setLedsagerNavn("Mia Sommer");
        h1.addTilmeldinger(tilmelding3);
        tilmelding3.addTillæg(tillæg1H1);
        tilmelding3.addUdflugt(u2);
        tilmelding3.addUdflugt(u3);

        Deltager deltager4 = Controller.createDeltager(tilmelding4,"Lone Jensen",69,"232242","by4");
        tilmelding4.setLedsagerNavn("Jan Madsen");
        tilmelding4.addUdflugt(u1);
        tilmelding4.addUdflugt(u2);
        tilmelding4.setHotel(h1);
        tilmelding4.addTillæg(tillæg1H1);



     konference1.addHotel(h1);
     konference1.addHotel(h2);
     konference1.addHotel(h3);



     konference1.addUdflugt(u1);
     konference1.addUdflugt(u2);
     konference1.addUdflugt(u3);





//        Udflugt udflugt = Controller.createUdflugt("Tur","dsdsdd",10000,start);
//        tilmelding1.addUdflugt(udflugt);
//
//
//
//        Firma firma = Controller.createFirma("Lars Larsen","23234423","dkdksokddsokds");
//
//        firma.addTilmelding(tilmelding1);
//        firma.addTilmelding(tilmelding1);
//
//
//
//        Controller.createDeltager(tilmelding2,"Jacob",23,"232323","dsadsa");
//
//
//
//

//
//        tilmelding1.setLedsagerNavn("Abukar");
//
//
//
//
//
//
//     System.out.println(tilmelding1.getSamletPrisForAlt());
//
//
////        tilmelding.setDeltager(deltager);

        System.out.println(konference1.konferenceOversigt() + "\n" + konference2.konferenceOversigt());

















    }
}
