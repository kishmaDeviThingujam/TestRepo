package com.employee.employeemanagement;

import com.employee.employeemanagement.model.Department;
import com.employee.employeemanagement.repository.DepartmentRepository;
import com.employee.employeemanagement.service.DepartmentService;
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

class DepartmentServiceTest {

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private DepartmentService departmentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetDepartmentById() {
        Department department = new Department();
        department.setId(1L);
        when(departmentRepository.findById(1L)).thenReturn(Optional.of(department));

        Department result = departmentService.getDepartmentById(1L);
        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void testSaveOrUpdate() {
        Department department = new Department();
        when(departmentRepository.save(any(Department.class))).thenReturn(department);

        Department result = departmentService.saveOrUpdate(department);
        assertNotNull(result);
        verify(departmentRepository, times(1)).save(department);
    }

    @Test
    void testDeleteById() {
        doNothing().when(departmentRepository).deleteById(1L);

        departmentService.deleteById(1L);
        verify(departmentRepository, times(1)).deleteById(1L);
    }
}