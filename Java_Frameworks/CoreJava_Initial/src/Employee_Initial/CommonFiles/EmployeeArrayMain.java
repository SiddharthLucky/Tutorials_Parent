package Employee_Initial.CommonFiles;

import Employee_Initial.Arrays.EmployeeServices;
import Employee_Initial.Arrays.EmployeeServicesInterface;
import Employee_Initial.Collections.EmployeeServices_Collections;
import Employee_Initial.CommonFiles.*;
import Employee_Initial.DatabaseUse.EmployeeServices_Database;
import Employee_Initial.DatabaseUse.EmployeeThreads;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class EmployeeArrayMain {

    public static void main(String[] args) {
        int uopt = 0;
        //Always use the interface on the deceleration side and the class implements it on the right

        String path1 = "C:\\Users\\siddh\\Desktop\\IMCS_Parent\\Java_Frameworks\\CoreJava_Initial\\src\\Employee_Initial\\EmployeeData.csv";
        String path2 = "C:\\Users\\siddh\\Desktop\\IMCS_Parent\\Java_Frameworks\\CoreJava_Initial\\src\\Employee_Initial\\EmployeeData2.csv";
        String path3 = "C:\\Users\\siddh\\Desktop\\IMCS_Parent\\Java_Frameworks\\CoreJava_Initial\\src\\Employee_Initial\\EmployeeData3.csv";


        Thread t1 = new Thread(new EmployeeThreads(path1));
        Thread t2 = new Thread(new EmployeeThreads(path2));
        Thread t3 = new Thread(new EmployeeThreads(path3));

        t1.start();
        t2.start();
        t3.start();

        EmployeeServicesInterface empArrayobj = new EmployeeServices();
        EmployeeServicesInterface empArrayobj2 = new EmployeeServices_Collections();
        EmployeeServicesInterface empArrayobj3 = new EmployeeServices_Database();

        while (true) {
            try {
                uopt = displayMenu();
            } catch (InputMismatchException | NullPointerException e) {
                System.out.println("Enter a valid numerical value.");
                uopt = displayMenu();
            }

            switch (uopt) {
                case 1:
                    try {
                        empArrayobj.addEmployee();
                        empArrayobj3.insertEmployeeDb();
                        System.out.println("Employee information added.\n");
                    } catch (customExceptions e) {
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
                    empArrayobj.deleteEmployeeDB(ein2);
                    System.out.println("Employee information deleted.\n");

                    break;

                case 3:
                    int ein3;
                    System.out.println("Enter employee ID to updated: ");
                    Scanner uinfo3 = new Scanner(System.in);
                    ein3 = uinfo3.nextInt();
                    try {
                        empArrayobj.updateEmployee(ein3);
                        System.out.println("Employee Information Updated.\n");
                    } catch (customExceptions e) {
                        System.out.println(e.toString());
                        System.out.println("Please re enter the values.");
                    }
                    break;

                case 4:
                    int tempidHolder4;
                    System.out.println("\nEnter the EmployeeID to search for: ");
                    Scanner uid = new Scanner(System.in);
                    tempidHolder4 = uid.nextInt();
                    Employee foundID1, foundID2;
                    foundID1 = empArrayobj.dispEmployeeID(tempidHolder4);
                    foundID2 = empArrayobj.displaybyIDfromDB(tempidHolder4);
                    System.out.println("\nFound1: " + foundID1 + "\n"+"\nFound2: " + foundID2 + "\n");
                    break;

                case 5:
                    Employee[] empArrMain1 = empArrayobj.dispEmployee();
                    System.out.println("Displaying values from Arrays");
                    for (int i = 0; i < empArrMain1.length; i++)
                    {
                        if (empArrMain1[i] != null)
                        {
                            System.out.println(empArrMain1[i]);
                        }
                    }
                    List<Employee> tempArr = empArrayobj3.displayEmployeesDB();
                    System.out.println("Displaying values from DB");
                    for(Employee emp : tempArr)
                    {
                        System.out.println(emp.toString());
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
                    displaySortingMenu();
                    tempArr = empArrayobj.sortEmployeesDB("ein");
                    System.out.println("Printing the sorted list:\n");
                    for (Employee emp : tempArr)
                    {
                        System.out.println(emp.toString());
                    }
                    break;

                case 9:
                    empArrayobj.saveToFile();
                    System.out.println("File Saved in: " + EmployeeUtil.getFilePath());
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
        System.out.println("7. GROSS INCOME BY ID:");
        System.out.println("8. SORT EMPLOYEES:");
        System.out.println("9. EXIT SAVING CHANGES:\n");
        System.out.println("Select your option:");
        Scanner uoption = new Scanner(System.in);
        temp = uoption.nextInt();
        return temp;
        //throw new InputMismatchException();
    }

    public static void displaySortingMenu()
    {
        int tempSort = 0;
        System.out.println("1. Sort by Salary:");
        System.out.println("1. Sort by Name and Salary:");
        System.out.println("1. Sort by Department:");
        System.out.println("1. Sort by ID:");
        Scanner sortuoption = new Scanner(System.in);
        tempSort = sortuoption.nextInt();
    }
}
