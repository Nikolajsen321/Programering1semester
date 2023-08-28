package Opgave1;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GuiListViewExercise extends Application {
    private TextField txfName = new TextField();
    private TextField txfTitel = new TextField();
    CheckBox chbSenior = new CheckBox("Senior");
    private ListView<Person> lvwPerson = new ListView<>();
    private ArrayList<Person> person = new ArrayList<>();



    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("ListView Demo4");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }

    private void initContent(GridPane pane) {
        this.initPerson();
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(40));
        pane.setHgap(20);
        pane.setVgap(20);

        Label lbtName = new Label("Name");
        pane.add(lbtName,0,0);
        pane.add(txfName,1,0);
        GridPane.setValignment(lbtName,VPos.TOP);

        Label lbtTitel = new Label("Titel");
        pane.add(lbtTitel,0,1);
        GridPane.setValignment(lbtTitel, VPos.TOP);
        pane.add(txfTitel,1,1);

        pane.add(lvwPerson,1,3);
        lvwPerson.setPrefWidth(200);
        lvwPerson.setPrefHeight(200);
        lvwPerson.getItems().setAll(person);

        ChangeListener<Person> listener = (ov, oldString , newString) -> this.personItemSelected();
        lvwPerson.getSelectionModel().selectedItemProperty().addListener(listener);

        Button btnAdd = new Button("Add Person");
        pane.add(btnAdd,3,0);
        btnAdd.setOnAction(event -> this.addAction());

        pane.add(chbSenior,1,2);
    }

    private void addAction() {
        String name = txfName.getText().trim();
        String titel = txfTitel.getText().trim();
        boolean senior = chbSenior.isSelected();
        if(name.length() > 0  && titel.length() > 0)
        {
            Person p = new Person(name, titel,senior);
            person.add(p);
            lvwPerson.getItems().setAll(person);
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("add en person");
            alert.setHeaderText("No name or titel typed");
            alert.setContentText("Type the name and titel of the person");
            alert.show();
        }
    }

    private void personItemSelected() {
        Person selected = lvwPerson.getSelectionModel().getSelectedItem();
        if(selected != null)
        {
            txfName.setText(selected.toString());
        }else{
            txfName.clear();
        }
    }

    private void initPerson() {
        person.add(new Person("Hans","Købmand"));
        person.get(0).setSenior(true);
        person.add(new Person("Mikkel","Sælger"));
        person.get(1).setSenior(false);
        person.add(new Person("Lars","Programør"));
        person.get(2).setSenior(false);

    }
}
