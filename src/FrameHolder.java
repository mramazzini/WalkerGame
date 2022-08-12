import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FrameHolder {

    private BufferedImage[] frames;
    private int currentFrame;
    private int framePause; //How many frames the animation should skip on the main thread
    private int currFramePause;
    public FrameHolder(String[] path){
        framePause=1;
        currFramePause=0;
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
    public void setFramePause(int x){
        framePause = x;
    }

    public int getFramePause() {
        return framePause;
    }
    public void setCurrFramePause(int x){
        currFramePause = x;
    }

    public int getCurrFramePause() {
        return currFramePause;
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
