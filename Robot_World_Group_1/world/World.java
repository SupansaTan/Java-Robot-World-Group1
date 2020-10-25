package world;
import java.io.*;
import java.util.*;

public class World
{
    private static int rowMax;
    private static int columnMax;
    private Scanner reader; // read file
    private static HashMap<String, String> blackBlock = new HashMap<String, String>();

    public World() 
    {
        this.readFile("map.txt");
    }
    
    public World(String fileName) // when want to use another file
    {
        this.readFile(fileName);
    }

    public void display() //Sikarin display int value of maximum row cloumn and black block position for checking
    {
        System.out.println(rowMax);
        System.out.println(columnMax);
        System.out.println(blackBlock);

    }

    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset
    //
    // Description: for readfile .txt
    // 
    /////////////////////////////////////////////////////
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

    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset
    //
    // Description: for get max row
    // 
    /////////////////////////////////////////////////////
    public int getMaxRow()
    {
        return rowMax;
    }

    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset
    //
    // Description: for get max column
    // 
    /////////////////////////////////////////////////////
    public int getMaxColumn()
    {
        return columnMax;
    }

    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset
    //
    // Description: for check that position is black block
    // 
    /////////////////////////////////////////////////////
    public boolean isBlackBlock(int row, int column)
    {
        if (blackBlock.get(row +","+ column) == "BLACK")
        {
            return true;
        }
        return false;
    }

    public int getNumBlack()
    {
        return blackBlock.size();
    }
    
    public void writeFile(){ //Sikarin write the current value of map and target also max row and column
        try {

            FileWriter myWriter = new FileWriter("Maps.txt");
            myWriter.write("Rows=" + Integer.toString(rowMax)+"\n");
            myWriter.write("Columns="+ Integer.toString(columnMax)+"\n");
            myWriter.write("Black Position:\n");


            for (String key : blackBlock.keySet() ) {
                myWriter.write("("+key+")\n");
            }
            myWriter.write("END");


            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}