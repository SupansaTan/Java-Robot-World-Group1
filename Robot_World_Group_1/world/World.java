package world;
import java.io.*;
import java.util.*;

public class World
{
    private int rowMax;
    private int columnMax;
    private Scanner reader; // read file
    private HashMap<String, String> blackBlock = new HashMap<String, String>();
    private int[] robotPos;
    private int[] targetPos;

    public World() 
    {
        this.readFile("map.txt");
    }

    public World(String fileName) // when want to use another file
    {
        this.readFile(fileName);
    }

    public void display() 
    {
        System.out.println(rowMax);
        System.out.println(columnMax);
        System.out.println(blackBlock);

    }

    public void readFile(String fileName) 
    {
        File file = new File(fileName);

        try 
        {
            reader = new Scanner(file); // start read file

            while (reader.hasNextLine())
            {
                String nextLine = reader.nextLine();
                
                if (nextLine.length() > 3 && nextLine.substring(0,4).equalsIgnoreCase("Rows"))
                {
                    // set value of max rows
                    rowMax = Integer.parseInt(nextLine.split("=")[1]);
                }
                else if (nextLine.length() > 7 && nextLine.substring(0,7).equalsIgnoreCase("Columns"))
                {
                    // set value of max columns
                    columnMax = Integer.parseInt(nextLine.split("=")[1]);
                }
                else if (nextLine.equalsIgnoreCase("Black Position:"))
                {
                    // show that next all lines is position of black blocks 
                    nextLine = reader.nextLine();
                    blackBlock.put(nextLine.substring(1, nextLine.length()-1), "BLACK");
                }
                else if (nextLine.equalsIgnoreCase("END"))
                {
                    // end read
                    break;
                }
                else
                {
                    // position of black blocks 
                    blackBlock.put(nextLine.substring(1, nextLine.length()-1), "BLACK");
                }
            }
            reader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found.");
        }
    }

    public int getMaxRow()
    {
        return rowMax;
    }

    public int getMaxColumn()
    {
        return columnMax;
    }

    public boolean isBlackBlock(int row, int column)
    {
        if (blackBlock.get(row +","+ column) == "BLACK")
        {
            return true;
        }
        return false;
    }

    /*
    public void paintComponent(Graphics G) {

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
    */
}