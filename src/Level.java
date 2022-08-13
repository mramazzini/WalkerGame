import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Level {

    private Character[] characters;
    private Platform[] platforms;
    private Frederick frederick;
    private Camera camera;
    public Level(int lvl) throws IOException {
        frederick = new Frederick();
        camera = new Camera(0,0, Panel.WIDTH, Panel.HEIGHT);
        if(lvl == 0){
            characters=new Character[]{

                    new SnowMan(512+128,768-128-36)};
            platforms = new Platform[]{
                    new BluePlat(0, 768 - 36, 1024),
                    new BluePlat(0, 512 - 36, 512),
                    new BluePlat(512, 256 - 36, 256),
                    new BluePlat(256, 256 - 36, 256),
                    new BluePlat(1024, 768 - 36, 1024)
            };
        }

        else{
            System.out.println("ERROR: Invalid level");
            characters = new Character[0];
            platforms = new Platform[0];
        }



    }
    public void refreshCharacters(){
        for(int i=0; i<characters.length; i++){
            if(characters[i].getType().equals("snowman")){

                SnowMan s = (SnowMan) characters[i];
                s.updateFrame();
                characters[i]=s;
            }
            characters[i].refresh();
        }
    }
    public Character[] getCharacters(){
        return characters;
    }

    public Frederick getFrederick() {
        return frederick;
    }

    public Platform[] getPlatforms(){
        return platforms;
    }
    public void drawLevel(Graphics g){
        g.drawImage(frederick.getFrame(), frederick.getX(), frederick.getY(), null);
        g.drawImage(frederick.getHpImg(), frederick.getHP().getxVal(), frederick.getHP().getyVal(), null);
        for(int i=0; i<characters.length; i++){
            g.drawImage(characters[i].getFrame(), characters[i].getX(), characters[i].getY(), null);
            g.drawImage(characters[i].getHpImg(), characters[i].getHP().getxVal(), characters[i].getHP().getyVal(), null);
        }

        for(int i=0; i<platforms.length; i++){
            g.drawImage(platforms[i].getFrame(), platforms[i].getX(), platforms[i].getY(), null);
        }
    }
    public void adjustForCamera(){

    }
    public void updateCharacters(ArrayList keyPressed){
        refreshCharacters();
        frederick.frederickState(keyPressed);
        isFrederickDumb();

    }
    public void isFrederickDumb(){ //Keeps Frederick from going into a wall
        Collider[] c= new Collider[getPlatforms().length];
        for(int i =0; i<c.length; i++){
            c[i]=getPlatforms()[i].getHitBox();
        }
        if(frederick.getHitBox().checkFrederickCollision(c)){
            frederick.setY(-frederick.getY()+frederick.getPrevY());
            frederick.setVelY(-frederick.getVelY());
        }
        if(frederick.getHitBox().checkFrederickCollision(c)) {
            frederick.setX(-frederick.getX() + frederick.getPrevX());
            frederick.setVelX(-frederick.getVelX());
        }
    }
    public void drawHitBoxes(Graphics g){

        //Draw Characters Hitbox
        g.setColor(Color.BLUE);
        g.drawRect(frederick.getHitBox().getxLeft(), frederick.getHitBox().getyTop(), frederick.getHitBox().getxRight()-frederick.getHitBox().getxLeft(), frederick.getHitBox().getyBot()- frederick.getHitBox().getyTop());
        for(int i=0; i< characters.length; i++){
            g.drawRect(characters[i].getHitBox().getxLeft(), characters[i].getHitBox().getyTop(), characters[i].getHitBox().getxRight()-characters[i].getHitBox().getxLeft(), characters[i].getHitBox().getyBot()- characters[i].getHitBox().getyTop());
        }

        //Draw Platform hitbox
        g.setColor(Color.green);
        for(int i=0; i< platforms.length; i++){
            g.drawRect(platforms[i].getHitBox().getxLeft(), platforms[i].getHitBox().getyTop(), platforms[i].getHitBox().getxRight()-platforms[i].getHitBox().getxLeft(), platforms[i].getHitBox().getyBot()- platforms[i].getHitBox().getyTop());
        }


        //Draw Dmg Boxes
        g.setColor(Color.black);
        for(int i=0; i< frederick.getCurrentWeapon().getHitBoxInt(frederick.frameHolder.getFrameNum()).length; i++){
            g.drawRect(
                    frederick.getCurrentWeapon().getHitBoxInt(frederick.frameHolder.getFrameNum())[i][0],
                    frederick.getCurrentWeapon().getHitBoxInt(frederick.frameHolder.getFrameNum())[i][2],
                    frederick.getCurrentWeapon().getHitBoxInt(frederick.frameHolder.getFrameNum())[i][1]- frederick.getCurrentWeapon().getHitBoxInt(frederick.frameHolder.getFrameNum())[i][0],
                    frederick.getCurrentWeapon().getHitBoxInt(frederick.frameHolder.getFrameNum())[i][3]-frederick.getCurrentWeapon().getHitBoxInt(frederick.frameHolder.getFrameNum())[i][2]);
        }

        //Draw Camera
        g.setColor(Color.MAGENTA);
        Collider c= camera.getBotCollide();
        g.drawRect(c.getxLeft(), c.getyTop(), c.getxRight()-c.getxLeft(), c.getyBot()-c.getyTop());
        c=camera.getLeftCollide();
        g.drawRect(c.getxLeft(), c.getyTop(), c.getxRight()-c.getxLeft(), c.getyBot()-c.getyTop());
        c=camera.getRightCollide();
        g.drawRect(c.getxLeft(), c.getyTop(), c.getxRight()-c.getxLeft(), c.getyBot()-c.getyTop());
        c=camera.getTopCollide();
        g.drawRect(c.getxLeft(), c.getyTop(), c.getxRight()-c.getxLeft(), c.getyBot()-c.getyTop());

    }

}
