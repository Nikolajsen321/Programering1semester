package Opgave3;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AddWindow extends Stage {
    private TextField txfNavn = new TextField();
    private TextField txfTitle = new TextField();
    private Person aktuelPerson = null;
    private CheckBox isSenior = new CheckBox("senior");


    public AddWindow(String title, Stage owner)
    {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);

    }

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblNavn = new Label("Navn");
        pane.add(lblNavn,0,0);
        pane.add(txfNavn,1,0,2,1);

        Label lblTitel = new Label("Titel");
        pane.add(lblTitel,0,1);
        pane.add(txfTitle,1,1,2,1);

        pane.add(isSenior,0,2);
        isSenior.setOnAction(event -> setPersonisSenior());





        HBox buttonBox = new HBox(20);
        pane.add(buttonBox,0,3);
        buttonBox.setPadding(new Insets(10,10,0,10));
        buttonBox.setAlignment(Pos.TOP_RIGHT);

        Button btnCancel = new Button("Cancel");
        buttonBox.getChildren().add(btnCancel);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        buttonBox.getChildren().add(btnOK);
        btnOK.setOnAction(event -> this.okAction());





    }

    private void okAction() {
        String navn = txfNavn.getText().trim();
        String title = txfTitle.getText().trim();
        if(title.length() > 0 && navn.length() > 0 ){
            aktuelPerson = new Person(navn,title);
            txfNavn.clear();
            txfTitle.clear();
            txfTitle.requestFocus();
            AddWindow.this.hide();
        }else{
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
          alert.setTitle("Create person");
          alert.setHeaderText("Information mangler");
          alert.setContentText("Type navn og title");
          alert.show();
        }

    }
    public Person getAktuelPerson(){
        return aktuelPerson;
    }
    public void clearAktuelPerson()
    {
        aktuelPerson = null;
    }

    public boolean setPersonisSenior()
    {
       boolean senior = isSenior.isSelected();
       return senior;


    }


    private void cancelAction() {
        isSenior.setSelected(false);
        txfNavn.clear();
        txfNavn.requestFocus();
        txfTitle.clear();
        aktuelPerson = null;
        AddWindow.this.hide();
    }





}

