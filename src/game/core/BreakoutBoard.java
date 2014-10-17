package game.core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


/**
 * Created by Seth on 10/16/2014.
 */
public class BreakoutBoard extends JPanel implements ActionListener {

    private Graphics2D graphics2D;
    private int B_WIDTH = 800;
    private int B_HEIGHT = 650;

    private Timer timer;
    private paddle thePaddle;
    private Ball theBall;
    private ArrayList bricks;

    private int[][] brickPos = {
            {0, 100},{100, 100},{200,100},{300,100},{400,100},{500,100},{600,100},{700,100}
    };

    public BreakoutBoard(){

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.white);
        setDoubleBuffered(true);
        setSize(B_WIDTH, B_HEIGHT);

        initBricks();
        thePaddle = new paddle();
        theBall = new Ball();
        timer = new Timer(5, this);
        timer.start();
    }

    public void initBricks(){
        bricks = new ArrayList();

        for(int i = 0; i < brickPos.length; i++){
            bricks.add(new brick(brickPos[i][0], brickPos[i][1]));
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(thePaddle.getThePaddle(), thePaddle.getX(), thePaddle.getY(), null);
        g2d.setColor(Color.red);
        g2d.fill(theBall.getBall());

        for(int i = 0; i < bricks.size(); i++){
            brick b = (brick) bricks.get(i);
            if(b.visible){
               g2d.setColor(b.getColor());
               g2d.fill(b.getBounds());
            }
        }
        //Debuggging
        g2d.setColor(Color.black);
        g2d.drawString("X: " +  String.valueOf(theBall.getX()), 5, 15);
        g2d.drawString("Y: " + String.valueOf(theBall.getY()), 5, 30);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        thePaddle.Move();
        theBall.Move();
        checkCollisions();
        repaint();
    }

    private void checkCollisions() {
        Rectangle ballPos = theBall.getBounds();
        Rectangle paddlePos = thePaddle.getBounds();

        if(ballPos.intersects(paddlePos)){
            theBall.changeDirection(thePaddle.getXDirection(), -theBall.speed);
        }
        //Watch the borders of the window = except the bottom
        if(theBall.getY() <= 0){
            theBall.changeDirection(theBall.getXDirection(), theBall.speed);
        }
        if(theBall.getX() <= 0 ){
            theBall.changeDirection(theBall.speed, theBall.getYDirection());
        }
        if(theBall.getX() >= (B_WIDTH - 15)){
            theBall.changeDirection(-theBall.speed, theBall.getYDirection());
        }

        //FOR DEBUGGGING
        if(theBall.getY() >= B_HEIGHT){
            theBall.changeDirection(0,-1);
        }

    }

    @Override
    public void addNotify(){
        super.addNotify();
        B_WIDTH = getWidth();
        B_HEIGHT = getHeight();
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
