package com.example.demo.service;

import com.example.demo.model.Employee;
import java.util.List;

public interface EmployeeService {
    void createEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    List<Employee> getAllEmployees();
    void updateEmployee(Employee employee);
    void deleteEmployee(Long id);
    List<Employee> getEmployeesByDepartment(Long departmentId);
    void promoteEmployee(Long employeeId, String newJobId, Double newSalary);
}
