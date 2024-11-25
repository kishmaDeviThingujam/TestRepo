package com.employee.employeemanagement.service;

import com.employee.employeemanagement.entity.DepartmentEntity;
import com.employee.employeemanagement.entity.EmployeeEntity;
import com.employee.employeemanagement.model.Department;
import com.employee.employeemanagement.model.Employee;
import com.employee.employeemanagement.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
        return departmentEntities.stream()
                .map(this::convertToModel)
                .collect(Collectors.toList());
    }
    private Department convertToModel(DepartmentEntity departmentEntity) {
        return Department.builder()
                .id(departmentEntity.getId())
                .name(departmentEntity.getName())
                .build();
    }

    public Department saveOrUpdate(Department department) {
        DepartmentEntity employeeEntity = convertToEntity(department);
        DepartmentEntity savedEntity = departmentRepository.save(employeeEntity);
        return convertToModel(savedEntity);
    }
    private DepartmentEntity convertToEntity(Department department) {
        return DepartmentEntity.builder()
                .id(department.getId())
                .name(department.getName())
                .build();
    }
    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }

    public Department getDepartmentById(Long id) {
        DepartmentEntity departmentEntity = departmentRepository.findById(id).orElse(null);
        return convertToModel(departmentEntity);
    }
}

