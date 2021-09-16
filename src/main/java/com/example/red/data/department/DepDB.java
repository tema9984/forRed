package com.example.red.data.department;

import java.sql.*;
import java.util.ArrayList;


public class DepDB {

    private static String url = "jdbc:firebirdsql://localhost:3050/c:/REDDB1.fdb";
    private static String jdbc = "org.firebirdsql.jdbc.FBDriver";
    private static String username = "SYSDBA";
    private static String password = "masterkey";


    public static ArrayList<Department> select() {

        ArrayList<Department> departments = new ArrayList<Department>();
        try{
            Class.forName(jdbc).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM DEPARTMENTS");
                while(resultSet.next()){

                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String mail = resultSet.getString(3);
                    int phone = resultSet.getInt(4);
                    Department department = new Department(id, name, mail, phone);
                    departments.add(department);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return departments;
    }
    public static Department selectOne(int id) {

        Department department = null;
        try{
            Class.forName(jdbc).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "SELECT * FROM DEPARTMENTS WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int d_id = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        String mail = resultSet.getString(3);
                        int phone = resultSet.getInt(4);
                        department = new Department(d_id, name, mail, phone);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return department;
    }
    public static int insert(Department department) {

        try{
            Class.forName(jdbc).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "INSERT INTO DEPARTMENTS (DEPARTMENT, mail, phone) Values ( ?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, department.getName());
                    preparedStatement.setString(2, department.getMail());
                    preparedStatement.setInt(3, department.getPhone());
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static int update(Department department) {

        try{
            Class.forName(jdbc).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "UPDATE DEPARTMENTS SET DEPARTMENT = ?, MAIL = ?, PHONE = ? WHERE ID = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, department.getName());
                    preparedStatement.setString(2, department.getMail());
                    preparedStatement.setInt(3, department.getPhone());
                    preparedStatement.setInt(4, department.getId());
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
                String sql = "DELETE FROM DEPARTMENTS WHERE id = ?";
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
