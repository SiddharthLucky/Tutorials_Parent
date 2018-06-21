package Employee_Initial;

public interface MasterInterface
{
    public Object displayEmployeesDB() throws Exception;
    public Object displaybyIDfromDB(int empid) throws Exception;
    public void insertEmployeeDb(int empid) throws Exception;
    public void deleteEmployeefromDB(int empid) throws Exception;
}
