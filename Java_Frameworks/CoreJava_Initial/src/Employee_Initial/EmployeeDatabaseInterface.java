package Employee_Initial;

import java.util.ArrayList;

public interface EmployeeDatabaseInterface
{
    public ArrayList<Employee> displayEmployeesDB() throws Exception;
    public Employee displaybyIDfromDB(int empid) throws Exception;
    public void insertEmployeeDb(Employee emp) throws Exception;
    public void deleteEmployeefromDB(int empid) throws Exception;
}
