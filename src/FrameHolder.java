import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FrameHolder {

    private BufferedImage[] frames;
    private int currentFrame;

    public FrameHolder(String[] path){
        //Fills the BufferedImage Variables with the stored Files
        try {
            frames = new BufferedImage[0];
            for(int i=0; i<path.length; i++ ){
                BufferedImage[] newArr = Arrays.copyOf(frames, frames.length + 1);
                newArr[frames.length] = ImageIO.read(new File(path[i]));
                frames = newArr;
            }



        } catch (IOException e) {

        }
    }
    public BufferedImage[] getFrames(){
        return frames;
    }
    public BufferedImage getCurrentFrame(){
        return  frames[currentFrame];
    }
    public int getFrameNum(){
        return currentFrame;
    }
    public void updateFrame(int temp){
        currentFrame = temp;
    }

}
