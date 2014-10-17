package game.core;

import javafx.scene.shape.Circle;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by Seth on 10/16/2014.
 */
public class Ball extends gameObject{

    private Ellipse2D.Double ball;
    private double diameter = 10;

    public Ball(){
        locationY = 300;
        locationX = 350;
        width = (int) diameter;
        height = (int) diameter;
        directionY = 1;
    }

    @Override
    public void Move(){
        locationY += directionY;
        locationX += directionX;
    }

    public Ellipse2D.Double getBall()
    {
        ball = new Ellipse2D.Double(locationX, locationY, diameter, diameter );
        return ball;
    }

    public void changeDirection(int x, int y){
        directionY = y;
        directionX = x;
    }

    public int getYDirection(){
        return directionY;
    }
    public int getXDirection(){
        return directionX;
    }
}
