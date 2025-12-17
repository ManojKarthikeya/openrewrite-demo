package com.example.demo.dao;

import com.example.demo.model.Employee;
import java.util.List;

public interface EmployeeDao {
    void save(Employee employee);
    Employee findById(Long id);
    List<Employee> findAll();
    void update(Employee employee);
    void delete(Long id);
    List<Employee> findByDepartmentId(Long departmentId);
}
