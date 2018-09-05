package com.mypackage.springboot.models;

public class Employee {
    int id, salary;
    String empName, department;

    public Employee(int id, int salary, String empName, String department) {
        this.id = id;
        this.salary = salary;
        this.empName = empName;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
