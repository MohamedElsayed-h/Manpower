package com.example.manpower.service;

import com.example.manpower.entity.Employee;
import com.example.manpower.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void registerEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException("Employee Not Found by id ::" + id);
        }
        return employee;
    }

    public void deleteEmployeeById(long id) {
        employeeRepository.deleteById(id);

    }

}