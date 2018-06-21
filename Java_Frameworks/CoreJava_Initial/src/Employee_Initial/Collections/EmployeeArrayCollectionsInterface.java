package Employee_Initial.Collections;

import Employee_Initial.Employee;

import java.util.ArrayList;

public interface EmployeeArrayCollectionsInterface
{
	public void readFromFile() throws Exception;
	public void saveToFile();
	public ArrayList<Employee> dispEmp();
	public void addEmp(Employee emp);
	public void updateEmp(int empid, Employee emp);
	public void deleteEmployee(int empid);
	public Employee dispEmpID(int empID);
	public ArrayList<Employee> getEmpArrList();
	public void setEmpArrList(ArrayList<Employee> empArrList);
}
