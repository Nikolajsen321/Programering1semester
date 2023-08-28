package gui;

import application.controller.Controller;
import application.model.Salg;
import javafx.application.Application;
import storage.Storage;

public class App {
    public static void main(String[] args) {
        Controller.initStorage();
        Application.launch(GuiFx.class);
    }
}
