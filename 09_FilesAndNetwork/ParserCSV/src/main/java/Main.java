import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        int income = 0;
        double expense = 0;

        try {
            String movementList = "C:/Users/User/IdeaProjects/java_basics/" +
                    "09_FilesAndNetwork/ParserCSV/src/main/resources/movementList.csv";
            List<String> lines = Files.readAllLines(Paths.get(movementList));
            lines.remove(0);
            HashMap<String, Double> splitExpense = new HashMap<>();
            System.out.println("Суммы расходов по организациям:");

            for (String line : lines) {
                List<String> fragments = new ArrayList<>(Arrays.asList(line.split(",")));
                for (int i = 0; i < fragments.size(); i++) {
                    if ((fragments.get(i).trim().contains("\"")) && (fragments.get(i + 1).trim().contains("\""))) {

                        fragments.set(i, (fragments.get(i).trim().replace("\"", "") +
                                "." + fragments.get(i + 1).trim().replace("\"", "")));
                        fragments.remove(i + 1);
                    }
                }

                income += Integer.parseInt(fragments.get(6));
                expense += Double.parseDouble(fragments.get(7));

                if (Double.parseDouble(fragments.get(7)) != 0) {
                    String[] s = fragments.get(5).split("[/\\\\]");
                    String key = s[s.length - 1].substring(0, s[s.length - 1].indexOf("  "));
                    Double value = Double.parseDouble(fragments.get(7));

                    if (!splitExpense.containsKey(key)) {
                        splitExpense.put(key, value);
                    } else {
                        splitExpense.put(key, splitExpense.get(key) + value);
                    }
                }
            }

            for (Map.Entry<String, Double> entry : splitExpense.entrySet()) {
                System.out.print(entry.getKey() + "\t");
                System.out.printf("%.2f " + "руб.", entry.getValue());
                System.out.println("\t");
            }

            System.out.println("\nСумма доходов: " + income + " руб." + "\nСумма расходов: " + expense + " руб.");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
