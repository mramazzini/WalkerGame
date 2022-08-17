import java.awt.*;

public class IceTile extends Tile{


    private String type; //slant, straight, drop, none
    private String lftOrRgt; //facing left or right



    public IceTile(int xVal, int yVal, String typeOfTile, String leftOrRight){


        setHeight(256);
        setWidth(128);
        type=typeOfTile;
        lftOrRgt=leftOrRight;
        if(type.equals("straight")){
            setFrameHolder(new String[] {"Assets/Flooring/IceFloor/IceTile0.png"});
            createHitBox(getX(),getY()+getHeight()*1/2, getX()+getWidth(), getY()+getHeight() );

        }

        else if(type.equals("slant")){
            if(lftOrRgt.equals("left")){
                setFrameHolder(new String[] {"Assets/Flooring/IceFloor/IceSlantL1.png"});
                createHitBox(getX(),getY()+getHeight()*1/2, getX()+getWidth(), getY()+getHeight() );
            }
            else{
                setFrameHolder(new String[] {"Assets/Flooring/IceFloor/IceSlantR2.png"});
                createHitBox(getX(),getY()+getHeight()*1/2, getX()+getWidth(), getY()+getHeight() );
            }
        }
        else if(type.equals("drop")){
            if(lftOrRgt.equals("left")){
                setFrameHolder(new String[] {"Assets/Flooring/IceFloor/IceDrop3.png"});
                createHitBox(getX(),getY()+getHeight()*1/2, getX()+getWidth(), getY()+getHeight() );
            }
            else{
                setFrameHolder(new String[] {"Assets/Flooring/IceFloor/IceDrop4.png"});
                createHitBox(getX(),getY()+getHeight()*1/2, getX()+getWidth(), getY()+getHeight() );
            }
        }
        else if(type.equals("wall")){
            if(lftOrRgt.equals("left")){
                setFrameHolder(new String[] {"Assets/Flooring/IceFloor/IceWallL5.png"});
                createHitBox(getX(),getY()+getHeight()*1/2, getX()+getWidth(), getY()+getHeight() );
            }
            else{
                setFrameHolder(new String[] {"Assets/Flooring/IceFloor/IceWallR6.png"});
                createHitBox(getX(),getY()+getHeight()*1/2, getX()+getWidth(), getY()+getHeight() );
            }
        }
        else if(type.equals("black")){
            setFrameHolder(new String[] {"Assets/Flooring/IceFloor/black.png"});
            createHitBox(0,0, 0, 0 );

        }
        else{
            setFrameHolder(new String[] {"Assets/Flooring/IceFloor/blank.png"});
            createHitBox(0,0,0,0);
        }
        setX(xVal);
        setY(yVal-getHeight()/2);
    }
}
