package services.security;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;

import java.security.NoSuchAlgorithmException;

import static com.mongodb.client.model.Filters.and;
import DB.IConnection;
import DB.nosql.mongo.ConnectionMongo;
import model.User;
import model.viewmodel.UserViewModel;

public class AuthServiceMongo implements IAuthService {
    IConnection<MongoClient> conn = new ConnectionMongo();

    @Override
    public User isUserValid(UserViewModel model) {
        var db = conn.connect().getDatabase("taskmanager");
        MongoCollection<User> users = db.getCollection("users", User.class);
        System.out.println("mongo-->" + model.getUsername()+" "+model.getPassword());
        User user = null;
        String pass ="";
        try {
            pass = EncryptService.Encrypt(model.getPassword());
        } catch (NoSuchAlgorithmException e1) {
            
            e1.printStackTrace();
        }
        System.out.println("pass "+pass);
        user = users.find(and(eq("username", model.getUsername()),
                eq("password",pass))).first();
        System.out.println("try-catch -->"+user);
        return user;
    }

}
