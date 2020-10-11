package target;

public class Target 
{
    private int posX, posY;

    public Target(int x, int y) {
        posX = x;
        posY = y;
    }

    public boolean met(int X, int Y) {
        
        if (X == posX && Y == posY) {
            return true;
        }
        else {
            return false;
        }
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
