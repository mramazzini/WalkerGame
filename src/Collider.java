public class Collider {

    private int xLeft;
    private int xRight;
    private int yTop;
    private int yBot;


    public Collider(int xL, int xR, int yT, int yB){
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

    public boolean checkFrederickCollision(Platform[] platforms){
        for(int i=0; i< platforms.length; i++){
            if(checkCollision(platforms[i].getHitBox())){

                return true;
            }

        }


        return false;

    }

    public int[] getCorners(){
        int[] temp=new int[]{xLeft,xRight,yTop,yBot};
        return temp;
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
