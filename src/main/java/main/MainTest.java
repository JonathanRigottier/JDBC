package main;

import model.Employee;
import persistence.RepositoryEmployee;

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

        repositoryEmployee.deleteEmployee(7);

    }

}
