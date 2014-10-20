package game.core;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

/**
 * Created by SethUrban on 10/20/14.
 * This object will keep track of player lives.
 */
public class Lives extends gameObject {
    private int numLives = 3;
    protected ArrayList<Life> theLives;
    private Color purple = new Color(0x9000DD);
    private int LivesIndicatorPOS;


    public Lives(){
        //want to put the lives in the top right corner of the screen
        locationX = 770;
        locationY = 10;
        //want to show three lives there
        width = 30;
        height = 10;
        theLives = new ArrayList<Life>();
        CreateLives();
    }

    private void CreateLives(){
        theLives.clear();
        int fromSide = 800;
        for(int i = 0; i < numLives; i++){
            Life aLife = new Life();
            fromSide -= aLife.diameter;
            aLife.setLocation(fromSide, locationY);
            theLives.add(aLife);
        }
        LivesIndicatorPOS = fromSide - 45;
    }

    public int LivesLeft(){
        return theLives.size();
    }

    public void RemoveLife(){
        numLives--;
        CreateLives();
    }

    public Color getColor(){
        return purple;
    }

    public Ellipse2D.Double getaLife(int life){
       return theLives.get(life).getLife();
    }
    public int LivesTextPOS(){
        return LivesIndicatorPOS;
    }











}
