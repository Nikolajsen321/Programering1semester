package Opgave6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.ArrayList;

public class GUI extends Application {
    private TextField txfName = new TextField();
    private TextField txfAge = new TextField();
    private TextArea txaInfo = new TextArea();
    private Button button;
    private Button dltButton;
    private Button crtButton;
    private Button updButton;
    private Student student = new Student();
    private int inc = 1;
    private int age = 0;

    public void start(Stage stage){
        stage.setTitle("Øvelse 6");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(40));
        pane.setHgap(10);
        pane.setVgap(10);

        Label info = new Label("Student info:");
        pane.add(info,0,0);
        pane.add(txaInfo,0,1,7,1);
        txaInfo.setPrefRowCount(7);
        txaInfo.setEditable(false);
        txaInfo.setPrefWidth(300);

        Label name = new Label("Navn");
        pane.add(name,0,3);
        pane.add(txfName,1,3);

        Label alder = new Label("Alder");
        pane.add(alder,0,4);
        pane.add(txfAge,1,4);
        txfAge.setText(Integer.toString(0));
        txfAge.setOnAction(event -> giveAge());

        CheckBox checkBox = new CheckBox();
        checkBox.setText("Active");
        pane.add(checkBox,0,5);

        checkBox.setOnAction(event -> {
            if(checkBox.isSelected()){
                this.activeAction();
            }else{
                this.unactiveAction();
            }
        });

//        Button increment = new Button("Inc");
//        pane.add(increment,2,4);
//        increment.setOnAction(event ->incremnting());

        button = new Button("Inc");
        pane.add(button,2,4);
        button.setOnAction(event ->incremnting());

//        Button reset = new Button("Reset");
//        pane.add(reset,3,4);
//        reset.setOnAction(event -> reseting());

        button = new Button("Reset");
        pane.add(button,3,4);
        button.setOnAction(event -> reseting());

//        Button create = new Button("create");
//        pane.add(create,1,7);
//        create.setOnAction(event -> creating());

        crtButton = new Button("Create");
        pane.add(crtButton,1,7);
        crtButton.setOnAction(event -> creating());

//        Button update = new Button("Update");
//        pane.add(update,2,7);

        updButton = new Button("Update");
        pane.add(updButton,2,7);
        updButton.setOnAction(event -> setupdate());
        updButton.setDisable(true);

//        Button delete = new Button("Delete");
//        pane.add(delete,3,7);

        dltButton = new Button("Delete");
        pane.add(dltButton,3,7);
        dltButton.setOnAction(event -> setdelete());
        dltButton.setDisable(true);
    }
    private void activeAction() {
        student.setActive(true);
    }

    private void unactiveAction() {
        student.setActive(false);
    }

    private String giveAge() {
        String getText = "";
        getText = txfAge.getText();
        return getText;
    }
    private void incremnting() {
        age = Integer.parseInt(txfAge.getText());
        age += inc;
        txfAge.setText(Integer.toString(age));
    }

    private void reseting() {
        txfName.setText(student.getName());
        txfAge.setText(Integer.toString(student.getAge()));
    }

    private void creating() {
        StringBuilder sb = new StringBuilder();
        student.setName(txfName.getText());
        student.setAge(Integer.parseInt(giveAge()));
        sb.append(student.toString());
        txaInfo.setText(sb.toString());
        txfAge.setText("0");
        txfName.setText("");
        crtButton.setDisable(true);
        updButton.setDisable(false);
        dltButton.setDisable(false);
    }

    private void setupdate() {
        StringBuilder sb = new StringBuilder();
        int tempInt = 0;

        if(!(student.getName().equals(txfName.getText())))
        {
            student.setName( txfName.getText());
        }
        if(student.getAge() != age)
        {
            student.setAge(Integer.parseInt(giveAge()));
        }
        sb.append(student.toString());
        txaInfo.setText(sb.toString());
    }

    private void setdelete() {
        txaInfo.setText("");
        txfAge.setText("0");
        student.setName("");
        txfName.setText("");
        student.setAge(0);
        crtButton.setDisable(false);
        updButton.setDisable(true);
        dltButton.setDisable(true);
    }
}
