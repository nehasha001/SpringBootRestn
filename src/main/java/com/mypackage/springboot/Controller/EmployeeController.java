package com.mypackage.springboot.Controller;

import com.mypackage.springboot.models.Employee;
import com.mypackage.springboot.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employees")
    public List<Employee> getAllEmployees() {

        return employeeService.getAllEmployees();
    }

    @RequestMapping(value = "/employee/{empName}")
    public Employee getEmployee(@PathVariable("empName") String empName) {

        return employeeService.getEmployee(empName);

    }
    @RequestMapping(value = "/employee")
    public List<Employee> getEmployees(@RequestParam String department) {
        return employeeService.getEmployees(department);
    }
}
