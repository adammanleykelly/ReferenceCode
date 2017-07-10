package arraylist;

/**
 * Created by Adam on 10/07/2017.
 */

/**
 *Lab 2. Phase 2. Adam Manley Kelly - R00113196
 */
import java.util.Scanner;
public class Phase2
{
    static Scanner kb = new Scanner(System.in);
    public static void main(String[] args)
    {
        //Number of students
        int N = 5;
        Student[] students = new Student[N];

        for (int i = 0; i < N; i++)
        {
            String firstName  = readString("Enter the students first name: ");
            String lastName   = readString("Enter the students last name: ");
            int mark   = readIntegerGT("Enter Students Mark: ", 0, 100);
            students[i] = new Student(firstName, lastName, mark);
        }

        for (int i = 0; i < N; i++)
        {
            System.out.println(students[i]);
        }
    }

    //Methods to read in data and validate input
    public static String readString(String prompt)
    {
        System.out.print(prompt);
        return kb.next();
    }

    public static int readIntegerGT(String prompt, int lowerBound, int higherBound)
    {
        int value;
        do
        {
            value = readInteger(prompt);
            if (value < lowerBound&& value > higherBound)
            {
                System.out.println("\nError - you must enter a integer value between " + lowerBound + " and "+higherBound+"!\n");
            }
        } while (value <=lowerBound && value > higherBound);
        return value;
    }

    public static int readInteger(String prompt)
    {
        boolean numGood = false;
        do
        {
            System.out.print(prompt);
            if(!kb.hasNextInt())
            {
                System.out.println("\nYou must enter an integer value!\n");
                kb.nextLine();
            }
            else
                numGood = true;
        } while(!numGood);
        return kb.nextInt();
    }
}
