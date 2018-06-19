package Employee_Initial;

import java.io.IOException;

public interface EmployeeServicesInterface{
	public void addEmployee() throws customExceptions;
	public void deleteEmployee(int empid);//throws customExceptions;
	public void updateEmployee(int empid)throws customExceptions;
	public Employee dispEmployeeID(int empid);//throws customExceptions;throws customExceptions;
	public Employee[] dispEmployee();//throws customExceptions;throws customExceptions;
	public float getHRAbyID(int empid);//throws customExceptions;throws customExceptions;
	public float grossSalaryByID(int empid);//throws customExceptions;throws customExceptions;
	public void saveToFile();
}
