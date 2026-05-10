package com.project.employee.service;

import com.project.employee.model.Employee;
import com.project.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public Employee addEmployee(Employee emp) {
        return repo.save(emp);
    }

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    public Employee getEmployee(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Employee updateEmployee(Long id, Employee emp) {
        Employee e = repo.findById(id).orElse(null);
        if (e != null) {
            e.setName(emp.getName());
            e.setEmail(emp.getEmail());
            e.setDepartment(emp.getDepartment());
            e.setSalary(emp.getSalary());
            return repo.save(e);
        }
        return null;
    }

    public void deleteEmployee(Long id) {
        repo.deleteById(id);
    }
}