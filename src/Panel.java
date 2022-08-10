import javax.swing.*;
import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;


//Holds Graphics, Main Thread, and KeyListener
class Panel extends JPanel implements KeyListener, Runnable {

    private final Frederick frederick;

    private BluePlat basePlatform;
    private BluePlat plat1;
    private BluePlat plat2;
    private BluePlat plat3;
    private BluePlat plat4;
    private final int WIDTH = 1028;
    private final int HEIGHT = 768;
    private ArrayList<java.lang.Character> keyPressed;
    private int key;

    private Platform[] platforms;

    public Panel() throws IOException {

        frederick = new Frederick();
        keyPressed = new ArrayList<java.lang.Character>();

        buildPlatforms();

        new Thread(this).start();
        this.addKeyListener(this);



    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.fillRect(0,0, WIDTH, HEIGHT);
        g.drawImage(frederick.getFrame(), frederick.getX(), frederick.getY(), null);
        g.setFont(new Font("Monospaced",Font.BOLD+Font.ITALIC,100));
        g.setColor(Color.BLUE);
        g.drawString("I am Birb", 30, 400);
        //Fredericks hitbox
        //g.drawRect(frederick.getHitBox().getxLeft(), frederick.getHitBox().getyTop(), frederick.getHitBox().getxRight()-frederick.getHitBox().getxLeft(), frederick.getHitBox().getyBot()- frederick.getHitBox().getyTop());
        for(int i=0; i<platforms.length; i++){
            g.drawImage(platforms[i].getFrame(), platforms[i].getX(), platforms[i].getY(), null);
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

            updateFrederick();

        }
    }

    public void updateFrederick(){

        if(frederick.isFalling()) {
            frederick.fallingSpeedIncrement();
        }
        else{
            frederick.resetFallingSpeed();
        }
        if(frederick.getVelY()>=0){
            frederick.setFalling(false);
        }
        if(keyPressed.contains('w')){ //w
            frederick.setFalling(true);

            frederick.setVelY(-20+frederick.getFallingSpeed());
            System.out.println(frederick.getFallingSpeed());


        }

        if (keyPressed.contains('s')) { //s
            frederick.setVelY(1);
        }
        if(!frederick.isAttacking()){
            if(keyPressed.contains('a')){ //a
                frederick.setVelX(-1);
                if(frederick.frameHolder.getFrameNum()==3){
                    frederick.frameHolder.updateFrame(2);
                }
                else{
                    frederick.frameHolder.updateFrame(3);
                }
            }
            if(keyPressed.contains('d')) { //d
                frederick.setVelX(1);
                if (frederick.frameHolder.getFrameNum()==0) {
                    frederick.frameHolder.updateFrame(1);
                } else {
                    frederick.frameHolder.updateFrame(0);
                }
            }


        }
        else {
            if(keyPressed.contains('a')){ //a
                frederick.setVelX(-1);
                if(frederick.frameHolder.getFrameNum()!=8 && frederick.frameHolder.getFrameNum()!=9){
                    frederick.frameHolder.updateFrame(8);
                }
                else if(frederick.frameHolder.getFrameNum() !=9){
                    frederick.frameHolder.updateFrame(9);

                }
                else{
                    frederick.frameHolder.updateFrame(7);
                    frederick.setAttacking(false);
                }
            }
            if(keyPressed.contains('d')) { //d
                frederick.setVelX(1);
                if (frederick.frameHolder.getFrameNum() != 5 && frederick.frameHolder.getFrameNum()!=6) {
                    frederick.frameHolder.updateFrame(5);
                }
                else if(frederick.frameHolder.getFrameNum() !=6){
                    frederick.frameHolder.updateFrame(6);

                }
                else{
                    frederick.frameHolder.updateFrame(4);
                    frederick.setAttacking(false);
                }
            }
            if(!keyPressed.contains('d') && !keyPressed.contains('a')){
                if(frederick.frameHolder.getFrameNum() ==4 || frederick.frameHolder.getFrameNum() ==1 ||frederick.frameHolder.getFrameNum() ==0){
                    frederick.frameHolder.updateFrame(5);
                }
                else if(frederick.frameHolder.getFrameNum() ==5){
                    frederick.frameHolder.updateFrame(6);

                }
                else if(frederick.frameHolder.getFrameNum() == 6){
                    frederick.frameHolder.updateFrame(4);
                    frederick.setAttacking(false);
                }
                else if(frederick.frameHolder.getFrameNum() ==7 || frederick.frameHolder.getFrameNum() ==2 || frederick.frameHolder.getFrameNum() ==3){
                    frederick.frameHolder.updateFrame(8);
                }
                else if(frederick.frameHolder.getFrameNum() ==8){
                    frederick.frameHolder.updateFrame(9);
                }
                else if(frederick.frameHolder.getFrameNum() ==9){
                    frederick.frameHolder.updateFrame(7);
                    frederick.setAttacking(false);
                }

            }
        }
        if (keyPressed.contains(' ')) { //Spacebar
            frederick.setAttacking(true);
        }
        frederick.refresh();
        isFrederickDumb();

    }

    public void isFrederickDumb(){ //Keeps Frederick from going into a wall
        if(frederick.getHitBox().checkFrederickCollision(platforms)){
            frederick.setY(-frederick.getY()+frederick.getPrevY());
            frederick.setVelY(-frederick.getVelY());
        }
        if(frederick.getHitBox().checkFrederickCollision(platforms)) {
            frederick.setX(-frederick.getX() + frederick.getPrevX());
            frederick.setVelX(-frederick.getVelX());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    private void buildPlatforms(){
        basePlatform = new BluePlat(0, 768-36, 1024);
        plat1 = new BluePlat(0, 512-36, 512);
        plat2 = new BluePlat(512, 256-36, 256);
        plat3 = new BluePlat(256, 256-36, 256);
        platforms = new Platform[]{basePlatform, plat1, plat2, plat3};
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

