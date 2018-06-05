package Employee_Initial;

public class EmployeeArrayOperationsImpl 
{
	static String[] empInfo_Table = new String[5];
	public static void emp_addEmp(Employee emp, int index)
	{
		empInfo_Table[index] = "ein: "+emp.getEin()+"ename: "+emp.geteName();
		System.out.println("Information saved: "+empInfo_Table[index]);
	}
	public static void emp_delEmp(Employee emp, int index)
	{
		empInfo_Table[index] = "NULL";
		System.out.println("Information Deleted");
	}
	public static void emp_updEmp(Employee emp, int index)
	{
		empInfo_Table[index] = "ein: "+emp.getEin()+" ename: "+emp.geteName();
		System.out.println("Information updated/saved: "+empInfo_Table[index]);
	}
	public static void emp_displayEmp()
	{
		for(int i = 0; i < empInfo_Table.length; i++)
		{
			System.out.println("Employee Information: " +empInfo_Table[i]);
		}
	}
	
	public static void emp_grossSalary(Employee emp)
	{
		float emp_baseSalary, da, hra, perc, grossEarning;
		int emp_Age = emp.geteAge();
		emp_baseSalary = emp.geteSalary();
		
		if(emp_baseSalary < 10000)
		{
			hra = emp.HRA(8);
			da = emp.DA(15);
			grossEarning = (emp_baseSalary + hra + da);
			System.out.println("Gross income of Employee "+emp.getEin()+" is: "+grossEarning);
		}
		else if(emp_baseSalary < 20000)
		{
			hra = emp.HRA(10);
			da = emp.DA(20);
			grossEarning = (emp_baseSalary + hra + da);
			System.out.println("Gross income of Employee "+emp.getEin()+" is: "+grossEarning);
		}
		else if(emp_baseSalary < 30000 && emp_Age >= 40)
		{
			hra = emp.HRA(15);
			da = emp.DA(27);
			grossEarning = (emp_baseSalary + hra + da);
			System.out.println("Gross income of Employee "+emp.getEin()+" is: "+grossEarning);
		}
		else if(emp_baseSalary < 30000 && emp_Age < 40)
		{
			hra = emp.HRA(13);
			da = emp.DA(25);
			grossEarning = (emp_baseSalary + hra + da);
			System.out.println("Gross income of Employee "+emp.getEin()+" is: "+grossEarning);
		}
		else
		{
			hra = emp.HRA(17);
			da = emp.DA(30);
			grossEarning = (emp_baseSalary + hra + da);
			System.out.println("Gross income of Employee "+emp.getEin()+" is: "+grossEarning);
		}
	}
}
