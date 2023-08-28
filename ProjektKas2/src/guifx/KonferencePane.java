package guifx;

import application.controller.Controller;
import application.model.Konference;
import application.model.Tilmelding;
import application.model.Udflugt;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import storage.Storage;

public class KonferencePane extends GridPane {
    private ListView<Konference> lvwKonferencer;

    private ListView<Konference> lvwUdflugter;

    private TextArea txaInfo, txaUdflugter;

   public KonferencePane(){
       this.setPadding(new Insets(20));
       this.setHgap(20);
       this.setVgap(10);
       this.setGridLinesVisible(false);

       VBox vbox1 = new VBox();
       vbox1.paddingProperty().set(new Insets(0, 40, 20, 20));

       VBox vbox2 = new VBox();
       vbox2.paddingProperty().set(new Insets(0, 40, 20, 0));

       VBox vbox3 = new VBox();
       vbox3.paddingProperty().set(new Insets(0, 40, 20, 0));

       HBox valueContainer = new HBox(vbox1, vbox2, vbox3);
       this.add(valueContainer, 0, 0);

       Label lblkon = new Label("Konferencer:");
       lblkon.paddingProperty().set(new Insets(0, 0, 10, 0));
       vbox1.getChildren().add(lblkon);

       lvwKonferencer = new ListView<>();
       vbox1.getChildren().add(lvwKonferencer);
       lvwKonferencer.setPrefWidth(200);
       lvwKonferencer.setPrefHeight(200);
       lvwKonferencer.getItems().setAll(Controller.getOrganisation().getKonerencer());

       ChangeListener<Konference> listener = (ov, oldKonference, newKonference) -> this.selectedKonferenceChanged();
       lvwKonferencer.getSelectionModel().selectedItemProperty().addListener(listener);

       Label lblInfo = new Label("Information:");
       lblInfo.paddingProperty().set(new Insets(0,0,10,0));
       vbox2.getChildren().add(lblInfo);

       txaInfo = new TextArea();
       vbox2.getChildren().add(txaInfo);
       txaInfo.setPrefWidth(200);
       txaInfo.setPrefHeight(200);
       txaInfo.setEditable(false);



       Label lblUdflugt = new Label("Udflugt-oversigt:");
       lblUdflugt.paddingProperty().set(new Insets(0,0,10,0));
       vbox3.getChildren().add(lblUdflugt);

       txaUdflugter = new TextArea();
       vbox3.getChildren().add(txaUdflugter);
       txaUdflugter.setPrefWidth(200);
       txaUdflugter.setPrefHeight(200);


   }

   private void selectedKonferenceChanged() {
       this.updateControls();
   }

   public void updateControls() {
       Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();

       if (konference != null) {
           txaInfo.setText(konference.konferenceOversigt());
           StringBuilder sb = new StringBuilder();
              for (Udflugt udflugt : konference.getUdflugter()) {
                sb.append(udflugt + "\n");
              }
              StringBuilder sb2 = new StringBuilder();
                txaUdflugter.setText(sb.toString());
       } else {
           txaInfo.clear();
           txaUdflugter.clear();
       }
   }

}
