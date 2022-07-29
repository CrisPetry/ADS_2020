package com.dados.util;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import dev.morphia.Datastore;
import dev.morphia.Morphia;

/**
 *
 * @author xSandman
 */
public class Conection {

    private static final String DATABASE = "133057";
    private static final int PORT = 27017;

    private static MongoClientURI uri = new MongoClientURI("mongodb://133057:133057@177.67.253.61/?authSource=133057&ssl=false");
    private static MongoClient mongo = new MongoClient(uri);
    private static MongoClient mongoClient = new MongoClient(uri);
    private static Morphia morphia = new Morphia();
    private static Datastore datastore = morphia.createDatastore(mongoClient, DATABASE);

    public static Datastore obterConexao() {
        return datastore;
    }
}
