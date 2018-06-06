package Employee_Initial;

import java.awt.DisplayMode;
import java.util.Scanner;

public class EmployeeArrayMain 
{

	private static Scanner empc;

	public static void main(String[] args) 
	{
		int totEmp,uopt;
		Employee[] empArrMain = null;
		System.out.println("Enter the number of Employees you will be working with:");
		empc = new Scanner(System.in);
		totEmp = empc.nextInt();
		
		Employee emp1 = new Employee();
		
		//emp2 = EmployeeUtil.init_Employee(2, "Sam", 56789, 25);
		
		EmployeeArrayOperationsImpl empArrayobj = new EmployeeArrayOperationsImpl(totEmp);
		
		while(true)
		{
			uopt = displayMenu(); 
			switch (uopt) {
			case 1: int ein1, esalary1, eage1;
					String ename1;
					Scanner uinfo1 = new Scanner(System.in);
					Scanner uname1 = new Scanner(System.in);
					System.out.println("Enter the Employee information:");
					System.out.println("Enter Employees ID: ");
					ein1 = uinfo1.nextInt();
					System.out.println("Enter Employees Name: ");
					ename1 = uname1.next();
					System.out.println("Enter Employees Salary: ");
					esalary1 = uinfo1.nextInt();
					System.out.println("Enter Employees Age: ");
					eage1 = uinfo1.nextInt();
					
					empArrMain = empArrayobj.addEmp(ein1, ename1, esalary1, eage1);
					break;

			case 2: // Delete function
					break;

			case 3: int ein3, esalary3, eage3;
					String ename3;
					Employee tempHolder3;
					Scanner uinfo3 = new Scanner(System.in);
					Scanner uname3 = new Scanner(System.in);
					System.out.println("Enter the EmployeeID whose information youd update: ");
					ein3 = uinfo3.nextInt();
					System.out.println("Enter Employees Name: ");
					ename3 = uname3.next();
					System.out.println("Enter Employees Salary: ");
					esalary3 = uinfo3.nextInt();
					System.out.println("Enter Employees Age: ");
					eage3 = uinfo3.nextInt();
					
					empArrMain = empArrayobj.updateEmp(ein3, ename3, esalary3, eage3);
					break;

			case 4: int tempidHolder;
					System.out.println("Enter the EmployeeID to search for: ");
					Scanner uid = new Scanner(System.in);
					tempidHolder = uid.nextInt();
					Employee foundID;
					foundID = empArrayobj.dispEmpID(tempidHolder);
					System.out.println("Found: "+ foundID+"\n");
					break;

			case 5: empArrMain = empArrayobj.dispEmp();
					for(int i = 0; i < empArrMain.length; i++)
					{
						System.out.println("info: "+empArrMain[i]);
					}
					break;

			case 6: // HRA by id
					break;

			case 7: // GROSS income by ID
					break;

			default:
				System.out.println("Selected an invalid option, Please select another\n");

			}
			
		}
		
		
	}
	
	public static int displayMenu()
	{
		int temp;
		System.out.println("Enter the number of Employees you will be working with:");
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
