package Employee_Initial.DatabaseUse;

import Employee_Initial.CommonFiles.Employee;

import java.util.ArrayList;

public interface EmployeeDatabaseInterface
{
    public ArrayList<Employee> displayEmployeesDB() throws Exception;
    public Employee displaybyIDfromDB(int empid) throws Exception;
    public void insertEmployeeDb(Employee emp) throws Exception;
    public void deleteEmployeefromDB(int empid) throws Exception;
}
