package game.core;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 * Created by Seth on 10/16/2014.
 */
public class BreakoutBoard extends JPanel implements ActionListener {

    private Graphics2D graphics2D;

    private Timer timer;
    private paddle thePaddle;

    public BreakoutBoard(){

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.white);
        setDoubleBuffered(true);
        setSize(800, 600);

        thePaddle = new paddle();
        timer = new Timer(5, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(thePaddle.getThePaddle(), thePaddle.getX(), thePaddle.getY(), null);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        thePaddle.movePaddle();
        repaint();
    }

    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            thePaddle.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            thePaddle.keyPressed(e);
        }
    }
}
