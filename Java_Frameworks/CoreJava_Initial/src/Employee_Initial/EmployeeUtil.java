package Employee_Initial;

public class EmployeeUtil 
{
	public static void init_Employee(int ein, String eName, int eSalary, int eAge)
	{
		Employee emp = new Employee();
		emp.setEin(ein);
		emp.seteName(eName);
		emp.seteInitSalary();
		emp.seteSalary(eSalary);
		emp.seteAge(eAge);
		emp.initCompanyName();
		System.out.println("Employee created: "+ emp);
	}
	
	// method to increase salary
	public static void inc_Salary(int eSalary)
	{
		int incSalary;
		Employee emp = new Employee();
		incSalary = eSalary;
		incSalary = incSalary + ((incSalary * 10) / 100);
		
		emp.seteSalary(incSalary);
		System.out.println("Increased Salary of Employee with ID: "+ emp.geteSalary());
	}
	
	public static void emp_Compare(int emp1Sal, int emp2Sal)
	{
		int obj_emp1, obj_emp2;
	
		obj_emp1 = emp1Sal;
		obj_emp2 = emp2Sal;
		
		if(obj_emp1 > obj_emp2)
		{
			System.out.println("The Salary of Employee1 is greater");
		}
		else
			System.out.println("Salary of Employee2 is greater");
	}
}
