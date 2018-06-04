package Employee_Initial;

import Employee_Initial.Employee.Department;

public class EmployeeMain {

	public static void main(String[] args) 
	{
		Employee emp1 = new Employee();
		Employee emp2 = new Employee();
		
		emp1 = EmployeeUtil.init_Employee(1, "Siddharth", 1234, 50);
		emp2 = EmployeeUtil.init_Employee(2, "Sam", 56789, 25);
		
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
