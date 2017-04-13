import java.io.*;

/**
 * Created by Davorin on 4/12/2017.
 */
public class FileWrite {
    private FileOutputStream fileOutputStream;
    private ObjectOutputStream objectOutputStream;
    private Record r1 = new Record (48384, "Jones", "Bob", 1000);
    private FileInputStream fileInputStream;
    private ObjectInputStream objectInputStream;
    private Record record;

    public FileWrite () {
        try {
            fileOutputStream = new FileOutputStream("myFile.ser", false);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
        }
        catch (IOException ioe) {
        }

        try {
            objectOutputStream.writeObject(r1);
        }
        catch (IOException ioe){
        }

        try {
            fileOutputStream.close();
        }
        catch (IOException ioe){
        }

        try {
            fileInputStream = new FileInputStream("myfile.ser");
            objectInputStream = new ObjectInputStream(fileInputStream);
        }
        catch (IOException ioe) {
        }

        try {
            while (true) {
                record = (Record)objectInputStream.readObject();
                System.out.printf("%-10d%-10s%-10s%10.2f\n", record.accountNumber, record.lastName, record.firstName, record.balance);
            }
        }
        catch (IOException ioe){
        }
        catch (ClassNotFoundException cnfe){
        }
        try {
            fileInputStream.close();
        }
        catch (IOException ioe){
        }

    }
    public static void main (String [] args) {
        FileWrite f = new FileWrite();
    }

}
