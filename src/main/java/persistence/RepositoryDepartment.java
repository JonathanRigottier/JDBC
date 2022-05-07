package persistence;

import model.Department;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RepositoryDepartment {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public RepositoryDepartment (){
        connection = DBUtil.getDBConnection();
    }

    public void saveDepartment(Department department) {

        String sql = "INSERT INTO departments (name) " +
                "VALUES (?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,department.getName());
            int result = preparedStatement.executeUpdate();
            if(result > 0) {
                System.out.println("New department saved with success");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDepartment(int departmentId, String name){
        String sql = "UPDATE departments SET name = ? WHERE departmentId = ? ";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,departmentId);
            int result = preparedStatement.executeUpdate();
            if(result > 0){
                System.out.println("Department name updated with success");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteDepartment(int departmentId) {
        String sql = "DELETE FROM departments WHERE departmentID = ? ";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, departmentId);
            int result = preparedStatement.executeUpdate();
            if(result > 0) {
                System.out.println("Department deleted with success");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
