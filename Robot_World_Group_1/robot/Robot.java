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
}
