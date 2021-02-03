package model.mongo;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import model.User;
import model.DB.ICrudServices;

public class UserMongo implements ICrudServices<User> {

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
        return null;
    }

    @Override
    public CompletableFuture<List<User>> GetAll() {
        // TODO Auto-generated method stub
        return null;
    }

    
    
}
