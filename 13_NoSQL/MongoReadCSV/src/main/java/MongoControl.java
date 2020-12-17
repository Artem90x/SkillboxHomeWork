import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.List;

public class MongoControl {

    MongoCollection<Document> collection;

    public MongoControl(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public void writeData(List<Document> students) {
        collection.insertMany(students);
        System.out.println("Общее количество студентов в базе: " + collection.countDocuments());
        System.out.println("Количество студентов старше 40 лет: " + collection.countDocuments
                (Filters.gt("Age", "40")));
        System.out.println("Имя самого молодого студента: " + ((Document) collection.find().sort
                (new BasicDBObject("Age", 1)).limit(1).first()).get("Name"));
        System.out.println("Список курсов самого старого студента: " + ((Document) collection.find().sort
                (new BasicDBObject("Age", -1)).limit(1).first()).get("Courses").toString());
    }
}
