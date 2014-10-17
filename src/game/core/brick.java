package game.core;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Seth on 10/16/2014.
 */
public class brick extends gameObject{
    private Rectangle aBrick;
    public boolean visible = true;
    public Color brickColor;
    private ArrayList colors;

    public brick(int x, int y){
        locationX = x;
        locationY = y;
        width = 100;
        height = 25;


        colors = new ArrayList();
        colors.add(Color.red);
        colors.add(Color.blue);
        colors.add(Color.yellow);
        colors.add(Color.green);
        colors.add(Color.pink);
        colors.add(Color.magenta);
        setBrickColor();
    }

    private void setBrickColor() {
        Random rand = new Random();
        int n = rand.nextInt(6);
        brickColor = (Color) colors.get(n);
    }

    public void setVisible(boolean visability){
        visible = visability;
    }

    public Color getColor(){
        return brickColor;
    }



}
