package com.employee.employeemanagement.entity;

import jakarta.persistence.*;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name ="department")
public class DepartmentEntity {
    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "id")
    private List<EmployeeEntity> employeeEntityList;

}