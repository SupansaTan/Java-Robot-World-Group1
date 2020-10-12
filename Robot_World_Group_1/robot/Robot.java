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
        
        // for test draw robot
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
        leftPosY = (800/world.getMaxColumn() * (column + 1));
        rightPosX = (800/world.getMaxRow() * (row + 1)); 
        rightPosY = (800/world.getMaxColumn() * (column + 1));
    }

    public void headDown() 
    {
        headPosX = (800/world.getMaxRow() * row) + (800/world.getMaxRow()/2);
        headPosY = (800/world.getMaxColumn() * (column + 1));
        leftPosX = (800/world.getMaxRow() * row);
        leftPosY = (800/world.getMaxColumn() * column);
        rightPosX = (800/world.getMaxRow() * (row + 1)); 
        rightPosY = (800/world.getMaxColumn() * column);

    }

    public void headLeft() 
    {
        headPosX = (800/world.getMaxRow() * (row + 1));
        headPosY = (800/world.getMaxColumn() * (column + 1));
        leftPosX = (800/world.getMaxRow() * row);
        leftPosY = (800/world.getMaxColumn() * column) + (800/world.getMaxRow()/2);
        rightPosX = (800/world.getMaxRow() * (row + 1)); 
        rightPosY = (800/world.getMaxColumn() * (column + 1));

    }

    public void headRight() 
    {
        headPosX = (800/world.getMaxRow() * row);
        headPosY = (800/world.getMaxColumn() * column);
        leftPosX = (800/world.getMaxRow() * (row + 1));
        leftPosY = (800/world.getMaxColumn() * column) + (800/world.getMaxRow()/2);
        rightPosX = (800/world.getMaxRow() * row); 
        rightPosY = (800/world.getMaxColumn() * (column +1));
        
    }

    public void turnLeft() 
    {
        if (direction == 0) 
        {
            direction = 3;
        }
        else 
        {
            direction -= 1;
        }
    }

    public void turnRight() 
    {
        if (direction == 3) 
        {
            direction = 0;
        }
        else 
        {
            direction += 1;
        }
    }

    public void move() 
    {
        if (direction == 0 && !this.isAtTopEdge()) 
        {
            row -= 1;
        }
        else if (direction == 1 && !this.isAtRightEdge()) 
        {
            row += 1;
        }
        else if (direction == 2 && !this.isAtBottomEdge()) 
        {
            column += 1;
        }
        else if (direction == 3 && !this.isAtLeftEdge()) 
        {
            column -= 1;
        }
    }

    public int getRow() 
    {
        return(row);
    }

    public int getColumn() 
    {
        return(column);
    }

    public boolean isAtTopEdge() 
    {
        return column <= 0;
    }

    public boolean isAtBottomEdge() 
    {
        return column >= -1;
    }

    public boolean isAtLeftEdge() 
    {
        return row <= 0;
    }

    public boolean isAtRightEdge() 
    {
        return row >= -1;
    }
    
}