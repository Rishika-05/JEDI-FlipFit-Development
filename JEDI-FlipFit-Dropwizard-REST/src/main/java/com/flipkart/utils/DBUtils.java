/**
 * This class provides utility methods for interacting with the database.
 */
package com.flipkart.utils;

import java.sql.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {

    /**
     * Executes a Data Manipulation Language (DML) query.
     * 
     * @param statement the prepared statement containing the query
     * @return the number of rows affected by the query
     */
    public static int executeDMLQuery(PreparedStatement statement) {
        if(statement != null) {
            try {
                //System.out.println("Executing Query " + statement);
                return statement.executeUpdate();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return 0;
    }

    /**
     * Executes the given fetch query.
     * 
     * @param statement the prepared statement containing the query
     * @return the result set from the execution
     */
    public static ResultSet executeQuery(PreparedStatement statement) {
        ResultSet rs=null;
        try {
            rs = statement.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return rs;
    }

    /**
     * Creates a database connection.
     * 
     * @return the Connection object
     */
    public static Connection getConnection() {
        Connection connection = null;
        if (connection != null)
            return connection;
        else {
            try {
                    Properties prop = new Properties();
                    String configPath = "./src/main/java/com/config.properties";
                    InputStream inputStream = new FileInputStream(configPath);
                    prop.load(inputStream);
                    String driver = prop.getProperty("driver");
                    String url = prop.getProperty("url");
                    String user = prop.getProperty("user");
                    String password = prop.getProperty("password");
                    Class.forName(driver);
                    connection = DriverManager.getConnection(url, user, password);

                }
                catch (ClassNotFoundException e){
                    e.printStackTrace();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                return connection;
            }

        }
    
}


