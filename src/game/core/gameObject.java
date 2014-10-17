package game.core;

import java.awt.*;

/**
 * Created by Seth on 10/16/2014.
 */
public class gameObject {

    protected int directionX;
    protected int directionY;
    protected int locationX;
    protected int locationY;
    protected int width;
    protected int height;

    public int speed = 2;


    public void Move(){
        locationX += directionX;
        locationY += directionY;
    }

    public int getX(){
        return locationX;
    }
    public int getY(){
        return locationY;
    }
    public Rectangle getBounds(){
        return new Rectangle(locationX, locationY, width, height);
    }
}
