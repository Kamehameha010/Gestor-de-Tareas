package DB.nosql.mongo;

import com.mongodb.MongoClient;

import DB.IConnection;

public class ConnectionMongo implements IConnection<MongoClient> {

    
    public ConnectionMongo() {
    }

    @Override
    public MongoClient connect() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub

    }

}
