package controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;



import model.User;
import model.DB.ICrudServices;
import model.SQL.UserSql;

public class UserController {

    private ICrudServices<User> manager = new UserSql();

    public UserController(ICrudServices<User> manager) {
        this.manager = manager;
    }

    public void Insert(User model) {
        manager.Insert(model);
    }

    public void Edit(User model) {
        manager.Edit(model);
    }

    public void Delete(int id) {
        manager.Delete(id);
    }

    public User Find (int id) {
        return  null; //manager.Find(id));
    }

    public CompletableFuture<List<User>> GetAll(){
        return manager.GetAll();
    }

}
