package Employee_Initial.Arrays;

import Employee_Initial.CommonFiles.Employee;
import Employee_Initial.CommonFiles.EmployeeUtil;

import java.io.*;

public class EmployeeArray <EA extends EmployeeBaseType>  implements EmployeeArrayInterface <EA>
{
	private EA[] empArr;

	@Override
	public EA[] getEmpArr() {
		return empArr;
	}

	@Override
	public void setEmpArr(EA[] empArr)
	{
		this.empArr = empArr;
	}

	//Default constructor initializes the array value
	public EmployeeArray(int empArrsize) {
		empArr = (EA[]) new EmployeeBaseType[empArrsize];
	}
	
	//Constructor is called when a file is passed as a parameter
	@Override
	public void readFromFile() throws Exception
	{
		EA[] tempArrHolder = getEmpArr();
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
				tempArrHolder[i] = (EA) emp;
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
	
	private EA parseLine(String line)
	{
		String[] tokens = line.split(",");
		Employee emp = EmployeeUtil.init_Employee(Integer.parseInt(tokens[0]), tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
		return (EA) emp;
	}

	// Method to display all the employees
		@Override
		public EA[] dispEmp() {
			EA[] tempArrHolder = getEmpArr();
			Employee tempval;
			for (int i = 0; i < tempArrHolder.length; i++) {
				if (tempArrHolder[i] != null) {
					tempval = (Employee) tempArrHolder[i];
					tempArrHolder[i] = (EA) tempval;
				}
			}
			setEmpArr(tempArrHolder);
			return getEmpArr();
		}
		
		// Method to display employee by ID
		@Override
		public EA dispEmpID(int empID) {
			EA tempObjHolder = null;
			EA[] tempArrHolder = getEmpArr();
			boolean flag = false;
			for (int i = 0; i < tempArrHolder.length; i++) {
				if (tempArrHolder[i] != null && flag == false) {
					tempObjHolder = tempArrHolder[i];
				}
				if (((Employee)tempObjHolder).getEin() == empID && flag == false) {
					tempObjHolder = tempArrHolder[i];
					flag = true;
				}
			}
			return tempObjHolder;
		}
		
		// Method to delete an employee and adjust the array
		@Override
		public void deleteEmployee(int empid) {
			EA[] tempArrHolder;
			tempArrHolder = getEmpArr();
			Employee tempObjHolder = null;
			int indexHolder = 0;
			boolean flag = false;
			for (int i = 0; i < tempArrHolder.length; i++) {
				if (tempArrHolder[i] != null) {
					tempObjHolder = (Employee) tempArrHolder[i];
				}
				if (tempObjHolder.getEin() == empid && flag == false) {
					tempArrHolder[i] = null;
					indexHolder = i;
					flag = true;
				}
			}
			tempArrHolder = (EA[]) adjArray((Employee[]) tempArrHolder, indexHolder);
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
		public void updateEmp(int empid, EA emp) {
			// Isolating the employee obj with relevant information
			EA[] tempArrHolder = getEmpArr();
			EA tempHolder = null;
			boolean flag = true;
			for (int i = 0; i < tempArrHolder.length; i++) {
				if (tempArrHolder[i] != null) {
					tempHolder = (EA) tempArrHolder[i];
				}
				if (((Employee)tempHolder).getEin() == empid && flag == true) {
					tempArrHolder[i] = emp;
					flag = false;
				}
			}
			setEmpArr(tempArrHolder);
		}
		
		private int getnextEmptyIndex() {
			int emptyval = 0;
			EA[] tempArrHolder = empArr;
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
		public void addEmp(EA emp) {
			EA[] tempArrHolder = getEmpArr();
			int indexHolder = getnextEmptyIndex();

			tempArrHolder[indexHolder] = emp;
			setEmpArr(tempArrHolder);
		}
		
		//Connect this method to read from the file in the constructor
		@Override
		public void saveToFile()
		{
			EA[] tempArrHolder = getEmpArr();
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
							emp = (Employee) tempArrHolder[i];
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
