package Question2;

import java.util.ArrayList;
import java.util.Comparator;

public class Department implements Comparable<Department>, Comparator<Department>
{
    private int deptNo;
    private String deptName;
    private double location;
    public static ArrayList<Department> deptArray = new ArrayList<>();

    public Department(int deptno, String deptName, double location)
    {
        setDeptName(deptName);
        setDeptNo(deptno);
        setLocation(location);
    }

    public int getDeptNo()
    {
        return deptNo;
    }

    public void setDeptNo(int deptNo)
    {
        this.deptNo = deptNo;
    }

    public String getDeptName()
    {
        return deptName;
    }

    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }

    public double getLocation()
    {
        return location;
    }

    public void setLocation(double location)
    {
        this.location = location;
    }

    @Override
    public int compareTo(Department deptobj)
    {
        final int UNEQAL = -1;
        final int EQUAL = 0;

        if(this.getDeptNo() > deptobj.getDeptNo())
        {
            return EQUAL;
        }
        else
            return UNEQAL;
    }

    @Override
    public int compare(Department o1, Department o2)
    {
        final int UNEQAL = -1;
        final int EQUAL = 0;

        if(o1.getDeptName().equals(o2.getDeptName()))
        {
            return EQUAL;
        }
        else
            return UNEQAL;
    }
}
