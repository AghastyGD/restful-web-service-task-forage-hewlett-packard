package com.hp.adomingos.restservice.employee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
       
    }

    // TEST HTTP REQUEST: Add an employee
    @Test
    public void testAddEmployee() throws Exception {
        String employeeJson = "{\"firstName\":\"Siselia\",\"lastName\":\"Sofia\",\"email\":\"sophy@gmail.com\",\"title\":\"Artista\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/employees/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(employeeJson))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    // TEST HTTP REQUEST: Update an employee 
    @Test
    public void testUpdateEmployee() throws Exception {
        String updatedEmployeeJson = "{\"firstName\":\"Domingos\",\"lastName\":\"Vicente\",\"email\":\"domuvice@gmail.com\",\"title\":\"ceo\"}";

        mockMvc.perform(MockMvcRequestBuilders.put("/employees/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedEmployeeJson))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    // TEST HTTP REQUEST: delete an employee
    @Test
    public void testDeleteEmployee() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/employees/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Deleted successfully"));
    }
}

