package org.afpa.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PapyrusDB {
    private final String URL = "jdbc:mariadb://localhost:3306/papyrus";
    private final String USER = "root";
    private final String PASS = "root";
    public Connection connection = null;

    public PapyrusDB() throws SQLException {
    }

    public  Connection getCon() throws SQLException{
        connection = DriverManager.getConnection(URL,USER,PASS);
        return connection;
    }
}
