import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Level {

    private Character[] characters;
    private Platform[] platforms;
    private Background background;
    private final int cameraSpd = 10;
    private Flooring[] floorings;
    private Frederick frederick;
    private Camera camera;
    public Level(int lvl) throws IOException {
        frederick = new Frederick();
        camera = new Camera(0,0, Panel.WIDTH, Panel.HEIGHT);
        int[] black8=new int[] {9,9,9,9,9,9,9,9};
        if(lvl == 1){
            background=new Background("snow");
            characters=new Character[]{

                    new SnowMan(512+128,768-128-36)};
            platforms = new Platform[]{
                    new BluePlat(0, 3, 1024),
                    new BluePlat(0, 4, 512),
                    new BluePlat(4, 2, 256),
                    new BluePlat(2, 2, 256),
                    new BluePlat(8, 4, 1024)
            };
            floorings = new Flooring[]{


            };


        }
        else if(lvl == 2){
            background=new Background("snow");
            floorings = new Flooring[]{
                    new IceFloor(0,2,new int[][]{
                            {4,1,1,1,1,1,1,1,},
                            {6,9,9,9,9,9,9,9,},
                            {6,9,9,9,9,9,9,9}
                    }),
                    new IceFloor(8,3, new int[][]{
                            {2,1,1,1,1,1,1,1},
                            black8,
                            black8
                    }),
                    new IceFloor(16,4, new int[][]{
                            {2,1,1,1,1,1,1,3},
                            black8,
                            black8
                    }),
                    new IceFloor(24,3, new int[][]{
                            {1,1,1,1,1,1,1,3},
                            black8,
                            black8
                    }),
                    new IceFloor(32,2, new int[][]{
                            {1,1,1,1,1,1,1,5},
                            {9,9,9,9,9,9,9,7},
                            {9,9,9,9,9,9,9,7},
                    }),
            };
            characters=new Character[]{};


            platforms = new Platform[]{
                    new BluePlat(4, 1, 1024),
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
        background.drawBackground(g,2);
        frederick.drawCharacter(g);
        frederick.drawCharacter(g);
        for(Character c: characters){
            c.drawCharacter(g);
        }

        for(Platform p :platforms){
            p.drawPlatform(g);
        }
        for(Flooring f: floorings){
            f.drawTiles(g);

        }
    }
    public void adjustForCamera(){
        if(frederick.getHitBox().checkCollision(camera.getTopCollide())){
            moveEverything(0,cameraSpd);
        }
        if(frederick.getHitBox().checkCollision(camera.getBotCollide())){
            moveEverything(0,-cameraSpd);
        }
        if(frederick.getHitBox().checkCollision(camera.getLeftCollide())){
            moveEverything(cameraSpd,0);
        }
        if(frederick.getHitBox().checkCollision(camera.getRightCollide())){
            moveEverything(-cameraSpd,0);
        }
    }
    public void moveEverything(int offsetX, int offsetY){
        for(Platform p:platforms){
            p.setX(offsetX);
            p.setY(offsetY);
        }
        for(Character c:characters){
            c.setX(offsetX);
            c.setY(offsetY);
            c.setInitX(c.getInitX()+offsetX);
            c.setInitY(c.getInitY()+offsetY);
        }
        for(Flooring f:floorings){
            f.setX(offsetX);
            f.setY(offsetY);
        }
        background.setX(offsetX);
        background.setY(offsetY);
        frederick.setX(offsetX);
        frederick.setY(offsetY);
    }
    public void updateCharacters(ArrayList keyPressed){
        refreshCharacters();
        adjustForCamera();
        frederick.frederickState(keyPressed);
        isFrederickDumb();







    }
    public void isFrederickDumb(){ //Keeps Frederick from going into a wall
        int tileCnt =0;
        for(Flooring f:floorings){
            for(Tile t[]:f.getTiles()){
                tileCnt=tileCnt+t.length;
            }
        }

        Collider[] c= new Collider[getPlatforms().length+tileCnt];
        int count=0;
        for(Platform p: platforms){
            c[count]=p.getHitBox();
            count++;
        }

        for(Flooring f:floorings){
            for(Tile[] t: f.getTiles()){
                for(int i =0; i<t.length; i++){
                    c[count]=t[i].getHitBox();
                    count++;
                }
            }
        }

        if(frederick.getHitBox().checkCollisions(c)){
            frederick.setY(-frederick.getY()+frederick.getPrevY());
            frederick.setVelY(-frederick.getVelY());
        }
        if(frederick.getHitBox().checkCollisions(c)) {
            frederick.setX(-frederick.getX() + frederick.getPrevX());
            frederick.setVelX(-frederick.getVelX());
        }

    }
    public void checkDamageCollision(){
        //Collider[] c = new Collider[frederick.getCurrentWeapon().getHitBoxInt()]
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

        //Draw Hrt Boxes
        g.setColor(Color.RED);
        for(Collider i:frederick.getHurtBoxes()){
            g.drawRect(i.getxLeft(),i.getyTop(),i.getxRight()-i.getxLeft(), i.getyBot()-i.getyTop());
        }
        //Draw Flooring

        for(Flooring f: floorings){
            f.drawHitboxes(g);

        }

        //Draw Camera
        camera.drawHitBox(g);

    }

}
