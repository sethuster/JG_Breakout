package game.core;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Seth on 10/16/2014. This is just a simple java game
 *
 */
public class Application extends JFrame {

    //Constructor for Application class
    public Application() {
        initUI();
    }

    //This sets up the JFrame for the board with some default behaivior
    private void initUI() {
        add(new BreakoutBoard());

        setSize(800, 650);
        setBackground(Color.black);
        setTitle("Breakout!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    //This is the main function - starts a new Application class
    public static void main(String[] args){
        new Application();
    }
}
