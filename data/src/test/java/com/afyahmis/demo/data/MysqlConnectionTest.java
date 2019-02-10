package com.afyahmis.demo.data;

import com.afyahmis.demo.core.interfaces.DbConnection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sun.lwawt.macosx.CWarningWindow;

import java.sql.Connection;
import java.sql.SQLOutput;

import static org.junit.Assert.*;

public class MysqlConnectionTest {

    private DbConnection dbConnection;

    @Before
    public void setUp() throws Exception {
        dbConnection = MysqlConnection.getInstance();
    }

    @Test
    public void getInstance() {
        Assert.assertNotNull(dbConnection);
        System.out.println(dbConnection.getConnectionId());
    }

    @Test
    public void getConnection() throws Exception {
        Connection connection = dbConnection.getConnection();
        Assert.assertNotNull(connection);
        System.out.println(dbConnection.getConnectionId());
    }
}