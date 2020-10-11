import javax.swing.*;
import java.awt.*;

import world.World;
import robot.Robot;

public class Robot_World
{
    private static World world;
    private static Robot robot;
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

        buttons[0].add(new drawPolygon(robot.getXpoints(), robot.getYpoints(), 3));

        frame.setVisible(true);
    }
}

class drawPolygon extends JComponent 
{
    int[] xpoint, ypoint;
    int npoint;

    drawPolygon(int[] x, int[] y, int n)
    {
        xpoint = x;
        ypoint = y;
        npoint = n;
    }

    public void paint(Graphics g) 
    {
        super.paintComponents(g);
        g.setColor(Color.BLUE);
        g.fillPolygon(xpoint, ypoint, npoint);
    }

}