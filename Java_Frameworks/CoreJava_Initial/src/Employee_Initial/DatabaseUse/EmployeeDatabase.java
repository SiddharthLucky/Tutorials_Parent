package Employee_Initial.DatabaseUse;

import Employee_Initial.CommonFiles.Employee;
import Employee_Initial.CommonFiles.EmployeeUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;

public class EmployeeDatabase implements EmployeeDatabaseInterface {

    public EmployeeDatabase()
    {
            ArrayList<Employee> tempArrHolder = null;
            String filePath = EmployeeUtil.getFilePath();
            String line = "";
            String splitBy = ", ";

            boolean check = EmployeeUtil.checkFileExists(filePath);
            if(check == true) {
                try {
                    BufferedReader breader = new BufferedReader(new FileReader(filePath));
                    int i = 0;
                    Employee emp;
                    while ((line = breader.readLine()) != null) {
                        String[] tempvalues = line.split(splitBy);
                        emp = EmployeeUtil.init_Employee(Integer.parseInt(tempvalues[0]), tempvalues[1], Integer.parseInt(tempvalues[2]), Integer.parseInt(tempvalues[3]));
                        initinsertEmployeeDb(emp);
                        i++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
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
                EmployeeList(empArrayDB, rs);
                con.close();
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return empArrayDB;
    }

    private void EmployeeList(ArrayList<Employee> empArrayDB, ResultSet rs) throws SQLException {
        while (rs.next())
        {
            int id = rs.getInt("ein");
            String name = rs.getString("employee_name");
            int salary = rs.getInt("employee_salary");
            int age = rs.getInt("employee_age");
            Employee emp = EmployeeUtil.init_Employee(id, name, salary, age);
            empArrayDB.add(emp);
        }
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
    public void insertEmployeeDb(int empid) throws Exception
    {
        boolean checkval;
        String filePath = EmployeeUtil.getFilePathDB();
        checkval = EmployeeUtil.checkFileExists(filePath);
        ArrayList<Employee> tempArr  = displayEmployeesDB();
        for(Employee emp : tempArr)
        {
            if(emp.getEin() == empid)
            {
                cleanInsertDB(emp);
            }
        }
    }

    private void initinsertEmployeeDb(Employee emp) throws Exception
    {
        boolean checkval;
        cleanInsertDB(emp);
    }

    private void cleanInsertDB(Employee emp) throws Exception {
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

    //Method to sort the data by salary
    @Override
    public ArrayList<Employee> sortDataDB(String column)
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
                String sql = "Select ein, employee_name, employee_salary, employee_age from employee_info order by " + column + " desc";
                Statement stmt;
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                EmployeeList(empArrayDB, rs);
                con.close();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return empArrayDB;
    }
}
