package Employee_Initial;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

// You can set the methods static when there are no instance variables created.
// 

//Method to get users input for all functions

public class EmployeeUtil{
	
	Employee emp;
	
	public static int getArrSize() {
		int totEmp = 0;
		try {
			
			// Look at the code carefully, you dont have to declare an array

			System.out.println("Enter the number of Employees you will be working with:");
			Scanner empc = new Scanner(System.in);
			totEmp = empc.nextInt();
			
		} catch (InputMismatchException|NullPointerException e) 
		{
			System.out.println("Enter a valid number of employees you will be working with.\n");
			getArrSize();
		}
		return totEmp;
	}
	
	public static Employee collectInfo() throws customExceptions
	{
		int ein, esalary, eage;
		String ename;
		Scanner uinfo = new Scanner(System.in);
		Scanner uname = new Scanner(System.in);
		System.out.println("Enter the Employee information:");
		System.out.println("Enter Employees ID: ");
		ein = uinfo.nextInt();
		System.out.println("Enter Employees Name: ");
		ename = uname.next();
		System.out.println("Enter Employees Salary: ");
		esalary = uinfo.nextInt();
		if(esalary <= 5000)
		{
			throw new customExceptions("The employees salary has to be more than 5000");
		}
		System.out.println("Enter Employees Age: ");
		eage = uinfo.nextInt();
		Employee emp;
		emp = EmployeeUtil.init_Employee(ein, ename, esalary, eage);
		return emp;
	}
	
	public static Employee collectInfo_Update(int ein) throws customExceptions
	{
		int esalary, eage;
		String ename;
		Scanner uinfo = new Scanner(System.in);
		Scanner uname = new Scanner(System.in);
		System.out.println("Enter the Employee information:");
		System.out.println("Enter Employees Name: ");
		ename = uname.next(); 
		System.out.println("Enter Employees Salary: ");
		esalary = uinfo.nextInt();
		if (esalary <= 5000) 
		{
			throw new customExceptions("Enter a Salary valye greater than 5000");
		}	
		System.out.println("Enter Employees Age: ");
		eage = uinfo.nextInt();
		Employee emp;
		emp = EmployeeUtil.init_Employee(ein, ename, esalary, eage);
		return emp;
	}
	
	
	public static Employee init_Employee(int ein, String eName, int eSalary, int eAge) {
		Employee emp = new Employee();
		emp.setEin(ein);
		emp.seteName(eName);
		emp.seteInitSalary();
		emp.seteSalary(eSalary);
		emp.seteAge(eAge);
		emp.initCompanyName(); // not mandatory that you use an object inference.
		return emp;
	}

	// method to increase salary
	public static void inc_Salary(int eSalary) {
		int incSalary;
		Employee emp = new Employee();
		incSalary = eSalary;
		incSalary = incSalary + ((incSalary * 10) / 100);

		emp.seteSalary(incSalary);
		System.out.println("Increased Salary of Employee with ID: " + emp.geteSalary());
	}

	public static void emp_salCompare(Employee emp1Sal, Employee emp2Sal) {
		int obj_emp1, obj_emp2;

		obj_emp1 = emp1Sal.geteSalary();
		obj_emp2 = emp2Sal.geteSalary();

		if (obj_emp1 > obj_emp2) {
			System.out.println("The Salary of Employee1 is greater");
		} else
			System.out.println("Salary of Employee2 is greater");
	}

	public static void emp_ageCompare(Employee emp1Age, Employee emp2Age) {
		int age1, age2;
		age1 = emp1Age.geteAge();
		age2 = emp2Age.geteAge();

		if (age1 > age2) {
			// return object so that it might be used someother time.
			System.out.println("Age of Employee 1 is greater");
		} else {
			System.out.println("Age of Employee 2 is greater");
		}
	}

	public static void emp_updSalary(Employee emp) // Dont have to use emp_ the inference can be made from the class
													// placement
	{
		int salHolder, ageHolder;
		salHolder = emp.geteSalary();
		ageHolder = emp.geteAge();

		if (salHolder < 10000 && ageHolder >= 35) {
			// method to avoid duplication
			salHolder = salHolder + ((salHolder * 15) / 100);
			emp.seteSalary(salHolder);
			System.out.println("New update salary of Employee " + emp.getEin() + " is: " + emp.geteSalary());
		} else if (salHolder < 15000 && ageHolder >= 45) {
			salHolder = salHolder + ((salHolder * 20) / 100);
			emp.seteSalary(salHolder);
			System.out.println("New update salary of Employee " + emp.getEin() + " is: " + emp.geteSalary());
		} else if (salHolder < 20000 && ageHolder >= 55) {
			salHolder = salHolder + ((salHolder * 25) / 100);
			emp.seteSalary(salHolder);
			System.out.println("New update salary of Employee " + emp.getEin() + " is: " + emp.geteSalary());
		} else {
			System.out.println("The values didnt match anyone, try again");
		}
	}

	public static float emp_grossSalary(Employee emp) {
		float emp_baseSalary, da, hra, perc, grossEarning;
		int emp_Age = emp.geteAge();
		emp_baseSalary = emp.geteSalary();

		if (emp_baseSalary < 10000) {
			// another method for dupliction
			hra = emp.HRA(8);
			da = emp.DA(15);
			grossEarning = (emp_baseSalary + hra + da);
			//System.out.println("Gross income of Employee " + emp.getEin() + " is: " + grossEarning);
			return grossEarning;
		} else if (emp_baseSalary < 20000) {
			hra = emp.HRA(10);
			da = emp.DA(20);
			grossEarning = (emp_baseSalary + hra + da);
			//System.out.println("Gross income of Employee " + emp.getEin() + " is: " + grossEarning);
			return grossEarning;
		} else if (emp_baseSalary < 30000 && emp_Age >= 40) {
			hra = emp.HRA(15);
			da = emp.DA(27);
			grossEarning = (emp_baseSalary + hra + da);
			//System.out.println("Gross income of Employee " + emp.getEin() + " is: " + grossEarning);
			return grossEarning;
		} else if (emp_baseSalary < 30000 && emp_Age < 40) {
			hra = emp.HRA(13);
			da = emp.DA(25);
			grossEarning = (emp_baseSalary + hra + da);
			//System.out.println("Gross income of Employee " + emp.getEin() + " is: " + grossEarning);
			return grossEarning;
		} else {
			hra = emp.HRA(17);
			da = emp.DA(30);
			grossEarning = (emp_baseSalary + hra + da);
			//System.out.println("Gross income of Employee " + emp.getEin() + " is: " + grossEarning);
			return grossEarning;
		}
	}

	public static void get_Dept(int did) {
		switch (did) {
		case 10:
			System.out.println("Selected Department Sales\n");
			break;

		case 20:
			System.out.println("Selected Department Purchase\n");
			break;

		case 30:
			System.out.println("Selected Department Administration\n");
			break;

		case 40:
			System.out.println("Selected Department Research");
			break;

		default:
			System.out.println("Select a valid number\n");
			break;
		}
		
	}
	
	public static String getFilePath()
	{
		String filePath = "C:\\Users\\siddh\\Desktop\\IMCS_Parent\\Java_Frameworks\\CoreJava_Initial\\src\\Employee_Initial\\EmployeeData.csv";
		return filePath;
	}
	
	public static File initfileFromUser()
	{
		String filePath = "C:\\Users\\siddh\\Desktop\\IMCS_Parent\\Java_Frameworks\\CoreJava_Initial\\src\\Employee_Initial\\EmployeeData.csv";
		File file = new File(filePath);
		createFile(file);
		return file;
	}


	public static void createFile(File file) {
		if(!file.exists())
		{
			System.out.println("The designated file doesnt exist.");
			System.out.println("New file is being created");
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static boolean checkFileExists(String filePath)
	{
		boolean exists = false;
		File file = new File(filePath);
		if(file.exists())
		{
			exists = true;
		}
		return exists;
	}

	public static void initConnection() throws Exception
	{
		Properties props = new Properties();
		FileInputStream in = new FileInputStream("Employee_Initial/dbLogin.properties");
		props.load(in);
		in.close();

		String driver = props.getProperty("jdbc.driver");
		if (driver != null) {
			Class.forName(driver) ;
		}

		String url = props.getProperty("jdbc.url");
		String username = props.getProperty("jdbc.username");
		String password = props.getProperty("jdbc.password");

		Connection con = DriverManager.getConnection(url, username, password);
	}
}


