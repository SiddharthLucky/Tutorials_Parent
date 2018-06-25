package Employee_Initial.DatabaseUse;

import Employee_Initial.CommonFiles.Employee;
import Employee_Initial.MasterInterface;

import java.util.List;

public interface EmployeeDatabaseInterface extends MasterInterface
{
    public List<Employee> displayEmployeesDB() throws Exception;
    public Employee displaybyIDfromDB(int empid) throws Exception;
    public void insertEmployeeDb(int empid) throws Exception;
    public void deleteEmployeefromDB(int empid) throws Exception;
    public List<Employee> sortDataDB(String column);
}
