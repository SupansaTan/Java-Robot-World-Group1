// ReadFile.java


import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFiles
{
    public String[] readLines(String filename) throws IOException
    {
        FileReader fileReader = new FileReader(filename);

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList();
        String line;

        while ((line = bufferedReader.readLine()) != null)
        {
            lines.add(line);
        }

        bufferedReader.close();

        return lines.toArray(new String[lines.size()]);
    }
}