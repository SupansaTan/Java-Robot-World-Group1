public class World {
    World world;
    ReadFiles fileR = new ReadFiles();
    int maxX, maxY;

    Robot robot;
    Target target;
    InputProcessor inputProcessor;
    String[] Map;
    int width = 800;
    int height = 800;
    void draw() {
        int X = width/maxX;
        int Y = height/maxY;
        int  colour;
        for (int i =0; i < (maxX ); i = i+1) {
            for (int j = 0; j < (maxY ); j = j+1) {
                if (world.getMap(i, j) == true) {
                    colour = 250;
                }
                else {
                    colour = 0;
                }
                fill(colour);
                rect(i*X, j*Y, X, Y);
            }
        }
    }



    int getMaxX() {
        // return horizontal block counts
        Map = fileR("Map.txt");
        String[] mapread = Map.split(',', 999999);
        maxX = mapread.length;
        return maxX;
    }

    int getMaxY() {
        // return vertical block counts
        Map = loadStrings("Map.txt");
        String[] mapread = Map.split(',', 999999);
        String[] block = mapread[Y].split('-', 999999);
        maxY = block.length;
        return maxY;
    }

    boolean getMap(int X, int Y) {
        Map = fileR.readLines("Map.txt");
        String[] mapread = split(Map[0], ',');
        String[] block = split(mapread[Y], '-');
        return world.boolCon(Integer.valueOf(block[X]));
    }
    boolean boolCon(int intValue)
    {

        // The integer value


        // The expected boolean value
        boolean boolValue;

        // Check if it's greater than equal to 1
        if (intValue >= 1) {
            boolValue = true;
        }
        else {
            boolValue = false;
        }
        return boolValue;
    }

    boolean checkIsWhite(int blockX, int blockY){
        return world.getMap(blockX, blockY);
    }
}

