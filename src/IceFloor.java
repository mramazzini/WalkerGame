import java.awt.*;

public class IceFloor extends Flooring{

    public IceFloor(int x, int y, int[][] locations){


        int offx = 128;
        int offy = 256;
        x=x*offx/2;
        y=y*offy/4;
        Tile[][] tiles = new Tile[locations.length][locations[0].length];
        for(int i=0; i< locations.length; i++){
            for(int j=0; j< locations[i].length; j++){
                if(locations[i][j]==1){
                    tiles[i][j] = new IceTile(x+j*offx,y+i*offy, "straight", "left");
                }
                else if(locations[i][j]==2){
                    tiles[i][j] = new IceTile(x+j*offx,y+i*offy, "slant", "left");
                }
                else if(locations[i][j]==3){
                    tiles[i][j] = new IceTile(x+j*offx,y+i*offy, "slant", "right");
                }
                else if(locations[i][j]==4){
                    tiles[i][j] = new IceTile(x+j*offx,y+i*offy, "drop", "left");
                }
                else if(locations[i][j]==5){
                    tiles[i][j] = new IceTile(x+j*offx,y+i*offy, "drop", "right");
                }
                else if(locations[i][j]==6){
                    tiles[i][j] = new IceTile(x+j*offx,y+i*offy/2, "wall", "left");
                }
                else if(locations[i][j]==7){
                    tiles[i][j] = new IceTile(x+j*offx,y+i*offy/2, "wall", "right");
                }
                else if(locations[i][j]==9){
                    tiles[i][j] = new IceTile(x+j*offx,y+i*offy, "black", "right");
                }

                else{
                    tiles[i][j] = new IceTile(x+j*offx,y+i*offy, "blank", "left");
                }
            }
        }

        setTiles(tiles);
        setX(x);
        setY(y);
    }


}
