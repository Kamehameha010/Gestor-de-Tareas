package services.security;

import java.sql.Connection;
import java.sql.SQLException;

import DB.IConnection;
import DB.sql.mysql.ConnectionMysql;
import model.User;
import model.viewmodel.UserViewModel;

public class AuthService implements IAuthService {

    IConnection<Connection> db = new ConnectionMysql();
    private final String FIND_USER = "Select username FROM USERS WHERE username=?, password=?";

    @Override
    public User isvalid(UserViewModel model) throws SQLException {

        var conn = db.connect();
        var stmp = conn.prepareStatement(FIND_USER);
        var result = stmp.executeQuery();

        User user = new User();

        user.setUsername(result.getString(1));
        
        return user;
    }
}
