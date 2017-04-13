import java.io.Serializable;

/**
 * Created by Davorin on 4/12/2017.
 */
public class Record  implements Serializable {
    public String firstName, lastName;
    public int accountNumber;
    public double balance;

    public Record (int acc, String last, String first, double bal) {
        accountNumber = acc;
        lastName = last;
        firstName = first;
        balance = bal;
    }
}
