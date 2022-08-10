public class BluePlat extends Platform{

    public BluePlat(int x, int y, int size){
        setX(x);
        setY(y);
        setHeight(36);
        if(size==1024){
            setWidth(1024);
            setFrameHolder(new String[] {"Assets/PlatBlue1024.png"});
            createHitBox(getX(),getX()+1024, getY(), getY()+36 );
        }
        else if(size==512){
            setWidth(512);
            setFrameHolder(new String[] {"Assets/PlatBlue512.png"});
            createHitBox(getX(),getX()+512, getY(), getY()+36 );
        }
        else{ //Default
            setWidth(256);
            setFrameHolder(new String[] {"Assets/PlatBlue256.png"});
            createHitBox(getX(),getX()+256, getY(), getY()+36 );
        }


    }
}
