package guifx;

import application.controller.Controller;
import application.model.Bane;
import application.model.Booking;
import application.model.Spiller;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import storage.Storage;
import javafx.scene.paint.Color;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Guifx extends Application {
    private TextField txfHour = new TextField();
    private TextField txfMinute = new TextField();
    private ListView<Bane> lvwBaner = new ListView<>();
    private TextArea txaAntalBookning = new TextArea();
    private ListView<Booking> lvwBookning = new ListView<>();
    private ListView<Spiller> lvwSpiller = new ListView<>();
    private CheckBox chkSingel = new CheckBox("single");
    private DatePicker dpDato = new DatePicker();


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
//        pane.setBackground(Background.fill(Color.PALEVIOLETRED));

        Label lblBaner = new Label("Baner");
        pane.add(lblBaner,0,0);
        pane.add(lvwBaner,0,1,1,2);
        lvwBaner.setPrefWidth(400);
        lvwBaner.getItems().setAll(Storage.getBaner());
        ChangeListener<Bane> listener =(ov, oldSalgsannonce, newSalgsannonce) ->this.selectedBane();
        lvwBaner.getSelectionModel().selectedItemProperty().addListener(listener);

        Label lblBookninger = new Label("Antal bookninger på Banen");
        pane.add(lblBookninger,0,3);
        pane.add(txaAntalBookning,0,4,2,5);
        txaAntalBookning.setPrefHeight(200);
        lblBookninger.setPrefWidth(100);
        txaAntalBookning.setEditable(false);
        txaAntalBookning.setPrefWidth(100);
        txaAntalBookning.setPrefHeight(170);


        Label lblSpiller = new Label("Spillere");
        pane.add(lblSpiller,3,0);
        pane.add(lvwSpiller,3,1,4,2);
        lvwSpiller.getItems().setAll(Storage.getSpiller());

        Label lblBooking = new Label("Spillernes booking");
        pane.add(lblBooking,7,0,8,1);
        pane.add(lvwBookning,7,1,18,2);
        ChangeListener<Spiller> listener1 =(ov, oldSalgsannonce, newSalgsannonce) ->this.selectedSpiller();
        lvwSpiller.getSelectionModel().selectedItemProperty().addListener(listener1);
        






        Label lblTid = new Label("Vælg tidspunkt \n(kun hele timer fra 9 -17)");
        pane.add(lblTid,7,6,7,7);
        pane.add(txfHour,14,6,19,7);
        txfHour.setPrefWidth(20);
        txfHour.setMaxWidth(40);


        pane.add(chkSingel,14,8,16,19);

        Label lblVælgDato = new Label("Vælg dato");
        pane.add(lblVælgDato,7,8,9,13);
        pane.add(dpDato,14,8,15,13);


        txfMinute.clear();
        txfHour.clear();

        Button btnBookning = new Button("Book bane til spiller");
        pane.add(btnBookning,18,9,19,10);
        btnBookning.setOnAction(event ->createBookning());







    }

    private void createBookning() {
        boolean chekbox = chkSingel.isSelected();
        LocalDate dato = dpDato.getValue();
        int time = Integer.parseInt(txfHour.getText());
        LocalTime tid = LocalTime.of(time,00);

        if(time >= 9 && time <= 17) {
            if (!txfHour.getText().isEmpty() && !lvwSpiller.getSelectionModel().isEmpty()
                    && !lvwBaner.getSelectionModel().isEmpty()) {
                String spillerNavn = txfHour.getText();
                String uddannelsen = txfMinute.getText();
                   if(lvwBaner.getSelectionModel().getSelectedItem().tidLedig(dato,tid)){
                       Booking booking = Controller.createBookning(dato, tid, chkSingel.isSelected(),
                               lvwSpiller.getSelectionModel().getSelectedItem());
                       booking.setBane(lvwBaner.getSelectionModel().getSelectedItem());
                       updateControlsForSpiller();
                       updateControlsForBane();
                       txfHour.clear();
                       txfMinute.clear();
                       dpDato.getEditor().clear();
                   }else{
                       Alert alert = new Alert(Alert.AlertType.ERROR);
                       alert.setTitle("Dato");
                       alert.setHeaderText("Ugyldigtvalg");
                       alert.setContentText("Dato er optaget");
                       alert.show();
                   }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Mangler navn eller uddanellse instution");
                alert.setHeaderText("Mangler navn");
                alert.setContentText("Skriv navn eller uddanelse");
                alert.show();
            }
        }else {
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Tid");
            alert1.setHeaderText("Forkert tid ");
            alert1.setContentText("Skriv en tid inde for til og med (9-17)");
            alert1.show();
        }




    }

    private void selectedSpiller() {
        this.updateControlsForSpiller();
    }

    private void updateControlsForSpiller() {
        Spiller spiller = lvwSpiller.getSelectionModel().getSelectedItem();
        if(spiller != null){
            lvwBookning.getItems().setAll(spiller.getBookninger());
        }

    }


    private void selectedBane() {
        this.updateControlsForBane();
    }

    private void updateControlsForBane() {
        Bane bane = lvwBaner.getSelectionModel().getSelectedItem();
        StringBuilder sb = new StringBuilder();
        String string = "";

        for(int i = 0; i < bane.antalBookningPrTime().length; i ++){
            if(bane.antalBookningPrTime()[i] != 0) {
                string += "tid " + (i+1) + " || " + bane.antalBookningPrTime()[i] + " (Booked)"+ "\n";
            } else {
                string += "tid " + (i+1) + " || " + bane.antalBookningPrTime()[i] + "\n";
            }
        }
        sb.append(string);
        txaAntalBookning.setText(String.valueOf(sb));
    }

}
