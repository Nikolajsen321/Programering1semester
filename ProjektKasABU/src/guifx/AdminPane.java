package guifx;

import application.model.Hotel;
import application.model.Konference;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminPane extends GridPane {
    private Button loginBtn;
    private TextField usernameField;
    private PasswordField passwordField;
    private TabPane tabPane;

    private ListView<Hotel> lvwHoteller;

    private ListView<Hotel> lvwTillæg;

    private ListView<Konference> lvwUdflugter;

    public AdminPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);


        Tab tabOpretKonference = new Tab("Opret Konference");
        VBox opretKonferenceLayout = new VBox();

        Label lblKonferenceNavn = new Label("Navn:");
        TextField txfKonferenceNavn = new TextField();
        lblKonferenceNavn.setPrefWidth(80);
        HBox konferenceNavnBox = new HBox();
        konferenceNavnBox.paddingProperty().set(new Insets(10, 0, 20, 10));
        konferenceNavnBox.getChildren().addAll(lblKonferenceNavn, txfKonferenceNavn);

        Label lblKonferenceLocation = new Label("Location:");
        TextField txfKonferenceLocation = new TextField();
        lblKonferenceLocation.setPrefWidth(80);
        HBox konferenceLocationBox = new HBox();
        konferenceLocationBox.paddingProperty().set(new Insets(10, 0, 20, 10));
        konferenceLocationBox.getChildren().addAll(lblKonferenceLocation, txfKonferenceLocation);

        Label lblKonferenceDato = new Label("Dato:");
        TextField txfKonferenceDato = new TextField();
        lblKonferenceDato.setPrefWidth(80);
        HBox konferenceDatoBox = new HBox();
        konferenceDatoBox.paddingProperty().set(new Insets(10, 0, 20, 10));
        konferenceDatoBox.getChildren().addAll(lblKonferenceDato, txfKonferenceDato);

        Label lblKonferencePris = new Label("Pris:");
        TextField txfKonferencePris = new TextField();
        lblKonferencePris.setPrefWidth(80);
        HBox konferencePrisBox = new HBox();
        konferencePrisBox.paddingProperty().set(new Insets(10, 0, 20, 10));
        konferencePrisBox.getChildren().addAll(lblKonferencePris, txfKonferencePris);

        Label lblKonferenceHoteller = new Label("Hoteller:");
        lvwHoteller = new ListView<>();
        lvwHoteller.setPrefWidth(100);
        lvwHoteller.setPrefHeight(200);

        Label lblKonferenceUdflugter = new Label("Udflugter:");
        lvwUdflugter = new ListView<>();
        lvwUdflugter.setPrefWidth(100);
        lvwUdflugter.setPrefHeight(200);

        HBox lblBox = new HBox(lblKonferenceHoteller,lblKonferenceUdflugter);
        lblBox.setSpacing(100);
        lblBox.paddingProperty().set(new Insets(10, 0, 10, 10));

        HBox lvwBox = new HBox(lvwHoteller,lvwUdflugter);
        lvwBox.setSpacing(40);
        lvwBox.paddingProperty().set(new Insets(10, 0, 10, 10));

        Button btnOpretKonference = new Button("Opret Konference");
        Button btnSletKonference = new Button("Slet Konference");

        HBox konferenceBtnBox = new HBox();
        konferenceBtnBox.paddingProperty().set(new Insets(10, 0, 20, 10));
        konferenceBtnBox.getChildren().addAll(btnOpretKonference, btnSletKonference);
        konferenceBtnBox.setSpacing(100);

        opretKonferenceLayout.getChildren().addAll(
                konferenceNavnBox,
                konferenceLocationBox,
                konferenceDatoBox,
                konferencePrisBox,
                lblBox,
                lvwBox,
                konferenceBtnBox
        );


        //----------------------------------------------------------------------------


        Tab tabOpretHotel = new Tab("Opret Hotel");
        VBox opretHotelLayout = new VBox();

        Label lblHotelNavn = new Label("Navn:");
        TextField txfHotelNavn = new TextField();
        lblHotelNavn.setPrefWidth(80);
        HBox hotelNavnBox = new HBox();
        hotelNavnBox.paddingProperty().set(new Insets(20, 0, 20, 10));
        hotelNavnBox.getChildren().addAll(lblHotelNavn, txfHotelNavn);

        Label lblHotelAdresse = new Label("Adresse:");
        TextField txfHotelAdresse = new TextField();
        lblHotelAdresse.setPrefWidth(80);
        HBox hotelAdresseBox = new HBox();
        hotelAdresseBox.paddingProperty().set(new Insets(20, 0, 20, 10));
        hotelAdresseBox.getChildren().addAll(lblHotelAdresse, txfHotelAdresse);

        Label lblPrisDobbelt = new Label("PrisDobbelt:");
        TextField txfPrisDobbelt = new TextField();
        lblPrisDobbelt.setPrefWidth(80);
        HBox prisDobbeltBox = new HBox();
        prisDobbeltBox.paddingProperty().set(new Insets(20, 0, 20, 10));
        prisDobbeltBox.getChildren().addAll(lblPrisDobbelt, txfPrisDobbelt);

        Label lblPrisEnkelt = new Label("PrisEnkelt:");
        TextField txfPrisEnkelt = new TextField();
        lblPrisEnkelt.setPrefWidth(80);
        HBox prisEnkeltBox = new HBox();
        prisEnkeltBox.paddingProperty().set(new Insets(20, 0, 20, 10));
        prisEnkeltBox.getChildren().addAll(lblPrisEnkelt, txfPrisEnkelt);

        Button btnOpretHotel = new Button("Opret Hotel");
        Button btnSletHotel = new Button("Slet Hotel");
        HBox hotelBtnBox = new HBox();
        hotelBtnBox.paddingProperty().set(new Insets(20, 0, 20, 10));
        hotelBtnBox.getChildren().addAll(btnOpretHotel, btnSletHotel);
        hotelBtnBox.setSpacing(100);

        opretHotelLayout.getChildren().addAll(
                hotelNavnBox,
                hotelAdresseBox,
                prisDobbeltBox,
                prisEnkeltBox,
                hotelBtnBox
        );
        tabOpretHotel.setContent(opretHotelLayout);

        //----------------------------------------------------------------------------

        Tab tabOpretUdflugt = new Tab("Opret Udflugt");
        VBox opretUdflugtLayout = new VBox();

        Label lblUdflugtNavn = new Label("Navn:");
        TextField txfUdflugtNavn = new TextField();
        lblUdflugtNavn.setPrefWidth(80);
        HBox udflugtNavnBox = new HBox();
        udflugtNavnBox.paddingProperty().set(new Insets(20, 0, 20, 10));
        udflugtNavnBox.getChildren().addAll(lblUdflugtNavn, txfUdflugtNavn);

        Label lblUdflugtLocation = new Label("Location:");
        TextField txfUdflugtLocation = new TextField();
        lblUdflugtLocation.setPrefWidth(80);
        HBox udflugtLocationBox = new HBox();
        udflugtLocationBox.paddingProperty().set(new Insets(20, 0, 20, 10));
        udflugtLocationBox.getChildren().addAll(lblUdflugtLocation, txfUdflugtLocation);

        Label lblStartDato = new Label("Start Dato:");
        TextField txfStartDato = new TextField();
        lblStartDato.setPrefWidth(80);
        HBox startDatoBox = new HBox();
        startDatoBox.paddingProperty().set(new Insets(20, 0, 20, 10));
        startDatoBox.getChildren().addAll(lblStartDato, txfStartDato);

        Label lblSlutDato = new Label("Slut Dato:");
        TextField txfSlutDato = new TextField();
        lblSlutDato.setPrefWidth(80);
        HBox slutDatoBox = new HBox();
        slutDatoBox.paddingProperty().set(new Insets(20,0,20,10));
        slutDatoBox.getChildren().addAll(lblSlutDato,txfSlutDato);

        Button btnOpretUdflugt = new Button("Opret Udflugt");
        Button btnSletUdflugt = new Button("Slet Udflugt");
        HBox udflugtBtnBox = new HBox();
        udflugtBtnBox.paddingProperty().set(new Insets(20, 0, 20, 10));
        udflugtBtnBox.getChildren().addAll(btnOpretUdflugt,btnSletUdflugt);
        udflugtBtnBox.setSpacing(100);

        opretUdflugtLayout.getChildren().addAll(
                udflugtNavnBox,
                udflugtLocationBox,
                startDatoBox,
                slutDatoBox,
                udflugtBtnBox
        );

        //----------------------------------------------------------------------------

        Tab tabAddTillæg = new Tab("Add Tillæg");
        VBox addTillægLayout = new VBox();

        Label lblTillægNavn = new Label("Navn:");
        TextField txfTillægNavn = new TextField();
        lblTillægNavn.setPrefWidth(80);
        HBox tillægNavnBox = new HBox(lblTillægNavn, txfTillægNavn);
        tillægNavnBox.paddingProperty().set(new Insets(20, 0, 20, 10));

        Label lblTillægPris = new Label("Pris:");
        TextField txfTillægPris = new TextField();
        lblTillægPris.setPrefWidth(80);
        HBox tillægPrisBox = new HBox(lblTillægPris, txfTillægPris);
        tillægPrisBox.paddingProperty().set(new Insets(20, 0, 20, 10));

        Label lblHoteller = new Label("Hoteller:");
        lvwHoteller = new ListView<>();
        lvwHoteller.setPrefSize(100, 200);

        Label lblTillæg = new Label("Tillæg:");
        lvwTillæg = new ListView<>();
        lvwTillæg.setPrefSize(100, 200);

        HBox lblBox1 = new HBox(lblHoteller, lblTillæg);
        lblBox1.setSpacing(100);
        lblBox1.paddingProperty().set(new Insets(10, 0, 10, 10));

        HBox lvwBox1 = new HBox(lvwHoteller, lvwTillæg);
        lvwBox1.setSpacing(40);
        lvwBox1.paddingProperty().set(new Insets(10, 0, 10, 10));

        Button btnAddTillæg = new Button("Add Tillæg");
        Button btnSletTillæg = new Button("Slet Tillæg");
        HBox tillægBtnBox = new HBox();
        tillægBtnBox.paddingProperty().set(new Insets(20, 0, 20, 10));
        tillægBtnBox.getChildren().addAll(btnAddTillæg, btnSletTillæg);
        tillægBtnBox.setSpacing(100);

        addTillægLayout.getChildren().addAll(
                tillægNavnBox,
                tillægPrisBox,
                lblBox1,
                lvwBox1,
                tillægBtnBox
        );

        //----------------------------------------------------------------------------


        loginBtn = new Button("Login");
        usernameField = new TextField();
        passwordField = new PasswordField();
        tabPane = new TabPane();

        GridPane loginPane = new GridPane();
        loginPane.setHgap(10);
        loginPane.setVgap(10);
        loginPane.addRow(0, new Label("Brugernavn:"), usernameField);
        loginPane.addRow(1, new Label("Adgangskode:"), passwordField);
        loginPane.addRow(2, new Label(""), loginBtn);


        this.add(loginPane, 0, 0);
        this.add(tabPane, 0, 1);

        loginBtn.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            if (isValidAdminLogin(username, password)) {
                TabPane tabPane = new TabPane();
                tabPane.getTabs().addAll(
                        new Tab("Opret Konference", opretKonferenceLayout),
                        new Tab("Opret Hotel", opretHotelLayout),
                        new Tab("Opret Udflugt", opretUdflugtLayout),
                        new Tab("Add Tillæg", addTillægLayout)
                );
                Scene scene = new Scene(tabPane, 400, 450);
                Stage stage = new Stage();
                stage.setTitle("Administratorvindue");
                stage.setScene(scene);
                stage.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Ugyldige login-oplysninger");
                alert.setContentText("Indtast venligst korrekte login-oplysninger og prøv igen.");
                alert.showAndWait();
            }
        });
    }

    private boolean isValidAdminLogin(String username, String password) {
        return username.equals("admin") && password.equals("1234");
    }
}

