package robot;
import world.World;

public class Robot
{
    private int direction; // 0:headup 1:headright 2:headdown 3:headleft
    private int row, column;
    private int headPosX, headPosY;
    private int leftPosX, leftPosY;
    private int rightPosX, rightPosY;
    private int[] xpoint = new int[3]; 
    private int[] ypoint = new int[3]; 
    private World world = new World();

    public Robot()
    {
        row = 0;
        column = 0;
        direction = 0;
        this.headUp();
        this.updatePoints();
    }

    public Robot(int px, int py, int di) 
    {
        row = px;
        column = py;
        direction = di;
    }

    public int[] getXpoints()
    {
        return xpoint;
    }

    public int[] getYpoints()
    {
        return ypoint;
    }

    public void updatePoints()
    {
        xpoint[0] = headPosX;
        xpoint[1] = leftPosX;
        xpoint[2] = rightPosX;
        ypoint[0] = headPosY;
        ypoint[1] = leftPosY;
        ypoint[2] = rightPosY;  
    }

    public void headUp() 
    {
        headPosX = (800/world.getMaxRow() * row) + (800/world.getMaxRow()/2);
        headPosY = (800/world.getMaxColumn() * column);
        leftPosX = (800/world.getMaxRow() * row);
        leftPosY = (800/world.getMaxColumn() * (column +1));
        rightPosX = (800/world.getMaxRow()) * (row +1); 
        rightPosY = (800/world.getMaxColumn() * (column +1));
    }
}