package arraylist;

/**
 * Created by Adam on 10/07/2017.
 */
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Lab 2. Phase 3. Adam Manley Kelly - R00113196 - Menu
 */
public class Phase3
{
    static Scanner kb = new Scanner(System.in);
    public static void main(String [] args)
    {
        int choice = -1;
        ArrayList<Student> Students = new ArrayList<Student>();
        do
        {
            System.out.println("1. Add a Student");
            System.out.println("2. Remove a Student");
            System.out.println("3. List all Students");

            while (!kb.hasNextInt())
            {
                readIntegerGT("Enter Students Mark: ", 1, 3);
                kb.nextLine();
            }
            choice = kb.nextInt();

            switch (choice)
            {
                case 1:
                    String firstName  = readString("Enter the students first name: ");
                    String lastName   = readString("Enter the students last name: ");
                    int mark  = readIntegerGT("Enter Students Mark: ", 0, 100);
                    Students.add(new Student(firstName, lastName, mark));
                    break;

                case 2:
                    int total = 0;
                    total = Students.size();
                    for (int i = 0; i < total; i++)
                    {
                        System.out.print(i + ". ");
                        System.out.println(Students.get(i));
                    }
                    System.out.println("");
                    int rem = readInteger("Which Student would you like to remove?(Please enter a number)");
                    kb.nextLine();
                    System.out.println("Student has been removed");
                    Students.remove(rem);
                    break;

                case 3:
                    total = Students.size();
                    for (int i = 0; i < total; i++)
                    {
                        System.out.print(i + ". ");
                        System.out.println(Students.get(i));
                    }
                    break;
            }
        } while (choice != 4);
    }

    //Validation and input
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

