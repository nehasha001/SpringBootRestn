package com.mypackage.springboot.repositories;

import com.mypackage.springboot.models.Employee;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {

    public List<Employee> employeeList =Arrays.asList(
            new Employee(1234, 4000, "Harish", "Developer"),
            new Employee(2345, 3000, "Javvaji", "Developer"),
            new Employee(3456, 5000, "Prasad", "Full Stack"),
            new Employee(4567, 3000, "Nikhil", "Full Stack")
            );

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getEmployee(String empName) {

       return employeeList.stream()
                .filter(employee -> employee.getEmpName().equals(empName))
                .findFirst().get();
    }

    public List<Employee> getEmployees(String department) {

        return employeeList.stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .collect(Collectors.toList());


    }
}
