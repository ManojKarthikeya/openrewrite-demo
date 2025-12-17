package com.example.demo.service;

import com.example.demo.model.Department;
import java.util.List;

public interface DepartmentService {
    void createDepartment(Department department);
    Department getDepartmentById(Long id);
    List<Department> getAllDepartments();
    void updateDepartment(Department department);
    void deleteDepartment(Long id);
}
