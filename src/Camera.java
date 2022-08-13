public class Camera {
    private int x;
    private int y;
    private Collider topCollide;
    private Collider botCollide;
    private Collider rightCollide;
    private Collider leftCollide;
    public Camera(int xVal, int yVal, int width, int length){
        topCollide= new Collider(xVal, width, yVal, length/4, "camera");
        botCollide= new Collider(xVal, width, yVal+length*3/4, length, "camera");
        rightCollide= new Collider(xVal+width*4/5, width, yVal, length, "camera");
        leftCollide= new Collider(xVal, width*1/5, yVal, length, "camera");
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
}
