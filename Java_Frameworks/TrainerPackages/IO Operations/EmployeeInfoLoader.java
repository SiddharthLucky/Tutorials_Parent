package trng.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EmployeeInfoLoader {

	public void serialyzeEmpInfo() throws Exception {

		try {
			CSVFileReader csvFileReader = new CSVFileReader();
			Employee[] employees = csvFileReader.readEmployees(new File("C:/temp/EmpData.csv"));
			serilizeEmployee(employees, "c:\\temp\\EmpData.txt");
//			displayEmployees(employees);
		} finally {

		}
	}

	private void displayEmployees(Employee[] employees) {
		for (Employee employee : employees) {
			
			if(employee == null) {break;}
			employee.display();
		}
	}

	static void serilizeEmployee(Employee[] employees, String file) throws IOException {
		FileOutputStream fos = new FileOutputStream(file);

		ObjectOutputStream oos = new ObjectOutputStream(fos);

		for (Employee employee : employees) {
			if (employee == null)
				break;
			oos.writeObject(employee);
		}

		oos.flush();
		fos.flush();
		fos.close();
		oos.close();
	}

	static Employee[] deSerilizeEmployee(String file) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(file);

		ObjectInputStream ois = new ObjectInputStream(fis);
		Employee[] employees = new Employee[20];
		Employee e = null;
		int i = 0;
		try {
			do {
				e = (Employee) ois.readObject();
				employees[i++] = e;
			} while (e != null);
		} catch (Exception exception) {

		}

		fis.close();
		ois.close();

		return employees;
	}

	public static void main(String[] args) throws Exception {
//		new EmployeeInfoLoader().serialyzeEmpInfo();
		Employee[] employees = deSerilizeEmployee("c:\\temp\\EmpData.txt");
		for (Employee employee : employees) {
			if (employee == null) {
				break;
			}
			employee.display();
		}
	}
}
