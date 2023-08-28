package application.controller;

import application.model.*;
import storage.Storage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Controller {
    public static Sælger createSælger(String navn,int studiekortNummer,String mobil){
        Sælger sælger = new Sælger(navn,studiekortNummer,mobil);
        Storage.addSælger(sælger);
        return sælger;
    }
    public static ArrayList<Sælger> getSælger(){
        return Storage.getSælgers();
    }

    public static Salgsannonce createSalgeannonce(Sælger sælger){
       Salgsannonce salgsannonce = sælger.createSalgsAnnoce();
       return salgsannonce;
    }

    public static Vare createVare(Varekategori varekategori,String navn, int udbudspris){
        Vare vare = new Vare(varekategori,navn,udbudspris);
        Storage.addVare(vare);
        return vare;
    }
    public static ArrayList<Vare> getVarer(){
       return Storage.getVares();
    }


    public static Salg createSalg(String købersNavn, int aftalteSamletPris, ArrayList<Vare> varer){
        Salg salg = new Salg(købersNavn,aftalteSamletPris,varer);
        Storage.addSalg(salg);
        return salg;
    }

    public static ArrayList<Salg> getSalg(){
        return Storage.getSalgs();
    }

    public static void initStorage(){
        Sælger viktor = createSælger("Viktor", 23,"Telefonnummer: 45344247");
       Sælger Gustav = createSælger("Gustav",35,"Telefonnummer: 56124522");

       Vare samsung = createVare(Varekategori.MOBILTELEFON,"Samsung mobil",1200);
      Vare iphone =  createVare(Varekategori.MOBILTELEFON,"Iphone",2000);
        Vare java = createVare(Varekategori.BOG,"JAVA",400);
        Vare android = createVare(Varekategori.BOG,"Android",300);
       Vare python =  createVare(Varekategori.BOG,"Python",200);
        Vare regnjakke = createVare(Varekategori.TØJ,"Regnjakke",100);
       Vare regnbukser = createVare(Varekategori.TØJ,"Regnbusker",80);
       Vare sko = createVare(Varekategori.TØJ,"Sko",100);

       Salgsannonce salgsannonce1 = viktor.createSalgsAnnoce();
       salgsannonce1.addVarer(samsung);

        Salgsannonce salgsannonce2 = viktor.createSalgsAnnoce();
        salgsannonce2.addVarer(java);
        salgsannonce2.addSalgsannonce(android);
        salgsannonce2.addVarer(python);


      Salgsannonce salgsannonce3 =  Gustav.createSalgsAnnoce();
      salgsannonce3.addVarer(iphone);
      salgsannonce3.addVarer(sko);

      Salgsannonce salgsannonce4 = Gustav.createSalgsAnnoce();
      salgsannonce4.addVarer(regnbukser);
      salgsannonce4.addVarer(regnjakke);

      ArrayList<Vare> købteTing1 = new ArrayList<>(List.of(android,python));
      ArrayList<Vare> købteTing2 = new ArrayList<>(List.of(regnbukser,regnjakke));

      Salg stine = createSalg("Stine",450,købteTing1);
      Salg laura = createSalg("Laura",120,købteTing2);

      String filNavn = "C:\\Users\\nikol\\OneDrive\\Skrivebord\\semesterPrøveJanuar.txt";
      salgTilFil(filNavn);
    }
    

    public static void salgTilFil(String filNavn){
        ArrayList<Salg> køber = new ArrayList<>(Storage.getSalgs());
        SortKøberList(køber);
        try(Scanner scan = new Scanner(System.in); PrintWriter printWriter = new PrintWriter(filNavn)) {
            for(int i = 0; i < køber.size(); i++){
                    printWriter.println(køber.get(i).getBuyer());
                }
            System.out.println("Færdig");
            }catch (IOException e){
            System.out.println(e.getMessage());
        }
        }

    public static void SortKøberList(ArrayList<Salg> køber) {
        for(int i =0; i <køber.size(); i++ ){
            int currentMinIndex = i ;
            for(int j = i +1; j < køber.size(); j++){

                if(køber.get(j).getKøbersNavn().compareTo(køber.get(currentMinIndex).getKøbersNavn()) < 0)
                {
                    currentMinIndex = j;
                }
            }
            swap(køber,i,currentMinIndex);
        }
    }
    public static void swap(ArrayList<Salg> køber, int i, int minIndex){
        Salg temp = køber.get(i);
        køber.set(i,køber.get(minIndex));
        køber.set(minIndex,temp);
    }

    public static void SortSælgerList(ArrayList<Sælger> sælgers) {
        for(int i =0; i <sælgers.size(); i++ ){
            int currentMinIndex = i ;
            for(int j = i +1; j < sælgers.size(); j++){

                if(sælgers.get(j).getNavn().compareTo(sælgers.get(currentMinIndex).getNavn()) < 0)
                {
                    currentMinIndex = j;
                }
            }
            swap1(sælgers,i,currentMinIndex);
        }
    }
    public static void swap1(ArrayList<Sælger> sælgers, int i, int minIndex){
        Sælger temp = sælgers.get(i);
        sælgers.set(i,sælgers.get(minIndex));
        sælgers.set(minIndex,temp);
    }


    public static ArrayList<Sælger> listAfSælgerSomHarKøbtVarer(){
        ArrayList<Sælger> sælgerSomHarKøbt = new ArrayList<>();
        ArrayList<Sælger> listAfSælger = new ArrayList<>(Storage.getSælgers());
        ArrayList<Salg> listAfKøber = new ArrayList<>(Storage.getSalgs());

        SortKøberList(listAfKøber);
        SortSælgerList(listAfSælger);

        int i1 = 0;
        int i2 = 0;
        while (i1 < Storage.getSælgers().size() && i2 < Storage.getSalgs().size()){
            if(listAfSælger.get(i1).getNavn().compareTo(listAfKøber.get(i2).getKøbersNavn()) == 0){
                i1++;
                i2++;
                sælgerSomHarKøbt.add(listAfSælger.get(i1));
            }else if(listAfSælger.get(i1).getNavn().compareTo(listAfKøber.get(i2).getKøbersNavn()) < 0){
                i1++;
            }else if(listAfSælger.get(i1).getNavn().compareTo(listAfKøber.get(i2).getKøbersNavn()) >0){
                i2++;
            }
        }
        return sælgerSomHarKøbt;
        }

    }



