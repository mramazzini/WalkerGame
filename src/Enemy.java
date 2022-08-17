public class Enemy extends Character{
    private boolean isAlive;

    public void setAlive(boolean b){
        isAlive=b;
    }
    public boolean getAlive(){
        return isAlive;
    }

    public void move(){
        int x = getInitX();

        if(getX()>=x){

            setVelX(-2);
        }
        if(getX()<x-512){

            setVelX(2);
        }



    }
}
