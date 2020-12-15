import com.opencsv.CSVReader;
import org.bson.Document;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    private static String CSV_FILE = "C:\\Users\\User\\IdeaProjects\\java_basics\\13_NoSQL" +
            "\\MongoReadCSV\\src\\main\\resources\\mongo.csv";

    public void parserCSV() {


        List<Document> students = new ArrayList();

        MongoControl control = new MongoControl();
        control.writeData(students);

        CSVReader reader = null;

        try {
            reader = new CSVReader(new FileReader(CSV_FILE));

            String[] line;
            while ((line = reader.readNext()) != null) {
                List<String> list = new ArrayList();
                String[] a = line[2].split(",");
                String[] b = a;
                int c = a.length;

                for (int i = 0; i < c; ++i) {
                    String s = b[i];
                    list.add(s);
                }
                students.add((new Document()).append("Name", line[0]).append("Age", line[1]).append("Courses", list));
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
