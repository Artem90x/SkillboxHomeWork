import java.io.File;
import java.util.Scanner;

public class RulesPath {
    public static File inputPath() {

        String inputPath = new Scanner(System.in).nextLine().
                replace("\\", File.separator);
        return new File(inputPath);
    }

    public static File checkSourceDirectory(File sourceDirectory) {

        for (; ; ) {
            if (!sourceDirectory.isDirectory()) {
                System.out.println("Ошибка! Путь указан не верно.");
                sourceDirectory = inputPath();
            } else {
                return sourceDirectory;
            }
        }
    }

    public static File checkTargetDirectory(File targetDirectory) {

        for (; ; ) {
            if (targetDirectory.exists()) {
                System.out.println("Ошибка! Директория уже сушествует, введите другой путь:");
                targetDirectory = inputPath();
            } else {
                System.out.println("Копирование успешно выполнено!");
                return targetDirectory;
            }
        }
    }
}
