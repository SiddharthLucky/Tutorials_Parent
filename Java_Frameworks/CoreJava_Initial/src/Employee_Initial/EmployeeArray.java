package Employee_Initial;

import java.io.*;

public class EmployeeArray implements EmployeeArrayInterface 
{
	private Employee[] empArr;

	public Employee[] getEmpArr() {
		return empArr;
	}

	@Override
	public void setEmpArr(Employee[] empArr) {
		this.empArr = empArr;
	}

	//Default constructor initializes the array value
	public EmployeeArray(int empArrsize) {
		empArr = new Employee[empArrsize];
	}
	
	//Constructor is called when a file is passed as a parameter
	@Override
	public void readFromFile() throws Exception
	{
		Employee[] tempArrHolder = getEmpArr();
		String filePath = EmployeeUtil.getFilePath();
		String line = "";
		String splitBy = ", ";
		
		try 
		{
			BufferedReader breader = new BufferedReader(new FileReader(filePath));
			int i = 0;
			Employee emp;
			while((line = breader.readLine()) != null)
			{
				String[] tempvalues = line.split(splitBy);
				emp = EmployeeUtil.init_Employee(Integer.parseInt(tempvalues[0]), tempvalues[1], Integer.parseInt(tempvalues[2]), Integer.parseInt(tempvalues[3]));
				tempArrHolder[i] = emp;
				i++;
			}
			System.out.println("Retrieved data from file.");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		setEmpArr(tempArrHolder);
	}
	
	private Employee parseLine(String line)
	{
		String[] tokens = line.split(",");
		Employee emp = EmployeeUtil.init_Employee(Integer.parseInt(tokens[0]), tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
		return emp;
	}

	// Method to display all the employees
		@Override
		public Employee[] dispEmp() {
			Employee[] tempArrHolder = getEmpArr();
			Employee tempval;
			for (int i = 0; i < tempArrHolder.length; i++) {
				if (tempArrHolder[i] != null) {
					tempval = tempArrHolder[i];
					tempArrHolder[i] = tempval;
				}
			}
			setEmpArr(tempArrHolder);
			return getEmpArr();
		}
		
		// Method to display employee by ID
		@Override
		public Employee dispEmpID(int empID) {
			Employee tempObjHolder = null;
			Employee[] tempArrHolder = getEmpArr();
			boolean flag = false;
			for (int i = 0; i < tempArrHolder.length; i++) {
				if (tempArrHolder[i] != null && flag == false) {
					tempObjHolder = tempArrHolder[i];
				}
				if (tempObjHolder.getEin() == empID && flag == false) {
					tempObjHolder = tempArrHolder[i];
					flag = true;
				}
			}
			return tempObjHolder;
		}
		
		// Method to delete an employee and adjust the array
		@Override
		public void deleteEmployee(int empid) {
			Employee[] tempArrHolder;
			tempArrHolder = getEmpArr();
			Employee tempObjHolder = null;
			int indexHolder = 0;
			boolean flag = false;
			for (int i = 0; i < tempArrHolder.length; i++) {
				if (tempArrHolder[i] != null) {
					tempObjHolder = tempArrHolder[i];
				}
				if (tempObjHolder.getEin() == empid && flag == false) {
					tempArrHolder[i] = null;
					indexHolder = i;
					flag = true;
				}
			}
			tempArrHolder = adjArray(tempArrHolder, indexHolder);
			setEmpArr(tempArrHolder);
		}
		
		private Employee[] adjArray(Employee[] tempArrHolder, int tempindHolder) {
			Employee tempHolder2 = null;
			for (int i = 0; i < tempArrHolder.length; i++) {
				for (int j = i + 1; j < tempArrHolder.length; j++) {
					if (tempArrHolder[i] == null && tempArrHolder[j] != null) {
						tempHolder2 = tempArrHolder[i];
						tempArrHolder[i] = tempArrHolder[j];
						tempArrHolder[j] = tempHolder2;
					}
				}
			}
			return tempArrHolder;
		}
		
		// Method to update the array values
		@Override
		public void updateEmp(int empid, Employee emp) {
			// Isolating the employee obj with relevant information
			Employee[] tempArrHolder = getEmpArr();
			Employee tempHolder = null;
			boolean flag = true;
			for (int i = 0; i < tempArrHolder.length; i++) {
				if (tempArrHolder[i] != null) {
					tempHolder = tempArrHolder[i];
				}
				if (tempHolder.getEin() == empid && flag == true) {
					tempArrHolder[i] = emp;
					flag = false;
				}
			}
			setEmpArr(tempArrHolder);
		}
		
		private int getnextEmptyIndex() {
			int emptyval = 0;
			Employee[] tempArrHolder = empArr;
			boolean flag = false;
			for (int i = 0; i < tempArrHolder.length; i++) {
				if (tempArrHolder[i] == null && flag == false) {
					emptyval = i;
					flag = true;
				}
			}
			if (emptyval == tempArrHolder.length)
				System.out.println("Maximum limit reached");

			return emptyval;
		}

		// Method to add employees
		@Override
		public void addEmp(Employee emp) {
			Employee[] tempArrHolder = getEmpArr();
			int indexHolder = getnextEmptyIndex();

			tempArrHolder[indexHolder] = emp;
			setEmpArr(tempArrHolder);
		}
		
		//COnnect this method to read from the file in the constructor		
		@Override
		public void saveToFile()
		{
			Employee[] tempArrHolder = getEmpArr();
			Employee emp;
			File file = EmployeeUtil.initfileFromUser();
			if(file.exists())
			{
				try
				{
					BufferedWriter buffWrite = new BufferedWriter(new FileWriter(file));
					String empContainer;
					for(int i = 0; i < tempArrHolder.length; i++)
					{
						if(tempArrHolder[i] != null)
						{
							emp = tempArrHolder[i];
							empContainer = ""+emp.getEin()+", "+emp.geteName()+", "+ emp.geteSalary()+", "+emp.geteAge()+", "+emp.geteAge()+", "+emp.geteCompany();
							buffWrite.write(empContainer);
							buffWrite.newLine();
						}
					}
					buffWrite.flush();
					buffWrite.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
}
