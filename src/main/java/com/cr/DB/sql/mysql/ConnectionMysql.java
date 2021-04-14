
package com.cr.DB.sql.mysql;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.cr.DB.IConnection;
import com.cr.tools.FileProperties;

public class ConnectionMysql implements IConnection<Connection> {

    private Connection conn = null;
    private Properties props;

    public ConnectionMysql() {

        try {
            props = FileProperties.readFile(new FileReader("Connection.propities"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection connect() {
        try {
            conn = DriverManager
                    .getConnection(String.format("jdbc:mysql://%s/%s?user=%s&password=%s", props.getProperty("host"),
                            props.getProperty("dbName"), props.getProperty("user"), props.getProperty("password")));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    @Override
    public void close() {

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.conn;
    }
}
