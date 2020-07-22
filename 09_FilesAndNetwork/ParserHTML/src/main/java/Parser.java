import core.Line;
import core.Station;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Parser {

    private static final String WEB_SRC = "https://www.moscowmap.ru/metro.html#lines";

    public static List<Line> linesList = new ArrayList<>();
    public static Map<String, List<Station>> stationsList = new LinkedHashMap<>();


    public static void getDataWebsite () {
        try {
            Document doc = Jsoup.connect(WEB_SRC).maxBodySize(0).get();
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
        } catch (
                IOException ex) {
            ex.printStackTrace();
        }
    }
}