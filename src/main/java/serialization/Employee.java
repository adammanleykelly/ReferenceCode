package serialization;

/**
 * Created by Adam on 10/07/2017.
 */
public class Employee implements java.io.Serializable
{
    public String name;
    public String address;
    public transient int SSN;
    //public int SNN;
    public int number;

    public void mailCheck()
    {
        System.out.println("Mailing a check to " + name + " " + address);
    }
}