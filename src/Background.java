import java.awt.*;

public class Background {

    private FrameHolder frameHolder;
    private int x;
    private int y;
    private String type;
    public Background(String t){
        x=-1024;
        y=-1024;
        type=t;
        if(type.equals("snow")){
            frameHolder=new FrameHolder(new String[] {"Assets/Backgrounds/IceBackground.png"});
        }

    }

    public FrameHolder getFrameHolder() {
        return frameHolder;
    }
    public void drawBackground(Graphics g, int loops){
        if(type.equals("snow")) {
            for (int i = 0; i < loops; i++) {
                g.drawImage(frameHolder.getCurrentFrame(), x + i *3000, y, null);
            }
        }
        else{
            System.out.println("background err");
        }

    }

    public void setY(int update) {
        y=y+update;
    }

    public void setX(int update) {
        x=x+update;
    }
}
