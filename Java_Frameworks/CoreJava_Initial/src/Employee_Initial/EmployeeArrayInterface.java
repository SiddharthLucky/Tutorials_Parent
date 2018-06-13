package Employee_Initial;

public interface EmployeeArrayInterface 
{
	public void addEmp(Employee emp);
	public void updateEmp(int empid, Employee emp);
	public void deleteEmployee(int empid);
	public Employee dispEmpID(int empID);
	public Employee[] dispEmp();
}
