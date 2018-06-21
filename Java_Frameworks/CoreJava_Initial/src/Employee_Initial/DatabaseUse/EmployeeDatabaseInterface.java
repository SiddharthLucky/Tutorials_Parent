package Employee_Initial.DatabaseUse;

import Employee_Initial.CommonFiles.Employee;
import Employee_Initial.MasterInterface;

import java.util.ArrayList;

public interface EmployeeDatabaseInterface extends MasterInterface
{
    public ArrayList<Employee> displayEmployeesDB() throws Exception;
    public Employee displaybyIDfromDB(int empid) throws Exception;
    public void insertEmployeeDb(int empid) throws Exception;
    public void deleteEmployeefromDB(int empid) throws Exception;
    public ArrayList<Employee> sortDataDB(String column);
}
