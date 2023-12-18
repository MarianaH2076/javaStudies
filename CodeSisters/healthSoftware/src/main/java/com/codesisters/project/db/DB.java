package com.codesisters.project.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

    private static Connection connection = null;

    public static Connection getConnection() throws SQLException, FileNotFoundException {
        if(connection == null){
            Properties props = loadProperties();
            String url = props.getProperty("dburl");
            System.out.println("dburl: " + url);
            connection = DriverManager.getConnection(url, props);
        }
        return connection;
    }

    public static void closeConnection(){
        if(connection != null){
            try{
                connection.close();
            } catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    public static Properties loadProperties() throws FileNotFoundException {
        String url = "C:\\Users\\Mariana\\Documents\\Tech\\codeBrain\\Project\\db.properties";

        try(FileInputStream fs = new FileInputStream(url)) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

}
