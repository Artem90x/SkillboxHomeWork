import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    StationIndex testStationIndex;
    RouteCalculator testRouteCalculator;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        testStationIndex = new StationIndex();
        testRouteCalculator = new RouteCalculator(testStationIndex);

        Line redLine = new Line(1, "Красная");
        Line blueLine = new Line(2, "Голубая");
        Line greenLine = new Line(3, "Зеленая");

        testStationIndex.addLine(redLine);
        testStationIndex.addLine(blueLine);
        testStationIndex.addLine(greenLine);

        //Ссылка на карту: https://i.ibb.co/f0yhydY/image.jpg)
        List<Station> redLineStation = new ArrayList<Station>(){{
        add(new Station("Девяткино", redLine));
        add(new Station("Площадь Ленина", redLine));
        add(new Station("Автово", redLine));
        }};

        List<Station> blueLineStation = new ArrayList<Station>() {{
           add(new Station("Парнас", blueLine));
           add(new Station("Сенная площадь", blueLine));
           add(new Station("Звёздная", blueLine));
        }};

        List<Station> greenLineStation = new ArrayList<Station>(){{
            add(new Station("Беговая", greenLine));
            add(new Station("Маяковская", greenLine));
        }};

        redLineStation.forEach((s) -> {
            testStationIndex.addStation(s);
            redLine.addStation(s);
        });

        blueLineStation.forEach((s) -> {
            testStationIndex.addStation(s);
            blueLine.addStation(s);
        });

        greenLineStation.forEach((s) -> {
            testStationIndex.addStation(s);
            greenLine.addStation(s);
        });

        testStationIndex.addConnection(new ArrayList<Station>() {{ //Переход с красной на голубую линию
            add(testStationIndex.getStation("Площадь Ленина"));
            add(testStationIndex.getStation("Парнас"));
        }});

        testStationIndex.addConnection(new ArrayList<Station>(){{ //Переход с голубой на зеленую линию
            add(testStationIndex.getStation("Звёздная"));
            add(testStationIndex.getStation("Беговая"));
        }});
    }

    public void testCalculateDurationWithoutConnection(){
        List<Station> testRoute = testRouteCalculator.getShortestRoute(testStationIndex.getStation("Девяткино"),
                testStationIndex.getStation("Автово"));
        double actual = RouteCalculator.calculateDuration(testRoute);
        double expected = 2 * 2.5;
        assertEquals(expected, actual);
    }

    public void testCalculateDurationWithOneConnection(){
        List<Station> testRoute = testRouteCalculator.getShortestRoute(testStationIndex.getStation("Девяткино"),
                testStationIndex.getStation("Звёздная"));
        double actual = RouteCalculator.calculateDuration(testRoute);
        double expected = 3 * 2.5 + 3.5;
        assertEquals(expected,actual);
    }

    public void testCalculateDurationWithTwoConnection(){
        List<Station> testRoute = testRouteCalculator.getShortestRoute(testStationIndex.getStation("Девяткино"),
                testStationIndex.getStation("Маяковская"));
        double actual = RouteCalculator.calculateDuration(testRoute);
        double expected = 4 * 2.5 + 2 * 3.5;
        assertEquals(expected,actual);
    }
    public void testShortestRouteWithoutConnection(){
        List<Station> expectedRoute = new ArrayList<Station>(){{
            add(testStationIndex.getStation("Девяткино"));
            add(testStationIndex.getStation("Площадь Ленина"));
            add(testStationIndex.getStation("Автово"));
        }};
        List<Station> actualRoute = testRouteCalculator.getShortestRoute(testStationIndex.getStation("Девяткино"),
                testStationIndex.getStation("Автово"));
        assertEquals(expectedRoute, actualRoute);
    }

    public void testShortestRouteWithOneConnection(){
        List<Station> expectedRoute = new ArrayList<Station>(){{
            add(testStationIndex.getStation("Девяткино"));
            add(testStationIndex.getStation("Площадь Ленина"));
            add(testStationIndex.getStation("Парнас"));
            add(testStationIndex.getStation("Сенная площадь"));
            add(testStationIndex.getStation("Звёздная"));
        }};
        List<Station> actualRoute = testRouteCalculator.getShortestRoute(testStationIndex.getStation("Девяткино"),
                testStationIndex.getStation("Звёздная"));
        assertEquals(expectedRoute, actualRoute);
    }

    public void testShortestRouteWithTwoConnection(){
        List<Station> expectedRoute = new ArrayList<Station>(){{
            add(testStationIndex.getStation("Девяткино"));
            add(testStationIndex.getStation("Площадь Ленина"));
            add(testStationIndex.getStation("Парнас"));
            add(testStationIndex.getStation("Сенная площадь"));
            add(testStationIndex.getStation("Звёздная"));
            add(testStationIndex.getStation("Беговая"));
            add(testStationIndex.getStation("Маяковская"));
        }};
        List<Station> actualRoute = testRouteCalculator.getShortestRoute(testStationIndex.getStation("Девяткино"),
                testStationIndex.getStation("Маяковская"));
        assertEquals(expectedRoute, actualRoute);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        testStationIndex = null;
        testRouteCalculator = null;
    }
}
