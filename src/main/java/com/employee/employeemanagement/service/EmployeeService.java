package com.employee.employeemanagement.service;

import com.employee.employeemanagement.entity.DepartmentEntity;
import com.employee.employeemanagement.entity.EmployeeEntity;
import com.employee.employeemanagement.model.Employee;
import com.employee.employeemanagement.repository.DepartmentRepository;
import com.employee.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public Employee getEmployeeById(Long id) {
        EmployeeEntity employeeEntity= employeeRepository.findById(id).orElse(null);
        return convertToModel(employeeEntity);
    }
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities.stream()
                .map(this::convertToModel)
                .collect(Collectors.toList());
    }
    private Employee convertToModel(EmployeeEntity employeeEntity) {
        return Employee.builder()
                .id(employeeEntity.getId())
                .name(employeeEntity.getName())
                .departmentId(employeeEntity.getDepartmentEntity().getId())
                .build();
    }
    public Employee saveOrUpdate(Employee employee) {
        EmployeeEntity employeeEntity = convertToEntity(employee);
        EmployeeEntity savedEntity = employeeRepository.save(employeeEntity);
        return convertToModel(savedEntity);
    }
    private EmployeeEntity convertToEntity(Employee employee) {
        DepartmentEntity departmentEntity = departmentRepository.findById(employee.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        return EmployeeEntity.builder()
                .id(employee.getId())
                .name(employee.getName())
                .departmentEntity(departmentEntity)
                .build();
    }
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
