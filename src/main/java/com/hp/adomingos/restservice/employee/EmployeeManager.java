package com.hp.adomingos.restservice.employee;

import java.util.List;

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

    // Update an employee (Partial update)
    public boolean updateEmployee(Integer id, Employee updatedEmployee) {
        List<Employee> employees = list.getEmployeeList();

        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                if (updatedEmployee.getFirstName() != null) {
                    employee.setFirstName(updatedEmployee.getFirstName());
                }
                if (updatedEmployee.getLastName() != null) {
                    employee.setLastName(updatedEmployee.getLastName());
                }
                if (updatedEmployee.getEmail() != null) {
                    employee.setEmail(updatedEmployee.getEmail());
                }
                if (updatedEmployee.getTitle() != null) {
                    employee.setTitle(updatedEmployee.getTitle());
                }
                
                return true;
            }
        }
        return false;       
    } 
}

