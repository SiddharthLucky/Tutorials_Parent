package Employee_Initial.CommonFiles;

import java.util.ArrayList;

public interface EmployeeServicesInterface{
	public void addEmployee() throws customExceptions;
	public void deleteEmployee(int empid);//throws customExceptions;
	public void updateEmployee(int empid)throws customExceptions;
	public Employee dispEmployeeID(int empid);//throws customExceptions;throws customExceptions;
	public Employee[] dispEmployee();//throws customExceptions;throws customExceptions;
	public float getHRAbyID(int empid);//throws customExceptions;throws customExceptions;
	public float grossSalaryByID(int empid);//throws customExceptions;throws customExceptions;
	public void saveToFile();

	//Methods for using collections
	public void addEmployeeCollections() throws customExceptions;
	public void deleteEmployeeCollections(int empid);//throws customExceptions;
	public void updateEmployeeCollections(int empid)throws customExceptions;
	public Employee dispEmployeeIDCollections(int empid);//throws customExceptions;throws customExceptions;
	public ArrayList<Employee> dispEmployeeCollections();//throws customExceptions;throws customExceptions;
	public float getHRAbyIDCollections(int empid);//throws customExceptions;throws customExceptions;
	public float grossSalaryByIDCollections(int empid);//throws customExceptions;throws customExceptions;
	public void saveToFileCollections();
}
