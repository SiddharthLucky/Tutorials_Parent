package Employee_Initial;

public class EmployeeMain {

	public static void main(String[] args) 
	{
		
		EmployeeUtil.init_Employee(1, "Siddharth", 123450, 24);
		EmployeeUtil.init_Employee(2, "Sam", 56789, 25);
		
		EmployeeUtil.inc_Salary(1000);
		
		EmployeeUtil.emp_Compare(123450, 56789);
		
	}

}
