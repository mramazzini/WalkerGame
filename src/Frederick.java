import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Frederick extends Character {
    private String stance;
    private boolean isAttacking;

    public Frederick() throws IOException {
        createWeapon("sword");
        createDmgBoxes(getCurrentWeapon().getHitBoxInt(0));
        setType("frederick");
        isAttacking=false;
        stance = "Battle";
        initGravity();
        initHP(100, getX()+64, getY()+64);
        setWidth(128);
        setLength(128);
        createHitBox(getX() + 43+64, getX() + 85+64, getY()+8+128, getY() + getLength()-8+128);
        setFrameHolder(new String[]{
                "Assets/Frederick/Frederick0.png",
                "Assets/Frederick/Frederick1.png",
                "Assets/Frederick/Frederick2.png",
                "Assets/Frederick/Frederick3.png",
                "Assets/Frederick/FrederickMald4.png",
                "Assets/Frederick/FrederickMald5.png",
                "Assets/Frederick/FrederickMald6.png",
                "Assets/Frederick/FrederickMald7.png",
                "Assets/Frederick/FrederickMald8.png",
                "Assets/Frederick/FrederickMald9.png",
                "Assets/Frederick/FrederickMald10.png",
                "Assets/Frederick/FrederickMald11.png",

                });
        frameHolder.setFramePause(5);

    }

    public String getStance() {
        return stance;
    }
    public void frederickState(ArrayList<java.lang.Character> arr){

        if (arr.contains('s')) { //s
            setVelY(2);
        }
        if(arr.contains('a')) { //a
            setVelX(-2);
        }
        if(arr.contains('d')) { //d
            setVelX(2);
        }
        if(arr.contains('w')){ //w
            setFalling(true);

            setVelY(-15+getFallingSpeed());



        }
        if (arr.contains(' ')) { //Spacebar
            setAttacking(true);
        }
        if(frameHolder.getCurrFramePause() == frameHolder.getFramePause()) {



                    if(!isAttacking()){
                        if(frameHolder.getFrameNum() ==11){
                            frameHolder.updateFrame(2);
                        }
                        else if(frameHolder.getFrameNum() == 7){
                            frameHolder.updateFrame(0);
                        }
                        if(arr.contains('a')){ //a

                            if(frameHolder.getFrameNum()==3 ){
                                frameHolder.updateFrame(2);
                            }
                            else{
                                frameHolder.updateFrame(3);
                            }
                        }
                        if(arr.contains('d')) { //d

                            if (frameHolder.getFrameNum()==0 ) {
                                frameHolder.updateFrame(1);
                            } else {
                                frameHolder.updateFrame(0);
                            }
                        }


                    }
                    else {
                        if(arr.contains('a')){ //a

                            if(frameHolder.getFrameNum()!=9 && frameHolder.getFrameNum()!=10 && frameHolder.getFrameNum()!=11 ){
                                frameHolder.updateFrame(9);
                            }
                            else if(frameHolder.getFrameNum() !=10 && frameHolder.getFrameNum()!=11 ){
                                frameHolder.updateFrame(10);

                            }
                            else if(frameHolder.getFrameNum()!=11 ){
                                frameHolder.updateFrame(11);

                            }
                            else{
                                frameHolder.updateFrame(8);
                                setAttacking(false);
                            }
                        }
                        if(arr.contains('d')) { //d

                            if (frameHolder.getFrameNum() != 5 && frameHolder.getFrameNum()!=6 && frameHolder.getFrameNum()!=7) {
                                frameHolder.updateFrame(5);
                            }
                            else if(frameHolder.getFrameNum() !=6 && frameHolder.getFrameNum()!=7){
                                frameHolder.updateFrame(6);

                            }
                            else if(frameHolder.getFrameNum()!=7){
                                frameHolder.updateFrame(7);

                            }
                            else{
                                frameHolder.updateFrame(4);
                                setAttacking(false);
                            }
                        }
                        if(!arr.contains('d') && !arr.contains('a')){
                            if(frameHolder.getFrameNum() ==7 || frameHolder.getFrameNum() ==1 ||frameHolder.getFrameNum() ==0){
                                frameHolder.updateFrame(4);
                            }
                            else if(frameHolder.getFrameNum() ==4){
                                frameHolder.updateFrame(5);

                            }
                            else if(frameHolder.getFrameNum() == 5){
                                frameHolder.updateFrame(6);

                            }
                            else if(frameHolder.getFrameNum() == 6){
                                frameHolder.updateFrame(7);
                                setAttacking(false);
                            }
                            else if(frameHolder.getFrameNum() ==11 || frameHolder.getFrameNum() ==2 || frameHolder.getFrameNum() ==3){
                                frameHolder.updateFrame(8);
                            }
                            else if(frameHolder.getFrameNum() ==8){
                                frameHolder.updateFrame(9);
                            }
                            else if(frameHolder.getFrameNum() ==9){
                                frameHolder.updateFrame(10);
                            }
                            else if(frameHolder.getFrameNum() ==10){
                                frameHolder.updateFrame(11);
                                setAttacking(false);
                            }


                        }
                    }



            frameHolder.setCurrFramePause(0);
        }


        if(isFalling()) {
            fallingSpeedIncrement();
        }
        else{
            resetFallingSpeed();
        }
        if(getVelY()>=0){
            setFalling(false);
        }


        frameHolder.setCurrFramePause(frameHolder.getCurrFramePause()+1);


        refresh();
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
