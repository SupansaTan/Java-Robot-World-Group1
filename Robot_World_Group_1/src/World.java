
import javax.swing.*;
import java.awt.*;


public class World extends JPanel {

    String Map = "1-1-1-0-1-1-1-0-1-1,1-1-1-0-1-1-1-1-1-1,0-1-1-1-1-1-1-1-1-1,1-1-1-1-1-0-1-1-1-0,1-0-1-1-0-0-1-1-0-0,1-1-0-1-1-1-1-1-1-0,1-1-1-1-0-0-1-1-1-1,1-0-1-1-1-0-1-1-1-1,1-0-0-1-1-1-1-0-0-1,1-0-1-1-0-1-1-1-1-1";
    String[] mapread = Map.split(",");
    int maxX = mapread.length;
    String[] block = mapread[0].split("-");
    int maxY = block.length;
    int X = 800 / maxX;
    int Y = 800 / maxY;
    public void drawDisplay() {
        repaint();

    }

    public void paintComponent(Graphics G) {
        super.paintComponent(G);

        for (int i = 0; i < (maxX); i = i + 1) {
            for (int j = 0; j < (maxY); j = j + 1) {
                String[] block = mapread[j].split("-");
                int mapBlock = Integer.parseInt(block[i]);
                if (mapBlock == 1) {
                    G.setColor(Color.WHITE);
                    G.fillRect(i * X, j * Y, X, Y);
                } else {
                    G.setColor(Color.BLACK);
                    G.fillRect(i * X, j * Y, X, Y);
                }


            }
        }

    }
    public int getMap(int X, int Y) {
        String Map = "1-1-1-0-1-1-1-0-1-1,1-1-1-0-1-1-1-1-1-1,0-1-1-1-1-1-1-1-1-1,1-1-1-1-1-0-1-1-1-0,1-0-1-1-0-0-1-1-0-0,1-1-0-1-1-1-1-1-1-0,1-1-1-1-0-0-1-1-1-1,1-0-1-1-1-0-1-1-1-1,1-0-0-1-1-1-1-0-0-1,1-0-1-1-0-1-1-1-1-1";
        String[] mapread = Map.split(",");
        String[] block = mapread[Y].split("-");
        int mapBlock = Integer.parseInt(block[X]);
        return(mapBlock);
    }

}