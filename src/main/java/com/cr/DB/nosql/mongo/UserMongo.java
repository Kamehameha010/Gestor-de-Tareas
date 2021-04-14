package com.cr.DB.nosql.mongo;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cr.DB.IConnection;
import com.cr.Services.ICrudServices;
import com.cr.model.User;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class UserMongo implements ICrudServices<User> {

    private MongoCollection<User> users;
    private MongoDatabase db;
    private IConnection<MongoClient> mongoClient;

    public UserMongo() {
        mongoClient = new ConnectionMongo();
        db = mongoClient.connect().getDatabase("taskmanager");
        users = db.getCollection("users", User.class);

    }

    @Override
    public void Insert(User obj) throws SQLException {
        users.insertOne(obj);
    }

    @Override
    public void Edit(User obj) throws SQLException {
        users.updateOne(eq("_id", obj.getId()),
                combine(set("name", obj.getName()), set("name", obj.getName()), set("lastname", obj.getLastName()),
                        set("username", obj.getUsername()), set("password", obj.getPassword())));

    }

    @Override
    public void Delete(int id) throws SQLException {
        users.deleteOne(eq("_id", id));
    }

    @Override
    public User Find(int id) throws SQLException {
        return users.find(eq("_id", id)).first();
    }

    @Override
    public List<User> GetAll(int id) throws SQLException {
        List<User> data = new ArrayList<User>();
        var iterUser = users.find().iterator();

        while (iterUser.hasNext()) {
            data.add(iterUser.next());
        }
        return data;
    }

}
