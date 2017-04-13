import java.io.*;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Davorin on 4/12/2017.
 */
public class Files {
    private FileReader fileReader;
    private FileWriter fileWriter;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String buffer;
    private int lineNumber;

    public Files () {
        try {
            //Read file
            fileReader = new FileReader("Runnin' Down A Dream.txt");
            bufferedReader = new BufferedReader(fileReader);
            lineNumber = 0;
            try {
                //Print the contents of the file
                while((buffer = bufferedReader.readLine()) != null) {
                    System.out.print(buffer + '\n');
                    lineNumber++;
                }
                bufferedReader.close();

                //Write to file
                fileWriter = new FileWriter("writing.txt");
                bufferedWriter = new BufferedWriter(fileWriter);
                for (int k = 0; k < lineNumber; k++) {
                    bufferedWriter.write(String.format("%-8s %3d %2s %n", "Line ",k,":"));
                }
                bufferedWriter.close();
            }
            catch (IOException ex) {
                System.out.println("Error");
            }
        }
        catch(FileNotFoundException fnfe) {
            System.out.println("File not found");
        }
        System.exit(0);
    }

    public static void main(String [] args) {
        Files f = new Files();
    }
}
