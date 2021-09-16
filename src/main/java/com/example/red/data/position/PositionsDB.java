package com.example.red.data.position;
import com.example.red.data.position.Positions;

import java.sql.*;
import java.util.ArrayList;

public class PositionsDB {
    private static String url = "jdbc:firebirdsql://localhost:3050/c:/REDDB1.fdb";
    private static String jdbc = "org.firebirdsql.jdbc.FBDriver";
    private static String username = "SYSDBA";
    private static String password = "masterkey";

    public static ArrayList<Positions> select() {

        ArrayList<Positions> positions = new ArrayList<Positions>();
        try{
            Class.forName(jdbc).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Posit");
                while(resultSet.next()){
                    int id = resultSet.getInt(1);
                    String post = resultSet.getString(2);
                    int salary = resultSet.getInt(3);
                    Positions position = new Positions(id, post, salary);
                    positions.add(position);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return positions;
    }
    public static Positions selectOne(int id) {

        Positions position = null;
        try{
            Class.forName(jdbc).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "SELECT * FROM POSIT WHERE post_id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int id_e = resultSet.getInt(1);
                        String post = resultSet.getString(2);
                        int salary = resultSet.getInt(3);
                        position = new Positions(id_e, post, salary);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return position;
    }
    public static int insert(Positions position) {

        try{
            Class.forName(jdbc).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "INSERT INTO POSIT (post, salary) Values (?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, position.getPosition());
                    preparedStatement.setInt(2, position.getSalary());
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static int update(Positions position) {

        try{
            Class.forName(jdbc).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "UPDATE POSIT SET POST = ?, SALARY = ? WHERE POST_ID = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, position.getPosition());
                    preparedStatement.setInt(2, position.getSalary());
                    preparedStatement.setInt(3, position.getId());
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
                String sql = "DELETE FROM POSIT WHERE POST_ID = ?";
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
