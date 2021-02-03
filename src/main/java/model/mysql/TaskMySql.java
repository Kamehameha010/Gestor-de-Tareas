package model.mysql;


import java.util.List;
import java.util.concurrent.CompletableFuture;

import model.Task;
import model.DB.ICrudServices;

public class TaskMySql implements ICrudServices<Task> {

    @Override
    public CompletableFuture<Void> Insert(Task obj) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CompletableFuture<Void> Edit(Task obj) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CompletableFuture<Void> Delete(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CompletableFuture<Task> Find(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CompletableFuture<List<Task>> GetAll() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
