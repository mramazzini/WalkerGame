import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public abstract class Character {



    //Holds the hitbox
    private Weapon currentWeapon;
    private boolean hasWeapon=false;
    private Boolean hasHitBox=false;
    private Collider hitBox;
    private int width;
    private int length;
    private String directionX; //Left or Right
    private ArrayList<Collider> hurtBoxes;
    private ArrayList<Collider> dmgBoxes;

    FrameHolder frameHolder;
    private String type;
    private int maxSpeedX = 10;
    private int maxSpeedY = 20;
    private int initX;
    private int initY;
    private int velX;
    private int velY;
    private HPBar hp;
    //X and Y pixelValues on the screen
    private int xVal;
    private boolean hasHP;
    private int yVal;
    private int prevX;
    private int prevY;
    private boolean isFalling;
    private int fallingSpeed;
    private boolean hasGravity;
    private final int GRAVSPEED = 5;

    public Collider[] getHurtBoxes(){
        Collider[] arr = new Collider[hurtBoxes.size()];
        for(int i=0; i< hurtBoxes.size(); i++){
            arr[i] = hurtBoxes.get(i);
        }
        return arr;
    }

    public void createHurtBoxes(int[][] vals){
        hurtBoxes = new ArrayList<Collider>();
        for(int i=0; i<vals.length; i++){
            hurtBoxes.add(new Collider(vals[i][0], vals[i][1], vals[i][2], vals[i][3], "hurtBox"));
        }
    }
    public void createWeapon(String type){
        hasWeapon=true;
        currentWeapon=new Weapon(xVal,yVal,type);
    }
    public void createDmgBoxes(int[][] vals){
        dmgBoxes = new ArrayList<Collider>();
        for(int i=0; i<vals.length; i++){
            dmgBoxes.add(new Collider(vals[i][0], vals[i][1], vals[i][2], vals[i][3], "attackBox"));
        }
    }
    public void setFrameHolder(String[] path){
        frameHolder = new FrameHolder(path);
    }
    public BufferedImage getFrame(){
        return frameHolder.getCurrentFrame();
    }
    public void initHP(int maxHP, int hpx, int hpy){
        hasHP = true;
        hp = new HPBar(maxHP, hpx, hpy);
    }
    public HPBar getHP() {
        return hp;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setType(String t){
        type=t;
    }
    public String getType(){
        return type;
    }
    public BufferedImage getHpImg(){
        return hp.getFrameHolder().getCurrentFrame();
    }
    public int getWidth(){
        return width;
    }
    public int getLength(){
        return length;
    }
    public void setWidth(int w){
        width=w;
    }
    public void setLength(int l){
        length = l;
    }
    public int getX(){
        return xVal;
    }
    public void setX(int updateX){
        xVal = xVal+updateX;
        if(hasHP){
            hp.setxVal(hp.getxVal()+updateX);
        }
        if(hasWeapon){
            currentWeapon.setX(currentWeapon.getX()+updateX);
        }
        if(hasHitBox){
            hitBox.setxLeft(hitBox.getxLeft()+updateX);
            hitBox.setxRight(hitBox.getxRight()+updateX);
        }
    }
    public int getY(){
        return yVal;
    }
    public void setY(int updateY){
        yVal = yVal + updateY;
        if(hasHP){
            hp.setyVal(hp.getyVal()+updateY);
        }
        if(hasWeapon){
            currentWeapon.setY(currentWeapon.getY()+updateY);
        }
        if(hasHitBox){
            hitBox.setyTop(hitBox.getyTop()+updateY);
            hitBox.setyBot(hitBox.getyBot()+updateY);
        }

    }
    public void initGravity(){
        hasGravity=true;
    }
    public void stopGravity(){
        hasGravity=false;
    }
    public boolean getHasHitBox(){
        return hasHitBox;
    }
    public boolean hasHp(){
        return hasHP;
    }

    public void fall(){
        if(hasGravity){
            setPrevY(yVal);
            setVelY(GRAVSPEED);


        }
    }
    public void refresh(){

        setPrevY(getY());
        setPrevX(getX());
        fall();
        if(velY>maxSpeedY){
            velY=maxSpeedY;
        }
        if(velY<-maxSpeedY){
            velY=-maxSpeedY;
        }
        if(velX>maxSpeedX){
            velX=maxSpeedX;
        }
        if(velX<-maxSpeedX){
            velX=-maxSpeedX;
        }

        setY(velY);
        setX(velX);
        if(velX>0){
            directionX="right";
        }
        if(velX<0){
            directionX="left";
        }

    }

    public Collider getHitBox(){
        return hitBox;
    }
    public void createHitBox(int x, int y, int width, int height){
        hasHitBox = true;
        hitBox = new Collider(x,y,width,height, "solidObject");
    }
    public int getPrevX(){
        return prevX;
    }
    public int getPrevY(){
        return prevY;
    }
    public void setPrevX(int x){
        prevX=x;
    }
    public void setPrevY(int y){
        prevY=y;
    }
    public void setVelX(int x){
        velX=velX+x;
    }
    public void setVelY(int y){
        velY=velY+y;
    }
    public int getVelX(){
        return velX;
    }
    public int getVelY(){
        return velY;
    }
    public void setInitX(int x){
        initX=x;
    }
    public void setInitY(int y){
        initY=y;
    }
    public int getInitX(){
        return initX;
    }
    public int getInitY(){
        return initY;
    }
    public String getDirectionX(){
        return directionX;
    }


    public void setFalling(boolean b){
        isFalling=b;
    }
    public boolean isFalling(){
        return isFalling;
    }

    public int getFallingSpeed(){
        return fallingSpeed;
    }
    public void fallingSpeedIncrement(){
        fallingSpeed++;
    }
    public void resetFallingSpeed(){
        fallingSpeed=0;
    }

    public void drawCharacter(Graphics g){
        g.drawImage(getFrame(), getX(), getY(), null);
        g.drawImage(getHpImg(), getHP().getxVal(), getHP().getyVal(), null);
    }

}
