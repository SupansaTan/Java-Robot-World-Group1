import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class ReadFiles {
    public static String main(String file_name) {
    File file = new File(file_name);
    return String.valueOf(file);
    }
}