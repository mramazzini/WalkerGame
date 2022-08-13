public class Weapon {
    //holds the hitboxes per frame of fredericks weapons
    private int x;
    private int y;
    private String type;
    private int[][] damageBox;

    public Weapon(int xVal, int yVal, String typeOfWeapon){
        x=xVal;
        y=yVal;
        type=typeOfWeapon;



    }

    public int[][] getHitBoxInt(int frame) {
        if (type.equals("sword")) {
            if (frame == 4) {
                damageBox = new int[][]{
                        {x + 48, x + 56, y + 231, y + 239},
                        {x + 56, x + 64, y + 223, y + 231},
                        {x + 64, x + 72, y + 215, y + 223},
                        {x + 72, x + 80, y + 207, y + 215},
                        {x + 80, x + 88, y + 199, y + 207},
                        {x + 88, x + 96, y + 191, y + 199},
                };

            }
            else if (frame == 5) {
                damageBox = new int[][]{
                        {x + 72, x + 80, y + 124, y + 132},
                        {x + 80, x + 88, y + 132, y + 140},
                        {x + 88, x + 96, y + 140, y + 148},
                        {x + 96, x + 104, y + 148, y + 156},
                        {x + 104, x + 112, y + 156, y + 164},
                        {x + 112, x + 120, y + 164, y + 172},
                };
            }
            else if (frame == 6) {
                damageBox = new int[][]{
                        {x + 175, x + 183, y + 124, y + 132},
                        {x + 167, x + 175, y + 132, y + 140},
                        {x + 159, x + 167, y + 140, y + 148},
                        {x + 151, x + 159, y + 148, y + 156},
                        {x + 143, x + 151, y + 156, y + 164},
                        {x + 135, x + 143, y + 164, y + 172},

                };
            }
            else if (frame == 7) {
                damageBox = new int[][]{
                        {x + 187, x + 195, y + 156, y + 164},
                        {x + 179, x + 187, y + 164, y + 172},
                        {x + 171, x + 179, y + 172, y + 180},
                        {x + 163, x + 171, y + 180, y + 188},
                        {x + 155, x + 163, y + 188, y + 196},
                        {x + 147, x + 155, y + 196, y + 204},

                };
            }
            else if (frame == 8) {
                damageBox = new int[][]{
                        {x + 200, x + 208, y + 231, y + 239},
                        {x + 192, x + 200, y + 223, y + 231},
                        {x + 184, x + 192, y + 215, y + 223},
                        {x + 176, x + 184, y + 207, y + 215},
                        {x + 168, x + 176, y + 199, y + 207},
                        {x + 160, x + 168, y + 191, y + 199},

                };
            }
            else if (frame == 9) {
                damageBox = new int[][]{
                        {x + 175, x + 183, y + 124, y + 132},
                        {x + 167, x + 175, y + 132, y + 140},
                        {x + 159, x + 167, y + 140, y + 148},
                        {x + 151, x + 159, y + 148, y + 156},
                        {x + 143, x + 151, y + 156, y + 164},
                        {x + 135, x + 143, y + 164, y + 172},

                };
            }
            else if (frame == 10) {
                damageBox = new int[][]{
                        {x + 72, x + 80, y + 124, y + 132},
                        {x + 80, x + 88, y + 132, y + 140},
                        {x + 88, x + 96, y + 140, y + 148},
                        {x + 96, x + 104, y + 148, y + 156},
                        {x + 104, x + 112, y + 156, y + 164},
                        {x + 112, x + 120, y + 164, y + 172},

                };
            }
            else if (frame == 11) {
                damageBox = new int[][]{
                        {x + 60, x + 68, y + 156, y + 164},
                        {x + 68, x + 76, y + 164, y + 172},
                        {x + 76, x + 84, y + 172, y + 180},
                        {x + 84, x + 92, y + 180, y + 188},
                        {x + 92, x + 100, y + 188, y + 196},
                        {x + 100, x + 108, y + 196, y + 204},
                };
            }
            else {
                damageBox = new int[][]{};
            }

        }
        return damageBox;

    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }
}
