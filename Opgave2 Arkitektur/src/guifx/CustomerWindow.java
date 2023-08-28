package guifx;
import application.controller.Controller;
import application.model.Company;
import application.model.Customer;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.security.spec.ECField;


public class CustomerWindow extends Stage {
    private Customer customer;

    public CustomerWindow(String titel,Customer customer){
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.customer = customer;

        this.setTitle(titel);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }
    public CustomerWindow(String titel){
        this(titel,null);

    }

    private TextField txfName;
    private Label lblError;
   ComboBox<Company> cbbCompany;
   private CheckBox chbCompany;
    private Company company;




    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblName = new Label("Name");
        pane.add(lblName,0,0);
        txfName = new TextField();
        pane.add(txfName,0,1);
        txfName.setPrefWidth(200);

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel,0,3);
        GridPane.setHalignment(btnCancel,HPos.LEFT);
        btnCancel.setOnAction(event -> cancelAction());

        Button btnOk = new Button("Ok");
        pane.add(btnOk,1,3);
        GridPane.setHalignment(btnOk,HPos.RIGHT);
        btnOk.setOnAction(event -> okAction());

        chbCompany = new CheckBox("Company");
        pane.add(chbCompany,0,6);
        ChangeListener<Boolean> listener =(ov, oldValue,newValue) ->selectedCompanyChanged(newValue);
        chbCompany.selectedProperty().addListener(listener);

        cbbCompany = new ComboBox<>();
        pane.add(cbbCompany, 0, 7);
        cbbCompany.getItems().addAll(Controller.getCompanies());
        cbbCompany.setDisable(false);


        initControls();
    }

    private void selectedCompanyChanged(Boolean newValue) {
    }

    private void initControls() {
        if(customer != null) {
            txfName.setText(customer.getName());

        } else{
            txfName.clear();
        }


    }




//    }

    private void okAction() {
        StringBuilder sb = new StringBuilder();
      String name = txfName.getText().trim();
        if (name.length() == 0) {
           lblError.setText("name is empty");
        }else{
            boolean companyIsSelected = chbCompany.isSelected();
            Company newCompany = cbbCompany.getSelectionModel().getSelectedItem();
            if(customer != null){
                Controller.updateCustomer(customer,name);
                Controller.addCustomerToCompany(customer,newCompany);
            }else{
                if(newCompany != null) {
                    Controller.createCustomer(name, newCompany);
                }else{
                    Controller.createCustomer(name);
                }
            }

            hide();
        }

    }

    private void cancelAction() {
        this.hide();

    }


}
