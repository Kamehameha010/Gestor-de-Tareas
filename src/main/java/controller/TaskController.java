package controller;

import java.sql.SQLException;
import java.util.List;


import DB.sql.mysql.TaskMysql;
import model.Task;
import services.ICrudServices;

public class TaskController  {


    private ICrudServices<Task, Task> _serviceContext;

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

    public List<Task> GetAll() throws SQLException {
        return _serviceContext.GetAll();
    }

    public Task FindById(int id) throws SQLException {
        return _serviceContext.Find(id);
    }
}
