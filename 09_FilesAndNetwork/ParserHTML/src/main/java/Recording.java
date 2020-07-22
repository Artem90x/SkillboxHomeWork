import com.fasterxml.jackson.databind.ObjectMapper;
import core.Metro;

import java.io.File;
import java.io.IOException;

public class Recording extends Parser {

    private static final String FILE_PATH = "C:/Users/User/IdeaProjects/Test" +
            "/Test1/untitled/src/main/resources/map.json";

    public static ObjectMapper mapper = new ObjectMapper();

    public  static void writeFileJson () {
        try {
            Metro metroMap = new Metro();
            metroMap.setStations(stationsList);
            metroMap.setLines(linesList);
            File path = new File(FILE_PATH);
            mapper.writerWithDefaultPrettyPrinter().writeValue(path, metroMap);
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(stationsList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}