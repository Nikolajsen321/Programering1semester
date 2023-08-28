package gui;

import application.controller.Controller;
import application.model.Salg;
import application.model.Salgsannonce;
import application.model.Sælger;
import application.model.Vare;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import storage.Storage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class GuiFx extends Application {

    private ListView<Salgsannonce> lvwSalgsAnnonce = new ListView<>();
    private ListView<Vare> lvwVare = new ListView<>();
    private TextField txfKøber = new TextField();
    private TextField txfAftaltPris = new TextField();
    private TextField filNavn = new TextField();

    private Button btnOpretSalg = new Button("Opret salg");
    private Button btnOpretFil = new Button("Salgs Fil");
    private Button btnSalgsFil = new Button("Salgsfil");


    @Override
    public void start(Stage stage){
        stage.setTitle("HandelsPlatForm");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }


    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(40));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblAktiveAnnonce = new Label("Aktive annonce");
        pane.add(lblAktiveAnnonce,0,0);
        pane.add(lvwSalgsAnnonce,0,1,1,1);
        lvwSalgsAnnonce.setPrefHeight(100);
        lvwSalgsAnnonce.setPrefWidth(200);
        lvwSalgsAnnonce.getItems().setAll(getSalgAnnonce(Storage.getSælgers()));
        ChangeListener<Salgsannonce> listener =(ov,oldSalgsannonce,newSalgsannonce) ->this.selectedSalgsAnnonce();
        lvwSalgsAnnonce.getSelectionModel().selectedItemProperty().addListener(listener);


        Label lblVarer = new Label("Vare");
        pane.add(lblVarer,2,0);
        pane.add(lvwVare,3,1,4,1);
        lvwVare.setPrefHeight(100);
        lvwVare.setPrefWidth(200);
        lvwVare.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


       Label lblKøber = new Label("Køber");
       pane.add(lblKøber,7,1);
       pane.add(txfKøber,8,1);


       Label lblAftaltPris = new Label("Aftalt pris");
       pane.add(lblAftaltPris,7,2);
       pane.add(txfAftaltPris,8,2);

       pane.add(btnOpretSalg,7,3);
        btnOpretSalg.setOnAction(event -> this.OpretSalgKnap());


        Label lblFilNavn = new Label("Fil navn");
        pane.add(lblFilNavn,10,4);
        pane.add(filNavn,11,4);
        pane.add(btnSalgsFil,9,4);
        btnSalgsFil.setOnAction(event -> this.OpretSalgsFil());



    }

    private void OpretSalgsFil() {
       ArrayList<Vare>  vareListe = new ArrayList<>(Storage.getVares());
       String navnFil =  "C:\\Users\\nikol\\OneDrive\\Skrivebord\\" + filNavn.getText()+".txt";


        try(Scanner scan = new Scanner(System.in); PrintWriter printWriter = new PrintWriter(navnFil)) {
            for(int i = 0; i < vareListe.size(); i++){
                if(vareListe.get(i).isSolgt()) {
                    printWriter.println(vareListe.get(i).toString());
                }
            }
            System.out.println("Færdig");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void OpretSalgKnap(){
        ArrayList<Vare> vare = null;
        String køberNavn = "";
        int aftaltsPris  = 0;
//        System.out.println( txfKøber.getText(1,2));
        int samletpris = 0;

        if(!lvwSalgsAnnonce.getSelectionModel().isEmpty()) {
            if(!lvwVare.getSelectionModel().isEmpty()){
              vare = new ArrayList<>(lvwVare.getSelectionModel().getSelectedItems());
                for(Vare v: vare ){
                    samletpris +=  v.getUdbudspris();
                }
            if (Integer.parseInt(txfAftaltPris.getText()) == samletpris && lvwVare.getSelectionModel().getSelectedItem().isSolgt() == false) {
                køberNavn = txfKøber.getText();
                aftaltsPris  = Integer.parseInt(txfAftaltPris.getText());
                Salg køber = Controller.createSalg(køberNavn, aftaltsPris, vare);
                updateControlsForSalgsAnnonce();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Select input ");
                alert.setHeaderText("1: did you add a name?\n2. did you give the right price\n3. is it already sold? " );
                alert.setContentText("Select something");
                alert.show();
            }
        } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Vælg en vare ");
                alert.setHeaderText("Du skal vælge en vare fra listen");
                alert.setContentText("Select something");
                alert.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Annonce");
            alert.setHeaderText("Du skal vælge en Annonce");
            alert.setContentText("Select something");
            alert.show();
        }
        vare = null;
        txfKøber.clear();
        txfAftaltPris.clear();



    }

    private ArrayList<Salgsannonce> getSalgAnnonce(ArrayList<Sælger> sælgers) {
        ArrayList<Salgsannonce> salgsannonce = new ArrayList<>();
        for(Sælger sælger : sælgers){
            for(Salgsannonce salgsannonce1 : sælger.getSalgsannoncer()) {
                if(salgsannonce1.isAktiv()){
                    salgsannonce.add(salgsannonce1);
                }
            }
        }
        return salgsannonce;
    }

    private void selectedSalgsAnnonce() {
        this.updateControlsForSalgsAnnonce();
    }

    public void updateControlsForSalgsAnnonce() {
        Salgsannonce salgsannonce = lvwSalgsAnnonce.getSelectionModel().getSelectedItem();
       if(salgsannonce != null){
           lvwVare.getItems().setAll(salgsannonce.getVarer());
       }
    }


}
