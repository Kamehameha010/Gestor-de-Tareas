package com.cr.Services.security;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;

import com.cr.DB.IConnection;
import com.cr.DB.sql.mysql.ConnectionMysql;
import com.cr.model.User;
import com.cr.model.viewmodel.UserViewModel;

public class AuthServiceMysql implements IAuthService {

    IConnection<Connection> db = new ConnectionMysql();
    private final String FIND_USER = "Select * FROM USERS WHERE username=? and password=?";

    @Override
    public User isUserValid(UserViewModel model) {

        var conn = db.connect();
        User user = null;
        try {
            var stmp = conn.prepareStatement(FIND_USER);

            stmp.setString(1, model.getUsername());

            stmp.setString(2, EncryptService.Encrypt(model.getPassword()));
            var result = stmp.executeQuery();
            
            if (result.next()) {
                user = new User();
                user.setId(result.getInt(1));
                user.setName(result.getString(2));
                user.setLastName(result.getString(3));
                user.setUsername(result.getString(4));
            }

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
