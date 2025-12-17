package com.example.demo.service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    @Transactional
    public void createEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }
        if (employee.getEmail() == null || employee.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Employee email cannot be empty");
        }
        // Business logic: check if email already exists (omitted for brevity but simulated check)
        if (employee.getSalary() != null && employee.getSalary() < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        employeeDao.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        return employeeDao.findById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
        if (employee == null || employee.getId() == null) {
            throw new IllegalArgumentException("Employee or ID cannot be null for update");
        }
        Employee existing = employeeDao.findById(employee.getId());
        if (existing == null) {
            throw new RuntimeException("Employee not found");
        }
        employeeDao.update(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        employeeDao.delete(id);
    }

    @Override
    public List<Employee> getEmployeesByDepartment(Long departmentId) {
        if (departmentId == null) {
            throw new IllegalArgumentException("Department ID cannot be null");
        }
        return employeeDao.findByDepartmentId(departmentId);
    }

    @Override
    @Transactional
    public void promoteEmployee(Long employeeId, String newJobId, Double newSalary) {
        Employee employee = employeeDao.findById(employeeId);
        if (employee != null) {
            employee.setJobId(newJobId);
            employee.setSalary(newSalary);
            employeeDao.update(employee);
        } else {
            throw new RuntimeException("Employee not found for promotion");
        }
    }
}
