package guifx;

import application.controller.Controller;
import application.model.*;
import javafx.application.Application;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Organisation organisation = Controller.createOrganisation("Miljø");
        LocalDate start = LocalDate.of(2023,12,10);
        LocalDate slut = LocalDate.of(2023,12,20);
        Konference konference = Controller.createKonference("Hav og himmel","dsdaadszdsa",start,slut,100);
        Tilmelding tilmelding = Controller.createTilmelding(konference,start,slut,true);
        Deltager deltager = Controller.createDeltager(tilmelding,"Asger",25,"32322332","dsdsadsa");

        Udflugt udflugt = Controller.createUdflugt("Tur","dsdsdd",10000,start);
        tilmelding.addUdflugt(udflugt);

        Firma firma = Controller.createFirma("Lars Larsen","23234423","dkdksokddsokds");
        Tilmelding tilmelding1 = Controller.createTilmelding(konference,start,slut,false);

        Deltager deltager1 = Controller.createDeltager(tilmelding1, "Hans",24,"4343","242323");

        firma.addTilmelding(tilmelding);
        firma.addTilmelding(tilmelding1);

        Konference konference1 = Controller.createKonference("Natur og miljø","dadds",start,slut,222);
        Tilmelding tilmelding2 = Controller.createTilmelding(konference1,start,slut,true);
        Controller.createDeltager(tilmelding2,"Jacob",23,"232323","dsadsa");

        Hotel h1 = Controller.createHotel("Den Hvide Svane","Adresse1",1250,1050);
        Hotel h2 = Controller.createHotel("Høtel Phønix","Adresse2",800,700);
        Hotel h3 = Controller.createHotel("Pension Tusindfryd","Adresse3",600,500);

        Controller.addHotelToKonference(konference,h1);
        Controller.addHotelToKonference(konference,h2);
        Controller.addHotelToKonference(konference1,h3);

        Udflugt u1 = Controller.createUdflugt("Byrundtur","Odense",125,LocalDate.of(2023,05,18));
        Udflugt u2 = Controller.createUdflugt("Egeskov","",75,LocalDate.of(2023,05,19));
        Udflugt u3 = Controller.createUdflugt("Trapholt Museum","Kolding",200,LocalDate.of(2023,05,20));

        Controller.addUdflugtToKonference(konference,u1);
        Controller.addUdflugtToKonference(konference,u2);
        Controller.addUdflugtToKonference(konference1,u3);

        Controller.createTillæg(h1,"Bad",500);
        Controller.createTillæg(h1,"WIFI",1000);
        Controller.createTillæg(h1,"Mad",50);

        Controller.createTillæg(h2,"WIFI",250);


     System.out.println(tilmelding.getSamletPrisForAlt());


//        tilmelding.setDeltager(deltager);

        System.out.println(konference.konferenceOversigt() + "\n" + konference1.konferenceOversigt());





        Application.launch(StartWindow.class);



    }
}
