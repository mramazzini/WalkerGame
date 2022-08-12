public class HPBar {
    private FrameHolder frameHolder;
    private int maxHP;
    private int health;
    private int xVal;
    private int yVal;

    public HPBar(int maxHPAmount, int hpX, int hpY){
        xVal=hpX;
        yVal=hpY;
        maxHP = maxHPAmount;
        health = maxHPAmount;
        frameHolder = new FrameHolder(new String[]{
                "Assets/HPBar/HPBar0.png",
                "Assets/HPBar/HPBar1.png",
                "Assets/HPBar/HPBar2.png",
                "Assets/HPBar/HPBar3.png",
                "Assets/HPBar/HPBar4.png",
                "Assets/HPBar/HPBar5.png",
                "Assets/HPBar/HPBar6.png",
                "Assets/HPBar/HPBar7.png",
        });

    }

    public int getxVal() {
        return xVal;
    }

    public int getyVal() {
        return yVal;
    }

    public void setxVal(int xVal) {
        this.xVal = xVal;
    }

    public void setyVal(int yVal) {
        this.yVal = yVal;
    }

    public int getHealth(){
        return health;
    }
    public void updateHealth(int x){
        double newHp=(x+health);
        double maxHPdoub = maxHP;
        if(newHp>=maxHPdoub){
            health = (int)maxHPdoub;
            frameHolder.updateFrame(0);
        }
        else if(newHp/maxHPdoub >= 0.88){
            frameHolder.updateFrame(1);
        }
        else if(newHp/maxHPdoub >= 0.75){
            frameHolder.updateFrame(2);
        }
        else if(newHp/maxHPdoub >= 0.63){
            frameHolder.updateFrame(3);
        }
        else if(newHp/maxHPdoub >= 0.50){
            frameHolder.updateFrame(4);
        }
        else if(newHp/maxHPdoub >= 0.38){
            frameHolder.updateFrame(5);
        }
        else if(newHp/maxHPdoub >= 0.25){
            frameHolder.updateFrame(6);
        }
        else if(newHp/maxHPdoub >= 0.12){
            frameHolder.updateFrame(7);
        }

        health = health+x;

    }

    public FrameHolder getFrameHolder() {
        return frameHolder;
    }
}
