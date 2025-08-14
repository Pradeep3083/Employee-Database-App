package com.example.EmpDBApp.model;

public class Employee {
    private int empId;
    private String empName;
    private String empDept;
    private double empSalary;

    public Employee(int empId, String empName, String empDept, double empSalary) {
        this.empId = empId;
        this.empName = empName;
        this.empDept = empDept;
        this.empSalary = empSalary;
    }

    public Employee(String empName, String empDept, double empSalary) {
        this.empName = empName;
        this.empDept = empDept;
        this.empSalary = empSalary;
    }

    public int getempId() { return empId; }
    public String getempName() { return empName; }
    public String getempDept() { return empDept; }
    public double getempSalary() { return empSalary; }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Dept: %s | Salary: %.2f", empId, empName, empDept, empSalary);
    }
}
