# Employee Database App (Java + MySQL)

A simple **Java console application** for managing employee records using **JDBC** with a MySQL database.  
This application demonstrates basic **CRUD operations** (Create, Read, Update, Delete).

---

## 📌 Features
- **Add Employee** — Insert new employee details (name, department, salary)
- **View All Employees** — Retrieve and display all employee records
- **Update Employee Salary** — Change the salary of an existing employee
- **Delete Employee** — Remove an employee by their ID
- **Exit** — Close the application

---

## 🛠 Technologies Used
- **Java** (JDK 17+ recommended)
- **MySQL** (8.x recommended)
- **JDBC** (Java Database Connectivity)
- **Maven/Gradle** (optional, if you want dependency management)
- **MySQL Connector/J** (JDBC driver)

---

## ⚙️ Database Setup

### 1️⃣ Create Database
```sql
CREATE DATABASE empdb;
USE empdb;
CREATE TABLE employee (
    empId INT PRIMARY KEY AUTO_INCREMENT,
    empName VARCHAR(100) NOT NULL,
    empDept VARCHAR(50) NOT NULL,
    empSalary DOUBLE NOT NULL
);
```

---

## 📥 Installation & Running
1. Clone the Project
``` bash
git clone https://github.com/yourusername/EmpDBApp.git
cd EmpDBApp
```
2. Download the MySQl Driver
- Download MySQl Connector/J from: https://dev.mysql.com/downloads/connector/j/
- Place the .jar file in a folder named lib inside your project
3. Compile the poject
``` bash
javac -cp ".;lib/mysql-connector-j-8.0.xx.jar" com/example/EmpDBApp/**/*.java
```
(Replace 8.0.xx with your actual MySQl Connector version)
4. Ru the Application
``` bash
java -cp ".;lib/mysql-connector-j-8.0.xx.jar" com.example.EmpDBApp.Main
```

---

## 📷 Example Output

``` yaml
===== Employee Database App =====
1. Add Employee
2. View All Employees
3. Update Employee Salary
4. Delete Employee
5. Exit
Enter choice: 2

ID: 1 | Name: John Doe | Dept: IT | Salary: 55000.00
ID: 2 | Name: Jane Smith | Dept: HR | Salary: 48000.00
ID: 3 | Name: Mike Johnson | Dept: Finance | Salary: 60000.00

```

## 📝 Notes
- Update database redentials in `EmployeeDao.java`
``` java
DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "your_password");
```







