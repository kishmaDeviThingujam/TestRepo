package com.employee.employeemanagement;

import com.employee.employeemanagement.model.Employee;
import com.employee.employeemanagement.repository.EmployeeRepository;
import com.employee.employeemanagement.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetEmployeeById() {
        Employee employee = new Employee();
        employee.setId(1L);
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        Employee result = employeeService.getEmployeeById(1L);
        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void testSaveOrUpdate() {
        Employee employee = new Employee();
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        Employee result = employeeService.saveOrUpdate(employee);
        assertNotNull(result);
        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    void testDeleteById() {
        doNothing().when(employeeRepository).deleteById(1L);

        employeeService.deleteById(1L);
        verify(employeeRepository, times(1)).deleteById(1L);
    }
}