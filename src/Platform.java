import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Platform{

    private int xVal;
    private int yVal;
    private int width;
    private int height;

    private FrameHolder frameHolder;
    private Collider hitBox;
    private boolean hasHitBox;

    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public void setWidth(int w){
        width=w;
    }
    public void setHeight(int h){
        height=h;
    }

    public void setFrameHolder(String[] path){
        frameHolder = new FrameHolder(path);
    }
    public BufferedImage getFrame(){
        return frameHolder.getCurrentFrame();
    }
    public int getX(){
        return xVal;
    }
    public void setX(int updateX){
        xVal = xVal+updateX;
        if(hasHitBox){
            hitBox.setxLeft(updateX+ hitBox.getxLeft());
            hitBox.setxRight(updateX+ hitBox.getxRight());
        }
    }
    public int getY(){
        return yVal;
    }
    public void setY(int updateY){
        yVal = yVal+updateY;
        if(hasHitBox){
            hitBox.setyTop(hitBox.getyTop()+updateY);
            hitBox.setyBot(hitBox.getyBot()+updateY);
        }
    }
    public boolean getHasHitBox(){
        return hasHitBox;
    }

    public Collider getHitBox(){
        return hitBox;
    }
    public void createHitBox(int x, int width, int y, int height){
        hasHitBox = true;
        hitBox = new Collider(x,width,y,height, "solidObject");
    }
    public void drawPlatform(Graphics g){
        g.drawImage(getFrame(), getX(), getY(), null);
    }

}
