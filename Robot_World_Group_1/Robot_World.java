import javax.swing.*;

import jdk.javadoc.internal.doclets.formats.html.resources.standard;

import java.awt.*;
import world.World;
import robot.Robot;

public class Robot_World {
   static World world;
   static JFrame frame;
   static JPanel mainPanel;
   static JButton[] buttons; 

    public static void main(String[] args)
    {
        // create frame
        frame = new JFrame("Robot World");
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create object of class World
        world = new World();

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
            if (world.isBlackBlock(i / world.getMaxRow(), i % world.getMaxColumn()))
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

        frame.setVisible(true);
    }
}
