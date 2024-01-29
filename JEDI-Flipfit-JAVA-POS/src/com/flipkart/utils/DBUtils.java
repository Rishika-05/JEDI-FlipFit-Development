package com.flipkart.utils;

import java.sql.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {

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
     * Execute the given fetch query
     * @param statement
     * @return result from the execution
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
     * Create connection
     * @return Connection object
     */

    public static Connection getConnection() {
            Connection connection = null;
            if (connection != null)
                return connection;
            else
            {
                try
                {

                    Properties prop = new Properties();

                    InputStream inputStream = new FileInputStream("/Users/sakshisoni/Documents/JEDI-FlipFit-Development/JEDI-Flipfit-JAVA-POS/src/config.properties");
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


