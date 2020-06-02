import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    private static String staffFile = "C:\\Users\\User\\IdeaProjects\\java_basics\\07_AdvancedOOPFeatures" +
            "\\LambdaExpressions\\data\\staff.txt";
    private static String dateFormat = "dd.MM.yyyy";

    public static void main(String[] args) throws ParseException {
        String beginningOfPeriod = "31.12.2016";
        String endOfPeriod = "01.01.2018";
        Date date1 = new SimpleDateFormat(dateFormat).parse(beginningOfPeriod);
        Date date2 = new SimpleDateFormat(dateFormat).parse(endOfPeriod);

        ArrayList<Employee> staff = loadStaffFromFile();
        staff.sort((o1, o2) -> {
            int result = o1.getSalary().compareTo(o2.getSalary());
            if (result != 0) {
                return result;
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        });
        staff.forEach(System.out::println);

        Stream<Employee> stream = staff.stream();
        stream.filter(e -> (e.getWorkStart().after(date1) & e.getWorkStart().before(date2)))
                .max(Comparator.comparing(Employee::getSalary))
                .ifPresent(e -> System.out.println("\nМаксимальная сумма зп в 2017 году: " + e.getSalary()));
    }

    private static ArrayList<Employee> loadStaffFromFile() {
        ArrayList<Employee> staff = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            for (String line : lines) {
                String[] fragments = line.split("\t");
                if (fragments.length != 3) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                staff.add(new Employee(
                        fragments[0],
                        Integer.parseInt(fragments[1]),
                        (new SimpleDateFormat(dateFormat)).parse(fragments[2])
                ));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return staff;
    }
}