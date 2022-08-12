import java.awt.*;
import java.io.IOException;

public class Level {

    private Character[] characters;
    private Platform[] platforms;
    private Frederick frederick;
    public Level(int lvl) throws IOException {
        frederick = new Frederick();
        if(lvl == 0){
            characters=new Character[]{

                    new SnowMan(512+128,768-128-36)};
            platforms = new Platform[]{
                    new BluePlat(0, 768-36, 1024),
                    new BluePlat(0, 512-36, 512),
                    new BluePlat(512, 256-36, 256),
                    new BluePlat(256, 256-36, 256)};
        }
        if(lvl ==1){

        }



    }
    public void refreshCharacters(){
        for(int i=0; i<characters.length; i++){
            if(characters[i].getType().equals("snowman")){

                SnowMan s = (SnowMan)characters[i];
                s.updateFrame();
                characters[i]=s;
            }
            characters[i].refresh();
        }
    }
    public Character[] getCharacters(){
        return characters;
    }

    public Frederick getFrederick() {
        return frederick;
    }

    public Platform[] getPlatforms(){
        return platforms;
    }
    public void drawLevel(Graphics g){
        g.drawImage(frederick.getFrame(), frederick.getX(), frederick.getY(), null);
        g.drawImage(frederick.getHpImg(), frederick.getHP().getxVal(), frederick.getHP().getyVal(), null);
        for(int i=0; i<characters.length; i++){
            g.drawImage(characters[i].getFrame(), characters[i].getX(), characters[i].getY(), null);
            g.drawImage(characters[i].getHpImg(), characters[i].getHP().getxVal(), characters[i].getHP().getyVal(), null);
        }

        for(int i=0; i<platforms.length; i++){
            g.drawImage(platforms[i].getFrame(), platforms[i].getX(), platforms[i].getY(), null);
        }
    }
}
