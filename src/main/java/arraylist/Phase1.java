package arraylist;

/**
 * Created by Adam on 10/07/2017.
 */
/**
 * Lab 2. Phase 1. Adam Manley Kelly - R00113196
 */
import java.util.Scanner;
public class Phase1
{
    static Scanner kb = new Scanner(System.in);

    public static void main(String[] args)
    {
        //number of students
        final int NUM = 5;
        String[] firstName= new String[NUM];
        String[] lastName = new String[NUM];
        int [] mark = new int [NUM];
        StudentDetails(firstName, lastName, mark);
        DisplayDetails(firstName, lastName, mark);
    }

    private static void StudentDetails(String[] firstName,String[] lastName, int[]mark)
    {
        for(int index = 0; index < mark.length; index++)
        {
            fName("Enter the First name of student " +(index +1)+": ",firstName, index);
            lName("Enter the Last name of student " +(index +1)+": ", lastName, index);
            marks("Enter the Students Mark: ",mark, index);
        }
    }

    private static void DisplayDetails (String[] firstName,String[] lastName, int[] mark)
    {
        String grade = "";
        for(int index = 0; index < mark.length; index++)
        {
            if(mark[index]>100 || mark[index]<0)
            {
                grade = "INVALID MARK";
            }else if (mark[index] >=85 )
            {
                grade = "Distinction";
            }
            else if (mark[index] >=65 ){grade = "Merit";}
            else if (mark[index] >=40 ){grade = "Pass";}
            else if (mark[index] >=0){grade = "Fail";}
            System.out.println(firstName[index]+" " + lastName[index] + " recieved a " + grade +" for his mark of " + mark[index]);
        }
    }

    public static String[] fName (String prompt, String[] firstName, int index)
    {
        firstName[index] = readString(prompt);
        return firstName;
    }

    public static String [] lName (String prompt, String [] lastName, int index)
    {
        lastName[index] = readString(prompt);
        return lastName;
    }

    public static int [] marks (String prompt, int [] mark, int index)
    {
        mark[index] = readIntegerGT(prompt, 0, 100);
        return mark;
    }

    //Validation and Input
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

