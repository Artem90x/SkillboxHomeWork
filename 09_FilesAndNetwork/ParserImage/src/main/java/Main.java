import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {
    private static int fileName;
    private static final String PATH_TO_SAVE = "C:/Users/User/IdeaProjects/java_basics/" +
            "09_FilesAndNetwork/ParserImage/src/main/data/";

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://lenta.ru/").maxBodySize(0).get();
        Elements img= doc.select("img");

        img.stream()
                .map(element -> element.attr("src"))
                .forEach(Main::downloadImage);
    }

    private static void downloadImage(String link) {
        if (!link.contains("http")) {
            link = "https:" + link;
        }
        try (InputStream in = new URL(link).openStream()) {
            fileName++;

            if (link.contains("jpg")) {
                copyImagesFolder(in, fileName, ".jpg");
            } else if (link.contains("png")) {
                copyImagesFolder(in, fileName, ".png");
            } else {
                URLConnection connection = new URL(link).openConnection();
                String[] mimeTypeParts = connection.getContentType().split("/");
                String format = "." + mimeTypeParts[1];
                copyImagesFolder(in, fileName, format);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Загружено изображений: " + fileName);
    }

    private static void copyImagesFolder(InputStream in, int fileName, String fileFormat) throws IOException {
        Files.copy(in, Paths.get(PATH_TO_SAVE + fileName + fileFormat), StandardCopyOption.REPLACE_EXISTING);
    }
}