package Employee_Initial;

public class EmployeeMain {

	public static void main(String[] args) 
	{
		Employee emp1 = new Employee();
		Employee emp2 = new Employee();
		
		emp1 = EmployeeUtil.init_Employee(1, "Siddharth", 1234, 50);
		emp2 = EmployeeUtil.init_Employee(2, "Sam", 56789, 25);
		
		/*// Array operations in java
		EmployeeArrayOperationsImpl.emp_addEmp(emp1, Integer.parseInt(args[0]));
		EmployeeArrayOperationsImpl.emp_updEmp(emp1, Integer.parseInt(args[0]));
		EmployeeArrayOperationsImpl.emp_delEmp(emp1, Integer.parseInt(args[0]));
		EmployeeArrayOperationsImpl.emp_displayEmp();
		
		// Get employee HRA
		emp1.HRA(10);*/
		
		
		// make sure you can make the application a bit interactive
		
		// You don't take the array to be static as it should be accessible by all the classes to have thier own info in the arrays 
		
		// Generally seeks more parameters
		EmployeeUtil.inc_Salary(1000);
		
		EmployeeUtil.emp_salCompare(emp1, emp2);
		
		EmployeeUtil.emp_ageCompare(emp1, emp2);
		
		EmployeeUtil.emp_updSalary(emp1);
		
		EmployeeUtil.emp_grossSalary(emp1);
		
		//Select Departments
		// reference created to the class where the enum is defined
		EmployeeUtil.get_Dept(10);
		
	}

}
