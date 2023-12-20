package com.hp.adomingos.restservice.employee;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class EmployeeManagerTest {

    private EmployeeManager employeeManager;

    @BeforeEach
    public void setUp() {
        employeeManager = new EmployeeManager();
    }

    // TEST: ADD EMPLOYEE
    @Test
    public void testAddEmployee() {
        Employee employee = new Employee(5, "Maroa", "Domingos", "maroadomingos@gmail.com", "Developer");

        employeeManager.addEmployee(employee);
        assertEquals(4, employeeManager.getAllEmployees().getEmployeeList().size());

    }

    // TEST: DELETE employee
    @Test
    public void testDeleteEmployeeSuccess() {
        assertTrue(employeeManager.deleteEmployee(1));
        assertEquals(3, employeeManager.getAllEmployees().getEmployeeList().size());

    }

    @Test
    public void testDeleteEmployeeNotFound() {
        assertFalse(employeeManager.deleteEmployee(10));
    }

    // TEST: UPDATE employee
    @Test
    public void testUpdateEmployeeSuccess() {
        Employee updatedEmployee = new Employee(2, "Siselia", "Sofia", "sophy@gmail.com", "Artista");

        assertTrue(employeeManager.updateEmployee(2, updatedEmployee));

        Employee existingEmployee = employeeManager.getAllEmployees().getEmployeeList().get(0);
        assertEquals("Siselia", existingEmployee.getFirstName());
        assertEquals("Sofia", existingEmployee.getLastName());
        assertEquals("sophy@gmail.com", existingEmployee.getEmail());
        assertEquals("Artista", existingEmployee.getTitle());
    }

    @Test
    public void testUpdateEmployeeNotFound() {
        Employee updatedEmployee = new Employee(10, "Lucia", "Sitole", "lucyjuly@gmail.com", "Bussiness Analyst");
        assertFalse(employeeManager.updateEmployee(10, updatedEmployee));
    }
}