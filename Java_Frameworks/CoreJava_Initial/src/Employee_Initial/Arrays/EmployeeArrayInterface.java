package Employee_Initial.Arrays;

import Employee_Initial.CommonFiles.Employee;

public interface EmployeeArrayInterface <EA extends EmployeeBaseType>
{
	public EA[] getEmpArr();
	public void setEmpArr(EA[] emp);
	public void addEmp(EA emp);
	public void updateEmp(int empid, EA emp);
	public void deleteEmployee(int empid);
	public EA dispEmpID(int empID);
	public EA[] dispEmp();
	public void readFromFile() throws Exception;
	public void saveToFile();
}
