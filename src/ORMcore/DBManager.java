package ORMcore;

import JDBCConf.JDBCConfiguration;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBManager {
    private static JDBCConfiguration configuration;
    public static JDBCConfiguration getConfiguration() {
        return configuration;
    }

    static {
        Properties prop = new Properties();
        try {
            prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        configuration = new JDBCConfiguration(
                prop.getProperty("driver"),
                prop.getProperty("url"),
                prop.getProperty("user"),
                prop.getProperty("pwd"),
                prop.getProperty("usingDB"),
                prop.getProperty("srcPath"),
                prop.getProperty("poPath")
        );
    }

    public static Connection createConn(){
        try {
            Class.forName(configuration.getDriver());
            return DriverManager.getConnection(configuration.getUrl(),configuration.getUser(),configuration.getPwd());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void close(Statement statement,Connection connection){
        try {
            if (statement!=null){
                statement.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection){
        try {
            if (resultSet!=null){
                resultSet.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {
            if (statement!=null){
                statement.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
