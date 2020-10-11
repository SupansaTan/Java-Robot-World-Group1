package robot;

public class Robot {
    int direction; // 0:headup 1:headright 2:headdown 3:headleft
    int posX, posY;
    int headPosX, headPosY;
    int leftPosX, leftPosY;
    int rightPosX, rightPosY;

    Robot(int px,int py,int di) {
        posX = px;
        posY = py;
        direction = di;
    }

    void headUp() {

    }

    void headDown() {

    }

    void headLeft() {

    }

    void headRight() {
        
    }

    void turnLeft() {
        if (direction == 0) {
            direction = 3;
        }
        else {
            direction -= 1;
        }
    }

    void turnRight() {
        if (direction == 3) {
            direction = 0;
        }
        else {
            direction += 1;
        }
    }

    void move() {
        if (direction == 0 && !this.isAtTopEdge()) {
            posY -= 1;
        }
        else if (directionn == 1 && !this.isAtRightEdge()) {
            posX += 1;
        }
        else if (direction == 2 && !this.isAtBottomEdge()) {
            posY += 1;
        }
        else if (direction == 3 && !this.isAtLeftEdge()) {
            posX -= 1;
        }
    }

    int getX() {
        return(posX);
    }

    int getY() {
        return(posY);
    }

    boolean isAtTopEdge() {
        return posY <= 0;
    }

    boolean isAtBottomEdge() {
        return posY >= -1;
    }

    boolean isAtLeftEdge() {
        return posX <= 0;
    }

    boolean isAtRightEdge() {
        return posX >= -1;
    }
}
