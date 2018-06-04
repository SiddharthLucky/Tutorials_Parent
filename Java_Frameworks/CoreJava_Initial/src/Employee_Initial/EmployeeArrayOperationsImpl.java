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
}
