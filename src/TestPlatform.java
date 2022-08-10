

public class TestPlatform extends Platform{

    public TestPlatform(int x, int y){
        setX(x);
        setY(y);
        setWidth(100);
        setHeight(300);
        createHitBox(getX(),getX()+10000, getY(), getY()+10 );
        setFrameHolder(new String[] {"Assets/TestPlatform.png"});
    }


}
