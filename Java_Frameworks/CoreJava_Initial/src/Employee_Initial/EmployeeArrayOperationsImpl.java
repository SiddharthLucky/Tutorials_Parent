package Employee_Initial;

public class EmployeeArrayOperationsImpl 
{

		// Make it mistakes protected
		// Don't make this static
		// Don't keep any scanners or Sysout,a s they should be implemented by the main class
		// Just initialize the array, the constructor will provide the size from the user taken from the main
	public Employee[] empArr;

	public EmployeeArrayOperationsImpl(int empArrsize) 
	{
		empArr = new Employee[empArrsize];
		dispEmp();
	}
	
	public int getnextEmptyIndex(Employee[] tempArr)
	{
		int emptyval = 0;
		boolean flag = false;
		for(int i = 0; i < tempArr.length; i++)
		{
			if(tempArr[i] == null && flag == false)
			{
				emptyval = i;
				flag = true;
			}
		}
		return emptyval;
	}
	
	// Method to add employees
		public Employee[] addEmp(int empID, String empName, int empSalary, int empAge)
		{
			int empEinTemp, empSalaryTemp, empTempAge;
			int indexHolder = getnextEmptyIndex(empArr);
			String empNameTemp;
			Employee emp;
			
			empEinTemp = empID;
			empSalaryTemp = empSalary;
			empTempAge = empAge;
			empNameTemp = empName;
			emp = EmployeeUtil.init_Employee(empEinTemp, empNameTemp, empSalaryTemp, empTempAge);
			empArr[indexHolder] = emp;
			
			return empArr;
		}
		
	// Method to update the array values
		public Employee[] updateEmp(int empid, String eName, int empsalary, int eage)
		{
			//Isolating the enployee obj with relevant information
			Employee tempEmpHolder = null;
			boolean flag = true;
			for(int i = 0; i < empArr.length; i++)
			{
				if(empArr[i] != null)
				{
					tempEmpHolder = empArr[i];
				}
				if(tempEmpHolder.getEin() == empid && flag == true)
				{
					tempEmpHolder = EmployeeUtil.init_Employee(empid, eName, empsalary, eage);
					empArr[i] = tempEmpHolder;
					flag = false;
				}
			}
			return empArr;
		}
		
	// Method to display employee by ID
		public Employee dispEmpID(int empID)
		{
			Employee tempObjHolder = null;
			boolean flag = false;
			for(int i = 0; i < empArr.length; i++)
			{
				if(empArr[i] != null)
				{
					tempObjHolder = empArr[i];
				}
				if(tempObjHolder.getEin() == empID && flag == false)
				{
					tempObjHolder = empArr[i];
					flag = true;
				}
			}
			return tempObjHolder;
		}
		
	// Method to display all the employees
		public Employee[] dispEmp()
		{
			Employee[] tempArrHolder = new Employee[empArr.length];
			for(int i = 0; i < empArr.length; i++)
			{
				tempArrHolder[i] = empArr[i];
			}
			return tempArrHolder;
		}
	
}
