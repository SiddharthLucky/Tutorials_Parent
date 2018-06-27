package Employee_Initial.Collections;

import Employee_Initial.CommonFiles.Employee;
import Employee_Initial.Arrays.EmployeeServicesInterface;
import Employee_Initial.CommonFiles.EmployeeUtil;
import Employee_Initial.CommonFiles.customExceptions;
import java.util.ArrayList;

public class EmployeeServices_Collections implements EmployeeServicesInterface
{
    EmployeeArrayCollectionsInterface empArrValCollections;

    public EmployeeServices_Collections()
    {
        empArrValCollections = new EmployeeArrayCollections();
        try
        {
            empArrValCollections.readFromFile();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
}
