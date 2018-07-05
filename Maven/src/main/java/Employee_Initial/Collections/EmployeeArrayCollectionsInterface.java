package Employee_Initial.Collections;

import Employee_Initial.CommonFiles.Employee;

import java.util.ArrayList;

public interface EmployeeArrayCollectionsInterface
{
	public void readFromFile() throws Exception;
	public void saveToFile();
	public ArrayList<Employee> dispEmployee();
	public void addEmployee(Employee emp);
	public void updateEmployee(int empid, Employee emp);
	public void deleteEmployee(int empid);
	public Employee dispEmployeeID(int empID);
	public ArrayList<Employee> getEmpArrList();
	public void setEmpArrList(ArrayList<Employee> empArrList);
}
