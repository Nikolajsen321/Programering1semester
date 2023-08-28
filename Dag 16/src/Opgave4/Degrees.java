package Opgave4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Degrees extends Application {
    private TextField txfFar = new TextField();
    private TextField txfCel = new TextField();

    private double celsius = 0;
    private double fahrenheit = 0;
    private double changeDeg = 0;


    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Temperature");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(40));
        pane.setHgap(20);
        pane.setVgap(20);

        Label navn = new Label("Omregner");
        Label fahrenheit = new Label("F°");
        Label celsius = new Label("C°");

        pane.add(navn,0,0,2,1);

        pane.add(celsius,0,1);
        pane.add(txfCel,1,1);


        pane.add(fahrenheit,2,1);
        pane.add(txfFar,3,1);

        txfCel.setOnAction(event -> this.changeCel());
        txfFar.setOnAction(event -> this.changeFar());
    }

    private void changeCel() {
        changeDeg = 0;
        celsius = Double.parseDouble(txfCel.getText());
        changeDeg = 1.8 * celsius + 32;
        txfFar.setText(Double.toString(changeDeg));
    }
    private void changeFar() {
        changeDeg = 0;
        fahrenheit = Double.parseDouble(txfFar.getText());
        changeDeg = (fahrenheit - 32)/1.8;
        txfCel.setText(Double.toString(changeDeg));
    }
}
