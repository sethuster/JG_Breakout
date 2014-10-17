package game.core;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Seth on 10/16/2014.
 */
public class Application extends JFrame {

    public Application() {
        initUI();
    }

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

    public static void main(String[] args){
        new Application();
    }
}
