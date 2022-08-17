public class BluePlat extends Platform{

    public BluePlat(int x, int y, int size){
        setX(x*128);
        setY(y*128);
        setHeight(36);
        if(size==1024){
            setWidth(1024);
            setFrameHolder(new String[] {"Assets/Flooring/BluePlatform/PlatBlue1024.png"});
        }
        else if(size==512){
            setWidth(512);
            setFrameHolder(new String[] {"Assets/Flooring/BluePlatform/PlatBlue512.png"});
        }
        else{ //Default
            setWidth(256);
            setFrameHolder(new String[] {"Assets/Flooring/BluePlatform/PlatBlue256.png"});
        }
        createHitBox(getX(),getX()+getWidth(), getY(), getY()+getHeight() );

    }
}
