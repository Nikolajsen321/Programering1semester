package Shapes.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.shape.Line;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        this.initContent(pane);
        Scene scene = new Scene(pane, 400, 400);

        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(Pane pane) {

//        Color color1 =  Color.YELLOW;
//        double x = 100;
//        Circle circle = new Circle(200, 90, 30);
//        pane.getChildren().add(circle);
//        circle.setFill(color1);
//        circle.setStroke(Color.BLACK);
//
//
//        Rectangle rectangle = new Rectangle(20,230,140,100);
//        pane.getChildren().add(rectangle);
//        rectangle.setFill(Color.RED);
//        rectangle.setStroke(Color.BLACK);
//
//        Rectangle rectangleWindow = new Rectangle(30,260,40,40);
//        pane.getChildren().add(rectangleWindow);
//        rectangleWindow.setFill(Color.BLACK);
//        rectangleWindow.setStroke(Color.BLACK);
//
////        Rectangle rectangleDoor = new Rectangle(( ))
//
//        Polygon threeWay = new Polygon(0,230,90,115,180,230);
//        pane.getChildren().add(threeWay);
////        threeWay.getPoints().addAll(new Double[]{
////                180.0,180.0,         // nummer 2 og 2 under er brugt til at lave den horisontale linje 180 og 180
////                30.0,180.0,
////                100.0, 70.0     // nummer 2 bruger jeg til at justere  højden  70
////                });
//        threeWay.setFill(Color.GREEN);
//        threeWay.setStroke(Color.BLACK);

        Line line = new Line(0,330,900,330);
        pane.getChildren().add(line);
        line.setFill(Color.BLACK);
        line.setStroke(Color.BLACK);

        Rectangle rectangleCar = new Rectangle(180,240,170,70);
        pane.getChildren().add(rectangleCar);
        rectangleCar.setStroke(Color.BLUEVIOLET);
        rectangleCar.setFill(Color.BLUEVIOLET);

        Rectangle rectangleRoof = new Rectangle(210,200,90,60);
        pane.getChildren().add(rectangleRoof);
        rectangleRoof.setStroke(Color.BLUEVIOLET);
        rectangleRoof.setFill(Color.BLUEVIOLET);

        int numberOfWheels = 4;
        int numbersOfLight = 2;
        int numberOfWindows;

        for(int i = 0; i < numberOfWheels; i++) {
            Circle wheely = new Circle( 190 + 45 * ( ( i  )) + 10, 320, 20);
            pane.getChildren().add(wheely);
            wheely.setStroke(Color.GREEN);
            wheely.setFill(Color.PALEGREEN);

            if( i % 2 == 0 ) {
              Circle lights = new Circle(195 + 70 * (i), 260, 10);
              pane.getChildren().add(lights);
              if( i == 2) {
                  lights.setStroke(Color.GREEN);
                  lights.setFill(Color.YELLOW);
              }else{
                  lights.setStroke(Color.GREEN);
                  lights.setFill(Color.RED);
              }
            }
        }


    }

}
