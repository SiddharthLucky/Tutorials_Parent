package Employee_Initial.CommonFiles;

//import lombok.Getter;

import Employee_Initial.Arrays.EmployeeArray;
import Employee_Initial.Arrays.EmployeeArrayInterface;
import Employee_Initial.Collections.EmployeeArrayCollections;
import Employee_Initial.Collections.EmployeeArrayCollectionsInterface;
import Employee_Initial.DatabaseUse.EmployeeDatabase;
import Employee_Initial.DatabaseUse.EmployeeDatabaseInterface;

import java.util.ArrayList;

public class EmployeeServices implements EmployeeServicesInterface {

	 EmployeeArrayInterface empArrVal;
	 EmployeeArrayCollectionsInterface empArrValCollections;
	 EmployeeDatabaseInterface empDB;

	// You are just initializing an object that refers to the methods in the EmployeeArray class

	public EmployeeServices()
	{
		empArrVal = new EmployeeArray(EmployeeUtil.getArrSize());
		empArrValCollections = new EmployeeArrayCollections();
		empDB = new EmployeeDatabase();
		try {
			empArrVal.readFromFile();
			empArrValCollections.readFromFile();
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
		Employee emp;
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
			if (tempObjHolder.getEin() == empid && flag) {
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
			if (tempObjHolder.getEin() == empid && flag)  {
				grossSalary = EmployeeUtil.emp_grossSalary(tempObjHolder);
				flag = false;
			}
		}
		return grossSalary;
	}
	
	@Override
	public void saveToFile()
	{
		empArrVal.saveToFile();
	}

	//---------------- Methods Using Collections--------------

    @Override
    public void addEmployeeCollections() throws customExceptions
    {
        Employee emp = EmployeeUtil.collectInfo();
        if(emp == null)
            throw new customExceptions("Adding employee failed");
        empArrValCollections.addEmployee(emp);
    }

    @Override
    public void deleteEmployeeCollections(int empid)
    {
        empArrValCollections.deleteEmployee(empid);
    }

    //Method to Update an Employee Information
    @Override
    public void updateEmployeeCollections(int empid) throws customExceptions
    {
        Employee emp;
        emp = EmployeeUtil.collectInfo_Update(empid);
        if (emp == null)
            throw new customExceptions("Updtaing employee failed");
        empArrValCollections.updateEmployee(empid, emp);
    }

    //Display Employees list by ID
    @Override
    public Employee dispEmployeeIDCollections(int empid)
    {
        Employee emp = empArrValCollections.dispEmployeeID(empid);
        return emp;
    }

    //Display all Employees
    @Override
    public ArrayList<Employee> dispEmployeeCollections()
    {
        return empArrValCollections.dispEmployee();
    }

    //Get hRA based on employee id
    @Override
    public float getHRAbyIDCollections(int empid) {
        ArrayList<Employee> tempArrHolder = empArrValCollections.getEmpArrList();
        Employee tempObjHolder = null;
        float hra = 0;
        for (Employee temoObjHolder : tempArrHolder) {
            if (tempObjHolder.getEin() == empid) {
                hra = tempObjHolder.HRA();
            }
        }
        // You can also choose to directly send the above equation in a return statement.
        return hra;
    }

    //Get gross salary based on employee id
    @Override
    public float grossSalaryByIDCollections(int empid) {
        Employee tempObjHolder = null;
        ArrayList<Employee> tempArrHolder = empArrValCollections.getEmpArrList();
        float grossSalary = 0;
        for (Employee emp : tempArrHolder) {
            if (tempObjHolder.getEin() == empid)  {
                grossSalary = EmployeeUtil.emp_grossSalary(tempObjHolder);
            }
        }
        return grossSalary;
    }

    @Override
    public void saveToFileCollections()
    {
        empArrValCollections.saveToFile();
    }


    //Methods to access the Database DAO class
	@Override
	public ArrayList<Employee> displayEmployeesDB()
	{
		ArrayList<Employee> tempArr = null;
		try {
			tempArr = empDB.displayEmployeesDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempArr;
	}

	@Override
	public Employee displaybyIDfromDB(int empid)
	{
		Employee emp = null;
		try {
			emp = empDB.displaybyIDfromDB(empid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}


	@Override
	public void insertEmployeeDb(int empid)
	{
		try {
			empDB.insertEmployeeDb(empid);
			System.out.println("Data Successfully inserted DB");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmployeeDB(int empid)
	{
		try {
			empDB.deleteEmployeefromDB(empid);
			System.out.println("Employee Info successfully deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Employee> sortEmployeesDB(String column)
	{
		ArrayList<Employee> tempArr = empDB.sortDataDB(column);
		return tempArr;
	}
}
