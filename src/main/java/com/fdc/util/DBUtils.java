package com.fdc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

    
//    private final static String URL = "jdbc:mysql://192.168.1.6:3306/answ?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC" ;
//    private final static String USERNAME = "spark" ;
//    private final static String PASSWORD = "123456" ;
    
    
    private final static String URL = "jdbc:oracle:thin:@10.1.241.76:1522:fjsdev";
    private final static String USERNAME = "fj" ;
    private final static String PASSWORD = "fj" ;
    
    
    private static Connection connection = null;
    
    static {
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    
    public static Connection getConnect() {
        if(connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return connection;
    }
    
    
    public static void main(String[] args) {
        
        
        

        
        
        

    }

}
