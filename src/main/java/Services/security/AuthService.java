package services.security;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;

import DB.IConnection;
import DB.sql.mysql.ConnectionMysql;
import model.User;
import model.viewmodel.UserViewModel;

public class AuthService implements IAuthService {

    IConnection<Connection> db = new ConnectionMysql();
    private final String FIND_USER = "Select * FROM USERS WHERE username=? and password=?";

    @Override
    public User isUserValid(UserViewModel model) {

        var conn = db.connect();
        User user = null;
        System.out.println(user == null);
        try {
            var stmp = conn.prepareStatement(FIND_USER);

            stmp.setString(1, model.getUsername());

            stmp.setString(2, EncryptService.Encrypt(model.getPassword()));
            var result = stmp.executeQuery();
            user = new User();
            while (result.next()) {
                user.setId(result.getInt(1));
                user.setName(result.getString(2));
                System.out.println("fdff "+result.getString(2));
                user.setLastName(result.getString(3));
                user.setUsername(result.getString(4));
            }
            System.out.println(user);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }
}
