package com.afyahmis.demo.data;

import com.afyahmis.demo.core.interfaces.DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;

public class MysqlConnection implements DbConnection {

    private Connection connection;
    private static final MysqlConnection instance=new MysqlConnection();
    private String connectionId;

    private MysqlConnection() {
        try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost/demo";
            String username = "root";
            String password = "M@un1983";
            Class.forName(driver);

            connection = DriverManager.getConnection(url, username, password);
            connectionId = UUID.randomUUID().toString();
            System.out.println("Connected !" + " Session:" + connectionId);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static MysqlConnection getInstance(){
        return instance;
    }

    @Override
    public String getConnectionId() {
        return connectionId;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }
}
