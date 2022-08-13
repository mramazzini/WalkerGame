public class Collider {

    private int xLeft;
    private int xRight;
    private int yTop;
    private int yBot;

    private String hitBoxType; //Hurtbox, solidObject, AttackBox, Camera

    public Collider(int xL, int xR, int yT, int yB , String type){
        hitBoxType=type;
        xLeft=xL;
        xRight=xR;
        yTop=yT;
        yBot=yB;
    }
    public Boolean checkCollision(Collider oppCol){

        if(yBot> oppCol.yTop && yTop < oppCol.yBot){
            if(xLeft < oppCol.xRight && xRight > oppCol.xLeft){
                return true;

            }

        }

        return false;
    }

    public boolean checkFrederickCollision(Collider[] colliders){
        for(int i=0; i< colliders.length; i++){
            if(checkCollision(colliders[i])){

                return true;
            }

        }


        return false;

    }

    public int[] getCorners(){
        int[] temp=new int[]{xLeft,xRight,yTop,yBot};
        return temp;
    }

    public String getHitBoxType() {
        return hitBoxType;
    }

    public void setHitBoxType(String hitBoxType) {
        this.hitBoxType = hitBoxType;
    }

    public void setxLeft(int xLeft) {
        this.xLeft = xLeft;
    }

    public void setxRight(int xRight) {
        this.xRight = xRight;
    }

    public void setyBot(int yBot) {
        this.yBot = yBot;
    }

    public void setyTop(int yTop) {
        this.yTop = yTop;
    }

    public int getxLeft() {
        return xLeft;
    }

    public int getxRight() {
        return xRight;
    }

    public int getyBot() {
        return yBot;
    }

    public int getyTop() {
        return yTop;
    }
}
