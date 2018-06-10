package Employee_Initial;

import java.util.Scanner;

public class EmployeeArrayMain {

	private static Scanner empc;

	public static void main(String[] args) {
		int uopt;
		Employee emp;
		EmployeeArray empArrayobj = new EmployeeArray(EmployeeUtil.getArrSize());
		EmployeeServices servicesObj = new EmployeeServices(empArrayobj);
		while (true) {
			uopt = displayMenu();
			switch (uopt) {
			case 1:
				emp = EmployeeUtil.collectInfo();
				empArrayobj.addEmp(emp);
				System.out.println("Employee information added.\n");
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
				
				Scanner uinfo3 = new Scanner(System.in);
			
				System.out.println("\nEnter the EmployeeID whose information youd update: ");
				ein3 = uinfo3.nextInt();
				
				emp = EmployeeUtil.collectInfo();
			
				empArrayobj.updateEmp(emp, ein3);
				System.out.println("Employee Information Updated.\n");
				break;

			case 4:
				int tempidHolder4;
				System.out.println("\nEnter the EmployeeID to search for: ");
				Scanner uid = new Scanner(System.in);
				tempidHolder4 = uid.nextInt();
				Employee foundID;
				foundID = empArrayobj.dispEmpID(tempidHolder4);
				System.out.println("\nFound: " + foundID + "\n");
				break;

			case 5:
				Employee[] empArrMain = empArrayobj.dispEmp();
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
				hra = servicesObj.getHRAbyID(tempidHolder6);
				System.out.println("The Employee with ID: " + tempidHolder6 + " has HRA of: " + hra + "\n");
				break;

			case 7:
				int tempHolder7 = 0;
				float grossSalary;
				System.out.println("Enter the Employees ID for his/her Gross Salary");
				Scanner uid7 = new Scanner(System.in);
				tempHolder7 = uid7.nextInt();
				grossSalary = servicesObj.grossSalaryByID(tempHolder7);
				System.out.println(
						"The Employee with ID: " + tempHolder7 + " has a Gross Salary of: " + grossSalary + "\n");
				break;

			default:
				System.out.println("Selected an invalid option, Please select another\n");

			}
		}
	}

	public static int displayMenu() {
		int temp;
		System.out.println("\nEnter your option: ");
		System.out.println("1. ADD:");
		System.out.println("2. DELETE:");
		System.out.println("3. UPDATE:");
		System.out.println("4. DISPLAY BY ID:");
		System.out.println("5. DISPLAY ALL:");
		System.out.println("6. HRA BY ID:");
		System.out.println("7. GROSS INCOME BY ID:\n");
		System.out.println("Select your option:");
		Scanner uoption = new Scanner(System.in);
		temp = uoption.nextInt();
		return temp;
	}
}
