package com.cr.controller;

import java.sql.SQLException;
import java.util.List;

import com.cr.DB.sql.mysql.TaskMysql;
import com.cr.Services.ICrudServices;
import com.cr.model.Task;

public class TaskController  {


    private ICrudServices<Task> _serviceContext;

    public TaskController(){
        
        _serviceContext = new TaskMysql();
    }

    public void create(Task model) throws SQLException {
        _serviceContext.Insert(model);
    }

    public void edit(Task model) throws SQLException {
        _serviceContext.Edit(model);
    }

    public void delete(int id) throws SQLException {
        _serviceContext.Find(id);
    }

    public List<Task> GetAll(int id) throws SQLException {
        return _serviceContext.GetAll(id);
    }

    public Task FindById(int id) throws SQLException {
        return _serviceContext.Find(id);
    }
}
