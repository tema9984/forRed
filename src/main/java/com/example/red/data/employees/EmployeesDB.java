package com.example.red.data.employees;

import com.example.red.data.employees.Employees;

import java.sql.*;
import java.util.ArrayList;

public class EmployeesDB {

        private static String url = "jdbc:firebirdsql://localhost:3050/c:/REDDB1.fdb";
        private static String jdbc = "org.firebirdsql.jdbc.FBDriver";
        private static String username = "SYSDBA";
        private static String password = "masterkey";

        public static ArrayList<Employees> select() {

            ArrayList<Employees> employees = new ArrayList<Employees>();
            try{
                Class.forName(jdbc).getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection(url, username, password)){

                    Statement statement = conn.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM Employees");
                    while(resultSet.next()){
                        int id = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        String surname = resultSet.getString(3);
                        int positions_id = resultSet.getInt(4);
                        int department_id = resultSet.getInt(5);
                        Employees employee = new Employees(id, name, surname, positions_id, department_id);
                        employees.add(employee);
                    }
                }
            }
            catch(Exception ex){
                System.out.println(ex);
            }
            return employees;
        }
        public static Employees selectOne(int id) {

            Employees employee = null;
            try{
                Class.forName(jdbc).getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection(url, username, password)){

                    String sql = "SELECT * FROM employees WHERE id=?";
                    try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                        preparedStatement.setInt(1, id);
                        ResultSet resultSet = preparedStatement.executeQuery();
                        if(resultSet.next()){
                            int id_e = resultSet.getInt(1);
                            String name = resultSet.getString(2);
                            String surname = resultSet.getString(3);
                            int positions_id = resultSet.getInt(4);
                            int department_id = resultSet.getInt(5);
                            employee = new Employees(id, name, surname, positions_id, department_id);
                        }
                    }
                }
            }
            catch(Exception ex){
                System.out.println(ex);
            }
            return employee;
        }
        public static int insert(Employees employee) {

            try{
                Class.forName(jdbc).getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection(url, username, password)){

                    String sql = "INSERT INTO Employees (name, surname, positions_id, departament_id) Values ( ?, ?, ?, ?)";
                    try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                        preparedStatement.setString(1, employee.getName());
                        preparedStatement.setString(2, employee.getSurname());
                        preparedStatement.setInt(3, employee.getPositions_id());
                        preparedStatement.setInt(4, employee.getDepartment_id());
                        return  preparedStatement.executeUpdate();
                    }
                }
            }
            catch(Exception ex){
                System.out.println(ex);
            }
            return 0;
        }

        public static int update(Employees employee) {

            try{
                Class.forName(jdbc).getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection(url, username, password)){

                    String sql = "UPDATE Employees SET NAME = ?, SURNAME = ?, POSITIONS_ID = ?, DEPARTAMENT_ID = ? WHERE ID = ?";
                    try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                        preparedStatement.setString(1, employee.getName());
                        preparedStatement.setString(2, employee.getSurname());
                        preparedStatement.setInt(3, employee.getPositions_id());
                        preparedStatement.setInt(4, employee.getDepartment_id());
                        preparedStatement.setInt(5, employee.getId());
                        return  preparedStatement.executeUpdate();
                    }
                }
            }
            catch(Exception ex){
                System.out.println(ex);
            }
            return 0;
        }
        public static int delete(int id) {

            try{
                Class.forName(jdbc).getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection(url, username, password)){
                    String sql = "DELETE FROM Employees WHERE id = ?";
                    try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                        preparedStatement.setInt(1, id);
                        return  preparedStatement.executeUpdate();
                    }
                }
            }
            catch(Exception ex){
                System.out.println(ex);
            }
            return 0;
        }

}
