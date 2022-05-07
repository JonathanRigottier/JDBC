package main;

import model.Department;
import model.Employee;
import model.Project;
import persistence.RepositoryDepartment;
import persistence.RepositoryEmployee;
import persistence.RepositoryProject;

public class MainTest {

    public static void main(String[] args) {
        RepositoryEmployee repositoryEmployee = new RepositoryEmployee();
        Employee employee1 = new Employee();
        employee1.setFirstName("Blessing");
        employee1.setLastName("surname");
        employee1.setEmail("blessing@gmail.com");
        employee1.setSalary(5000);
        employee1.setPhoneNumber("5555-6990");
        employee1.setDateOfBirth("1990-05-01");
        //repositoryEmployee.saveEmployee(employee1);

        //repositoryEmployee.updateEmployeeSalary(1,2000);

        //repositoryEmployee.deleteEmployee(7);

        //repositoryEmployee.updateEmployee(8,"Jack","Robbins","1989-08-08","+372 558 07 63","jack.robbins@gmail.com");

        RepositoryDepartment repositoryDepartment = new RepositoryDepartment();
        Department department1 = new Department();
        department1.setName("Research");

        //repositoryDepartment.saveDepartment(department1);

        //repositoryDepartment.updateDepartment(5,"Marketing");

        //repositoryDepartment.deleteDepartment(5);

        RepositoryProject repositoryProject = new RepositoryProject();
        Project project1 = new Project();
        project1.setDescription("SDA Academy Full Course App");

        //repositoryProject.saveProject(project1);

        //repositoryProject.updateProject(4,"Marketing App");

        //repositoryProject.deleteProject(4);


    }

}
