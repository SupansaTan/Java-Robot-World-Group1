package inputProcessor;

import java.awt.event.KeyEvent;
import robotWorld.Robot_World;
import target.Target;

public class InputProcessor extends Robot_World
{
    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset, Sikarin Kaewjutaniti
    //
    // Description: for control when push key
    // 
    /////////////////////////////////////////////////////
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
        else if(key == KeyEvent.VK_S)
        {
            world.writeFile();
        }

        robot.updatePoints();
    }
}
