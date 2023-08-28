package Opgave5;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GuiToggleAndListView extends Application {
    private Label lblTxt = new Label("Radio Buttom example");
    private Button btnADD = new Button("Add");
    private ToggleGroup group = new ToggleGroup();
    private ListView<String> lswListOfBoyAndGirl = new ListView<>();
    ArrayList<String> arrayListOfBoyName = new ArrayList<>();
    ArrayList<String> arraylistOfGirlName = new ArrayList<>();
    private TextField txfOfNames = new TextField();


    @Override
    public void start(Stage stage) {
        stage.setTitle("Velkommen til mit toggle program");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(GridPane pane) {
        // vis eller gem Gridlines
//        pane.setGridLinesVisible(true);
//        sætter padding for pane
        pane.setPadding(new Insets(40));
        // sætter vertikal mellemrum
        pane.setHgap(10);
        //sætter horisontal mellemrum
        pane.setVgap(10);

        //tilføjer et label til pane ved (col = 0 og row = 0)
        Label lablName = new Label("Name");
        pane.add(lablName,0,0);
        // add a labe
        Label lblNames = new Label("Names");
        pane.add(lblNames,0,2);
        GridPane.setValignment(lblNames, VPos.TOP);

        pane.add(txfOfNames,1,0);

        HBox box = new HBox();
        pane.add(box,1,1);

        //Drenge kanp
        RadioButton rb1 = new RadioButton();
        box.getChildren().add(rb1);
        rb1.setText("Drenge");
        rb1.setPrefWidth(200);
        rb1.setUserData(arrayListOfBoyName);
        rb1.setToggleGroup(group);
        rb1.setOnAction(event->setListType());
        //Pige knap
        RadioButton rb2 = new RadioButton();
        box.getChildren().add(rb2);
        rb2.setText("Piger");
        rb2.setPrefWidth(200);
        rb2.setUserData(arraylistOfGirlName);
        rb2.setToggleGroup(group);
        rb2.setOnAction(event->setListType());

        //Knap markeret fra start
        RadioButton rb0 = (RadioButton) group.getToggles().get(0);
        rb0.setSelected(true);

        // add a listView to the pane(at col=1, row=1)
        initNames();
        pane.add(lswListOfBoyAndGirl,1, 2);
        lswListOfBoyAndGirl.setPrefWidth(200);
        lswListOfBoyAndGirl.setPrefHeight(200);
        lswListOfBoyAndGirl.getItems().setAll((arrayListOfBoyName));


        ChangeListener<String> listener = (ov,oldString,newString) ->this.selectionChanged();
        lswListOfBoyAndGirl.getSelectionModel().selectedItemProperty().addListener(listener);

        Button btnAdd = new Button("Add");
        pane.add(btnAdd,4,0);
        btnAdd.setOnAction(event ->this.addAction());

        Button btnDel = new Button("Delete");
        pane.add(btnDel,5,0);
        btnDel.setOnAction(event -> this.delAction());
    }

    private void delAction() {
        String name = txfOfNames.getText().trim();
        if(name.length() > 0 ){
            RadioButton rb = (RadioButton) group.getSelectedToggle();
            if(rb.getUserData() == arrayListOfBoyName){
                arrayListOfBoyName.remove(lswListOfBoyAndGirl.getSelectionModel().getSelectedItem());
                lswListOfBoyAndGirl.getItems().setAll(arrayListOfBoyName);
            }else if(rb.getUserData() == arraylistOfGirlName){
                arraylistOfGirlName.remove(lswListOfBoyAndGirl.getSelectionModel().getSelectedItem());
                lswListOfBoyAndGirl.getItems().setAll(arraylistOfGirlName);
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Select input ");
            alert.setHeaderText("Not selected");
            alert.setContentText("Select something before deleting");
            alert.show();
        }
    }

    private void addAction() {
        String name = txfOfNames.getText().trim();
        if(name.length() > 0 ){
            RadioButton rb = (RadioButton) group.getSelectedToggle();
            if(rb.getUserData() == arrayListOfBoyName){
                arrayListOfBoyName.add(name);
                lswListOfBoyAndGirl.getItems().setAll(arrayListOfBoyName);
            }else if(rb.getUserData() == arraylistOfGirlName){
                arraylistOfGirlName.add(name);
                lswListOfBoyAndGirl.getItems().setAll(arraylistOfGirlName);
            }

        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Select input ");
            alert.setHeaderText("Not selected");
            alert.setContentText("Select something before deleting");
            alert.show();
        }
    }

    private void selectionChanged() {
        String selected = lswListOfBoyAndGirl.getSelectionModel().getSelectedItem();
        if(selected != null){
            txfOfNames.setText(selected);
        }else{
            txfOfNames.clear();
        }
    }

    private void initNames(){
        arrayListOfBoyName.add("Per");
        arrayListOfBoyName.add("Ove");
        arrayListOfBoyName.add("Mikkel");

        arraylistOfGirlName.add("Signe");
        arraylistOfGirlName.add("Mie");
        arraylistOfGirlName.add("Hanne");

    }

    private void setListType() {
        RadioButton rb = (RadioButton) group.getSelectedToggle();
        ArrayList<String> list = (ArrayList) rb.getUserData();
        lswListOfBoyAndGirl.getItems().setAll(list);
    }
}
