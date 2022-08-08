import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;


public class Character {
    //Stores the Standing Still Frame
    private BufferedImage standingMan;

    //Stores the Frames for the WalkingMan Gif
    private BufferedImage[] walkingMan;

    //Counts the current Frame
    private int frame;

    //X and Y pixelValues on the screen
    private int xVal;
    private int yVal;

    public Character() throws IOException {

        //Fills the BufferedImage Variables with the stored Files
        try {
            standingMan = ImageIO.read(new File("Assets/Char.png"));
            walkingMan = new BufferedImage[]{ImageIO.read(new File("Assets/Walking1.png")), ImageIO.read(new File("Assets/Walking2.png"))};
        } catch (IOException e) {
            String workingDir = System.getProperty("user.dir");
            System.out.println("Current working directory : " + workingDir);
            e.printStackTrace();
        }

    }
    public int getX(){
        return xVal;
    }
    public void setX(int updateX){
        xVal = updateX;
    }
    public int getY(){
        return yVal;
    }
    public void setY(int updateY){
        yVal = updateY;
    }

    public BufferedImage getImage(){
        return walkingMan[frame];
    }

    public void updateImage(){
        if(frame==0){
            frame=1;
        }
        else{
            frame=0;
        }
    }
}
