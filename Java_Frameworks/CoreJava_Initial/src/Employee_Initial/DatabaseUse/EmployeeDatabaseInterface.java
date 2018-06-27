package Employee_Initial.DatabaseUse;

import Employee_Initial.CommonFiles.Employee;

import java.util.List;

public interface EmployeeDatabaseInterface
{
    public List<Employee> displayEmployeesDB() throws Exception;
    public Employee displaybyIDfromDB(int empid) throws Exception;
    public void updateEmployeeDb(int empid) throws Exception;
    public void deleteEmployeefromDB(int empid) throws Exception;
    public List<Employee> sortDataDB(String column);
    public void initinsertEmployeeDb(Employee emp) throws Exception;
}
