import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Arrays;


public class Character {
    //Stores the frames of the character


    //Holds the hitbox
    private Boolean hasHitBox;
    private Collider hitBox;
    private int width;
    private int length;

    FrameHolder frameHolder;
    private int maxSpeedX = 10;
    private int maxSpeedY = 20;
    private int velX;
    private int velY;
    //X and Y pixelValues on the screen
    private int xVal;
    private int yVal;
    private int prevX;
    private int prevY;
    private boolean isFalling;
    private int fallingSpeed;
    private boolean hasGravity;
    private final int GRAVSPEED = 5;

    public void setFrameHolder(String[] path){
        frameHolder = new FrameHolder(path);
    }
    public BufferedImage getFrame(){
        return frameHolder.getCurrentFrame();
    }

    public int getWidth(){
        return width;
    }
    public int getLength(){
        return length;
    }
    public void setWidth(int w){
        width=w;
    }
    public void setLength(int l){
        length = l;
    }
    public int getX(){
        return xVal;
    }
    public void setX(int updateX){
        xVal = xVal+updateX;
        if(hasHitBox){
            hitBox.setxLeft(hitBox.getxLeft()+updateX);
            hitBox.setxRight(hitBox.getxRight()+updateX);
        }
    }
    public int getY(){
        return yVal;
    }
    public void setY(int updateY){
        yVal = yVal + updateY;
        if(hasHitBox){
            hitBox.setyTop(hitBox.getyTop()+updateY);
            hitBox.setyBot(hitBox.getyBot()+updateY);
        }
    }
    public void initGravity(){
        hasGravity=true;
    }
    public void stopGravity(){
        hasGravity=false;
    }
    public boolean getHasHitBox(){
        return hasHitBox;
    }

    public void fall(){
        if(hasGravity){
            setPrevY(yVal);
            setVelY(GRAVSPEED);


        }
    }
    public void refresh(){

        setPrevY(getY());
        setPrevX(getX());
        fall();
        if(velY>maxSpeedY){
            velY=maxSpeedY;
        }
        if(velY<-maxSpeedY){
            velY=-maxSpeedY;
        }
        if(velX>maxSpeedX){
            velX=maxSpeedX;
        }
        if(velX<-maxSpeedX){
            velX=-maxSpeedX;
        }

        setY(velY);
        setX(velX);

    }

    public Collider getHitBox(){
        return hitBox;
    }
    public void createHitBox(int x, int y, int width, int height){
        hasHitBox = true;
        hitBox = new Collider(x,y,width,height);
    }
    public int getPrevX(){
        return prevX;
    }
    public int getPrevY(){
        return prevY;
    }
    public void setPrevX(int x){
        prevX=x;
    }
    public void setPrevY(int y){
        prevY=y;
    }
    public void setVelX(int x){
        velX=velX+x;
    }
    public void setVelY(int y){
        velY=velY+y;
    }
    public int getVelX(){
        return velX;
    }
    public int getVelY(){
        return velY;
    }

    public void setFalling(boolean b){
        isFalling=b;
    }
    public boolean isFalling(){
        return isFalling;
    }

    public int getFallingSpeed(){
        return fallingSpeed;
    }
    public void fallingSpeedIncrement(){
        fallingSpeed++;
    }
    public void resetFallingSpeed(){
        fallingSpeed=0;
    }

}
