package persistence;

import model.Project;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RepositoryProject {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public RepositoryProject (){
        connection = DBUtil.getDBConnection();
    }

    public void saveProject(Project project) {

        String sql = "INSERT INTO projects (description) " +
                "VALUES (?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,project.getDescription());
            int result = preparedStatement.executeUpdate();
            if(result > 0) {
                System.out.println("New project saved with success");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateProject(int projectId, String description) {
        String sql = "UPDATE projects SET description = ? WHERE projectID = ? ";
         try {
             preparedStatement = connection.prepareStatement(sql);
             preparedStatement.setString(1,description);
             preparedStatement.setInt(2,projectId);
             int result = preparedStatement.executeUpdate();
             if(result > 0){
                 System.out.println("Project name updated with success");

             }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProject(int projectId) {
        String sql = "DELETE FROM projects WHERE projectID = ? ";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,projectId);
            int result = preparedStatement.executeUpdate();
            if(result > 0) {
                System.out.println("Project deleted with success");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
