package com.alex.model.presistent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
    private static final String PATH = "src//main//resources//application.properties";
    private static String url;
    private static String root;
    private static String pass;
    private static Connection connection = null;

    public static Connection setConnection(){
        if(connection == null) {
            try{
                getProperties();
                connection = DriverManager.getConnection(url,root,pass);
            } catch (SQLException a){
                System.out.println("SQL Exception:" + a.getMessage());
                System.out.println("SQL State:" + a.getSQLState());
                System.out.println("Vendor Error:" + a.getErrorCode());
            }
        }
        return connection;
    }

    public static void closeConnection(){
        if (connection != null) {
            try{
               connection.close();
            } catch (SQLException a){
                System.out.println("SQL Exception:" + a.getMessage());
                System.out.println("SQL State:" + a.getSQLState());
                System.out.println("Vendor Error:" + a.getErrorCode());
            }
        }
    }

    private static void getProperties() {
        Properties properties = new Properties();
        try (FileInputStream fileInput = new FileInputStream(PATH)){
            properties.load(fileInput);
            url = properties.getProperty("datasource.url");
            root = properties.getProperty("datasource.username");
            pass = properties.getProperty("datasource.password");
            Class.forName(properties.getProperty("datasource.driver-class-name"));
        } catch (FileNotFoundException a){
            a.printStackTrace();
        } catch (IOException a) {
            a.printStackTrace();
        } catch (ClassNotFoundException a) {
            a.printStackTrace();
        }
    }
}
