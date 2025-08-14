package com.example.EmpDBApp.dao;

import com.example.EmpDBApp.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    private static Connection getConnection() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb","root","pradeep");
    }

    public void addEmployee(Employee emp){
        String sql = "INSERT INTO employee(empname, empdept, empsalary) values (?,?,?)";
        try(Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1,emp.getempName());
            ps.setString(2,emp.getempDept());
            ps.setDouble(3,emp.getempSalary());
            ps.executeUpdate();
            System.out.println("Employee added successfully");
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public List<Employee> getAllEmployees(){
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        try(Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                employees.add(new Employee(
                        rs.getInt("empId"),
                        rs.getString("empName"),
                        rs.getString("empDept"),
                        rs.getDouble("empSalary")
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return employees;
    }

    public void updateEmployeeSalary(int id, double newSalary) {
        String sql = "UPDATE employee SET empSalary = ? WHERE empId = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, newSalary);
            stmt.setInt(2, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee salary updated!");
            } else {
                System.out.println("Employee not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE empId = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee deleted!");
            } else {
                System.out.println("Employee not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
