package com.example.demo.service;

import com.example.demo.dao.DepartmentDao;
import com.example.demo.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao;

    @Autowired
    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    @Transactional
    public void createDepartment(Department department) {
        if (department == null) {
            throw new IllegalArgumentException("Department cannot be null");
        }
        if (department.getDepartmentName() == null || department.getDepartmentName().isEmpty()) {
            throw new IllegalArgumentException("Department name cannot be empty");
        }
        departmentDao.save(department);
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentDao.findById(id);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentDao.findAll();
    }

    @Override
    @Transactional
    public void updateDepartment(Department department) {
        if (department == null || department.getId() == null) {
            throw new IllegalArgumentException("Department or ID cannot be null");
        }
        departmentDao.update(department);
    }

    @Override
    @Transactional
    public void deleteDepartment(Long id) {
        departmentDao.delete(id);
    }
}
