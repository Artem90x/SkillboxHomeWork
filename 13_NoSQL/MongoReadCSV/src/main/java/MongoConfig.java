import com.mongodb.MongoClient;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;



public class MongoConfig {

    public void init() {

        Parser parser = new Parser();
        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("local");
        MongoCollection<Document> collection = mongoDatabase.getCollection("students");
        collection.drop();

        parser.parserCSV();
    }
}
