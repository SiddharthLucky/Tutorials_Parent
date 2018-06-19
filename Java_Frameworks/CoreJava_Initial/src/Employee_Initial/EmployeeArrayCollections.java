package Employee_Initial;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeArrayCollections implements EmployeeArrayCollectionsInterface
{
	private ArrayList<Employee> empArrList = new ArrayList<>();
	
	public ArrayList<Employee> getEmpArrList() {
		return empArrList;
	}

	public void setEmpArrList(ArrayList<Employee> empArrList) {
		this.empArrList = empArrList;
	}
	
	@Override
	public void readFromFile() throws Exception
	{
		ArrayList<Employee> tempArrHolder = getEmpArrList();
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
				tempArrHolder.add(emp);
				i++;
			}
			System.out.println("Retrieved data from file.");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		setEmpArrList(tempArrHolder);
	}
	
	private Employee parseLine(String line)
	{
		String[] tokens = line.split(",");
		Employee emp = EmployeeUtil.init_Employee(Integer.parseInt(tokens[0]), tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
		return emp;
	}
	
	@Override
	public ArrayList<Employee> dispEmp() {
		return getEmpArrList();
	}
	
	@Override
	public Employee dispEmpID(int empID) {
		Employee tempObjHolder = null;
		ArrayList<Employee> tempArrHolder = getEmpArrList();
		for(Employee emp : tempArrHolder)
		{
			if(emp.getEin() == empID)
			{
				tempObjHolder = emp;
			}
		}
		return tempObjHolder;
	}
	
	@Override
	public void deleteEmployee(int empid) {
		ArrayList<Employee> tempArrHolder;
		tempArrHolder = getEmpArrList();
		
		for(Employee emp : tempArrHolder)
		{
			if(emp.getEin() == empid)
			{
				tempArrHolder.remove(emp);
			}
		}
		setEmpArrList(tempArrHolder);
	}
	
	@Override
	public void updateEmp(int empid, Employee emp) 
	{
		// Isolating the employee obj with relevant information
		ArrayList<Employee> tempArrHolder = getEmpArrList();
		for (Employee tempHolder : tempArrHolder) 
		{
			if (tempHolder.getEin() == empid) 
			{
				tempArrHolder.remove(tempHolder);
				tempArrHolder.add(emp);
			}
		}
		setEmpArrList(tempArrHolder);
	}
	
	@Override
	public void addEmp(Employee emp) {
		ArrayList<Employee> tempArrHolder = getEmpArrList();

		tempArrHolder.add(emp);
		setEmpArrList(tempArrHolder);
	}
	
	@Override
	public void saveToFile()
	{
		ArrayList<Employee> tempArrHolder = getEmpArrList();
		File file = EmployeeUtil.initfileFromUser();
		if(file.exists())
		{
			try
			{
				BufferedWriter buffWrite = new BufferedWriter(new FileWriter(file));
				String empContainer;
				for(Employee emp : tempArrHolder)
				{
						empContainer = ""+emp.getEin()+", "+emp.geteName()+", "+ emp.geteSalary()+", "+emp.geteAge()+", "+emp.geteAge()+", "+emp.geteCompany();
						buffWrite.write(empContainer);
						buffWrite.newLine();
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

