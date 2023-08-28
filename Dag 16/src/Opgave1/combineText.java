package Opgave1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class combineText extends Application {

    private TextField txfFirstName = new TextField();
    private TextField txfLastName = new TextField();
    private TextField txfCombine = new TextField();


    @Override
    public void start(Stage stage)
    {
        stage.setTitle("combineText");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(50));

        pane.setHgap(10);

        pane.setVgap(10);


        Label labelName = new Label("First Name ");
        pane.add(labelName,0,0);
        pane.add(txfFirstName,0,1,1,1);

        Label labelLastName = new Label("Last Name");
        pane.add(labelLastName,3,0);
        pane.add(txfLastName,2,1,3,1);

        Label combineName = new Label("Full name");
        pane.add(combineName,0,3);
        pane.add(txfCombine,0,4,6,3);

        Button buttonCommbine = new Button("Combine");
        pane.add(buttonCommbine,4,7);
        buttonCommbine.setOnAction(event -> this.combine());
    }

    private void combine() {
        String firstName = "";
        String lastName = "";
        firstName =txfFirstName.getText() + " ";
        lastName = txfLastName.getText();
        txfCombine.setText(firstName + lastName);
    }
}
