
import javax.swing.*;

public class Robot_World {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Robot World");
        frame.setVisible(true);
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        World object = new World();
        frame.add(object);

        object.drawDisplay();

    }
}
