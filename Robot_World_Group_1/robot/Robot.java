package robot;

import robotWorld.Robot_World;

public class Robot extends Robot_World
{
    private int direction; // 0:headup 1:headright 2:headdown 3:headleft
    private int row, column;
    private int headPosX, headPosY;
    private int leftPosX, leftPosY;
    private int rightPosX, rightPosY;
    private int[] xpoint = new int[3]; 
    private int[] ypoint = new int[3]; 

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
        this.updatePoints();
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
        if (direction == 0)
        {
            this.headUp();
        }
        else if (direction == 1)
        {
            this.headRight();
        }
        else if (direction == 2)
        {
            this.headDown();
        }
        else if (direction == 3)
        {
            this.headLeft();
        }
        
        xpoint[0] = headPosX;
        xpoint[1] = leftPosX;
        xpoint[2] = rightPosX;
        ypoint[0] = headPosY;
        ypoint[1] = leftPosY;
        ypoint[2] = rightPosY;  
    }

    public void headUp() 
    {
        headPosX = (800/world.getMaxRow()/2);
        headPosY = 0;
        leftPosX = 0;
        leftPosY = (800/world.getMaxColumn());
        rightPosX = (800/world.getMaxRow()); 
        rightPosY = (800/world.getMaxColumn());
    }

    public void headDown() 
    {
        headPosX = (800/world.getMaxRow()/2);
        headPosY = (800/world.getMaxColumn());
        leftPosX = 0;
        leftPosY = 0;
        rightPosX = (800/world.getMaxRow()); 
        rightPosY = 0;
    }

    public void headLeft() 
    {
        headPosX = 0;
        headPosY = (800/world.getMaxColumn()/2);
        leftPosX = (800/world.getMaxRow());
        leftPosY = (800/world.getMaxColumn());
        rightPosX = (800/world.getMaxRow()); 
        rightPosY = 0;
    }

    public void headRight() 
    {
        headPosX = (800/world.getMaxRow());
        headPosY = (800/world.getMaxColumn()/2);
        leftPosX = 0;
        leftPosY = 0;
        rightPosX = 0; 
        rightPosY = (800/world.getMaxColumn());
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
            this.row -= 1;
        }
        else if (direction == 1 && !this.isAtRightEdge()) 
        {
            this.column += 1;
        }
        else if (direction == 2 && !this.isAtBottomEdge()) 
        {
            this.row += 1;
        }
        else if (direction == 3 && !this.isAtLeftEdge()) 
        {
            this.column -= 1;
        }
    }

    public int getRow() 
    {
        return row;
    }

    public int getColumn() 
    {
        return column;
    }

    public boolean isAtTopEdge() 
    {
        return row <= 0;
    }

    public boolean isAtBottomEdge() 
    {
        return row >= world.getMaxColumn()-1;
    }

    public boolean isAtLeftEdge() 
    {
        return column <= 0;
    }

    public boolean isAtRightEdge() 
    {
        return column >= world.getMaxRow()-1;
    }
    
}