package game.core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Seth on 10/16/2014.
 * This is the paddle the player controls - it is an image
 */
public class paddle extends gameObject {

    private String thePaddle = "paddle.png"; //get the image file to use for the paddle
    private Image image;  //this is where the image will be stored



    public paddle(){
        //This is used to load the image
        ImageIcon ii = new ImageIcon(this.getClass().getResource(thePaddle));
        image = ii.getImage(); //This is used to store the image
        //These variables set the location of the paddle - in the middle and bottom of the board
        locationX = 300;
        locationY = 600;
        //This gets the width and height of the paddle
        width = image.getWidth(null);
        height = image.getHeight(null);
        //sets the speed at which the player can move the paddle
        speed = 3;

    }

    public Image getThePaddle(){
        return image;
    }

    public int getXDirection(){
        return directionX;
    }
    @Override
    public void Move(){
        //this only let's the player move the paddle from side to side
        locationX += directionX;
    }

    public void keyPressed(KeyEvent k){
        //This method sets the direction of the paddle based on the key being pressed
        int key = k.getKeyCode();

        if(key == KeyEvent.VK_LEFT){
            directionX = -speed;
        }
        if(key == KeyEvent.VK_RIGHT){
            directionX = +speed;
        }
    }
    public void keyReleased(KeyEvent k){
        //this stops the movement of the paddle based on the key that was released.
        int key = k.getKeyCode();

        if(key == KeyEvent.VK_LEFT){
            directionX = 0;
        }
        if(key == KeyEvent.VK_RIGHT){
            directionX = 0;
        }
    }


}
