package com.itransition.app.resourses.database;

import java.sql.*;

public class DatabaseDriver {

    private Connection connection;
    private static DatabaseDriver driver = null;
    private static final String databasePath = "jdbc:sqlite:G:\\archive\\Courses\\test-generetor\\src\\main\\resources\\db.sqlite";

    private DatabaseDriver(Connection connection){
        this.connection = connection;
    }

    public static DatabaseDriver getInstance(){
        if(driver == null){
            Connection connection = null;
            try{
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection(databasePath);
                driver = new DatabaseDriver(connection);
            }catch (SQLException e){
                e.printStackTrace();
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        return driver;
    }

    public ResultSet getRecords(String queryBody){
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(queryBody);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
