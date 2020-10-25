package robotWorld;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import world.World;
import robot.Robot;
import target.Target;
import inputProcessor.InputProcessor;
import flowchart.Flowchart;

public class Robot_World
{
    public static World world;
    public static Robot robot;
    private static Target target;
    private static InputProcessor inputProcessor;
    private static Flowchart flowchart;
    private static JFrame frame;
    private static JPanel mainPanel;
    private static JPanel textPanel;
    private static JButton[] buttons;

    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset , Sikarin Kaewjutaniti
    //
    // Description: draw all elements in frame and add keyListener for update position
    // 
    /////////////////////////////////////////////////////
    public static void main(String[] args)
    {
        // create frame
        frame = new JFrame("Robot World");
        frame.setSize(800,800);
        frame.setTitle("Robot World");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create object of class
        world = new World();
        robot = new Robot(1,1,1);
        target = new Target(9,7);
        inputProcessor = new InputProcessor();
        flowchart = new Flowchart();

        // add command in flowchart
        flowchart.add("move()");
        flowchart.ifStatement("isBlocked()", "turnLeft()", "turnRight()");
        flowchart.add("move()");
        flowchart.render();

        // do all command in flowchart
        world.getFlow(flowchart);

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

/////////////////////////////////////////////////////
//
// Programmer: Supansa Tantulset
//
// Description: for draw and paint polygon shape
// 
/////////////////////////////////////////////////////
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