package Employee_Initial;

public class EmployeeArrayOperationsImpl 
{
	static String[] empInfo_Table = new String[5];
	public static Employee emp_addEmp(Employee emp)
	{
		empInfo_Table[0] = "ein:"+emp.getEin()+"";
		return emp;
	}
}
