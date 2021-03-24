package DB.nosql.mongo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import DB.IConnection;
import tools.FileProperties;

public class ConnectionMongo implements IConnection<MongoClient> {

    private Properties props;
    private MongoClient conn;

    public ConnectionMongo() {
        try {
            props = FileProperties.readFile(new FileReader("MongoClient.propities"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MongoClient connect() {

        conn = MongoClients.create(ConnectionSettings
                .setting(String.format("mongodb://%s:%s", props.getProperty("host"), props.getProperty("port"))));
        
        return conn;
    }

    @Override
    public void close() {
        conn.close();
    }
}
