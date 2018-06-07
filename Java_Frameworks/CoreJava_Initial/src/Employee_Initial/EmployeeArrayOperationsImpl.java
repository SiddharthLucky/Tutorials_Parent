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
	}
	
	private int getnextEmptyIndex()
	{
		int emptyval = 0;
		boolean flag = false;
		for(int i = 0; i < empArr.length; i++)
		{
			if(empArr[i] == null && flag == false)
			{
				emptyval = i;
				flag = true;
			}
		}
		if(emptyval == empArr.length)
			System.out.println("Maximum limit reached");
		
		return emptyval;
	}
	
	// Method to add employees
		public Employee[] addEmp(int empID, String empName, int empSalary, int empAge)
		{
			int empEinTemp, empSalaryTemp, empTempAge;
			int indexHolder = getnextEmptyIndex();
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
			//Isolating the employee obj with relevant information
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
		public Employee dispEmpID(Employee[] tempArrHolder, int empID)
		{
			Employee tempObjHolder = null;
			boolean flag = false;
			for(int i = 0; i < tempArrHolder.length; i++)
			{
				if(tempArrHolder[i] != null && flag == false)
				{
					tempObjHolder = tempArrHolder[i];
				}
				if(tempObjHolder.getEin() == empID && flag == false)
				{
					tempObjHolder = tempArrHolder[i];
					flag = true;
				}
			}
			return tempObjHolder;
		}
		
	// Method to display all the employees
		public Employee[] dispEmp(Employee[] tempArrHolder)
		{
			Employee tempval;
			for(int i = 0; i < tempArrHolder.length; i++)
			{
				if(tempArrHolder[i] != null)
				{
					tempval = tempArrHolder[i];
					tempArrHolder[i] = tempval;
				}
			}
			return tempArrHolder;
		}
		
	// Method to delete an employee and adjust the array
		public Employee[] deleteEmployee(int empid)
		{
			Employee[] tempArrHolder;
			tempArrHolder = empArr;
			Employee tempObjHolder = null;
			int indexHolder = 0;
			boolean flag = false;
			for(int i = 0; i < tempArrHolder.length; i++)
			{
				if(tempArrHolder[i] != null)
				{
					tempObjHolder = tempArrHolder[i];
				}
				if(tempObjHolder.getEin() == empid && flag == false)
				{
					tempArrHolder[i] = null;
					indexHolder = i;
					flag = true;
				}
			}
			tempArrHolder = adjArray(tempArrHolder, indexHolder);
			return tempArrHolder;
		}
		
		private Employee[] adjArray(Employee[] tempArrHolder, int tempindHolder)
		{
			Employee tempHolder2 = null;
			for(int i = 0; i < tempArrHolder.length; i++)
			{
				for(int j = i + 1; j < tempArrHolder.length; j++)
				{
					if(tempArrHolder[i] == null && tempArrHolder[j] != null)
					{
						tempHolder2 = tempArrHolder[i];
						tempArrHolder[i] = tempArrHolder[j];
						tempArrHolder[j] = tempHolder2;
					}
				}
			}
			return tempArrHolder;
		}
		
		public float getHRAbyID(Employee[] tempArrHolder, int empid)
		{
			Employee tempObjHolder = null;
			float hra = 0;
			boolean flag = true;
			for(int i = 0; i< tempArrHolder.length; i++)
			{
				if(tempArrHolder[i] != null)
				{
					tempObjHolder = tempArrHolder[i];
				}
				if(tempObjHolder.getEin() == empid && flag == true)
				{
					hra = tempObjHolder.HRA();
					flag = false;
				}
				
			}
			return hra;
		}
		
		public float grossSalaryByID(Employee[] tempArrHolder, int empid)
		{
			Employee tempObjHolder = null;
			float grossSalary = 0;
			boolean flag = true;
			for(int i = 0; i< tempArrHolder.length; i++)
			{
				if(tempArrHolder[i] != null)
				{
					tempObjHolder = tempArrHolder[i];
				}
				if(tempObjHolder.getEin() == empid && flag == true)
				{
					grossSalary = EmployeeUtil.emp_grossSalary(tempObjHolder);
					flag = false;
				}
			}
			return grossSalary;
		}
}
