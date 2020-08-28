import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int newWidth = 300;
    private static final int CORES = 2;
    private static final String srcFolder = "C:/Users/User/IdeaProjects/java_basics/" +
            "11_Multithreading/ImageResizer/data/src";
    private static final String dstFolder = "C:/Users/User/IdeaProjects/java_basics/" +
            "11_Multithreading/ImageResizer/data/dst";

    public static void main(String[] args) {

        File srcDir = new File(srcFolder);
        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();
        assert files != null;
        int middle = files.length / CORES;

        List<ImageResizer> imageResizers = new ArrayList<>();

        for (int i = 0; i < CORES; i++) {
            File[] threadFiles = new File[middle];
            System.arraycopy(files, middle * i, threadFiles, 0, threadFiles.length);
            imageResizers.add(i, new ImageResizer(threadFiles, newWidth, dstFolder, start));
            new Thread(imageResizers.get(i)).start();
        }
    }
}