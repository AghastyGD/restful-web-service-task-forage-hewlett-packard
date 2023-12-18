package com.hp.adomingos.restservice.employee;

import org.springframework.stereotype.Repository;

// Importing the employees class to use the
// definid properties in this class
import com.hp.adomingos.restservice.employee.Employees;

@Repository

//Class to create a list
// of employees
public class EmployeeManager {
    private static Employees list = new Employees();

    // First is executed this static block
    // before the main block
    static
    {

        // Creating some example employees
        list.getEmployeeList().add(
            new Employee(
                1,
                "Augusto",
                "Domingos",
                "augustodomingos@gmail.com",
                "Senior Software Engineer"
            ));

        list.getEmployeeList().add(
            new Employee(
                2,
                "Noemia",
                "Domingos",
                "noemiadomingos@gmail.com",
                "Junior FrontEnd Developer"
            ));
        
        list.getEmployeeList().add(
            new Employee(
                3,
                "Stela",
                "Yun",
                "syun@hewlettpackard.com",
                "Senior Software Engineering Director"
            ));
        
        list.getEmployeeList().add(
            new Employee(
                4,
                "John",
                "Steve",
                "johnsteve@gmail.com",
                "Junior Backend Developer"   
            ));
            
    }

    // Return the list
    public Employees getAllEmployees() {
        return list;
    }

    // Add an employee to the list
    public void addEmployee(Employee employee) {
        list.getEmployeeList().add(employee);
    }
}

