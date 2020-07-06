import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            System.out.println("Введите путь директории, которую хотите скопировать:");
            File sourceDirectory = RulesPath.checkSourceDirectory(RulesPath.inputPath());

            System.out.println("Введите путь директории, в которую хотите скопировать:");
            File targetDirectory = RulesPath.checkTargetDirectory(RulesPath.inputPath());

            FileUtils.copyDirectory(sourceDirectory, targetDirectory);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}