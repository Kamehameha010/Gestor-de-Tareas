
package DB.sql.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import DB.IConnection;

public class ConnectionMysql implements IConnection<Connection> {

    private Connection conn = null;
    
    public ConnectionMysql(){
    }

    @Override
    public Connection connect() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/taskmanager?user=kame&password=1234");

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

    public Connection getConnection(){
        return this.conn;
    }
}
