package model.NoSQL;

import model.Task;
import model.DB.ICrudServices;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TaskNoSql implements ICrudServices<Task> {
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


