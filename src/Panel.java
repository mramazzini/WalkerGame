import javax.swing.*;
import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;


//Holds Graphics, Main Thread, KeyListener, and MouseListener
class Panel extends JPanel implements MouseListener, KeyListener, Runnable {
    static final int WIDTH = 1024;
    static final int HEIGHT = 768;
    private ArrayList<java.lang.Character> keyPressed;
    private int key;
    private boolean drawHitboxes = false;

    private Level currentLevel;


    public Panel() throws IOException {


        keyPressed = new ArrayList<java.lang.Character>();
        initLevel(2);




        new Thread(this).start();
        this.addKeyListener(this);
        this.addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        //g.fillRect(0,0, WIDTH, HEIGHT);
        currentLevel.drawLevel(g);
        g.setFont(new Font("Monospaced",Font.BOLD+Font.ITALIC,100));
        g.setColor(Color.BLUE);


        //hitboxes
        if(drawHitboxes){
            currentLevel.drawHitBoxes(g);
        }

    }


    //so our panel is the correct size when pack() is called on Jframe
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }


    public void run() {

        while(true) {
            try {

                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            repaint();

            currentLevel.updateCharacters(keyPressed);

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    private void initLevel(int lvl) throws IOException {
        currentLevel = new Level(lvl);

    }
    @Override
    public void keyPressed(KeyEvent e) {
        key= e.getKeyCode();

        if(key == 87){ //w
            addKey('w');
        }
        if(key == 83){ //s
            addKey('s');
        }
        if(key == 65){ //a
            addKey('a');
        }
        if(key == 68){ //d
            addKey('d');
        }
        if(key == 32){ //Spacebar
            addKey(' ');
        }
        if(key == 192){ //Grave
            drawHitboxes= !drawHitboxes;
        }




    }
    private void addKey(java.lang.Character c){
        for (int i=0; i<keyPressed.size(); i++){
            if(keyPressed.get(i).equals(c)){
                return;
            }

        }
        keyPressed.add(c);


    }
    private void removeKey(java.lang.Character c){
        keyPressed.remove(c);
        if(c.equals('w') || c.equals('s')){
            currentLevel.getFrederick().setVelY(-currentLevel.getFrederick().getVelY());
        }
        if(c.equals('d') || c.equals('a')){
            currentLevel.getFrederick().setVelX(-currentLevel.getFrederick().getVelX());
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        key= e.getKeyCode();

        //System.out.println(key);
        if(key == 87){ //w
            removeKey('w');

        }
        if(key == 83){ //s
            removeKey('s');

        }
        if(key == 65){ //a
            removeKey('a');

        }
        if(key == 68){ //d
            removeKey('d');

        }
        if(key == 32){
            removeKey(' ');

        }
        if(key == 192){ //Grave
            removeKey('`');
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Absolute Coordinates: (" + e.getX()+","+e.getY()+")");
        System.out.println("Relative Coordinates: (" + e.getX()/128+","+e.getY()/128+")");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

