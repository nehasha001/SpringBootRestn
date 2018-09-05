package com.mypackage.springboot.services;

import com.mypackage.springboot.models.Employee;
import com.mypackage.springboot.repositories.EmployeeRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public Employee getEmployee(String empName) {
        return employeeRepository.getEmployee(empName);
    }

    public List<Employee> getEmployees(String department) {
        return employeeRepository.getEmployees(department);
    }
}
