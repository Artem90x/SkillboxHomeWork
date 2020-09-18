import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Stack;
import java.util.concurrent.ConcurrentSkipListSet;

public class Recording {

    public static void writeToFile(String fileName, ConcurrentSkipListSet<String> siteMap) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            PrintWriter printWriter = new PrintWriter(fileWriter);
            int tab = 1;
            String previousUrl = null;
            Iterator<String> urlIterator = siteMap.iterator();
            Stack<String> parents = new Stack<>();
            while (urlIterator.hasNext()) {
                String currentUrl = urlIterator.next();
                if (previousUrl != null) {
                    if (currentUrl.contains(previousUrl)) {
                        tab += 4;
                        parents.push(previousUrl);
                    } else {
                        while (!parents.isEmpty() && !currentUrl.contains(parents.peek())) {
                            parents.pop();
                            tab -= 4;
                        }
                    }
                }
                printWriter.printf("%" + tab + "s%s\n", "", currentUrl);
                previousUrl = currentUrl;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}