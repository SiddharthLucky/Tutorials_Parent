package Employee_Initial;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.Serializable;

import lombok.Getter;

public class EmployeeServices implements EmployeeServicesInterface, Serializable {

	// Make it mistakes protected
	// Don't make this static
	// Don't keep any scanners or Sysout,a s they should be implemented by the main
	// class
	// Just initialize the array, the constructor will provide the size from the
	// user taken from the main
	// Dont have to make return type array as there is only one copy that is being maintained by the UTIL class
	// Therefore you actually dont have to maintain another copy with the main class, or pass it as a parameter
	// As there is only one array defined and stored in the util class.
	// When you are making an array, you can make a variable to hold the index value of the array, as that way you dont have to
	// iterate everytime through the array.length

	EmployeeArray empArrVal;
	// You are just initializing an object that refers to the methods in the EmployeeArray class

	public EmployeeServices()
	{
		empArrVal = new EmployeeArray(EmployeeUtil.getArrSize());
		try {
			empArrVal.readFromFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	//Method to add an employee
	@Override
	public void addEmployee() throws customExceptions
	{
		Employee emp = EmployeeUtil.collectInfo();
		if(emp == null)
			throw new customExceptions("Adding employee failed");
		empArrVal.addEmp(emp);
	}
	
	//Method to delete an Employee
	@Override
	public void deleteEmployee(int empid)
	{
		empArrVal.deleteEmployee(empid);
	}
	
	//Method to Update an Employee Information
	@Override
	public void updateEmployee(int empid) throws customExceptions
	{
		Employee emp = null;
		emp = EmployeeUtil.collectInfo_Update(empid);
		if (emp == null)
			throw new customExceptions("Updtaing employee failed");
		empArrVal.updateEmp(empid, emp);
	}

	//Display Employees list by ID
	@Override
	public Employee dispEmployeeID(int empid)
	{
		Employee emp = empArrVal.dispEmpID(empid);
		return emp;
	}
	
	//Display all Employees
	@Override
	public Employee[] dispEmployee()
	{
		return empArrVal.dispEmp();
	}
	
	//Get hRA based on empployee id
	@Override
	public float getHRAbyID(int empid) {
		Employee[] tempArrHolder = empArrVal.getEmpArr(); 
		Employee tempObjHolder = null;
		float hra = 0;
		boolean flag = true;
		for (int i = 0; i < tempArrHolder.length; i++) {
			if (tempArrHolder[i] != null) {
				tempObjHolder = tempArrHolder[i];
			}
			if (tempObjHolder.getEin() == empid && flag == true) {
				hra = tempObjHolder.HRA();
				flag = false;
			}

		}
		// You can also choose to directly send the above equation in a return statement.
		return hra;
	}
	
	//Get gross salary based on employee id
	@Override
	public float grossSalaryByID(int empid) {
		Employee tempObjHolder = null;
		Employee[] tempArrHolder = empArrVal.getEmpArr(); 
		float grossSalary = 0;
		boolean flag = true;
		for (int i = 0; i < tempArrHolder.length; i++) {
			if (tempArrHolder[i] != null) {
				tempObjHolder = tempArrHolder[i];
			}
			if (tempObjHolder.getEin() == empid && flag == true) {
				grossSalary = EmployeeUtil.emp_grossSalary(tempObjHolder);
				flag = false;
			}
		}
		return grossSalary;
	}
	
	//COnnect this method to read from the file in the constructor	
	
	@Override
	public void saveToFile()
	{
		Employee[] tempArrHolder = empArrVal.getEmpArr();
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
	
	/*@Override
	public void employeeSerialize() throws IOException 
	{
		String file = EmployeeUtil.getfileFromUser();
		boolean fileExists = EmployeeUtil.checkFileExists(file);
		Employee[] empArr = empArrVal.getEmpArr();
		Employee emp = null;
		FileOutputStream fout = new FileOutputStream(file);
		ObjectOutputStream objectStream = new ObjectOutputStream(fout);
	if(fileExists == true)
	{
		for(int i = 0; i < empArr.length; i++)
		{
			if(empArr[i]!=null)
			{
				emp = empArr[i];
				objectStream.writeObject(emp);
			}
		}
	}
		objectStream.flush();
		fout.flush();
		objectStream.close();
		fout.close();
		System.out.println("All the employees are written to the file.");
		System.out.println("The file is saved at: "+EmployeeUtil.getfileFromUser());
	}
	
	@Override
	public Employee[] employeeDeSerialize() throws IOException, ClassNotFoundException
	{
		String file = EmployeeUtil.getfileFromUser();
		boolean fileExists = EmployeeUtil.checkFileExists(file);
		Employee[] empDesrialize = null;
		Employee emp;
		FileInputStream finput = new FileInputStream(file);
		ObjectInputStream objectInput = new ObjectInputStream(finput);
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
		int i = 0;
		if(fileExists == true)
		{
			while(reader.readLine() != null)
			{
				emp = (Employee) objectInput.readObject();
				empDesrialize[i] = emp;
				i++;
			}
		}
		reader.close();
		finput.close();
		objectInput.close();
		
		return empDesrialize;
	}*/
}
