package Question2;

import java.util.*;

public class DepartmentApp
{
    public static void main(String[] args)
    {
        Department d1 = new Department(3, "Sid",1.5);
        Department d2 = new Department(1, "Sid2",1.2);
        Department d3 = new Department(2, "Sid3",1.6);
        Department d4 = new Department(5, "Sid4",1.1);


        Department.deptArray.add(d1);
        Department.deptArray.add(d2);
        Department.deptArray.add(d3);
        Department.deptArray.add(d4);

        ArrayList<Department> tempArr = Department.deptArray;

        int temp;
        System.out.println("Select Method to sort: ");
        Scanner uoption = new Scanner(System.in);
        temp = uoption.nextInt();

        switch (temp)
        {
            case 1:
                Collections.sort(tempArr);
                for(Department d : tempArr)
                System.out.println(d.getDeptNo());
                break;

            case 2:

                break;

            default:
                System.out.println("Invalid values");
        }
    }
}
