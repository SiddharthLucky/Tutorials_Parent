package Employee_Initial;

public class EmployeeArrayOperationsImpl {

	// Make it mistakes protected
	// Don't make this static
	// Don't keep any scanners or Sysout,a s they should be implemented by the main
	// class
	// Just initialize the array, the constructor will provide the size from the
	// user taken from the main
	// Dont have to make return type array as there is only one copy that is being maintained by the UTIL class
	// Therefor you actually dont have to maintain another copy with the main class, or pass it as a parameter
	// As there is only one array defined and stored in the util class.
	// When you are making an array, you can make a variable to hold the index value of the array, as that way you dont have to
	// iterate everytime through the array.length
	public Employee[] empArr;

	public EmployeeArrayOperationsImpl(int empArrsize) {
		empArr = new Employee[empArrsize];
	}

	private int getnextEmptyIndex() {
		int emptyval = 0;
		Employee[] tempArrHolder = empArr;
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
	public void addEmp(Employee emp) {
		Employee[] tempArrHolder = empArr;
		int indexHolder = getnextEmptyIndex();

		tempArrHolder[indexHolder] = emp;
		empArr = tempArrHolder;
	}

	// Method to update the array values
	public void updateEmp(Employee emp, int empid) {
		// Isolating the employee obj with relevant information
		Employee[] tempArrHolder = empArr; 
		boolean flag = true;
		for (int i = 0; i < tempArrHolder.length; i++) {
			/*if (tempArrHolder[i] != null) {
				emp = tempArrHolder[i];
			}*/
			System.out.println("ein: "+emp.getEin()+"empid: "+empid);
			if (emp.getEin() == empid && flag == true) {
				tempArrHolder[i] = emp;
				flag = false;
			}
		}
		empArr = tempArrHolder;
	}

	// Method to display employee by ID
	public Employee dispEmpID(int empID) {
		Employee tempObjHolder = null;
		Employee[] tempArrHolder = empArr;
		boolean flag = false;
		for (int i = 0; i < tempArrHolder.length; i++) {
			if (tempArrHolder[i] != null && flag == false) {
				tempObjHolder = tempArrHolder[i];
			}
			if (tempObjHolder.getEin() == empID && flag == false) {
				tempObjHolder = tempArrHolder[i];
				flag = true;
			}
		}
		return tempObjHolder;
	}

	// Method to display all the employees
	public Employee[] dispEmp() {
		Employee[] tempArrHolder = empArr;
		Employee tempval;
		for (int i = 0; i < tempArrHolder.length; i++) {
			if (tempArrHolder[i] != null) {
				tempval = tempArrHolder[i];
				tempArrHolder[i] = tempval;
			}
		}
		empArr = tempArrHolder;
		return empArr;
	}

	// Method to delete an employee and adjust the array
	public void deleteEmployee(int empid) {
		Employee[] tempArrHolder;
		tempArrHolder = empArr;
		Employee tempObjHolder = null;
		int indexHolder = 0;
		boolean flag = false;
		for (int i = 0; i < tempArrHolder.length; i++) {
			if (tempArrHolder[i] != null) {
				tempObjHolder = tempArrHolder[i];
			}
			if (tempObjHolder.getEin() == empid && flag == false) {
				tempArrHolder[i] = null;
				indexHolder = i;
				flag = true;
			}
		}
		tempArrHolder = adjArray(tempArrHolder, indexHolder);
		empArr = tempArrHolder;
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

	public float getHRAbyID(int empid) {
		Employee[] tempArrHolder = empArr; 
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
		return hra;
	}

	public float grossSalaryByID(int empid) {
		Employee tempObjHolder = null;
		Employee[] tempArrHolder = empArr; 
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
}
