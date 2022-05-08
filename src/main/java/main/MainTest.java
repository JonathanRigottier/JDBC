package main;

import model.Department;
import model.Employee;
import model.EmployeeDepartment;
import model.Project;
import persistence.RepositoryDepartment;
import persistence.RepositoryEmployee;
import persistence.RepositoryProject;

import java.util.List;

public class MainTest {

    public static void main(String[] args) {
        RepositoryEmployee repositoryEmployee = new RepositoryEmployee();
        Employee employee1 = new Employee();
        employee1.setFirstName("Helari");
        employee1.setLastName("Puust");
        employee1.setEmail("helari@gmail.com");
        employee1.setSalary(7025);
        employee1.setPhoneNumber("5005-8690");
        employee1.setDateOfBirth("1983-02-27");
        employee1.setEmployeeId(9);
        //repositoryEmployee.saveEmployee(employee1);

        //repositoryEmployee.updateEmployeeSalary(1,2000);

        //repositoryEmployee.deleteEmployee(7);

        //repositoryEmployee.updateEmployee(employee1);

        /*List<Employee> listAllEmp = repositoryEmployee.listAllEmployees();
        for (Employee emp : listAllEmp) {
            System.out.println(emp.toString());
        }*/

        /*Employee empResult = repositoryEmployee.findEmployeeById(11);
        if(empResult != null) {
            System.out.println(empResult.toString());
        } else {
            System.out.println("This employee id does not exist !");
        }*/
        List<EmployeeDepartment> list = repositoryEmployee.listEmployeeWithDepartment();
        for (EmployeeDepartment emp : list) {
            System.out.println(emp.toString());
        }

        /*RepositoryDepartment repositoryDepartment = new RepositoryDepartment();
        Department department1 = new Department();
        department1.setName("Research");*/

        //repositoryDepartment.saveDepartment(department1);

        //repositoryDepartment.updateDepartment(5,"Marketing");

        //repositoryDepartment.deleteDepartment(5);

        /*RepositoryProject repositoryProject = new RepositoryProject();
        Project project1 = new Project();
        project1.setDescription("SDA Academy Full Course App");*/

        //repositoryProject.saveProject(project1);

        //repositoryProject.updateProject(4,"Marketing App");

        //repositoryProject.deleteProject(4);


    }

}
