package com.employee.employeemanagement.repository;

import com.employee.employeemanagement.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

//    EmployeeEntity findByUserId(int userId);
//
//    @Modifying
//    @Query("update EmployeeEntity set name=:name, age=:age, salary=:salary where userId=:userId")
//    int updateEmployee(int userId, String name, int age, int salary);

}
