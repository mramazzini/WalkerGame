import javax.swing.*;
import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;


//Holds Graphics, Main Thread, and KeyListener
class Panel extends JPanel implements KeyListener, Runnable {

    Character char1;
    private final int WIDTH = 400;
    private final int HEIGHT = 400;
    private int key;


    public Panel() throws IOException {

        char1 = new Character();
        new Thread(this).start();
        this.addKeyListener(this);



    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        char1.updateImage();

        g.drawImage(char1.getImage(), char1.getX(), char1.getY(), null);

    }

    //so our panel is the corerct size when pack() is called on Jframe
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }


    public void run() {

        while(true) {
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            repaint();
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        key= e.getKeyCode();
        System.out.println(key);
        if(key == 87){ //w
            char1.setY(char1.getY()-5);
        }
        if(key == 83){ //s
            char1.setY(char1.getY()+5);
        }
        if(key == 65){ //a
            char1.setX(char1.getX()-5);
        }
        if(key == 68){ //d
            char1.setX(char1.getX()+5);
        }



    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

