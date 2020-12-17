import com.mongodb.MongoClient;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class MongoConfig {

    private MongoCollection<Document> collection;
    private MongoDatabase mongoDatabase;

    public MongoCollection<Document> init() {
        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        mongoDatabase = mongoClient.getDatabase("local");
        collection = mongoDatabase.getCollection("students");
        collection.drop();
        return collection;
    }

    public MongoCollection<Document> getCollection() {
        return collection;
    }

    public MongoDatabase getMongoDatabase() {
        return mongoDatabase;
    }
}
