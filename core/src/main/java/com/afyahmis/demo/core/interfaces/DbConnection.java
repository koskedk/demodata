package com.afyahmis.demo.core.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface DbConnection {
    String getConnectionId();
    Connection getConnection() throws Exception;
}
