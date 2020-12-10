import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.opencsv.CSVReader;
import org.bson.Document;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {

    private static String CSV_FILE = "C:\\Users\\User\\IdeaProjects\\java_basics\\13_NoSQL" +
            "\\MongoReadCSV\\src\\main\\resources\\mongo.csv";

    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        MongoDatabase database = mongoClient.getDatabase("local");
        MongoCollection<Document> collection = database.getCollection("students");

        List<Document> students = new ArrayList();
        CSVReader reader = null;

        try {
            reader = new CSVReader(new FileReader(CSV_FILE));

            String[] line;
            while((line = reader.readNext()) != null) {
                List<String> list = new ArrayList();
                String[] a = line[2].split(",");
                String[] b = a;
                int c = a.length;

                for(int i = 0; i < c; ++i) {
                    String s = b[i];
                    list.add(s);
                }
                students.add((new Document()).append("Name", line[0]).append("Age", line[1]).append("Courses", list));
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        collection.insertMany(students);
        System.out.println("Общее количество студентов в базе: " + collection.countDocuments());
        System.out.println("Количество студентов старше 40 лет: " + collection.countDocuments
                (Filters.gt("Age", "40")));
        System.out.println("Имя самого молодого студента: " + ((Document)collection.find().sort
                (new BasicDBObject("Age", 1)).limit(1).first()).get("Name"));
        System.out.println("Список курсов самого старого студента: " + ((Document)collection.find().sort
                (new BasicDBObject("Age", -1)).limit(1).first()).get("Courses").toString());
    }
}