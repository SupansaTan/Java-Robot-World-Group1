package robot;

import robotWorld.Robot_World;
import target.Target;

public class Robot extends Robot_World
{
    private static Target target = new Target(9,7);
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

    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset
    //
    // Description: for get position x all points
    // 
    /////////////////////////////////////////////////////
    public int[] getXpoints()
    {
        return xpoint;
    }

    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset
    //
    // Description: for get position y all points
    // 
    /////////////////////////////////////////////////////
    public int[] getYpoints()
    {
        return ypoint;
    }

    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset
    //
    // Description: update all points after robot is moved
    // 
    /////////////////////////////////////////////////////
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

    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset
    //
    // Description: for update position when head of robot is up
    // 
    /////////////////////////////////////////////////////
    public void headUp() 
    {
        headPosX = (800/world.getMaxRow()/2);
        headPosY = 0;
        leftPosX = 0;
        leftPosY = (800/world.getMaxColumn());
        rightPosX = (800/world.getMaxRow()); 
        rightPosY = (800/world.getMaxColumn());
    }

    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset , Sikarin Kaewjutaniti
    //
    // Description: for update position when head of robot is down
    // 
    /////////////////////////////////////////////////////
    public void headDown() 
    {
        headPosX = (800/world.getMaxRow()/2);
        headPosY = (800/world.getMaxColumn());
        leftPosX = 0;
        leftPosY = 0;
        rightPosX = (800/world.getMaxRow()); 
        rightPosY = 0;
    }

    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset , Sikarin Kaewjutaniti
    //
    // Description: for update position when head of robot is left
    // 
    /////////////////////////////////////////////////////
    public void headLeft() 
    {
        headPosX = 0;
        headPosY = (800/world.getMaxColumn()/2);
        leftPosX = (800/world.getMaxRow());
        leftPosY = (800/world.getMaxColumn());
        rightPosX = (800/world.getMaxRow()); 
        rightPosY = 0;
    }

    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset , Sikarin Kaewjutaniti
    //
    // Description: for update position when head of robot is right
    // 
    /////////////////////////////////////////////////////
    public void headRight() 
    {
        headPosX = (800/world.getMaxRow());
        headPosY = (800/world.getMaxColumn()/2);
        leftPosX = 0;
        leftPosY = 0;
        rightPosX = 0; 
        rightPosY = (800/world.getMaxColumn());
    }

    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset
    //
    // Description: for update direction when robot is turn left
    // 
    /////////////////////////////////////////////////////
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

    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset
    //
    // Description: for update direction when robot is turn right
    // 
    /////////////////////////////////////////////////////
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

    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset, Sikarin Kaewjutaniti
    //
    // Description: for update position when robot is moved
    // 
    /////////////////////////////////////////////////////
    public void move() 
    {
        if (target.getRow()== row && target.getColumn() == column){

        }
        else if (direction == 0 && !this.isAtTopEdge())
        {
            if(world.isBlackBlock( row-1, column )== false) {
                this.row -= 1;
            }
        }
        else if (direction == 1 && !this.isAtRightEdge())
        {
            if(world.isBlackBlock( row, column+1 )== false)
            {
                this.column += 1;
            }
        }
        else if (direction == 2 && !this.isAtBottomEdge()) 
        {
            if(world.isBlackBlock( row+1, column )== false) {
                this.row += 1;
            }
        }
        else if (direction == 3 && !this.isAtLeftEdge()) 
        {
            if(world.isBlackBlock( row, column-1 )== false) {
                this.column -= 1;
            }
        }
    }

    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset
    //
    // Description: for get row
    // 
    /////////////////////////////////////////////////////
    public int getRow()
    {
        return row;
    }

    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset
    //
    // Description: for get column
    // 
    /////////////////////////////////////////////////////
    public int getColumn() 
    {
        return column;
    }

    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset
    //
    // Description: for check robot is at top edge
    // 
    /////////////////////////////////////////////////////
    public boolean isAtTopEdge() 
    {
        return row <= 0;
    }

    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset
    //
    // Description: for check robot is at bottom edge
    // 
    /////////////////////////////////////////////////////
    public boolean isAtBottomEdge() 
    {
        return row >= world.getMaxColumn()-1;
    }

    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset
    //
    // Description: for check robot is at left edge
    // 
    /////////////////////////////////////////////////////
    public boolean isAtLeftEdge() 
    {
        return column <= 0;
    }

    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset
    //
    // Description: for check robot is at right edge
    // 
    /////////////////////////////////////////////////////
    public boolean isAtRightEdge() 
    {
        return column >= world.getMaxRow()-1;
    }
    
    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset
    //
    // Description: check font of the robot is can walk or not?
    // 
    /////////////////////////////////////////////////////
    public boolean isBlocked()
    {
        if(direction == 0 && (column <= 0 || world.isBlackBlock(row, column-1)))
        {
            return true;
        }
        else if (direction == 1 && (column >= world.getMaxColumn()-1 || world.isBlackBlock(row+1, column)))
        {
            return true;
        }
        else if (direction == 2 && (row <= 0 || world.isBlackBlock(row, column+1)))
        {
            return true;
        }
        else if (direction == 3 && (row >= world.getMaxRow()-1 || world.isBlackBlock(row-1, column)))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}