package Employee_Initial.DatabaseUse;

import Employee_Initial.Arrays.EmployeeServices;
import Employee_Initial.CommonFiles.Employee;
import Employee_Initial.CommonFiles.EmployeeUtil;

import java.util.ArrayList;

public class EmployeeThreads implements Runnable {

    String filePath = "";
    ArrayList<Employee> tempArr = new ArrayList<>();
    EmployeeServices_Database empSer;
    public EmployeeThreads(String filePath)
    {
        this.filePath = filePath;
        // The files flow is managed by the services class
        empSer = new EmployeeServices_Database();
    }

    @Override
    public void run()
    {
        tempArr = Jobs.readFilebyUser(filePath);
        for(Employee emp : tempArr)
        {
            empSer.ThreadInsert(tempArr);
        }
    }
    public static class Jobs
    {
        static ArrayList<Employee> readFilebyUser(String filePath)
        {
            ArrayList<Employee> tempArr = EmployeeUtil.readfile(filePath);
            return tempArr;
        }
    }
}
