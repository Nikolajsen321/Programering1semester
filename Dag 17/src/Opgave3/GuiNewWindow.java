package Opgave3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.ArrayList;

public class GuiNewWindow extends Application {

    private ListView<Person> lswPerson = new ListView<>();
    private ArrayList<Person> person = new ArrayList<>();
    private AddWindow personWindow;
   private Button btnADD = new Button("Add");
    private CheckBox chbSenior = new CheckBox("Senior");


    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Velkommen");
        GridPane pane  = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
        personWindow = new AddWindow("Create a person ",stage);

    }

    private void initContent(GridPane pane) {
        this.initPerson();
        pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(60));
        pane.setVgap(20);
        pane.setHgap(20);

        Label lblPerson = new Label("Persons:");
        pane.add(lblPerson,0,0);


        pane.add(lswPerson,0,1);
        lswPerson.setPrefWidth(200);
        lswPerson.setPrefHeight(200);
        lswPerson.getItems().setAll(person);

        pane.add(btnADD,2,0);
        btnADD.setPrefWidth(90);
        btnADD.setOnAction(event -> this.addAction());

    }

    private void addAction() {
        personWindow.showAndWait();
        // wait for dialog to close
        if(personWindow.getAktuelPerson() != null) {
            Person person1 = personWindow.getAktuelPerson();
            boolean senior = personWindow.setPersonisSenior();
            person1.setSenior(senior);
            person.add(person1);
            lswPerson.getItems().setAll(person);
        }
    }

    private void initPerson() {
        person.add(new Person("Morten","Lastbilchauffør"));
        person.get(0).setSenior(true);

    }


}
