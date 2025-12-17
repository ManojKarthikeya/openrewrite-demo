package com.example.demo.dao;

import com.example.demo.model.Department;
import java.util.List;

public interface DepartmentDao {
    void save(Department department);
    Department findById(Long id);
    List<Department> findAll();
    void update(Department department);
    void delete(Long id);
}
