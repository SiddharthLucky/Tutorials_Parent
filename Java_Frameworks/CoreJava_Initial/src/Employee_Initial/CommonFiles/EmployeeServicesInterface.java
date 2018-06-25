package Employee_Initial.CommonFiles;

import java.util.List;

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
	public List<Employee> dispEmployeeCollections();//throws customExceptions;throws customExceptions;
	public float getHRAbyIDCollections(int empid);//throws customExceptions;throws customExceptions;
	public float grossSalaryByIDCollections(int empid);//throws customExceptions;throws customExceptions;
	public void saveToFileCollections();

	//Methods for using DB methods
	public List<Employee> displayEmployeesDB();
	public Employee displaybyIDfromDB(int empid);
	public void insertEmployeeDb(int empid);
	public void deleteEmployeeDB(int empid);
	public List<Employee> sortEmployeesDB(String column);
}
