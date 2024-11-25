package com.employee.employeemanagement.controller;

import com.employee.employeemanagement.entity.DepartmentEntity;
import com.employee.employeemanagement.model.Employee;
import com.employee.employeemanagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.employee.employeemanagement.model.Department;

import java.util.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PostMapping
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveOrUpdate(department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateDepartment( @RequestBody  Department department) {
        departmentService.saveOrUpdate(department);
    }
}
