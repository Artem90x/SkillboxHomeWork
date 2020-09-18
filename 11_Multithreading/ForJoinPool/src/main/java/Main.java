import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ForkJoinPool;

public class Main {

    private static final String URL = "https://skillbox.ru";
    private static final String PATH_TO_SAVE = "C:/Users/User/IdeaProjects/java_basics/11_Multithreading/" +
            "ForJoinPool/data/sitemap.txt";

    public static void main(String[] args) {
        ConcurrentSkipListSet<String> siteMap = new ConcurrentSkipListSet<>();
        System.out.printf("Создаем карту сайта: %s\n", URL);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(new ParserSiteMap(URL, URL, siteMap));
        Recording.writeToFile(PATH_TO_SAVE, siteMap);
        System.out.printf("Карта сайта создана: %s", PATH_TO_SAVE);
    }
}