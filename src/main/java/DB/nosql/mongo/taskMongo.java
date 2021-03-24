package DB.nosql.mongo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import DB.IConnection;
import model.Task;
import services.ICrudServices;

public class taskMongo implements ICrudServices<Task> {

    private MongoCollection<Task> tasks;
    private MongoDatabase db;
    private IConnection<MongoClient> mongoClient;

    public taskMongo() {
        mongoClient = new ConnectionMongo();
        db = mongoClient.connect().getDatabase("taskmanager");
        tasks = db.getCollection("tasks", Task.class);

    }

    @Override
    public void Insert(Task obj) throws SQLException {
        tasks.insertOne(obj);
    }

    @Override
    public void Edit(Task obj) throws SQLException {
        tasks.updateOne(eq("_id", obj.getId()),
                combine(set("taskname", obj.getTaskName()), set("description", obj.getTaskDescription()),
                        set("date", obj.getTaskDate()), set("status", obj.getTaskIsCompleted())));

    }

    @Override
    public void Delete(int id) throws SQLException {
        tasks.deleteOne(eq("_id", id));
    }

    @Override
    public Task Find(int id) throws SQLException {

        return tasks.find(eq("_id", id)).first();
    }

    @Override
    public List<Task> GetAll(int id) throws SQLException {
        List<Task> data = new ArrayList<Task>();
        var iterUser = tasks.find(eq("id_user", id)).iterator();

        while (iterUser.hasNext()) {
            data.add(iterUser.next());
        }
        return data;
    }
}
