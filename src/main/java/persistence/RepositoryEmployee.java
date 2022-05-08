package persistence;

import model.Employee;
import model.EmployeeDepartment;
import util.DBUtil;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

//DDL (data definition language) - create, drop


public class RepositoryEmployee {
    private Connection connection;  //global attribute
    private PreparedStatement preparedStatement;  //global attribute
    private ResultSet resultSet;  //global attribute

    public RepositoryEmployee (){
        connection = DBUtil.getDBConnection();
    }
    //DML (data manipulation language) - insert, update, delete


    public void saveEmployee(Employee employee) {
        //statement
        //prepareStatement
        String sql = "INSERT INTO employees (firstName, lastName, dateOfBirth, phoneNumber, salary, email) " +
                "VALUES (?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,employee.getFirstName());
            preparedStatement.setString(2,employee.getLastName());
            preparedStatement.setDate(3, Date.valueOf(employee.getDateOfBirth()));
            preparedStatement.setString(4,employee.getPhoneNumber());
            preparedStatement.setInt(5, employee.getSalary());
            preparedStatement.setString(6,employee.getEmail());
            int result = preparedStatement.executeUpdate();
            if(result > 0) {
                System.out.println("Employee saved with success");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(Employee employee) {
        String sql = "UPDATE employees SET firstName = ?, lastName = ?, dateOfBirth = ?, phoneNumber = ?, salary = ? ,email = ? " +
                "WHERE employeeId = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setDate(3, Date.valueOf(employee.getDateOfBirth()));
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.setInt(5, employee.getSalary());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setInt(7,employee.getEmployeeId());
            int result = preparedStatement.executeUpdate();
            if(result > 0) {
                System.out.println("Employee updated with success");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateEmployeeSalary(int employeeId, int newSalary){
        String sql = "UPDATE employees SET salary = ? WHERE employeeId = ? ";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,newSalary);
            preparedStatement.setInt(2,employeeId);
            int result = preparedStatement.executeUpdate();
            if(result > 0){
                System.out.println("Employee salary updated with success");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int employeeId) {
        String sql = "DELETE FROM employees WHERE employeeId = ? ";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employeeId);
            int result = preparedStatement.executeUpdate();
            if(result > 0) {
                System.out.println("Employee deleted with success");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //DQL (data query language) - select
    public Employee findEmployeeById(int employeeId){
        String sql = "SELECT * FROM employees WHERE employeeId = ? ";
        Employee employee = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,employeeId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee = new Employee();
                employee.setEmployeeId(resultSet.getInt("employeeId"));
                employee.setFirstName(resultSet.getString("firstName"));
                employee.setLastName(resultSet.getString("lastName"));
                employee.setEmail(resultSet.getString("email"));
                employee.setSalary(resultSet.getInt("salary"));
                employee.setPhoneNumber(resultSet.getString("phoneNumber"));
                employee.setDateOfBirth(String.valueOf(resultSet.getDate("dateOfBirth")));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employee;
    }

    public List<Employee> listAllEmployees(){
        String sql = "SELECT * FROM employees";
        List<Employee> employeeList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Employee employee = new Employee();
                String firstName = resultSet.getString("firstName");
                employee.setFirstName(firstName);
                employee.setLastName(resultSet.getString("lastName"));
                employee.setEmail(resultSet.getString("email"));
                employee.setSalary(resultSet.getInt("salary"));
                employee.setPhoneNumber(resultSet.getString("phoneNumber"));
                employee.setDateOfBirth(String.valueOf(resultSet.getDate("dateOfBirth")));
                employee.setEmployeeId(resultSet.getInt("employeeId"));
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeeList;
    }

    public List<EmployeeDepartment> listEmployeeWithDepartment() {
        List<EmployeeDepartment> list = new ArrayList<>();
        String sql = "SELECT e.employeeId AS id, e.firstName, e.lastName, d.name " +
                     "FROM employees e " +
                     "INNER JOIN departments d ON e.departmentId = d.departmentId;";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                EmployeeDepartment employeeDept = new EmployeeDepartment();
                employeeDept.setEmployeeId(resultSet.getInt("id"));
                employeeDept.setFirstName(resultSet.getString("e.firstName"));
                employeeDept.setLastName(resultSet.getString("e.lastName"));
                employeeDept.setDepartmentName(resultSet.getString("d.name"));
                list.add(employeeDept);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<EmployeeDepartment> listEmployeeByDepartmentId(int departmentId){
        return null;
    }

    public List<EmployeeDepartment> listEmployeeByDepartmentName(String departmentName){
        return null;
    }


}
