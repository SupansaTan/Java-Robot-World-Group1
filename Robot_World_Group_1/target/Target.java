package target;

public class Target
{
    private int row, column;
    private int[] xpoint = new int[8];
    private int[] ypoint = new int[8];

    public Target(int x, int y) 
    {
        row = x;
        column = y;
        this.addPoints();
    }

    public boolean met(int X, int Y) 
    {
        if (X == row && Y == column) 
        {
            return true;
        }
        else 
        {
            return false;
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
    // Description: for add each point in array of xpoint and ypoint
    // 
    /////////////////////////////////////////////////////
    public void addPoints()
    {
        for (int i=0; i<8; i++){
            xpoint[i] = 37 + (int) (35 * Math.cos(Math.toRadians(45*i)));
            ypoint[i] = 37 + (int) (35 * Math.sin(Math.toRadians(45*i)));
        }
    }
}
