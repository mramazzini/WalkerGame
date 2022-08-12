import javax.swing.*;
import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;


//Holds Graphics, Main Thread, and KeyListener
class Panel extends JPanel implements KeyListener, Runnable {
    private final int WIDTH = 1028;
    private final int HEIGHT = 768;
    private ArrayList<java.lang.Character> keyPressed;
    private int key;

    private Level currentLevel;
    private Frederick frederick;

    public Panel() throws IOException {


        keyPressed = new ArrayList<java.lang.Character>();
        initLevel(0);
        frederick = currentLevel.getFrederick();



        new Thread(this).start();
        this.addKeyListener(this);



    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.fillRect(0,0, WIDTH, HEIGHT);
        currentLevel.drawLevel(g);
        g.setFont(new Font("Monospaced",Font.BOLD+Font.ITALIC,100));
        g.setColor(Color.BLUE);
        //g.drawString("Frederick ", 30, 400);

        //Fredericks hitbox
        //g.drawRect(frederick.getHitBox().getxLeft(), frederick.getHitBox().getyTop(), frederick.getHitBox().getxRight()-frederick.getHitBox().getxLeft(), frederick.getHitBox().getyBot()- frederick.getHitBox().getyTop());


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

            updateCharacters();

        }
    }

    public void updateCharacters(){
        currentLevel.refreshCharacters();
        frederick.frederickState(keyPressed);
        isFrederickDumb();

    }

    public void isFrederickDumb(){ //Keeps Frederick from going into a wall
        if(frederick.getHitBox().checkFrederickCollision(currentLevel.getPlatforms())){
            frederick.setY(-frederick.getY()+frederick.getPrevY());
            frederick.setVelY(-frederick.getVelY());
        }
        if(frederick.getHitBox().checkFrederickCollision(currentLevel.getPlatforms())) {
            frederick.setX(-frederick.getX() + frederick.getPrevX());
            frederick.setVelX(-frederick.getVelX());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    private void initLevel(int lvl) throws IOException {
        currentLevel = new Level(0);

    }
    @Override
    public void keyPressed(KeyEvent e) {
        key= e.getKeyCode();
        //System.out.println(key);
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
            frederick.setVelY(-frederick.getVelY());
        }
        if(c.equals('d') || c.equals('a')){
            frederick.setVelX(-frederick.getVelX());
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

    }
}

