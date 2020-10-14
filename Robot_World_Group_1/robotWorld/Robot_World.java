package robotWorld;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import world.World;
import robot.Robot;
import target.Target;
import inputProcessor.InputProcessor;

public class Robot_World
{
    public static World world;
    public static Robot robot;
    private static Target target;
    private static InputProcessor inputProcessor;
    private static JFrame frame;
    private static JPanel mainPanel;
    private static JPanel textPanel;
    private static JButton[] buttons;
    private static JLabel Status;

    public static void main(String[] args)
    {
        // create frame
        frame = new JFrame("Robot World");
        frame.setSize(800,800);
        frame.setTitle("Robot World");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Status = new JLabel();
        // create object of class
        world = new World();
        robot = new Robot(1,1,1);
        target = new Target(9,7);
        inputProcessor = new InputProcessor();

        // use grid in panel for divide blocks
        mainPanel = new JPanel();
        textPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(world.getMaxRow(), world.getMaxColumn(),2,2));
        mainPanel.setBackground(Color.BLACK);
        frame.add(mainPanel);


        // use button instead of each block
        int amountOfBtn = world.getMaxRow() * world.getMaxColumn();
        buttons = new JButton[amountOfBtn];

        for (int i=0; i<amountOfBtn; i++)
        {
            buttons[i] = new JButton();
            if (world.isBlackBlock( i/world.getMaxRow(), i%world.getMaxColumn() ) == true)
            {
                buttons[i].setBackground(Color.BLACK);
            }
            else
            {
                buttons[i].setBackground(Color.WHITE);
            }
            buttons[i].setOpaque(true);
            buttons[i].setBorder(null);
            mainPanel.add(buttons[i]);
        }

        // when pressed key
        frame.addKeyListener(new KeyListener()
        {
            public void keyTyped(KeyEvent e) {            
            }
        
            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e)
            {
                if(robot.getRow() == target.getRow() && robot.getColumn() == target.getColumn())
                {
                    frame.add(textPanel);
                    JLabel jlabel = new JLabel("You are the Winner");
                    jlabel.setFont(new Font("Verdana",1,60));
                    textPanel.add(jlabel);
                }
                buttons[robot.getRow() * world.getMaxRow() + robot.getColumn()].remove(0);
                buttons[robot.getRow() * world.getMaxRow() + robot.getColumn()].revalidate();
                buttons[robot.getRow() * world.getMaxRow() + robot.getColumn()].repaint();

                inputProcessor.control(e.getKeyCode());
                buttons[robot.getRow() * world.getMaxRow() + robot.getColumn()].add(new DrawPolygon(robot.getXpoints(), robot.getYpoints(), 3));
            }
        });

        // display the robot

        buttons[robot.getRow() * world.getMaxRow() + robot.getColumn()].add(new DrawPolygon(robot.getXpoints(), robot.getYpoints(), 3));
        
        // display the target
        buttons[target.getRow() * world.getMaxRow() + target.getColumn()].add(new DrawPolygon(target.getXpoints(), target.getYpoints(), 8));
        
        frame.setFocusable(true);
        frame.setFocusTraversalKeysEnabled(false);
        frame.setVisible(true);
    }
}

class DrawPolygon extends JComponent 
{
    int[] xpoint, ypoint;
    int npoint;
    public static Robot robot = new Robot(1,1,1);
    private static Target target = new Target(9,7);

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