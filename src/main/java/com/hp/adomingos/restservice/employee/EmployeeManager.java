package com.hp.adomingos.restservice.employee;

import java.util.List;
import java.util.Iterator;

import org.springframework.stereotype.Repository;



@Repository
//Class to create a list of employees
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

    // Delete an employee
    public boolean deleteEmployee(Integer id) {
        List<Employee> employees = list.getEmployeeList();

        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                employees.remove(employee);
                return true;
            }
        }

        return false; // Employee not found
    }

    // Update an employee
    public boolean updateEmployee(Integer id, Employee updatedEmployee) {
        List<Employee> employees = list.getEmployeeList();

        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);

            if (employee.getId().equals(id)) {
                employee.setFirstName(updatedEmployee.getFirstName());
                employee.setLastName(updatedEmployee.getLastName());
                return true;
            }
        }

        return false; // Employee not found
    }

}

