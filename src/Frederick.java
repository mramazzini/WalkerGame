import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Frederick extends Character {
    private String stance;
    private boolean isAttacking;

    public Frederick() throws IOException {

        isAttacking=false;
        stance = "Battle";
        initGravity();
        setWidth(128);
        setLength(128);
        createHitBox(getX() + getWidth() *1/ 3, getX() + getWidth() * 2 / 3, getY()+8, getY() + getLength()-8);
        setFrameHolder(new String[]{
                "Assets/Frederick0.png",
                "Assets/Frederick1.png",
                "Assets/Frederick2.png",
                "Assets/Frederick3.png",
                "Assets/FrederickMald0.png",
                "Assets/FrederickMald1.png",
                "Assets/FrederickMald2.png",
                "Assets/FrederickMald3.png",
                "Assets/FrederickMald4.png",
                "Assets/FrederickMald5.png",

                });


    }

    public String getStance() {
        return stance;
    }

    public void setStance(String stance) {
        this.stance = stance;
    }
    public boolean isAttacking(){
        return isAttacking;
    }
    public void setAttacking(boolean b){
        isAttacking=b;
    }
}
