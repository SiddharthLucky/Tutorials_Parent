package Employee_Initial;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeArrayMain {

	public static void main(String[] args) {
		int uopt = 0;
		//Always use the interface on the deceleration side and the class implements it on the right
		EmployeeServicesInterface empArrayobj = new EmployeeServices();
		while (true) {
			try 
			{
				uopt = displayMenu();
			}
			catch (InputMismatchException|NullPointerException e)
			{
				System.out.println("Enter a valid numerical value.");
				uopt = displayMenu();
			}
			
			switch (uopt) {
			case 1:
				try 
				{
					empArrayobj.addEmployee();
					System.out.println("Employee information added.\n");
				}
				catch (customExceptions e)
				{
					System.out.println(e.toString());
					System.out.println("Please re enter the values:");
				}
				break;

			case 2:
				int ein2;
				System.out.println("Enter employee ID to delete: ");
				Scanner uinfo2 = new Scanner(System.in);
				ein2 = uinfo2.nextInt();
				empArrayobj.deleteEmployee(ein2);
				System.out.println("Employee information deleted.\n");

				break;

			case 3:
				int ein3;
				System.out.println("Enter employee ID to updated: ");
				Scanner uinfo3 = new Scanner(System.in);
				ein3 = uinfo3.nextInt();
				try 
				{
					empArrayobj.updateEmployee(ein3);
					System.out.println("Employee Information Updated.\n");
				}
				catch(customExceptions e)
				{
					System.out.println(e.toString());
					System.out.println("Please re enter the values.");
				}
				break;

			case 4:
				int tempidHolder4;
				System.out.println("\nEnter the EmployeeID to search for: ");
				Scanner uid = new Scanner(System.in);
				tempidHolder4 = uid.nextInt();
				Employee foundID;
				foundID = empArrayobj.dispEmployeeID(tempidHolder4);
				System.out.println("\nFound: " + foundID + "\n");
				break;

			case 5:
				Employee[] empArrMain = empArrayobj.dispEmployee();
				for (int i = 0; i < empArrMain.length; i++) {
					if (empArrMain[i] != null) {
						System.out.println(empArrMain[i]);
					}
				}
				break;

			case 6:
				int tempidHolder6 = 0;
				float hra;
				System.out.println("\nEnter the Employees ID for his/her HRA");
				Scanner uid6 = new Scanner(System.in);
				tempidHolder6 = uid6.nextInt();
				hra = empArrayobj.getHRAbyID(tempidHolder6);
				System.out.println("The Employee with ID: " + tempidHolder6 + " has HRA of: " + hra + "\n");
				break;

			case 7:
				int tempHolder7 = 0;
				float grossSalary;
				System.out.println("Enter the Employees ID for his/her Gross Salary");
				Scanner uid7 = new Scanner(System.in);
				tempHolder7 = uid7.nextInt();
				grossSalary = empArrayobj.grossSalaryByID(tempHolder7);
				System.out.println(
						"The Employee with ID: " + tempHolder7 + " has a Gross Salary of: " + grossSalary + "\n");
				break;
				
				
			case 8:
				empArrayobj.saveToFile();
				System.out.println("File Saved in: "+EmployeeUtil.getFilePath());
				break;
			//case 8:
				/*try {
					empArrayobj.employeeSerialize();
				} catch (IOException e) {			
					e.printStackTrace();
					System.out.println("Operation failed, could not be written.");
				}
				System.out.println("Exiting Code.");*/
				//break;

			default:
				System.out.println("Selected an invalid option, Please select another\n");

			}
		}
	}

	public static int displayMenu(){
		int temp;
		System.out.println("\nEnter your option: ");
		System.out.println("1. ADD:");
		System.out.println("2. DELETE:");
		System.out.println("3. UPDATE:");
		System.out.println("4. DISPLAY BY ID:");
		System.out.println("5. DISPLAY ALL:");
		System.out.println("6. HRA BY ID:");
		System.out.println("7. GROSS INCOME BY ID:");
		System.out.println("8. EXIT SAVING CHANGES:\n");
		System.out.println("Select your option:");
		Scanner uoption = new Scanner(System.in);
		temp = uoption.nextInt();
		return temp;
		//throw new InputMismatchException();
		
	}
}
