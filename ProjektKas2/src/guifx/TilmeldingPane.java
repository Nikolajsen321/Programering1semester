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
import java.util.Date;
import java.util.List;

public class TilmeldingPane extends GridPane {

    private TextField txfDeltagerNavn, txfAdresse, txfAlder, txfTlf,
            txfHotelNavn, txfAnkomstDato, txfAfresningsDato,
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

        txfDeltagerNavn = new TextField();
        HBox deltagerNavn = new HBox(lblDeltagerNavn, txfDeltagerNavn);
        deltagerNavn.paddingProperty().set(new Insets(0, 0, 10, 0));
        vbox1.getChildren().add(deltagerNavn);

        //------------------------------------------------------------------------------------------

        Label lblAdresse = new Label("Adresse:");
        lblAdresse.setPrefWidth(80);

        txfAdresse = new TextField();
        HBox adresse = new HBox(lblAdresse, txfAdresse);
        adresse.paddingProperty().set(new Insets(0, 0, 10, 0));
        vbox1.getChildren().add(adresse);

        //------------------------------------------------------------------------------------------

        Label lblAlder = new Label("Alder:");
        lblAlder.setPrefWidth(80);

        txfAlder = new TextField();
        HBox alder = new HBox(lblAlder, txfAlder);
        alder.paddingProperty().set(new Insets(0, 0, 10, 0));
        vbox1.getChildren().add(alder);

        //------------------------------------------------------------------------------------------

        Label lblTlf = new Label("Telefon:");
        lblTlf.setPrefWidth(80);

        txfTlf = new TextField();
        HBox tlf = new HBox(lblTlf, txfTlf);
        tlf.paddingProperty().set(new Insets(0, 0, 10, 0));
        vbox1.getChildren().add(tlf);

        //------------------------------------------------------------------------------------------

        chbLedsager = new CheckBox("Ledsager:");
        chbLedsager.setOnAction(event -> selectedLedsager(chbLedsager.isSelected()));
        vbox1.getChildren().add(chbLedsager);
        chbLedsager.setPrefWidth(80);

        txfLedsager = new TextField();
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
        cbbKonfernecer.getItems().setAll(Controller.getOrganisation().getKonerencer());

        ChangeListener<Konference> listener = (ov, oldKonference, newKonference) -> this.selectedKonferenceChanged();
        cbbKonfernecer.getSelectionModel().selectedItemProperty().addListener(listener);

        //------------------------------------------------------------------------------------------

        Label lblUdflugter = new Label("Udflugter:");
        lblUdflugter.setPrefWidth(80);

        lvwUdflugter = new ListView<>();
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

        //txfAnkomstDato = new TextField();
        dpAnkomst = new DatePicker();
        HBox ankomstDato = new HBox(lblAnkomstDato, dpAnkomst);
        ankomstDato.paddingProperty().set(new Insets(0, 0, 10, 0));
        vbox2.getChildren().add(ankomstDato);

        // -------------------------------------------------------------------------

        Label lblAfrejsningsDato = new Label("AfrejsningsDato:");
        lblAfrejsningsDato.setPrefWidth(80);

        //txfAfresningsDato = new TextField();
        dpAfrejse = new DatePicker();
        HBox afresningsDato = new HBox(lblAfrejsningsDato, dpAfrejse);
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

        txfFirmaNavn = new TextField();
        HBox firmaNavn = new HBox(lblFirmaNavn, txfFirmaNavn);
        firmaNavn.paddingProperty().set(new Insets(10, 0, 10, 0));
        vbox3.getChildren().add(firmaNavn);
        txfFirmaNavn.setDisable(true);

        // -------------------------------------------------------------------------

        Label lblFirmaTlf = new Label("Telefon:");
        lblFirmaTlf.setPrefWidth(80);

        txfFirmaTlf = new TextField();
        HBox firmaTlf = new HBox(lblFirmaTlf, txfFirmaTlf);
        firmaTlf.paddingProperty().set(new Insets(0, 0, 10, 0));
        vbox3.getChildren().add(firmaTlf);
        txfFirmaTlf.setDisable(true);

        // -------------------------------------------------------------------------

        Label lblFirmaMail = new Label("Mail:");
        lblFirmaMail.setPrefWidth(80);

        txfFirmaMail = new TextField();
        HBox firmaMail = new HBox(lblFirmaMail, txfFirmaMail);
        firmaMail.paddingProperty().set(new Insets(0, 0, 10, 0));
        vbox3.getChildren().add(firmaMail);
        txfFirmaMail.setDisable(true);

        // -------------------------------------------------------------------------

        Label lblVærelse = new Label("Værelser:");

//        lvwVærelser = new ListView<>();
//        lvwVærelser.setPrefWidth(100);
//        lvwVærelser.setPrefHeight(100);
        txaVærelse = new TextArea();
        txaVærelse.setPrefWidth(100);
        txaVærelse.setPrefHeight(100);

        HBox værelserHBox = new HBox(lblVærelse, txaVærelse);
        vbox3.getChildren().add(værelserHBox);

        Label lblTillæg = new Label("Tillæg:");
        lvwTillæg = new ListView<>();
        lvwTillæg.setPrefWidth(100);
        lvwTillæg.setPrefHeight(100);

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
            txaVærelse.setText(sb.toString() + "kr Dobbelt værelse");
        } else {
            sb.append(String.valueOf(hotel.getPrisEnkelt()));
            txaVærelse.setText(sb.toString() + "kr Enkelt værelse");
        }
        lvwTillæg.getItems().setAll(hotel.getTillægs());
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
        String ankomstDato = txfAnkomstDato.getText().trim();
        String afresningsDato = txfAfresningsDato.getText().trim();
        if(navn.length() > 0 &&
                adresse.length() > 0 &&
                tlf.length() >= 8 &&
                alder.length() > 0 &&
                ankomstDato != null &&
                afresningsDato != null) {
            txfDeltagerNavn.clear();
            txfAdresse.clear();
            txfTlf.clear();
            txfAlder.clear();
            txfAnkomstDato.clear();
            txfAfresningsDato.clear();

        }
    }
}
