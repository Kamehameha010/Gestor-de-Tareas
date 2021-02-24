package DB.sql.mysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.IConnection;
import model.User;
import services.ICrudServices;

public class UserMysql implements ICrudServices<User, User> {

    private IConnection<Connection> mysql;

    public UserMysql() throws SQLException {
        mysql = new ConnectionMysql();
    }

    private final String INSERT = "INSERT INTO USERS VALUES(null,?,?,?,?)";
    private final String UPDATE = "UPDATE FROM USERS SET name=?, lastname=?, username=?,password=? WHERE id_user=?";
    private final String DELETE = "DELETE FROM USERS WHERE id_user=?";
    private final String FIND_BY_ID = "SELECT * FROM USERS WHERE id_user=?";
    private final String GET_ALL = "SELECT * FROM USERS";

    @Override
    public void Insert(User obj) throws SQLException {

        var conn = mysql.connect();
        var stmp = conn.prepareStatement(INSERT);
        stmp.setString(1, obj.getName());
        stmp.setString(2, obj.getLastName());
        stmp.setString(3, obj.getUsername());
        stmp.setString(4, obj.getPassword());
        try {
            stmp.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }

    @Override
    public void Edit(User obj) throws SQLException {
        var conn = mysql.connect();
        var stmp = conn.prepareStatement(UPDATE);
        stmp.setString(1, obj.getName());
        stmp.setString(2, obj.getLastName());
        stmp.setString(3, obj.getUsername());
        stmp.setString(4, obj.getPassword());
        stmp.setInt(4, obj.getId());
        try {
            stmp.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }

    @Override
    public void Delete(int id) throws SQLException {
        var conn = mysql.connect();
        var stmp = conn.prepareStatement(DELETE);
        stmp.setInt(1, id);
        try {
            stmp.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }

    @Override
    public User Find(int id) throws SQLException {
        var conn = mysql.connect();
        var stmp = conn.prepareStatement(FIND_BY_ID);
        stmp.setInt(1, id);
        User user = new User();
        ;
        try {
            var rs = stmp.executeQuery();

            while (rs.next()) {
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setUsername(rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return user;
    }

    @Override
    public List<User> GetAll() throws SQLException {

        ArrayList<User> users = new ArrayList<>();

        var conn = mysql.connect();
        var stmp = conn.prepareStatement(GET_ALL);
        try {
            var rs = stmp.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setUsername(rs.getString(4));
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return users;
    }

}
