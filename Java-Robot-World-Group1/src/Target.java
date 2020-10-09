public class Target {
    World world;

    int width;
    int height;
    int posX, posY;

    Target(int x, int y,int winWidth,int winHeight){
        posX = x;
        posY = y;
        width = winWidth;
        height = winHeight;

    }

    boolean met(int X, int Y) {
        // check the target met the robot or not

        if ((posX == X) && (posY == Y)) {
            // when the robot is on target
            return true;
        }
        else {
            return false;
        }
    }

    int draw() {
        float actualPosX = (width/world.getMaxX()*posX)+width/world.getMaxX()/2;
        float actualPosY = (height/world.getMaxY()*posY)+height/world.getMaxY()/2;
        float radius =  width/world.getMaxX()/2;
        int cornerNumber = 8; //octagon
        return(actualPosX, actualPosY, radius, cornerNumber) ;

    }

    int getPosX() {
        return posX;
    }

    int getPosY() {
        return posY;
    }
}
