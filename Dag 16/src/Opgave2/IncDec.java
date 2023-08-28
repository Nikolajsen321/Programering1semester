package Opgave2;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.management.StringValueExp;

public class IncDec extends Application
{
    private int suming;
    private int decInc = 1;
    private TextField txfnumbers = new TextField();

    @Override
    public void start(Stage stage)
    {
        stage.setTitle("IncDec Demo");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }
    public void initContent(GridPane pane)
    {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(40));
        pane.setHgap(2);
        pane.setVgap(5);

        Label numbers = new Label("Number");
        pane.add(numbers,2,2);
//        txfnumbers.setAlignment(Pos.CENTER_RIGHT);
//        txfnumbers.setPrefWidth(0.5);
        pane.add(txfnumbers,3,2);
//        txfnumbers.setEditable(false);
        txfnumbers.setText("0");

        Button increment = new Button("Inc");
        pane.add(increment,4,1);
        Button decrement = new Button("Dec");
        pane.add(decrement,4,3);

        decrement.setOnAction(event -> this.decrement());
        increment.setOnAction(event -> this.increment());
    }

    private void decrement()
    {
//        String sums = "";
//        String startValue = "";
//       startValue = txfnumbers.getText();
//        suming --;
//        sums = Integer.toString(suming);
//        txfnumbers.setText(sums);

        suming = Integer.parseInt(txfnumbers.getText());
        suming -= decInc;
        txfnumbers.setText(Integer.toString(suming));

    }

    private void increment()
    {
        suming = Integer.parseInt(txfnumbers.getText());
        suming += decInc;
        txfnumbers.setText(Integer.toString(suming));
//        String sums = "";
//        suming ++;
//        sums = Integer.toString(suming);
//        txfnumbers.setText(sums);
    }


}
