import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Номера
        ArrayList<String> list = new ArrayList<>();
        String[] chars = new String[]{"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 1; k < 199; k++) {
                    String currChar = chars[i];
                    String region = String.valueOf(k);
                    if (k < 10) {
                        region = "0" + region;
                    }
                    String number = String.format("%s%d%d%d%s%s%s", currChar,
                            j, j, j, currChar, currChar, region);
                    list.add(number);
                }
            }
        }
        list.forEach(System.out::println);

        HashSet<String> hashSet = new HashSet<>();
        hashSet.addAll(list);

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.addAll(list);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Найти номер:");
        String inputSearch = scanner.nextLine();

        while (true) {
            //1. Прямой перебор можно использовать list.contains()
            long start = System.nanoTime();
            long duration = System.nanoTime() - start;
            if (list.contains(inputSearch)) {
                System.out.println("Поиск перебором: номер найден, поиск занял " + duration);
            } else
                System.out.println("Поиск перебором: номер не найден, поиск занял " + duration);

            //2. Бинарный поиск с помощью Collections.binarySearch()
            long start2 = System.nanoTime();
            int binaryCount = Collections.binarySearch(list, inputSearch);
            long duration2 = System.nanoTime() - start2;
            if (binaryCount > 0) {
                System.out.println("Поиск бинарный: номер найден, поиск занял " + duration2);
            } else {
                System.out.println("Бинарный поиск: номер не найден, поиск занял " + duration2);
            }

            //3. HashSet
            long start3 = System.nanoTime();
            boolean hashCount = hashSet.contains(inputSearch);
            long duration3 = System.nanoTime() - start3;
            if (hashCount) {
                System.out.println("Поиск в HashSet: номер найден, поиск занял " + duration3);
            } else {
                System.out.println("Поиск в HashSet: номер не найден, поиск занял " + duration3);
            }

            //4. TreeSet
            long start4 = System.nanoTime();
            boolean treeCount = treeSet.contains(inputSearch);
            long duration4 = System.nanoTime() - start4;
            if (treeCount) {
                System.out.println("Поиск в TreeSet: номер найден, поиск занял " + duration4);
            } else {
                System.out.println("Поиск в TreeSet: номер не найден, поиск занял " + duration4);
            }
            return;
        }
    }
}
