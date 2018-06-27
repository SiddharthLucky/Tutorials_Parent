package Employee_Initial.DatabaseUse;

import Employee_Initial.CommonFiles.Employee;
import Employee_Initial.Arrays.EmployeeServicesInterface;
import Employee_Initial.CommonFiles.EmployeeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeServices_Database implements EmployeeServicesInterface
{
    EmployeeDatabaseInterface empDB;

    public EmployeeServices_Database()
    {
        empDB = new EmployeeDatabase();
    }

    //--------------Method inserts all the values into the database-------------
    public void ThreadInsert(ArrayList<Employee> empThread)
    {
        for(Employee emp : empThread)
        {
            try
            {
                empDB.initinsertEmployeeDb(emp);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //-----------Methods to access the Database DAO class------------
    @Override
    public List<Employee> displayEmployeesDB() {
        List<Employee> tempArr = null;
        try {
            tempArr = empDB.displayEmployeesDB();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tempArr;

    }
    @Override
    public Employee displaybyIDfromDB(int empid)
    {
        Employee emp = null;
        try {
            emp = empDB.displaybyIDfromDB(empid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emp;
    }


    @Override
    public void updateEmployeeDb(int empid)
    {
        try {
            empDB.updateEmployeeDb(empid);
            System.out.println("Data Successfully inserted DB");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertEmployeeDb()
    {
        try {
            Employee emp = EmployeeUtil.collectInfo();
            empDB.initinsertEmployeeDb(emp);
            System.out.println("Data Successfully inserted DB");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployeeDB(int empid)
    {
        try {
            empDB.deleteEmployeefromDB(empid);
            System.out.println("Employee Info successfully deleted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> sortEmployeesDB(String column)
    {
        List<Employee> tempArrEmp = empDB.sortDataDB(column);
        Stream<Employee> tempArr= tempArrEmp.stream();

        int sortval = 0;
        if(sortval == 1)
        {
            tempArrEmp = tempArr.sorted((o1, o2) -> Integer.compare(o1.geteSalary(), o2.geteSalary()))
                    .collect(Collectors.toList());
        }
        if(sortval == 2)
        {
            tempArrEmp = tempArr.sorted((o1, o2) -> o1.geteName().compareToIgnoreCase(o2.geteName()))
                    .sorted((o1, o2) -> o1.geteName().compareToIgnoreCase(o2.geteName()))
                    .collect(Collectors.toList());
        }
        if(sortval == 3)
        {
            tempArrEmp = tempArr.sorted((o1,o2) -> Integer.compare(o1.getDno() , o2.getDno()))
                    .collect(Collectors.toList());
        }
        if(sortval == 4)
        {
            tempArrEmp = tempArr.sorted((o1, o2) -> Integer.compare(o1.getEin(), o2.getEin()))
                    .collect(Collectors.toList());
        }
        return tempArrEmp;
    }
}
