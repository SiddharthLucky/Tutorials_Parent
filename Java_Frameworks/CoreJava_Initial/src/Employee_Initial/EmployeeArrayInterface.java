package Employee_Initial;

public interface EmployeeArrayInterface 
{
	public Employee[] getEmpArr();
	public void setEmpArr(Employee[] emp);
	public void addEmp(Employee emp);
	public void updateEmp(int empid, Employee emp);
	public void deleteEmployee(int empid);
	public Employee dispEmpID(int empID);
	public Employee[] dispEmp();
	public void readFromFile() throws Exception;
	public void saveToFile();
}
