package Employee_Initial;

public class EmployeeServices implements EmployeeServicesInterface {

	// Make it mistakes protected
	// Don't make this static
	// Don't keep any scanners or Sysout,a s they should be implemented by the main
	// class
	// Just initialize the array, the constructor will provide the size from the
	// user taken from the main
	// Dont have to make return type array as there is only one copy that is being maintained by the UTIL class
	// Therefore you actually dont have to maintain another copy with the main class, or pass it as a parameter
	// As there is only one array defined and stored in the util class.
	// When you are making an array, you can make a variable to hold the index value of the array, as that way you dont have to
	// iterate everytime through the array.length

	EmployeeArray empArrVal;
	// You are just initializing an object that refers to the methods in the EmployeeArray class

	public EmployeeServices()
	{
		empArrVal = new EmployeeArray(EmployeeUtil.getArrSize());
	}
	
	//Method to add an employee
	@Override
	public void addEmployee()
	{
		Employee emp = EmployeeUtil.collectInfo();
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
	public void updateEmployee(int empid)
	{
		Employee emp = null;
		try 
		{
			emp = EmployeeUtil.collectInfo_Update(empid);
		}
		catch(customExceptions e)
		{
			e.printStackTrace();
		}
		empArrVal.updateEmp(empid, emp);
	}

	//Display Employees list by ID
	@Override
	public Employee dispEmployeeID(int empid)
	{
		Employee emp = empArrVal.dispEmpID(empid);
		return emp;
	}
	
	//Display all Employees
	@Override
	public Employee[] dispEmployee()
	{
		return empArrVal.dispEmp();
	}
	
	//Get hRA based on empployee id
	@Override
	public float getHRAbyID(int empid) {
		Employee[] tempArrHolder = empArrVal.getEmpArr(); 
		Employee tempObjHolder = null;
		float hra = 0;
		boolean flag = true;
		for (int i = 0; i < tempArrHolder.length; i++) {
			if (tempArrHolder[i] != null) {
				tempObjHolder = tempArrHolder[i];
			}
			if (tempObjHolder.getEin() == empid && flag == true) {
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
		Employee tempObjHolder = null;
		Employee[] tempArrHolder = empArrVal.getEmpArr(); 
		float grossSalary = 0;
		boolean flag = true;
		for (int i = 0; i < tempArrHolder.length; i++) {
			if (tempArrHolder[i] != null) {
				tempObjHolder = tempArrHolder[i];
			}
			if (tempObjHolder.getEin() == empid && flag == true) {
				grossSalary = EmployeeUtil.emp_grossSalary(tempObjHolder);
				flag = false;
			}
		}
		return grossSalary;
	}
}
