package arraylist;

/**
 * Created by Adam on 10/07/2017.
 */
/**
 *  Lab 2. Phase 2. Adam Manley Kelly - R00113196
 */
public class Student
{
    private String firstName, lastName, grade;
    private int mark;


    public Student(){}
    public Student(String firstName, String lastName, int mark)
    {
        setfName(firstName);
        setlName(lastName);
        setMark(mark);
        setGrade(mark,grade);
    }

    public void setfName(String F)
    {
        this.firstName = F;
    }

    public void setlName(String L)
    {
        this.lastName= L;
    }

    public void setMark(int M)
    {
        this.mark = M;
    }

    public void setGrade (int mark, String grade)
    {
        for(int index = 0; index < mark; index++)
        {
            if(mark>100 || mark<0)
            {
                this.grade = "INVALID MARK";
            }
            else if (mark >=85 ){this.grade = "Distinction";}
            else if (mark >=65 ){this.grade = "Merit";}
            else if (mark >=40 ){this.grade = "Pass";}
            else if (mark >=0){this.grade = "Fail";}
        }
    }

    public String getfName()
    {
        return firstName;
    }

    public String getlName()
    {
        return lastName;
    }

    public int getMark()
    {
        return mark;
    }

    public String getGrade()
    {
        return grade;
    }

    public String toString ()
    {
        return ""+getfName()+" " + getlName() + " recieved a " + getGrade() +" for his mark of " +getMark();
    }

    public void print ()
    {
        System.out.println(toString());
    }


}
