package game.core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Seth on 10/16/2014.
 */
public class paddle extends gameObject {

    private String thePaddle = "paddle.png";
    private Image image;

    public paddle(){
        ImageIcon ii = new ImageIcon(this.getClass().getResource(thePaddle));
        image = ii.getImage();
        locationX = 300;
        locationY = 600;
        width = image.getWidth(null);
        height = image.getHeight(null);

    }

    public Image getThePaddle(){
        return image;
    }

    public int getXDirection(){
        return directionX;
    }
    @Override
    public void Move(){
        locationX += directionX;
    }

    public void keyPressed(KeyEvent k){
        int key = k.getKeyCode();

        if(key == KeyEvent.VK_LEFT){
            directionX = -speed;
        }
        if(key == KeyEvent.VK_RIGHT){
            directionX = +speed;
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
