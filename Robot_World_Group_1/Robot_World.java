import javax.swing.*;
import world.World;
import robot.Robot;

public class Robot_World {
    public static void main(String[] args)
    {
        // create frame
        JFrame frame = new JFrame("Robot World");
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        World world = new World();
        world.display();

        frame.setVisible(true);
    }
}
