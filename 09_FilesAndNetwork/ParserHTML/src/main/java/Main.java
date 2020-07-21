import com.fasterxml.jackson.databind.ObjectMapper;
import core.Line;
import core.Metro;
import core.Station;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final String WEBSITE = "https://www.moscowmap.ru/metro.html#lines";
    private static final String FILE_PATH = "C:/Users/User/IdeaProjects/java_basics" +
            "/09_FilesAndNetwork/ParserHTML/src/main/resources/map.json";

    public static List<Line> linesList = new ArrayList<>();
    public static Map<String, List<Station>> stationsList = new LinkedHashMap<>();
    public static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {

        try {
            Document doc = Jsoup.connect(WEBSITE).maxBodySize(0).get();
            Elements lines = doc.getElementsByClass("js-metro-line");
            lines.forEach(e -> linesList.add(new Line(e.attr("data-line"), e.text())));

            Elements stations = doc.getElementsByClass("js-metro-stations");
            stations.forEach(e -> e.children().forEach(element -> {
                if (!stationsList.containsKey(e.attr("data-line"))) {
                    stationsList.put(e.attr("data-line"), new ArrayList<>());
                }
                stationsList.get(e.attr("data-line"))
                        .add(new Station(element.getElementsByClass("name").text()));
            }));

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
