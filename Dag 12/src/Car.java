

import javafx.scene.shape.DrawMode;
import javafx.scene.shape.Shape;

import java.awt.*;

public class Car {
    private Color color;

    private int doors;
    private int wheels;



    public Car(Color color1, int doors1, int wheels1)
    {
        this.color = color1;
        this.doors = doors1;
        this.wheels = wheels1;
    }
    public Car()
    {
        this(Color.RED, 2,4);
    }

    public Color getColor()
    {
        return color;
    }


    public void setColor(Color color1)
    {
        this.color = color1;
    }

    public int getDoor(){
        return doors;
    }
    public void setDoor(int doors1){
       this.doors = doors1;
    }
    public int getWheels(){
        return wheels;
    }
    public void setWheels(int wheels1){
        this.wheels = wheels1;
    }


    @Override
    public String toString(){
        return color + " veichel with " + doors + " doors";
    }
}