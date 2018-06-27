package Employee_Initial.Arrays;

import Employee_Initial.CommonFiles.Employee;
import Employee_Initial.CommonFiles.customExceptions;

import java.util.List;

public interface EmployeeServicesInterface
{
	default public void addEmployee() throws customExceptions {	}
	default public void deleteEmployee(int empid) {	};//throws customExceptions;
	default public void updateEmployee(int empid)throws customExceptions  {	};
	default public Employee dispEmployeeID(int empid) {	Employee emp = null; return emp;};//throws customExceptions;throws customExceptions;
	default public Employee[] dispEmployee() { Employee[] emp = new Employee[0]; return emp;};//throws customExceptions;throws customExceptions;
	default public float getHRAbyID(int empid) {float val = 0; return val;};//throws customExceptions;throws customExceptions;
	default public float grossSalaryByID(int empid) {float val = 0; return val;};//throws customExceptions;throws customExceptions;
	default public void saveToFile(){};

	//Methods for using collections
	default public void addEmployeeCollections() throws customExceptions{};
	default public void deleteEmployeeCollections(int empid){};//throws customExceptions;
	default public void updateEmployeeCollections(int empid)throws customExceptions{};
	default public Employee dispEmployeeIDCollections(int empid){Employee emp = null; return emp;};//throws customExceptions;throws customExceptions;
	default public List<Employee> dispEmployeeCollections(){List<Employee> tempList = null; return tempList;};//throws customExceptions;throws customExceptions;
	default public float getHRAbyIDCollections(int empid){float val = 0; return val;};//throws customExceptions;throws customExceptions;
	default public float grossSalaryByIDCollections(int empid){float val = 0; return val;};//throws customExceptions;throws customExceptions;
	default public void saveToFileCollections(){};

	//Methods for using DB methods
	default public List<Employee> displayEmployeesDB(){List<Employee> tempList = null; return tempList;}
	default public Employee displaybyIDfromDB(int empid){Employee emp = null; return emp;}
	default public void insertEmployeeDb(){}
	default public void updateEmployeeDb(int empid){};
	default public void deleteEmployeeDB(int empid){}
	default public List<Employee> sortEmployeesDB(String column){List<Employee> tempList = null; return tempList;}
}
