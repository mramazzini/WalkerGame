import java.io.IOException;

public class SnowMan extends Enemy{
    public SnowMan(int x, int y) throws IOException {
        setType("snowman");
        setX(x);
        setY(y);
        setVelX(2);
        setAlive(true);
        setInitX(x);
        setInitY(y);
        initHP(20, getX(), getY());
        setWidth(128);
        setLength(128);
        createHitBox(getX() + getWidth()*1/5 , getX()  +getWidth() *4/5 , getY()+getLength()*1/3, getY() + getLength());
        setFrameHolder(new String[]{
                "Assets/SnowMan/SnowMan0.png",
                "Assets/SnowMan/SnowMan1.png",
                "Assets/SnowMan/SnowMan2.png",
                "Assets/SnowMan/SnowMan3.png",
                "Assets/SnowMan/SnowManDeath4.png",
                "Assets/SnowMan/SnowManDeath5.png",
                "Assets/SnowMan/SnowManDeath6.png",
                "Assets/SnowMan/SnowManDeath7.png",
                "Assets/SnowMan/SnowManDeath8.png",
                "Assets/SnowMan/SnowManDeath9.png",
                "Assets/SnowMan/SnowManDeath10.png",
                "Assets/SnowMan/SnowManDeath11.png",
                "Assets/SnowMan/SnowManDeath12.png",
                "Assets/SnowMan/SnowManDeath13.png",
                "Assets/SnowMan/SnowManDeath14.png",
                "Assets/SnowMan/SnowManDeath15.png",
                "Assets/SnowMan/SnowManDeath16.png",
                "Assets/SnowMan/SnowManDeath17.png",

        });
        frameHolder.setFramePause(10);

    }

    public void updateFrame(){

        move();

        if(frameHolder.getCurrFramePause() == frameHolder.getFramePause()){
            if(getDirectionX().equals("left")){
                if(frameHolder.getFrameNum()==10){ //Snowman stays dead on last frame
                    return;
                }
                else if(getAlive()){

                    if(frameHolder.getFrameNum()==0){
                        frameHolder.updateFrame(1);
                    }
                    else{
                        frameHolder.updateFrame(0);
                    }

                }
                else{
                    frameHolder.updateFrame(frameHolder.getFrameNum()+1);
                }
                frameHolder.setCurrFramePause(0);
            }
            else{
                if(frameHolder.getFrameNum()==17){ //Snowman stays dead on last frame
                    return;
                }
                else if(getAlive()){

                    if(frameHolder.getFrameNum()==3){
                        frameHolder.updateFrame(2);

                    }
                    else{
                        frameHolder.updateFrame(3);
                    }

                }
                else{
                    frameHolder.updateFrame(frameHolder.getFrameNum()+1);
                }
                frameHolder.setCurrFramePause(0);
            }

        }
        else{
            frameHolder.setCurrFramePause(frameHolder.getCurrFramePause()+1);
        }
        refresh();
    }

}
