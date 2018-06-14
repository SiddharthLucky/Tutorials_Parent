package Employee_Initial;

public interface EmployeeServicesInterface{
	public void addEmployee();
	public void deleteEmployee(int empid);
	public void updateEmployee(int empid);
	public Employee dispEmployeeID(int empid);
	public Employee[] dispEmployee();
	public float getHRAbyID(int empid);
	public float grossSalaryByID(int empid);
}
