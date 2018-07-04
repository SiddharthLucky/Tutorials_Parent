package Employee_Initial.Arrays;

import Employee_Initial.CommonFiles.Employee;
import Employee_Initial.CommonFiles.EmployeeUtil;
import Employee_Initial.CommonFiles.customExceptions;

//-------------------- This class contains Service methods for Employee Array Packages--------------------

public class EmployeeServices <ES extends EmployeeBaseType> implements EmployeeServicesInterface <ES>{

	EmployeeArrayInterface empArrVal;

	// You are just initializing an object that refers to the methods in the EmployeeArray class

	// The file reading has to be handled by the Services or the Util class, but there is no way
	// that the DAO class handles those operations, it is strictly bound to handle only CRUD operations

	public EmployeeServices()
	{
		empArrVal = new EmployeeArray(EmployeeUtil.getArrSize());
		try {
			empArrVal.readFromFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Method to add an employee
	@Override
	public void addEmployee() throws customExceptions
	{
		ES emp = (ES) EmployeeUtil.collectInfo();
		if(emp == null)
			throw new customExceptions("Adding employee failed");
		empArrVal.addEmp(emp);
	}
	
	//Method to delete an Employee
	@Override
	public void deleteEmployee(int empid)
	{
		empArrVal.deleteEmployee(empid);
	}
	
	//Method to Update an Employee Information
	@Override
	public void updateEmployee(int empid) throws customExceptions
	{
		ES emp;
		emp = (ES) EmployeeUtil.collectInfo_Update(empid);
		if (emp == null)
			throw new customExceptions("Updtaing employee failed");
		empArrVal.updateEmp(empid, emp);
	}

	//Display Employees list by ID
	@Override
	public ES dispEmployeeID(int empid)
	{
		ES emp = (ES) empArrVal.dispEmpID(empid);
		return (ES) emp;
	}
	
	//Display all Employees
	@Override
	public ES[] dispEmployee()
	{
		return (ES[]) empArrVal.dispEmp();
	}
	
	//Get hRA based on empployee id
	@Override
	public float getHRAbyID(int empid) {
		ES[] tempArrHolder = (ES[]) empArrVal.getEmpArr();
		Employee tempObjHolder = null;
		float hra = 0;
		boolean flag = true;
		for (int i = 0; i < tempArrHolder.length; i++) {
			if (tempArrHolder[i] != null) {
				tempObjHolder = (Employee) tempArrHolder[i];
			}
			if (tempObjHolder.getEin() == empid && flag) {
				hra = tempObjHolder.HRA();
				flag = false;
			}

		}
		// You can also choose to directly send the above equation in a return statement.
		return hra;
	}
	
	//Get gross salary based on employee id
	@Override
	public float grossSalaryByID(int empid) {
		ES tempObjHolder = null;
		ES[] tempArrHolder = (ES[]) empArrVal.getEmpArr();
		float grossSalary = 0;
		boolean flag = true;
		for (int i = 0; i < tempArrHolder.length; i++) {
			if (tempArrHolder[i] != null) {
				tempObjHolder = tempArrHolder[i];
			}
			if (((Employee)tempObjHolder).getEin() == empid && flag)  {
				grossSalary = EmployeeUtil.emp_grossSalary((Employee) tempObjHolder);
				flag = false;
			}
		}
		return grossSalary;
	}
	
	@Override
	public void saveToFile()
	{
		empArrVal.saveToFile();
	}

}
