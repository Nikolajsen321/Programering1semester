package guifx;
import applikation.controler.Controler;
import applikation.model.Bestilling;
import applikation.model.Forstilling;
import applikation.model.Kunde;
import applikation.model.Plads;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import storage.Storage;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class BestillingPane extends Application {

    private ListView<Forstilling> lvwforstiling = new ListView<>();
    private ListView<Kunde> lvwKunde = new ListView<>();
    ListView<Plads> lvwPlads = new ListView<>();
    private TextField txfForstillingNavn = new TextField();
    private TextField txfStartDato = new TextField();
    private TextField txfSlutDato = new TextField();
    private TextField txfKundeNavn = new TextField();
    private TextField txfKundeMobil = new TextField();
    private TextField txfDato = new TextField();


    @Override
    public void start(Stage stage){
        stage.setTitle("Bestilling side ");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setVgap(5);
        pane.setHgap(10);



        Label  lblForstilling = new Label("Forstillinger");
        pane.add(lblForstilling,0,0);
        pane.add(lvwforstiling,0,1,2,1);
        lvwforstiling.setPrefHeight(100);
        lvwforstiling.setPrefWidth(200);
        lvwforstiling.getItems().setAll(Storage.getForstillinger());
        lvwforstiling.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

         // for at der ikke kommer kæmpe stor mellem rum mellem label og textfield i pane
        // laver jeg endnu en Gridpane for textfields og Label

        Label lblNavn = new Label("Navn");
        pane.add(lblNavn,0,2);
        pane.add(txfForstillingNavn,1,2);

        Label lblStartDato = new Label("StartDato");
        pane.add(lblStartDato,0,3);
        pane.add(txfStartDato,1,3);

        Label lblSlutDato = new Label("SlutDato");
        pane.add(lblSlutDato,0,4);
        pane.add(txfSlutDato,1,4);

        Label  lblKunder = new Label("Kunder");
        pane.add(lblKunder,3,0);
        pane.add(lvwKunde,3,1,2,1);
        lvwKunde.setPrefHeight(100);
        lvwKunde.setPrefWidth(200);
        lvwKunde.getItems().setAll(Storage.getKunder());
        lvwKunde.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        Label lblKundeNavn = new Label("Navn");
        pane.add(lblKundeNavn,3,3);
        pane.add(txfKundeNavn,4,3);

        Label lblMobilNr = new Label("Mobil");
        pane.add(lblMobilNr,3,4);
        pane.add(txfKundeMobil,4,4);

        Label lblPladser = new Label("Plads");
        pane.add(lblPladser, 7, 0);
        pane.add(lvwPlads, 7, 1, 2, 1);
        lvwPlads.setPrefHeight(300);
        lvwPlads.setPrefWidth(200);
        lvwPlads.getItems().setAll(Storage.getPladser());
        lvwPlads.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Label lblDato = new Label("Dato:");
        pane.add(lblDato,7,3);
        pane.add(txfDato,8,3);




        Button btnOpretForstilling = new Button("Opret forstilling");
        pane.add(btnOpretForstilling,1,5);
        btnOpretForstilling.setOnAction(event -> this.OpretForstilling());

        Button btnOpretKunde = new Button("Opret kunde");
        pane.add(btnOpretKunde,4,5);
        btnOpretKunde.setOnAction(event -> this.OpretKunde());

        Button btnOpretBestilling = new Button("Opret bestilling");
        pane.add(btnOpretBestilling,8,4);
        btnOpretBestilling.setOnAction(event -> opretActionBestilling());



//        Label lblStartDato = new Label("StartDato");
//        pane.add(lblStartDato,0,4);
//        pane.add(txfStartDato,1,4);
//
//
//        Label lblSlutDato = new Label("SlutDato");

    }

    private void opretActionBestilling() {
        ArrayList<Plads> pladser = new ArrayList<>(lvwPlads.getSelectionModel().getSelectedItems());
        Forstilling forstilling = lvwforstiling.getSelectionModel().getSelectedItem();
        Kunde kunde = lvwKunde.getSelectionModel().getSelectedItem();
        String stringdato = txfDato.getText().trim();
        LocalDate dato;
        try {
            dato = LocalDate.parse(stringdato);

        }catch (DateTimeException exp){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not read selected date");
            alert.setContentText("Write date in following format: 'yyyy-MM-dd");
            alert.showAndWait();
            return;
        }
//
        Bestilling bestilling = Controler.opretBestilling(forstilling,kunde,dato,pladser);
       lvwforstiling.getItems().setAll(Storage.getForstillinger());


        if(bestilling != null){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Order created");
            alert.setHeaderText("Order created for " + kunde.getNavn());
            alert.setContentText("Write date in following format: 'yyyy-MM-dd");
            alert.showAndWait();
        }
    }

    private void OpretKunde() {
        String kundeNavn = txfKundeNavn.getText().trim();
        String mobilNr = txfKundeMobil.getText().trim();
        if(kundeNavn.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Manglende navn ");
            alert.setHeaderText("Indsæt navn i feltet");
            alert.setContentText("Indtastnavn");
        }
        Controler.createKunde(kundeNavn,mobilNr);
        lvwKunde.getItems().setAll(Storage.getKunder());

    }



    private void OpretForstilling() {
        String forstillingNavn = txfForstillingNavn.getText().trim();
        String startD = txfStartDato.getText().trim();
        String slutD = txfSlutDato.getText().trim();

        LocalDate startDato = null;
        LocalDate slutDato = null;
        try {
            startDato = LocalDate.parse(startD);
        }catch (DateTimeParseException exp){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fejl");
            alert.setHeaderText("Kunne ikke aflæse start dato");
            alert.setContentText("Format for start dato skal være 'yyyy-MM-dd'");
            alert.showAndWait();
            return;
        }
        try {
            slutDato = LocalDate.parse(slutD);
        }catch (DateTimeParseException exp){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fejl");
            alert.setHeaderText("Kunne ikke aflæse slut dato");
            alert.setContentText("Format for slut dato skal være 'yyyy-MM-dd'");
            alert.showAndWait();
            return;
        }
        if(forstillingNavn.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Mangler input");
            alert.setHeaderText("Udfyld navne feltet");
            alert.setContentText("Der skal vælges et navn til forstilling");
            alert.show();
            return;
        }else {
            Controler.createForstilling(forstillingNavn,startDato,slutDato);

        }
        txfForstillingNavn.clear();
        txfStartDato.clear();
        txfSlutDato.clear();
        lvwforstiling.getItems().setAll(Controler.getForstillinger());

    }


}
