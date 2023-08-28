package Opgave3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Investment extends Application {

    private TextField txfinvestment = new TextField();
    private TextField txfYears = new TextField();
    private TextField txfInteres = new TextField();
    private TextField txfFutureValue = new TextField();

    private double investMent = 0;
    private double nrYears = 0;
    private double monthlyInterest = 0;


   private Button button = new Button("Calculate");


    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Investment");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(30));
        pane.setHgap(3);
        pane.setVgap(20);

        Label investment = new Label("Investment");
        pane.add(investment,0,0);
        pane.add(txfinvestment,1,0);

        Label years = new Label("Years");
        pane.add(years,0,1);
        pane.add(txfYears,1,1);

        Label interest = new Label("Interest\n(in procent)");
        Label procent = new Label("%");
        pane.add(interest,0,2);
        pane.add(txfInteres,1,2);
        pane.add(procent,2,2);

        Label future = new Label("Future value");
        pane.add(future,0,4);
        pane.add(txfFutureValue,1,4);

        pane.add(button,1,3);
        button.setOnAction(event -> this.compute() );

    }

    private void compute() {

        double investment = 0;
        double years = 0;
        double interest = 0;
        double faktor1 = 0;

        investment = Double.parseDouble(txfinvestment.getText());
        years = Double.parseDouble(txfYears.getText());
        interest = Double.parseDouble(txfInteres.getText()) /100;
        investment = investment * Math.pow((1+interest),years);

//       for(int i = 0; i < years; i ++)
//        {
//            faktor1 = (1 + interest);
//            investment = faktor1 * investment;
//        }
        txfFutureValue.setText(Double.toString(investment));
    }
}
