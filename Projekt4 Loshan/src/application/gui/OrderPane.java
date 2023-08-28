package application.gui;

import application.controller.Controller;
import application.model.Customer;
import application.model.Order;
import application.model.Seat;
import application.model.Show;
import application.storage.Storage;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class OrderPane extends Application {

    private ListView<Show> listShow = new ListView<>();
    private ListView<Customer> listCustomer = new ListView<>();
    private ListView<Seat> listSeat = new ListView<>();
    private TextField txfShowName = new TextField();
    private TextField txfStartDate = new TextField();
    private TextField txfEndDate = new TextField();
    private TextField txfCustomerName = new TextField();
    private TextField txfCustomerMobile = new TextField();
    private TextField txfDate = new TextField();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("View orders");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setVgap(5);
        pane.setHgap(10);

        pane.add(listShow, 0, 1, 2, 1);
        Label lblShow = new Label("Shows");
        pane.add(lblShow, 0, 0);
        listShow.setPrefHeight(150);
        listShow.setPrefWidth(300);
        listShow.getItems().setAll(Storage.getShows());

        Label lblName = new Label("Name");
        pane.add(txfShowName, 1, 2);
        pane.add(lblName, 0, 2);


        Label lblStartDate = new Label("Start date");
        pane.add(lblStartDate, 0, 3);
        pane.add(txfStartDate, 1, 3);

        Label lblEndDate = new Label("End date");
        pane.add(lblEndDate, 0, 4);
        pane.add(txfEndDate, 1, 4);

        Label lblCustomer = new Label("Customer");
        pane.add(lblCustomer,3,0);
        pane.add(listCustomer,3,1,2,1);
        listCustomer.setPrefHeight(150);
        listCustomer.setPrefWidth(300);
        listCustomer.getItems().setAll(Storage.getCustomers());

        Label lblCustomerName = new Label("Customer name");
        pane.add(lblCustomerName, 3, 2);
        pane.add(txfCustomerName, 4, 2);

        Label lblCustomerMobile = new Label("Customer mobile");
        pane.add(lblCustomerMobile, 3, 3);
        pane.add(txfCustomerMobile, 4, 3);

        Button createShow = new Button("Create show");
        pane.add(createShow, 1, 5);

        Button createCustomer = new Button("Create customer");
        pane.add(createCustomer, 4, 4);

        Label lblSeats = new Label("Seat");
        pane.add(lblSeats, 7, 0);
        pane.add(listSeat, 7, 1, 2, 1);
        listSeat.setPrefHeight(150);
        listSeat.setPrefWidth(300);
        listSeat.getItems().setAll(Storage.getSeats());
        listSeat.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Label seatDate = new Label("Date");
        pane.add(seatDate, 7, 2);
        pane.add(txfDate, 8, 2);

        Button createOrder = new Button("Create order");
        pane.add(createOrder, 8, 3);

        createCustomer.setOnAction(Event -> createCustomer());
        createShow.setOnAction(Event -> createShow());
        createOrder.setOnAction(Event -> createOrder());
    }

    public void createCustomer() {
        String customerName = txfCustomerName.getText();
        String mobile = txfCustomerMobile.getText();

        Controller.createCustomer(customerName, mobile);

        listCustomer.getItems().setAll(Storage.getCustomers());
    }

    public void createShow() {
        String showName = txfShowName.getText().trim();
        String startDate = txfStartDate.getText().trim();
        String endDate = txfEndDate.getText().trim();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startD = null;
        LocalDate endD = null;

        try {
            startD = LocalDate.parse(startDate, formatter);
        } catch (DateTimeException d) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not read start date");
            alert.setContentText("Write date in following format: 'yyyy-MM-dd");
            alert.showAndWait();
            return;
        } try {
            endD = LocalDate.parse(endDate, formatter);
        } catch (DateTimeException d) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not read end date");
            alert.setContentText("Write date in following format: 'yyyy-MM-dd");
            alert.showAndWait();
            return;
        }

        Controller.createShow(showName, startD, endD);
        listShow.getItems().setAll(Storage.getShows());
    }

    public void createOrder() {
        Show show = listShow.getSelectionModel().getSelectedItem();
        Customer customer = listCustomer.getSelectionModel().getSelectedItem();
        String date = txfDate.getText().trim();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startD = null;
        ArrayList<Seat> seats = new ArrayList<>(listSeat.getSelectionModel().getSelectedItems());
        try {
            startD = LocalDate.parse(date, formatter);
        } catch (DateTimeException d) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not read start date");
            alert.setContentText("Write date in following format: 'yyyy-MM-dd");
            alert.showAndWait();
            return;
        }

        Order order = Controller.createOrderWithSeats(show, customer, startD, seats);
        System.out.println(order);
        listSeat.getItems().setAll(Controller.getSeats());
        if (order != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Order created");
            alert.setHeaderText("Order created for " + customer.getName());
            alert.setContentText("Write date in following format: 'yyyy-MM-dd");
            alert.showAndWait();
        }
    }

}
