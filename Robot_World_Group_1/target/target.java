package target;

public class Target {
    int posX, posY;

    Target(int x, int y) {
        posX = x;
        posY = y;
    }

    boolean met(int X, int Y) {
        
        if (x == posX && Y == posY) {
            return true;
        }
        else {
            return false;
        }
    }

    int getPosX() {
        return posX;
    }

    int getPosY() {
        return posY;
    }
}
