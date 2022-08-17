import java.awt.*;

public class Camera {
    private int x;
    private int y;
    private Collider topCollide;
    private Collider botCollide;
    private Collider rightCollide;
    private Collider leftCollide;
    public Camera(int xVal, int yVal, int width, int length){
        x = xVal;
        y= yVal;
        moveScreenCollider(xVal, yVal, width, length);
    }

    public void moveScreenCollider(int xVal, int yVal, int width, int length){
        topCollide= new Collider(xVal, width, yVal-1000, length*1/2, "camera");
        botCollide= new Collider(xVal, width, yVal+length*1/2, length+1000, "camera");
        rightCollide= new Collider(xVal+width*1/2, width+1000, yVal, length, "camera");
        leftCollide= new Collider(xVal-1000, width*1/2, yVal, length, "camera");
    }

    public Collider getBotCollide() {
        return botCollide;
    }

    public Collider getLeftCollide() {
        return leftCollide;
    }

    public Collider getRightCollide() {
        return rightCollide;
    }

    public Collider getTopCollide() {
        return topCollide;
    }
    public void drawHitBox(Graphics g){
        g.setColor(Color.MAGENTA);
        Collider c= getBotCollide();
        g.drawRect(c.getxLeft(), c.getyTop(), c.getxRight()-c.getxLeft(), c.getyBot()-c.getyTop());
        c=getLeftCollide();
        g.drawRect(c.getxLeft(), c.getyTop(), c.getxRight()-c.getxLeft(), c.getyBot()-c.getyTop());
        c=getRightCollide();
        g.drawRect(c.getxLeft(), c.getyTop(), c.getxRight()-c.getxLeft(), c.getyBot()-c.getyTop());
        c=getTopCollide();
        g.drawRect(c.getxLeft(), c.getyTop(), c.getxRight()-c.getxLeft(), c.getyBot()-c.getyTop());
    }
}
