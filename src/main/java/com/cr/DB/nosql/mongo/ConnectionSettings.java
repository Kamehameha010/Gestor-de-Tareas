package com.cr.DB.nosql.mongo;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;

import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class ConnectionSettings {

    public static MongoClientSettings setting(String connection) {
        var ConnectionString = new ConnectionString(connection);
        CodecRegistry pojoCodecRegistry = CodecRegistries
                .fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                pojoCodecRegistry);

        return MongoClientSettings.builder().applyConnectionString(ConnectionString).codecRegistry(codecRegistry)
                .build();
    }
}
