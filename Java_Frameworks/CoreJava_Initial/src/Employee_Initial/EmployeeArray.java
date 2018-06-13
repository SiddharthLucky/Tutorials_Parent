package Employee_Initial;

public class EmployeeArray implements EmployeeArrayInterface 
{
	private Employee[] empArr;

	 public Employee[] getEmpArr() {
		return empArr;
	}

	public void setEmpArr(Employee[] empArr) {
		this.empArr = empArr;
	}

	public EmployeeArray(int empArrsize) {
		empArr = new Employee[empArrsize];
	}

	// Method to display all the employees
		@Override
		public Employee[] dispEmp() {
			Employee[] tempArrHolder = getEmpArr();
			Employee tempval;
			for (int i = 0; i < tempArrHolder.length; i++) {
				if (tempArrHolder[i] != null) {
					tempval = tempArrHolder[i];
					tempArrHolder[i] = tempval;
				}
			}
			setEmpArr(tempArrHolder);
			return getEmpArr();
		}
		
		// Method to display employee by ID
		@Override
		public Employee dispEmpID(int empID) {
			Employee tempObjHolder = null;
			Employee[] tempArrHolder = getEmpArr();
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
		
		// Method to delete an employee and adjust the array
		@Override
		public void deleteEmployee(int empid) {
			Employee[] tempArrHolder;
			tempArrHolder = getEmpArr();
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
			setEmpArr(tempArrHolder);
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
		
		// Method to update the array values
		@Override
		public void updateEmp(int empid, Employee emp) {
			// Isolating the employee obj with relevant information
			Employee[] tempArrHolder = getEmpArr();
			Employee tempHolder = null;
			boolean flag = true;
			for (int i = 0; i < tempArrHolder.length; i++) {
				if (tempArrHolder[i] != null) {
					tempHolder = tempArrHolder[i];
				}
				if (tempHolder.getEin() == empid && flag == true) {
					tempArrHolder[i] = emp;
					flag = false;
				}
			}
			setEmpArr(tempArrHolder);
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
		@Override
		public void addEmp(Employee emp) {
			Employee[] tempArrHolder = getEmpArr();
			int indexHolder = getnextEmptyIndex();

			tempArrHolder[indexHolder] = emp;
			setEmpArr(tempArrHolder);
		}
}
