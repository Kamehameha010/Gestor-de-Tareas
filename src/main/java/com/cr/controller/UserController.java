package com.cr.controller;

import java.sql.SQLException;
import java.util.List;

import com.cr.DB.sql.mysql.UserMysql;
import com.cr.Services.ICrudServices;
import com.cr.model.User;

public class UserController {

    private ICrudServices<User> _serviceContext;

    public UserController() throws SQLException {
        _serviceContext = new UserMysql();
    }

    public void create(User model) throws SQLException {
        _serviceContext.Insert(model);
    }

    public void edit(User model) throws SQLException {
        _serviceContext.Edit(model);
    }

    public void delete(int id) throws SQLException {
        _serviceContext.Find(id);
    }

    public List<User> GetAll(int id) throws SQLException {
        return _serviceContext.GetAll(id);
    }

    public User FindById(int id) throws SQLException {
        return _serviceContext.Find(id);
    }
}
