import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {
    public static void main(String[] args) {

        File folderName;
        try {
            for (; ; ) {
                System.out.println("Введите путь до папки:");
                BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
                String inputPath = inputReader.readLine().replace("\\", File.separator);
                folderName = new File(inputPath);
                if (folderName.isDirectory()) {
                    break;
                } else {
                    System.out.println("Путь указан не верно!");
                }
            }
            String folderSize = sizeConverter(getFoldersSize(folderName));
            System.out.println("Размер папки " + folderName + ":\t" + folderSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String sizeConverter(long originalSize) {

        final String[] typeUnits = {" byte", " Kb", " Mb", " Gb"};
        int unitIndex = 0;
        double tempSize = (double) originalSize / 1024;

        while (tempSize >= 1) {
            tempSize = tempSize / 1024;
            unitIndex++;
        }

        if (unitIndex == 0) {
            return originalSize + typeUnits[unitIndex];
        } else {
            return (Math.round(10 * originalSize / (Math.pow(1024, (unitIndex)))) / 10.0) + typeUnits[unitIndex];
        }
    }

    private static long getFoldersSize(File folder) {
        final long[] foldersSize = {0};
        try {
            Files.walkFileTree(folder.toPath(), new SimpleFileVisitor<>() {

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    foldersSize[0] += file.toFile().length();
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return foldersSize[0];
    }
}