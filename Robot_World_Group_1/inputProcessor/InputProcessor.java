package inputProcessor;

import java.awt.event.KeyEvent;
import robotWorld.Robot_World;

public class InputProcessor extends Robot_World
{
    public void control(int key)
    {
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W)
        {
            // arrow up or key 'w'
            robot.move();
        }
        else if (key == KeyEvent.VK_LEFT| key == KeyEvent.VK_A)
        {
            // arrow left or key 'a'
            robot.turnLeft();
        }
        else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D)
        {
            // arrow right or key 'd'
            robot.turnRight();
        }
        robot.updatePoints();
    }
}
