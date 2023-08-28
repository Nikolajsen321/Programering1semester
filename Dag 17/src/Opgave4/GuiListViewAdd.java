package Opgave4;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;


public class GuiListViewAdd extends Application {
    private Label lblTxt = new Label("Radio Buttoum");
    private ToggleGroup group = new ToggleGroup();
    private ListView<String> lswBoy = new ListView<>();
    private TextField txfName = new TextField();
    private ArrayList<String> listOfBoysName = new ArrayList<>();
    private ArrayList<String> listOfGirlName = new ArrayList<>();
    private String[] boyGirl = {};


    @Override
    public void start(Stage stage){
        stage.setTitle("Velkommen");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();



    }

    private void initContent(GridPane pane) {
        this.initBoy();
        pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(40));
        pane.setVgap(10);
        pane.setHgap(10);

        Label boyNames = new Label("Names");
        pane.add(boyNames,0,1);
        pane.add(lswBoy,1,2);
        lswBoy.setPrefHeight(100);
        lswBoy.setPrefHeight(190);
        lswBoy.getItems().setAll(listOfBoysName);

        Label boyName = new Label("Name");
        pane.add(boyName,0,3);
        pane.add(txfName,1,3);

        Button btnAdd = new Button("Add");
        pane.add(btnAdd,2,2);
        btnAdd.setOnAction(event -> this.addAction());

        ChangeListener<String> listener = (ov,oldString,newString) ->this.selectionChanged();
        lswBoy.getSelectionModel().selectedItemProperty().addListener(listener);




    }


    private void addAction() {
        String name = txfName.getText().trim();
        if(name.length() > 0){
            listOfBoysName.add(name);
            lswBoy.getItems().setAll(listOfBoysName);
            txfName.clear();
        }
    }

    private void selectionChanged() {
        String selected = lswBoy.getSelectionModel().getSelectedItem();
        if(selected != null){
            txfName.setText(selected);

        }else{
            txfName.clear();
        }
    }

    private void initBoy() {
        listOfBoysName.add(new Boy("Henrik").makeBoyString());

    }


}
