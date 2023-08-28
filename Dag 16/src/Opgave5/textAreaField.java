package Opgave5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class textAreaField extends Application {

    private TextField txfName = new TextField();
    private TextArea txaList = new TextArea();

    private ArrayList<String> listName = new ArrayList<>();

    private String name = "";

    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Liste");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(GridPane pane)
    {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(40));
        pane.setHgap(10);
        pane.setVgap(10);

        Label name = new Label("Name");
        pane.add(name,0,0);
        pane.add(txfName,0,1);
        txfName.setPrefWidth(200);

        pane.add(txaList,0,3);
//        txaList.setPrefRowCount(7);
        txaList.setPrefWidth(270);
        txaList.setEditable(false);

        Button button = new Button("Add");
        button.setPrefWidth(80);
        pane.add(button,1,2);
        button.setOnAction(event -> this.add());

    }

    private void add() {
        name = txfName.getText();
        txaList.setText(this.getDescription(name));
    }

    public String getDescription(String name ) {
        String outPutNames = "";
        StringBuilder sb = new StringBuilder();
        listName.add(name);

        for(int i = 0; i < listName.size(); i++) {
           outPutNames += listName.get(i) + "\n";
        }

        sb.append(outPutNames);
        return sb.toString();
    }

}
