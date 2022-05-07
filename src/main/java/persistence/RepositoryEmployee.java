package persistence;

import model.Employee;
import util.DBUtil;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

//DDL (data definition language) - create, drop


public class RepositoryEmployee {
    private Connection connection;  //global attribute
    private PreparedStatement preparedStatement;  //global attribute

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

    public void updateEmployee(int employeeID, String firstName, String lastName, String dateOfBirth, String phoneNumber, String email) {
        String sql = "UPDATE employees SET firstName = ?, lastName = ?, dateOfBirth = ?, phoneNumber = ?, email = ? " +
                "WHERE employeeId = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);
            preparedStatement.setString(3,dateOfBirth);
            preparedStatement.setString(4,phoneNumber);
            preparedStatement.setString(5,email);
            preparedStatement.setInt(6,employeeID);
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
    public Employee findEmployeeBy(int employeeId){
        return null;
    }

    public List<Employee> listAllEmployees(){
        return null;
    }


}
