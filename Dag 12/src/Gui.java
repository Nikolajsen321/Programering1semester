import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;


public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        Car car1 = new Car();
        this.drawCar(pane,car1);
        Scene scene = new Scene(pane, 400, 400);

        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();
    }
    
     public void drawCar(Pane pane, Car car) {
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

        for(int i = 0; i < car.getWheels(); i++) {
            Circle wheely = new Circle( 190 + 45 * ( ( i  )) + 10, 320, 20);
            pane.getChildren().add(wheely);
            wheely.setStroke(Color.GREEN);
            wheely.setFill(Color.PALEGREEN);


            if( i % car.getDoor() == 0 ){
                Line door = new Line(280 - 20 *(i),250,280 -20 * (i),270);
                pane.getChildren().add(door);
                door.setStrokeWidth(1);
                door.setStroke(Color.BLACK);
                door.setFill(Color.BLACK);
            }

                if( i % 2 == 0 ) {
              Circle lights = new Circle(195 + 70 * (i), 260, 10);
              pane.getChildren().add(lights);
              Rectangle carWindow = new Rectangle(220 + (i * 30),220,20,30);
              pane.getChildren().add(carWindow);
              carWindow.setFill(Color.DODGERBLUE);



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
