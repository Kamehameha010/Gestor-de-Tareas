package model.SQL;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import model.User;
import model.DB.ICrudServices;

public class UserSql implements ICrudServices<User> {

    @Override
    public CompletableFuture<Void> Insert(User obj) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CompletableFuture<Void> Edit(User obj) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CompletableFuture<Void> Delete(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CompletableFuture<User> Find(int id) {
        // TODO Auto-generated method stub
        User user = new User();
        return CompletableFuture.completedFuture(user);
    }

    @Override
    public CompletableFuture<List<User>> GetAll() {
        // TODO Auto-generated method stub

        List<User> users = new ArrayList<User>();
        return CompletableFuture.completedFuture(users);
    }
    
}
