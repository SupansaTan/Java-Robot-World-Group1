import javax.swing.*;
import java.awt.*;

import world.World;
import robot.Robot;
import target.Target;

public class Robot_World
{
    private static World world;
    private static Robot robot;
    private static Target target;
    private static JFrame frame;
    private static JPanel mainPanel;
    private static JButton[] buttons; 

    public static void main(String[] args)
    {
        // create frame
        frame = new JFrame("Robot World");
        frame.setSize(800,800);
        frame.setTitle("Robot World");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create object of class
        world = new World();
        robot = new Robot();
        target = new Target(9,7);

        // use grid in panel for divide blocks
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(world.getMaxRow(), world.getMaxColumn(),2,2));
        mainPanel.setBackground(Color.BLACK);
        frame.add(mainPanel);

        // use button instead of each block
        int amountOfBtn = world.getMaxRow() * world.getMaxColumn();
        buttons = new JButton[amountOfBtn];

        for (int i=0; i<amountOfBtn; i++)
        {
            buttons[i] = new JButton();
            if (world.isBlackBlock( i/world.getMaxRow(), i%world.getMaxColumn() ))
            {
                buttons[i].setBackground(Color.BLACK);
            }
            else
            {
                buttons[i].setBackground(Color.WHITE);
            }
            buttons[i].setBorder(null);
            mainPanel.add(buttons[i]);
        }

        // display the robot
        buttons[robot.getRow() * world.getMaxRow() + robot.getColumn()].add(new DrawPolygon(robot.getXpoints(), robot.getYpoints(), 3));
        
        // display the target
        buttons[target.getRow() * world.getMaxRow() + target.getColumn()].add(new DrawPolygon(target.getXpoints(), target.getYpoints(), 8));

        frame.setVisible(true);
    }
}

class DrawPolygon extends JComponent 
{
    int[] xpoint, ypoint;
    int npoint;

    DrawPolygon(int[] x, int[] y, int n)
    {
        xpoint = x;
        ypoint = y;
        npoint = n;
    }

    public void paint(Graphics g) 
    {
        super.paintComponents(g);

        if (npoint == 3)
        {
            g.setColor(Color.BLUE); // Robot
        }
        else
        {
            g.setColor(Color.RED); // Target
        }

        g.fillPolygon(xpoint, ypoint, npoint);
    }

}