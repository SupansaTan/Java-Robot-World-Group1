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

    public int getRow() 
    {
        return row;
    }

    public int getColumn() 
    {
        return column;
    }

    public int[] getXpoints()
    {
        return xpoint;
    }

    public int[] getYpoints()
    {
        return ypoint;
    }

    public void addPoints()
    {
        for (int i=0; i<8; i++){
            xpoint[i] = 37 + (int) (35 * Math.cos(Math.toRadians(45*i)));
            ypoint[i] = 37 + (int) (35 * Math.sin(Math.toRadians(45*i)));
        }
    }
}
