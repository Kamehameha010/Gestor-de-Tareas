package model.DB;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import model.Identity;

public interface ICrudServices<T extends Identity> {

    CompletableFuture<Void> Insert(T obj);

    CompletableFuture<Void> Edit(T obj);

    CompletableFuture<Void> Delete(int id);

    CompletableFuture<T> Find(int id);

    CompletableFuture<List<T>> GetAll();

}
