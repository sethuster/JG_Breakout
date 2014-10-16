package game.core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Seth on 10/16/2014.
 */
public class paddle {

    private String thePaddle = "paddle.png";
    private Image image;

    private int directionX;
    private int locationX;
    private int locationY;

    public paddle(){
        ImageIcon ii = new ImageIcon(this.getClass().getResource(thePaddle));
        image = ii.getImage();
        locationX = 300;
        locationY = 600;

    }

    public Image getThePaddle(){
        return image;
    }

    public void movePaddle(){
        locationX += directionX;
    }
    public int getX(){
        return locationX;
    }
    public int getY(){
        return locationY;
    }

    public void keyPressed(KeyEvent k){
        int key = k.getKeyCode();

        if(key == KeyEvent.VK_LEFT){
            directionX = -1;
        }
        if(key == KeyEvent.VK_RIGHT){
            directionX = +1;
        }
    }
    public void keyReleased(KeyEvent k){
        int key = k.getKeyCode();

        if(key == KeyEvent.VK_LEFT){
            directionX = 0;
        }
        if(key == KeyEvent.VK_RIGHT){
            directionX = 0;
        }
    }


}
