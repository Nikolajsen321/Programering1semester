package guifx;

import application.controller.Controller;
import application.model.*;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.time.LocalDate;

public class TilmeldingPane extends GridPane {

    private TextField txfDeltagerNavn, txfAdresse, txfAlder, txfTlf,
            txfHotelNavn, txfAnkomstDato, txfAfrejsningsDato,
            txfFirmaNavn, txfFirmaTlf, txfFirmaMail, txfFordragholder, txfLedsager;
    private CheckBox chbLedsager, chbFordragsholder, chbFirma;

    private ListView<Hotel> lvwHoteller;

    private ListView<Hotel> lvwVærelser;

    private TextArea txaVærelse;

    private ListView<Tillæg> lvwTillæg;

    private ComboBox<Udflugt> cbbUdflugter;

    private ListView<Udflugt> lvwUdflugter;

    private ComboBox<Konference> cbbKonfernecer;

    private DatePicker dpAnkomst = new DatePicker();

    private DatePicker dpAfrejse = new DatePicker();

    private Deltager deltager;
    private Tilmelding tilmelding;

    public TilmeldingPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);


        VBox vbox1 = new VBox();
        vbox1.paddingProperty().set(new Insets(0, 40, 20, 20));

        VBox vbox2 = new VBox();
        vbox2.paddingProperty().set(new Insets(0, 40, 20, 0));

        VBox vbox3 = new VBox();
        vbox3.paddingProperty().set(new Insets(0, 40, 20, 0));

        HBox valueContainer = new HBox(vbox1, vbox2, vbox3);
        this.add(valueContainer, 0, 0);

        Label lblDeltagerNavn = new Label("Navn:");
        lblDeltagerNavn.setPrefWidth(80);

        txfDeltagerNavn = new TextField("Nikolaj");
        HBox deltagerNavn = new HBox(lblDeltagerNavn, txfDeltagerNavn);
        deltagerNavn.paddingProperty().set(new Insets(0, 0, 10, 0));
        vbox1.getChildren().add(deltagerNavn);

        //------------------------------------------------------------------------------------------

        Label lblAdresse = new Label("Adresse:");
        lblAdresse.setPrefWidth(80);

        txfAdresse = new TextField("Sønderhøj 30");
        HBox adresse = new HBox(lblAdresse, txfAdresse);
        adresse.paddingProperty().set(new Insets(0, 0, 10, 0));
        vbox1.getChildren().add(adresse);

        //------------------------------------------------------------------------------------------

        Label lblAlder = new Label("Alder:");
        lblAlder.setPrefWidth(80);

        txfAlder = new TextField("26");
        HBox alder = new HBox(lblAlder, txfAlder);
        alder.paddingProperty().set(new Insets(0, 0, 10, 0));
        vbox1.getChildren().add(alder);

        //------------------------------------------------------------------------------------------

        Label lblTlf = new Label("Telefon:");
        lblTlf.setPrefWidth(80);

        txfTlf = new TextField("88888888");
        HBox tlf = new HBox(lblTlf, txfTlf);
        tlf.paddingProperty().set(new Insets(0, 0, 10, 0));
        vbox1.getChildren().add(tlf);

        //------------------------------------------------------------------------------------------

        chbLedsager = new CheckBox("Ledsager:");
        chbLedsager.setOnAction(event -> selectedLedsager(chbLedsager.isSelected()));
        vbox1.getChildren().add(chbLedsager);
        chbLedsager.setPrefWidth(80);

        txfLedsager = new TextField("Asger");
        HBox ledsager = new HBox(chbLedsager, txfLedsager);
        ledsager.paddingProperty().set(new Insets(0, 0, 10, 0));
        vbox1.getChildren().add(ledsager);
        txfLedsager.setDisable(true);

        //------------------------------------------------------------------------------------------

        Label lblKonferencer = new Label("Konferencer:");
        lblKonferencer.setPrefWidth(80);

        cbbKonfernecer = new ComboBox<>();
        HBox konferencer = new HBox(lblKonferencer, cbbKonfernecer);
        konferencer.paddingProperty().set(new Insets(0, 0, 10, 0));
        vbox1.getChildren().add(konferencer);
        cbbKonfernecer.getItems().setAll(Controller.getOrganisation().getKonferencer());

        ChangeListener<Konference> listener = (ov, oldKonference, newKonference) -> this.selectedKonferenceChanged();
        cbbKonfernecer.getSelectionModel().selectedItemProperty().addListener(listener);

        //------------------------------------------------------------------------------------------

        Label lblUdflugter = new Label("Udflugter:");
        lblUdflugter.setPrefWidth(80);

        lvwUdflugter = new ListView<>();
        lvwUdflugter.setPrefWidth(200);
        lvwUdflugter.setPrefHeight(200);
        HBox udflugter = new HBox(lblUdflugter, lvwUdflugter);
        udflugter.paddingProperty().set(new Insets(20, 0, 10, 0));
        vbox1.getChildren().add(udflugter);

        // -------------------------------------------------------------------------

        Button btnTilmeld = new Button("Tilmeld");
        vbox1.getChildren().add(btnTilmeld);
        btnTilmeld.setOnAction(event -> this.tilmeldAction());

        // -------------------------------------------------------------------------

        chbFordragsholder = new CheckBox("Fordragsholder");
        vbox2.getChildren().add(chbFordragsholder);
        chbFordragsholder.paddingProperty().set(new Insets(0, 0, 10, 80));

        Label lblHotelNavn = new Label("Hotel:");
        lblHotelNavn.setPrefWidth(80);

        txfHotelNavn = new TextField();
        HBox hotelNavn = new HBox(lblHotelNavn, txfHotelNavn);
        hotelNavn.paddingProperty().set(new Insets(10, 0, 10, 0));
        vbox2.getChildren().add(hotelNavn);

        // -------------------------------------------------------------------------

        Label lblAnkomstDato = new Label("AnkomstDato:");
        lblAnkomstDato.setPrefWidth(80);

        txfAnkomstDato = new TextField("2023-05-18");
        HBox ankomstDato = new HBox(lblAnkomstDato, txfAnkomstDato);
        ankomstDato.paddingProperty().set(new Insets(0, 0, 10, 0));
        vbox2.getChildren().add(ankomstDato);

        // -------------------------------------------------------------------------

        Label lblAfrejsningsDato = new Label("AfrejsningsDato:");
        lblAfrejsningsDato.setPrefWidth(80);

        txfAfrejsningsDato = new TextField("2023-05-20");
//        dpAfrejse = new DatePicker();
        HBox afresningsDato = new HBox(lblAfrejsningsDato, txfAfrejsningsDato);
        afresningsDato.paddingProperty().set(new Insets(0, 0, 10, 0));
        vbox2.getChildren().add(afresningsDato);

        // -------------------------------------------------------------------------

        Label lblHoteller = new Label("Hoteller:");
        lvwHoteller = new ListView<>();

        lvwHoteller.setPrefWidth(240);
        lvwHoteller.setPrefHeight(100);

        VBox vboxHoteller = new VBox(lblHoteller, lvwHoteller);
        vboxHoteller.setSpacing(10);
        vboxHoteller.setAlignment(Pos.CENTER_LEFT);

        ChangeListener<Hotel> listener1 = (ov, oldHotel, newHotel) -> this.selectedHotelChanged();
        lvwHoteller.getSelectionModel().selectedItemProperty().addListener(listener1);


        HBox hoteller = new HBox(vboxHoteller);
        vbox2.getChildren().add(hoteller);


        // -------------------------------------------------------------------------

        chbFirma = new CheckBox("Firma");
        vbox3.getChildren().add(chbFirma);
        chbFirma.setOnAction(event -> selectedFirma(chbFirma.isSelected()));
        chbFirma.paddingProperty().set(new Insets(0, 0, 10, 80));

        Label lblFirmaNavn = new Label("Navn:");
        lblFirmaNavn.setPrefWidth(80);

        txfFirmaNavn = new TextField("MacD");
        HBox firmaNavn = new HBox(lblFirmaNavn, txfFirmaNavn);
        firmaNavn.paddingProperty().set(new Insets(10, 0, 10, 0));
        vbox3.getChildren().add(firmaNavn);
        txfFirmaNavn.setDisable(true);

        // -------------------------------------------------------------------------

        Label lblFirmaTlf = new Label("Telefon:");
        lblFirmaTlf.setPrefWidth(80);

        txfFirmaTlf = new TextField("22222222");
        HBox firmaTlf = new HBox(lblFirmaTlf, txfFirmaTlf);
        firmaTlf.paddingProperty().set(new Insets(0, 0, 10, 0));
        vbox3.getChildren().add(firmaTlf);
        txfFirmaTlf.setDisable(true);

        // -------------------------------------------------------------------------

        Label lblFirmaMail = new Label("Mail:");
        lblFirmaMail.setPrefWidth(80);

        txfFirmaMail = new TextField("MacD@gmail.com");
        HBox firmaMail = new HBox(lblFirmaMail, txfFirmaMail);
        firmaMail.paddingProperty().set(new Insets(0, 0, 10, 0));
        vbox3.getChildren().add(firmaMail);
        txfFirmaMail.setDisable(true);

        // -------------------------------------------------------------------------

        Label lblVærelse = new Label("Værelser:");


        txaVærelse = new TextArea();
        txaVærelse.setPrefWidth(100);
        txaVærelse.setPrefHeight(100);

        HBox værelserHBox = new HBox(lblVærelse, txaVærelse);
        vbox3.getChildren().add(værelserHBox);

        Label lblTillæg = new Label("Tillæg:");
        lvwTillæg = new ListView<>();
        lvwTillæg.setPrefWidth(100);
        lvwTillæg.setPrefHeight(100);
        lvwTillæg.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        HBox tillægHBox = new HBox(lblTillæg, lvwTillæg);
        vbox3.getChildren().add(tillægHBox);

        HBox lblHobox = new HBox(lblVærelse, lblTillæg);
        lblHobox.setSpacing(90);
        lblHobox.paddingProperty().set(new Insets(0, 0, 10, 0));
        vbox3.getChildren().add(lblHobox);

        HBox tillæg = new HBox(txaVærelse, lvwTillæg);
        tillæg.setSpacing(40);
        tillæg.paddingProperty().set(new Insets(0, 0, 10, 0));
        vbox3.getChildren().add(tillæg);


        // -------------------------------------------------------------------------


    }

    private void selectedLedsager(boolean selected) {
        txfLedsager.setDisable(!selected);
    }
    private void selectedFirma(boolean selected) {
        txfFirmaNavn.setDisable(!selected);
        txfFirmaTlf.setDisable(!selected);
        txfFirmaMail.setDisable(!selected);
    }
    public void selectedKonferenceChanged() {
        this.updateControls();
    }

    public void selectedHotelChanged(){
        this.updateHotel();
    }

    public void updateHotel(){
        Hotel hotel = lvwHoteller.getSelectionModel().getSelectedItem();
        StringBuilder sb = new StringBuilder();
        if(chbLedsager.isSelected()){
            sb.append(String.valueOf(hotel.getPrisDoubbelt()));
            txaVærelse.setText(sb.toString() + "kr \nDobbelt værelse");
        } else {
            sb.append(String.valueOf(hotel.getPrisEnkelt()));
            txaVærelse.setText(sb.toString() + "kr \nEnkelt værelse");
        }
        lvwTillæg.getItems().setAll(hotel.getTillægs());
        txfHotelNavn.setText(hotel.getNavn());
    }

    public void updateControls() {
        Konference konference = cbbKonfernecer.getSelectionModel().getSelectedItem();
        if (konference != null) {
            lvwHoteller.getItems().setAll(konference.getHoteler());
            lvwUdflugter.getItems().setAll(konference.getUdflugter());
        }
    }




    private void tilmeldAction() {
        String navn = txfDeltagerNavn.getText().trim();
        String alder = txfAlder.getText().trim();
        String tlf = txfTlf.getText().trim();
        String adresse = txfAdresse.getText().trim();
        LocalDate ankomstDato = LocalDate.parse( txfAnkomstDato.getText().trim());
        LocalDate afresningsDato = LocalDate.parse(txfAfrejsningsDato.getText().trim());
        int alderInt = Integer.parseInt(alder);
        if(navn.length() > 0 &&
                adresse.length() > 0 &&
                tlf.length() >= 8 &&
                alder.length() > 0 &&
                ankomstDato != null &&
                afresningsDato != null) {

            boolean erFordragsholder = chbFordragsholder.isSelected();
            Konference newKonference = cbbKonfernecer.getSelectionModel().getSelectedItem();
            Hotel hotel = lvwHoteller.getSelectionModel().getSelectedItem();
            Udflugt udflugt = lvwUdflugter.getSelectionModel().getSelectedItem();
            Tillæg tillæg = lvwTillæg.getSelectionModel().getSelectedItem();

            tilmelding = Controller.createTilmelding(newKonference,ankomstDato,afresningsDato,erFordragsholder);
            deltager = Controller.createDeltager(navn,alderInt,tlf,adresse);


            if(deltager != null && tilmelding != null){
                Controller.setDeltagerTilTilmelding(tilmelding,deltager);
                if(chbFirma.isSelected()){
                    String firmaNavn = txfFirmaNavn.getText().trim();
                    String firmaTelefon = txfFirmaTlf.getText().trim();
                    String firmaMail = txfFirmaMail.getText().trim();
                    Firma firma = Controller.createFirma(firmaNavn,firmaTelefon,firmaMail);
                    firma.addTilmelding(tilmelding);
                }
                if(chbLedsager.isSelected()){
                    String ledsagerNavn = txfLedsager.getText().trim();
                    tilmelding.setLedsagerNavn(ledsagerNavn);
                }
                if(hotel != null) {
                    hotel.addTilmeldinger(tilmelding);
                }

                if(udflugt != null){
                    udflugt.addTilmelding(tilmelding);
                }

                if(tillæg != null){
                    tilmelding.addTillæg(tillæg);
                }
            }

            txfDeltagerNavn.clear();
            txfAdresse.clear();
            txfTlf.clear();
            txfAlder.clear();
            txfAnkomstDato.clear();
            txfAfrejsningsDato.clear();
            txfFirmaNavn.clear();
            txfFirmaTlf.clear();
            txfFirmaMail.clear();
            txfLedsager.clear();
            chbLedsager.setSelected(false);
            chbFirma.setSelected(false);
            chbFordragsholder.setSelected(false);
            txfHotelNavn.clear();

        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Tilmelding oprettet");
        alert.setContentText("Den total pris er " + tilmelding.getSamletPrisForAlt() + " kr");
        alert.showAndWait();
    }
}
