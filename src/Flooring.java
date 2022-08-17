import java.awt.*;
import java.awt.image.BufferedImage;

public class Flooring {
    private int xVal;
    private int yVal;
    private Tile[][] tiles;


    public void setX(int updateX) {
        xVal = updateX+xVal;
        for(Tile[] t:tiles){
            for(Tile tile:t){
                tile.setX(updateX);
            }
        }
    }

    public void setY(int updateY) {
        yVal=yVal+updateY;
        for(Tile[] t:tiles){
            for(Tile tile:t){
                tile.setY(updateY);
            }
        }
    }
    public void drawHitboxes(Graphics g){
        g.setColor(Color.yellow);
        for(Tile[] t:getTiles()){
            for(Tile tile:t){
                tile.drawHitbox(g);
            }
        }
    }
    public void drawTiles(Graphics g){

        for(Tile[] t:getTiles()){
            for(Tile tile:t){
                tile.drawImage(g);
            }
        }
    }

    public int getX(){
        return xVal;
    }

    public int getY(){
        return yVal;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }
}
