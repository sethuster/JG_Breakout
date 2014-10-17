package game.core;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Seth on 10/16/2014.
 * This is used to create bricks for the ball to break.
 * it is a child object of the gameObject class
 */
public class brick extends gameObject{

    public boolean visible = true; //Indicates if the block has been destroyed or not
    public Color brickColor; //sets the block color
    private ArrayList colors; //an array of colors

    public brick(int x, int y){
        locationX = x;
        locationY = y;
        width = 100;
        height = 25;

        //set up the colors to choose from
        colors = new ArrayList();
        colors.add(Color.red);
        colors.add(Color.blue);
        colors.add(Color.yellow);
        colors.add(Color.green);
        colors.add(Color.pink);
        colors.add(Color.magenta);
        colors.add(Color.DARK_GRAY);
        colors.add(Color.cyan);
        colors.add(Color.orange);
        setBrickColor();
    }

    private void setBrickColor() {
        Random rand = new Random();
        int n = rand.nextInt(colors.size());
        brickColor = (Color) colors.get(n);
    }

   public Color getColor(){
        return brickColor;
    }



}
