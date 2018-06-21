package Employee_Initial;

import Employee_Initial.Collections.EmployeeArrayCollections;
import Employee_Initial.CommonFiles.EmployeeUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeDatabase implements EmployeeDatabaseInterface{

    public EmployeeDatabase()
    {
        EmployeeArrayCollections arrColl= new EmployeeArrayCollections();
        try {
            arrColl.readFromFile();
            ArrayList<Employee> tempArr= arrColl.getEmpArrList();
            for(Employee emp : tempArr)
            {
                insertEmployeeDb(emp);
            }
            System.out.println("Values have been placed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        EmployeeDatabase empdb = new EmployeeDatabase();

        //Checking if method works


        //Method to display all employees
        try {
            ArrayList<Employee> emparrtest = empdb.displayEmployeesDB();
            for(Employee emp : emparrtest)
            {
                System.out.println(emp.getEin()+" "+emp.geteName());
            }
            Employee emp = empdb.displaybyIDfromDB(1);
            System.out.println(emp.getEin()+" "+emp.geteName()+" "+emp.geteSalary());

            //empdb.insertEmployeeDb(emp);
            //empdb.deleteEmployeefromDB(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Method to display all the employees in the Database
    @Override
    public ArrayList<Employee> displayEmployeesDB() throws Exception
    {
        ArrayList<Employee> empArrayDB = new ArrayList<>();
        try
        {
            boolean checkval;
            String filePath = EmployeeUtil.getFilePathDB();
            checkval = EmployeeUtil.checkFileExists(filePath);
            if (checkval == true)
            {
                Connection con = EmployeeUtil.initConnection();
                String sql = "Select ein, employee_name, employee_salary, employee_age from employee_info";
                Statement stmt;
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next())
                {
                    int id = rs.getInt("ein");
                    String name = rs.getString("employee_name");
                    int salary = rs.getInt("employee_salary");
                    int age = rs.getInt("employee_age");
                    Employee emp = EmployeeUtil.init_Employee(id, name, salary, age);
                    empArrayDB.add(emp);
                }
                con.close();
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return empArrayDB;
    }

    //Method to display employee by id from database
    @Override
    public Employee displaybyIDfromDB(int empid) throws Exception
    {
        Employee emp = null;
        boolean checkval;
        String filePath = EmployeeUtil.getFilePathDB();
        checkval = EmployeeUtil.checkFileExists(filePath);
        if(checkval == true)
        {
            Connection con = EmployeeUtil.initConnection();
            String sql = "Select ein, employee_name, employee_salary, employee_age from employee_info where ein = "+empid+"";
            Statement stmt;
            stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next())
            {
                int id = rs.getInt("ein");
                String name = rs.getString("employee_name");
                int salary = rs.getInt("employee_salary");
                int age = rs.getInt("employee_age");
                emp = EmployeeUtil.init_Employee(id, name, salary, age);
            }
            con.close();
        }
        return emp;
    }

    //Method to insert into db
    @Override
    public void insertEmployeeDb(Employee emp) throws Exception
    {
        boolean checkval;
        String filePath = EmployeeUtil.getFilePathDB();
        checkval = EmployeeUtil.checkFileExists(filePath);
        if(checkval == true)
        {
            Connection con = EmployeeUtil.initConnection();
            String sql = "Insert into employee_info (ein , employee_name, employee_salary, employee_age, emp_company) values (?, ?, ?, ?, ?)";
            PreparedStatement stmt;
            stmt = con.prepareStatement(sql);
            stmt.setInt(1,emp.getEin());
            stmt.setString(2, emp.geteName());
            stmt.setInt(3,emp.geteSalary());
            stmt.setInt(4, emp.geteAge());
            stmt.setString(5, emp.geteCompany());
            stmt.executeUpdate();
            con.close();
        }
    }

    //Method to delete values from DB
    @Override
    public void deleteEmployeefromDB(int empid) throws Exception {
        boolean checkval;
        String filePath = EmployeeUtil.getFilePathDB();
        checkval = EmployeeUtil.checkFileExists(filePath);
        if(checkval == true)
        {
            Connection con = EmployeeUtil.initConnection();
            String sql = "Delete from employee_info where ein = ?";
            PreparedStatement stmt;
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, empid);
            stmt.executeUpdate();
            con.close();
        }
    }
}
