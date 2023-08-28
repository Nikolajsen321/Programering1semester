package guifx;

import application.controller.Controller;
import application.model.Hotel;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HotelPane extends GridPane {
    private ListView<Hotel> lvwHoteller;
    private TextArea txaInfo;

    public HotelPane(){
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        VBox vbox1 = new VBox();
        vbox1.paddingProperty().set(new Insets(0, 40, 20, 20));

        VBox vbox2 = new VBox();
        vbox2.paddingProperty().set(new Insets(0, 40, 20, 0));

        HBox valueContainer = new HBox(vbox1, vbox2);
        this.add(valueContainer, 0, 0);

        Label lblHotel = new Label("Hoteller:");
        lblHotel.paddingProperty().set(new Insets(0,0,10,0));
        vbox1.getChildren().add(lblHotel);

        lvwHoteller = new ListView<>();
        vbox1.getChildren().add(lvwHoteller);
        lvwHoteller.setPrefWidth(200);
        lvwHoteller.setPrefHeight(200);
        lvwHoteller.getItems().setAll(Controller.getHoteller());

        ChangeListener<Hotel> listener = (ov, oldHotel, newHotel) -> this.selectedHotelChanged();
        lvwHoteller.getSelectionModel().selectedItemProperty().addListener(listener);

        Label lblInfo = new Label("Information:");
        lblInfo.paddingProperty().set(new Insets(0,0,10,0));
        vbox2.getChildren().add(lblInfo);

        txaInfo = new TextArea();
        vbox2.getChildren().add(txaInfo);
        txaInfo.setPrefWidth(200);
        txaInfo.setPrefHeight(100);
        txaInfo.setEditable(false);

    }

    private void selectedHotelChanged(){
        this.updateControls();
    }

    public void updateControls(){
        Hotel hotel = lvwHoteller.getSelectionModel().getSelectedItem();
        if (hotel != null) {
            txaInfo.setText(hotel.getHotelOversigt());
        } else {
            txaInfo.clear();
        }
    }

}
