package game.core;

import javafx.scene.shape.Ellipse;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by SethUrban on 10/20/14.
 * This is the actual life to be stored in the lives collection
 */
public class Life extends gameObject {
    private Ellipse2D.Double life;
    public double diameter = 20;



    public Life(){
        width = (int) diameter;
        height = (int) diameter;
    }

    public void setLocation(int x, int y){
        locationX = x;
        locationY = y;
    }

    public Ellipse2D.Double getLife(){
        return new Ellipse2D.Double(locationX, locationY, width, height);
    }

}
