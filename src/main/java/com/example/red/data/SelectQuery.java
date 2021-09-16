package com.example.red.data;

import java.sql.*;
import java.util.ArrayList;


public class SelectQuery {
    private static String url = "jdbc:firebirdsql://localhost:3050/c:/REDDB1.fdb";
    private static String jdbc = "org.firebirdsql.jdbc.FBDriver";
    private static String username = "SYSDBA";
    private static String password = "masterkey";

    public static ArrayList select(String sql) {

        ArrayList<ArrayList<String>> answer = new ArrayList<ArrayList<String>>();
        try{
            Class.forName(jdbc).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                int columns = resultSet.getMetaData().getColumnCount();
                while(resultSet.next()){
                    ArrayList<String > pre = new ArrayList<String>();
                    for (int i = 1; i <= columns; i++){
                        pre.add(resultSet.getString(i));
                    }
                    answer.add(pre);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return answer;
    }
}
