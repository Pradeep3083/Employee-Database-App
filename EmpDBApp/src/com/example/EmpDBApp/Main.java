package com.example.EmpDBApp;

import com.example.EmpDBApp.dao.EmployeeDao;
import com.example.EmpDBApp.model.Employee;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeDao dao = new EmployeeDao();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\n===== Employee Database App =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1 -> {
                    System.out.println("Enter name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter department: ");
                    String dept = sc.nextLine();
                    System.out.println("Enter salary: ");
                    double salary = sc.nextDouble();
                    dao.addEmployee(new Employee(name, dept, salary));
                }
                case 2 -> {
                    List<Employee> list = dao.getAllEmployees();
                    if (list.isEmpty()) {
                        System.out.println("No employees found.");
                    } else {
                        list.forEach(System.out::println);
                    }
                }
                case 3 -> {
                    System.out.print("Enter employee ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter new salary: ");
                    double newSalary = sc.nextDouble();
                    dao.updateEmployeeSalary(id, newSalary);
                }
                case 4 -> {
                    System.out.print("Enter employee ID to delete: ");
                    int id = sc.nextInt();
                    dao.deleteEmployee(id);
                }
                case 5 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }

        }
    }
}